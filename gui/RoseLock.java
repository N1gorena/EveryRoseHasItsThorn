package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;

import javax.swing.ImageIcon;
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
	}
	
	
	public void paintComponent(Graphics g){
		g.drawImage(background, 0, 0, null);
		//TODO generate filled in triangle to place widgets on
		Polygon p = generateLockShape("Triangle");
		
		g.drawPolygon(p);
		g.setColor(Color.WHITE);
		g.fillPolygon(p);
		
		
	}
	
	public Polygon generateLockShape(String shape){
		switch(shape){
		case "Triangle":
			//Hacked out my desired Triangle
			Polygon p = new Polygon();
			int WIDTH = this.background.getWidth(null);
			int HEIGHT = this.background.getHeight(null);
			p.addPoint(WIDTH/4, HEIGHT/4 + 60);
			p.addPoint( (WIDTH/4) , HEIGHT);
			p.addPoint(WIDTH, HEIGHT);
			p.addPoint(WIDTH + 400 , HEIGHT + 300);
			
			
			return p;
		default:
			Polygon pee = new Polygon();
			return pee;
		}
		
	}
}
