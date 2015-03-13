package dataservice.getdatadataservice;

import java.util.ArrayList;

import po.PlayerPO;

public interface GetPlayerdataDataService {

	public PlayerPO getPlayerdata(String playerName);
	
	public ArrayList<PlayerPO> getAllPlayerdata(String key,String order);
	
	public ArrayList<PlayerPO> getSomePlayerdata(String position,String partition,String key,String order);
}
