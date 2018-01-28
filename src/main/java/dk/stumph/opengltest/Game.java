package dk.stumph.opengltest;

import javax.swing.JFrame;

import com.jogamp.opengl.GL4;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

public class Game extends JFrame implements GLEventListener {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final String TITLE = "[stumph.dk] Minimal OpenGL Test";

	public Game() {
		super(TITLE);

		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		GLCanvas canvas = new GLCanvas(capabilities);
		canvas.addGLEventListener(this);

		this.getContentPane().add(canvas);
		this.setName(TITLE);
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		canvas.requestFocusInWindow();

	}

	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

		// TODO: call draw code here
		gl.glBegin(GL2.GL_LINE_LOOP);
		gl.glVertex3f(-0.50f, -0.75f, 0);
		gl.glVertex3f(0.7f, 0.5f, 0);
		gl.glVertex3f(0.70f, -0.70f, 0);
		gl.glVertex3f(0f, 0.5f, 0);

		gl.glEnd();

		gl.glBegin(GL2.GL_TRIANGLES); // Drawing Using Triangles

		gl.glVertex3f(0.1f, 0.1f, 0.0f); // Top
		gl.glVertex3f(-0.2f, -0.10f, 0.0f); // Bottom Left
		gl.glVertex3f(0.1f, -0.5f, 0.0f); // Bottom Right
		gl.glEnd();

		gl.glFlush();
	}

	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	public void init(GLAutoDrawable drawable) {
		GL4 gl = drawable.getGL().getGL4();
		gl.glClearColor(0.392f, 0.584f, 0.929f, 1.0f);

	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();

		// get the OpenGL 2 graphics object
		if (height <= 0)
			height = 1;

		// preventing divided by 0 exception height = 1;
		final float h = (float) width / (float) height;

		// display area to cover the entire window
		gl.glViewport(0, 0, width, height);

		// transforming projection matrix
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		// gl.gluPerspective(45.0f, h, 1.0, 20.0);

		// transforming model view gl.glLoadIdentity();
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	public void play() {

	}

}