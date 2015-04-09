package businesslogic.playerbl;

import po.PlayerMatchPO;
import vo.PlayerMatchVO;

public class GetPlayerMatchVO {
	public PlayerMatchVO getPlayerMatchVO(PlayerMatchPO playerMatchPO){
		PlayerMatchVO playerMatchVO = new PlayerMatchVO(playerMatchPO.getDate(),
				playerMatchPO.getTeam(), 
				playerMatchPO.getPlayername(), 
				playerMatchPO.getPosition(),
				playerMatchPO.getMinutes(),
				playerMatchPO.getFieldGoal(),
				playerMatchPO.getFieldGoalAttempts(),
				playerMatchPO.getThreepointFieldGoal(),
				playerMatchPO.getThreepointFieldGoalAttempts(),
				playerMatchPO.getFreeThrow(),
				playerMatchPO.getFreeThrowAttempts(),
				playerMatchPO.getOffensiveRebound(), 
				playerMatchPO.getDefensiveRebound(),
				playerMatchPO.getBackboard(),
				playerMatchPO.getAssist(), 
				playerMatchPO.getSteal(),
				playerMatchPO.getBlock(),
				playerMatchPO.getTurnOver(),
				playerMatchPO.getFoul(),
				playerMatchPO.getScoring());
		return playerMatchVO;
		
	}

}
