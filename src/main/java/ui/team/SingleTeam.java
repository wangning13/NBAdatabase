package ui.team;

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
public class SingleTeam extends MyPanel implements ActionListener{
	Frame frame;
	JScrollPane pane1;
	MyTable table1;
	DefaultTableModel model1;
	//JScrollPane pane2;
	//MyTable table2;
	//DefaultTableModel model2;
	String[] columnNames1 = {"西南区","西北区","太平洋区","东南区","中区","大西洋区"};
	//String[] columnNames2 = {"队名","缩写","城市","联盟","分区","主场","进入NBA"};
	//JLabel rankingBand = new JLabel(Img.RANKINGBAND);
    JLabel jl = new JLabel(Img.BOARD);
    JLabel jl1 = new JLabel("队名");
    JLabel jl2 = new JLabel("缩写");
    JLabel jl3 = new JLabel("城市");
    JLabel jl4 = new JLabel("联盟");
    JLabel jl5 = new JLabel("分区");
    JLabel jl6 = new JLabel("主场");
    JLabel jl7 = new JLabel("进入NBA");
    
    JLabel teamName = new JLabel("队名");
    JLabel abbreviation = new JLabel("缩写");
    JLabel city = new JLabel("城市");
    JLabel leagle = new JLabel("联盟");
    JLabel area = new JLabel("分区");
    JLabel home = new JLabel("主场");
    JLabel year = new JLabel("进入NBA");

	Font font1 = new Font("黑体", Font.BOLD, 16);
	JLabel teamIcon = new JLabel(Img.GSW);
	public SingleTeam(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;

		//this.add(rankingBand);
		//rankingBand.setBounds(0, 150, 1052, 120);

		this.add(teamIcon);
		teamIcon.setBounds(50, 155, 220, 220);
		
		this.add(jl1);
		jl1.setBounds(10, 370, 100, 30);
		jl1.setFont(font1);
		this.add(jl2);
		jl2.setBounds(10, 410, 100, 30);
		jl2.setFont(font1);
		this.add(jl3);
		jl3.setBounds(10, 450, 100, 30);
		jl3.setFont(font1);
		this.add(jl4);
		jl4.setBounds(10, 490, 100, 30);
		jl4.setFont(font1);
		this.add(jl5);
		jl5.setBounds(10, 530, 100, 30);
		jl5.setFont(font1);
		this.add(jl6);
		jl6.setBounds(10, 570, 100, 30);
		jl6.setFont(font1);
		this.add(jl7);
		jl7.setBounds(10, 610, 100, 30);
		jl7.setFont(font1);
		
		this.add(teamName);
		teamName.setBounds(100, 370, 100, 30);
		teamName.setFont(font1);
		this.add(abbreviation);
		abbreviation.setBounds(100, 410, 100, 30);
		abbreviation.setFont(font1);
		this.add(city);
		city.setBounds(100, 450, 100, 30);
		city.setFont(font1);
		this.add(leagle);
		leagle.setBounds(100, 490, 100, 30);
		leagle.setFont(font1);
		this.add(area);
		area.setBounds(100, 530, 100, 30);
		area.setFont(font1);
		this.add(home);
		home.setBounds(100, 570, 100, 30);
		home.setFont(font1);
		this.add(year);
		year.setBounds(100, 610, 200, 30);
		year.setFont(font1);
						
        this.add(jl);
        jl.setBounds(0, 150, 300, 500);
		
        Object[][] data1 = null;
	    model1 = new DefaultTableModel(new Object[][]{},columnNames1);
	    model1.setDataVector(data1, columnNames1);
	    table1 = new MyTable(model1);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane1 = new JScrollPane (table1);
	    this.add(pane1);
	    pane1.setBounds(300, 150, 752, 500);
	    
     /*   Object[][] data2 = null;
	    model2 = new DefaultTableModel(new Object[][]{},columnNames2);
	    model2.setDataVector(data2, columnNames2);
	    table2 = new MyTable(model2);

	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane2 = new JScrollPane (table2);
	    this.add(pane2);
	    pane2.setBounds(120, 150, 932, 120);
	   */
	}
	
	public void update(String team){
		changePIC(team);
		this.repaint();
	}
	
	public void changePIC(String team){
		if(team.equals("ATL"))
		    teamIcon.setIcon(Img.ATL);
		else if(team.equals("BKN"))
		    teamIcon.setIcon(Img.BKN);
		else if(team.equals("BOS"))
		    teamIcon.setIcon(Img.BOS);
		else if(team.equals("CHA"))
		    teamIcon.setIcon(Img.CHA);
		else if(team.equals("CHI"))
		    teamIcon.setIcon(Img.CHI);
		else if(team.equals("CLE"))
		    teamIcon.setIcon(Img.CLE);
		else if(team.equals("DAL"))
		    teamIcon.setIcon(Img.DAL);
		else if(team.equals("DEN"))
		    teamIcon.setIcon(Img.DEN);
		else if(team.equals("DET"))
		    teamIcon.setIcon(Img.DET);
		else if(team.equals("GSW"))
		    teamIcon.setIcon(Img.GSW);
		else if(team.equals("HOU"))
		    teamIcon.setIcon(Img.HOU);
		else if(team.equals("IND"))
		    teamIcon.setIcon(Img.IND);
		else if(team.equals("LAC"))
		    teamIcon.setIcon(Img.LAC);
		else if(team.equals("LAL"))
		    teamIcon.setIcon(Img.LAL);
		else if(team.equals("MEM"))
		    teamIcon.setIcon(Img.MEM);
		else if(team.equals("MIA"))
		    teamIcon.setIcon(Img.MIA);
		else if(team.equals("MIL"))
		    teamIcon.setIcon(Img.MIL);
		else if(team.equals("MIN"))
		    teamIcon.setIcon(Img.MIN);
		else if(team.equals("NOP"))
		    teamIcon.setIcon(Img.NOP);
		else if(team.equals("NYK"))
		    teamIcon.setIcon(Img.NYK);
		else if(team.equals("OKC"))
		    teamIcon.setIcon(Img.OKC);
		else if(team.equals("ORL"))
		    teamIcon.setIcon(Img.ORL);
		else if(team.equals("PHI"))
		    teamIcon.setIcon(Img.PHI);
		else if(team.equals("PHX"))
		    teamIcon.setIcon(Img.PHX);
		else if(team.equals("POR"))
		    teamIcon.setIcon(Img.POR);
		else if(team.equals("SAC"))
		    teamIcon.setIcon(Img.SAC);
		else if(team.equals("SAS"))
		    teamIcon.setIcon(Img.SAS);
		else if(team.equals("TOR"))
		    teamIcon.setIcon(Img.TOR);
		else if(team.equals("UTA"))
		    teamIcon.setIcon(Img.UTA);
		else if(team.equals("WAS"))
		    teamIcon.setIcon(Img.WAS);
	}
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("home")){
			frame.change(this, frame.mainFrame);
		}
		else if(e.getActionCommand().equals("back")){
			frame.change(this, frame.teamsSelectPanel);
		}
		
		
	}

}
