package businesslogic.teambl;

import java.util.ArrayList;

import vo.TeamVO;

public class testGetTeamData {
	public static void main(String[] args) {
		TeamRank teamRank = new TeamRank();
		ArrayList<TeamVO> teamVOs = teamRank.getTeamData("13-14","`partition`='Atlantic'", "wins", "DESC");
		for (int i = 0; i < teamVOs.size(); i++) {
			System.out.println(teamVOs.get(i).getAssistEfficiency());
		}
		
	}

}
