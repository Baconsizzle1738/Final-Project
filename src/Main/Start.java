package Main;

import java.awt.Color;
import java.util.Random;

public class Start extends Room{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Random r;
	
	public Start () {
		super();
		r = new Random();
		setBackground(new Color(r.nextInt(101), r.nextInt(101), r.nextInt(101)));
		
		
	}
	
}
