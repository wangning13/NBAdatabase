package businesslogicservice.teamblservice;

import java.util.ArrayList;

import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamVO;

public interface TeamRankService {
	//根据分区联盟，属性条件，正序倒序返回球员数据的数组
	public ArrayList<TeamVO>  getTeamPlayer(String condition, String key,String order);
	
	//根据球队返回球队信息
	public TeaminfoPO getTeamInfo(String teamName);
	
	//根据球队返回球队数据
	public TeamPO getTeamData(String teamName);
	
	//根据属性条件，正序倒序返回球员数据的数组
	public ArrayList<TeamPO> getAllTeamdata(String key,String order);

}
