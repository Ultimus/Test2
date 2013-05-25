

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener{
	JButton end = new JButton("Beenden");
	JButton start = new JButton("Start");
	
	


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
	JFrame frame;
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
		System.out.println("Stellung:"+ s.getText());
		System.exit(1);
	}

}
}
