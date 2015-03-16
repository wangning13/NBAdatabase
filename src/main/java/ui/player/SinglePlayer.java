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

import ui.main.Frame;
import ui.main.MyButton;
import ui.main.MyPanel;
import ui.material.Img;
import ui.tools.MyTable;

@SuppressWarnings("serial")
public class SinglePlayer extends MyPanel implements ActionListener{
	Frame frame;
	JScrollPane pane;
	MyTable table;
	DefaultTableModel model;
	String[] columnNames = {"西南区","西北区","太平洋区","东南区","中区","大西洋区"};

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
		name.setBounds(100, 330, 100, 30);
		name.setFont(font1);
		this.add(number);
		number.setBounds(100, 365, 100, 30);
		number.setFont(font1);
		this.add(position);
		position.setBounds(100, 400, 100, 30);
		position.setFont(font1);
		this.add(height);
		height.setBounds(100, 435, 100, 30);
		height.setFont(font1);
		this.add(weight);
		weight.setBounds(100, 470, 100, 30);
		weight.setFont(font1);
		this.add(birth);
		birth.setBounds(100, 505, 100, 30);
		birth.setFont(font1);
		this.add(age);
		age.setBounds(100, 540, 100, 30);
		age.setFont(font1);
		this.add(exp);
		exp.setBounds(100, 575, 100, 30);
		exp.setFont(font1);
		this.add(school);
		school.setBounds(100, 610, 100, 30);
		school.setFont(font1);
		
		this.add(board);
		board.setBounds(0, 150, 250, 500);
		
        Object[][] data = null;
	    model = new DefaultTableModel(new Object[][]{},columnNames);
	    model.setDataVector(data, columnNames);
	    table = new MyTable(model);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane = new JScrollPane (table);
	    this.add(pane);
	    pane.setBounds(250, 150, 802, 500);
	   
	}
	
	public void update(String name){
		playerIcon.setIcon(Img.load(name));
		
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
