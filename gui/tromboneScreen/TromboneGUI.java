package gui.tromboneScreen;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import trombone.Trombone;

public class TromboneGUI extends JPanel {
	private Trombone myInstrument;
	
	public TromboneGUI(Trombone Tromby){
		if(Tromby == null){
			System.out.println("SOMETHING WENT WRONG");
			Thread.dumpStack();
		}
		this.myInstrument = Tromby;
		this.setBackground(Color.BLACK);
		this.setSize(700,700);
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g){
		//Get Shit drawn
		g.drawLine(0, 0, 500, 500);
	}

}
