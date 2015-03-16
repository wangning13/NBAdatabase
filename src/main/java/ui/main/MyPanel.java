package ui.main;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.material.Img;


@SuppressWarnings("serial")
public class MyPanel extends JPanel implements ActionListener{
	Frame frame;
	private MyButton mini=new MyButton(Img.MINI1,Img.MINI2);
	private MyButton close=new MyButton(Img.CLOSE1,Img.CLOSE2);
	private static Point origin = new Point(); 
	public JLabel band = new JLabel(Img.BAND);
	JLabel tittle = new JLabel(Img.TITTLE);
	MyButton home = new MyButton(Img.HOME1,Img.HOME2);
	MyButton back = new MyButton(Img.BACK1,Img.BACK2);
	public MyPanel(Frame frame){		
		this.frame=frame;
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0,0,1052,650);
		
		this.add(home);
		home.setBounds(980, 100, 40, 40);
		home.addActionListener(this);
		home.setActionCommand("home");
		
        this.add(back);
        back.setBounds(30, 100, 40, 40);
        back.addActionListener(this);
        back.setActionCommand("back");

	    this.add(tittle);
	    tittle.setBounds(285,25,500,150);
		this.add(band);
	    band.setBounds(0,30,1052,120);
		
		MouseHandler mh=new MouseHandler();
		this.add(mini);
		mini.setBounds(995, 4 ,23, 22);
		mini.addActionListener(mh);
		mini.setActionCommand("mini");
		
		this.add(close);
		close.setBounds(1022, 5, 23, 21);
		close.addActionListener(mh);
		close.setActionCommand("close");
	
	
	 this.addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {  //按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
                 origin.x = e.getX();  //当鼠标按下的时候获得窗口当前的位置
                 origin.y = e.getY();
         }
         });
	    
	    this.addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseDragged(MouseEvent e) { 
                 Point p = MyPanel.this.frame.getLocation();  //当鼠标拖动时获取窗口当前位置
                 if (e.getY()<30)
                 MyPanel.this.frame.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
         }
         });
}

	public void paintComponent(Graphics g){
		g.drawImage(Img.BG, 0, 0, null);
	}

    class MouseHandler implements ActionListener  {
         public void actionPerformed(ActionEvent e){
 	        if (e.getActionCommand().equals("close")){

		     	System.exit(0);
	     	}
	     	else{
		     	frame.setExtendedState(Frame.ICONIFIED);
	     	}
          }
     }

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
