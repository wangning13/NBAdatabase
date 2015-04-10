package businesslogic.teambl;

import java.util.ArrayList;

import po.TeamMatchPO;
import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamMatchVO;
import vo.TeamMonthMatchVO;
import vo.TeamVO;
import vo.TeaminfoVO;

public class testRanking{
	public static void main(String[] args) {
		TeamRank teamRank = new TeamRank();
		TeamMatchVO teamMatchVO = teamRank.getTeamMatch("13-10-29", "LAL");
		System.out.println(teamMatchVO.getOpponent());
		
		
	}
}