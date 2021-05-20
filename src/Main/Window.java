package Main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;


/**
 * This project was based off an Internet urban legend called the Backrooms, a maze of halls that go on infinitely.
 * The data structure used here is based off the LinkedList and also Binary Trees, as that is how all the rooms are connected
 * through references to the next or previous room in itself, and the design of this program can allow for potentially
 * infinite amount of rooms.
 * 
 * Using this program is very simple. You first enter by pressing the enter button, and then traverse the rooms by clicking
 * the buttons present. The "GO BACK" button brings you to the previous room (unless it is the first room generated), the "NEXT"
 * button takes you to the next room, which is generated upon clicking the button (assuming the room isn't already generated).
 * The "TURN" does the same thing as the next button and is only an alternate choice. The "WARP" button takes you to a random
 * room that was already generated. There is a 20% chance to get a split room, a 4% chance to get a warp option, and also a 0.4%
 * chance to reach a special "dead" room where you are stuck forever :).
 *
 */
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
		
		//setLayout(new GridLayout());
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
