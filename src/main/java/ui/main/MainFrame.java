package ui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.main.Frame;
import ui.main.MyButton;
import ui.main.MyPanel;
import ui.material.Img;


@SuppressWarnings("serial")
public class MainFrame extends MyPanel implements ActionListener{
	private Frame frame;

	MyButton ranking = new MyButton(Img.RANKICON1,Img.RANKICON2);
	MyButton statistics = new MyButton(Img.STATISTICSICON1,Img.STATISTICSICON2);
	MyButton teams = new MyButton(Img.TEAMICON1,Img.TEAMICON2);
	MyButton players = new MyButton(Img.PLAYERICON1,Img.PLAYERICON2);
	MyButton matches = new MyButton(Img.MATCHICON1,Img.MATCHICON2);

	public MainFrame(Frame frame) {
		super(frame);
		this.frame = frame;
		this.setLayout(null);
		this.setOpaque(false);
	    
	    this.add(ranking);
	    ranking.setBounds(446, 230, 160, 60);
	    ranking.addActionListener(this);
	    ranking.setActionCommand("ranking");
	    
	    this.add(statistics);
	    statistics.setBounds(446, 310, 160, 60);
	    statistics.addActionListener(this);
	    statistics.setActionCommand("statistics");
	    
	    this.add(teams);
	    teams.setBounds(446, 390, 160, 60);
	    teams.addActionListener(this);
	    teams.setActionCommand("teams");
	    
	    this.add(players);
	    players.setBounds(446, 470, 160, 60);
	    players.addActionListener(this);
	    players.setActionCommand("players");
	    
	    this.add(matches);
	    matches.setBounds(446, 550, 160, 60);
	    matches.addActionListener(this);
	    matches.setActionCommand("matches");

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
		else if(e.getActionCommand().equals("matches")){
			frame.change(this, frame.matchesPanel);
		}
	}


}
