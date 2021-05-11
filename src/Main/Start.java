package Main;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;

/**
 * This is the starting room.
 * @author Baconsizzle1738
 *
 */
public class Start extends Room{
	
	/**
	 * ???????????
	 */
	private static final long serialVersionUID = 1L;
	
	Random r;
	
	
	public Start () {
		super(null);
		r = new Random();
		
		setBackground(new Color(r.nextInt(11)+90, r.nextInt(11)+90, r.nextInt(11)+90));
		JButton next = new JButton("ENTER");
		next.setBackground(new Color(160, 0, 0));
		add(next);
		
		
	}
	
}
