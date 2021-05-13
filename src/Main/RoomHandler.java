package Main;

import java.util.ArrayList;

public class RoomHandler {
	
	private ArrayList<Room> rooms;
	
	
	public RoomHandler() {
		rooms = new ArrayList<Room>();
	}
	
	public void add(Room r) {
		rooms.add(r);
	}
	
	public int size() {
		return rooms.size();
	}
	
	
	
}
