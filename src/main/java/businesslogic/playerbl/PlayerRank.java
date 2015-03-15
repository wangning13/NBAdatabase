package businesslogic.playerbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.getdatadataservice.GetPlayerdataDataService;
import dataservice.getdatadataservice.GetTeamdataDataService;
import po.PlayerPO;
import po.PlayerinfoPO;
import vo.PlayerVO;

public class PlayerRank {
	String rmi = "127.0.0.1";
	
	
	ArrayList<PlayerVO> playerVOs;
	String[] allPlayer = new String[15];
	public String[] getAllPlayer(String teamName){
		ArrayList<String> teamPlayerList;
		GetTeamdataDataService g;
		try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPlayerList = g.getTeamPlayer(teamName);
			for (int i = 0; i < 15; i++) {
				if (teamPlayerList.get(i)!=null) {
					allPlayer[i] = teamPlayerList.get(i);
				}else {
					allPlayer[i]= null; 
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
		
		return allPlayer;
		
	}
	
	public PlayerPO getPlayerdata(String playerName){
		GetPlayerdataDataService g ;
		PlayerPO playerPO = null;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerPO = g.getPlayerdata(playerName);
			playerPO.setThreePointShotPercentage(((double)playerPO.getThreePointFieldGoal())/playerPO.getThreePointFieldGoalAttempts());
			playerPO.setFreeThrowPercentage(((double)playerPO.getFreeThrow())/playerPO.getFreeThrowAttempts());
			playerPO.setEfficiency((playerPO.getScoring()+playerPO.getBackboard()+playerPO.getAssist()+playerPO.getSteal()+playerPO.getBlock())-(playerPO.getFreeThrowAttempts()-playerPO.getFreeThrow())-playerPO.getTurnOver());
			playerPO.setGmScEfficiency(playerPO.getScoring()+0.4*playerPO.getFieldGoal()-0.7*playerPO.getFieldGoalAttempts()-0.4*(playerPO.getFreeThrowAttempts()-playerPO.getFreeThrow())+0.7*playerPO.getOffensiveRebound()+0.3*playerPO.getDefensiveRebound()+playerPO.getSteal()+0.7*playerPO.getAssist()+0.7*playerPO.getBlock()-0.4*playerPO.getFoul()-playerPO.getTurnOver());
			playerPO.setNearlyFivePercentage((playerPO.getNearlyFiveAverageScoring()-playerPO.getPreviousAverageScoring())/playerPO.getPreviousAverageScoring());
			playerPO.setTrueShootingPercentage(playerPO.getScoring()/(2*(playerPO.getFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts())));
			playerPO.setShootingEfficiency(((double)playerPO.getFieldGoal()/playerPO.getFieldGoalAttempts()));
			playerPO.setBackboardPercentage(playerPO.getBackboard()*(playerPO.getTeamMinutes()/5)/playerPO.getMinites()/(playerPO.getTeamBackboard()+playerPO.getOpponentBackBoard()));
			playerPO.setOffensiveReboundPercentage(playerPO.getOffensiveRebound()*(playerPO.getTeamMinutes()/5)/playerPO.getMinites()/(playerPO.getTeamOffensiveRebound()+playerPO.getOpponentOffensiveRebound()));
			playerPO.setDefensiveReboundPercentage(playerPO.getDefensiveRebound()*(playerPO.getTeamMinutes()/5)/playerPO.getMinites()/(playerPO.getTeamDefensiveRebound()+playerPO.getOpponentDefensiveRebound()));
			playerPO.setAssistPercentage(playerPO.getAssist()/(playerPO.getMinites()/(playerPO.getTeamMinutes()/5)*(playerPO.getTeamFieldGoal()+playerPO.getTeamFreeThrow())-playerPO.getFieldGoal()-playerPO.getFreeThrow()));
			playerPO.setStealPercentage(playerPO.getSteal()*(playerPO.getTeamMinutes()/5)/playerPO.getMinites()/playerPO.getOpponentOffensiveRebound());
			playerPO.setBlockPercentage(((double)playerPO.getBlock()*(playerPO.getTeamMinutes())/5)/playerPO.getMinites()/(playerPO.getOpponentFieldGoalAttempts()-playerPO.getOpponentThreePointFieldGoalAttempts()));
			playerPO.setTurnOverPercentage(playerPO.getTurnOver()/(playerPO.getFieldGoalAttempts()-playerPO.getThreePointFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()+playerPO.getTurnOver()));
			playerPO.setUsage((playerPO.getFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()+playerPO.getTurnOver())*(playerPO.getTeamMinutes()/5)/playerPO.getMinites()/(playerPO.getTeamFieldGoalAttempts()+0.44*playerPO.getTeamFreeThrowAttempts()+playerPO.getTeamTurnOver()));
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
		
		return playerPO;
	}
	
	public PlayerinfoPO getPlayerinfo(String playerName){
		GetPlayerdataDataService g;
		PlayerinfoPO playerinfoPO = null;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerinfoPO = g.getPlayerinfo(playerName);
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
		return playerinfoPO;
	}
	
	public ArrayList<PlayerPO> getAllPlayerdata(String key,String order){
		ArrayList<PlayerPO> playerPOs = null;
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerPOs = g.getAllPlayerdata(key, order);
			for (int i = 0; i < playerPOs.size(); i++) {
				playerPOs.get(i).setThreePointShotPercentage(((double)playerPOs.get(i).getThreePointFieldGoal())/playerPOs.get(i).getThreePointFieldGoalAttempts());
				playerPOs.get(i).setFreeThrowPercentage(((double)playerPOs.get(i).getFreeThrow())/playerPOs.get(i).getFreeThrowAttempts());
				playerPOs.get(i).setEfficiency((playerPOs.get(i).getScoring()+playerPOs.get(i).getBackboard()+playerPOs.get(i).getAssist()+playerPOs.get(i).getSteal()+playerPOs.get(i).getBlock())-(playerPOs.get(i).getFreeThrowAttempts()-playerPOs.get(i).getFreeThrow())-playerPOs.get(i).getTurnOver());
				playerPOs.get(i).setGmScEfficiency(playerPOs.get(i).getScoring()+0.4*playerPOs.get(i).getFieldGoal()-0.7*playerPOs.get(i).getFieldGoalAttempts()-0.4*(playerPOs.get(i).getFreeThrowAttempts()-playerPOs.get(i).getFreeThrow())+0.7*playerPOs.get(i).getOffensiveRebound()+0.3*playerPOs.get(i).getDefensiveRebound()+playerPOs.get(i).getSteal()+0.7*playerPOs.get(i).getAssist()+0.7*playerPOs.get(i).getBlock()-0.4*playerPOs.get(i).getFoul()-playerPOs.get(i).getTurnOver());
				playerPOs.get(i).setNearlyFivePercentage((playerPOs.get(i).getNearlyFiveAverageScoring()-playerPOs.get(i).getPreviousAverageScoring())/playerPOs.get(i).getPreviousAverageScoring());
				playerPOs.get(i).setTrueShootingPercentage(playerPOs.get(i).getScoring()/(2*(playerPOs.get(i).getFieldGoalAttempts()+0.44*playerPOs.get(i).getFreeThrowAttempts())));
				playerPOs.get(i).setShootingEfficiency(((double)playerPOs.get(i).getFieldGoal()/playerPOs.get(i).getFieldGoalAttempts()));
				playerPOs.get(i).setBackboardPercentage(playerPOs.get(i).getBackboard()*(playerPOs.get(i).getTeamMinutes()/5)/playerPOs.get(i).getMinites()/(playerPOs.get(i).getTeamBackboard()+playerPOs.get(i).getOpponentBackBoard()));
				playerPOs.get(i).setOffensiveReboundPercentage(playerPOs.get(i).getOffensiveRebound()*(playerPOs.get(i).getTeamMinutes()/5)/playerPOs.get(i).getMinites()/(playerPOs.get(i).getTeamOffensiveRebound()+playerPOs.get(i).getOpponentOffensiveRebound()));
				playerPOs.get(i).setDefensiveReboundPercentage(playerPOs.get(i).getDefensiveRebound()*(playerPOs.get(i).getTeamMinutes()/5)/playerPOs.get(i).getMinites()/(playerPOs.get(i).getTeamDefensiveRebound()+playerPOs.get(i).getOpponentDefensiveRebound()));
				playerPOs.get(i).setAssistPercentage(playerPOs.get(i).getAssist()/(playerPOs.get(i).getMinites()/(playerPOs.get(i).getTeamMinutes()/5)*(playerPOs.get(i).getTeamFieldGoal()+playerPOs.get(i).getTeamFreeThrow()-playerPOs.get(i).getFieldGoal()-playerPOs.get(i).getFreeThrow())));
				playerPOs.get(i).setStealPercentage(playerPOs.get(i).getSteal()*(playerPOs.get(i).getTeamMinutes()/5)/playerPOs.get(i).getMinites()/playerPOs.get(i).getOpponentOffensiveRebound());
				playerPOs.get(i).setBlockPercentage(((double)playerPOs.get(i).getBlock()*(playerPOs.get(i).getTeamMinutes())/5)/playerPOs.get(i).getMinites()/(playerPOs.get(i).getOpponentFieldGoalAttempts()-playerPOs.get(i).getOpponentThreePointFieldGoalAttempts()));
				playerPOs.get(i).setTurnOverPercentage(playerPOs.get(i).getTurnOver()/(playerPOs.get(i).getFieldGoalAttempts()-playerPOs.get(i).getThreePointFieldGoalAttempts()+0.44*playerPOs.get(i).getFreeThrowAttempts()+playerPOs.get(i).getTurnOver()));
				playerPOs.get(i).setUsage((playerPOs.get(i).getFieldGoalAttempts()+0.44*playerPOs.get(i).getFreeThrowAttempts()+playerPOs.get(i).getTurnOver())*(playerPOs.get(i).getTeamMinutes()/5)/playerPOs.get(i).getMinites()/(playerPOs.get(i).getTeamFieldGoalAttempts()+0.44*playerPOs.get(i).getTeamFreeThrowAttempts()+playerPOs.get(i).getTeamTurnOver()));
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
		
		
		return playerPOs;
	}
	
	public ArrayList<PlayerVO> getByEfficiency(ArrayList<PlayerPO> po,String key,String order){
		ArrayList<PlayerPO> playerPOs2 = null;
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerPOs2 = g.getByEfficiency(getAllPlayerdata(key,order), key, order);
			for (int i = 0; i < playerPOs2.size(); i++) {
				PlayerVO playerVO = new PlayerVO(playerPOs2.get(i).getPlayerName(), playerPOs2.get(i).getTeam(), playerPOs2.get(i).getAppearance(),
						playerPOs2.get(i).getFirstPlay(), playerPOs2.get(i).getBackboard(),playerPOs2.get(i).getAssist(),playerPOs2.get(i).getMinites(),
						playerPOs2.get(i).getFieldGoal(), playerPOs2.get(i).getFieldGoalAttempts(), playerPOs2.get(i).getThreePointFieldGoal(),
						playerPOs2.get(i).getThreePointFieldGoalAttempts(), playerPOs2.get(i).getFreeThrow(),
						playerPOs2.get(i).getFreeThrowAttempts(), playerPOs2.get(i).getOffensiveRebound(), playerPOs2.get(i).getDefensiveRebound(),
						playerPOs2.get(i).getSteal(),playerPOs2.get(i).getBlock(),playerPOs2.get(i).getTurnOver(), playerPOs2.get(i).getFoul(),playerPOs2.get(i).getScoring(),
						playerPOs2.get(i).getTeamFieldGoal(),playerPOs2.get(i).getTeamBackboard(),playerPOs2.get(i).getTeamMinutes(),
						playerPOs2.get(i).getTeamFreeThrowAttempts(),playerPOs2.get(i).getTeamTurnOver(),playerPOs2.get(i).getOpponentBackBoard(),
						playerPOs2.get(i).getOpponentFieldGoalAttempts(),
						playerPOs2.get(i).getOpponentThreePointFieldGoalAttempts(),
						playerPOs2.get(i).getThreePointShotPercentage(),playerPOs2.get(i).getFreeThrowPercentage(),
						playerPOs2.get(i).getEfficiency(),playerPOs2.get(i).getGmScEfficiency(),
						playerPOs2.get(i).getNearlyFivePercentage(),playerPOs2.get(i).getTrueShootingPercentage(),
						playerPOs2.get(i).getShootingEfficiency(),playerPOs2.get(i).getBackboardPercentage(),
						playerPOs2.get(i).getOffensiveReboundPercentage(),
						playerPOs2.get(i).getDefensiveReboundPercentage(),playerPOs2.get(i).getAssistPercentage(),
						playerPOs2.get(i).getStealPercentage(), playerPOs2.get(i).getBlockPercentage(),
						playerPOs2.get(i).getTurnOverPercentage(), playerPOs2.get(i).getUsage(),
						playerPOs2.get(i).getPreviousAverageScoring(), playerPOs2.get(i).getNearlyFiveAverageScoring());
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
