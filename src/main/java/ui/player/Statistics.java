package ui.player;

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

import ui.main.Frame;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;

@SuppressWarnings("serial")
public class Statistics extends MyPanel implements ActionListener{
	Frame frame;
	JScrollPane pane;
	MyTable table;
	DefaultTableModel model;
	String[] columnNames = {"球员名称","所属球队","参赛场数","先发场数","篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率","进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率","GmSc效率值","真是命中率","投篮效率","篮板率","进攻篮板率","防守篮板率","助攻率","抢断率","盖帽率","失误率","使用率"};
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
        type.addItem("真是命中率");
        type.addItem("投篮效率");
        type.addItem("篮板率");
        type.addItem("进攻篮板率");
        type.addItem("防守篮板率");
        type.addItem("助攻率");
        type.addItem("抢断率");
        type.addItem("盖帽率");
        type.addItem("失误率");
        type.addItem("使用率");
        posision.addItem("前锋");
        posision.addItem("中锋");
        posision.addItem("后卫");
        area.addItem("东部");
        area.addItem("西部");
        area.addItem("东南区");
        area.addItem("大西洋区");
        area.addItem("中部区");
        area.addItem("西南区");
        area.addItem("西北区");
        area.addItem("太平洋区");
		term.addItem("得分");
		term.addItem("篮板");
		term.addItem("助攻");
		term.addItem("得分/篮板/助攻");
		term.addItem("盖帽");
		term.addItem("抢断");
		term.addItem("犯规");
		term.addItem("失误");
		term.addItem("分钟");
		term.addItem("效率");
		term.addItem("投篮");
		term.addItem("三分");
		term.addItem("罚球");
		term.addItem("两双");
		
        this.add(jl1);
        jl1.setBounds(20, 175, 180, 20);
        jl1.setFont(font1);
        
        this.add(type);
        type.setBounds(150, 175, 110, 20);
        type.setFont(font1);
        
        this.add(descending);
        descending.setBounds(270, 172, 60, 25);
        
        this.add(ascending);
        ascending.setBounds(340, 172, 60, 25);
        
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
		
		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 70);
		
        Object[][] data = null;
	    model = new DefaultTableModel(new Object[][]{},columnNames);
	    model.setDataVector(data, columnNames);
	    table = new MyTable(model);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane = new JScrollPane (table);
	    this.add(pane);
	    pane.setBounds(0, 220, 1052, 430);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("home")||e.getActionCommand().equals("back")){
			frame.change(this, frame.mainFrame);
		}
		
	}

}

