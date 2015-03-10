package data.initial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialPlayerdata {
//初始化球员技术统计
	String info="";
	public InitialPlayerdata(Statement statement) {
		System.out.println("初始化球员技术统计……");
		ReadIn();
		String[] singleinfo=info.split("%");
		for (int i = 0; i < singleinfo.length; i++) {
			String[] temp=singleinfo[i].split(";");
			for (int j = 0; j < temp.length; j++) {
				if(temp[j].contains("'"))
					temp[j]=temp[j].substring(0, temp[j].indexOf("'"))+"\\"+temp[j].substring(temp[j].indexOf("'"), temp[j].length());
			}
			if(temp[19].charAt(0)<48||temp[19].charAt(0)>57)
				temp[19]="0";
			String sql="INSERT INTO playerdata  (`date`,team,playername,position,minites,fieldGoal,fieldGoalAttempts,`three-pointFieldGoal`,`three-pointFieldGoalAttempts`,freeThrow,freeThrowAttempts,offensiveRebound,defensiveRebound,backboard,assit,steal,block,turnOver,foul,scoring)  values('" 
					+ temp[0]
					+ "','"
					+ temp[1]
					+ "','"
					+ temp[2]
					+ "','"
					+ temp[3]
					+ "','"
					+ temp[4]
					+ "','"
					+ temp[5]
					+ "','"
					+ temp[6]
					+ "','"
					+ temp[7]
					+ "','"
					+ temp[8]
					+ "','"
					+ temp[9]
					+ "','"
					+ temp[10]
					+ "','"
					+ temp[11]
					+ "','"
					+ temp[12]
					+ "','"
					+ temp[13]
					+ "','"
					+ temp[14]
					+ "','"
					+ temp[15]
					+ "','"
					+ temp[16]
					+ "','"
					+ temp[17]
					+ "','"
					+ temp[18]
					+ "','"
					+ temp[19] + "')";
		try {
				statement.addBatch(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		}
		try {
			statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ReadIn(){
		File f=new File("data/matches");
		String[] filelist=f.list();
		for (int i = 0; i < filelist.length; i++) {
			String[] temp=filelist[i].split("_");
			String date=temp[1];
			String[] team=temp[2].split("-");
			try {
				FileReader fr=new FileReader("data/matches/"+filelist[i]);
				BufferedReader br=new BufferedReader(fr);
				String line="";
				int count=0;
				while((line=br.readLine())!=null){
					if(!line.contains(";")){
						count++;
						continue;
					}
					if(line.charAt(0)>=48&&line.charAt(0)<=57){
						continue;
					}else{
						if(count==1)
							info=info+date+";"+team[0]+";"+line.substring(0,line.length()-1)+"%";
						else
							info=info+date+";"+team[1]+";"+line.substring(0,line.length()-1)+"%";
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}