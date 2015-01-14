package gui.tromboneScreen;

import gui.MainFrame;
import gui.Ivory.Ivory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.JButton;
import javax.swing.JPanel;

import trombone.Trombone;

public class TromboneScreen extends JPanel {
	
	private TromboneGUI myTromboneGUI = null;
	private Ivory Keyano = null;
	
	public TromboneScreen(Container mf){
		this.setBackground(Color.BLUE);
		this.setLayout(new GridBagLayout());
		this.setSize(mf.getSize());
		
		Trombone RTrombone = null; 
		try {
			RTrombone = new Trombone();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GLProfile glprofile = GLProfile.getDefault();
		GLCapabilities glcapabilities = new GLCapabilities(glprofile);
		this.myTromboneGUI = new TromboneGUI(RTrombone,glcapabilities);
		GridBagConstraints trombGUIConstraints = new GridBagConstraints();
		trombGUIConstraints.gridx = 0;
		trombGUIConstraints.gridy = 0;
		trombGUIConstraints.weightx = 0.75;
		trombGUIConstraints.weighty = 0.75;
		trombGUIConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		trombGUIConstraints.fill = GridBagConstraints.BOTH;
		//JButton testButton = new JButton("Fuck");
		myTromboneGUI.setSize(MainFrame.screenDim);
		this.add(myTromboneGUI, trombGUIConstraints);
		
		
		//ControlsGUI controls = new ControlsGUI();
		GridBagConstraints controlsConstraints = new GridBagConstraints();
		controlsConstraints.gridx = 1;
		controlsConstraints.gridy = 0;
		controlsConstraints.weightx = 0.25;
		controlsConstraints.weighty = 0.75;
		controlsConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		controlsConstraints.fill = GridBagConstraints.BOTH;
		JButton testButton2 = new JButton("Fuck");
		testButton2.setSize(MainFrame.screenDim);
		this.add(testButton2, controlsConstraints);
		
		//bottomGUI bGUI = new bGUI();
		GridBagConstraints Constraints = new GridBagConstraints();
		Constraints.gridx = 0;
		Constraints.gridy = 1;
		Constraints.weightx = 1.0;
		Constraints.weighty = 0.25;
		Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		Constraints.fill = GridBagConstraints.BOTH;
		Constraints.gridwidth = 2;
		
		this.Keyano = new Ivory("");
		this.Keyano.setInstrument(this.myTromboneGUI);
		Keyano.setSize(MainFrame.screenDim);
		this.add( Keyano , Constraints );
	}
	
	public TromboneGUI getTromboneGUI(){
		return this.myTromboneGUI;
	}
	
	public Ivory getIvory(){
		return this.Keyano;
	}

}
