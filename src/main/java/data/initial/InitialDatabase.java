package data.initial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InitialDatabase {

	public InitialDatabase() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/nba";
		String user = "root";
		String password = "";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			 conn.setAutoCommit(false);
			if(!conn.isClosed()){
				System.out.println("Succeeded connecting to the Database!");
				Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				String sql="drop table matches";
				statement.execute(sql);
				sql="drop table playerdata";
				statement.execute(sql);
				sql="drop table playerinfo";
				statement.execute(sql);
				sql="CREATE TABLE matches (date varchar(255) not null, `h/g` varchar(1) not null, name varchar(255) not null, total int not null,first int not null,second int not null,third int not null,fourth int not null,primary key (date,name));";
				statement.execute(sql);
				sql="CREATE TABLE playerdata (`date`  varchar(255) not null,team varchar(255) not null,playername varchar(255) not null,position varchar(255),minites varchar(255) not null,fieldGoal int not null,fieldGoalAttempts int not null,`three-pointFieldGoal` int not null,`three-pointFieldGoalAttempts` int not null,freeThrow int not null,freeThrowAttempts int not null,offensiveRebound int not null,defensiveRebound int not null,backboard int not null,assit int not null,steal int not null,block int not null,turnOver int not null,foul int not null,scoring int,index(team,playername));";
				statement.execute(sql);
				sql="CREATE TABLE playerinfo (name varchar(255) not null,number varchar(255) not null,position varchar(255) not null,height varchar(255) not null,weight int not null,birth varchar(255) not null,age int not null,exp varchar(255) not null,school varchar(255) not null);";
				statement.execute(sql);
				new InitialPlayerinfo(statement);
				new InitialMatches(statement); 
				new InitialPlayerdata(statement);
				conn.commit();  
				conn.close(); 
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
