package ui.match;


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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.teambl.TeamRank;
import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyButton;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;
import ui.tools.Translate;
import vo.TeamMatchVO;
import vo.TeamVO;

@SuppressWarnings("serial")
public class Matches extends MyPanel implements ActionListener{
	TeamRankService trs = new TeamRank();
	Frame frame;
	JScrollPane pane1;
	MyTable table1;
	DefaultTableModel model1;
	String[] columnNames1 = {"日期","场次","投篮命中数","投篮出手数","三分命中数","三分出手数"};

	JLabel rankingBand = new JLabel(Img.RANKINGBAND);

	JComboBox<String> team = new JComboBox<String>();
	JComboBox<String> month = new JComboBox<String>();
	JComboBox<String> season = new JComboBox<String>();
	JButton search = new JButton("查询");

	Font font1 = new Font("黑体", Font.BOLD, 16);
	public Matches(Frame frame) {
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
		
		
		team.addItem("圣安东尼奥马刺");
		team.addItem("孟菲斯灰熊");
		team.addItem("达拉斯小牛");
		team.addItem("休斯顿火箭");
		team.addItem("新奥尔良鹈鹕");
        team.addItem("明尼苏达森林狼");
        team.addItem("丹佛掘金");
        team.addItem("尤他爵士");
        team.addItem("波特兰开拓者");
        team.addItem("俄克拉荷马雷霆");
        team.addItem("萨克拉门托国王");
        team.addItem("菲尼克斯太阳");
        team.addItem("洛杉矶湖人");
        team.addItem("洛杉矶快船");
        team.addItem("金州勇士");
        team.addItem("迈阿密热");
        team.addItem("奥兰多魔术");
        team.addItem("亚特兰大老鹰");
        team.addItem("华盛顿奇才");
        team.addItem("夏洛特黄蜂");
        team.addItem("底特律活塞");
        team.addItem("印第安纳步行者");
        team.addItem("克里夫兰骑士");
        team.addItem("芝加哥公牛");
        team.addItem("密尔沃基雄鹿");
        team.addItem("波士顿凯尔特人");
        team.addItem("费城76人");
        team.addItem("纽约尼克斯");
        team.addItem("布鲁克林篮网");
        team.addItem("多伦多猛龙");
        
        this.add(season);
        season.setBounds(575, 175, 70, 20);
        season.setFont(font1);
        
        this.add(month);
        month.setBounds(670, 175, 60, 20);
        month.setFont(font1);
        
        this.add(team);
        team.setBounds(750, 175, 150, 20);
        team.setFont(font1);
        
        this.add(search);
        search.setBounds(920, 172, 60, 25);
        search.addActionListener(this);
        search.setActionCommand("search");

		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 70);
		
		
        Object[][] data = null;
	    model1 = new DefaultTableModel(new Object[][]{},columnNames1);
	    model1.setDataVector(data, columnNames1);
	    table1 = new MyTable(model1);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane1 = new JScrollPane (table1);
	    this.add(pane1);
	    pane1.setBounds(0, 220, 1052, 430);
	
	}

    public Object[][] getData(ArrayList<TeamMatchVO> matches){
    	int num = matches.size();
    	Object[][] data = new Object[num][];
		for(int i = 0;i<num;i++){
			Object[] temp = {matches.get(i).getDate(),matches.get(i).getName(),matches.get(i).getOpponent(),matches.get(i).getTotal()};
		    data[i] = temp;
		}
		return data;
    }
    
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("home")||e.getActionCommand().equals("back")){
			frame.change(this, frame.mainFrame);
		}
		if(e.getActionCommand().equals("search")){

			Object[][] data = getData(trs.getTeamMonthMatch(season.getSelectedItem().toString().substring(2)+"-"+month.getSelectedItem().toString().substring(0,2),Translate.translate(team.getSelectedItem().toString())));
			model1.setDataVector(data, columnNames1);
		    table1.setWidth();
			table1.updateUI();
		}
	}
}

