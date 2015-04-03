package businesslogic.teambl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import po.TeamMatchPO;
import po.TeamPO;
import po.TeaminfoPO;
import vo.TeamMatchVO;
import vo.TeamMonthMatchVO;
import vo.TeamVO;
import vo.TeaminfoVO;
import businesslogicservice.teamblservice.TeamRankService;
import dataservice.getdatadataservice.GetTeamdataDataService;

public class TeamRank implements TeamRankService{
	String rmi = "127.0.0.1";
	DecimalFormat df=new DecimalFormat("#.0000");
	
	private  ArrayList<TeamPO> Ranking(String season,String condition,String order) {
		ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPOs = g.getSomeTeamdata(season,condition, "wins", order);
			for (int i = 0; i < teamPOs.size(); i++) {
				Calculate calculate = new Calculate();
				calculate.Calculate(teamPOs.get(i));
				
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
	
    private ArrayList<TeamVO>  gettingTeamData(String season,String condition, String key,String order) {
    	ArrayList<TeamVO> teamVOs = new ArrayList<TeamVO>();
    	ArrayList<TeamPO> teamPOs2 = null;
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPOs2 = g.getByEfficiency(this.Ranking(season,condition,order), key, order);
			for (int i = 0; i < teamPOs2.size(); i++) {
				GetTeamVO getTeamVO = new GetTeamVO();
				TeamVO teamVO = getTeamVO.GetTeamVO(teamPOs2.get(i));
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
    
    public ArrayList<TeamVO>  getTeamData(String season,String condition, String key,String order){
    	ArrayList<TeamVO> teamVOs = gettingTeamData(season,condition, key, order);
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
    
    public TeamVO getTeamData(String season,String teamName){
    	ArrayList<TeamVO> teamVOs = getAllTeamdata(season,"wins", "DESC");
    	int teamRank = 0;
    	TeamVO teamVO = new TeamVO();
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			TeamPO teamPO = g.getTeamdata(season,teamName);
			for (int i = 0; i < teamVOs.size(); i++) {
				if (teamName.equals(teamVOs.get(i).getTeamName())) {
					teamRank = teamVOs.get(i).getRank();
				}
			}
			GetTeamVO getTeamVO = new GetTeamVO();
			
			teamVO = getTeamVO.GetTeamVO(teamPO);
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
    
    public ArrayList<TeamVO> getAllTeamdata(String season,String key,String order){

    	return this.getTeamData(season,"1", key, order);
    }
	
    public ArrayList<TeamMonthMatchVO> getTeamMonthMatch(String month,String team){
		ArrayList<TeamMonthMatchVO> teamMonthMatchVOs = new ArrayList<TeamMonthMatchVO>();
		ArrayList<TeamMatchPO> teamMatchPOs = new ArrayList<TeamMatchPO>();
		GetTeamdataDataService g;
		try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamMatchPOs = g.getTeamMonthMatch(month, team);
			for (int i = 0; i < teamMatchPOs.size(); i++) {
				for (int j = 0; j < teamMatchPOs.size(); j++) {
					if (teamMatchPOs.get(i).getHostGuest().equals("h")) {
						if (teamMatchPOs.get(i).getDate().equals(teamMatchPOs.get(j).getDate())) {
							TeamMonthMatchVO teamMonthMatchVO = new TeamMonthMatchVO(teamMatchPOs.get(j).getDate(), 
									teamMatchPOs.get(i).getName(), 
									teamMatchPOs.get(j).getName(), 
									teamMatchPOs.get(i).getTotal()+"-"+teamMatchPOs.get(j).getTotal(),
									teamMatchPOs.get(i).getFirst()+"-"+teamMatchPOs.get(j).getFirst(),
									teamMatchPOs.get(i).getSecond()+"-"+teamMatchPOs.get(j).getSecond(),
									teamMatchPOs.get(i).getThird()+"-"+teamMatchPOs.get(j).getThird(), 
									teamMatchPOs.get(i).getFourth()+"-"+teamMatchPOs.get(j).getFourth());
							teamMonthMatchVOs.add(teamMonthMatchVO);
							teamMatchPOs.remove(j);
						}
					}else {
						if (teamMatchPOs.get(i).getDate().equals(teamMatchPOs.get(j).getDate())) {
							TeamMonthMatchVO teamMonthMatchVO = new TeamMonthMatchVO(teamMatchPOs.get(j).getDate(), 
									teamMatchPOs.get(j).getName(),
									teamMatchPOs.get(i).getName(), 
									teamMatchPOs.get(j).getTotal()+"-"+teamMatchPOs.get(i).getTotal(),
									teamMatchPOs.get(j).getFirst()+"-"+teamMatchPOs.get(i).getFirst(),
									teamMatchPOs.get(j).getSecond()+"-"+teamMatchPOs.get(i).getSecond(),
									teamMatchPOs.get(j).getThird()+"-"+teamMatchPOs.get(i).getThird(), 
									teamMatchPOs.get(j).getFourth()+"-"+teamMatchPOs.get(i).getFourth());
							teamMonthMatchVOs.add(teamMonthMatchVO);
							teamMatchPOs.remove(j);
						}
					}
					
					
				}
				
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
		return teamMonthMatchVOs;
	}
    
    public TeamMatchVO getTeamMatch(String date,String team){
    	TeamMatchVO teamMatchVO = new TeamMatchVO();
    	TeamMatchPO teamMatchPO = new TeamMatchPO();
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamMatchVO = new TeamMatchVO(teamMatchPO.getDate(),
					teamMatchPO.getHostGuest(), 
					teamMatchPO.getName(),
					teamMatchPO.getOpponent(),
					teamMatchPO.getWinLose(), 
					teamMatchPO.getTotal(),
					teamMatchPO.getFirst(), 
					teamMatchPO.getSecond(), 
					teamMatchPO.getThird(), 
					teamMatchPO.getFourth());
			
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
    	return teamMatchVO;
    }
    
    public ArrayList<TeamMatchVO> getTeamRecentFiveMatch(String team){
    	ArrayList<TeamMatchPO> teamMatchPOs = new ArrayList<TeamMatchPO>();
    	ArrayList<TeamMatchVO> teamMatchVOs = new ArrayList<TeamMatchVO>();
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamMatchPOs = g.getTeamRecentFiveMatch(team);
			for (int i = 0; i < teamMatchPOs.size(); i++) {
				TeamMatchVO teamMatchVO = new TeamMatchVO(teamMatchPOs.get(i).getDate(),
						teamMatchPOs.get(i).getHostGuest(), 
						teamMatchPOs.get(i).getName(),
						teamMatchPOs.get(i).getOpponent(),
						teamMatchPOs.get(i).getWinLose(), 
						teamMatchPOs.get(i).getTotal(),
						teamMatchPOs.get(i).getFirst(), 
						teamMatchPOs.get(i).getSecond(), 
						teamMatchPOs.get(i).getThird(), 
						teamMatchPOs.get(i).getFourth());
				teamMatchVOs.add(teamMatchVO);
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
    	return teamMatchVOs;
    }

}

