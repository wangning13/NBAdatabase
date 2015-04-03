package ui.team;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import businesslogic.teambl.TeamRank;
import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;
import ui.tools.Translate;
import vo.TeamVO;

@SuppressWarnings("serial")
public class Ranking extends MyPanel implements ActionListener{
	TeamRankService trs = new TeamRank();
	Frame frame;
	JScrollPane pane1;
	MyTable table1;
	DefaultTableModel model1;
	String[] columnNames1 = {"球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻效率","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻篮板数","场均防守篮板数","场均篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	/*JScrollPane pane2;
	MyTable table2;
	DefaultTableModel model2;
	String[] columnNames2 = {"东部","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻效率","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻篮板数","场均防守篮板数","场均篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	JScrollPane pane3;
	MyTable table3;
	DefaultTableModel model3;
	String[] columnNames3 = {"东南区","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻效率","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻篮板数","场均防守篮板数","场均篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	JScrollPane pane4;
	MyTable table4;
	DefaultTableModel model4;
	String[] columnNames4 = {"大西洋区","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻效率","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻篮板数","场均防守篮板数","场均篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	JScrollPane pane5;
	MyTable table5;
	DefaultTableModel model5;
	String[] columnNames5 = {"中部区","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻效率","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻篮板数","场均防守篮板数","场均篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	JScrollPane pane6;
	MyTable table6;
	DefaultTableModel model6;
	String[] columnNames6 = {"西南区","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻效率","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻篮板数","场均防守篮板数","场均篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	JScrollPane pane7;
	MyTable table7;
	DefaultTableModel model7;
	String[] columnNames7 = {"西北区","球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻效率","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻篮板数","场均防守篮板数","场均篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	JScrollPane pane8;
	MyTable table8;
	DefaultTableModel model8;
	String[] columnNames8 = {"太平洋区","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻效率","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻篮板数","场均防守篮板数","场均篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
	JScrollPane pane9;
	MyTable table9;
	DefaultTableModel model9;
	String[] columnNames9 = {"球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻效率","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻篮板数","场均防守篮板数","场均篮板数","场均助攻数","场均抢断数","场均盖帽数","场均失误数","场均犯规数","场均得分"};
*/
	JLabel rankingBand = new JLabel(Img.RANKINGBAND);
	JRadioButton jrb1 = new JRadioButton("西部");
	JRadioButton jrb2 = new JRadioButton("东部");
	JRadioButton jrb3 = new JRadioButton("西南区");
	JRadioButton jrb4 = new JRadioButton("西北区");
	JRadioButton jrb5 = new JRadioButton("太平洋区");
	JRadioButton jrb6 = new JRadioButton("东南区");
	JRadioButton jrb7 = new JRadioButton("中部区");
	JRadioButton jrb8 = new JRadioButton("大西洋区");
	JLabel jl = new JLabel("赛季热点:");
	ButtonGroup group = new ButtonGroup();
	JComboBox<String> type = new JComboBox<String>();
	JComboBox<String> term = new JComboBox<String>();
	JButton descending = new JButton("降序");
	JButton ascending = new JButton("升序");
	JButton search = new JButton("查询");
	Font font1 = new Font("黑体", Font.BOLD, 16);
	public Ranking(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
		

		
		this.add(jrb1);
		jrb1.setBounds(30, 165, 90, 20);
		jrb1.setFont(font1);
        jrb1.addActionListener(this);
        jrb1.setActionCommand("west");
		this.add(jrb2);
		jrb2.setBounds(30, 185, 90, 20);
		jrb2.setFont(font1);
        jrb2.addActionListener(this);
        jrb2.setActionCommand("east");
		this.add(jrb3);
		jrb3.setBounds(120, 165, 90, 20);
		jrb3.setFont(font1);
		jrb3.addActionListener(this);
		jrb3.setActionCommand("southwest");
		this.add(jrb4);
		jrb4.setBounds(210, 165, 90, 20);
		jrb4.setFont(font1);
		jrb4.addActionListener(this);
		jrb4.setActionCommand("northwest");
		this.add(jrb5);
		jrb5.setBounds(300, 165, 95, 20);
		jrb5.setFont(font1);
		jrb5.addActionListener(this);
		jrb5.setActionCommand("pacific");
		this.add(jrb6);
		jrb6.setBounds(120, 185, 90, 20);
		jrb6.setFont(font1);
		jrb6.addActionListener(this);
		jrb6.setActionCommand("southeast");
		this.add(jrb7);
		jrb7.setBounds(210, 185, 90, 20);
		jrb7.setFont(font1);
		jrb7.addActionListener(this);
		jrb7.setActionCommand("central");
		this.add(jrb8);
		jrb8.setBounds(300, 185, 95, 20);
		jrb8.setFont(font1);
		jrb8.addActionListener(this);
		jrb8.setActionCommand("atlantic");
		group.add(jrb1);
		group.add(jrb2);
		group.add(jrb3);
		group.add(jrb4);
		group.add(jrb5);
		group.add(jrb6);
		group.add(jrb7);
		group.add(jrb8);

		
        type.addItem("胜率");
        type.addItem("球队名称");
        type.addItem("场次");
        type.addItem("投篮命中数");
        type.addItem("投篮出手数");
        type.addItem("三分命中数");
        type.addItem("三分出手数");
        type.addItem("罚球命中数");
        type.addItem("罚球出手数");
        type.addItem("进攻篮板数");
        type.addItem("防守篮板数");
        type.addItem("篮板数");
        type.addItem("助攻数");
        type.addItem("抢断数");
        type.addItem("盖帽数");
        type.addItem("失误数");
        type.addItem("犯规数");
        type.addItem("比赛得分");
        type.addItem("投篮命中率");
        type.addItem("三分命中率");
        type.addItem("罚球命中率");
        type.addItem("进攻回合");
        type.addItem("进攻效率");
        type.addItem("防守效率");
        type.addItem("进攻篮板效率");
        type.addItem("防守篮板效率");
        type.addItem("抢断效率");
        type.addItem("助攻效率");
        this.add(type);
        type.setBounds(750, 160, 110, 20);
        type.setFont(font1);
        
        this.add(descending);
        descending.setBounds(880, 157, 60, 25);
        descending.addActionListener(this);
        descending.setActionCommand("descending");
        descending.setUI(new MyButtonUI());
        
        this.add(ascending);
        ascending.setBounds(950, 157, 60, 25);
        ascending.addActionListener(this);
        ascending.setActionCommand("ascending");
        ascending.setUI(new MyButtonUI());
		
	    term.removeAllItems();			
		term.addItem("场均得分");
		term.addItem("场均篮板");
		term.addItem("场均助攻");
		term.addItem("场均盖帽");
	    term.addItem("场均抢断");
		term.addItem("三分命中率");
		term.addItem("投篮命中率");
		term.addItem("罚球命中率");
		  
	    this.add(term);
	    term.setBounds(830, 190, 100, 20);
	    term.setFont(font1);
	    this.add(jl);
	    jl.setBounds(750, 190, 80, 20);
	    jl.setFont(font1);
	    
        this.add(search);
        search.setBounds(950, 187, 60, 25);
        search.addActionListener(this);
        search.setActionCommand("search");
        search.setUI(new MyButtonUI());
        
		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 70);
		
		
        Object[][] data= getData(trs.getAllTeamdata("13-14","wins", "DESC"));
	    model1 = new DefaultTableModel(new Object[][]{},columnNames1);
	    model1.setDataVector(data, columnNames1);
	    table1 = new MyTable(model1);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane1 = new JScrollPane (table1);
	    this.add(pane1);
	    pane1.setBounds(0, 220, 1052, 430);
	    
    /*    Object[][] data2 = getData(trs.getTeamData("`east/west`='E'", "wins", "DESC"));
	    model2 = new DefaultTableModel(new Object[][]{},columnNames2);
	    model2.setDataVector(data2, columnNames2);
	    table2 = new MyTable(model2);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane2 = new JScrollPane (table2);
	    this.add(pane2);
	    pane2.setBounds(0, 435, 1052, 215);
	    
        Object[][] data3 = getData(trs.getTeamData("`partition`='Southeast'", "wins", "DESC"));
	    model3 = new DefaultTableModel(new Object[][]{},columnNames3);
	    model3.setDataVector(data3, columnNames3);
	    table3 = new MyTable(model3);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane3 = new JScrollPane (table3);
	    this.add(pane3);
	    pane3.setBounds(0, 220, 526, 143);
	    
        Object[][] data4 = getData(trs.getTeamData("`partition`='Atlantic'", "wins", "DESC"));
	    model4 = new DefaultTableModel(new Object[][]{},columnNames4);
	    model4.setDataVector(data4, columnNames4);
	    table4 = new MyTable(model4);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane4 = new JScrollPane (table4);
	    this.add(pane4);
	    pane4.setBounds(0, 363, 526, 143);
	    
        Object[][] data5 = getData(trs.getTeamData("`partition`='Central'", "wins", "DESC"));
	    model5 = new DefaultTableModel(new Object[][]{},columnNames5);
	    model5.setDataVector(data5, columnNames5);
	    table5 = new MyTable(model5);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane5 = new JScrollPane (table5);
	    this.add(pane5);
	    pane5.setBounds(0, 506, 526, 144);
	    
        Object[][] data6 = getData(trs.getTeamData("`partition`='Southwest'", "wins", "DESC"));
	    model6 = new DefaultTableModel(new Object[][]{},columnNames6);
	    model6.setDataVector(data6, columnNames6);
	    table6 = new MyTable(model6);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane6 = new JScrollPane (table6);
	    this.add(pane6);
	    pane6.setBounds(526, 220, 526, 143);
	    
        Object[][] data7 = getData(trs.getTeamData("`partition`='Northwest'", "wins", "DESC"));
	    model7 = new DefaultTableModel(new Object[][]{},columnNames7);
	    model7.setDataVector(data7, columnNames7);
	    table7 = new MyTable(model7);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane7 = new JScrollPane (table7);
	    this.add(pane7);
	    pane7.setBounds(526, 363, 526, 143);
	    
        Object[][] data8 = getData(trs.getTeamData("`partition`='Pacific'", "wins", "DESC"));
	    model8 = new DefaultTableModel(new Object[][]{},columnNames8);
	    model8.setDataVector(data8, columnNames8);
	    table8 = new MyTable(model8);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane8 = new JScrollPane (table8);
	    this.add(pane8);
	    pane8.setBounds(526, 506, 526, 144);
	    
        Object[][] data9 = null;
	    model9 = new DefaultTableModel(new Object[][]{},columnNames9);
	    model9.setDataVector(data9, columnNames9);
	    table9 = new MyTable(model9);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane9 = new JScrollPane (table9);
	    this.add(pane9);
	    pane9.setBounds(0, 220, 1052, 430);*/
	}

    public Object[][] getData(ArrayList<TeamVO> teams){
    	int num = teams.size();
    	Object[][] data = new Object[num][];
		for(int i = 0;i<num;i++){
			Object[] temp = {teams.get(i).getTeamName(),teams.get(i).getMatches(),teams.get(i).getFieldGoal(),teams.get(i).getFieldGoalAttempts(),teams.get(i).getThreePointFieldGoal(),teams.get(i).getThreePointFieldGoalAttempts(),teams.get(i).getFreeThrow(),teams.get(i).getFreeThrowAttempts(),teams.get(i).getOffensiveRebound(),teams.get(i).getDefensiveRebound(),teams.get(i).getBackboard(),teams.get(i).getAssist(),teams.get(i).getSteal(),teams.get(i).getBlock(),teams.get(i).getTurnOver(),teams.get(i).getFoul(),teams.get(i).getScoring(),teams.get(i).getFieldGoalPercentage(),teams.get(i).getThreePointShotPercentage(),teams.get(i).getFreeThrowPercentage(),teams.get(i).getWinningPercentage(),teams.get(i).getPossessions(),teams.get(i).getOffensiveEfficiency(),teams.get(i).getDefensiveEfficiency(),teams.get(i).getOffensivebackboardEfficiency(),teams.get(i).getDefensivebackboardEfficiency(),teams.get(i).getStealEfficiency(),teams.get(i).getAssitEfficiency(),teams.get(i).getAverageFieldGoal(),teams.get(i).getAverageFieldGoalAttempts(),teams.get(i).getAverageThreePointFieldGoal(),teams.get(i).getAverageThreePointFieldGoalAttempts(),teams.get(i).getAverageFreeThrow(),teams.get(i).getAverageFreeThrowAttempts(),teams.get(i).getAverageOffensiveRebound(),teams.get(i).getAverageDefensiveRebound(),teams.get(i).getAverageBackboard(),teams.get(i).getAverageAsist(),teams.get(i).getAverageSteal(),teams.get(i).getAverageBlock(),teams.get(i).getAverageTurnOver(),teams.get(i).getAverageFoul(),teams.get(i).getAverageScoring()};
		    data[i] = temp;
		}
		return data;
    }
    
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("west")){
			/*pane1.setVisible(true);
			pane2.setVisible(true);*/
			Object[][] data = getData(trs.getTeamData("13-14","`east/west`='W'", "wins", "DESC"));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
		if(e.getActionCommand().equals("east")){
		/*	pane1.setVisible(false);
			pane2.setVisible(false);
			pane3.setVisible(true);
			pane4.setVisible(true);
			pane5.setVisible(true);
			pane6.setVisible(true);
			pane7.setVisible(true);
			pane8.setVisible(true);*/
			Object[][] data = getData(trs.getTeamData("13-14","`east/west`='E'", "wins", "DESC"));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
		if(e.getActionCommand().equals("southwest")){
			Object[][] data = getData(trs.getTeamData("13-14","`partition`='Southwest'", "wins", "DESC"));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
		if(e.getActionCommand().equals("northwest")){
			Object[][] data = getData(trs.getTeamData("13-14","`partition`='Northwest'", "wins", "DESC"));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
		if(e.getActionCommand().equals("pacific")){
			Object[][] data = getData(trs.getTeamData("13-14","`partition`='Pacific'", "wins", "DESC"));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
		if(e.getActionCommand().equals("southeast")){
			Object[][] data = getData(trs.getTeamData("13-14","`partition`='Southeast'", "wins", "DESC"));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
		if(e.getActionCommand().equals("central")){
			Object[][] data = getData(trs.getTeamData("13-14","`partition`='Central'", "wins", "DESC"));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
		if(e.getActionCommand().equals("atlantic")){
			Object[][] data = getData(trs.getTeamData("13-14","`partition`='Atlantic'", "wins", "DESC"));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
		if(e.getActionCommand().equals("home")||e.getActionCommand().equals("back")){
			frame.change(this, frame.mainFrame);
		}
		if(e.getActionCommand().equals("descending")){
			/*pane1.setVisible(false);
			pane2.setVisible(false);
			pane3.setVisible(false);
			pane4.setVisible(false);
			pane5.setVisible(false);
			pane6.setVisible(false);
			pane7.setVisible(false);
			pane8.setVisible(false);
			jrb1.setSelected(false);
			jrb2.setSelected(false);*/
			Object[][] data = getData(trs.getAllTeamdata("13-14",Translate.translate1(type.getSelectedItem().toString()), "DESC"));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
		if(e.getActionCommand().equals("ascending")){
			/*pane1.setVisible(false);
			pane2.setVisible(false);
			pane3.setVisible(false);
			pane4.setVisible(false);
			pane5.setVisible(false);
			pane6.setVisible(false);
			pane7.setVisible(false);
			pane8.setVisible(false);
			jrb1.setSelected(false);
			jrb2.setSelected(false);*/
			Object[][] data = getData(trs.getAllTeamdata("13-14",Translate.translate1(type.getSelectedItem().toString()), "ASC"));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
		
		
	}

}
