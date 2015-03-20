package businesslogic.teambl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamVO;
import vo.TeaminfoVO;
import businesslogicservice.teamblservice.TeamRankService;
import dataservice.getdatadataservice.GetTeamdataDataService;

public class TeamRank implements TeamRankService{
	String rmi = "127.0.0.1";
	
	
	
	
	public  ArrayList<TeamPO> Ranking(String condition,String order) {
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPOs = g.getSomeTeamdata(condition, "wins", order);
			for (int i = 0; i < teamPOs.size(); i++) {
				//胜率
				teamPOs.get(i).setWinningPercentage(((double)teamPOs.get(i).getWins())/teamPOs.get(i).getMatches());
				
				//投篮命中率
				teamPOs.get(i).setFieldGoalPercentage(((double)teamPOs.get(i).getFieldGoal())/teamPOs.get(i).getFieldGoalAttempts());
				//三分命中率
				teamPOs.get(i).setThreePointShotPercentage(((double)teamPOs.get(i).getThreePointFieldGoal())/teamPOs.get(i).getThreePointFieldGoalAttempts());
				//罚球命中率
				teamPOs.get(i).setFreeThrowPercentage(((double)teamPOs.get(i).getFreeThrow())/teamPOs.get(i).getFreeThrowAttempts());
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
	
    public ArrayList<TeamVO>  gettingTeamData(String condition, String key,String order) {
    	ArrayList<TeamVO> teamVOs = new ArrayList<TeamVO>();
    	ArrayList<TeamPO> teamPOs2 = null;
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPOs2 = g.getByEfficiency(this.Ranking(condition,order), key, order);
			for (int i = 0; i < teamPOs2.size(); i++) {
				TeamVO teamVO = new TeamVO(0,
				teamPOs2.get(i).getOpponentFieldGoal(),
				teamPOs2.get(i).getOpponentFieldGoalAttempts(),
				teamPOs2.get(i).getOpponentTurnOver(),
				teamPOs2.get(i).getOpponentFreeThrowAttempts(),
				teamPOs2.get(i).getOppenentScoring(),
				teamPOs2.get(i).getTeamName(),
				teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getWins(),
				teamPOs2.get(i).getFieldGoal(),
				((double)teamPOs2.get(i).getFieldGoal())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getFieldGoalAttempts(),
				((double)teamPOs2.get(i).getFieldGoalAttempts())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getThreePointFieldGoal(),
				((double)teamPOs2.get(i).getThreePointFieldGoal())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getThreePointFieldGoalAttempts(),
				((double)teamPOs2.get(i).getThreePointFieldGoalAttempts())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getFreeThrow(),
				((double)teamPOs2.get(i).getFreeThrow())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getFreeThrowAttempts(),
				((double)teamPOs2.get(i).getFreeThrowAttempts())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getOffensiveRebound(),
				((double)teamPOs2.get(i).getOffensiveRebound())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getDefensiveRebound(),
				((double)teamPOs2.get(i).getDefensiveRebound())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getOpponentOffensiveRebound(),
				((double)teamPOs2.get(i).getOpponentOffensiveRebound())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getOpponentDefensiveRebound(),
				((double)teamPOs2.get(i).getOpponentDefensiveRebound())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getBackboard(),
				((double)teamPOs2.get(i).getBackboard())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getAssist(),
				((double)teamPOs2.get(i).getAssist())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getSteal(),
				((double)teamPOs2.get(i).getSteal())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getBlock(),
				((double)teamPOs2.get(i).getBlock())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getTurnOver(),
				((double)teamPOs2.get(i).getTurnOver())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getFoul(),
				((double)teamPOs2.get(i).getFoul())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getScoring(),
				((double)teamPOs2.get(i).getScoring())/teamPOs2.get(i).getMatches(),
				teamPOs2.get(i).getFieldGoalPercentage(),
				teamPOs2.get(i).getThreePointShotPercentage(),
				teamPOs2.get(i).getFreeThrowPercentage(),
				teamPOs2.get(i).getWinningPercentage(),
				teamPOs2.get(i).getPossessions(),
				teamPOs2.get(i).getOffensiveEfficiency(),
				teamPOs2.get(i).getDefensiveEfficiency(),
				teamPOs2.get(i).getOffensivebackboardEfficiency(),
				teamPOs2.get(i).getDefensivebackboardEfficiency(),
				teamPOs2.get(i).getStealEfficiency(),
				teamPOs2.get(i).getAssitEfficiency());
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
    
    private void getrank(ArrayList<TeamVO> teamVOs){
    	ArrayList<TeamVO> teamVOs2 = gettingTeamData("`east/west`='E'", "winningPercentage","DESC");
    	for (int i = 0; i < teamVOs2.size(); i++) {
			teamVOs2.get(i).setRank(i+1);
		}
    	for (int i = 0; i < teamVOs2.size(); i++) {
			for (int j = 0; j < teamVOs.size(); j++) {
				if (teamVOs.get(j).getTeamName().equals(teamVOs2.get(i).getTeamName())) {
					teamVOs.get(i).setRank(teamVOs2.get(i).getRank());
				}
			}
		}
    	ArrayList<TeamVO> teamVOs3 = gettingTeamData("`east/west`='W'", "winningPercentage","DESC");
    	for (int i = 0; i < teamVOs3.size(); i++) {
			teamVOs3.get(i).setRank(i+1);
		}
    	for (int i = 0; i < teamVOs3.size(); i++) {
			for (int j = 0; j < teamVOs.size(); j++) {
				if (teamVOs.get(j).getTeamName().equals(teamVOs3.get(i).getTeamName())) {
					teamVOs.get(i).setRank(teamVOs3.get(i).getRank());
				}
			}
		}
    }
    
    public ArrayList<TeamVO>  getTeamData(String condition, String key,String order){
    	ArrayList<TeamVO> teamVOs = gettingTeamData(condition, key, order);
    	getrank(teamVOs);
    	return teamVOs;
    } 
    
    public TeaminfoVO getTeamInfo(String teamName){
    	TeaminfoPO  teaminfoPO = null;
    	TeaminfoVO teaminfoVO = null;
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teaminfoPO = g.getTeaminfo(teamName);
			teaminfoVO = new TeaminfoVO(teaminfoPO.getName(), teaminfoPO.getAbbr(), teaminfoPO.getCity(), teaminfoPO.getLeague(), teaminfoPO.getPartition(), teaminfoPO.getCourt(), teaminfoPO.getYear());
			
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
    	return teaminfoVO;
    }
    
    public TeamVO getTeamData(String teamName){
    	ArrayList<TeamVO> teamVOs = getAllTeamdata("wins", "DESC");
    	getrank(teamVOs);
    	int teamRank = 0;
    	TeamVO teamVO = new TeamVO();
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			TeamPO teamPO = g.getTeamdata(teamName);
			for (int i = 0; i < teamVOs.size(); i++) {
				if (teamName.equals(teamVOs.get(i).getTeamName())) {
					teamRank = teamVOs.get(i).getRank();
				}
			}
			teamVO = new TeamVO(teamRank,
					teamPO.getOpponentFieldGoal(),
					teamPO.getOpponentFieldGoalAttempts(),
					teamPO.getOpponentTurnOver(),
					teamPO.getOpponentFreeThrowAttempts(),
					teamPO.getOppenentScoring(),
					teamPO.getTeamName(),
					teamPO.getMatches(),
					teamPO.getWins(),
					teamPO.getFieldGoal(),
					((double)teamPO.getFieldGoal())/teamPO.getMatches(),
					teamPO.getFieldGoalAttempts(),
					((double)teamPO.getFieldGoalAttempts())/teamPO.getMatches(),
					teamPO.getThreePointFieldGoal(),
					((double)teamPO.getThreePointFieldGoal())/teamPO.getMatches(),
					teamPO.getThreePointFieldGoalAttempts(),
					((double)teamPO.getThreePointFieldGoalAttempts())/teamPO.getMatches(),
					teamPO.getFreeThrow(),
					((double)teamPO.getFreeThrow())/teamPO.getMatches(),
					teamPO.getFreeThrowAttempts(),
					((double)teamPO.getFreeThrowAttempts())/teamPO.getMatches(),
					teamPO.getOffensiveRebound(),
					((double)teamPO.getOffensiveRebound())/teamPO.getMatches(),
					teamPO.getDefensiveRebound(),
					((double)teamPO.getDefensiveRebound())/teamPO.getMatches(),
					teamPO.getOpponentOffensiveRebound(),
					((double)teamPO.getOpponentOffensiveRebound())/teamPO.getMatches(),
					teamPO.getOpponentDefensiveRebound(),
					((double)teamPO.getOpponentDefensiveRebound())/teamPO.getMatches(),
					teamPO.getBackboard(),
					((double)teamPO.getBackboard())/teamPO.getMatches(),
					teamPO.getAssist(),
					((double)teamPO.getAssist())/teamPO.getMatches(),
					teamPO.getSteal(),
					((double)teamPO.getSteal())/teamPO.getMatches(),
					teamPO.getBlock(),
					((double)teamPO.getBlock())/teamPO.getMatches(),
					teamPO.getTurnOver(),
					((double)teamPO.getTurnOver())/teamPO.getMatches(),
					teamPO.getFoul(),
					((double)teamPO.getFoul())/teamPO.getMatches(),
					teamPO.getScoring(),
					((double)teamPO.getScoring())/teamPO.getMatches(),
					teamPO.getFieldGoalPercentage(),
					teamPO.getThreePointShotPercentage(),
					teamPO.getFreeThrowPercentage(),
					teamPO.getWinningPercentage(),
					teamPO.getPossessions(),
					teamPO.getOffensiveEfficiency(),
					teamPO.getDefensiveEfficiency(),
					teamPO.getOffensivebackboardEfficiency(),
					teamPO.getDefensivebackboardEfficiency(),
					teamPO.getStealEfficiency(),
					teamPO.getAssitEfficiency());			
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
    	return teamVO;
    }
    
    public ArrayList<TeamVO> getAllTeamdata(String key,String order){
//    	ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
//    	ArrayList<TeamVO> teamVOs = new ArrayList<TeamVO>();
//    	GetTeamdataDataService g;
//    	try {
//			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
//			teamPOs = g.getAllTeamdata(key, order);
//			for (int i = 0; i < teamPOs.size(); i++) {
//				TeamVO teamVO = new TeamVO(0,
//						teamPOs.get(i).getOpponentFieldGoal(),
//						teamPOs.get(i).getOpponentFieldGoalAttempts(),
//						teamPOs.get(i).getOpponentTurnOver(),
//						teamPOs.get(i).getOpponentFreeThrowAttempts(),
//						teamPOs.get(i).getOppenentScoring(),
//						teamPOs.get(i).getTeamName(),
//						teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getWins(),
//						teamPOs.get(i).getFieldGoal(),
//						teamPOs.get(i).getFieldGoal()/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getFieldGoalAttempts(),
//						((double)teamPOs.get(i).getFieldGoalAttempts())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getThreePointFieldGoal(),
//						((double)teamPOs.get(i).getThreePointFieldGoal())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getThreePointFieldGoalAttempts(),
//						((double)teamPOs.get(i).getThreePointFieldGoalAttempts())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getFreeThrow(),
//						((double)teamPOs.get(i).getFreeThrow())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getFreeThrowAttempts(),
//						((double)teamPOs.get(i).getFreeThrowAttempts())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getOffensiveRebound(),
//						((double)teamPOs.get(i).getOffensiveRebound())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getDefensiveRebound(),
//						((double)teamPOs.get(i).getDefensiveRebound())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getOpponentOffensiveRebound(),
//						((double)teamPOs.get(i).getOpponentOffensiveRebound())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getOpponentDefensiveRebound(),
//						((double)teamPOs.get(i).getOpponentDefensiveRebound())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getBackboard(),
//						((double)teamPOs.get(i).getBackboard())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getAssist(),
//						((double)teamPOs.get(i).getAssist())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getSteal(),
//						((double)teamPOs.get(i).getSteal())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getBlock(),
//						((double)teamPOs.get(i).getBlock())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getTurnOver(),
//						((double)teamPOs.get(i).getTurnOver())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getFoul(),
//						((double)teamPOs.get(i).getFoul())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getScoring(),
//						((double)teamPOs.get(i).getScoring())/teamPOs.get(i).getMatches(),
//						teamPOs.get(i).getFieldGoalPercentage(),
//						teamPOs.get(i).getThreePointShotPercentage(),
//						teamPOs.get(i).getFreeThrowPercentage(),
//						teamPOs.get(i).getWinningPercentage(),
//						teamPOs.get(i).getPossessions(),
//						teamPOs.get(i).getOffensiveEfficiency(),
//						teamPOs.get(i).getDefensiveEfficiency(),
//						teamPOs.get(i).getOffensivebackboardEfficiency(),
//						teamPOs.get(i).getDefensivebackboardEfficiency(),
//						teamPOs.get(i).getStealEfficiency(),
//						teamPOs.get(i).getAssitEfficiency());
//						teamVOs.add(teamVO);
//			}
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NotBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	return this.getTeamData("1", key, order);
    }
	

}

