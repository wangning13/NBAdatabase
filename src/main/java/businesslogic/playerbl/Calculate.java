package businesslogic.playerbl;

import java.text.DecimalFormat;

import po.PlayerPO;
import po.PlayerinfoPO;

public class Calculate {
	DecimalFormat df=new DecimalFormat("#.0000");
	public void Calculate(PlayerPO playerPO){
		
		if (playerPO.getFieldGoalAttempts()==0) {
			playerPO.setFieldGoalShotPercentage(0);
		}else {
			playerPO.setFieldGoalShotPercentage(Double.parseDouble(df.format((double)playerPO.getFieldGoal()/playerPO.getFieldGoalAttempts())));
		}
		if (playerPO.getThreePointFieldGoalAttempts()==0) {
			playerPO.setThreePointShotPercentage(0);
		}else {
			playerPO.setThreePointShotPercentage(Double.parseDouble(df.format(((double)playerPO.getThreePointFieldGoal())/playerPO.getThreePointFieldGoalAttempts())));

		}
		if (playerPO.getFreeThrowAttempts()==0) {
			playerPO.setFreeThrowPercentage(0);
		}else {
			playerPO.setFreeThrowPercentage(((double)playerPO.getFreeThrow())/playerPO.getFreeThrowAttempts());

		}
		playerPO.setEfficiency((playerPO.getScoring()+playerPO.getBackboard()+playerPO.getAssist()+playerPO.getSteal()+playerPO.getBlock())-(playerPO.getFreeThrowAttempts()-playerPO.getFreeThrow())-playerPO.getTurnOver());
		playerPO.setGmScEfficiency(playerPO.getScoring()+0.4*playerPO.getFieldGoal()-0.7*playerPO.getFieldGoalAttempts()-0.4*(playerPO.getFreeThrowAttempts()-playerPO.getFreeThrow())+0.7*playerPO.getOffensiveRebound()+0.3*playerPO.getDefensiveRebound()+playerPO.getSteal()+0.7*playerPO.getAssist()+0.7*playerPO.getBlock()-0.4*playerPO.getFoul()-playerPO.getTurnOver());
		if (playerPO.getPreviousAverageScoring()==0) {
			playerPO.setNearlyFivePercentage(0);
		}else {
			playerPO.setNearlyFivePercentage((playerPO.getNearlyFiveAverageScoring()-playerPO.getPreviousAverageScoring())/playerPO.getPreviousAverageScoring());

		}
		if ((2*(playerPO.getFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()))==0) {
			playerPO.setTrueShootingPercentage(0);
		}else {
			playerPO.setTrueShootingPercentage(Double.parseDouble(df.format(playerPO.getScoring()/(2*(playerPO.getFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts())))));
		}
		if (playerPO.getFieldGoalAttempts()==0) {
			playerPO.setShootingEfficiency(0);
		}else {
			playerPO.setShootingEfficiency(Double.parseDouble(df.format(((double)playerPO.getFieldGoal()+0.5*playerPO.getThreePointFieldGoal()/playerPO.getFieldGoalAttempts()))));
		}
		if (playerPO.getMinutes()==0) {
			playerPO.setBackboardPercentage(0);
			playerPO.setOffensiveReboundPercentage(0);
			playerPO.setDefensiveReboundPercentage(0);
			playerPO.setAssistPercentage(0);
			playerPO.setStealPercentage(0);
			playerPO.setBlockPercentage(0);
		}else {
			if (playerPO.getTeamBackboard()+playerPO.getOpponentBackBoard()==0) {
				playerPO.setBackboardPercentage(0);
			}
			else {
				playerPO.setBackboardPercentage(Double.parseDouble(df.format(playerPO.getBackboard()*(playerPO.getTeamMinutes()/5)/playerPO.getMinutes()/(playerPO.getTeamBackboard()+playerPO.getOpponentBackBoard()))));
			}
			if (playerPO.getTeamOffensiveRebound()+playerPO.getOpponentOffensiveRebound()==0) {
				playerPO.setOffensiveReboundPercentage(0);
			}else {
				playerPO.setOffensiveReboundPercentage(Double.parseDouble(df.format(playerPO.getOffensiveRebound()*(playerPO.getTeamMinutes()/5)/playerPO.getMinutes()/(playerPO.getTeamOffensiveRebound()+playerPO.getOpponentOffensiveRebound()))));
			}
			if (playerPO.getTeamDefensiveRebound()+playerPO.getOpponentDefensiveRebound()==0) {
				playerPO.setDefensiveReboundPercentage(0);
			}else {
				playerPO.setDefensiveReboundPercentage(Double.parseDouble(df.format(playerPO.getDefensiveRebound()*(playerPO.getTeamMinutes()/5)/playerPO.getMinutes()/(playerPO.getTeamDefensiveRebound()+playerPO.getOpponentDefensiveRebound()))));
			}
			if (playerPO.getMinutes()==0) {
				playerPO.setAssistPercentage(0);
			}else {
				playerPO.setAssistPercentage(Double.parseDouble(df.format(playerPO.getAssist()/(playerPO.getMinutes()/(playerPO.getTeamMinutes()/5)*(playerPO.getTeamFieldGoal()+playerPO.getTeamFreeThrow()-playerPO.getFieldGoal()-playerPO.getFreeThrow())))));
			}
			if (playerPO.getTeamMinutes()==0||playerPO.getOpponentOffensiveRebound()==0) {
				playerPO.setStealPercentage(0);
			}else {
				playerPO.setStealPercentage(Double.parseDouble(df.format(playerPO.getSteal()*(playerPO.getTeamMinutes()/5)/playerPO.getMinutes()/playerPO.getOpponentOffensiveRebound())));
			}
			if (playerPO.getTeamMinutes()==0||playerPO.getOpponentFieldGoalAttempts()-playerPO.getOpponentThreePointFieldGoalAttempts()==0) {
				playerPO.setBlockPercentage(0);
			}else {
				playerPO.setBlockPercentage(Double.parseDouble(df.format(((double)playerPO.getBlock()*(playerPO.getTeamMinutes())/5)/playerPO.getMinutes()/(playerPO.getOpponentFieldGoalAttempts()-playerPO.getOpponentThreePointFieldGoalAttempts()))));
			}
		}
		if ((playerPO.getFieldGoalAttempts()-playerPO.getThreePointFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()+playerPO.getTurnOver())==0) {
			playerPO.setTurnOverPercentage(0);
		}else {
			
			playerPO.setTurnOverPercentage(Double.parseDouble(df.format(playerPO.getTurnOver()/(playerPO.getFieldGoalAttempts()+playerPO.getThreePointFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()+playerPO.getTurnOver()))));

		}
		if (playerPO.getMinutes()==0||(playerPO.getTeamFieldGoalAttempts()+0.44*playerPO.getTeamFreeThrowAttempts()+playerPO.getTeamTurnOver())==0) {
			playerPO.setUsage(0);
			
		}else {
			playerPO.setUsage(Double.parseDouble(df.format((playerPO.getFieldGoalAttempts()+0.44*playerPO.getFreeThrowAttempts()+playerPO.getTurnOver())*(playerPO.getTeamMinutes()/5)/playerPO.getMinutes()/(playerPO.getTeamFieldGoalAttempts()+0.44*playerPO.getTeamFreeThrowAttempts()+playerPO.getTeamTurnOver()))));

		}
	}

}
