package Main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	/**
	 * ?????
	 */
	private static final long serialVersionUID = 1L;
	
	
	RoomHandler handler;
	
	
	/**
	 * The main JFrame for the project.
	 * @param title	Title of window.
	 */
	public Window (String title) {
		super();
		handler = new RoomHandler();
		
		setLayout(new GridLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setVisible(true);
		setPreferredSize(new Dimension(1000, 700));
		setResizable(false);
		setBackground(new Color(100, 100, 100));
		Container c = getContentPane();
		
		c.add(new Start(null, handler));
		
		pack();
	}
	
	
	public static void main(String[] args) {
		new Window("LABYRINTH");
	}
	
	
	
}
