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
				teamPO.getFieldGoal()*teamPO.getMatches(),
				teamPO.getFieldGoal(),
				teamPO.getFieldGoalAttempts()*teamPO.getMatches(),
				teamPO.getFieldGoalAttempts(),
				teamPO.getThreePointFieldGoal()*teamPO.getMatches(),
				teamPO.getThreePointFieldGoal(),
				teamPO.getThreePointFieldGoalAttempts()*teamPO.getMatches(),
				teamPO.getThreePointFieldGoalAttempts(),
				teamPO.getFreeThrow()*teamPO.getMatches(),
				teamPO.getFreeThrow(),
				teamPO.getFreeThrowAttempts()*teamPO.getMatches(),
				teamPO.getFreeThrowAttempts(),
				teamPO.getOffensiveRebound()*teamPO.getMatches(),
				teamPO.getOffensiveRebound(),
				teamPO.getDefensiveRebound()*teamPO.getMatches(),
				teamPO.getDefensiveRebound(),
				teamPO.getOpponentOffensiveRebound()*teamPO.getMatches(),
				teamPO.getOpponentOffensiveRebound(),
				teamPO.getOpponentDefensiveRebound()*teamPO.getMatches(),
				teamPO.getOpponentDefensiveRebound(),
				teamPO.getBackboard()*teamPO.getMatches(),
				teamPO.getBackboard(),
				teamPO.getAssist()*teamPO.getMatches(),
				teamPO.getAssist(),
				teamPO.getSteal()*teamPO.getMatches(),
				teamPO.getSteal(),
				teamPO.getBlock()*teamPO.getMatches(),
				teamPO.getBlock(),
				teamPO.getTurnOver()*teamPO.getMatches(),
				teamPO.getTurnOver(),
				teamPO.getFoul()*teamPO.getMatches(),
				teamPO.getFoul(),
				teamPO.getScoring()*teamPO.getMatches(),
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
