package data.getdata;

public class SqlStatement {
//order：DESC降序，ASC升序
	public static String countTeamMatches(String teamName){
		String r="SELECT COUNT(name) FROM matches WHERE name='"+teamName+"'";
		return r;
	}
	
	public static String countTeamSum(String teamName){
		String r="SELECT SUM(fieldGoal),SUM(fieldGoalAttempts),SUM(`threepointFieldGoal`),SUM(`threepointFieldGoalAttempts`),SUM(freeThrow),SUM(freeThrowAttempts),SUM(offensiveRebound),SUM(defensiveRebound),SUM(backboard),SUM(assit),SUM(steal),SUM(block),SUM(turnOver),SUM(foul),SUM(scoring) FROM playerdata WHERE team='"+teamName+"'";
		return r;
	}
	
	public static String getTeamName(){
		String r="SELECT abbr FROM teaminfo";
		return r;
	}
	
	public static String getTeaminfo(String teamName){
		String r="SELECT * FROM teaminfo WHERE abbr='"+teamName+"'";
		return r;
	}
	
	public static String countPlayerMatches(String playerName){
		String r="SELECT COUNT(playername) FROM playerdata WHERE playername='"+playerName+"'";
		return r;
	}
	
	public static String countPlayerSum(String playerName){
		String r="SELECT SUM(fieldGoal),SUM(fieldGoalAttempts),SUM(`three-pointFieldGoal`),SUM(`three-pointFieldGoalAttempts`),SUM(freeThrow),SUM(freeThrowAttempts),SUM(offensiveRebound),SUM(defensiveRebound),SUM(backboard),SUM(assit),SUM(steal),SUM(block),SUM(turnOver),SUM(foul),SUM(scoring) FROM playerdata WHERE playername='"+playerName+"'";
		return r;
	}
	
	public static String getPlayerinfo(String playerName){
		String r="SELECT * FROM playerinfo WHERE name='"+playerName+"'";
		return r;
	}
}
