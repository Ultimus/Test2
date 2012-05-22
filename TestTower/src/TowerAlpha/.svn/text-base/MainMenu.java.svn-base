/**
 * This class shows our logo as intro and the main menu afterwards
 */
package TowerAlpha;

import java.awt.Font;

//import java.awt.Color;

public class MainMenu {

   // window size
   public static final int WIDTH = 1024;
   public static final int HEIGHT = 720;
   public static boolean game_launched = false;
   
   // playername
   public static String playername = "A";
   
   // init intro and draw main menu 
   public static void main(String[] args) {
      
      // set window size and scaling
      StdDraw.setCanvasSize(WIDTH, HEIGHT);
      StdDraw.setXscale(0, WIDTH);
      StdDraw.setYscale(0, HEIGHT);
      
      drawIntro();
      drawMainMenu();
      /*
      switch(drawMainMenu()){
         
         case 1 : GameAlpha.main(args); 
                  break;
                  
         case 2: drawHighscore();
                  break;
                  
         default: System.exit(0);
         
      }*/

      
   }
   
   // render intro
   public static void drawIntro() {

      StdDraw.picture(WIDTH/2, HEIGHT/2, "Menu.png");
      
      for(int i = 1; i < 80; i++){
    	  
         StdDraw.picture(WIDTH/2, HEIGHT/2, "maximus_logo.png", 16*i, 9*i);
      
      }
      StdDraw.setPenColor(StdDraw.WHITE);
	  StdDraw.setFont(new Font("Arial", Font.PLAIN, 22));
      StdDraw.text(WIDTH/2, HEIGHT/4, " presents ");
      
      // idle to show logo
      try {
         Thread.sleep(1000);
      } catch(Exception e) {}
      
   }
   
   public static void drawMainMenu(){
      
      StdDraw.clear(StdDraw.MM_SEABLUE);
      
      StdDraw.picture(WIDTH/2, HEIGHT/2, "Menu.png");
      
      StdDraw.picture(WIDTH/2, HEIGHT-HEIGHT/7, "maximus_logo.png", 16*50, 9*50);
    
      StdDraw.picture(WIDTH/2, HEIGHT/2+100, "menu_new_game.png");
      StdDraw.picture(WIDTH/2, HEIGHT/2,     "menu_highscore.png");
      StdDraw.picture(WIDTH/2, HEIGHT/2-100, "menu_tutorial.png");
      StdDraw.picture(WIDTH/2, HEIGHT/2-200, "menu_exit.png");
      
      // this avoids reclicking the highscore button if you go back from highscore view to main menu by blocking the button for 250ms
      try { Thread.sleep(250); } catch (Exception e) { }
      
      while(true) {
          
         //System.out.println("x=" + StdDraw.mouseX() + " y=" + StdDraw.mouseY());
         
         // new game button
         if(StdDraw.mouseX() > 490 && StdDraw.mouseX() < 790 && StdDraw.mouseY() > 445  && StdDraw.mouseY() < 475){
            
            if(StdDraw.mousePressed() == true) {
               // this fixes a bug that towers get build with the same mouse click you start the game
               try { Thread.sleep(250); } catch (Exception e) { }
               
               /*
               char key = 0;
               
               while(playername.length() < 3){
                  
                  if(StdDraw.hasNextKeyTyped()){
                       key = StdDraw.nextKeyTyped();
                  }
                  
                  if(key != 0){
                     
                     playername = playername.concat(String.valueOf(key));
                     playername.
                     
                     
                  }

                  System.out.println(playername);
                  
               }
               */
               
               GameOption();

               //return 1;
            }
               
         }
         
         // highscore button
         if(StdDraw.mouseX() > 490 && StdDraw.mouseX() < 790 && StdDraw.mouseY() > 345  && StdDraw.mouseY() < 375){
            
            if(StdDraw.mousePressed() == true){
               drawHighscore();
               //return 2;
            }
               
         }
         
         // tutorial button
         if(StdDraw.mouseX() > 490 && StdDraw.mouseX() < 790 && StdDraw.mouseY() > 245  && StdDraw.mouseY() < 275){
            
            if(StdDraw.mousePressed() == true){
               Tutorial.drawTutorialIntro();
               //return 2;
            }
               
         }
      
         // exit button
         if(StdDraw.mouseX() > 490 && StdDraw.mouseX() < 790 && StdDraw.mouseY() > 145  && StdDraw.mouseY() < 175){
            
            if(StdDraw.mousePressed() == true)
               System.exit(0);
         }
            
         
      }
   }
   
   public static void drawHighscore(){
      
      StdDraw.clear(StdDraw.MM_SEABLUE);
      StdDraw.picture(WIDTH/2, HEIGHT/2, "background5.png");
      StdDraw.picture(WIDTH/2, HEIGHT-HEIGHT/7, "maximus_logo.png", 16*50, 9*50);
      
      String highscoretxt = HighScore.show();
      //String highscoretxt = "1;Mirko;1337;10.06.2011;2;Max;100;09.06.2011";
      
      if(highscoretxt.equals("1")) {
         
         StdDraw.text(WIDTH/2, HEIGHT/2+100, "Error: No connection to the internet! Unable to display highscore list!");
         
      } else {
         
         String [] hs = highscoretxt.split(";");
         
         StdDraw.setPenColor(StdDraw.WHITE);
         StdDraw.setFont(new Font("Arial", Font.PLAIN, 20));
         
         StdDraw.text(WIDTH/2, HEIGHT/2+150, "# Name Score Date");
               
         for(int i = 0; i < (hs.length); i+=4) {
         
            if(i % 4 == 0) System.out.println();
            
            // #1 Mirko 1337 10.06.2011
            
            String line = "#" + hs[i] + "   " + hs[i+1] + "   " + hs[i+2] + "   " + hs[i+3];
            
            //System.out.print(line);
            //StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(WIDTH/2, HEIGHT/2+100-i*10, line);
            
         }
         
         StdDraw.picture(WIDTH/2, HEIGHT/12, "back.png");
         
         while(true) {
            if(StdDraw.mousePressed() == true) drawMainMenu();
         }
            
         
      }
      
   }  
      
      //StdDraw.text(WIDTH/2, HEIGHT/2, hs);
      
      
       
     public static void GameOption(){
         StdDraw.clear(StdDraw.MM_SEABLUE);
         StdDraw.picture(WIDTH/2, HEIGHT/2, "background5.png");
         StdDraw.picture(WIDTH/2, HEIGHT-HEIGHT/7, "maximus_logo.png", 16*50, 9*50);
         
         StdDraw.setPenColor(StdDraw.WHITE);
	     StdDraw.setFont(new Font("Arial", Font.PLAIN, 18));
         
         StdDraw.picture(WIDTH/2, HEIGHT/2+100, "easy.png");
         StdDraw.text(WIDTH/2, HEIGHT/2+50, "Startmoney: 600  -   Wavelevel: 1");
         
         StdDraw.picture(WIDTH/2, HEIGHT/2,     "medium.png");
         StdDraw.text(WIDTH/2, HEIGHT/2-50, "Startmoney: 600  -   Wavelevel: 3");
         
         StdDraw.picture(WIDTH/2, HEIGHT/2-100, "hard.png");
         StdDraw.text(WIDTH/2, HEIGHT/2-150, "Startmoney: 800  -   Wavelevel: 5");
         while(true){
	           	if(StdDraw.mouseX() > 360 && StdDraw.mouseX() < 670 && StdDraw.mouseY() < 470  && StdDraw.mouseY() > 450){
		            
		            if(StdDraw.mousePressed() == true) {
		            
		               // this fixes a bug that towers get build with the same mouse click you start the game
		               try { Thread.sleep(250); } catch (Exception e) { }
		               
		               game_launched = true; // this is for setWindow in GameAlpha as the window is already set here, it doesnt get moved again
		               String [] args = {};
		               GameBeta.main(args);
		            }
               	}
	         	if(StdDraw.mouseX() > 360 && StdDraw.mouseX() < 670 && StdDraw.mouseY() < 370  && StdDraw.mouseY() > 350){
		            
		            if(StdDraw.mousePressed() == true) {
		               // this fixes a bug that towers get build with the same mouse click you start the game
		               try { Thread.sleep(250); } catch (Exception e) { }
		               
		               GameBeta.wavelevel = 3;
		               game_launched = true; // this is for setWindow in GameAlpha as the window is already set here, it doesnt get moved again
		               String [] args = {};
		               GameBeta.main(args);
		            }
	         	}
	         	if(StdDraw.mouseX() > 360 && StdDraw.mouseX() < 670 && StdDraw.mouseY() < 270  && StdDraw.mouseY() > 250){
		            
		            if(StdDraw.mousePressed() == true) {
		            	
		               // this fixes a bug that towers get build with the same mouse click you start the game
		               try { Thread.sleep(250); } catch (Exception e) { }
		               
		               GameBeta.wavelevel = 5;
		               GameBeta.gold = 800;
		               game_launched = true; // this is for setWindow in GameAlpha as the window is already set here, it doesnt get moved again
		               String [] args = {};
		               GameBeta.main(args);
		            }
	         	}
         }
     }
}

   
