package Main;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

public class Start extends Room{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Random r;
	
	public Start () {
		super();
		r = new Random();
		setBackground(new Color(r.nextInt(11)+90, r.nextInt(11)+90, r.nextInt(11)+90));
		JButton next = new JButton("NEXT ROOM");
		
	}
	
}
