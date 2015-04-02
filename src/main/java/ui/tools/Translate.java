package ui.tools;

public class Translate {

	public static String translate(String team){
		String result = "GSW";
        if(team.equals("圣安东尼奥马刺"))
        	result = "SAS";
        else if(team.equals("孟菲斯灰熊"))
        	result = "MEM";
        else if(team.equals("达拉斯小牛"))
        	result = "DAL";
        else if(team.equals("休斯顿火箭"))
        	result = "HOU";
        else if(team.equals("新奥尔良鹈鹕"))
        	result = "NOP";
        else if(team.equals("明尼苏达森林狼"))
        	result = "MIN";
        else if(team.equals("丹佛掘金"))
        	result = "DEN";
        else if(team.equals("尤他爵士"))
        	result = "UTA";
        else if(team.equals("波特兰开拓者"))
        	result = "POR";
        else if(team.equals("俄克拉荷马雷霆"))
        	result = "OKC";
        else if(team.equals("萨克拉门托国王"))
        	result = "SAC";
        else if(team.equals("菲尼克斯太阳"))
        	result = "PHX";
        else if(team.equals("洛杉矶湖人"))
        	result = "LAL";
        else if(team.equals("洛杉矶快船"))
        	result = "LAC";
        else if(team.equals("金州勇士"))
        	result = "GSW";
        else if(team.equals("迈阿密热"))
        	result = "MIA";
        else if(team.equals("奥兰多魔术"))
        	result = "ORL";
        else if(team.equals("亚特兰大老鹰"))
        	result = "ATL";
        else if(team.equals("华盛顿奇才"))
        	result = "WAS";
        else if(team.equals("夏洛特黄蜂"))
        	result = "CHA";
        else if(team.equals("底特律活塞"))
        	result = "DET";
        else if(team.equals("印第安纳步行者"))
        	result = "IND";
        else if(team.equals("克里夫兰骑士"))
        	result = "CLE";
        else if(team.equals("芝加哥公牛"))
        	result = "CHI";
        else if(team.equals("密尔沃基雄鹿"))
        	result = "MIL";
        else if(team.equals("波士顿凯尔特人"))
        	result = "BOS";
        else if(team.equals("费城76人"))
        	result = "PHI";
        else if(team.equals("纽约尼克斯"))
        	result = "NYK";
        else if(team.equals("布鲁克林篮网"))
        	result = "BKN";
        else if(team.equals("多伦多猛龙"))
        	result = "TOR";
        
        return result;
	}
	
	public static String translate1(String type){
		String result = "scoring";
        if(type.equals("胜率"))
        	result = "winningPercentage";
        else if(type.equals("球队名称"))
        	result = "teamName";
        else if(type.equals("场次"))
        	result = "matches";
        else if(type.equals("投篮命中数")||type.equals("投篮"))
        	result = "fieldGoal";
        else if(type.equals("投篮出手数"))
        	result = "fieldGoalAttempts";
        else if(type.equals("三分命中数")||type.equals("三分"))
        	result = "threePointFieldGoal";
        else if(type.equals("三分出手数"))
        	result = "threePointFieldGoalAttempts";
        else if(type.equals("罚球命中数")||type.equals("罚球"))
        	result = "freeThrow";
        else if(type.equals("罚球出手数"))
        	result = "freeThrowAttempts";
        else if(type.equals("进攻篮板数"))
        	result = "offensiveRebound";
        else if(type.equals("防守篮板数"))
        	result = "defensiveRebound";
        else if(type.equals("篮板数")||type.equals("篮板"))
        	result = "backboard";
        else if(type.equals("助攻数")||type.equals("助攻"))
        	result = "assist";
        else if(type.equals("抢断数")||type.equals("抢断"))
        	result = "steal";
        else if(type.equals("盖帽数")||type.equals("盖帽"))
        	result = "block";
        else if(type.equals("失误数")||type.equals("失误"))
        	result = "turnOver";
        else if(type.equals("犯规数")||type.equals("犯规"))
        	result = "foul";
        else if(type.equals("比赛得分"))
        	result = "scoring";
        else if(type.equals("投篮命中率"))
        	result = "fieldGoalPercentage";
        else if(type.equals("三分命中率"))
        	result = "threePointShotPercentage";
        else if(type.equals("罚球命中率"))
        	result = "freeThrowPercentage";
        else if(type.equals("进攻回合"))
        	result = "possessions";
        else if(type.equals("进攻效率"))
        	result = "offensiveEfficiency";
        else if(type.equals("防守效率"))
        	result = "defensiveEfficiency";
        else if(type.equals("进攻篮板效率"))
        	result = "offensivebackboardEfficiency";
        else if(type.equals("防守篮板效率"))
        	result = "defensivebackboardEfficiency";
        else if(type.equals("抢断效率"))
        	result = "stealEfficiency";
        else if(type.equals("助攻效率"))
        	result = "assitEfficiency";
        else if(type.equals("得分"))
        	result = "scoring";
        else if(type.equals("球员名称"))
        	result = "playerName";
        else if(type.equals("所属球队"))
        	result = "team";
        else if(type.equals("参赛场数"))
        	result = "appearance";
        else if(type.equals("先发场数"))
        	result = "firstPlay";
        else if(type.equals("在场时间"))
        	result = "minutes";
        else if(type.equals("进攻数"))
        	result = "offensiveRebound";
        else if(type.equals("防守数"))
        	result = "defensiveRebound";
        else if(type.equals("效率"))
        	result = "efficiency";
        else if(type.equals("GmSc效率"))
        	result = "GmScEfficiency";
        else if(type.equals("真实命中率"))
        	result = "trueShootingPercentage";
        else if(type.equals("投篮效率"))
        	result = "shootingEfficiency";
        else if(type.equals("篮板率"))
        	result = "backboardPercentage";
        else if(type.equals("进攻篮板率"))
        	result = "offensiveReboundPercentage";
        else if(type.equals("防守篮板率"))
        	result = "defensiveReboundPercentage";
        else if(type.equals("助攻率"))
        	result = "assistPercentage";
        else if(type.equals("抢断率"))
        	result = "stealPercentage";
        else if(type.equals("盖帽率"))
        	result = "blockPercentage";
        else if(type.equals("失误率"))
        	result = "turnOverPercentage";
        else if(type.equals("使用率"))
        	result = "usage";
        else if(type.equals("两双"))
        	result = "doubleDouble";
        else if(type.equals("得分/篮板/助攻"))
        	result = "weightAverage";
        else if(type.equals("前锋"))
        	result = "F";
        else if(type.equals("中锋"))
        	result = "C";
        else if(type.equals("后卫"))
        	result = "G";
        else if(type.equals("东部"))
        	result = "league:E";
        else if(type.equals("西部"))
        	result = "league:W";
        else if(type.equals("东南区"))
        	result = "partition:Southeast";
        else if(type.equals("大西洋区"))
        	result = "partition:Atlantic";
        else if(type.equals("西南区"))
        	result = "partition:Southwest";
        else if(type.equals("西北区"))
        	result = "partition:Northwest";
        else if(type.equals("太平洋区"))
        	result = "partition:Pacific";
        else if(type.equals("中部区"))
        	result = "partition:Central";

        return result;
	}
}
