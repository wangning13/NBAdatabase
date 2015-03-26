package ui.player;

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
		// TODO Auto-generated method stub
		super.paint(g, c);
		
	}

	@Override
	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		// TODO Auto-generated method stub
		super.paintCurrentValue(g, bounds, hasFocus);
	}

	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds,
			boolean hasFocus) {
		// TODO Auto-generated method stub
		super.paintCurrentValueBackground(g, bounds, hasFocus);
	}
	

}
