import java.awt.Robot;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.awt.AWTException;


public class klickbot{
	

	public static void main (String [] args){
		try { 
			Robot Robo = new Robot();
			Robo.mouseMove(100,200);
		}
		catch (AWTException e){
			throw new RuntimeException("Failed",e);
		}
		Robo.mouseMove(100,200);
		
	
	}
}

class MyMouseListener extends MouseAdapter {
	public void mousePressed(MouseEvent e){
	System.out.println (e.getX()+" "+e.getY());
	}
}
