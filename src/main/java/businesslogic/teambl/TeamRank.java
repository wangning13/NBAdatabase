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
				teamPOs.set(i, calculate.Calculate(teamPOs.get(i)));
				
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
				ArrayList<TeamMatchPO> teamMatchPOs2 = g.getTeamMonthMatch(month, teamMatchPOs.get(i).getOpponent());
				for (int j = 0; j < teamMatchPOs2.size(); j++) {
					if (teamMatchPOs2.get(j).getOpponent().equals(team)) {
						String data = teamMatchPOs.get(i).getDate();
						String host = "";
						String guest = "";
						if (teamMatchPOs.get(i).getHostGuest().equals("h")) {
							host = team;
							guest = teamMatchPOs2.get(j).getName();
						}else {
							host = teamMatchPOs2.get(j).getName();
							guest = team;
						}
						String score = teamMatchPOs.get(i).getTotal() + "-" + teamMatchPOs2.get(j).getTotal();
						String first = teamMatchPOs.get(i).getFirst() + "-" + teamMatchPOs2.get(j).getFirst();
						String second = teamMatchPOs.get(i).getSecond() + "-" + teamMatchPOs2.get(j).getSecond();
						String third = teamMatchPOs.get(i).getThird() + "-" + teamMatchPOs2.get(j).getThird();
						String fourth = teamMatchPOs.get(i).getFourth() + "-" + teamMatchPOs2.get(j).getFourth();
						TeamMonthMatchVO teamMonthMatchVO = new TeamMonthMatchVO(data, host, guest, score, first, second, third, fourth);
						teamMonthMatchVOs.add(teamMonthMatchVO);
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
			teamMatchPO = g.getTeamMatch(date, team);
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
    
    public ArrayList<TeamVO> getSeasonTop(String season,String condition){
    	ArrayList<TeamPO> teamPOs = new ArrayList<TeamPO>();
    	ArrayList<TeamVO> teamVOs = new ArrayList<TeamVO>();
    	GetTeamdataDataService g;
    	try {
			g = (GetTeamdataDataService) Naming.lookup("rmi://"+rmi+":2015/GetTeamdata");
			teamPOs = g.getSeasonTop(season, condition);
			for (int i = 0; i < teamPOs.size(); i++) {
				GetTeamVO getTeamVO = new GetTeamVO();
				TeamVO teamVO = getTeamVO.GetTeamVO(teamPOs.get(i));
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

