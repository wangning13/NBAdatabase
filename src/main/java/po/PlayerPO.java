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
	public PlayerPO(	String playerName,String team,int appearance,int firstPlay,int fieldGoal,int fieldGoalAttempts,int threePointFieldGoal,int threePointFieldGoalAttempts,int freeThrow,int freeThrowAttempts,int offensiveRebound,int defensiveRebound,int backboard,	int assit,double minites,int steal,int block,int turnOver,int foul,int scoring) {
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

}
