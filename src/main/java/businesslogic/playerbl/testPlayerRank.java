package businesslogic.playerbl;

import java.util.ArrayList;

import po.PlayerPO;
import po.PlayerinfoPO;
import vo.PlayerVO;
import vo.PlayerinfoVO;

public class testPlayerRank {
	public static void main(String[] args){
		PlayerRank playerRank = new PlayerRank();
//		ArrayList<String> a = playerRank.getAllPlayer("CHI");
//		System.out.println(a.size());
//		for (int i = 0; i < a.size(); i++) {
//			System.out.println(a.get(i));
//		}
		PlayerVO playerVO = playerRank.getPlayerdata("Brandon Knight");
		System.out.println(playerVO.getThreePointShotPercentage());
		System.out.println(playerVO.getTeam());
		System.out.println(playerVO.getAppearance());
		System.out.println(playerVO.getFirstPlay());
		System.out.println(playerVO.getOpponentOffensiveRebound());
		System.out.println(playerVO.getOpponentBackBoard());
		System.out.println(playerVO.getOpponentDefensiveRebound());
		System.out.println(playerVO.getOpponentFieldGoalAttempts());
		System.out.println(playerVO.getOpponentThreePointFieldGoalAttempts());
		System.out.println(playerVO.getSteal());
		System.out.println(playerVO.getStealPercentage());
		System.out.println(playerVO.getBackboardPercentage());
		System.out.println(playerVO.getDefensiveReboundPercentage());
		System.out.println(playerVO.getAverageBackboard());
		System.out.println(playerVO.getAverageAssist());
		
//		PlayerinfoVO playerinfoVO = playerRank.getPlayerinfo("Brandon Knight");
//		System.out.println(playerinfoVO.getAge());
//		System.out.print(playerinfoVO.getBirth());
//		System.out.println(playerinfoVO.getExp());
//		System.out.println(playerinfoVO.getHeight());
//		System.out.println(playerinfoVO.getName());
//		System.out.println(playerinfoVO.getNumber());
//		System.out.println(playerinfoVO.getPosition());
//		System.out.println(playerinfoVO.getSchool());
//		System.out.println(playerinfoVO.getWeight());
		
//		ArrayList<PlayerVO> playerVOs = playerRank.getAllPlayerdata("wins", "DESC");
//		System.out.println();
//		for (int i = 0; i < playerVOs.size(); i++) {
//			System.out.println("sd");
//			System.out.println(playerVOs.get(i).getAppearance());
//		}
		
//		ArrayList<PlayerVO> playerVOs = playerRank.getFirstFifty("C", "`east/west`='W'", "appearance");
		
		
	}

}
