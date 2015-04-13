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
		
//		ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = teamRank.getTeamMonthMatch("13-10", "LAL");
//		for (int i = 0; i < teamMonthMatchVOs.size(); i++) {
//			System.out.println(teamMonthMatchVOs.get(i).getDate());
//			System.out.println(teamMonthMatchVOs.get(i).getHost());
//			System.out.println(teamMonthMatchVOs.get(i).getGuest());
//			System.out.println(teamMonthMatchVOs.get(i).getScore());
//			System.out.println(teamMonthMatchVOs.get(i).getFirst());
//			System.out.println(teamMonthMatchVOs.get(i).getSecond());
//			System.out.println(teamMonthMatchVOs.get(i).getThird());
//			System.out.println(teamMonthMatchVOs.get(i).getFourth());
//		}
		
		ArrayList<TeamVO> teamVOs = teamRank.getSeasonTop("13-14", "backboard");
		for (int i = 0; i < teamVOs.size(); i++) {
			System.out.println(teamVOs.get(i).getBackboard());
			System.out.println(teamVOs.get(i).getAssist());
			System.out.println(teamVOs.get(i).getAssistEfficiency());
			System.out.println(teamVOs.get(i).getOppenentScoring());
			System.out.println(teamVOs.get(i).getDefensiveEfficiency());
			System.out.println(teamVOs.get(i).getDefensivebackboardEfficiency());
		}
		
		
		
//		TeamMatchVO teamMatchVO = teamRank.getTeamMatch("13-10-29", "LAL");
//		System.out.println(teamMatchVO.getHostGuest());
//		System.out.println(teamMatchVO.getOpponent());
		
//		ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = teamRank.getTeamRecentFiveMatch("LAL");
//		System.out.println(teamMonthMatchVOs.size());
//		for (int i = 0; i < teamMonthMatchVOs.size(); i++) {
//			System.out.println(teamMonthMatchVOs.get(i).getDate());
//			System.out.println(teamMonthMatchVOs.get(i).getHost());
//			System.out.println(teamMonthMatchVOs.get(i).getGuest());
//			System.out.println(teamMonthMatchVOs.get(i).getScore());
//			System.out.println(teamMonthMatchVOs.get(i).getFirst());
//			System.out.println(teamMonthMatchVOs.get(i).getSecond());
//			System.out.println(teamMonthMatchVOs.get(i).getThird());
//			System.out.println(teamMonthMatchVOs.get(i).getFourth());
//		}
		
	}

}
