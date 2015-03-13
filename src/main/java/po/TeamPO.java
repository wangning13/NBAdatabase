package po;
//对手投篮命中数，对手投篮出手数，对手失误数,对手罚球数
public class TeamPO {
	int opponentFieldGoal;//对手投篮命中数
	int opponentFieldGoalAttempts;//对手投篮出手次数
	int opponentTurnOver;//对手失误数
	int opponentFreeThrowAttempts;//对手罚球数
	
	String teamName;//球队名称
	int matches;//比赛场数
	int wins;//胜利场数
	int fieldGoal;//投篮命中数
	int fieldGoalAttempts;//投篮出手次数
	int threePointFieldGoal;//三分命中数
	int threePointFieldGoalAttempts;//三分出手数
	int freeThrow;//罚球命中数
	int freeThrowAttempts;//罚球出手数
	int offensiveRebound;//进攻篮板数
	int defensiveRebound;//防守篮板数
	int opponentOffensiveRebound;//对手进攻篮板数
	int opponentDefensiveRebound;//对手防守篮板数
	int backboard;//篮板数
	int assist;//助攻数
	int steal;//抢断数
	int block;//盖帽数
	int turnOver;//失误数
	int foul;//犯规数
	int scoring;//比赛得分
	public TeamPO(int opponentFieldGoal, int opponentFieldGoalAttempts,
			int opponentTurnOver, int opponentFreeThrowAttempts,
			String teamName, int matches, int wins, int fieldGoal,
			int fieldGoalAttempts, int threePointFieldGoal,
			int threePointFieldGoalAttempts, int freeThrow,
			int freeThrowAttempts, int offensiveRebound, int defensiveRebound,
			int opponentOffensiveRebound, int opponentDefensiveRebound,
			int backboard, int assist, int steal, int block, int turnOver,
			int foul, int scoring) {
		super();
		this.opponentFieldGoal = opponentFieldGoal;
		this.opponentFieldGoalAttempts = opponentFieldGoalAttempts;
		this.opponentTurnOver = opponentTurnOver;
		this.opponentFreeThrowAttempts = opponentFreeThrowAttempts;
		this.teamName = teamName;
		this.matches = matches;
		this.wins = wins;
		this.fieldGoal = fieldGoal;
		this.fieldGoalAttempts = fieldGoalAttempts;
		this.threePointFieldGoal = threePointFieldGoal;
		this.threePointFieldGoalAttempts = threePointFieldGoalAttempts;
		this.freeThrow = freeThrow;
		this.freeThrowAttempts = freeThrowAttempts;
		this.offensiveRebound = offensiveRebound;
		this.defensiveRebound = defensiveRebound;
		this.opponentOffensiveRebound = opponentOffensiveRebound;
		this.opponentDefensiveRebound = opponentDefensiveRebound;
		this.backboard = backboard;
		this.assist = assist;
		this.steal = steal;
		this.block = block;
		this.turnOver = turnOver;
		this.foul = foul;
		this.scoring = scoring;
	}
	public int getOpponentFieldGoal() {
		return opponentFieldGoal;
	}
	public void setOpponentFieldGoal(int opponentFieldGoal) {
		this.opponentFieldGoal = opponentFieldGoal;
	}
	public int getOpponentFieldGoalAttempts() {
		return opponentFieldGoalAttempts;
	}
	public void setOpponentFieldGoalAttempts(int opponentFieldGoalAttempts) {
		this.opponentFieldGoalAttempts = opponentFieldGoalAttempts;
	}
	public int getOpponentTurnOver() {
		return opponentTurnOver;
	}
	public void setOpponentTurnOver(int opponentTurnOver) {
		this.opponentTurnOver = opponentTurnOver;
	}
	public int getOpponentFreeThrowAttempts() {
		return opponentFreeThrowAttempts;
	}
	public void setOpponentFreeThrowAttempts(int opponentFreeThrowAttempts) {
		this.opponentFreeThrowAttempts = opponentFreeThrowAttempts;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
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
	public int getBackboard() {
		return backboard;
	}
	public void setBackboard(int backboard) {
		this.backboard = backboard;
	}
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
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
