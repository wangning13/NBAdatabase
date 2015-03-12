package businesslogic.teambl;

import java.util.ArrayList;

import data.getdata.GetTeamdata;
import po.TeamPO;
import vo.TeamVO;

public class RankByLeague {
	ArrayList<TeamPO> teamPOs;
	ArrayList<TeamVO> teamVOs;
	
	int rank = 0;//排名
	double fieldGoalPercentage = 0.0;//投篮命中率
	double threePointShotPercentage = 0.0;//三分命中率
	double freeThrowPercentage = 0.0;//三分命中率
	double winningPercentage = 0.0;//胜率
	double possessions = 0.0;//进攻回合
	double offensiveEfficiency = 0.0;//进攻效率
	double defensiveEfficiency = 0.0;//防守效率
	double backboardEfficiency = 0.0;//篮板效率
	double stealEfficiency = 0.0;//抢断效率
	double assitEfficiency = 0.0;//助攻效率
	
	public void  RankByLeague(League league) {
		GetTeamdata g=new GetTeamdata();
		if (league.equals(League.EAST)) {
			teamPOs = g.getSomeTeamdata("`east/west`='E'", "wins", "DESC");
			for (int i = 0; i < teamPOs.size(); i++) {
				winningPercentage = ((double)teamPOs.get(i).getWins())/teamPOs.get(i).getMatches();
				rank = i;
				fieldGoalPercentage = ((double)teamPOs.get(i).getFieldGoal())/teamPOs.get(i).getFieldGoalAttempts();
				threePointShotPercentage = ((double)teamPOs.get(i).getThreePointFieldGoal())/teamPOs.get(i).getThreePointFieldGoalAttempts();
				possessions = teamPOs.get(i).getFieldGoalAttempts() + 0.4*teamPOs.get(i).getFreeThrowAttempts()
						- 1.07*(((double)teamPOs.get(i).getOffensiveRebound()/
								(teamPOs.get(i).getOffensiveRebound()+teamPOs.get(i).getOpponentOffensiveRebound())
								*(teamPOs.get(i).getFieldGoalAttempts()-teamPOs.get(i).getFieldGoal()))) + 1.07*teamPOs.get(i).getTurnOver();
				
				
				
			}
			
			
		}else {
			teamPOs = g.getSomeTeamdata("`east/west`='W'", "wins", "DESC");
			for (int i = 0; i < teamPOs.size(); i++) {
				winningPercentage = ((double)teamPOs.get(i).getWins())/teamPOs.get(i).getMatches();
				
			}
			
			
		}
		
		
	}

}
