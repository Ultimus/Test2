import java.util.*;
import java.awt.Color;
import javax.swing.*;


public class Display extends JApplet{
	

	public static void main (String[] args){
	Display a=new Display();
	
	}

	public Display (){
	StdDraw.setXscale (-1, 1);
	StdDraw.setYscale (-1, 1);
	//StdDraw.picture(0, 0, "BN.gif");
	ImageIcon icon = new ImageIcon ("BN.gif");
	getContentPane().add(new JLabel(icon));
	
	}

	

	/*public void first (){
	
	if (Hit== true){
		StdDraw.picture (2, 8, Hit);
	}
	

	if (Crit_Hit == true){
		StdDraw.picture (2, 8, Crit);
	}

	if (evade == true){
		StdDraw.picture (2, 8, eva);
}
}
	public void second (){
	
	 if (Hit== true){
		StdDraw.picture (8, 8, Hit);
	}
	

	if (Crit_Hit == true){
		StdDraw.picture (8, 8, Crit);
	}

	if (evade == true){
		StdDraw.picture (8, 8, eva);
	}

}*/

	/*public void text (Hit, DMG){
	
	if (Hit == true ){
	StdDraw.text (3, 5, ""+ Name+ " Trifft das Ziel.\n"+Name2 + "erleidet" +DMG+ "Schaden.");
	}

	if (Crit == true){
	StdDraw.text (3, 5, ""+Name+ "landet einen Crittischen Treffer. WOHAAA!\n" +Name2+ "erleidet" +DMG+ "Schaden.");
	}

	if (evade == true){
	StdDraw.text (3,5, ""+Name+ "Ist dem Angriff ausgewichen.");
	}
}*/



}
