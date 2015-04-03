package businesslogicservice.teamblservice;

import java.util.ArrayList;

import vo.TeamMatchVO;
import vo.TeamMonthMatchVO;
import vo.TeamVO;
import vo.TeaminfoVO;

public interface TeamRankService {
	//根据分区联盟，属性条件，正序倒序返回球队数据的数组
	public ArrayList<TeamVO>  getTeamData(String season,String condition, String key,String order);
	
	//根据球队返回球队信息
	public TeaminfoVO getTeamInfo(String teamName);
	
	//根据球队返回球队数据
	public TeamVO getTeamData(String season,String teamName);
	
	//根据属性条件，正序倒序返回球队数据的数组
	public ArrayList<TeamVO> getAllTeamdata(String season,String key,String order);
	
	
	public ArrayList<TeamMonthMatchVO> getTeamMonthMatch(String month,String team);
	
	public TeamMatchVO getTeamMatch(String date,String team);
	
	public ArrayList<TeamMatchVO> getTeamRecentFiveMatch(String team);

}
