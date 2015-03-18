package businesslogic.teambl;

import vo.TeaminfoVO;

public class testGetTeamInfo {
	public static void main(String[] args) {
		TeamRank teamRank = new TeamRank();
		TeaminfoVO teaminfoVO = teamRank.getTeamInfo("BOS");
		System.out.println(teaminfoVO.getName());
		System.out.println(teaminfoVO.getAbbr());
		System.out.println(teaminfoVO.getCity());
		System.out.println(teaminfoVO.getLeague());
		System.out.println(teaminfoVO.getPartition());
		System.out.println(teaminfoVO.getCourt());
		System.out.println(teaminfoVO.getYear());
	}

}
