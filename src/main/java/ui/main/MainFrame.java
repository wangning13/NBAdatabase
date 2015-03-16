package ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.main.Frame;
import ui.main.MyButton;
import ui.main.MyPanel;
import ui.material.Img;
import ui.team.Ranking;



public class MainFrame extends MyPanel implements ActionListener{
	private Frame frame;

	JButton ranking = new JButton("排名");
	JButton statistics = new JButton("统计");
	JButton teams = new JButton("球队");
	JButton players = new JButton("球员");

	public MainFrame(Frame frame) {
		super(frame);
		this.frame = frame;
		this.setLayout(null);
		this.setOpaque(false);
	    
	    this.add(ranking);
	    ranking.setBounds(476, 250, 100, 30);
	    ranking.addActionListener(this);
	    ranking.setActionCommand("ranking");
	    
	    this.add(statistics);
	    statistics.setBounds(476, 350, 100, 30);
	    statistics.addActionListener(this);
	    statistics.setActionCommand("statistics");
	    
	    this.add(teams);
	    teams.setBounds(476, 450, 100, 30);
	    teams.addActionListener(this);
	    teams.setActionCommand("teams");
	    
	    this.add(players);
	    players.setBounds(476, 550, 100, 30);
	    players.addActionListener(this);
	    players.setActionCommand("players");

    }

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("ranking")){
			frame.change(this, frame.rankingPanel);
		}
		else if(e.getActionCommand().equals("statistics")){
			frame.change(this, frame.statisticsPanel);
		}
		else if(e.getActionCommand().equals("teams")){
			frame.change(this, frame.teamsSelectPanel);
		}
		else if(e.getActionCommand().equals("players")){
			frame.change(this, frame.playersSelectPanel);
		}
	}


}
