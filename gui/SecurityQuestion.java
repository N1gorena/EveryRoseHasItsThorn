package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SecurityQuestion extends JPanel {
	private AnswerLine answerLine;
	private JLabel question;
	
	public SecurityQuestion(String Q, String[] answers) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		
		this.question = new JLabel(formatQuestion(Q));
		this.question.setForeground(Color.RED);
		this.question.setFont(this.question.getFont().deriveFont(13.0f));
		this.question.setAlignmentX(LEFT_ALIGNMENT);
		this.question.setAlignmentY(CENTER_ALIGNMENT);
		this.add(this.question);
		
		this.add(Box.createVerticalGlue());
		
		JButton answerQ = new JButton("Submit");
		JComboBox<String> possAnswers = new JComboBox<String>();
		this.answerLine = new AnswerLine(possAnswers,answerQ,answers);
		this.answerLine.setSize(200, 10);
		this.answerLine.setAlignmentX(LEFT_ALIGNMENT);
		this.answerLine.setAlignmentY(CENTER_ALIGNMENT);
		this.add(answerLine);
		
		
		
		
	}
	
	
	private class AnswerLine extends JPanel{
		public AnswerLine(JComboBox<String> answers, JButton submit, String[] givenAnswers){
			this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
			this.setBackground(Color.BLACK);
			
			for(String s : givenAnswers){
				answers.addItem(s);
			}
			answers.setBackground(Color.BLACK);
			answers.setForeground(Color.WHITE);
			this.add(answers);
			
			submit.setBackground(Color.BLACK);
			submit.setForeground(Color.BLUE);
			this.add(submit);
		}
	}
	
	private String formatQuestion(String Q){
		return "<html>" + Q + "</html>";
	}
}
