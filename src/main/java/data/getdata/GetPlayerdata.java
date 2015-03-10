package data.getdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import data.initial.InitialDatabase;

public class GetPlayerdata {

	Statement statement;
	public GetPlayerdata() {
		try {
			Class.forName(InitialDatabase.driver);
			Connection conn = DriverManager.getConnection(InitialDatabase.url, InitialDatabase.user, InitialDatabase.password);
			statement = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
}
