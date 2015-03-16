package ui.tools;

public class Translate {

	public static String translate(String team){
		String result = "GSW";
        if(team.endsWith("圣安东尼奥马刺"))
        	result = "SAS";
        else if(team.endsWith("孟菲斯灰熊"))
        	result = "MEM";
        else if(team.endsWith("达拉斯小牛"))
        	result = "DAL";
        else if(team.endsWith("休斯顿火箭"))
        	result = "HOU";
        else if(team.endsWith("新奥尔良鹈鹕"))
        	result = "NOP";
        else if(team.endsWith("明尼苏达森林狼"))
        	result = "MIN";
        else if(team.endsWith("丹佛掘金"))
        	result = "DEN";
        else if(team.endsWith("尤他爵士"))
        	result = "UTA";
        else if(team.endsWith("波特兰开拓者"))
        	result = "POR";
        else if(team.endsWith("俄克拉荷马雷霆"))
        	result = "OKC";
        else if(team.endsWith("萨克拉门托国王"))
        	result = "SAC";
        else if(team.endsWith("菲尼克斯太阳"))
        	result = "PHX";
        else if(team.endsWith("洛杉矶湖人"))
        	result = "LAL";
        else if(team.endsWith("洛杉矶快船"))
        	result = "LAC";
        else if(team.endsWith("金州勇士"))
        	result = "GSW";
        else if(team.endsWith("迈阿密热"))
        	result = "MIA";
        else if(team.endsWith("奥兰多魔术"))
        	result = "ORL";
        else if(team.endsWith("亚特兰大老鹰"))
        	result = "ATL";
        else if(team.endsWith("华盛顿奇才"))
        	result = "WAS";
        else if(team.endsWith("夏洛特黄蜂"))
        	result = "CHA";
        else if(team.endsWith("底特律活塞"))
        	result = "DET";
        else if(team.endsWith("印第安纳步行者"))
        	result = "IND";
        else if(team.endsWith("克里夫兰骑士"))
        	result = "CLE";
        else if(team.endsWith("芝加哥公牛"))
        	result = "CHI";
        else if(team.endsWith("密尔沃基雄鹿"))
        	result = "MIL";
        else if(team.endsWith("波士顿凯尔特人"))
        	result = "BOS";
        else if(team.endsWith("费城76人"))
        	result = "PHI";
        else if(team.endsWith("纽约尼克斯"))
        	result = "NYK";
        else if(team.endsWith("布鲁克林篮网"))
        	result = "BKN";
        else if(team.endsWith("多伦多猛龙"))
        	result = "TOR";
        
        return result;
	}
}
