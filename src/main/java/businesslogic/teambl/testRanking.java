package businesslogic.teambl;

import java.util.ArrayList;

import vo.TeamVO;

public class testRanking{
	public static void main(String[] args) {
		TeamRank teamRank = new TeamRank();
		ArrayList<TeamVO> teamVOs = teamRank.getTeamData("`east/west`='E'", "wins", "ASC");
		for (int i = 0; i < teamVOs.size(); i++) {
			System.out.println(teamVOs.get(i).getRank());
			System.out.println(teamVOs.get(i).getOpponentFieldGoal());
			System.out.println(teamVOs.get(i).getOpponentFieldGoalAttempts());
			System.out.println(teamVOs.get(i).getOpponentTurnOver());
			System.out.println(teamVOs.get(i).getOpponentFreeThrowAttempts());
			System.out.println(teamVOs.get(i).getOppenentScoring());
			System.out.println(teamVOs.get(i).getTeamName());
			System.out.println(teamVOs.get(i).getMatches());
			System.out.println(teamVOs.get(i).getWins());
			System.out.println(teamVOs.get(i).getFieldGoal());
			System.out.println(teamVOs.get(i).getFieldGoalAttempts());
			System.out.println(teamVOs.get(i).getThreePointFieldGoal());
			System.out.println(teamVOs.get(i).getThreePointFieldGoalAttempts());
			System.out.println(teamVOs.get(i).getFreeThrow());
			System.out.println(teamVOs.get(i).getFreeThrowAttempts());
			System.out.println(teamVOs.get(i).getOffensiveRebound());
			System.out.println(teamVOs.get(i).getDefensiveRebound());
			System.out.println(teamVOs.get(i).getOpponentOffensiveRebound());
			System.out.println(teamVOs.get(i).getOpponentDefensiveRebound());
			System.out.println(teamVOs.get(i).getBackboard());
			System.out.println(teamVOs.get(i).getAssist());
			System.out.println(teamVOs.get(i).getSteal());
			System.out.println(teamVOs.get(i).getBlock());
			System.out.println(teamVOs.get(i).getTurnOver());
			System.out.println(teamVOs.get(i).getFoul());
			System.out.println(teamVOs.get(i).getScoring());
			System.out.println("*--------------------------------------------------------------------------------*");
			
		}
		
	}
}