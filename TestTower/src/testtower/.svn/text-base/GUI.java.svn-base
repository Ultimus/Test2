package testtower;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI {
	public static void main( String[] args ){
		JFrame frame = new JFrame ("Giga TD");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		final Icon background = new ImageIcon("testback1.png");
		JLabel back = new JLabel (background);
		final Icon Enemy = new ImageIcon ("testschiff1.png");
		final JLabel Enemy1 = new JLabel (Enemy);
		Enemy1.setBounds(0, 0, 100, 100);
		frame.add(Enemy1);
		frame.add(back);
		
		

		frame.pack();
		frame.setVisible(true);
		
		frame.addMouseListener( new MouseAdapter() {
			public void mouseClicked( MouseEvent ereignis ) {
				
				int x = ereignis.getX()-70;
				int y = ereignis.getY()-70;
				Enemy1.setLocation(x, y);
			}
		});
		
	}
}
		
		
		
		

