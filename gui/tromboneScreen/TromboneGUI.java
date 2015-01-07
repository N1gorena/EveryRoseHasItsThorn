package gui.tromboneScreen;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import trombone.Trombone;

import java.lang.Math.*;

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
	private static enum Axis{incX,decX,incY,decY,incZ,decZ};
	
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
	    //Camera
	    gl.glTranslatef(0.0f, 0.0f, -2.5f); // translate into the screen
	    //gl.glRotatef(90,0.0f,0.0f,-1.0f);
	    //Brush
	    	//Orienting Axes
			    gl.glBegin(GL.GL_LINES); // draw using triangles
			    //Positive Axes 
			    gl.glColor3d(0.0f, 0.0f, 1.0f);
			    gl.glVertex3d(0, 0, 0);
			    gl.glVertex3d(1.8f, 0, 0);
			    gl.glColor3d(1.0f, 0.0f, 0.0f);
			    gl.glVertex3d(0, 0, 0);
			    gl.glVertex3d(0, 1.2f, 0);
			    gl.glColor3d(0.0f, 1.0f, 0.0f);
			    gl.glVertex3d(0, 0, 0);
			    gl.glVertex3d(0, 0, 1);
			    //Neg Axes
			    gl.glColor3d(0.0f, 0.0f, 1.0f);
			    gl.glVertex3d(0, 0, 0);
			    gl.glVertex3d(-1.8f, 0, 0);
			    gl.glColor3d(1.0f, 0.0f, 0.0f);
			    gl.glVertex3d(0, 0, 0);
			    gl.glVertex3d(0, -1.2f, 0);
			    gl.glColor3d(0.0f, 1.0f, 0.0f);
			    gl.glVertex3d(0, 0, 0);
			    gl.glVertex3d(0, 0, -1);
			    gl.glEnd();
			//Background Done    
		    //Object Trombone
			double sideLength = 0.6f;
			createSquare(sideLength, gl, -0.6f, 0.4f, 0.0f,TromboneGUI.Axis.incX,TromboneGUI.Axis.decY);  
		    gl.glBegin(GL.GL_LINE_LOOP);
			drawCircle(gl);
	    //
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
	
	private void drawCircle(GL2 brush){
		int radius = 1;
		double pi = Math.PI;
		//brush.glBegin(GL.GL_LINES);
		
		for(double ini = 0.0f ; ini < 2*pi ; ini+=0.1){
			brush.glVertex3d(radius*Math.cos(ini), radius * Math.sin(ini), 0.0f);
		}
		brush.glEnd();
	}
	
	//Assuming Quads
	//Takes in a sideLength, a "brush", the top left coordinate in x,y,z and enums for orientation.
	//Square is drawn expanding in leading enum direction by amount=sideLength,
	//and then expanding in second enum direction by amount=sideLength;
	private void createSquare(double sideLength, GL2 gl, double TLx, double TLy, double TLz, Axis expansion1, Axis expansion2){
	    gl.glBegin(GL2.GL_QUADS);
	    gl.glVertex3d(TLx,TLy,TLz);
	    
	    double x = TLx;
	    double y = TLy;
	    double z = TLz;
	    switch(expansion1){
	    	case incX:
    			x = TLx + sideLength;
    			gl.glVertex3d(x, TLy, TLz); 
    			break;
	    	case decX:
	    		x = TLx - sideLength;
    			gl.glVertex3d(x, TLy, TLz); 
    			break;
	    	case incY:
	    		y = TLy + sideLength;
    			gl.glVertex3d(TLx, y, TLz); 
    			break;
	    	case decY:
	    		y = TLy - sideLength;
    			gl.glVertex3d(TLx, y, TLz); 
    			break;
	    	case incZ:
	    		z = TLz + sideLength;
    			gl.glVertex3d(TLx, TLy, z); 
    			break;
	    	case decZ:
	    		z = TLz - sideLength;
    			gl.glVertex3d(TLx, TLy, z); 
    			break;
	    	default:System.out.println("fucked up CreateSquare");break;
	    }
	    switch(expansion2){
	    	case incX:gl.glVertex3d(TLx + sideLength, y, z); break;
	    	case decX:gl.glVertex3d(TLx - sideLength, y, z); break;
	    	case incY:gl.glVertex3d(x, TLy + sideLength, z); break;
	    	case decY:gl.glVertex3d(x, TLy - sideLength, z); break;
	    	case incZ:gl.glVertex3d(x, y, TLz + sideLength); break;
	    	case decZ:gl.glVertex3d(x, y, TLz - sideLength); break;
	    	default:System.out.println("fucked up CreateSquare");break;
	    }
	    switch(expansion2){
	    	case incX:gl.glVertex3d(TLx + sideLength, TLy, TLz); break;
	    	case decX:gl.glVertex3d(TLx - sideLength, TLy, TLz); break;
	    	case incY:gl.glVertex3d(TLx, TLy + sideLength, TLz); break;
	    	case decY:gl.glVertex3d(TLx, TLy - sideLength, TLz); break;
	    	case incZ:gl.glVertex3d(TLx, TLy, TLz + sideLength); break;
	    	case decZ:gl.glVertex3d(TLx, TLy, TLz - sideLength); break;
	    	default:System.out.println("fucked up CreateSquare");break;
	    }
	    gl.glEnd();
	}
}
