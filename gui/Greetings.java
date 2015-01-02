package gui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Greetings extends JPanel {
	
	private JLabel wishes;
	
	public Greetings(String greeting){
		this.wishes = new JLabel(greeting);
		wishes.setText(greeting);
		wishes.setBackground(Color.blue);
		wishes.setForeground(Color.red);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(wishes);
	}
	
}
