package ui.player;

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
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businesslogic.playerbl.PlayerRank;
import businesslogic.teambl.TeamRank;
import businesslogicservice.playerblservice.PlayerRankService;
import businesslogicservice.teamblservice.TeamRankService;
import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;
import ui.tools.Translate;
import vo.PlayerVO;
import vo.TeamVO;

@SuppressWarnings("serial")
public class Statistics extends MyPanel implements ActionListener{
	PlayerRankService prs = new PlayerRank();
	Frame frame;
	JScrollPane pane;
	MyTable table;
	DefaultTableModel model;
	String[] columnNames = {"球员名称","所属球队","参赛场数","先发场数","篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率","进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率","GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率","失误率","使用率","场均得分","场均时间","场均篮板","场均助攻","场均投篮命中数","场均投篮出手数","场均三分命中数","场均三分出手数","场均罚球命中数","场均罚球出手数","场均进攻数","场均防守数","场均抢断数","场均盖帽数","场均失误数","场均犯规数"};
	JLabel rankingBand = new JLabel(Img.RANKINGBAND);

	JComboBox<String> type = new JComboBox<String>();
	JButton descending = new JButton("降序");
	JButton ascending = new JButton("升序");
	Font font1 = new Font("黑体", Font.BOLD, 16);
	JLabel jl1 = new JLabel("对所有球员排序：");
	JLabel jl2 = new JLabel("按条件筛选前50名：");
	JComboBox<String> posision = new JComboBox<String>();
	JComboBox<String> area = new JComboBox<String>();
	JComboBox<String> term = new JComboBox<String>();
	JButton filter = new JButton("筛选");
	public Statistics(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
		
        type.addItem("得分");
        type.addItem("球员名称");
        type.addItem("所属球队");
        type.addItem("参赛场数");
        type.addItem("先发场数");
        type.addItem("篮板数");
        type.addItem("助攻数");
        type.addItem("在场时间");
        type.addItem("投篮命中率");
        type.addItem("三分命中率");
        type.addItem("罚球命中率");
        type.addItem("进攻数");
        type.addItem("防守数");
        type.addItem("抢断数");
        type.addItem("盖帽数");
        type.addItem("失误数");
        type.addItem("犯规数");
        type.addItem("效率");
        type.addItem("GmSc效率值");
        type.addItem("真实命中率");
        type.addItem("投篮效率");
        type.addItem("篮板率");
        type.addItem("进攻篮板率");
        type.addItem("防守篮板率");
        type.addItem("助攻率");
        type.addItem("抢断率");
        type.addItem("盖帽率");
        type.addItem("失误率");
        type.addItem("使用率");
        type.setUI(new MyComboBoxUI());
        posision.addItem("前锋");
        posision.addItem("中锋");
        posision.addItem("后卫");
        posision.setUI(new MyComboBoxUI());
        area.addItem("东部");
        area.addItem("西部");
        area.addItem("东南区");
        area.addItem("大西洋区");
        area.addItem("中部区");
        area.addItem("西南区");
        area.addItem("西北区");
        area.addItem("太平洋区");
        area.setUI(new MyComboBoxUI());
		term.addItem("得分");
		term.addItem("篮板");
		term.addItem("助攻");
		term.addItem("得分/篮板/助攻");
		term.addItem("盖帽");
		term.addItem("抢断");
		term.addItem("犯规");
		term.addItem("失误");
		term.addItem("在场时间");
		term.addItem("效率");
		term.addItem("投篮");
		term.addItem("三分");
		term.addItem("罚球");
		term.addItem("两双");
		term.setUI(new MyComboBoxUI());
		
        this.add(jl1);
        jl1.setBounds(20, 175, 180, 20);
        jl1.setFont(font1);
        
        this.add(type);
        type.setBounds(150, 175, 110, 20);
        type.setFont(font1);
        
        this.add(descending);
        descending.setBounds(270, 172, 60, 25);
        descending.addActionListener(this);
        descending.setActionCommand("descending");
        descending.setUI(new MyButtonUI());
        
        this.add(ascending);
        ascending.setBounds(340, 172, 60, 25);
        ascending.addActionListener(this);
        ascending.setActionCommand("ascending");
        ascending.setUI(new MyButtonUI());
        
        this.add(jl2);
        jl2.setBounds(510, 175, 180, 20);
        jl2.setFont(font1);
        
        this.add(posision);
        posision.setBounds(660, 175, 70, 20);
        posision.setFont(font1);

        this.add(area);
        area.setBounds(740, 175, 80, 20);
        area.setFont(font1);
        
        this.add(term);
        term.setBounds(830, 175, 140, 20);
        term.setFont(font1);

        this.add(filter);
        filter.setBounds(980, 172, 60, 25);
        filter.addActionListener(this);
        filter.setActionCommand("filter");
        filter.setUI(new MyButtonUI());
		
		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 70);
		
        Object[][] data = getData(prs.getAllPlayerdata("scoring", "DESC"));
	    model =  new DefaultTableModel(new Object[][]{}, columnNames) {  
	        public Class getColumnClass(int column) {  
	            Class returnValue;  
	            if ((column >= 0) && (column < getColumnCount())) {  
	                returnValue = getValueAt(0, column).getClass();  
	            } else {  
	                returnValue = Object.class;  
	            }  
	            return returnValue;  
	        }  
	    };  
	    RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);  
	    model.setDataVector(data, columnNames);

	    table = new MyTable(model);
	    table.setRowSorter(sorter);  

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane = new JScrollPane (table);
	    this.add(pane);
	    pane.setBounds(0, 220, 1052, 430);
	}
	
    public Object[][] getData(ArrayList<PlayerVO> players){
    	int num = players.size();
    	Object[][] data = new Object[num][];
		for(int i = 0;i<num;i++){
			Object[] temp = {players.get(i).getPlayerName(),players.get(i).getTeam(),players.get(i).getAppearance(),players.get(i).getFirstPlay(),players.get(i).getBackboard(),players.get(i).getAssist(),players.get(i).getMinites(),players.get(i).getFielfGoalShotPercentage(),players.get(i).getThreePointShotPercentage(),players.get(i).getFreeThrowPercentage(),players.get(i).getOffensiveRebound(),players.get(i).getDefensiveRebound(),players.get(i).getSteal(),players.get(i).getBlock(),players.get(i).getTurnOver(),players.get(i).getFoul(),players.get(i).getScoring(),players.get(i).getEfficiency(),players.get(i).getGmScEfficiency(),players.get(i).getTrueShootingPercentage(),players.get(i).getShootingEfficiency(),players.get(i).getBackboardPercentage(),players.get(i).getOffensiveReboundPercentage(),players.get(i).getDefensiveReboundPercentage(),players.get(i).getAssistPercentage(),players.get(i).getStealPercentage(),players.get(i).getBlockPercentage(),players.get(i).getTurnOverPercentage(),players.get(i).getUsage(),players.get(i).getAverageScoring(),players.get(i).getAverageMinute(),players.get(i).getAverageBackboard(),players.get(i).getAverageAssist(),players.get(i).getAverageFieldGoal(),players.get(i).getAverageFieldGoalAttempts(),players.get(i).getAverageThreePointFieldGoal(),players.get(i).getAverageThreePointFieldGoalAttempts(),players.get(i).getAverageFreeThrow(),players.get(i).getAverageFreeThrowAttempts(),players.get(i).getAverageOffensiveRebound(),players.get(i).getAverageDefensiveRebound(),players.get(i).getAverageSteal(),players.get(i).getAverageBlock(),players.get(i).getAverageTurn(),players.get(i).getAverageFoul()};
		    data[i] = temp;
		}
		return data;
    }
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("home")||e.getActionCommand().equals("back")){
			frame.change(this, frame.mainFrame);
		}
		
		if(e.getActionCommand().equals("descending")){	
			 Object[][] data = getData(prs.getAllPlayerdata(Translate.translate1(type.getSelectedItem().toString()), "DESC"));
			 model.setDataVector(data, columnNames);
		     table.setWidth();
			 table.updateUI();
		}
		if(e.getActionCommand().equals("ascending")){
			 Object[][] data = getData(prs.getAllPlayerdata(Translate.translate1(type.getSelectedItem().toString()), "ASC"));
			 model.setDataVector(data, columnNames);
		     table.setWidth();
			 table.updateUI();
		}
		if(e.getActionCommand().equals("filter")){
			 Object[][] data = getData(prs.getFirstFifty(Translate.translate1(posision.getSelectedItem().toString()),Translate.translate1(area.getSelectedItem().toString()),Translate.translate1(term.getSelectedItem().toString())));
			 model.setDataVector(data, columnNames);
		     table.setWidth();
			 table.updateUI();
		}
	}

}

