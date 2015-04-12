package businesslogic.playerbl;

import java.util.ArrayList;

import po.PlayerPO;
import po.PlayerinfoPO;
import vo.PlayerMatchVO;
import vo.PlayerVO;
import vo.PlayerinfoVO;

public class testPlayerRank {
	public static void main(String[] args){
		PlayerRank playerRank = new PlayerRank();
//		ArrayList<PlayerMatchVO> playerMatchVOs = playerRank.getPlayerMatchdata("13-10-29", "LAL");
//		for (int i = 0; i < playerMatchVOs.size(); i++) {
//			System.out.println(playerMatchVOs.get(i).getPlayername());
//			System.out.println(playerMatchVOs.get(i).getScoring());
//		}
	
//		ArrayList<PlayerMatchVO> playerMatchVOs2 = playerRank.getPlayerMonthMatch("13-10", "Ed Davis");
//		for (int i = 0; i < playerMatchVOs2.size(); i++) {
//			System.out.println(playerMatchVOs2.get(i).getPlayername());
//			System.out.println(playerMatchVOs2.get(i).getMinutes());
//			System.out.println(playerMatchVOs2.get(i).getScoring());
//		}
		
//		ArrayList<PlayerMatchVO> playerMatchVOs = playerRank.getPlayerRecentFiveMatch("Ed Davis");
//		for (int i = 0; i < playerMatchVOs.size(); i++) {
//			System.out.println(playerMatchVOs.get(i).getDate());
//		}
		
//		ArrayList<PlayerMatchVO> playerMatchVOs = playerRank.getDayTop("13-10-29", "backboard");
//		for (int i = 0; i < playerMatchVOs.size(); i++) {
//			System.out.println(playerMatchVOs.get(i).getPlayername());
//			System.out.println(playerMatchVOs.get(i).getBackboard());
//		}
		
		
		
//		ArrayList<String> a = playerRank.getAllPlayer("CHI");
//		System.out.println(a.size());
//		for (int i = 0; i < a.size(); i++) {
//			System.out.println(a.get(i));
//		}

		ArrayList<PlayerVO> playerVOs = playerRank.getSeasonTop("12-13", "backboard");
		System.out.println(playerVOs.size());
		for (int i = 0; i < playerVOs.size(); i++) {
			System.out.println(playerVOs.get(i).getMinutes());
		}

		
		
	}

}
