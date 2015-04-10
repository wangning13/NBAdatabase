package businesslogic.teambl;

import java.util.ArrayList;

import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamMonthMatchVO;
import vo.TeamVO;
import vo.TeaminfoVO;

public class testRanking{
	public static void main(String[] args) {
		TeamRank teamRank = new TeamRank();
		ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = teamRank.getTeamMonthMatch("14-01", "SAS");
		System.out.println(teamMonthMatchVOs.size());
		for (int i = 0; i < teamMonthMatchVOs.size(); i++) {
			System.out.println(teamMonthMatchVOs.get(i).getHost());
			System.out.println(teamMonthMatchVOs.get(i).getGuest());
		}
		
	}
}