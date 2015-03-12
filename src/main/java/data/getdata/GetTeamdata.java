package data.getdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import po.TeamPO;
import data.initial.InitialDatabase;

public class GetTeamdata {

	Statement statement;
	public GetTeamdata() {
		try {
			Class.forName(InitialDatabase.driver);
			Connection conn = DriverManager.getConnection(InitialDatabase.url, InitialDatabase.user, InitialDatabase.password);
			statement = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public TeamPO getTeamdata(String teamName){
		int matches=0;//比赛场数
		int wins=0;//胜利场数
		int fieldGoal=0;//投篮命中数
		int fieldGoalAttempts=0;//投篮出手次数
		int threePointFieldGoal=0;//三分命中数
		int threePointFieldGoalAttempts=0;//三分出手数
		int freeThrow=0;//罚球命中数
		int freeThrowAttempts=0;//罚球出手数
		int offensiveRebound=0;//进攻篮板数
		int defensiveRebound=0;//防守篮板数
		int opponentOffensiveRebound=0;//对手进攻篮板数
		int opponentDefensiveRebound=0;//对手防守篮板数
		int backboard=0;//篮板数
		int assist=0;//助攻数
		int steal=0;//抢断数
		int block=0;//盖帽数
		int turnOver=0;//失误数
		int foul=0;//犯规数
		int scoring=0;//比赛得分
		try {
			ResultSet rs=statement.executeQuery(SqlStatement.countTeamMatches(teamName));
			while(rs.next())
			    matches=rs.getInt(1);
			rs=statement.executeQuery(SqlStatement.countTeamSum(teamName));
			while(rs.next()){
		        fieldGoal=rs.getInt(1);
		        fieldGoalAttempts=rs.getInt(2);
		        threePointFieldGoal=rs.getInt(3);
		        threePointFieldGoalAttempts=rs.getInt(4);
		        freeThrow=rs.getInt(5);
		        freeThrowAttempts=rs.getInt(6);
		        offensiveRebound=rs.getInt(7);
		        defensiveRebound=rs.getInt(8);
		        backboard=rs.getInt(9);
		        assist=rs.getInt(10);
		        steal=rs.getInt(11);
		        block=rs.getInt(12);
		        turnOver=rs.getInt(13);
		        foul=rs.getInt(14);
		        scoring=rs.getInt(15);
			}
			rs=statement.executeQuery(SqlStatement.countTeamWins(teamName));
			while(rs.next())
				wins=rs.getInt(1);
			ArrayList<String> date=new ArrayList<String>();
			ArrayList<String> opponent=new ArrayList<String>();
			rs=statement.executeQuery(SqlStatement.getTeamOpponent(teamName));
			while(rs.next()){
				date.add(rs.getString(1));
				opponent.add(rs.getString(2));
			}
			for (int i = 0; i < date.size(); i++) {
				rs=statement.executeQuery(SqlStatement.getTeamOpponentRebound(date.get(i), opponent.get(i)));
				int temp1=0;
				int temp2=0;
				while(rs.next()){
					temp1=rs.getInt(1);
					temp2=rs.getInt(2);
				}
				opponentOffensiveRebound=opponentOffensiveRebound+temp1;
				opponentDefensiveRebound=opponentDefensiveRebound+temp2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TeamPO po=new TeamPO(teamName, matches, wins, fieldGoal, fieldGoalAttempts, threePointFieldGoal, threePointFieldGoalAttempts, freeThrow, freeThrowAttempts, offensiveRebound, defensiveRebound, opponentOffensiveRebound, opponentDefensiveRebound, backboard, assist, steal, block, turnOver, foul, scoring);
		return po;
	}
	
	public ArrayList<TeamPO> getAllTeamdata(String key,String order){
		ArrayList<TeamPO> po=new ArrayList<TeamPO>();
		ArrayList<TeamPO> r=new ArrayList<TeamPO>();
		try {
			ResultSet rs=statement.executeQuery(SqlStatement.getTeamName());
			ArrayList<String> teamName=new ArrayList<String>();
			while(rs.next())
				teamName.add(rs.getString(1));
			for (int i = 0; i < teamName.size(); i++) {
				TeamPO temp=getTeamdata(teamName.get(i));
				po.add(temp);
			}
			r=getByOrder(po,key,order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	public ArrayList<TeamPO> getSomeTeamdata(String condition,String key,String order){
		ArrayList<TeamPO> po=new ArrayList<TeamPO>();
		ArrayList<TeamPO> r=new ArrayList<TeamPO>();
		ArrayList<String> team=new ArrayList<String>();
		String sql="SELECT * FROM teaminfo WHERE "+condition;
		try {
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next())
				team.add(rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < team.size(); i++) {
			TeamPO temp=getTeamdata(team.get(i));
			po.add(temp);
		}
		r=getByOrder(po, key, order);
		return r;
	}
	
	private ArrayList<TeamPO> getByOrder(ArrayList<TeamPO> po,String key,String order){
		ArrayList<TeamPO> r=new ArrayList<TeamPO>();
		String sql="CREATE TABLE temp (teamName varchar(255), matches int,wins int, fieldGoal int, fieldGoalAttempts int, threePointFieldGoal int, threePointFieldGoalAttempts int, freeThrow int, freeThrowAttempts int, offensiveRebound int, defensiveRebound int,	opponentOffensiveRebound int ,opponentDefensiveRebound int , backboard int, assist int, steal int, block int, turnOver int, foul int, scoring int)";
		try {
			statement.addBatch(sql);
			for (int i = 0; i < po.size(); i++) {
				TeamPO tt=po.get(i);
				sql="INSERT INTO temp values('"
						+ tt.getTeamName()
						+ "','"
						+ tt.getMatches()
						+ "','"
						+ tt.getWins()
						+ "','"
						+ tt.getFieldGoal()
						+ "','"
						+ tt.getFieldGoalAttempts()
						+ "','"
						+ tt.getThreePointFieldGoal()
						+ "','"
						+ tt.getThreePointFieldGoalAttempts()
						+ "','"
						+ tt.getFreeThrow()
						+ "','"
						+ tt.getFreeThrowAttempts()
						+ "','"
						+ tt.getOffensiveRebound()
						+ "','"
						+ tt.getDefensiveRebound()
						+ "','"
						+ tt.getOpponentOffensiveRebound()
						+ "','"
						+ tt.getOpponentDefensiveRebound()
						+ "','"
						+ tt.getBackboard()
						+ "','"
						+ tt.getAssist()
						+ "','"
						+ tt.getSteal()
						+ "','"
						+ tt.getBlock()
						+ "','"
						+ tt.getTurnOver()
						+ "','"
						+ tt.getFoul()
						+ "','"
						+ tt.getScoring() + "')";
				statement.addBatch(sql);
			}
			statement.executeBatch();
			sql="SELECT * FROM temp ORDER BY `"+key+"`"+order;
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()){
				TeamPO tt=new TeamPO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getInt(14), rs.getInt(15), rs.getInt(16), rs.getInt(17),rs.getInt(18), rs.getInt(19), rs.getInt(20));
				r.add(tt);
			}
			sql="DROP TABLE temp";
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
}
