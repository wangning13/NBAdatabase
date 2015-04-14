package ui.match;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import businesslogic.playerbl.PlayerRank;
import businesslogicservice.playerblservice.PlayerRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;
import vo.PlayerMatchVO;
import vo.TeamMonthMatchVO;

@SuppressWarnings("serial")
public class SingleMatch extends MyPanel implements ActionListener{
	PlayerRankService prs = new PlayerRank();
	public boolean flag = false;
	Frame frame;
	JScrollPane pane1;
	MyTable table1;
	DefaultTableModel model1;
	String[] columnNames1 = {"主队","上场时间","得分","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","盖帽数","犯规数","抢断数","失误数"};
	JScrollPane pane2;
	MyTable table2;
	DefaultTableModel model2;
	String[] columnNames2 = {"客队","位置","上场时间","得分","投篮命中数","投篮出手数","三分命中数","三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数","盖帽数","犯规数","抢断数","失误数"};

	JLabel rankingBand = new JLabel(Img.MATCHBAND);

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
	//JLabel jl7 = new JLabel("主队");
	//JLabel jl8 = new JLabel("客队");

	Font font1 = new Font("黑体", Font.BOLD, 16);
	public SingleMatch(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
		
		this.add(teamIcon1);
		teamIcon1.setBounds(30, 150, 100, 100);
		this.add(teamIcon2);
		teamIcon2.setBounds(922, 150, 100, 100);
		this.add(jl5);
		jl5.setBounds(200, 150, 70, 30);
		jl5.setFont(font1);
		this.add(jl6);
		jl6.setBounds(820, 150, 70, 30);
		jl6.setFont(font1);
		this.add(point1);
		point1.setBounds(202, 175, 50, 50);
		point1.setFont(font1);
		this.add(point2);
		point2.setBounds(823, 175, 50, 50);
		point2.setFont(font1);
		this.add(jl1);
		jl1.setBounds(310, 150, 100, 30);
		jl1.setFont(font1);
		this.add(jl2);
		jl2.setBounds(440, 150, 100, 30);
		jl2.setFont(font1);
		this.add(jl3);
		jl3.setBounds(570, 150, 100, 30);
		jl3.setFont(font1);
		this.add(jl4);
		jl4.setBounds(700, 150, 100, 30);
		jl4.setFont(font1);
		
		this.add(point1_1);
		point1_1.setBounds(325, 190, 100, 30);
		point1_1.setFont(font1);
		this.add(point1_2);
		point1_2.setBounds(455, 190, 100, 30);
		point1_2.setFont(font1);
		this.add(point1_3);
		point1_3.setBounds(585, 190, 100, 30);
		point1_3.setFont(font1);
		this.add(point1_4);
		point1_4.setBounds(715, 190, 100, 30);
		point1_4.setFont(font1);
		
		this.add(point2_1);
		point2_1.setBounds(325, 220, 100, 30);
		point2_1.setFont(font1);
		this.add(point2_2);
		point2_2.setBounds(455, 220, 100, 30);
		point2_2.setFont(font1);
		this.add(point2_3);
		point2_3.setBounds(585, 220, 100, 30);
		point2_3.setFont(font1);
		this.add(point2_4);
		point2_4.setBounds(715, 220, 100, 30);
		point2_4.setFont(font1);
		
		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 100);
		
	/*	this.add(jl7);
		jl7.setBounds(0, 220, 1052, 50);
		this.add(jl8);
		jl8.setBounds(0, 435, 1052, 50);*/
		
		
        Object[][] data1 = null;
	    model1 = new DefaultTableModel(new Object[][]{},columnNames1);
	    model1.setDataVector(data1, columnNames1);
	    table1 = new MyTable(model1);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane1 = new JScrollPane (table1);
	    this.add(pane1);
	    pane1.setBounds(0, 250, 1052, 200);
	    
        Object[][] data2 = null;
	    model2 = new DefaultTableModel(new Object[][]{},columnNames2);
	    model2.setDataVector(data2, columnNames2);
	    table2 = new MyTable(model2);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane2 = new JScrollPane (table2);
	    this.add(pane2);
	    pane2.setBounds(0, 450, 1052, 200);
	
	}
	
	public void update(TeamMonthMatchVO temp){
		ArrayList<PlayerMatchVO> hostPlayers = prs.getPlayerMatchdata(temp.getDate(),temp.getHost());
		ArrayList<PlayerMatchVO> guestPlayers = prs.getPlayerMatchdata(temp.getDate(),temp.getGuest());
		ImageIcon icon = Img.loadTeam(temp.getHost());
		icon.setImage(icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)); 
		teamIcon1.setIcon(icon);
		
		icon = Img.loadTeam(temp.getGuest());
		icon.setImage(icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT)); 
		teamIcon2.setIcon(icon);
		
		Object[][] data1 = getData(hostPlayers);
		model1.setDataVector(data1, columnNames1);
	    table1.setWidth();
		table1.updateUI();
		
		Object[][] data2 = getData(guestPlayers);
		model2.setDataVector(data2, columnNames2);
	    table2.setWidth();
		table2.updateUI();
		
		
		String score[] = temp.getScore().split("-");
		String first[] = temp.getFirst().split("-");
		String second[] = temp.getSecond().split("-");
		String third[] = temp.getThird().split("-");
		String fourth[] = temp.getFourth().split("-");
		
		point1.setText(score[0]);
		point2.setText(score[1]);
		point1_1.setText(first[0]);
		point2_1.setText(first[1]);
		point1_2.setText(second[0]);
		point2_2.setText(second[1]);
		point1_3.setText(third[0]);
		point2_3.setText(third[1]);
		point1_4.setText(fourth[0]);
		point2_4.setText(fourth[1]);

		
	}

    public Object[][] getData(ArrayList<PlayerMatchVO> matches){
    	int num = matches.size();
    	Object[][] data = new Object[num][];
		for(int i = 0;i<num;i++){
			Object[] temp = {matches.get(i).getPlayername(),matches.get(i).getMinutes(),matches.get(i).getScoring(),matches.get(i).getFieldGoal(),matches.get(i).getFieldGoalAttempts(),matches.get(i).getThreepointFieldGoal(),matches.get(i).getThreepointFieldGoalAttempts(),matches.get(i).getFreeThrow(),matches.get(i).getFreeThrowAttempts(),matches.get(i).getOffensiveRebound(),matches.get(i).getDefensiveRebound(),matches.get(i).getBackboard(),matches.get(i).getAssist(),matches.get(i).getBlock(),matches.get(i).getFoul(),matches.get(i).getSteal(),matches.get(i).getTurnOver()};
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
			if(!flag)
			    frame.change(this, frame.matchesPanel);
			else
				frame.change(this, frame.singleTeamPanel);
		}

	}
	
}

