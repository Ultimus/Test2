package testtower;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.*;

public class GUI2 {
	
	public static LinkedList shipList;
	
	public static JFrame frame = new JFrame ("Giga TD");
	
	
	public static void init(Path[] parry, LinkedList list){
		
		//Initialisiert das Fenster, mit dem Hintergrund back1 
		//Holt sich ueber den Weg Array die Position der Wege
		//Zeichnet die Wege auf den Hintergrund
		//In der Liste wird die Schiff Liste uerbegeben
		//Schiff generetaion muss ich in externe Methode ausgelagert werden
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		final Icon background = new ImageIcon("back1.png");
		JLabel back = new JLabel (background);
		
		shipList = new LinkedList();				//Liste wird initialisiert
			
		Enemy compareE; 
		final Icon boatIcon = new ImageIcon("testschiff1.png");
		JLabel[] boat  = new JLabel[list.size()];
		
		for(int k = 0; k<list.size(); k++){
			compareE = (Enemy)list.get(k);
			boat[k] = new JLabel(boatIcon);
			boat[k].setBounds(compareE.getX(), compareE.getY(),	compareE.getWidth(), compareE.getHeigth());
			frame.add(boat[k]);
		}// Liste an Schiffen wird durchgegangen

		
		
		
		final Icon wayIcon = new ImageIcon("weg.png");
		JLabel[] way  = new JLabel[parry.length];
		
		for(int i = 0; i < parry.length; i++){
			
			way[i] = new JLabel(wayIcon);
			way[i].setBounds(parry[i].getX(), parry[i].getY(), parry[i].getSize(), parry[i].getSize());
			frame.add(way[i]);
		}
		
		
		frame.add(back);
		
		

		frame.pack();
		frame.setVisible(true);
		
		
		
	}//init
	
	
	public static void drawMove(LinkedList<Enemy> list){
		
		Enemy compareE; 
		final Icon wayIcon = new ImageIcon("qqq.png");
		JLabel[] boat  = new JLabel[list.size()];
		
		for(int k = 0; k<list.size(); k++){
			compareE = (Enemy)list.get(k);
			boat[k] = new JLabel(wayIcon);
			boat[k].setBounds(compareE.getX(), compareE.getY(),	compareE.getWidth(), compareE.getHeigth());
			frame.add(boat[k]);
			
			
		}
		frame.setVisible(true);
	}
	

	
}


		
		
		
		
		/*
		 * frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setLayout( new FlowLayout() );
		// Button 1:
		final Icon icon1 = new ImageIcon("hitlerbot.png" );
		final Icon icon2 = new ImageIcon("a.jpeg" );
		final JButton button1 = new JButton( icon1 );
		frame.add( button1 );
		ActionListener al = new ActionListener() {
		public void actionPerformed( ActionEvent e ) {
		button1.setIcon( icon2 );
		}
	};
		 */
