package Main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

/**
 * This is the starting room.
 * @author Baconsizzle1738
 *
 */
public class Start extends Room implements ActionListener{
	
	/**
	 * ???????????
	 */
	private static final long serialVersionUID = 1L;
	
	Random r;
	
	
	public Start (RoomHandler h) {
		super(null);
		r = new Random();
		
		setBackground(new Color(r.nextInt(11)+90, r.nextInt(11)+90, r.nextInt(11)+90));
		JButton next = new JButton("ENTER");
		next.setBackground(new Color(160, 0, 0));
		add(next);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("ENTER")) {
			this.getParent().remove(this);
		}
	}

}
