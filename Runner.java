//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class Runner extends JFrame
{
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;

	public Runner()
	{
		super("Falling Gradient");
		setSize(WIDTH,HEIGHT);

		mainLoop theGame = new mainLoop();
		((Component)theGame).setFocusable(true);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		Runner run = new Runner();
	}
}