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
import ui.tools.Translate;

@SuppressWarnings("serial")
public class TeamsSelect extends MyPanel implements ActionListener{
	Frame frame;
	JScrollPane pane;
	MyTable table;
	DefaultTableModel model;
	String[] columnNames = {"西南区","西北区","太平洋区","东南区","中区","大西洋区"};
	JLabel rankingBand = new JLabel(Img.RANKINGBAND);
    JLabel jl = new JLabel("NBA球队");

	Font font1 = new Font("黑体", Font.BOLD, 16);
	public TeamsSelect(Frame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
		this.frame = frame;
		
	    this.add(jl);
	    jl.setBounds(20, 170, 100, 30);
	    jl.setFont(font1);
		
		this.add(rankingBand);
		rankingBand.setBounds(0, 150, 1052, 70);

        Object[][] data = getData();
	    model = new DefaultTableModel(data,columnNames);
	    model.setDataVector(data, columnNames);
	    table = new MyTable(model);

	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    pane = new JScrollPane (table);
	    this.add(pane);
	    pane.setBounds(0, 220, 1052, 430);
	    
	    table.addMouseListener(new MouseAdapter() {    //这里使用MouseAdapter代替MouseListener，因为MouseListener要重写的方法太多
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				jump(row,column);
			}
		});
	}
	
	public Object[][] getData(){
		Object[][] data = new Object[5][];
        Object temp1[] = {"圣安东尼奥马刺","明尼苏达森林狼","萨克拉门托国王","迈阿密热","底特律活塞","波士顿凯尔特人"};
        Object temp2[] = {"孟菲斯灰熊","丹佛掘金","菲尼克斯太阳","奥兰多魔术","印第安纳步行者","费城76人"};
        Object temp3[] = {"达拉斯小牛","尤他爵士","洛杉矶湖人","亚特兰大老鹰","克里夫兰骑士","纽约尼克斯"};
        Object temp4[] = {"休斯顿火箭","波特兰开拓者","洛杉矶快船","华盛顿奇才","芝加哥公牛","布鲁克林篮网"};
        Object temp5[] = {"新奥尔良鹈鹕","俄克拉荷马雷霆","金州勇士","夏洛特黄蜂","密尔沃基雄鹿","多伦多猛龙"}; 
        data[0] = temp1;
        data[1] = temp2;
        data[2] = temp3;
        data[3] = temp4;
        data[4] = temp5;
        return data;
	}
	
	public void jump(int row,int column){
		String temp = table.getValueAt(row, column).toString();
		String team = Translate.translate(temp);
		frame.change(this, frame.singleTeamPanel);
		frame.singleTeamPanel.update(team);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("home")||e.getActionCommand().equals("back")){
			frame.change(this, frame.mainFrame);
		}	
	}

}
