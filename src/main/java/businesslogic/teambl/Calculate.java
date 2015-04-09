package businesslogic.teambl;

import java.text.DecimalFormat;

import po.TeamPO;
import po.TeaminfoPO;

public class Calculate {
	DecimalFormat df=new DecimalFormat("#.0000");
	public TeamPO Calculate(TeamPO teamPO){
		//胜率
		teamPO.setWinningPercentage(((double)teamPO.getWins())/teamPO.getMatches());
		
		//投篮命中率
		teamPO.setFieldGoalPercentage(((double)teamPO.getFieldGoal())/teamPO.getFieldGoalAttempts());
		//三分命中率
		teamPO.setThreePointShotPercentage(((double)teamPO.getThreePointFieldGoal())/teamPO.getThreePointFieldGoalAttempts());
		//罚球命中率
		teamPO.setFreeThrowPercentage(((double)teamPO.getFreeThrow())/teamPO.getFreeThrowAttempts());
		//进攻回合
		teamPO.setPossessions(teamPO.getFieldGoalAttempts() + 0.4*teamPO.getFreeThrowAttempts()
				- 1.07*(((double)teamPO.getOffensiveRebound()/
						(teamPO.getOffensiveRebound()+teamPO.getOpponentOffensiveRebound())
						*(teamPO.getFieldGoalAttempts()-teamPO.getFieldGoal()))) + 1.07*teamPO.getTurnOver());
		double possessions = teamPO.getPossessions();
		//进攻效率
		teamPO.setOffensiveEfficiency(((double)teamPO.getScoring())/possessions*100);
		//防守回合
		double opponentPossessions = teamPO.getOpponentFieldGoalAttempts() + 0.4*teamPO.getOpponentFreeThrowAttempts()
				- 1.07*(((double)teamPO.getOpponentOffensiveRebound()/
						(teamPO.getOffensiveRebound()+teamPO.getOpponentOffensiveRebound())
						*(teamPO.getOpponentFieldGoalAttempts()-teamPO.getOpponentFieldGoal()))) + 1.07*teamPO.getOpponentTurnOver();
		//防守效率
		teamPO.setDefensiveEfficiency(((double)teamPO.getOppenentScoring())/opponentPossessions*100);
		//进攻篮板效率
		teamPO.setOffensivebackboardEfficiency(((double)teamPO.getOffensiveRebound())/(teamPO.getOffensiveRebound()+teamPO.getOpponentDefensiveRebound()));
		//防守篮板效率
		teamPO.setDefensivebackboardEfficiency(((double)teamPO.getDefensiveRebound())/(teamPO.getDefensiveRebound()+teamPO.getOpponentOffensiveRebound()));
		//抢断效率
		teamPO.setStealEfficiency(((double)teamPO.getSteal())/opponentPossessions*100);
		//助攻效率
		teamPO.setAssistEfficiency(((double)teamPO.getAssist())/possessions*100);
		System.out.println("assitEfficiency:"+teamPO.getAssistEfficiency());
		return teamPO;
	}

}
