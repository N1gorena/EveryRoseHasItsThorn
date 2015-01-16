package gui.Ivory;

import gui.tromboneScreen.TromboneGUI;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import trombone.Note;
import trombone.Trombone;

public class Ivory extends JPanel implements KeyListener,ActionListener{
	
	TromboneGUI ivGui = null;
	private final int volume = 50;
	
	private Map<Character,Boolean> notesOn = null; 
	
	private static final Map<Character,Note> whiteBones; 
	static{
		whiteBones = new HashMap<Character,Note>();
		
		whiteBones.put('a', new Note("A4", 0, 0));
		whiteBones.put('b', new Note("B4", 0, 0));
		whiteBones.put('c', new Note("C4", 0, 0));
		whiteBones.put('d', new Note("D4", 0, 0));
		whiteBones.put('e', new Note("E4", 0, 0));
		whiteBones.put('f', new Note("F4", 0, 0));
		whiteBones.put('a', new Note("G4", 0, 0));
		
	}
	
	private JTextField keyboard;
	private Trombone sounder;
	
	
	
	
	public Ivory(String string) {
		// TODO Auto-generated constructor stub
		this.keyboard = new JTextField(20);
		this.keyboard.addKeyListener((java.awt.event.KeyListener) this);
		this.keyboard.setText(string);
		
		this.notesOn = new HashMap<Character,Boolean>();
		
		this.add(keyboard);
		
		try {
			sounder = new Trombone();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char keyPressed = e.getKeyChar();
		if(this.notesOn.containsKey(keyPressed)){
			if(!notesOn.get(keyPressed)){
				this.notesOn.put(keyPressed, true);
				Note toPlay = whiteBones.get(keyPressed);
				toPlay.setVolume(this.volume);
				try {
					sounder.playNote(toPlay);
					System.out.println("Playing");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		else{
			this.notesOn.put(keyPressed, true);
			Note toPlay = whiteBones.get(e.getKeyChar());
			toPlay.setVolume(this.volume);
			try {
				sounder.playNote(toPlay);
				System.out.println("Playing");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		char keyReleased = e.getKeyChar();
		if(this.notesOn.get(keyReleased)){
			
			Note toEnd = whiteBones.get(e.getKeyChar());
			toEnd.setVolume(this.volume);
			sounder.endNote(toEnd);
			this.notesOn.put(keyReleased, false);
			System.out.println("stopping");
			
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
	
	public void setInstrument(TromboneGUI instrument){
		this.ivGui = instrument;
		return;
	}

}
