package businesslogic.teambl;

import java.text.DecimalFormat;

import po.TeamPO;
import vo.TeamVO;

public class GetTeamVO2 {
	DecimalFormat df=new DecimalFormat("#.0000");
	public TeamVO GetTeamVO2(TeamPO teamPO){
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
				teamPO.getFieldGoal(),
				teamPO.getFieldGoalAttempts(),
				teamPO.getFieldGoalAttempts(),
				teamPO.getThreePointFieldGoal(),
				teamPO.getThreePointFieldGoal(),
				teamPO.getThreePointFieldGoalAttempts(),
				teamPO.getThreePointFieldGoalAttempts(),
				teamPO.getFreeThrow(),
				teamPO.getFreeThrow(),
				teamPO.getFreeThrowAttempts(),
				teamPO.getFreeThrowAttempts(),
				teamPO.getOffensiveRebound(),
				teamPO.getOffensiveRebound(),
				teamPO.getDefensiveRebound(),
				teamPO.getDefensiveRebound(),
				teamPO.getOpponentOffensiveRebound(),
				teamPO.getOpponentOffensiveRebound(),
				teamPO.getOpponentDefensiveRebound(),
				teamPO.getOpponentDefensiveRebound(),
				teamPO.getBackboard(),
				teamPO.getBackboard(),
				teamPO.getAssist(),
				teamPO.getAssist(),
				teamPO.getSteal(),
				teamPO.getSteal(),
				teamPO.getBlock(),
				teamPO.getBlock(),
				teamPO.getTurnOver(),
				teamPO.getTurnOver(),
				teamPO.getFoul(),
				teamPO.getFoul(),
				teamPO.getScoring(),
				teamPO.getScoring(),
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
				Double.parseDouble(df.format(teamPO.getAssistEfficiency())));
		return teamVO;
	}

}
