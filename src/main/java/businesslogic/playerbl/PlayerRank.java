package businesslogic.playerbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import businesslogicservice.playerblservice.PlayerRankService;
import dataservice.getdatadataservice.GetPlayerdataDataService;
import dataservice.getdatadataservice.GetTeamdataDataService;
import po.PlayerPO;
import po.PlayerinfoPO;
import vo.PlayerVO;
import vo.PlayerinfoVO;

public class PlayerRank implements PlayerRankService{
	String rmi = "127.0.0.1";
	DecimalFormat df=new DecimalFormat("#.0000");
	
	String[] allPlayer;
	public ArrayList<String> getAllPlayer(String teamName){
		ArrayList<String> teamPlayerList1;
		ArrayList<String> teamPlayerList2 = new ArrayList<String>();
		GetTeamdataDataService g;
		try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPlayerList1 = g.getTeamPlayer(teamName);
			for (int i = 0; i < teamPlayerList1.size(); i++) {
				if (!teamPlayerList1.get(i).equals(null)) {
					teamPlayerList2.add(teamPlayerList1.get(i));
				}
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teamPlayerList2;
		
	}
	
	public PlayerVO getPlayerdata(String season,String playerName){
		GetPlayerdataDataService g ;
		PlayerPO playerPO = new PlayerPO();
		PlayerVO playerVO = new PlayerVO() ;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerPO = g.getPlayerdata(season,playerName);
			Calculate calculate = new Calculate();
			calculate.Calculate(playerPO);
			
			GetPlayerVO getPlayerVO = new GetPlayerVO();
			getPlayerVO.getPlayerVO(playerPO, playerVO);
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return playerVO;
	}
	
	public PlayerinfoVO getPlayerinfo(String playerName){
		GetPlayerdataDataService g;
		PlayerinfoPO playerinfoPO = new PlayerinfoPO();
		PlayerinfoVO playerinfoVO = new PlayerinfoVO();
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerinfoPO = g.getPlayerinfo(playerName);
			if (playerinfoPO==null) {
				playerinfoVO = new PlayerinfoVO("",
						"", 
						"", 
						"", 
						0, 
						"",
						0, 
						"", 
						"");
			}else {
				playerinfoVO = new PlayerinfoVO(playerinfoPO.getName(),
						playerinfoPO.getNumber(), 
						playerinfoPO.getPosition(), 
						playerinfoPO.getHeight(), 
						playerinfoPO.getWeight(), 
						playerinfoPO.getBirth(),
						playerinfoPO.getAge(), 
						playerinfoPO.getExp(), 
						playerinfoPO.getSchool());
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return playerinfoVO;
	}
	
	public ArrayList<PlayerVO> getAllPlayerdata(String season,String key,String order){
		ArrayList<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerPOs = g.getAllPlayerdata(season,"backboard", order);
			for (int i = 0; i < playerPOs.size(); i++) {
				Calculate calculate = new Calculate();
				calculate.Calculate(playerPOs.get(i));
				    
					
				}
				
			
			ArrayList<PlayerPO> playerPOs2 = g.getByEfficiency(playerPOs, key, order);
			for (int i = 0; i < playerPOs2.size(); i++) {
				GetPlayerVO getPlayerVO = new GetPlayerVO();
				getPlayerVO.getPlayerVO(playerPOs2.get(i), playerVOs.get(i));
				
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return playerVOs;
	}
	
	//筛选前50名
	public ArrayList<PlayerVO> getFirstFifty(String season,String position,String partition,String key){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			if (key.equals("weightAverage")) {
				playerPOs = g.getSomePlayerdata(season,position, partition, "scoring", "DESC");
				for (int i = 0; i < playerPOs.size()-1; i++) {
					for (int j = 0; j < playerPOs.size()-i-1; j++) {
						if (playerPOs.get(j).getScoring()+playerPOs.get(j).getBackboard()+playerPOs.get(j).getAssist() < playerPOs.get(j+1).getScoring()+playerPOs.get(j+1).getBackboard()+playerPOs.get(j+1).getAssist()) {
							PlayerPO tempPlayerPO = playerPOs.get(j);
							playerPOs.set(j, playerPOs.get(j+1));
							playerPOs.set(j+1, tempPlayerPO);
						}
					}
				}
				for (int i = 0; i < Math.min(50, playerPOs.size()); i++) {
					Calculate calculate = new Calculate();
					calculate.Calculate(playerPOs.get(i));
				}
				for (int i = 0; i < Math.min(50, playerPOs.size()); i++){
					GetPlayerVO getPlayerVO = new GetPlayerVO();
					getPlayerVO.getPlayerVO(playerPOs.get(i), playerVOs.get(i));
				}
			}else {
				playerPOs = g.getSomePlayerdata(season,position, partition, "scoring", "DESC");
				for (int i = 0; i < Math.min(50, playerPOs.size()); i++) {
					Calculate calculate = new Calculate();
					calculate.Calculate(playerPOs.get(i));
				}
				
				ArrayList<PlayerPO> playerPOs2 = g.getByEfficiency(playerPOs, key, "DESC");
				for (int i = 0; i < Math.min(50, playerPOs2.size()); i++) {
					GetPlayerVO getPlayerVO = new GetPlayerVO();
					getPlayerVO.getPlayerVO(playerPOs2.get(i), playerVOs.get(i));
				
				}
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return playerVOs;
		
	}
	
}
