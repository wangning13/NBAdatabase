package businesslogic.playerbl;

import java.util.ArrayList;

import data.getdata.GetPlayerdata;
import dataservice.getdatadataservice.GetPlayerdataDataService;
import po.PlayerPO;
import vo.PlayerVO;

public class PlayerRank {
	ArrayList<PlayerPO> playerPOs;
	ArrayList<PlayerVO> playerVOs;
	ArrayList<PlayerVO> playerVOs2;
	String[] allPlayer = new String[15];
	public String[] getAllPlayer(String teamName){
		GetPlayerdataDataService g = new GetPlayerdata();
		allPlayer = g.   ;
		return allPlayer;
		
	}
	
	public PlayerPO getPlayerdata(String playerName){
		GetPlayerdataDataService g = new GetPlayerdata();
		PlayerPO playerPO = g.getPlayerdata(playerName);
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
		playerPO.setAssistPercentage(playerPO.getAssist()/(playerPO.getMinites()/(playerPO.getTeamMinutes()/5)*(playerPO.getTeamFieldGoal()+playerPO.getTeamFreeThrow()-playerPO.getFieldGoal()-playerPO.getFreeThrow())));
		playerPO.setStealPercentage(playerPO.getSteal()*(playerPO.getTeamMinutes()/5)/playerPO.getMinites()/playerPO.getOpponentOffensiveRebound());
		playerPO.setBlockPercentage(((double)playerPO.getBlock()*(playerPO.getTeamMinutes())/5)/playerPO.getMinites()/(playerPO.getOpponentFieldGoalAttempts()-playerPO.getOpponentThreePointFieldGoalAttempts()));
		playerPO.setTurnOverPercentage(playerPO.getTurnOver()/(playerPO.getFieldGoalAttempts()-playerPO.getThreePointFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()+playerPO.getTurnOver()));
		playerPO.setUsage((playerPO.getFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()+playerPO.getTurnOver())*(playerPO.getTeamMinutes()/5)/playerPO.getMinites()/(playerPO.getTeamFieldGoalAttempts()+0.44*playerPO.getTeamFreeThrowAttempts()+playerPO.getTeamTurnOver()));
		return playerPO;
	}
	
	

}
