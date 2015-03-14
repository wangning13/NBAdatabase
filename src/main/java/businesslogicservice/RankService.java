package businesslogicservice;

import java.util.ArrayList;

import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamVO;

public interface RankService {
	
	public ArrayList<TeamPO> Ranked(String condition, String key,String order);
	
	public TeaminfoPO getTeamInfo(String teamName);

}
