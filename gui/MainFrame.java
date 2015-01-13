package gui;

import gui.roseLock.RoseLock;
import gui.tromboneScreen.TromboneScreen;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	public static final Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
	private RoseLock lockScreen;
	private TromboneScreen instrumentScreen; 
	
	public MainFrame(){
		this.setTitle("8-Bit Trombone");
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setPreferredSize(screenDim);
		this.setResizable(false);
		this.setLayout(new CardLayout());		
		
		this.lockScreen = new RoseLock("roseBackground.png", this);
		this.add(lockScreen, "ROSELOCK");
		
		Dimension hack = lockScreen.getSize();
		hack.setSize(hack.width + 6, hack.height + 26);
		
		this.setSize(hack);
		this.setLocation( ((screenDim.width/2) - this.getWidth()/2) , ((screenDim.height/2) - this.getHeight()/2) );
		
		this.instrumentScreen = new TromboneScreen(this.getContentPane());
		this.add(instrumentScreen,"TEST");
	}

	public void cardSwap(String string) {
		CardLayout myCL = (CardLayout) this.getContentPane().getLayout();
		myCL.show(this.getContentPane(), "TEST");
	}
	
	public void moveSlide(double dist){
		instrumentScreen.getTromboneGUI().setOffset(dist);
	}

}
