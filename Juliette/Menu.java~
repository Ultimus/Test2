

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener{
	JButton end = new JButton("Beenden");
	JButton start = new JButton("Start");
	JFrame frame = new JFrame("Juliette");
	
	


	public Menu(String Title){
		super(Title);

	// Baue Rahmen
	
	


	//Buttons	
	

	end.setBounds(120,120,160,40);
	end.addActionListener(this);
	add(end);
	
	start.addActionListener(this);
	start.setBounds(120, 200, 160,40);
	add(start);
	this.pack();
	
	
	
}

public static void main (String args[]){
	Menu w = new Menu("Juliette");
	
	w.setLayout(null);
	w.setVisible(true);
	w.setResizable(false);
	w.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	w.setSize(640,480);

	w.setLocationRelativeTo(null);

	}
public void actionPerformed(ActionEvent e){
	if(e.getSource() == end)
		System.exit(1);
	if(e.getSource() == start){
		Engine a = new Engine();
		Stellung s =a.roll();
		showIt(s);
		System.out.println("Stellung:"+ s.getText());
		//System.exit(1);
	}

}

public void showIt (Stellung s){
	switch(s.getId()){
	case 1:
	StdDraw.picture(0.5,0.5,"doggy.png");
	break;
	case 2:
	StdDraw.picture(0.5,0.5,"cowgirl.png");
	break;
	case 3:
	StdDraw.picture(0.5,0.5, "sixtynine.png");
	break;
	}

	
	
}


}
