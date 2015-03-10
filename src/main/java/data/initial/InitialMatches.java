package data.initial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialMatches {
//初始化比赛数据
	String info="";
	public InitialMatches(Statement statement) {
		System.out.println("初始化比赛数据……");
		ReadIn();
		String[] singleinfo=info.split("%");
		for (int i = 0; i < singleinfo.length; i++) {
			String[] singleline=singleinfo[i].split(":");
			for (int j = 0; j < singleline.length; j++) {
				String[] temp=singleline[j].split(";");
				String sql="INSERT INTO matches values('"
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
						+ temp[9] + "')";
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
	}
	
	public void ReadIn(){
		File f=new File("data/matches");
		String[] filelist=f.list();
		for (int i = 0; i < filelist.length; i++) {
			try {
				FileReader fr=new FileReader("data/matches/"+filelist[i]);
				BufferedReader br=new BufferedReader(fr);
				String line=br.readLine();
				String[] temp=line.split(";");
				info=info+temp[0]+";h;";
				String guest=":"+temp[0]+";g;";
				String[] temp1=temp[1].split("-");
				info=info+temp1[0]+";"+temp1[1]+";";
				guest=guest+temp1[1]+";"+temp1[0]+";";
				temp1=temp[2].split("-");
				if(Integer.parseInt(temp1[0])>Integer.parseInt(temp1[1])){
					info=info+"w;"+temp1[0]+";";
					guest=guest+"l;"+temp1[1]+";";
				}else{
					info=info+"l;"+temp1[0]+";";
					guest=guest+"w;"+temp1[1]+";";
				}
				line=br.readLine();
				temp=line.split(";");
				for (int j = 0; j < 4; j++) {
					temp1=temp[j].split("-");
					info=info+temp1[0]+";";
					guest=guest+temp1[1]+";";
				}
				info=info.substring(0, info.length()-1)+guest;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			info=info.substring(0, info.length()-1)+"%";
		}
	}
}
