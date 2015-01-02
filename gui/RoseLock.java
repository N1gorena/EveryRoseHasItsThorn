package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoseLock extends JPanel {
	private Image background;
	public RoseLock(String imagePath){
		this.background = new ImageIcon("images/"+ imagePath).getImage();
		Dimension size = new Dimension(this.background.getWidth(null), this.background.getHeight(null));
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMaximumSize(size);
		this.setSize(size);
		this.setLayout(null);
		
		JButton testBitch = new JButton("Bitch");
		
	
		
		this.add(testBitch);
		testBitch.setBounds(0, 0, 200, 200);;
		testBitch.repaint();
			
		
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(background, 0, 0, null);
		//TODO generate background foreground distinction
		Polygon p = generateLockShape("NJGUnoBox");
		
		g.drawPolygon(p);
		g.setColor(Color.RED);
		g.fillPolygon(p);
		
		Polygon p2 = generateLockShape("NJGDosBox");
		
		g.drawPolygon(p2);
		g.setColor(Color.WHITE);
		g.fillPolygon(p2);
		
		
		
	}
	
	public Polygon generateLockShape(String shape){
		switch(shape){
		case "NJGUnoBox":
			//Hacking boxes
			Polygon p = new Polygon();
			int WIDTH = this.background.getWidth(null);
			int HEIGHT = this.background.getHeight(null);
			p.addPoint(WIDTH/4  + 200, HEIGHT/4 + 500);
			p.addPoint( (WIDTH/4) + 200 , HEIGHT/4 + 570);
			p.addPoint(WIDTH/4  + 380, HEIGHT/4 + 500);
			p.addPoint( (WIDTH/4) + 380 , HEIGHT/4 + 570);
			
			
			return p;
		case "NJGDosBox":
			//Hacking boxes
			Polygon p2 = new Polygon();
			int WIDTHD = this.background.getWidth(null);
			int HEIGHTD = this.background.getHeight(null);
			p2.addPoint(WIDTHD/4  + 150, HEIGHTD/4 + 580);
			p2.addPoint( (WIDTHD/4) + 150 , HEIGHTD/4 + 650);
			p2.addPoint(WIDTHD/4  + 430, HEIGHTD/4 + 580);
			p2.addPoint( (WIDTHD/4) + 430 , HEIGHTD/4 + 650);
			
			
			return p2;
		default:
			Polygon pee = new Polygon();
			return pee;
		}
		
	}
}
