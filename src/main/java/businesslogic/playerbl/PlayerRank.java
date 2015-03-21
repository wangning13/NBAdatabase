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
	
	ArrayList<PlayerVO> playerVOs;
	String[] allPlayer;
	public ArrayList<String> getAllPlayer(String teamName){
		ArrayList<String> teamPlayerList1;
		ArrayList<String> teamPlayerList2 = new ArrayList<String>();
		GetTeamdataDataService g;
		try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPlayerList1 = g.getTeamPlayer(teamName);
			System.out.println(teamPlayerList1.size());
			for (int i = 0; i < teamPlayerList1.size(); i++) {
				if (!teamPlayerList1.get(i).equals(null)) {
					teamPlayerList2.add(teamPlayerList1.get(i));
				}
			}
			System.out.println(teamPlayerList2.size());
			
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
	
	public PlayerVO getPlayerdata(String playerName){
		GetPlayerdataDataService g ;
		PlayerPO playerPO = null;
		PlayerVO playerVO = null;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerPO = g.getPlayerdata(playerName);
			double th = ((double)playerPO.getThreePointFieldGoal())/playerPO.getThreePointFieldGoalAttempts();
			playerPO.setThreePointShotPercentage(Double.parseDouble(df.format(th)));
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
			playerVO = new PlayerVO(
					playerPO.getPlayerName(),
					playerPO.getTeam(), 
					playerPO.getAppearance(),
					playerPO.getFirstPlay(),
					playerPO.getBackboard(),
					Double.parseDouble(df.format(((double)playerPO.getBackboard())/playerPO.getAppearance())),
					playerPO.getAssist(),
					Double.parseDouble(df.format(((double)playerPO.getAssist()/playerPO.getAppearance()))),
					Double.parseDouble(df.format(playerPO.getMinites())),
					Double.parseDouble(df.format(((double)playerPO.getMinites()/playerPO.getAppearance()))),
					playerPO.getFieldGoal(),
					Double.parseDouble(df.format(((double)playerPO.getFieldGoal()/playerPO.getAppearance()))),
					playerPO.getFieldGoalAttempts(), 
					Double.parseDouble(df.format(((double)playerPO.getFieldGoalAttempts()/playerPO.getAppearance()))),
					playerPO.getThreePointFieldGoal(),
					Double.parseDouble(df.format(((double)playerPO.getThreePointFieldGoal()/playerPO.getAppearance()))),
					playerPO.getThreePointFieldGoalAttempts(),
					Double.parseDouble(df.format(((double)playerPO.getThreePointFieldGoalAttempts()/playerPO.getAppearance()))),
					playerPO.getFreeThrow(),
					Double.parseDouble(df.format(((double)playerPO.getFreeThrow()/playerPO.getAppearance()))),
					playerPO.getFreeThrowAttempts(), 
					Double.parseDouble(df.format(((double)playerPO.getFreeThrowAttempts()/playerPO.getAppearance()))),
					playerPO.getOffensiveRebound(), 
					Double.parseDouble(df.format(((double)playerPO.getOffensiveRebound()/playerPO.getAppearance()))),
					playerPO.getDefensiveRebound(),
					Double.parseDouble(df.format(((double)playerPO.getDefensiveRebound()/playerPO.getAppearance()))),
					playerPO.getSteal(),
					Double.parseDouble(df.format(((double)playerPO.getSteal()/playerPO.getAppearance()))),
					playerPO.getBlock(),
					Double.parseDouble(df.format(((double)playerPO.getBlock()/playerPO.getAppearance()))),
					playerPO.getTurnOver(), 
					Double.parseDouble(df.format(((double)playerPO.getTurnOver()/playerPO.getAppearance()))),
					playerPO.getFoul(),
					Double.parseDouble(df.format(((double)playerPO.getFoul()/playerPO.getAppearance()))),
					playerPO.getScoring(),
					Double.parseDouble(df.format(((double)playerPO.getScoring()/playerPO.getAppearance()))),
					playerPO.getTeamFieldGoalAttempts(),
					playerPO.getTeamBackboard(),
					playerPO.getTeamFieldGoal(),
					playerPO.getTeamFreeThrow(),
					playerPO.getTeamOffensiveRebound(),
					playerPO.getTeamDefensiveRebound(),
					Double.parseDouble(df.format(playerPO.getTeamMinutes())),
					playerPO.getTeamFreeThrowAttempts(),
					playerPO.getTeamTurnOver(),
					playerPO.getOpponentBackBoard(),
					playerPO.getOpponentOffensiveRebound(),
					playerPO.getOpponentDefensiveRebound(),
					playerPO.getOpponentFieldGoalAttempts(),
					playerPO.getOpponentThreePointFieldGoalAttempts(),
					Double.parseDouble(df.format(playerPO.getThreePointShotPercentage())),
					Double.parseDouble(df.format(playerPO.getFreeThrowPercentage())),
					Double.parseDouble(df.format(playerPO.getEfficiency())),
					Double.parseDouble(df.format(playerPO.getGmScEfficiency())),
					Double.parseDouble(df.format(playerPO.getNearlyFivePercentage())),
					Double.parseDouble(df.format(playerPO.getTrueShootingPercentage())),
					Double.parseDouble(df.format(playerPO.getShootingEfficiency())),
					Double.parseDouble(df.format(playerPO.getBackboardPercentage())),
					Double.parseDouble(df.format(playerPO.getOffensiveReboundPercentage())),
					Double.parseDouble(df.format(playerPO.getDefensiveReboundPercentage())),
					Double.parseDouble(df.format(playerPO.getAssistPercentage())),
					Double.parseDouble(df.format(playerPO.getStealPercentage())), 
					Double.parseDouble(df.format(playerPO.getBlockPercentage())),
					Double.parseDouble(df.format(playerPO.getTurnOverPercentage())), 
					Double.parseDouble(df.format(playerPO.getUsage())),
					Double.parseDouble(df.format(playerPO.getPreviousAverageScoring())),
					Double.parseDouble(df.format(playerPO.getNearlyFiveAverageScoring())),
					playerPO.getDoubleDouble()
					);
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
		PlayerinfoPO playerinfoPO = null;
		PlayerinfoVO playerinfoVO = null;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			playerinfoPO = g.getPlayerinfo(playerName);
			playerinfoVO = new PlayerinfoVO(playerinfoPO.getName(),
					playerinfoPO.getNumber(), 
					playerinfoPO.getPosition(), 
					playerinfoPO.getHeight(), 
					playerinfoPO.getWeight(), 
					playerinfoPO.getBirth(),
					playerinfoPO.getAge(), 
					playerinfoPO.getExp(), 
					playerinfoPO.getSchool());
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
	
	public ArrayList<PlayerVO> getAllPlayerdata(String key,String order){
		ArrayList<PlayerPO> playerPOs = new ArrayList<PlayerPO>();
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
			
			ArrayList<PlayerPO> playerPOs2 = g.getByEfficiency(playerPOs, key, order);
			for (int i = 0; i < playerPOs2.size(); i++) {
				PlayerVO playerVO = new PlayerVO(
						playerPOs2.get(i).getPlayerName(),
						playerPOs2.get(i).getTeam(), 
						playerPOs2.get(i).getAppearance(),
						playerPOs2.get(i).getFirstPlay(),
						playerPOs2.get(i).getBackboard(),
						Double.parseDouble(df.format(((double)playerPOs2.get(i).getBackboard())/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getAssist(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getAssist()/playerPOs2.get(i).getAppearance())),
						Double.parseDouble(df.format(playerPOs2.get(i).getMinites())),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getMinites()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getFieldGoal(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getFieldGoal()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getFieldGoalAttempts(), 
						Double.parseDouble(df.format((double)playerPOs2.get(i).getFieldGoalAttempts()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getThreePointFieldGoal(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getThreePointFieldGoal()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getThreePointFieldGoalAttempts(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getThreePointFieldGoalAttempts()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getFreeThrow(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getFreeThrow()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getFreeThrowAttempts(), 
						Double.parseDouble(df.format((double)playerPOs2.get(i).getFreeThrowAttempts()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getOffensiveRebound(), 
						Double.parseDouble(df.format((double)playerPOs2.get(i).getOffensiveRebound()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getDefensiveRebound(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getDefensiveRebound()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getSteal(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getSteal()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getBlock(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getBlock()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getTurnOver(), 
						Double.parseDouble(df.format((double)playerPOs2.get(i).getTurnOver()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getFoul(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getFoul()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getScoring(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getScoring()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getTeamFieldGoalAttempts(),
						playerPOs2.get(i).getTeamBackboard(),
						playerPOs2.get(i).getTeamFieldGoal(),
						playerPOs2.get(i).getTeamFreeThrow(),
						playerPOs2.get(i).getTeamOffensiveRebound(),
						playerPOs2.get(i).getTeamDefensiveRebound(),
						Double.parseDouble(df.format(playerPOs2.get(i).getTeamMinutes())),
						playerPOs2.get(i).getTeamFreeThrowAttempts(),
						playerPOs2.get(i).getTeamTurnOver(),
						playerPOs2.get(i).getOpponentBackBoard(),
						playerPOs2.get(i).getOpponentOffensiveRebound(),
						playerPOs2.get(i).getOpponentDefensiveRebound(),
						playerPOs2.get(i).getOpponentFieldGoalAttempts(),
						playerPOs2.get(i).getOpponentThreePointFieldGoalAttempts(),
						Double.parseDouble(df.format(playerPOs2.get(i).getThreePointShotPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getFreeThrowPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getEfficiency())),
						Double.parseDouble(df.format(playerPOs2.get(i).getGmScEfficiency())),
						Double.parseDouble(df.format(playerPOs2.get(i).getNearlyFivePercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getTrueShootingPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getShootingEfficiency())),
						Double.parseDouble(df.format(playerPOs2.get(i).getBackboardPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getOffensiveReboundPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getDefensiveReboundPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getAssistPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getStealPercentage())), 
						Double.parseDouble(df.format(playerPOs2.get(i).getBlockPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getTurnOverPercentage())), 
						Double.parseDouble(df.format(playerPOs2.get(i).getUsage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getPreviousAverageScoring())),
						Double.parseDouble(df.format(playerPOs2.get(i).getNearlyFiveAverageScoring())),
						playerPOs2.get(i).getDoubleDouble()
						);
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
	public ArrayList<PlayerVO> getFirstFifty(String position,String partition,String key){
		ArrayList<PlayerPO> playerPOs2 = new ArrayList<PlayerPO>();
		ArrayList<PlayerVO> playerVOs = new ArrayList<PlayerVO>();
		GetPlayerdataDataService g;
		try {
			g = (GetPlayerdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetPlayerdata");
			if (key.equals("weightAverage")) {
				playerPOs2 = g.getSomePlayerdata(position, partition, "wins", "DESC");
				for (int i = 0; i < playerPOs2.size()-1; i++) {
					for (int j = 0; j < playerPOs2.size()-i-1; j++) {
						if (playerPOs2.get(i).getScoring()+playerPOs2.get(i).getBackboard()+playerPOs2.get(i).getAssist() < playerPOs2.get(i+1).getScoring()+playerPOs2.get(i+1).getBackboard()+playerPOs2.get(i+1).getAssist()) {
							PlayerPO tempPlayerPO = playerPOs2.get(i);
							playerPOs2.set(i, playerPOs2.get(i+1));
							playerPOs2.set(i+1, tempPlayerPO);
						}
					}
				}
				
			}else {
				playerPOs2 = g.getSomePlayerdata(position, partition, key, "DESC");
			}
			for (int i = 0; i < 50; i++) {
				PlayerVO playerVO = new PlayerVO(
						playerPOs2.get(i).getPlayerName(),
						playerPOs2.get(i).getTeam(), 
						playerPOs2.get(i).getAppearance(),
						playerPOs2.get(i).getFirstPlay(),
						playerPOs2.get(i).getBackboard(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getBackboard()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getAssist(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getAssist()/playerPOs2.get(i).getAppearance())),
						Double.parseDouble(df.format(playerPOs2.get(i).getMinites())),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getMinites()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getFieldGoal(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getFieldGoal()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getFieldGoalAttempts(), 
						Double.parseDouble(df.format((double)playerPOs2.get(i).getFieldGoalAttempts()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getThreePointFieldGoal(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getThreePointFieldGoal()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getThreePointFieldGoalAttempts(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getThreePointFieldGoalAttempts()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getFreeThrow(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getFreeThrow()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getFreeThrowAttempts(), 
						Double.parseDouble(df.format((double)playerPOs2.get(i).getFreeThrowAttempts()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getOffensiveRebound(), 
						Double.parseDouble(df.format((double)playerPOs2.get(i).getOffensiveRebound()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getDefensiveRebound(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getDefensiveRebound()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getSteal(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getSteal()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getBlock(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getBlock()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getTurnOver(), 
						Double.parseDouble(df.format((double)playerPOs2.get(i).getTurnOver()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getFoul(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getFoul()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getScoring(),
						Double.parseDouble(df.format((double)playerPOs2.get(i).getScoring()/playerPOs2.get(i).getAppearance())),
						playerPOs2.get(i).getTeamFieldGoalAttempts(),
						playerPOs2.get(i).getTeamBackboard(),
						playerPOs2.get(i).getTeamFieldGoal(),
						playerPOs2.get(i).getTeamFreeThrow(),
						playerPOs2.get(i).getTeamOffensiveRebound(),
						playerPOs2.get(i).getTeamDefensiveRebound(),
						Double.parseDouble(df.format(playerPOs2.get(i).getTeamMinutes())),
						playerPOs2.get(i).getTeamFreeThrowAttempts(),
						playerPOs2.get(i).getTeamTurnOver(),
						playerPOs2.get(i).getOpponentBackBoard(),
						playerPOs2.get(i).getOpponentOffensiveRebound(),
						playerPOs2.get(i).getOpponentDefensiveRebound(),
						playerPOs2.get(i).getOpponentFieldGoalAttempts(),
						playerPOs2.get(i).getOpponentThreePointFieldGoalAttempts(),
						Double.parseDouble(df.format(playerPOs2.get(i).getThreePointShotPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getFreeThrowPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getEfficiency())),
						Double.parseDouble(df.format(playerPOs2.get(i).getGmScEfficiency())),
						Double.parseDouble(df.format(playerPOs2.get(i).getNearlyFivePercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getTrueShootingPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getShootingEfficiency())),
						Double.parseDouble(df.format(playerPOs2.get(i).getBackboardPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getOffensiveReboundPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getDefensiveReboundPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getAssistPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getStealPercentage())), 
						Double.parseDouble(df.format(playerPOs2.get(i).getBlockPercentage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getTurnOverPercentage())), 
						Double.parseDouble(df.format(playerPOs2.get(i).getUsage())),
						Double.parseDouble(df.format(playerPOs2.get(i).getPreviousAverageScoring())),
						Double.parseDouble(df.format(playerPOs2.get(i).getNearlyFiveAverageScoring())),
						playerPOs2.get(i).getDoubleDouble());
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
