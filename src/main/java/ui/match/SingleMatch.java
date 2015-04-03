package ui.match;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import businesslogic.teambl.TeamRank;
import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;
import ui.tools.Translate;
import vo.TeamMatchVO;
import vo.TeamMonthMatchVO;

@SuppressWarnings("serial")
public class SingleMatch extends MyPanel implements ActionListener{
	TeamRankService trs = new TeamRank();
	Frame frame;
	JScrollPane pane1;
	MyTable table1;
	DefaultTableModel model1;
	String[] columnNames1 = {"日期","场次","投篮命中数","投篮出手数","三分命中数","三分出手数"};
	JScrollPane pane2;
	MyTable table2;
	DefaultTableModel model2;
	String[] columnNames2 = {"日期","场次","投篮命中数","投篮出手数","三分命中数","三分出手数"};

	JLabel rankingBand = new JLabel(Img.RANKINGBAND);

	JComboBox<String> team = new JComboBox<String>();
	JComboBox<String> month = new JComboBox<String>();
	JComboBox<String> season = new JComboBox<String>();
	JButton search = new JButton("查询");
	
	JLabel teamIcon1 = new JLabel();
	JLabel teamIcon2 = new JLabel();
	JLabel point1 = new JLabel("0");
	JLabel point2 = new JLabel("0");
	JLabel point1_1 = new JLabel("0");
	JLabel point2_1 = new JLabel("0");
	JLabel point1_2 = new JLabel("0");
	JLabel point2_2 = new JLabel("0");
	JLabel point1_3 = new JLabel("0");
	JLabel point2_3 = new JLabel("0");
	JLabel point1_4 = new JLabel("0");
	JLabel point2_4 = new JLabel("0");
	JLabel jl1 = new JLabel("第一节");
	JLabel jl2 = new JLabel("第二节");
	JLabel jl3 = new JLabel("第三节");
	JLabel jl4 = new JLabel("第四节");
	JLabel jl5 = new JLabel("主队");
	JLabel jl6 = new JLabel("客队");

	Font font1 = new Font("黑体", Font.BOLD, 16);
	public SingleMatch(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
		
		this.add(teamIcon1);
		teamIcon1.setBounds(30, 160, 100, 100);
		this.add(teamIcon2);
		teamIcon2.setBounds(922, 160, 100, 100);
		this.add(jl5);
		jl5.setBounds(50, 260, 70, 30);
		this.add(jl6);
		jl6.setBounds(902, 260, 70, 30);
		this.add(point1);
		point1.setBounds(150, 185, 50, 50);
		this.add(point2);
		point2.setBounds(802, 185, 50, 50);
		this.add(jl1);
		jl1.setBounds(300, 165, 100, 30);
		this.add(jl2);
		jl2.setBounds(400, 165, 100, 30);
		this.add(jl3);
		jl3.setBounds(500, 165, 100, 30);
		this.add(jl4);
		jl4.setBounds(600, 165, 100, 30);
		
		this.add(point1_1);
		point1_1.setBounds(300, 205, 100, 30);
		this.add(point1_2);
		point1_2.setBounds(400, 205, 100, 30);
		this.add(point1_3);
		point1_3.setBounds(500, 205, 100, 30);
		this.add(point1_4);
		point1_4.setBounds(600, 205, 100, 30);
		
		this.add(point2_1);
		point2_1.setBounds(300, 245, 100, 30);
		this.add(point2_2);
		point2_2.setBounds(400, 245, 100, 30);
		this.add(point2_3);
		point2_3.setBounds(500, 245, 100, 30);
		this.add(point2_4);
		point2_4.setBounds(600, 245, 100, 30);
		
		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 70);
		
		
        Object[][] data1 = null;
	    model1 = new DefaultTableModel(new Object[][]{},columnNames1);
	    model1.setDataVector(data1, columnNames1);
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
	
	}
	
	public void update(){
		
	}

    public Object[][] getData(ArrayList<TeamMonthMatchVO> matches){
    	int num = matches.size();
    	Object[][] data = new Object[num][];
		for(int i = 0;i<num;i++){
			Object[] temp = {matches.get(i).getDate()};
		    data[i] = temp;
		}
		return data;
    }
    
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("home")){
			frame.change(this, frame.mainFrame);
		}
		if(e.getActionCommand().equals("back")){
			frame.change(this, frame.matchesPanel);
		}
		if(e.getActionCommand().equals("search")){

			Object[][] data = getData(trs.getTeamMonthMatch(season.getSelectedItem().toString().substring(2)+"-"+month.getSelectedItem().toString().substring(0,2),Translate.translate(team.getSelectedItem().toString())));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
	}
}

