package businesslogic.teambl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamVO;
import businesslogicservice.teamblservice.TeamRankService;
import dataservice.getdatadataservice.GetTeamdataDataService;

public class TeamRank implements TeamRankService{
	String rmi = "127.0.0.1";
	
	
	ArrayList<TeamVO> teamVOs;
	
	private ArrayList<TeamPO> Ranking(String condition, String key,String order) {
		ArrayList<TeamPO> teamPOs = null;
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPOs = g.getSomeTeamdata(condition, key, order);
			for (int i = 0; i < teamPOs.size(); i++) {
				//胜率
				teamPOs.get(i).setWinningPercentage(((double)teamPOs.get(i).getWins())/teamPOs.get(i).getMatches());
				//投篮命中率
				teamPOs.get(i).setFieldGoalPercentage(((double)teamPOs.get(i).getFieldGoal())/teamPOs.get(i).getFieldGoalAttempts());
				//三分命中率
				teamPOs.get(i).setThreePointShotPercentage(((double)teamPOs.get(i).getThreePointFieldGoal())/teamPOs.get(i).getThreePointFieldGoalAttempts());
				//进攻回合
				teamPOs.get(i).setPossessions(teamPOs.get(i).getFieldGoalAttempts() + 0.4*teamPOs.get(i).getFreeThrowAttempts()
						- 1.07*(((double)teamPOs.get(i).getOffensiveRebound()/
								(teamPOs.get(i).getOffensiveRebound()+teamPOs.get(i).getOpponentOffensiveRebound())
								*(teamPOs.get(i).getFieldGoalAttempts()-teamPOs.get(i).getFieldGoal()))) + 1.07*teamPOs.get(i).getTurnOver());
				double possessions = teamPOs.get(i).getPossessions();
				//进攻效率
				teamPOs.get(i).setOffensiveEfficiency(((double)teamPOs.get(i).getScoring())/possessions*100);
				//防守回合
				double opponentPossessions = teamPOs.get(i).getOpponentFieldGoalAttempts() + 0.4*teamPOs.get(i).getOpponentFreeThrowAttempts()
						- 1.07*(((double)teamPOs.get(i).getOpponentOffensiveRebound()/
								(teamPOs.get(i).getOffensiveRebound()+teamPOs.get(i).getOpponentOffensiveRebound())
								*(teamPOs.get(i).getOpponentFieldGoalAttempts()-teamPOs.get(i).getOpponentFieldGoal()))) + 1.07*teamPOs.get(i).getOpponentTurnOver();
				//防守效率
				teamPOs.get(i).setDefensiveEfficiency(((double)teamPOs.get(i).getOppenentScoring())/opponentPossessions*100);
				//进攻篮板效率
				teamPOs.get(i).setOffensivebackboardEfficiency(((double)teamPOs.get(i).getOffensiveRebound())/(teamPOs.get(i).getOffensiveRebound()+teamPOs.get(i).getOpponentDefensiveRebound()));
				//防守篮板效率
				teamPOs.get(i).setDefensivebackboardEfficiency(((double)teamPOs.get(i).getDefensiveRebound())/(teamPOs.get(i).getDefensiveRebound()+teamPOs.get(i).getOpponentOffensiveRebound()));
				//抢断效率
				teamPOs.get(i).setStealEfficiency(((double)teamPOs.get(i).getSteal())/opponentPossessions*100);
				//助攻效率
				teamPOs.get(i).setAssitEfficiency(((double)teamPOs.get(i).getAssist())/possessions*100);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teamPOs;
	}
	
    private ArrayList<TeamVO>  gettingTeamData(String condition, String key,String order) {
    	ArrayList<TeamPO> teamPOs2 = null;
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPOs2 = g.getByEfficiency(Ranking(condition, key,order), key, order);
			for (int i = 0; i < teamPOs2.size(); i++) {
				TeamVO teamVO = new TeamVO(0, teamPOs2.get(i).getFieldGoalPercentage(),
						teamPOs2.get(i).getThreePointShotPercentage(), teamPOs2.get(i).getFreeThrowPercentage(),
						teamPOs2.get(i).getWinningPercentage(), teamPOs2.get(i).getPossessions(),
						teamPOs2.get(i).getOffensiveEfficiency(), teamPOs2.get(i).getDefensiveEfficiency(),
						teamPOs2.get(i).getOffensivebackboardEfficiency(),
						teamPOs2.get(i).getDefensivebackboardEfficiency(), teamPOs2.get(i).getStealEfficiency(),
						teamPOs2.get(i).getAssitEfficiency(), teamPOs2.get(i).getTeamName(), teamPOs2.get(i).getMatches(),
						teamPOs2.get(i).getFieldGoal(), teamPOs2.get(i).getFieldGoalAttempts(), teamPOs2.get(i).getThreePointFieldGoal(),
						teamPOs2.get(i).getThreePointFieldGoalAttempts(), teamPOs2.get(i).getFreeThrow(),
						teamPOs2.get(i).getFreeThrowAttempts(), teamPOs2.get(i).getOffensiveRebound(), teamPOs2.get(i).getDefensiveRebound(),
						teamPOs2.get(i).getBackboard(), teamPOs2.get(i).getAssist(), teamPOs2.get(i).getSteal(), teamPOs2.get(i).getBlock(), teamPOs2.get(i).getTurnOver(),
						teamPOs2.get(i).getFoul(), teamPOs2.get(i).getScoring());
				teamVOs.add(teamVO);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamVOs;
	}
    
    private void getrank(){
    	ArrayList<TeamVO> teamVOs2 = gettingTeamData("`east/west`='E'", "winningPercentage","ASC");
    	for (int i = 0; i < teamVOs2.size(); i++) {
			for (int j = 0; j < teamVOs.size(); j++) {
				if (teamVOs.get(j).equals(teamVOs2.get(i))) {
					teamVOs.get(i).setRank(i+1);
				}
			}
		}
    	ArrayList<TeamVO> teamVOs3 = gettingTeamData("`east/west`='W'", "winningPercentage","ASC");
    	for (int i = 0; i < teamVOs3.size(); i++) {
			for (int j = 0; j < teamVOs.size(); j++) {
				if (teamVOs.get(j).equals(teamVOs3.get(i))) {
					teamVOs.get(i).setRank(i+1);
				}
			}
		}
    }
    
    public ArrayList<TeamVO>  getTeamData(String condition, String key,String order){
    	teamVOs = gettingTeamData(condition, key, order);
    	getrank();
    	return teamVOs;
    } 
    
    public TeaminfoPO getTeamInfo(String teamName){
    	TeaminfoPO  teaminfoPO = null;
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teaminfoPO = g.getTeaminfo(teamName);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return teaminfoPO;
    }
    
    public TeamPO getTeamData(String teamName){
    	TeamPO teamPO = null;
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPO = g.getTeamdata(teamName);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return teamPO;
    }
    
    public ArrayList<TeamVO> getAllTeamdata(String key,String order){
    	ArrayList<TeamPO> teamPOs = null;
    	ArrayList<TeamVO> teamVOs = null;
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPOs = g.getAllTeamdata(key, order);
			for (int i = 0; i < teamPOs.size(); i++) {
				TeamVO teamVO = new TeamVO(0, teamPOs.get(i).getFieldGoalPercentage(),
						teamPOs.get(i).getThreePointShotPercentage(), teamPOs.get(i).getFreeThrowPercentage(),
						teamPOs.get(i).getWinningPercentage(), teamPOs.get(i).getPossessions(),
						teamPOs.get(i).getOffensiveEfficiency(), teamPOs.get(i).getDefensiveEfficiency(),
						teamPOs.get(i).getOffensivebackboardEfficiency(),
						teamPOs.get(i).getDefensivebackboardEfficiency(), teamPOs.get(i).getStealEfficiency(),
						teamPOs.get(i).getAssitEfficiency(), teamPOs.get(i).getTeamName(), teamPOs.get(i).getMatches(),
						teamPOs.get(i).getFieldGoal(), teamPOs.get(i).getFieldGoalAttempts(), teamPOs.get(i).getThreePointFieldGoal(),
						teamPOs.get(i).getThreePointFieldGoalAttempts(), teamPOs.get(i).getFreeThrow(),
						teamPOs.get(i).getFreeThrowAttempts(), teamPOs.get(i).getOffensiveRebound(), teamPOs.get(i).getDefensiveRebound(),
						teamPOs.get(i).getBackboard(), teamPOs.get(i).getAssist(), teamPOs.get(i).getSteal(), teamPOs.get(i).getBlock(), teamPOs.get(i).getTurnOver(),
						teamPOs.get(i).getFoul(), teamPOs.get(i).getScoring());
				teamVOs.add(teamVO);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return teamVOs;
    }
	

}

