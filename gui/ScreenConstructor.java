package gui;

import gui.Ivory.Ivory;
import gui.tromboneScreen.TromboneGUI;

import java.util.Scanner;

import javax.swing.JFrame;

public class ScreenConstructor {
	
	
	/*Main Method: Entry Point
	 * Create the main frame that will house the entirety of the program.
	 * This is the top-level frame that will hold all GUI panels and frames.
	 */
	public static void main(String[] args) {
	
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);				//Set visible so program can be seen.
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Set default close operation to avoid issues.
		
		//TromboneGUI instrument = mainFrame.getInstrumentGUI();
		
		//Ivory keyboardInput = mainFrame.getIvoryInput();
		
	}

}
