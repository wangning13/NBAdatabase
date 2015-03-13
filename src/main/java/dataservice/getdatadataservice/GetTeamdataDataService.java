package dataservice.getdatadataservice;

import java.util.ArrayList;

import po.TeamPO;

public interface GetTeamdataDataService {

	public TeamPO getTeamdata(String teamName);
	
	public ArrayList<TeamPO> getAllTeamdata(String key,String order);
	
	public ArrayList<TeamPO> getSomeTeamdata(String condition,String key,String order);
	
	public ArrayList<TeamPO> getByEfficiency(ArrayList<TeamPO> po,String key,String order);
}
