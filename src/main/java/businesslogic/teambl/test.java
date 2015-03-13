package businesslogic.teambl;

import java.rmi.dgc.Lease;
import java.util.ArrayList;

import vo.TeamVO;

public class test {
	public static void main(String[] args) {
		Rank rank = new Rank();
		ArrayList<TeamVO> vos = rank.Ranked("`east/west`='E'", "winningPercentage","ASC");
		
		for (int i = 0; i < vos.size(); i++) {
			System.out.println(vos.get(i).getTeamName());
		}
		
	}

}
