package po;

public class PlayerPO {

	String playerName;//球员姓名
	String team;//球员队伍
	int appearance;//参赛场数
	int firstPlay;//先发场数
	int fieldGoal;//投篮命中数
	int fieldGoalAttempts;//投篮出手次数
	int threePointFieldGoal;//三分命中数
	int threePointFieldGoalAttempts;//三分出手数
	int freeThrow;//罚球命中数
	int freeThrowAttempts;//罚球出手数
	int offensiveRebound;//进攻数
	int defensiveRebound;//防守数
	int backboard;//篮板数
	int assit;//助攻数
	double minites;//在场时间
	int steal;//抢断数
	int block;//盖帽数
	int turnOver;//失误数
	int foul;//犯规数 
	int scoring;//比赛得分
	int teamFieldGoalAttempts;//球队总出手次数
	int teamBackboard;//球队总篮板
	double teamMinutes;//球队上场总时间
	int teamFreeThrowAttempts;//球队罚球次数
	int teamTurnOver;//球队失误数
	int opponentFieldGoalAttempts;//对手投篮出手次数
	int opponentThreePointFieldGoalAttempts;//对手三分出手数
	public PlayerPO(	String playerName,String team,int appearance,int firstPlay,int fieldGoal,int fieldGoalAttempts,int threePointFieldGoal,int threePointFieldGoalAttempts,int freeThrow,int freeThrowAttempts,int offensiveRebound,int defensiveRebound,int backboard,	int assit,double minites,int steal,int block,int turnOver,int foul,int scoring,int teamFieldGoalAttempts,int teamBackboard,double teamMinutes,int teamFreeThrowAttempts,int teamTurnOver,int opponentFieldGoalAttempts,int opponentThreePointFieldGoalAttempts) {
		this.playerName=playerName;
		this.team=team;
		this.appearance=appearance;
		this.firstPlay=firstPlay;
		this.fieldGoal=fieldGoal;
		this.fieldGoalAttempts=fieldGoalAttempts;
		this.threePointFieldGoal=threePointFieldGoal;
		this.threePointFieldGoalAttempts=threePointFieldGoalAttempts;
		this.freeThrow=freeThrow;
		this.freeThrowAttempts=freeThrowAttempts;
		this.backboard=backboard;
		this.assit=assit;
		this.minites=minites;
		this.offensiveRebound=offensiveRebound;
		this.defensiveRebound=defensiveRebound;
		this.steal=steal;
		this.block=block;
		this.turnOver=turnOver;
		this.foul=foul;
		this.scoring=scoring;
		this.teamFieldGoalAttempts=teamFieldGoalAttempts;
		this.teamBackboard=teamBackboard;
		this.teamMinutes=teamMinutes;
		this.teamFreeThrowAttempts=teamFreeThrowAttempts;
		this.teamTurnOver=teamTurnOver;
		this.opponentFieldGoalAttempts=opponentFieldGoalAttempts;
		this.opponentThreePointFieldGoalAttempts=opponentThreePointFieldGoalAttempts;
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
	public int getFieldGoal() {
		return fieldGoal;
	}
	public void setFieldGoal(int fieldGoal) {
		this.fieldGoal = fieldGoal;
	}
	public int getFieldGoalAttempts() {
		return fieldGoalAttempts;
	}
	public void setFieldGoalAttempts(int fieldGoalAttempts) {
		this.fieldGoalAttempts = fieldGoalAttempts;
	}
	public int getThreePointFieldGoal() {
		return threePointFieldGoal;
	}
	public void setThreePointFieldGoal(int threePointFieldGoal) {
		this.threePointFieldGoal = threePointFieldGoal;
	}
	public int getThreePointFieldGoalAttempts() {
		return threePointFieldGoalAttempts;
	}
	public void setThreePointFieldGoalAttempts(int threePointFieldGoalAttempts) {
		this.threePointFieldGoalAttempts = threePointFieldGoalAttempts;
	}
	public int getFreeThrow() {
		return freeThrow;
	}
	public void setFreeThrow(int freeThrow) {
		this.freeThrow = freeThrow;
	}
	public int getFreeThrowAttempts() {
		return freeThrowAttempts;
	}
	public void setFreeThrowAttempts(int freeThrowAttempts) {
		this.freeThrowAttempts = freeThrowAttempts;
	}
	public int getBackboard() {
		return backboard;
	}
	public void setBackboard(int backboard) {
		this.backboard = backboard;
	}
	public int getAssit() {
		return assit;
	}
	public void setAssit(int assit) {
		this.assit = assit;
	}
	public double getMinites() {
		return minites;
	}
	public void setMinites(double minites) {
		this.minites = minites;
	}
	public int getOffensiveRebound() {
		return offensiveRebound;
	}
	public void setOffensiveRebound(int offensiveRebound) {
		this.offensiveRebound = offensiveRebound;
	}
	public int getDefensiveRebound() {
		return defensiveRebound;
	}
	public void setDefensiveRebound(int defensiveRebound) {
		this.defensiveRebound = defensiveRebound;
	}
	public int getSteal() {
		return steal;
	}
	public void setSteal(int steal) {
		this.steal = steal;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public int getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(int turnOver) {
		this.turnOver = turnOver;
	}
	public int getFoul() {
		return foul;
	}
	public void setFoul(int foul) {
		this.foul = foul;
	}
	public int getScoring() {
		return scoring;
	}
	public void setScoring(int scoring) {
		this.scoring = scoring;
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
}
