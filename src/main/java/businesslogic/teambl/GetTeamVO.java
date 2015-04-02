package businesslogic.teambl;

import java.text.DecimalFormat;

import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamVO;

public class GetTeamVO {
	DecimalFormat df=new DecimalFormat("#.0000");
	public TeamVO GetTeamVO(TeamPO teamPO){
		TeamVO teamVO = new TeamVO(0,
				teamPO.getOpponentFieldGoal(),
				teamPO.getOpponentFieldGoalAttempts(),
				teamPO.getOpponentTurnOver(),
				teamPO.getOpponentFreeThrowAttempts(),
				teamPO.getOppenentScoring(),
				teamPO.getTeamName(),
				teamPO.getMatches(),
				teamPO.getWins(),
				teamPO.getFieldGoal(),
				Double.parseDouble(df.format(((double)teamPO.getFieldGoal())/teamPO.getMatches())),
				teamPO.getFieldGoalAttempts(),
				Double.parseDouble(df.format(((double)teamPO.getFieldGoalAttempts())/teamPO.getMatches())),
				teamPO.getThreePointFieldGoal(),
				Double.parseDouble(df.format(((double)teamPO.getThreePointFieldGoal())/teamPO.getMatches())),
				teamPO.getThreePointFieldGoalAttempts(),
				Double.parseDouble(df.format(((double)teamPO.getThreePointFieldGoalAttempts())/teamPO.getMatches())),
				teamPO.getFreeThrow(),
				Double.parseDouble(df.format(((double)teamPO.getFreeThrow())/teamPO.getMatches())),
				teamPO.getFreeThrowAttempts(),
				Double.parseDouble(df.format(((double)teamPO.getFreeThrowAttempts())/teamPO.getMatches())),
				teamPO.getOffensiveRebound(),
				Double.parseDouble(df.format(((double)teamPO.getOffensiveRebound())/teamPO.getMatches())),
				teamPO.getDefensiveRebound(),
				Double.parseDouble(df.format(((double)teamPO.getDefensiveRebound())/teamPO.getMatches())),
				teamPO.getOpponentOffensiveRebound(),
				Double.parseDouble(df.format(((double)teamPO.getOpponentOffensiveRebound())/teamPO.getMatches())),
				teamPO.getOpponentDefensiveRebound(),
				Double.parseDouble(df.format(((double)teamPO.getOpponentDefensiveRebound())/teamPO.getMatches())),
				teamPO.getBackboard(),
				Double.parseDouble(df.format(((double)teamPO.getBackboard())/teamPO.getMatches())),
				teamPO.getAssist(),
				Double.parseDouble(df.format(((double)teamPO.getAssist())/teamPO.getMatches())),
				teamPO.getSteal(),
				Double.parseDouble(df.format(((double)teamPO.getSteal())/teamPO.getMatches())),
				teamPO.getBlock(),
				Double.parseDouble(df.format(((double)teamPO.getBlock())/teamPO.getMatches())),
				teamPO.getTurnOver(),
				Double.parseDouble(df.format(((double)teamPO.getTurnOver())/teamPO.getMatches())),
				teamPO.getFoul(),
				Double.parseDouble(df.format(((double)teamPO.getFoul())/teamPO.getMatches())),
				teamPO.getScoring(),
				Double.parseDouble(df.format(((double)teamPO.getScoring())/teamPO.getMatches())),
				Double.parseDouble(df.format(teamPO.getFieldGoalPercentage())),
				Double.parseDouble(df.format(teamPO.getThreePointShotPercentage())),
				Double.parseDouble(df.format(teamPO.getFreeThrowPercentage())),
				Double.parseDouble(df.format(teamPO.getWinningPercentage())),
				Double.parseDouble(df.format(teamPO.getPossessions())),
				Double.parseDouble(df.format(teamPO.getOffensiveEfficiency())),
				Double.parseDouble(df.format(teamPO.getDefensiveEfficiency())),
				Double.parseDouble(df.format(teamPO.getOffensivebackboardEfficiency())),
				Double.parseDouble(df.format(teamPO.getDefensivebackboardEfficiency())),
				Double.parseDouble(df.format(teamPO.getStealEfficiency())),
				Double.parseDouble(df.format(teamPO.getAssitEfficiency())));
		return teamVO;
	}

}
