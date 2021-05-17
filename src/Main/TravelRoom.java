package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TravelRoom extends Room implements ActionListener{
	
	/**
	 * ?????????????????????????????????
	 */
	private static final long serialVersionUID = 1L;
	

	public TravelRoom(Room prev, RoomHandler h) {
		super(prev, h);
		
		System.out.println("REE");
		
		setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		setPreferredSize(new Dimension(1000, 700));
		
		//20% chance for 2 next rooms, 0.5% chance for a dead room, and 5% chance for a warp to a random previous room.
		int isSplit = r.nextInt(5);
		int isWarp = r.nextInt(20);
		int isDead = r.nextInt(200);
		
		JButton back = new JButton("GO BACK");
		back.setBackground(new Color(130, 130, 130));
		back.addActionListener(this);
		add(back);
		
		
		if (isDead != 0) {
			JButton next = new JButton("NEXT");
			next.setBackground(new Color(0, 0, 210));
			next.addActionListener(this);
			add(next);
			
			if (isWarp == 0 && handler.size() >= 3) {
				JButton warp = new JButton("WARP");
				warp.setBackground(new Color(0, 210, 0));
				warp.addActionListener(this);
				add(warp);
			}
			if (isSplit == 0) {
				JButton split = new JButton("TURN");
				split.setBackground(new Color(210, 0, 0));
				split.addActionListener(this);
				add(split);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String source = ((JButton) e.getSource()).getText();
		if (source.equals("GO BACK") && prev != null) {
			getParent().add(prev);
			getParent().revalidate();
			getParent().remove(this);
		}
		
		if (source.equals("NEXT")) {
			if (next == null) {
				next = new TravelRoom(this, handler);
				handler.add(next);
			}
			getParent().add(next);
			getParent().revalidate();
			getParent().remove(this);
		}
		
		if (source.equals("TURN")) {
			if (side == null) {
				side = new TravelRoom(this, handler);
				handler.add(side);
			}
			getParent().add(side);
			getParent().revalidate();
			getParent().remove(this);
		}
		
	}
	
}
