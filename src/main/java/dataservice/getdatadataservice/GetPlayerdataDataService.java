package dataservice.getdatadataservice;

import java.util.ArrayList;

import po.PlayerPO;
import po.PlayerinfoPO;

public interface GetPlayerdataDataService {

	public PlayerPO getPlayerdata(String playerName);
	
	public PlayerinfoPO getPlayerinfo(String playerName);
	
	public ArrayList<PlayerPO> getAllPlayerdata(String key,String order);
	
	public ArrayList<PlayerPO> getSomePlayerdata(String position,String partition,String key,String order);
	
	public ArrayList<PlayerPO> getByEfficiency(ArrayList<PlayerPO> po,String key,String order);
}
