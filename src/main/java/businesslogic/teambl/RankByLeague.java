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
				//胜率
				winningPercentage = ((double)teamPOs.get(i).getWins())/teamPOs.get(i).getMatches();
				//排名
				rank = i;
				//投篮命中率
				fieldGoalPercentage = ((double)teamPOs.get(i).getFieldGoal())/teamPOs.get(i).getFieldGoalAttempts();
				//三分命中率
				threePointShotPercentage = ((double)teamPOs.get(i).getThreePointFieldGoal())/teamPOs.get(i).getThreePointFieldGoalAttempts();
				//进攻回合
				possessions = teamPOs.get(i).getFieldGoalAttempts() + 0.4*teamPOs.get(i).getFreeThrowAttempts()
						- 1.07*(((double)teamPOs.get(i).getOffensiveRebound()/
								(teamPOs.get(i).getOffensiveRebound()+teamPOs.get(i).getOpponentOffensiveRebound())
								*(teamPOs.get(i).getFieldGoalAttempts()-teamPOs.get(i).getFieldGoal()))) + 1.07*teamPOs.get(i).getTurnOver();
				//进攻效率
				offensiveEfficiency = ((double)teamPOs.get(i).getScoring())/possessions*100;
				//防守回合
				double opponentPossessions = teamPOs.get(i).getOpponentFieldGoalAttempts() + 0.4*teamPOs.get(i).getOpponentFreeThrowAttempts()
						- 1.07*(((double)teamPOs.get(i).getOpponentOffensiveRebound()/
								(teamPOs.get(i).getOffensiveRebound()+teamPOs.get(i).getOpponentOffensiveRebound())
								*(teamPOs.get(i).getOpponentFieldGoalAttempts()-teamPOs.get(i).getOpponentFieldGoal()))) + 1.07*teamPOs.get(i).getOpponentTurnOver();
				//防守效率
				defensiveEfficiency = ((double)teamPOs.get(i).getScoring())/teamPOs.get(i).getMatches()*100;
				
				
				
			}
			
			
		}else {
			teamPOs = g.getSomeTeamdata("`east/west`='W'", "wins", "DESC");
			for (int i = 0; i < teamPOs.size(); i++) {
				winningPercentage = ((double)teamPOs.get(i).getWins())/teamPOs.get(i).getMatches();
				
			}
			
			
		}
		
		
	}

}
