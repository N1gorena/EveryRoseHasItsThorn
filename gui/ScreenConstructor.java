package gui;

import java.util.Scanner;

import javax.swing.JFrame;

public class ScreenConstructor {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Scanner userInput = new Scanner(System.in);
		
		boolean t = true;
		while(t){
			int x = userInput.nextInt();
			if( x > 0 ){
				mainFrame.moveSlide(-5.0f);

			}
			else{
				mainFrame.moveSlide(0.0f);

			}
			if(x == -1 ){
				t = false;
			}
		}
		
	
	}

}
