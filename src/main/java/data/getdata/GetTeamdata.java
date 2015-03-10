package data.getdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		int fieldGoal=0;//投篮命中数
		int fieldGoalAttempts=0;//投篮出手次数
		int threePointFieldGoal=0;//三分命中数
		int threePointFieldGoalAttempts=0;//三分出手数
		int freeThrow=0;//罚球命中数
		int freeThrowAttempts=0;//罚球出手数
		int offensiveRebound=0;//进攻篮板数
		int defensiveRebound=0;//防守篮板数
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TeamPO po=new TeamPO(teamName, matches, fieldGoal, fieldGoalAttempts, threePointFieldGoal, threePointFieldGoalAttempts, freeThrow, freeThrowAttempts, offensiveRebound, defensiveRebound, backboard, assist, steal, block, turnOver, foul, scoring);
		return po;
	}
	
	public String getAllTeamdata(){
		String r="";
		return r;
	}
}
