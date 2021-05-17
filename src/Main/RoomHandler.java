package Main;

import java.util.ArrayList;
import java.util.Random;

public class RoomHandler {
	
	private ArrayList<Room> rooms;
	
	private Random r;
	
	public RoomHandler() {
		rooms = new ArrayList<Room>();
		
		r = new Random();
	}
	
	public void add(Room r) {
		rooms.add(r);
	}
	
	public int size() {
		return rooms.size();
	}
	
	public Room get() {
		return rooms.get(r.nextInt(rooms.size()-3));
	}
	
}
