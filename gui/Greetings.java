package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Greetings extends JPanel {
	
	private JLabel greeting;
	private JLabel christmas;
	private JLabel newYear;
	
	public Greetings(){
		this.greeting = new JLabel("Hi Rose!");
		this.christmas = new JLabel("Merry Christmas!");
		this.newYear = new JLabel("And Happy New Year!");
				
		this.setBackground(Color.black);
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		
		greeting.setForeground(Color.RED);
		christmas.setForeground(Color.WHITE);
		newYear.setForeground(Color.BLUE);
	
		greeting.setFont(greeting.getFont().deriveFont(16.0f));
		christmas.setFont(christmas.getFont().deriveFont(16.0f));
		newYear.setFont(newYear.getFont().deriveFont(16.0f));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		

		greeting.setAlignmentY(CENTER_ALIGNMENT);
		greeting.setAlignmentX(CENTER_ALIGNMENT);
		christmas.setAlignmentY(CENTER_ALIGNMENT);
		christmas.setAlignmentX(CENTER_ALIGNMENT);
		newYear.setAlignmentY(CENTER_ALIGNMENT);
		newYear.setAlignmentX(CENTER_ALIGNMENT);
		
		
		this.add(greeting);
		this.add(christmas);
		this.add(newYear);
	}
	
}
