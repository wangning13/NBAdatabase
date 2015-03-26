package ui.player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class MyComboBoxUI extends BasicComboBoxUI{

	@Override
	protected void installDefaults() {
		// TODO Auto-generated method stub
		super.installDefaults();
		LookAndFeel.installProperty( comboBox, "opaque", Boolean.TRUE);
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		g.setColor(new Color(255,0,0,150));
		g.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 10, 10);
		super.paint(g, c);
		
	}

	@Override
	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		g.setColor(Color.red);
		super.paintCurrentValue(g, bounds, hasFocus);
	}

	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds,
			boolean hasFocus) {
		g.setColor(Color.green);
		super.paintCurrentValueBackground(g, bounds, hasFocus);
	}
	

}
