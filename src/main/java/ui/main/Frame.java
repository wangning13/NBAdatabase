package ui.main;

import java.awt.CardLayout;

import javax.swing.*;

import ui.player.PlayersSelect;
import ui.player.SinglePlayer;
import ui.player.Statistics;
import ui.team.Ranking;
import ui.team.SingleTeam;
import ui.team.TeamsSelect;

@SuppressWarnings("serial")
public class Frame extends JFrame{

	public static final int WIN_W = 1052;
	public static final int WIN_H = 650;
    public Ranking rankingPanel = new Ranking(this);
    public Statistics statisticsPanel = new Statistics(this);
    public MainFrame mainFrame = new MainFrame(this);
    public TeamsSelect teamsSelectPanel = new TeamsSelect(this);
    public PlayersSelect playersSelectPanel = new PlayersSelect(this);
    public SingleTeam singleTeamPanel = new SingleTeam(this);
    public SinglePlayer singlePlayerPanel = new SinglePlayer(this);
	public Frame (){
		super("NBA数据控");
		this.getContentPane().add(mainFrame);
        CardLayout cl=new CardLayout();
		this.setLayout(cl);

		
	    this.setSize(WIN_W,WIN_H);
	    this.setLocationRelativeTo(null);//使窗口位于屏幕中央
	    this.setUndecorated(true);//只有在窗体不可显示时才调用此方法
	    this.setResizable(false);   // 去除窗口栏 (目前暂时保留以供调试方便)
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	
	}
	
	public void change(JPanel cur,JPanel next){
		cur.setVisible(false);
		this.remove(cur);
		System.gc();
		next.setVisible(true);
		add(next);
		next.setBounds(0,0,1052,650);
		repaint();
	}


}

