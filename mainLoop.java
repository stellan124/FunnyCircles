//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import static java.lang.Character.*;

import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class mainLoop extends JPanel implements Runnable, MouseListener,
		MouseMotionListener, MouseWheelListener {
	private BufferedImage back;
	private int[] mousePos = new int[2];
	private boolean[] mouseButtons = new boolean[3];
	private CircleGroup Circles;
	private double speed = 0.5;
	// double xPos, double yPos,double speed,Color c
	private Circle cursorCircle = new Circle(0, 0, 0, Color.black);

	public mainLoop() {
		setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.addMouseWheelListener(this);
		new Thread(this).start();
		Circles = new CircleGroup(200);
		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		window.setColor(Color.black);
		window.fillRect(0, 0, 1920, 1080);
		window.setColor(Color.yellow);
		window.drawString("" + speed, 100, 50);
		cursorCircle.setPos(mousePos[0], mousePos[1]);
		Circles.stayOutOfCircle(cursorCircle);
		Circles.setGroupSpeed(speed);
		Circles.followPoint(mousePos[0], mousePos[1]);
		if (mouseButtons[0]) {
			Circles.moveGroup();
		}
		cursorCircle.draw(window);
		Circles.drawGroup(window);
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton() == 1) {
			if (mouseButtons[0]) {
				mouseButtons[0] = false;
			} else {
				mouseButtons[0] = true;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePos = new int[] { e.getX(), e.getY() };
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePos = new int[] { e.getX(), e.getY() };
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if (e.getWheelRotation() > 0) {
			if (e.isShiftDown()) {
				speed += 1;
			} else {
				speed += 0.1;
			}
		} else if (e.getWheelRotation() < 0) {
			if (e.isShiftDown()) {
				speed -= 1;
			} else {
				speed -= 0.1;
			}
		}
	}

}
