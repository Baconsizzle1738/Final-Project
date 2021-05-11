package Main;

import java.awt.Dimension;

import javax.swing.JPanel;

public abstract class Room extends JPanel{
	
	/**
	 * A reference to the next room.
	 */
	private Room next;
	
	/**
	 * A reference to a previous room.
	 */
	private Room prev;
	
	/**
	 * A reference to a branched room.
	 */
	private Room side;
	
	/**
	 * ?????????????????????
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * This is an individual room that the player can enter and exit.
	 */
	public Room(Room prev) {
		super();
		setVisible(true);
		setPreferredSize(new Dimension(1000, 700));
		
		this.prev = prev;
	}
	
	/**
	 * Changes the room that cones after.
	 * @param r	The new Room.
	 */
	public void setNext(Room r) {
		next = r;
	}
	
	/**
	 * Changes the room to the side.
	 * @param r	The new Room.
	 */
	public void setSide(Room r) {
		side = r;
	}
	
	/**
	 * Changes the origin of the room.
	 * @param r	New room origin.
	 */
	public void setPrevious(Room r) {
		prev = r;
	}
	
	/**
	 * Returns the next room.
	 * @return	The next Room.
	 */
	public Room getNext() {
		return next;
	}
	
	/**
	 * Returns the side room.
	 * @return	The Room to branch.
	 */
	public Room getSide() {
		return side;
	}
	
	/**
	 * Returns the previous room.
	 * @return	The previous Room.
	 */
	public Room getPrevious() {
		return prev;
	}
	

}
