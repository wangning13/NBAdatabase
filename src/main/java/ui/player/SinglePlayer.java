package ui.player;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import po.PlayerinfoPO;
import businesslogic.playerbl.PlayerRank;
import businesslogicservice.playerblservice.PlayerRankService;
import ui.main.Frame;
import ui.main.MyButton;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;
import vo.PlayerVO;
import vo.PlayerinfoVO;

@SuppressWarnings("serial")
public class SinglePlayer extends MyPanel implements ActionListener{
	PlayerRankService prs = new PlayerRank();
	Frame frame;
	JScrollPane pane1;
	MyTable table1;
	DefaultTableModel model1;
	String[] columnNames1 = {"所属球队","参赛场数","先发场数","篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率","进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率","GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率","失误率","使用率","场均得分","场均时间","场均篮板","场均助攻","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻数","场均防守数","场均抢断数","场均盖帽数","场均失误数","场均犯规数"};
	JScrollPane pane2;
	MyTable table2;
	DefaultTableModel model2;
	String[] columnNames2 = {"场均得分","场均时间","场均篮板","场均助攻","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻数","场均防守数","场均抢断数","场均盖帽数","场均失误数","场均犯规数"};
	JLabel rankingBand = new JLabel(Img.RANKINGBAND);
	JComboBox<String> month = new JComboBox<String>();
	JComboBox<String> season = new JComboBox<String>();
    JButton search = new JButton("查询");
    JLabel jl1 = new JLabel("姓名");
    JLabel jl2 = new JLabel("号码");
    JLabel jl3 = new JLabel("位置");
    JLabel jl4 = new JLabel("身高");
    JLabel jl5 = new JLabel("体重");
    JLabel jl6 = new JLabel("生日");
    JLabel jl7 = new JLabel("年龄");
    JLabel jl8 = new JLabel("NBA球龄");
    JLabel jl9 = new JLabel("毕业学校");
    
    JLabel name = new JLabel("队名");
    JLabel number = new JLabel("缩写");
    JLabel position = new JLabel("城市");
    JLabel height = new JLabel("联盟");
    JLabel weight = new JLabel("分区");
    JLabel birth = new JLabel("主场");
    JLabel age = new JLabel("进入NBA");
    JLabel exp = new JLabel("进入NBA");
    JLabel school = new JLabel("进入NBA");
    
    JLabel playerIcon = new JLabel(Img.load("Jeremy Lin"));
    JLabel board = new JLabel(Img.BOARD1);
 //   JButton enterTeam = new JButton("进入球队页面");
    
	Font font1 = new Font("黑体", Font.BOLD, 16);
//	Font font2 = new Font("黑体", Font.BOLD, 14);
	public SinglePlayer(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
		season.addItem("2014");
		season.addItem("2013");
		season.addItem("2012");
		season.addItem("2011");
		season.addItem("2010");
		season.addItem("2009");
		season.addItem("2008");
		
		month.addItem("01月");
		month.addItem("02月");
		month.addItem("03月");
		month.addItem("04月");
		month.addItem("05月");
		month.addItem("06月");
		month.addItem("07月");
		month.addItem("08月");
		month.addItem("09月");
		month.addItem("10月");
		month.addItem("11月");
		month.addItem("12月");
		
        this.add(season);
        season.setBounds(815, 175, 70, 20);
        season.setFont(font1);
        
        this.add(month);
        month.setBounds(900, 175, 60, 20);
        month.setFont(font1);
        
        this.add(search);
        search.setBounds(980, 172, 60, 25);
        search.addActionListener(this);
        search.setActionCommand("search");
        
		this.add(rankingBand);
		rankingBand.setBounds(250, 150, 802, 70);
		this.add(playerIcon);
		playerIcon.setBounds(10, 147, 230, 185);
		
		this.add(jl1);
		jl1.setBounds(10, 330, 100, 30);
		jl1.setFont(font1);
		this.add(jl2);
		jl2.setBounds(10, 365, 100, 30);
		jl2.setFont(font1);
		this.add(jl3);
		jl3.setBounds(10, 400, 100, 30);
		jl3.setFont(font1);
		this.add(jl4);
		jl4.setBounds(10, 435, 100, 30);
		jl4.setFont(font1);
		this.add(jl5);
		jl5.setBounds(10, 470, 100, 30);
		jl5.setFont(font1);
		this.add(jl6);
		jl6.setBounds(10, 505, 100, 30);
		jl6.setFont(font1);
		this.add(jl7);
		jl7.setBounds(10, 540, 100, 30);
		jl7.setFont(font1);
		this.add(jl8);
		jl8.setBounds(10, 575, 100, 30);
		jl8.setFont(font1);
		this.add(jl9);
		jl9.setBounds(8, 610, 100, 30);
		jl9.setFont(font1);
/*
		this.add(enterTeam);
		enterTeam.setBounds(55, 607, 130, 30);
		enterTeam.addActionListener(this);
		enterTeam.setActionCommand("enterTeam");
		enterTeam.setFont(font2);
	*/	
		this.add(name);
		name.setBounds(80, 330, 200, 30);
		name.setFont(font1);
		this.add(number);
		number.setBounds(80, 365, 200, 30);
		number.setFont(font1);
		this.add(position);
		position.setBounds(80, 400, 200, 30);
		position.setFont(font1);
		this.add(height);
		height.setBounds(80, 435, 200, 30);
		height.setFont(font1);
		this.add(weight);
		weight.setBounds(80, 470, 200, 30);
		weight.setFont(font1);
		this.add(birth);
		birth.setBounds(80, 505, 200, 30);
		birth.setFont(font1);
		this.add(age);
		age.setBounds(80, 540, 200, 30);
		age.setFont(font1);
		this.add(exp);
		exp.setBounds(80, 575, 200, 30);
		exp.setFont(font1);
		this.add(school);
		school.setBounds(80, 610, 200, 30);
		school.setFont(font1);
		
		this.add(board);
		board.setBounds(0, 150, 250, 500);
		
        Object[][] data1 = null;
	    model1 = new DefaultTableModel(new Object[][]{},columnNames1);
	    model1.setDataVector(data1, columnNames1);
	    table1 = new MyTable(model1);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane1 = new JScrollPane (table1);
	    this.add(pane1);
	    pane1.setBounds(250, 435, 802, 215);
	    
        Object[][] data2 = null;
	    model2 = new DefaultTableModel(new Object[][]{},columnNames2);
	    model2.setDataVector(data2, columnNames2);
	    table2 = new MyTable(model2);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane2 = new JScrollPane (table2);
	    this.add(pane2);
	    pane2.setBounds(250,  220, 802, 215);
	   
	}
	
	public void update(String name){
		playerIcon.setIcon(Img.load(name));
		PlayerinfoVO playerInfo = prs.getPlayerinfo(name);
	    this.name.setText(name);
	    number.setText(playerInfo.getNumber());
	    position.setText(playerInfo.getPosition());
	    height.setText(playerInfo.getHeight());
	    weight.setText(String.valueOf(playerInfo.getWeight()));
	    birth.setText(playerInfo.getBirth());
	    age.setText(String.valueOf(playerInfo.getAge()));
	    exp.setText(playerInfo.getExp());
	    school.setText(playerInfo.getSchool());
	    
	    PlayerVO player = prs.getPlayerdata(name);
	    Object[][] data1 = new Object[1][];
		
		Object[] temp1 = {player.getTeam(),player.getAppearance(),player.getFirstPlay(),player.getBackboard(),player.getAssist(),player.getMinutes(),player.getFielfGoalShotPercentage(),player.getThreePointShotPercentage(),player.getFreeThrowPercentage(),player.getOffensiveRebound(),player.getDefensiveRebound(),player.getSteal(),player.getBlock(),player.getTurnOver(),player.getFoul(),player.getScoring(),player.getEfficiency(),player.getGmScEfficiency(),player.getTrueShootingPercentage(),player.getShootingEfficiency(),player.getBackboardPercentage(),player.getOffensiveReboundPercentage(),player.getDefensiveReboundPercentage(),player.getAssistPercentage(),player.getStealPercentage(),player.getBlockPercentage(),player.getTurnOverPercentage(),player.getUsage(),player.getAverageScoring(),player.getAverageMinute(),player.getAverageBackboard(),player.getAverageAssist(),player.getAverageFieldGoal(),player.getAverageFieldGoalAttempts(),player.getAverageThreePointFieldGoal(),player.getAverageThreePointFieldGoalAttempts(),player.getAverageFreeThrow(),player.getAverageFreeThrowAttempts(),player.getAverageOffensiveRebound(),player.getAverageDefensiveRebound(),player.getAverageSteal(),player.getAverageBlock(),player.getAverageTurn(),player.getAverageFoul()};
		data1[0] = temp1;
		
		model1.setDataVector(data1, columnNames1);
	    table1.setWidth();
		table1.updateUI();
		
	/*    Object[][] data2 = new Object[1][];
		
		Object[] temp2 = {player.getAverageScoring(),player.getAverageMinute(),player.getAverageBackboard(),player.getAverageAssist(),player.getAverageFieldGoal(),player.getAverageFieldGoalAttempts(),player.getAverageThreePointFieldGoal(),player.getAverageThreePointFieldGoalAttempts(),player.getAverageFreeThrow(),player.getAverageFreeThrowAttempts(),player.getAverageOffensiveRebound(),player.getAverageDefensiveRebound(),player.getAverageSteal(),player.getAverageBlock(),player.getAverageTurn(),player.getAverageFoul()};
		data2[0] = temp2;
		
		model2.setDataVector(data2, columnNames2);
	    table2.setWidth();
		table2.updateUI();*/
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("home")){
			frame.change(this, frame.mainFrame);
		}
		else if(e.getActionCommand().equals("back")){
			frame.change(this, frame.playersSelectPanel);
		}
		
	}

}
