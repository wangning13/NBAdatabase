package businesslogic.teambl;

import java.rmi.dgc.Lease;
import java.util.ArrayList;

import vo.TeamVO;

public class test {
	public static void main(String[] args) {
		TeamRank rank = new TeamRank();
		ArrayList<TeamVO> vos = rank.Ranked("`east/west`='E'", "winningPercentage","ASC");
		
		for (int i = 0; i < vos.size(); i++) {
			System.out.println(vos.get(i).getTeamName());
		}
		
	}

}
