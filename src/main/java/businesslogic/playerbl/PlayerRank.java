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
import po.PlayerMatchPO;
import po.PlayerPO;
import po.PlayerinfoPO;
import vo.PlayerMatchVO;
import vo.PlayerVO;
import vo.PlayerinfoVO;

public class PlayerRank implements PlayerRankService{
	String rmi = "127.0.0.1";
	DecimalFormat df=new DecimalFormat("#.0000");
	
	String[] allPlayer;
	public ArrayList<String> getAllPlayer(String season,String teamName){
		ArrayList<String> teamPlayerList1;
		ArrayList<String> teamPlayerList2 = new ArrayList<String>();
		GetTeamdataDataService g;
		try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPlayerList1 = g.getTeamPlayer(season,teamName);
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
			playerPO = calculate.Calculate(playerPO);
			
			GetPlayerVO getPlayerVO = new GetPlayerVO();
			playerVO = getPlayerVO.getPlayerVO(playerPO);
			
			
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
				playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
				}
			ArrayList<PlayerPO> playerPOs2 = g.getByEfficiency(playerPOs, key, order);
			for (int i = 0; i < playerPOs2.size(); i++) {
				GetPlayerVO getPlayerVO = new GetPlayerVO();
				PlayerVO playerVO = getPlayerVO.getPlayerVO(playerPOs2.get(i));
				playerVOs.add(playerVO);
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
					playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
				}
				for (int i = 0; i < Math.min(50, playerPOs.size()); i++){
					GetPlayerVO getPlayerVO = new GetPlayerVO();
					PlayerVO playerVO = getPlayerVO.getPlayerVO(playerPOs.get(i));
					playerVOs.add(playerVO);
				}
			}else {
				playerPOs = g.getSomePlayerdata(season,position, partition, "scoring", "DESC");
				for (int i = 0; i < Math.min(50, playerPOs.size()); i++) {
					Calculate calculate = new Calculate();
					playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
				}
				
				ArrayList<PlayerPO> playerPOs2 = g.getByEfficiency(playerPOs, key, "DESC");
				for (int i = 0; i < Math.min(50, playerPOs2.size()); i++) {
					GetPlayerVO getPlayerVO = new GetPlayerVO();
					PlayerVO playerVO = getPlayerVO.getPlayerVO(playerPOs2.get(i));
					playerVOs.add(playerVO);
				
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
	
	//一场比赛一个球队所有球员数据
	public ArrayList<PlayerMatchVO> getPlayerMatchdata(String date,String team){
		ArrayList<PlayerMatchPO> playerMatchPOs = new ArrayList<PlayerMatchPO>();
		ArrayList<PlayerMatchVO> playerMatchVOs = new ArrayList<PlayerMatchVO>();
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerMatchPOs = g.getPlayerMatchdata(date, team);
			for (int i = 0; i < playerMatchPOs.size(); i++) {
				GetPlayerMatchVO getPlayerMatchVO = new GetPlayerMatchVO();
				PlayerMatchVO playerMatchVO = getPlayerMatchVO.getPlayerMatchVO(playerMatchPOs.get(i));
				playerMatchVOs.add(playerMatchVO);
				
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
		return playerMatchVOs;
	}
	
	
	public ArrayList<PlayerMatchVO> getPlayerMonthMatch(String month,String player){
		ArrayList<PlayerMatchPO> playerMatchPOs = new ArrayList<PlayerMatchPO>();
		ArrayList<PlayerMatchVO> playerMatchVOs = new ArrayList<PlayerMatchVO>();
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerMatchPOs = g.getPlayerMonthMatch(month, player);
//			System.out.println(playerMatchPOs.size());
			for (int i = 0; i < playerMatchPOs.size(); i++) {
				GetPlayerMatchVO getPlayerMatchVO = new GetPlayerMatchVO();
				PlayerMatchVO playerMatchVO = getPlayerMatchVO.getPlayerMatchVO(playerMatchPOs.get(i));
				playerMatchVOs.add(playerMatchVO);
				
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
		return playerMatchVOs;
		
	}
	
	public ArrayList<PlayerMatchVO> getPlayerRecentFiveMatch(String player){
		ArrayList<PlayerMatchPO> playerMatchPOs = new ArrayList<PlayerMatchPO>();
		ArrayList<PlayerMatchVO> playerMatchVOs = new ArrayList<PlayerMatchVO>();
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerMatchPOs = g.getPlayerRecentFiveMatch(player);
			for (int i = 0; i < playerMatchPOs.size(); i++) {
				GetPlayerMatchVO getPlayerMatchVO = new GetPlayerMatchVO();
				PlayerMatchVO playerMatchVO = getPlayerMatchVO.getPlayerMatchVO(playerMatchPOs.get(i));
				playerMatchVOs.add(playerMatchVO);
				
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
		return playerMatchVOs;
	}
	
	public ArrayList<PlayerMatchVO> getDayTop(String condition){
		ArrayList<PlayerMatchPO> playerMatchPOs = new ArrayList<PlayerMatchPO>();
		ArrayList<PlayerMatchVO> playerMatchVOs = new ArrayList<PlayerMatchVO>();
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerMatchPOs = g.getDayTop(condition);
			for (int i = 0; i < playerMatchPOs.size(); i++) {
				GetPlayerMatchVO getPlayerMatchVO = new GetPlayerMatchVO();
				PlayerMatchVO playerMatchVO = getPlayerMatchVO.getPlayerMatchVO(playerMatchPOs.get(i));
				playerMatchVOs.add(playerMatchVO);
				
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
		return playerMatchVOs;
	}
	
	
	//仅适用于场均
	public ArrayList<PlayerVO> getSeasonTop(String season,String condition){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		ArrayList<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerPOs = g.getAllPlayerdata(season, "backboard", "DESC");
			System.out.println(playerPOs.get(0).getTeamBackboard());
			System.out.println(playerPOs.get(0).getTeamMinutes());
			System.out.println(playerPOs.get(0).getOpponentBackBoard());
			System.out.println(playerPOs.get(0).getTeamFieldGoal());
			System.out.println(playerPOs.get(0).getOpponentFieldGoalAttempts());
			for (int i = 0; i < playerPOs.size(); i++) {
				Calculate calculate = new Calculate();
				playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
			playerPOs2 = g.getByEfficiency(playerPOs, condition, "DESC");
			for (int i = 0; i < 5; i++) {
				GetPlayerVO2 getPlayerVO2 = new GetPlayerVO2();
				PlayerVO playerVO = getPlayerVO2.getPlayerVO2(playerPOs2.get(i));
				playerVOs.add(playerVO);
				
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
	
	
	public ArrayList<PlayerVO> getMostImporvedPlayer(String season,String key){
		ArrayList<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerPOs = g.getAllPlayerdata(season, "backboard", "DESC");
			for (int i = 0; i < playerPOs.size(); i++) {
				Calculate calculate = new Calculate();
				playerPOs.set(i, calculate.Calculate(playerPOs.get(i)));
			}
			playerPOs2 = g.getByEfficiency(playerPOs, key, "DESC");
			for (int i = 0; i < 5; i++) {
				GetPlayerVO getPlayerVO = new GetPlayerVO();
				PlayerVO playerVO = getPlayerVO.getPlayerVO(playerPOs2.get(i));
				playerVOs.add(playerVO);
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
