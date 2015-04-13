package businesslogicservice.playerblservice;

import java.util.ArrayList;

import po.PlayerPO;
import po.PlayerinfoPO;
import vo.PlayerMatchVO;
import vo.PlayerVO;
import vo.PlayerinfoVO;

public interface PlayerRankService {
	public ArrayList<String> getAllPlayer(String season,String teamName);//根据球队名称获得所有球员的姓名（数组长度都是15）
	public PlayerVO getPlayerdata(String season,String playerName);//根据球员姓名获得球员的数据
	public PlayerinfoVO getPlayerinfo(String playerName);//根据球员姓名获得球员信息
	public ArrayList<PlayerVO> getAllPlayerdata(String season,String key,String order);//根据条件正序或倒序排列的球员数据的数组
	public ArrayList<PlayerVO> getFirstFifty(String season,String position,String partition,String key);//筛选前50名
	public ArrayList<PlayerMatchVO> getPlayerMatchdata(String date,String team);
	public ArrayList<PlayerMatchVO> getPlayerMonthMatch(String month,String team);
	public ArrayList<PlayerMatchVO> getPlayerRecentFiveMatch(String player);
	public ArrayList<PlayerMatchVO> getDayTop(String condition);
	public ArrayList<PlayerVO> getSeasonTop(String season,String condition);
}
