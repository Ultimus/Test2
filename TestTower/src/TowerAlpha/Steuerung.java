package TowerAlpha;

public class Steuerung extends Thread{


	public void run() {
		try {
			
	   
			GameBeta.watchMouse();
			sleep(0);
			GameBeta.watchMouse();
	    }
	    catch(InterruptedException e) {
	    	        
	    }    

	    GameBeta.watchMouse();
	}
	  

	
}
