package data.initial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InitialDatabase {
//进攻回合
	public static String driver = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://127.0.0.1:3306/nba";
	public static String user = "root";
	public static String password = "";
	public InitialDatabase() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed()){
				Statement statement = conn.createStatement();
				 conn.setAutoCommit(false);
				String sql="drop table matches";
				statement.execute(sql);
				sql="drop table playerdata";
				statement.execute(sql);
				sql="drop table playerinfo";
				statement.execute(sql);
				sql="CREATE TABLE matches (date varchar(255) not null, `host/guest` varchar(1) not null, name varchar(255) not null,opponent varchar(255) not null,`win/lose` varchar(1) not null, total int not null,first int not null,second int not null,third int not null,fourth int not null,primary key (date,name));";
				statement.execute(sql);
				sql="CREATE TABLE playerdata (`date`  varchar(255) not null,team varchar(255) not null,playername varchar(255) not null,position varchar(255),seconds int not null,fieldGoal int not null,fieldGoalAttempts int not null,`threepointFieldGoal` int not null,`threepointFieldGoalAttempts` int not null,freeThrow int not null,freeThrowAttempts int not null,offensiveRebound int not null,defensiveRebound int not null,backboard int not null,assit int not null,steal int not null,block int not null,turnOver int not null,foul int not null,scoring int,index(date,team,playername));";
				statement.execute(sql);
				sql="CREATE TABLE playerinfo (name varchar(255) not null,number varchar(255) not null,position varchar(255) not null,height varchar(255) not null,weight int not null,birth varchar(255) not null,age int not null,exp varchar(255) not null,school varchar(255) not null);";
				statement.execute(sql);
				conn.commit();  
				new InitialPlayerinfo(statement);
				conn.commit();  
				statement.clearBatch();
				new InitialMatches(statement); 
				conn.commit();  
				statement.clearBatch();
				new InitialPlayerdata(conn); 
				conn.close(); 
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
