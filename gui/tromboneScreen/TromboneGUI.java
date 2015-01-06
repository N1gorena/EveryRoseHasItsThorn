package gui.tromboneScreen;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import trombone.Trombone;

import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.awt.GLJPanel;
import javax.media.opengl.glu.GLU;
import static javax.media.opengl.GL.*;  // GL constants
import static javax.media.opengl.GL2.*; // GL2 constants

import com.jogamp.opengl.util.FPSAnimator;

public class TromboneGUI extends GLJPanel implements GLEventListener {
	private Trombone myInstrument;
	private static final int FPS = 60;
	private FPSAnimator animator; 
	private GLU glu;
	public TromboneGUI(Trombone Tromby, GLCapabilities glcapabilities){
		super(glcapabilities);
		if(Tromby == null){
			System.out.println("SOMETHING WENT WRONG");
			Thread.dumpStack();
		}
		this.myInstrument = Tromby;
		//this.setBackground(Color.BLACK);
		//this.setSize(700,700);
		this.animator = new FPSAnimator(this,FPS,true);
		animator.start();
		this.addGLEventListener(this);
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();      // get the OpenGL graphics context
	      glu = new GLU();                         // get GL Utilities
	      gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // set background (clear) color
	      gl.glClearDepth(1.0f);      // set clear depth value to farthest
	      gl.glEnable(GL_DEPTH_TEST); // enables depth testing
	      gl.glDepthFunc(GL_LEQUAL);  // the type of depth test to do
	      gl.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST); // best perspective correction
	      gl.glShadeModel(GL_SMOOTH); // blends colors nicely, and smoothes out lighting
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
	    gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
	    gl.glLoadIdentity();  // reset the model-view matrix
	    
	      // ----- Your OpenGL rendering code here (Render a white triangle for testing) -----
	    gl.glTranslatef(0.0f, 0.0f, -1.0f); // translate into the screen
	    gl.glBegin(GL.GL_LINES); // draw using triangles
	    //Positive Axes
	    gl.glVertex3d(0, 0, 0);
	    gl.glVertex3d(1, 0, 0);
	    gl.glVertex3d(0, 0, 0);
	    gl.glVertex3d(0, 1, 0);
	    gl.glVertex3d(0, 0, 0);
	    gl.glVertex3d(0, 0, 1);
	    //Neg Axes
	    gl.glVertex3d(0, 0, 0);
	    gl.glVertex3d(-1, 0, 0);
	    gl.glVertex3d(0, 0, 0);
	    gl.glVertex3d(0, -1, 0);
	    gl.glVertex3d(0, 0, 0);
	    gl.glVertex3d(0, 0, -1);
	    
	    gl.glEnd();
	    
	   /* gl.glColor3f(0.0f, 2.5f, 0.0f);
	    gl.glVertex3d(0.0f, 1.0f, 0.0f);
	    gl.glColor3f(1.0f, 0.0f, 0.0f);
	    gl.glVertex3f(-1.0f, -1.0f, 0.0f);
	    gl.glColor3f(0.0f, 0.0f, 1.0f);
	    gl.glVertex3f(1.0f, -1.0f, 0.0f);
	    gl.glEnd();
	    
	    
	    gl.glBegin(GL.GL_TRIANGLES); // draw using triangles
	    gl.glColor3f(0.0f, 1.0f, 0.0f);
	    gl.glVertex3d(-1.0f, -1.0f, 0.0f);
	    gl.glColor3f(1.0f, 0.0f, 0.0f);
	    gl.glVertex3f(-3.0f, -1.0f, 0.0f);
	    gl.glColor3f(0.0f, 0.0f, 1.0f);
	    gl.glVertex3f(-2.0f, 1.0f, 0.0f);
	    gl.glEnd();
	    
	    gl.glBegin(GL.GL_TRIANGLES); // draw using triangles
	    gl.glColor3f(0.0f, 1.0f, 0.0f);
	    gl.glVertex3d(-1.0f, -1.0f, 0.0f);
	    gl.glColor3f(1.0f, 0.0f, 0.0f);
	    gl.glVertex3f(0.0f, 1.0f, 0.0f);
	    gl.glColor3f(0.0f, 0.0f, 1.0f);
	    gl.glVertex3f(-2.0f, 1.0f, 0.0f);
	    gl.glEnd();*/
	    
	    
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
		 
	      if (height == 0) height = 1;   // prevent divide by zero
	      float aspect = (float)width / height;
	 
	      // Set the view port (display area) to cover the entire window
	      gl.glViewport(0, 0, width, height);
	 
	      // Setup perspective projection, with aspect ratio matches viewport
	      gl.glMatrixMode(GL_PROJECTION);  // choose projection matrix
	      gl.glLoadIdentity();             // reset projection matrix
	      glu.gluPerspective(45.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar
	 
	      // Enable the model-view transform
	      gl.glMatrixMode(GL_MODELVIEW);
	      gl.glLoadIdentity(); // reset
		
	}

}
