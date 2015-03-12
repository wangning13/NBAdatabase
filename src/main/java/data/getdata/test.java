package data.getdata;

import java.util.ArrayList;

import po.TeamPO;

public class test {
	public static void main(String[] args) {
		GetTeamdata g=new GetTeamdata();
		ArrayList<TeamPO> po=g.getSomeTeamdata("`east/west`='W'", "wins", "DESC");
		for (int i = 0; i < po.size(); i++) {
			System.out.println(po.get(i).getTeamName());
		}
	}
}
