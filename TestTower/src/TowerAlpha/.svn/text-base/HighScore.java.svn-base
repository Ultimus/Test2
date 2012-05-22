package TowerAlpha;

/*
 * HighScore
 *    Upload and Download via Online HTTP Web Server
 *    via PHP Script
 *    stored in MySQL Database
 * 
 * http://mgamez.eu/propra/index.php?do=&name=&score=&hash=
 * 
 * PHP Parameter:
 *    "do": 
 *       Options "upload" 
 *                = enables score upload with 3 required parameters
 *                   1. name = name of player
 *                   2. score = score
 *                   3. hash = md5sum("name score 1337"); (anti-cheat) (not yet implemented)
 *                   
 *     returns 1 if upload worked
 *     returns 0 if online but upload failed
 *     returns CHEATER if online but hash modified
 *                
 *                
 *    "show": 
 *       no options
 *          = shows top100 highscore list in xml format 
 *             to be displayed ingame
 *             sorted by points descending
 *    
 * */

import java.net.URL;
import java.util.Scanner;


public class HighScore {

   // for testing
   /*
   public static void main (String [] args) {
      int r = upload("TEST2", 10000);
      //String r = show();
      System.out.println(r);
   }
   */
   
   /*
    *    sends data to http://mgamez.eu/propra/index.php?name= NAME &score= SCORE &h= HASH
    *       returns 0 on success
    *       returns 1 on error
    */
   public static int upload (String name, int score) {
      
      try {
        
    	  String url = "http://mgamez.eu/propra/?do=upload&score=" + score + "&name=" + name;
    	  
    	  //System.out.println(url);
    	  
         URL mgamez = new URL(url);
         String result = new Scanner(mgamez.openStream()).useDelimiter("\\Z").next();
         if(result.equals("0")) {
        	 return 0; // success
         }           	
          else {
        	  System.out.println("Highscore Upload ErrorID: " + result);
        	  return 1; // error
          }
            
         
      } catch(Exception e) {
         
         e.printStackTrace();
         return 1;
         
      }
      
   }
   
   /*
    * gets highscore list via xml
    *    returns 
    * */
   public static String show () {
      
      try {
         
         URL mgamez = new URL("http://mgamez.eu/propra/?do=show");
         String result = new Scanner(mgamez.openStream()).useDelimiter("\\Z").next();
         return result;

         
      } catch(Exception e) {
         
         e.printStackTrace();
         return "1";
         
      }
      
   }
}
