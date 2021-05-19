package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TravelRoom extends Room implements ActionListener{
	
	/**
	 * ?????????????????????????????????
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Determines properties of room and if it behaves like a tree node or a link node.
	 */
	int isDead, isWarp, isSplit;

	public TravelRoom(Room prev, RoomHandler h) {
		super(prev, h);
		
		System.out.println("REE");
		
		setLayout(null);
		setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		setPreferredSize(new Dimension(1000, 700));
		
		//20% chance for 2 next rooms, 0.5% chance for a dead room, and 5% chance for a warp to a random previous room.
		isSplit = r.nextInt(5);
		isWarp = r.nextInt(20);
		isDead = r.nextInt(200);
		
		JButton back = new JButton("GO BACK");
		back.setBackground(new Color(130, 130, 130));
		back.addActionListener(this);
		add(back);
		
		
		if (isDead != 0) {
			JButton next = new JButton("NEXT");
			next.setBackground(new Color(0, 0, 210));
			next.addActionListener(this);
			next.setBounds(200, 200, 70, 20);
			add(next);
			
			if (isWarp == 0 && handler.size() >= 5) {
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
			getParent().validate();
			getParent().remove(this);
			prev.getParent().revalidate();
		}
		
		if (source.equals("NEXT")) {
			if (next == null) {
				next = new TravelRoom(this, handler);
				handler.add(next);
			}
			getParent().add(next);
			getParent().validate();
			getParent().remove(this);
			next.getParent().revalidate();
		}
		
		if (source.equals("TURN")) {
			if (side == null) {
				side = new TravelRoom(this, handler);
				handler.add(side);
			}
			getParent().add(side);
			getParent().validate();
			getParent().remove(this);
			side.getParent().revalidate();
		}
		
		if (source.equals("WARP")) {
			Room randWarp = handler.get();
			getParent().add(randWarp);
			getParent().validate();
			getParent().remove(this);
			randWarp.getParent().revalidate();
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String s = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm`1234567890-=~!@#$%^&*()_+[]{}|;':,.<>";
		if (isDead == 0) {
			g.setFont(new Font(Font.MONOSPACED, 0, 12));
			
			setBackground(Color.black);
			g.setColor(new Color(0, 100, 0));
			g.fillOval(250, 133, 500, 500);
			g.setColor(Color.black);
			g.fillOval(380, 300, 70, 70);
			g.fillOval(550, 300, 70, 70);
			g.fillRect(30, 325, 900, 20);
			g.fillRect(355, 500, 300, 20);
			
			g.setColor(new Color(0f, 0.52f, 0f, 0.5f));
			for (int y = 0; y<14; y++) {
				for (int x = 0; x<200; x++) {
					int ind = r.nextInt(s.length()-1);
					g.drawString(s.substring(ind), y*80, x*5);
				}
			}
			
		}
		repaint();
		
		
	}
	
}
