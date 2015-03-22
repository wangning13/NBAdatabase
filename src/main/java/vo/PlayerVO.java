package vo;

public class PlayerVO {
	String playerName;//球员姓名
	String team;//所属球队
	int appearance;//参赛场数
	int firstPlay;//先发场数
	int backboard;//篮板数
	double averageBackboard;//场均篮板数
	int assist;//助攻数
	double averageAssist;//场均助攻数
	double minites;//在场时间
	double averageMinute;//场均在场时间
	int fieldGoal;//投篮命中数
	double averageFieldGoal;//场均投篮命中数
	int fieldGoalAttempts;//投篮出手次数
	double averageFieldGoalAttempts;//场均投篮出手次数
	int threePointFieldGoal;//三分命中数
	double averageThreePointFieldGoal;//场均三分命中数
	int threePointFieldGoalAttempts;//三分出手数
	double averageThreePointFieldGoalAttempts;//场均三分出手数
	int freeThrow;//罚球命中数
	double averageFreeThrow;//场均罚球命中数
	int freeThrowAttempts;//罚球出手数
	double averageFreeThrowAttempts;//场均罚球出手数
	int offensiveRebound;//进攻数
	double averageOffensiveRebound;//场均进攻数
	int defensiveRebound;//防守数
	double averageDefensiveRebound;//场均防守数
	int steal;//抢断数
	double averageSteal;//场均抢断数
	int block;//盖帽数
	double averageBlock;//场均盖帽数
	int turnOver;//失误数
	double averageTurn;//场均失误数
	int foul;//犯规数 
	double averageFoul;//场均犯规数
	int scoring;//比赛得分
	double averageScoring;//场均比赛得分
	int teamFieldGoalAttempts;//球队总出手次数
	int teamBackboard;//球队总篮板
	int teamFieldGoal;//球队投篮命中数
	int teamFreeThrow;//球队的罚球命中数
	int teamOffensiveRebound;//球队总进攻篮板
	int teamDefensiveRebound;//球队总防守篮板
	double teamMinutes;//球队所有球员上场时间
	int teamFreeThrowAttempts;//球队罚球次数
	int teamTurnOver;//球队失误数
	int opponentBackBoard;//对手总篮板
	int opponentOffensiveRebound;//对手总进攻篮板
	int opponentDefensiveRebound;//对手总防守篮板
	int opponentFieldGoalAttempts;//对手投篮出手次数
	int opponentThreePointFieldGoalAttempts;//对手三分出手数
	
	double fielfGoalShotPercentage;//投篮命中率
	double threePointShotPercentage;//三分命中率
	double freeThrowPercentage;//罚球命中率
	double efficiency;//效率
	double GmScEfficiency;//GmSc效率
	double nearlyFivePercentage;//近五场提升率
	double trueShootingPercentage;//真实命中率
	double shootingEfficiency;//投篮效率
	double backboardPercentage;//篮板率
	double offensiveReboundPercentage;//进攻篮板率
	double defensiveReboundPercentage;//防守篮板率
	double assistPercentage;//助攻率
	double stealPercentage;//抢断率
	double blockPercentage;//盖帽率
	double turnOverPercentage;//失误率
	double usage;//使用率
	
	double previousAverageScoring;//五场前的平均得分
	double nearlyFiveAverageScoring;//近五场的平均得分
	int doubleDouble=0;//两双次数
	public PlayerVO(String playerName, String team, int appearance,
			int firstPlay, int backboard, double averageBackboard, int assist,
			double averageAssist, double minites, double averageMinute,
			int fieldGoal, double averageFieldGoal, int fieldGoalAttempts,
			double averageFieldGoalAttempts, int threePointFieldGoal,
			double averageThreePointFieldGoal, int threePointFieldGoalAttempts,
			double averageThreePointFieldGoalAttempts, int freeThrow,
			double averageFreeThrow, int freeThrowAttempts,
			double averageFreeThrowAttempts, int offensiveRebound,
			double averageOffensiveRebound, int defensiveRebound,
			double averageDefensiveRebound, int steal, double averageSteal,
			int block, double averageBlock, int turnOver, double averageTurn,
			int foul, double averageFoul, int scoring, double averageScoring,
			int teamFieldGoalAttempts, int teamBackboard, int teamFieldGoal,
			int teamFreeThrow, int teamOffensiveRebound,
			int teamDefensiveRebound, double teamMinutes,
			int teamFreeThrowAttempts, int teamTurnOver, int opponentBackBoard,
			int opponentOffensiveRebound, int opponentDefensiveRebound,
			int opponentFieldGoalAttempts,
			int opponentThreePointFieldGoalAttempts,
			double fieldGoalShotPercentage,
			double threePointShotPercentage, double freeThrowPercentage,
			double efficiency, double GmScEfficiency,
			double nearlyFivePercentage, double trueShootingPercentage,
			double shootingEfficiency, double backboardPercentage,
			double offensiveReboundPercentage,
			double defensiveReboundPercentage, double assistPercentage,
			double stealPercentage, double blockPercentage,
			double turnOverPercentage, double usage,
			double previousAverageScoring, double nearlyFiveAverageScoring,
			int doubleDouble) {
		super();
		this.playerName = playerName;
		this.team = team;
		this.appearance = appearance;
		this.firstPlay = firstPlay;
		this.backboard = backboard;
		this.averageBackboard = averageBackboard;
		this.assist = assist;
		this.averageAssist = averageAssist;
		this.minites = minites;
		this.averageMinute = averageMinute;
		this.fieldGoal = fieldGoal;
		this.averageFieldGoal = averageFieldGoal;
		this.fieldGoalAttempts = fieldGoalAttempts;
		this.averageFieldGoalAttempts = averageFieldGoalAttempts;
		this.threePointFieldGoal = threePointFieldGoal;
		this.averageThreePointFieldGoal = averageThreePointFieldGoal;
		this.threePointFieldGoalAttempts = threePointFieldGoalAttempts;
		this.averageThreePointFieldGoalAttempts = averageThreePointFieldGoalAttempts;
		this.freeThrow = freeThrow;
		this.averageFreeThrow = averageFreeThrow;
		this.freeThrowAttempts = freeThrowAttempts;
		this.averageFreeThrowAttempts = averageFreeThrowAttempts;
		this.offensiveRebound = offensiveRebound;
		this.averageOffensiveRebound = averageOffensiveRebound;
		this.defensiveRebound = defensiveRebound;
		this.averageDefensiveRebound = averageDefensiveRebound;
		this.steal = steal;
		this.averageSteal = averageSteal;
		this.block = block;
		this.averageBlock = averageBlock;
		this.turnOver = turnOver;
		this.averageTurn = averageTurn;
		this.foul = foul;
		this.averageFoul = averageFoul;
		this.scoring = scoring;
		this.averageScoring = averageScoring;
		this.teamFieldGoalAttempts = teamFieldGoalAttempts;
		this.teamBackboard = teamBackboard;
		this.teamFieldGoal = teamFieldGoal;
		this.teamFreeThrow = teamFreeThrow;
		this.teamOffensiveRebound = teamOffensiveRebound;
		this.teamDefensiveRebound = teamDefensiveRebound;
		this.teamMinutes = teamMinutes;
		this.teamFreeThrowAttempts = teamFreeThrowAttempts;
		this.teamTurnOver = teamTurnOver;
		this.opponentBackBoard = opponentBackBoard;
		this.opponentOffensiveRebound = opponentOffensiveRebound;
		this.opponentDefensiveRebound = opponentDefensiveRebound;
		this.opponentFieldGoalAttempts = opponentFieldGoalAttempts;
		this.opponentThreePointFieldGoalAttempts = opponentThreePointFieldGoalAttempts;
		this.threePointShotPercentage = threePointShotPercentage;
		this.freeThrowPercentage = freeThrowPercentage;
		this.efficiency = efficiency;
		this.GmScEfficiency = GmScEfficiency;
		this.nearlyFivePercentage = nearlyFivePercentage;
		this.trueShootingPercentage = trueShootingPercentage;
		this.shootingEfficiency = shootingEfficiency;
		this.backboardPercentage = backboardPercentage;
		this.offensiveReboundPercentage = offensiveReboundPercentage;
		this.defensiveReboundPercentage = defensiveReboundPercentage;
		this.assistPercentage = assistPercentage;
		this.stealPercentage = stealPercentage;
		this.blockPercentage = blockPercentage;
		this.turnOverPercentage = turnOverPercentage;
		this.usage = usage;
		this.previousAverageScoring = previousAverageScoring;
		this.nearlyFiveAverageScoring = nearlyFiveAverageScoring;
		this.doubleDouble = doubleDouble;
		this.fielfGoalShotPercentage = fieldGoalShotPercentage;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getAppearance() {
		return appearance;
	}
	public void setAppearance(int appearance) {
		this.appearance = appearance;
	}
	public int getFirstPlay() {
		return firstPlay;
	}
	public void setFirstPlay(int firstPlay) {
		this.firstPlay = firstPlay;
	}
	public int getBackboard() {
		return backboard;
	}
	public void setBackboard(int backboard) {
		this.backboard = backboard;
	}
	public double getAverageBackboard() {
		return averageBackboard;
	}
	public void setAverageBackboard(double averageBackboard) {
		this.averageBackboard = averageBackboard;
	}
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
	}
	public double getAverageAssist() {
		return averageAssist;
	}
	public void setAverageAssist(double averageAssist) {
		this.averageAssist = averageAssist;
	}
	public double getMinites() {
		return minites;
	}
	public void setMinites(double minites) {
		this.minites = minites;
	}
	public double getAverageMinute() {
		return averageMinute;
	}
	public void setAverageMinute(double averageMinute) {
		this.averageMinute = averageMinute;
	}
	public int getFieldGoal() {
		return fieldGoal;
	}
	public void setFieldGoal(int fieldGoal) {
		this.fieldGoal = fieldGoal;
	}
	public double getAverageFieldGoal() {
		return averageFieldGoal;
	}
	public void setAverageFieldGoal(double averageFieldGoal) {
		this.averageFieldGoal = averageFieldGoal;
	}
	public int getFieldGoalAttempts() {
		return fieldGoalAttempts;
	}
	public void setFieldGoalAttempts(int fieldGoalAttempts) {
		this.fieldGoalAttempts = fieldGoalAttempts;
	}
	public double getAverageFieldGoalAttempts() {
		return averageFieldGoalAttempts;
	}
	public void setAverageFieldGoalAttempts(double averageFieldGoalAttempts) {
		this.averageFieldGoalAttempts = averageFieldGoalAttempts;
	}
	public int getThreePointFieldGoal() {
		return threePointFieldGoal;
	}
	public void setThreePointFieldGoal(int threePointFieldGoal) {
		this.threePointFieldGoal = threePointFieldGoal;
	}
	public double getAverageThreePointFieldGoal() {
		return averageThreePointFieldGoal;
	}
	public void setAverageThreePointFieldGoal(double averageThreePointFieldGoal) {
		this.averageThreePointFieldGoal = averageThreePointFieldGoal;
	}
	public int getThreePointFieldGoalAttempts() {
		return threePointFieldGoalAttempts;
	}
	public void setThreePointFieldGoalAttempts(int threePointFieldGoalAttempts) {
		this.threePointFieldGoalAttempts = threePointFieldGoalAttempts;
	}
	public double getAverageThreePointFieldGoalAttempts() {
		return averageThreePointFieldGoalAttempts;
	}
	public void setAverageThreePointFieldGoalAttempts(
			double averageThreePointFieldGoalAttempts) {
		this.averageThreePointFieldGoalAttempts = averageThreePointFieldGoalAttempts;
	}
	public int getFreeThrow() {
		return freeThrow;
	}
	public void setFreeThrow(int freeThrow) {
		this.freeThrow = freeThrow;
	}
	public double getAverageFreeThrow() {
		return averageFreeThrow;
	}
	public void setAverageFreeThrow(double averageFreeThrow) {
		this.averageFreeThrow = averageFreeThrow;
	}
	public int getFreeThrowAttempts() {
		return freeThrowAttempts;
	}
	public void setFreeThrowAttempts(int freeThrowAttempts) {
		this.freeThrowAttempts = freeThrowAttempts;
	}
	public double getAverageFreeThrowAttempts() {
		return averageFreeThrowAttempts;
	}
	public void setAverageFreeThrowAttempts(double averageFreeThrowAttempts) {
		this.averageFreeThrowAttempts = averageFreeThrowAttempts;
	}
	public int getOffensiveRebound() {
		return offensiveRebound;
	}
	public void setOffensiveRebound(int offensiveRebound) {
		this.offensiveRebound = offensiveRebound;
	}
	public double getAverageOffensiveRebound() {
		return averageOffensiveRebound;
	}
	public void setAverageOffensiveRebound(double averageOffensiveRebound) {
		this.averageOffensiveRebound = averageOffensiveRebound;
	}
	public int getDefensiveRebound() {
		return defensiveRebound;
	}
	public void setDefensiveRebound(int defensiveRebound) {
		this.defensiveRebound = defensiveRebound;
	}
	public double getAverageDefensiveRebound() {
		return averageDefensiveRebound;
	}
	public void setAverageDefensiveRebound(double averageDefensiveRebound) {
		this.averageDefensiveRebound = averageDefensiveRebound;
	}
	public int getSteal() {
		return steal;
	}
	public void setSteal(int steal) {
		this.steal = steal;
	}
	public double getAverageSteal() {
		return averageSteal;
	}
	public void setAverageSteal(double averageSteal) {
		this.averageSteal = averageSteal;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public double getAverageBlock() {
		return averageBlock;
	}
	public void setAverageBlock(double averageBlock) {
		this.averageBlock = averageBlock;
	}
	public int getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(int turnOver) {
		this.turnOver = turnOver;
	}
	public double getAverageTurn() {
		return averageTurn;
	}
	public void setAverageTurn(double averageTurn) {
		this.averageTurn = averageTurn;
	}
	public int getFoul() {
		return foul;
	}
	public void setFoul(int foul) {
		this.foul = foul;
	}
	public double getAverageFoul() {
		return averageFoul;
	}
	public void setAverageFoul(double averageFoul) {
		this.averageFoul = averageFoul;
	}
	public int getScoring() {
		return scoring;
	}
	public void setScoring(int scoring) {
		this.scoring = scoring;
	}
	public double getAverageScoring() {
		return averageScoring;
	}
	public void setAverageScoring(double averageScoring) {
		this.averageScoring = averageScoring;
	}
	public int getTeamFieldGoalAttempts() {
		return teamFieldGoalAttempts;
	}
	public void setTeamFieldGoalAttempts(int teamFieldGoalAttempts) {
		this.teamFieldGoalAttempts = teamFieldGoalAttempts;
	}
	public int getTeamBackboard() {
		return teamBackboard;
	}
	public void setTeamBackboard(int teamBackboard) {
		this.teamBackboard = teamBackboard;
	}
	public int getTeamFieldGoal() {
		return teamFieldGoal;
	}
	public void setTeamFieldGoal(int teamFieldGoal) {
		this.teamFieldGoal = teamFieldGoal;
	}
	public int getTeamFreeThrow() {
		return teamFreeThrow;
	}
	public void setTeamFreeThrow(int teamFreeThrow) {
		this.teamFreeThrow = teamFreeThrow;
	}
	public int getTeamOffensiveRebound() {
		return teamOffensiveRebound;
	}
	public void setTeamOffensiveRebound(int teamOffensiveRebound) {
		this.teamOffensiveRebound = teamOffensiveRebound;
	}
	public int getTeamDefensiveRebound() {
		return teamDefensiveRebound;
	}
	public void setTeamDefensiveRebound(int teamDefensiveRebound) {
		this.teamDefensiveRebound = teamDefensiveRebound;
	}
	public double getTeamMinutes() {
		return teamMinutes;
	}
	public void setTeamMinutes(double teamMinutes) {
		this.teamMinutes = teamMinutes;
	}
	public int getTeamFreeThrowAttempts() {
		return teamFreeThrowAttempts;
	}
	public void setTeamFreeThrowAttempts(int teamFreeThrowAttempts) {
		this.teamFreeThrowAttempts = teamFreeThrowAttempts;
	}
	public int getTeamTurnOver() {
		return teamTurnOver;
	}
	public void setTeamTurnOver(int teamTurnOver) {
		this.teamTurnOver = teamTurnOver;
	}
	public int getOpponentBackBoard() {
		return opponentBackBoard;
	}
	public void setOpponentBackBoard(int opponentBackBoard) {
		this.opponentBackBoard = opponentBackBoard;
	}
	public int getOpponentOffensiveRebound() {
		return opponentOffensiveRebound;
	}
	public void setOpponentOffensiveRebound(int opponentOffensiveRebound) {
		this.opponentOffensiveRebound = opponentOffensiveRebound;
	}
	public int getOpponentDefensiveRebound() {
		return opponentDefensiveRebound;
	}
	public void setOpponentDefensiveRebound(int opponentDefensiveRebound) {
		this.opponentDefensiveRebound = opponentDefensiveRebound;
	}
	public int getOpponentFieldGoalAttempts() {
		return opponentFieldGoalAttempts;
	}
	public void setOpponentFieldGoalAttempts(int opponentFieldGoalAttempts) {
		this.opponentFieldGoalAttempts = opponentFieldGoalAttempts;
	}
	public int getOpponentThreePointFieldGoalAttempts() {
		return opponentThreePointFieldGoalAttempts;
	}
	public void setOpponentThreePointFieldGoalAttempts(
			int opponentThreePointFieldGoalAttempts) {
		this.opponentThreePointFieldGoalAttempts = opponentThreePointFieldGoalAttempts;
	}
	public double getThreePointShotPercentage() {
		return threePointShotPercentage;
	}
	public void setThreePointShotPercentage(double threePointShotPercentage) {
		this.threePointShotPercentage = threePointShotPercentage;
	}
	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}
	public void setFreeThrowPercentage(double freeThrowPercentage) {
		this.freeThrowPercentage = freeThrowPercentage;
	}
	public double getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	public double getGmScEfficiency() {
		return GmScEfficiency;
	}
	public void setGmScEfficiency(double gmScEfficiency) {
		GmScEfficiency = gmScEfficiency;
	}
	public double getNearlyFivePercentage() {
		return nearlyFivePercentage;
	}
	public void setNearlyFivePercentage(double nearlyFivePercentage) {
		this.nearlyFivePercentage = nearlyFivePercentage;
	}
	public double getTrueShootingPercentage() {
		return trueShootingPercentage;
	}
	public void setTrueShootingPercentage(double trueShootingPercentage) {
		this.trueShootingPercentage = trueShootingPercentage;
	}
	public double getShootingEfficiency() {
		return shootingEfficiency;
	}
	public void setShootingEfficiency(double shootingEfficiency) {
		this.shootingEfficiency = shootingEfficiency;
	}
	public double getBackboardPercentage() {
		return backboardPercentage;
	}
	public void setBackboardPercentage(double backboardPercentage) {
		this.backboardPercentage = backboardPercentage;
	}
	public double getOffensiveReboundPercentage() {
		return offensiveReboundPercentage;
	}
	public void setOffensiveReboundPercentage(double offensiveReboundPercentage) {
		this.offensiveReboundPercentage = offensiveReboundPercentage;
	}
	public double getDefensiveReboundPercentage() {
		return defensiveReboundPercentage;
	}
	public void setDefensiveReboundPercentage(double defensiveReboundPercentage) {
		this.defensiveReboundPercentage = defensiveReboundPercentage;
	}
	public double getAssistPercentage() {
		return assistPercentage;
	}
	public void setAssistPercentage(double assistPercentage) {
		this.assistPercentage = assistPercentage;
	}
	public double getStealPercentage() {
		return stealPercentage;
	}
	public void setStealPercentage(double stealPercentage) {
		this.stealPercentage = stealPercentage;
	}
	public double getBlockPercentage() {
		return blockPercentage;
	}
	public void setBlockPercentage(double blockPercentage) {
		this.blockPercentage = blockPercentage;
	}
	public double getTurnOverPercentage() {
		return turnOverPercentage;
	}
	public void setTurnOverPercentage(double turnOverPercentage) {
		this.turnOverPercentage = turnOverPercentage;
	}
	public double getUsage() {
		return usage;
	}
	public void setUsage(double usage) {
		this.usage = usage;
	}
	public double getPreviousAverageScoring() {
		return previousAverageScoring;
	}
	public void setPreviousAverageScoring(double previousAverageScoring) {
		this.previousAverageScoring = previousAverageScoring;
	}
	public double getNearlyFiveAverageScoring() {
		return nearlyFiveAverageScoring;
	}
	public void setNearlyFiveAverageScoring(double nearlyFiveAverageScoring) {
		this.nearlyFiveAverageScoring = nearlyFiveAverageScoring;
	}
	public int getDoubleDouble() {
		return doubleDouble;
	}
	public void setDoubleDouble(int doubleDouble) {
		this.doubleDouble = doubleDouble;
	}
	public double getFielfGoalShotPercentage() {
		return fielfGoalShotPercentage;
	}
	public void setFielfGoalShotPercentage(double fielfGoalShotPercentage) {
		this.fielfGoalShotPercentage = fielfGoalShotPercentage;
	}
	

}
