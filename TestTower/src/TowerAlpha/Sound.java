package TowerAlpha;

public class Sound {

	public void play(String filename) {
    	
    	// play only if sounds are not muted
    	if(GameBeta.sounds == true){
    		
    		
    		if(filename == "sounds/canonball_shot.wav"){
    			
    			//new Sound_Canon().play();
    			
    		}
    		
    		/*

    		try {

        		StdAudio.play(filename);
        		//StdAudio.close(); 
        		
    		} catch (Exception e) {
    			
    		}
*/
    		

    	}
        
    }

}
