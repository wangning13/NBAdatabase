package businesslogic.teambl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.dgc.Lease;
import java.util.ArrayList;

import po.TeamPO;
import dataservice.getdatadataservice.GetTeamdataDataService;
import vo.TeamVO;

public class testRanking{
	public static void main(String[] args) {
		TeamRank teamRank = new TeamRank();
		ArrayList<TeamPO> teamPOs = teamRank.Ranking("`east/west`='E'", "wins", "ASC");
		for (int i = 0; i < 1; i++) {
			System.out.println(teamPOs.get(i).getOpponentFieldGoal());
			System.out.println(teamPOs.get(i).getOpponentFieldGoalAttempts());
			System.out.println(teamPOs.get(i).getOpponentTurnOver());
			System.out.println(teamPOs.get(i).getOpponentFreeThrowAttempts());
			System.out.println(teamPOs.get(i).getOppenentScoring());
			System.out.println(teamPOs.get(i).getTeamName());
			System.out.println(teamPOs.get(i).getMatches());
			System.out.println(teamPOs.get(i).getWins());
			System.out.println(teamPOs.get(i).getFieldGoal());
			System.out.println(teamPOs.get(i).getFieldGoalAttempts());
			System.out.println(teamPOs.get(i).getThreePointFieldGoal());
			System.out.println(teamPOs.get(i).getThreePointFieldGoalAttempts());
			System.out.println(teamPOs.get(i).getFreeThrow());
			System.out.println(teamPOs.get(i).getFreeThrowAttempts());
			System.out.println(teamPOs.get(i).getOffensiveRebound());
			System.out.println(teamPOs.get(i).getDefensiveRebound());
			System.out.println(teamPOs.get(i).getOpponentOffensiveRebound());
			System.out.println(teamPOs.get(i).getOpponentDefensiveRebound());
			System.out.println(teamPOs.get(i).getBackboard());
			System.out.println(teamPOs.get(i).getAssist());
			System.out.println(teamPOs.get(i).getSteal());
			System.out.println(teamPOs.get(i).getBlock());
			System.out.println(teamPOs.get(i).getTurnOver());
			System.out.println(teamPOs.get(i).getFoul());
			System.out.println(teamPOs.get(i).getScoring());
			System.out.println("*--------------------------------------------------------------------------------*");
			
		}
		
	}
}
