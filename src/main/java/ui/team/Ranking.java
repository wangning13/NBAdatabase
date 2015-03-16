package ui.team;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyButton;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;

@SuppressWarnings("serial")
public class Ranking extends MyPanel implements ActionListener{
	Frame frame;
	JScrollPane pane1;
	MyTable table1;
	DefaultTableModel model1;
	String[] columnNames1 = {"西部排名","球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻效率"};
	JScrollPane pane2;
	MyTable table2;
	DefaultTableModel model2;
	String[] columnNames2 = {"东部排名","球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻效率"};
	JScrollPane pane3;
	MyTable table3;
	DefaultTableModel model3;
	String[] columnNames3 = {"东南区排名","球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻效率"};
	JScrollPane pane4;
	MyTable table4;
	DefaultTableModel model4;
	String[] columnNames4 = {"大西洋区排名","球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻效率"};
	JScrollPane pane5;
	MyTable table5;
	DefaultTableModel model5;
	String[] columnNames5 = {"中部区排名","球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻效率"};
	JScrollPane pane6;
	MyTable table6;
	DefaultTableModel model6;
	String[] columnNames6 = {"西南区排名","球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻效率"};
	JScrollPane pane7;
	MyTable table7;
	DefaultTableModel model7;
	String[] columnNames7 = {"西北区排名","球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻效率"};
	JScrollPane pane8;
	MyTable table8;
	DefaultTableModel model8;
	String[] columnNames8 = {"太平洋区排名","球队名称","场次","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分","投篮命中率","三分命中率","罚球命中率","胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻效率"};

	JLabel rankingBand = new JLabel(Img.RANKINGBAND);
	JRadioButton jrb1 = new JRadioButton("联盟排名");
	JRadioButton jrb2 = new JRadioButton("分区排名");
	ButtonGroup group = new ButtonGroup();
	JComboBox<String> type = new JComboBox<String>();
	JButton descending = new JButton("降序");
	JButton ascending = new JButton("升序");
	Font font1 = new Font("黑体", Font.BOLD, 16);
	public Ranking(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
		

		
		this.add(jrb1);
		jrb1.setBounds(30, 175, 95, 20);
		jrb1.setFont(font1);
		jrb1.setSelected(true);
        jrb1.addActionListener(this);
        jrb1.setActionCommand("league");
		this.add(jrb2);
		jrb2.setBounds(150, 175, 95, 20);
		jrb2.setFont(font1);
        jrb2.addActionListener(this);
        jrb2.setActionCommand("area");
		group.add(jrb1);
		group.add(jrb2);
		

		
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
        type.addItem("篮板效率");
        type.addItem("抢断效率");
        type.addItem("助攻效率");
        this.add(type);
        type.setBounds(750, 175, 110, 20);
        type.setFont(font1);
        
        this.add(descending);
        descending.setBounds(880, 172, 60, 25);
        descending.addActionListener(this);
        descending.setActionCommand("descending");
        
        this.add(ascending);
        ascending.setBounds(950, 172, 60, 25);
        ascending.addActionListener(this);
        ascending.setActionCommand("ascending");
		
		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 70);
		
		
        Object[][] data = null;
	    model1 = new DefaultTableModel(new Object[][]{},columnNames1);
	    model1.setDataVector(data, columnNames1);
	    table1 = new MyTable(model1);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane1 = new JScrollPane (table1);
	    this.add(pane1);
	    pane1.setBounds(0, 220, 1052, 215);
	    
        Object[][] data2 = null;
	    model2 = new DefaultTableModel(new Object[][]{},columnNames2);
	    model2.setDataVector(data2, columnNames2);
	    table2 = new MyTable(model2);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane2 = new JScrollPane (table2);
	    this.add(pane2);
	    pane2.setBounds(0, 435, 1052, 215);
	    
        Object[][] data3 = null;
	    model3 = new DefaultTableModel(new Object[][]{},columnNames3);
	    model3.setDataVector(data3, columnNames3);
	    table3 = new MyTable(model3);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane3 = new JScrollPane (table3);
	    this.add(pane3);
	    pane3.setBounds(0, 220, 526, 143);
	    
        Object[][] data4 = null;
	    model4 = new DefaultTableModel(new Object[][]{},columnNames4);
	    model4.setDataVector(data4, columnNames4);
	    table4 = new MyTable(model4);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane4 = new JScrollPane (table4);
	    this.add(pane4);
	    pane4.setBounds(0, 363, 526, 143);
	    
        Object[][] data5 = null;
	    model5 = new DefaultTableModel(new Object[][]{},columnNames5);
	    model5.setDataVector(data5, columnNames5);
	    table5 = new MyTable(model5);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane5 = new JScrollPane (table5);
	    this.add(pane5);
	    pane5.setBounds(0, 506, 526, 144);
	    
        Object[][] data6 = null;
	    model6 = new DefaultTableModel(new Object[][]{},columnNames6);
	    model6.setDataVector(data6, columnNames6);
	    table6 = new MyTable(model6);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane6 = new JScrollPane (table6);
	    this.add(pane6);
	    pane6.setBounds(526, 220, 526, 143);
	    
        Object[][] data7 = null;
	    model7 = new DefaultTableModel(new Object[][]{},columnNames7);
	    model7.setDataVector(data7, columnNames7);
	    table7 = new MyTable(model7);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane7 = new JScrollPane (table7);
	    this.add(pane7);
	    pane7.setBounds(526, 363, 526, 143);
	    
        Object[][] data8 = null;
	    model8 = new DefaultTableModel(new Object[][]{},columnNames8);
	    model8.setDataVector(data8, columnNames8);
	    table8 = new MyTable(model8);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane8 = new JScrollPane (table8);
	    this.add(pane8);
	    pane8.setBounds(526, 506, 526, 144);

	}
	
    public void	initial(){
 
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("league")){
			pane1.setVisible(true);
			pane2.setVisible(true);
		}
		if(e.getActionCommand().equals("area")){
			pane1.setVisible(false);
			pane2.setVisible(false);
		}
		if(e.getActionCommand().equals("home")||e.getActionCommand().equals("back")){
			frame.change(this, frame.mainFrame);
		}
		if(e.getActionCommand().equals("descending")){

		}
		if(e.getActionCommand().equals("ascending")){

		}
		
		
	}

}
