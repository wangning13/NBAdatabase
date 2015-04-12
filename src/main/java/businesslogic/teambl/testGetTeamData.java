package businesslogic.teambl;

import java.util.ArrayList;

import vo.PlayerMatchVO;
import vo.TeamMatchVO;
import vo.TeamMonthMatchVO;
import vo.TeamVO;

public class testGetTeamData {
	public static void main(String[] args) {
		TeamRank teamRank = new TeamRank();
//		ArrayList<TeamVO> teamVOs = teamRank.getTeamData("13-14","`partition`='Atlantic'", "wins", "DESC");
//		for (int i = 0; i < teamVOs.size(); i++) {
//			System.out.println(teamVOs.get(i).getAssistEfficiency());
//		}
		
		ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = teamRank.getTeamMonthMatch("13-10", "LAL");
		for (int i = 0; i < teamMonthMatchVOs.size(); i++) {
			System.out.println(teamMonthMatchVOs.get(i).getDate());
			System.out.println(teamMonthMatchVOs.get(i).getHost());
			System.out.println(teamMonthMatchVOs.get(i).getGuest());
			System.out.println(teamMonthMatchVOs.get(i).getScore());
			System.out.println(teamMonthMatchVOs.get(i).getFirst());
			System.out.println(teamMonthMatchVOs.get(i).getSecond());
			System.out.println(teamMonthMatchVOs.get(i).getThird());
			System.out.println(teamMonthMatchVOs.get(i).getFourth());
		}
		
		
		
//		TeamMatchVO teamMatchVO = teamRank.getTeamMatch("13-10-29", "LAL");
//		System.out.println(teamMatchVO.getHostGuest());
//		System.out.println(teamMatchVO.getOpponent());
		
//		ArrayList<TeamMatchVO> teamMatchVOs = teamRank.getTeamRecentFiveMatch("LAL");
//		System.out.println(teamMatchVOs.size());
//		for (int i = 0; i < teamMatchVOs.size(); i++) {
//			System.out.println(teamMatchVOs.get(i).getOpponent());
//		}
		
	}

}
