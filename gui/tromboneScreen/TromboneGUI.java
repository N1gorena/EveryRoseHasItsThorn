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
	private static enum Plane{XY,XZ,YX,YZ,ZX,ZY};
	
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
		    //X neg = Spin axis towards you from sides
		    //Y neg = Spin axis Clockwise from bottom LeftHanded
		    //Z neg = Spin axis Clockwise from front LeftHanded
	    
	    	gl.glRotatef(90, 0.0f,-1.0f,0.0f);
	    	
	    	//Negative means Positive?
		    gl.glTranslatef(-2.5f, 0.0f,0.0f); // translate into the screen
		   
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
			gl.glColor3d(0.7f,0.7f,1.0f);
			createSquareTube(gl,0.6f,0.0f,0.0f,-0.1f, Axis.decZ,0.6f);
			//createElbow(gl,0.6f,0.0f,0.0f,0.0f, Plane.ZY,1);
			//createElbow(gl,0.6f,0.0f,0.0f,0.0f, Plane.YZ,2);
			//createElbow(gl,0.6f,0.0f,0.0f,0.0f, Plane.YZ,3);
			//createElbow(gl,0.6f,0.0f,0.0f,0.0f, Plane.YZ,4);

			//drawCircle(gl);
	    
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
		  brush.glBegin(GL.GL_LINE_LOOP);
		
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
	
	//TODO Most Recent
	//Creating elbow by giving center coordinates and a plane and a quadrant in said plane.
	//From center point, create elbow will create a square in the plane in the quadrant using the given center as a (0,0,0) point
	//Elbow will be created as if looking at the elbow from the non-used dimensions perspective staring at the origin from some distance back
	//First axis of plane is the "X" axis, second axis of the plane is "Y" axis.
	//It will be as though the elbow is curling toward the "Y" dimension of any given plane
	//Elbows: Traveling in negative "X" direction, get sent in negative non-used direction
	//Elbows: Traveling in positive "Y" direction, get sent in negative non-used direction 
	private void createElbow(GL2 brush,double sideLength, double Cx, double Cy, double Cz, Plane plane, int quadrant){
		brush.glBegin(GL2.GL_QUAD_STRIP);
		
		//Quadrant Validation?
		
		double angleFrom = 0.0f;
		double angleTo = 0.0f;
		
		switch(quadrant){
			case 1:
				angleFrom = 0.0f;
				angleTo = 90.0f;
				break;
			case 2:
				angleFrom = 180.0f;
				angleTo = 90.0f;
				break;
			case 3:
				angleFrom = 180.0f;
				angleTo = 270.0f;
				break;
			case 4:
				angleFrom = 360.0f;
				angleTo = 270.0f;
				break;
			default:
				System.out.println("Funked Up");;
				break;
		}
		
		if( quadrant%2 != 0 ){//ODD quadrants
			//Different perspective I take I think...
			for(double angle = angleFrom ; angle < angleTo ; angle += 0.001f ){
				//TODO Obey expand axis rules, change it to plane to plane
				brush.glVertex3d(Cx, Cy, Cz);//1
				//Up the second Axis
				//Point 2
				switch(plane){
					case XY:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx , Cy + sideLength , Cz );//2
								break;
							case 3:
								brush.glVertex3d( Cx , Cy - sideLength , Cz );//2
								break;
							default:
								System.out.println("fucked up1");
								break;
						}
						break;
					case XZ:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx , Cy , Cz + sideLength );//2
								break;
							case 3:
								brush.glVertex3d( Cx , Cy , Cz - sideLength);//2
								break;
							default:
								System.out.println("fucked up2");
								break;
						}
						break;
					case YX:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx + sideLength , Cy , Cz );//2
								break;
							case 3:
								brush.glVertex3d( Cx - sideLength , Cy , Cz );//2
								break;
							default:
								System.out.println("fucked up3");
								break;
						}
						break;
					case YZ:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx , Cy , Cz + sideLength );//2
								break;
							case 3:
								brush.glVertex3d( Cx , Cy , Cz - sideLength );//2
								break;
							default:
								System.out.println("fucked up4");
								break;
						}
						break;
					case ZX:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx + sideLength , Cy , Cz );//2
								break;
							case 3:
								brush.glVertex3d( Cx - sideLength , Cy , Cz );//2
								break;
							default:
								System.out.println("fucked up3");
								break;
						}
						break;
					case ZY:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx , Cy + sideLength , Cz );//2
								break;
							case 3:
								brush.glVertex3d( Cx , Cy - sideLength , Cz );//2
								break;
							default:
								System.out.println("fucked up3");
								break;
						}
						break;
					default:
						System.out.println("fucked up5");
						break;
				}
				//Point 4
				switch(plane){
					case XY:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy , Cz - (sideLength*Math.sin(Math.toRadians(angle))) );//4
								break;
							case 3:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy , Cz + (sideLength*Math.sin(Math.toRadians(angle))) );//4
								break;
							default:
								System.out.println("fucked up6");
								break;
						}
						break;
					case XZ:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy - (sideLength*Math.sin(Math.toRadians(angle))) , Cz );//4
								break;
							case 3:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy + (sideLength*Math.sin(Math.toRadians(angle))) , Cz );//4
								break;
							default:
								System.out.println("fucked up7");
								break; 
						}
						break;
					case YX://TODO
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz - (sideLength*Math.sin(Math.toRadians(angle))) );//4
								break;
							case 3:
								brush.glVertex3d( Cx , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz + (sideLength*Math.sin(Math.toRadians(angle))) );//4
								break;
							default:
								System.out.println("fucked up8");
								break;
						}
						break;
					case YZ:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx  - (sideLength*Math.sin(Math.toRadians(angle))) , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz );//4
								break;
							case 3:
								brush.glVertex3d( Cx  + (sideLength*Math.sin(Math.toRadians(angle))) , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz );//4
								break;
							default:
								System.out.println("fucked up9");
								break;
						}
						break;
					case ZX:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx , Cy - (sideLength*Math.sin(Math.toRadians(angle))) , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//4
								break;
							case 3:
								brush.glVertex3d( Cx , Cy + (sideLength*Math.sin(Math.toRadians(angle))) , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//4
								break;
							default:
								System.out.println("fucked up7");
								break; 
						}
						break;
					case ZY:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx - (sideLength*Math.sin(Math.toRadians(angle))) , Cy , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//4
								break;
							case 3:
								brush.glVertex3d( Cx + (sideLength*Math.sin(Math.toRadians(angle))) , Cy , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//4
								break;
							default:
								System.out.println("fucked up7");
								break; 
						}
						break;
					default:
						System.out.println("fucked up10");
						break;
				}
				//Point three
				switch(plane){
					case XY:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy + sideLength , Cz - (sideLength*Math.sin(Math.toRadians(angle))) );//3;
								break;
							case 3:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy - sideLength , Cz + (sideLength*Math.sin(Math.toRadians(angle))) );//3;
								break;
							default:
								System.out.println("fucked up11");
								break;
						}
						break;
					case XZ:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy - (sideLength*Math.sin(Math.toRadians(angle))) , Cz + sideLength );//3;
								break;
							case 3:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy + (sideLength*Math.sin(Math.toRadians(angle))) , Cz - sideLength );//3;
								break;
							default:
								System.out.println("fucked up12");
								break;
						}
						break;
					case YX:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx + sideLength , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz - (sideLength*Math.sin(Math.toRadians(angle))) );//3;
								break;
							case 3:
								brush.glVertex3d( Cx - sideLength , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz + (sideLength*Math.sin(Math.toRadians(angle))) );//3;
								break;
							default:
								System.out.println("fucked up13");
								break;
						}
						break;
					case YZ:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx - (sideLength*Math.sin(Math.toRadians(angle))) , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz + sideLength );//3;
								break;
							case 3:
								brush.glVertex3d( Cx + (sideLength*Math.sin(Math.toRadians(angle))) , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz - sideLength );//3;
								break;
							default:
								System.out.println("fucked up14");
								break;
						}
						break;
					case ZX:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx + sideLength , Cy - (sideLength*Math.sin(Math.toRadians(angle))) , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//3;
								break;
							case 3:
								brush.glVertex3d( Cx - sideLength , Cy + (sideLength*Math.sin(Math.toRadians(angle))) , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//3;
								break;
							default:
								System.out.println("fucked up12");
								break;
						}
						break;
					case ZY:
						switch(quadrant){
							case 1:
								brush.glVertex3d( Cx - (sideLength*Math.sin(Math.toRadians(angle))) , Cy + sideLength , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//3;
								break;
							case 3:
								brush.glVertex3d( Cx + (sideLength*Math.sin(Math.toRadians(angle))) , Cy - sideLength , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//3;
								break;
							default:
								System.out.println("fucked up12");
								break;
						}
						break;
					default:
						System.out.println("fucked up last");
						break;
					
				}
			}
			brush.glEnd();
		}
		else{//EVENS
			for(double angle = angleFrom ; angle > angleTo ; angle -= 0.001f ){
				//TODO Obey expand axis rules, change it to plane to plane
				brush.glVertex3d(Cx, Cy, Cz);//1
				//Up the second Axis
				switch(plane){
					case XY:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx , Cy + sideLength , Cz );//2
								break;
							case 4:
								brush.glVertex3d( Cx , Cy - sideLength , Cz );//2
								break;
							default:
								System.out.println("fucked upA");
								break;
						}
						break;
					case XZ:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx , Cy , Cz  + sideLength );//2
								break;
							case 4:
								brush.glVertex3d( Cx , Cy , Cz  - sideLength );//2
								break;
							default:
								System.out.println("fucked upB");
								break;
						}
						break;
					case YX:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx + sideLength , Cy , Cz );//2
								break;
							case 4:
								brush.glVertex3d( Cx - sideLength , Cy , Cz );//2
								break;
							default:
								System.out.println("fucked upA");
								break;
						}
						break;
					case YZ:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx , Cy , Cz + sideLength );//2
								break;
							case 4:
								brush.glVertex3d( Cx , Cy , Cz - sideLength );//2
								break;
							default:
								System.out.println("fucked upA");
								break;
						}
						break;
					case ZX:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx + sideLength , Cy , Cz );//2
								break;
							case 4:
								brush.glVertex3d( Cx - sideLength , Cy , Cz );//2
								break;
							default:
								System.out.println("fucked upB");
								break;
						}
						break;
					case ZY:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx , Cy + sideLength , Cz );//2
								break;
							case 4:
								brush.glVertex3d( Cx , Cy - sideLength , Cz );//2
								break;
							default:
								System.out.println("fucked upB");
								break;
						}
						break;
					default:
						System.out.println("fucked upC");
						break;
				}
				
				switch(plane){
					case XY:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy , Cz - (sideLength*Math.sin(Math.toRadians(angle))) );//4
								break;
							case 4:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy , Cz + (sideLength*Math.sin(Math.toRadians(angle))) );//4
								break;
							default:
								System.out.println("fucked upD");
								break;
						}
						break;
					case XZ:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy - (sideLength*Math.sin(Math.toRadians(angle))) , Cz );//4
								break;
							case 4:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy + (sideLength*Math.sin(Math.toRadians(angle))) , Cz );//4
								break;
							default:
								System.out.println("fucked upE");
								break;
						}
						break;
					case YX:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz - (sideLength*Math.sin(Math.toRadians(angle))) );//4
								break;
							case 4:
								brush.glVertex3d( Cx , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz + (sideLength*Math.sin(Math.toRadians(angle))) );//4
								break;
							default:
								System.out.println("fucked upD");
								break;
						}
						break;
					case YZ:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx - (sideLength*Math.sin(Math.toRadians(angle))) , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz );//4
								break;
							case 4:
								brush.glVertex3d( Cx  + (sideLength*Math.sin(Math.toRadians(angle))) , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz );//4
								break;
							default:
								System.out.println("fucked upD");
								break;
						}
						break;
					case ZX:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx , Cy - (sideLength*Math.sin(Math.toRadians(angle))) , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//4
								break;
							case 4:
								brush.glVertex3d( Cx , Cy + (sideLength*Math.sin(Math.toRadians(angle))) , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//4
								break;
							default:
								System.out.println("fucked upD");
								break;
						}
						break;
					case ZY:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx - (sideLength*Math.sin(Math.toRadians(angle))) , Cy , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//4
								break;
							case 4:
								brush.glVertex3d( Cx + (sideLength*Math.sin(Math.toRadians(angle))) , Cy , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//4
								break;
							default:
								System.out.println("fucked upD");
								break;
						}
						break;
					default:
						System.out.println("fucked upF");
						break;
				}
				
				switch(plane){
					case XY:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy + sideLength , Cz - (sideLength*Math.sin(Math.toRadians(angle))) );//3;
								break;
							case 4:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy - sideLength , Cz + (sideLength*Math.sin(Math.toRadians(angle))) );//3;
								break;
							default:
								System.out.println("fucked upG");
								break;
						}
						break;
					case XZ:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy - (sideLength*Math.sin(Math.toRadians(angle))) , Cz + sideLength );//3;
								break;
							case 4:
								brush.glVertex3d( Cx + (sideLength*Math.cos(Math.toRadians(angle))) , Cy + (sideLength*Math.sin(Math.toRadians(angle))) , Cz - sideLength );//3;
								break;
							default:
								System.out.println("fucked up H");
								break;
						}
						break;
					case YX:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx + sideLength , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz - (sideLength*Math.sin(Math.toRadians(angle))) );//3;
								break;
							case 4:
								brush.glVertex3d( Cx - sideLength , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz + (sideLength*Math.sin(Math.toRadians(angle))) );//3;
								break;
							default:
								System.out.println("fucked upG");
								break;
						}
						break;
					case YZ:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx - (sideLength*Math.sin(Math.toRadians(angle))) , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz + sideLength );//3;
								break;
							case 4:
								brush.glVertex3d( Cx + (sideLength*Math.sin(Math.toRadians(angle))) , Cy + (sideLength*Math.cos(Math.toRadians(angle))) , Cz - sideLength );//3;
								break;
							default:
								System.out.println("fucked upG");
								break;
						}
						break;
					case ZX:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx + sideLength , Cy - (sideLength*Math.sin(Math.toRadians(angle))) , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//3;
								break;
							case 4:
								brush.glVertex3d( Cx - sideLength , Cy + (sideLength*Math.sin(Math.toRadians(angle))) , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//3;
								break;
							default:
								System.out.println("fucked upG");
								break;
						}
						break;
					case ZY:
						switch(quadrant){
							case 2:
								brush.glVertex3d( Cx - (sideLength*Math.sin(Math.toRadians(angle))) , Cy + sideLength , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//3;
								break;
							case 4:
								brush.glVertex3d( Cx + (sideLength*Math.sin(Math.toRadians(angle))) , Cy - sideLength , Cz + (sideLength*Math.cos(Math.toRadians(angle))) );//3;
								break;
							default:
								System.out.println("fucked upG");
								break;
						}
						break;
					default:
						System.out.println("fucked upI");
						break;
					
				}

			}
			brush.glEnd();
		}
	}
	
	//Defaults to traveling in negative direction because its the same thing as traveling in positive direction
	//Y axis is Up when traveling x or z axis
	//Z axis is up when traveling y axis.
	private void createSquareTube(GL2 brush, double sideLength, double TLx, double TLy, double TLz, Axis direction, double stretchLength){
		//TODO Current
		brush.glBegin(GL2.GL_QUAD_STRIP);
		//Square 1
			//Point 1
			brush.glVertex3d( TLx , TLy , TLz );
			//Point 2
			if(direction == Axis.decX || direction == Axis.incX){
				brush.glVertex3d( TLx , TLy , TLz - sideLength );
			}
			else if( direction == Axis.decY || direction == Axis.incY){
				brush.glVertex3d( TLx - sideLength , TLy , TLz );
			}
			else if(direction == Axis.decZ || direction == Axis.incZ){
				brush.glVertex3d( TLx + sideLength  , TLy, TLz );
			}
			//Point 4
			if(direction == Axis.decX || direction == Axis.incX){
				brush.glVertex3d( TLx , TLy - sideLength , TLz );
			}
			else if( direction == Axis.decY || direction == Axis.incY){
				brush.glVertex3d( TLx , TLy , TLz - sideLength );
			}
			else if(direction == Axis.decZ || direction == Axis.incZ){
				brush.glVertex3d( TLx , TLy  - sideLength , TLz );
			}
			//point 3
			if(direction == Axis.decX || direction == Axis.incX){
				brush.glVertex3d( TLx , TLy - sideLength , TLz - sideLength );
			}
			else if( direction == Axis.decY || direction == Axis.incY){
				brush.glVertex3d( TLx  - sideLength , TLy , TLz - sideLength );
			}
			else if(direction == Axis.decZ || direction == Axis.incZ){
				brush.glVertex3d( TLx + sideLength , TLy - sideLength , TLz );
			}
		//Square 2
			for(double length = 0.0f ; length < stretchLength ; length += 0.0001f){
				//Point 1
				if(direction == Axis.decX || direction == Axis.incX){
					brush.glVertex3d( TLx - length , TLy , TLz );
				}
				else if( direction == Axis.decY || direction == Axis.incY){
					brush.glVertex3d( TLx , TLy - length , TLz );
				}
				else if(direction == Axis.decZ || direction == Axis.incZ){
					brush.glVertex3d( TLx  , TLy, TLz - length);
				}
				//Point 2
				if(direction == Axis.decX || direction == Axis.incX){
					brush.glVertex3d( TLx - length , TLy , TLz - sideLength );
				}
				else if( direction == Axis.decY || direction == Axis.incY){
					brush.glVertex3d( TLx - sideLength , TLy - length , TLz );
				}
				else if(direction == Axis.decZ || direction == Axis.incZ){
					brush.glVertex3d( TLx + sideLength  , TLy, TLz - length );
				}
				//Point 4
				if(direction == Axis.decX || direction == Axis.incX){
					brush.glVertex3d( TLx - length , TLy - sideLength , TLz );
				}
				else if( direction == Axis.decY || direction == Axis.incY){
					brush.glVertex3d( TLx , TLy - length , TLz - sideLength );
				}
				else if(direction == Axis.decZ || direction == Axis.incZ){
					brush.glVertex3d( TLx , TLy  - sideLength , TLz - length );
				}
				//point 3
				if(direction == Axis.decX || direction == Axis.incX){
					brush.glVertex3d( TLx - length , TLy - sideLength , TLz - sideLength );
				}
				else if( direction == Axis.decY || direction == Axis.incY){
					brush.glVertex3d( TLx  - sideLength , TLy - length , TLz - sideLength );
				}
				else if(direction == Axis.decZ || direction == Axis.incZ){
					brush.glVertex3d( TLx + sideLength , TLy - sideLength , TLz - length );
				}
			}
		
		
		brush.glEnd();
	}
}
