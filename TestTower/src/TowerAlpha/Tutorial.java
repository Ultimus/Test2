package TowerAlpha;

//import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;
public class Tutorial{
	
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 720;
	public static boolean game_launched = false;

	public static void drawTutorialIntro(){
	      
	      StdDraw.clear(StdDraw.MM_SEABLUE); // bg sea
	      StdDraw.picture(WIDTH/2, HEIGHT/2, "background5.png"); // bg
	      StdDraw.picture(WIDTH/2, HEIGHT-HEIGHT/7, "maximus_logo.png", 16*50, 9*50); // top logo
	      
	      // font settings
	      StdDraw.setPenColor(StdDraw.WHITE);
	      StdDraw.setFont(new Font("Arial", Font.PLAIN, 18));

	      
	      StdDraw.textLeft(200, 525, "Das Prinzip einer TowerDefense ist das folgende:");
	      StdDraw.textLeft(200, 500, "Es erscheinen feindliche Einheiten die ihren Weg von A nach B versuchen zu bestreiten");
	      StdDraw.textLeft(200, 475, "Sofern sie ihr Ziel erreichen wird ein Leben abgezogen");
	      StdDraw.textLeft(200, 450, "Wenn die Anzahl der Leben auf 0 sinkt haben wir VERLOREN");
	      StdDraw.textLeft(200, 425, "Damit dies nicht passiert bauen wir Türme um die Feinde aufzuhalten");
	      
	      StdDraw.textLeft(200, 390, "In unserm Fall wären es verschiedene Piratenschiffe,");
	      StdDraw.textLeft(200, 365, "die versuchen zur Totenkopfhöhle zu gelangen um den versunkenen Schatz zu finden");
	      StdDraw.textLeft(200, 340, "Wir versuchen diese mit Hilfe von unsern 3 Türmen aufzuhalten");
	      
	      StdDraw.textLeft(200, 305, "Unser Kanoneturm macht normalen Schaden an den Gegnern");
	      StdDraw.textLeft(200, 280, "Unsere Rumkanone weniger Schaden, aber verlangsamt die Gegner");
	      StdDraw.textLeft(200, 255, "Unsere Windmühle gleichen Schaden und zusätzlich noch Zeitschaden");
	      
	      StdDraw.textLeft(200, 230, "Es gibt verschiedene Gegnertypen");
	      StdDraw.textLeft(200, 205, "Das normale Schiff hat eben normal ;)");
	      StdDraw.textLeft(200, 180, "Das Floss ist schneller, aber hat weniger Lebenspunkte");
	      StdDraw.textLeft(200, 155, "Der nächste Gegner folgt noch");
	      
	      StdDraw.picture(WIDTH/2, HEIGHT/10, "start.png");
	      // back to main menu
	      StdDraw.picture(WIDTH/2, HEIGHT/10-50, "back.png");
	      
	      while(true) {
	    	//System.out.prnintln("x=" + StdDraw.mouseX() + " y=" + StdDraw.mouseY());       
	    	         // start tutorial button
	    	        if(StdDraw.mouseX() > 404 && StdDraw.mouseX() < 623 && StdDraw.mouseY() < 79  && StdDraw.mouseY() > 66){
	    	            
	    	            if(StdDraw.mousePressed() == true) {
	    	               // this fixes a bug that towers get build with the same mouse click you start the game
	    	               try { Thread.sleep(250); } catch (Exception e) { }
	    	               
	    	               //game_launched = true; // this is for setWindow in GameAlpha as the window is already set here, it doesnt get moved again
	    	               drawTutorialstep1();

	    	               //return 1;
	    	            }
	    	               
	    	         }
	    	         // back to main menu
	    	         if(StdDraw.mouseX() > 404 && StdDraw.mouseX() < 623 && StdDraw.mouseY() < 29  && StdDraw.mouseY() > 16){
	    	            
	    	            if(StdDraw.mousePressed() == true) {
	    	               
	    	               //System.out.println("MOUSE PRESSED!!");   
	    	               MainMenu.drawMainMenu();
	    	                  
	    	            }
	    	         }
	      }
	    	         
	      }
	public static void drawTutorialstep1(){

		GameBeta.enemies = new LinkedList<Enemy>();
		GameBeta.towers = new LinkedList<Tower>();
		GameBeta.balls = new LinkedList<CanonBall>();
		GameBeta.bombs = new LinkedList<Bomb>();
		GameBeta.gold = 900;
		
		GameBeta.mapOne(); // erstellt ein Array des Weges		
		
		GameBeta.setWindow();

		while(GameBeta.lifes > -10) { 
			   //Game Loop

			   if(GameBeta.lifes > 0){
				   while(GameBeta.start==false){//gibt dem spieler zeit die türme zu bauen bevor er startet 
					   	GameBeta.watchMouse();
			
			   			StdDraw.clear(StdDraw.MM_SEABLUE);
			   			StdDraw.picture(WIDTH/2+125, HEIGHT/2, "background5_tut.png");
			   			
			   			GameBeta.setWay(GameBeta.path);
			   		
			   			StdDraw.picture(WIDTH-107, GameBeta.schaedelPos-18, "SchadelHinten.png"); //357
			   							   			
			   			StdDraw.picture(WIDTH-54,GameBeta.schaedelPos, "SchadelVorne.png");
			   			StdDraw.picture(750, 75, "start.png");
			   			StdDraw.setPenColor(StdDraw.WHITE);
			   			StdDraw.setFont(new Font("Arial", Font.PLAIN, 18));
			   			StdDraw.text(700, 600, "Unser Startgehalt betraegt 800G");
			   			StdDraw.text(750, 575, "Davon bauen wir 2 Kanonentuerme(1) auf Rot");
			   			StdDraw.text(800, 550, "Eine RumKanone auf Blau");
			   			StdDraw.text(725, 525, "und eine Mühle auf Blau-Gruen");
			   			StdDraw.text(800, 500, "Drücke Start um zu starten");
			   			StdDraw.setPenColor(StdDraw.BLACK);
			   			
			   			GameBeta.drawTowers();
			   			GameBeta.drawLifes();
		   		   		
			   			GameBeta.drawInterface();
			   			
			   			GameBeta.mouseSetCanon();
			   			GameBeta.mouseSetRum();
			   			GameBeta.mouseSetRMill();
			   			
			   			
			   			GameBeta.keyCheck();
			   			watchMouse();
			   			
			   			StdDraw.show(10);
			   	   		//System.out.println("Here 1");
			   	   	}
				 
				//sortEnemy();
				GameBeta.wave();
				GameBeta.enemyDirection();
				GameBeta.enemyMove();
				
				//System.out.println("Here 1");
				GameBeta.checkHP();
				//System.out.println("Here 2");
				GameBeta.stillslowed();
				GameBeta.stillstunned();
	   			
				GameBeta.watchMouse();
				watchMouse();
	   			
	   			StdDraw.clear(StdDraw.MM_SEABLUE);
	   			StdDraw.picture(WIDTH/2+125, HEIGHT/2, "background5_tut.png");
	   			
	   			GameBeta.setWay(GameBeta.path);
	   		
	   			StdDraw.picture(WIDTH-107, 357, "SchadelHinten.png");
	   			
	   			GameBeta.drawShip();
				//System.out.println("Here 3");
	   			
	   			StdDraw.picture(WIDTH-54,375, "SchadelVorne.png");
	   			StdDraw.picture(750, 75, "pause.png");
	   				   						
	   			GameBeta.drawTowers();
	   			GameBeta.drawBombs();
	   			GameBeta.drawLifes();
	   			GameBeta.drawInterface();
	   			GameBeta.shoot();
	   			GameBeta.drawBalls();
	   				   			
	   			GameBeta.mouseSetCanon();
	   			GameBeta.mouseSetRum();
	   			GameBeta.mouseSetRMill();
	   			GameBeta.keyCheck();
	   			
				//System.out.println("Here 4");
	   			//System.out.println("Here 2");
	   			while(GameBeta.pause == true){
	   				
	   				//System.out.println("Key checked");
	   				GameBeta.watchMouse();
	   				watchMouse();
	   				
	   				GameBeta.keyCheck();
	   			}
	   			if(GameBeta.gold >= 250){
	   				step2();
	   			}
	   			
				
			   } else {
			      
				   GameBeta.gameover();
				   
				}

				StdDraw.show(10); // refresh time
				
			}//gameloop
	}
	
	public static void step2(){
		StdDraw.clear(StdDraw.MM_SEABLUE); // bg sea
	      StdDraw.picture(WIDTH/2, HEIGHT/2, "background5.png"); // bg
	      StdDraw.picture(WIDTH/2, HEIGHT-HEIGHT/7, "maximus_logo.png", 16*50, 9*50); // top logo
	      
	      // font settings
	      StdDraw.setPenColor(StdDraw.WHITE);
	      StdDraw.setFont(new Font("Arial", Font.PLAIN, 18));

	      
	      StdDraw.text(400, 525, "Dies war das Tuturial zur Towerdefense");
	      StdDraw.text(400, 500, "Um das normale Spiel jedoch zu bestehen ");
	      StdDraw.text(400, 475, "hier noch ein Tipp:");
	      StdDraw.text(400, 450, "Bau immer erst die Rumkanone ");
	      StdDraw.text(400, 425, "da diese slowed und die andren Tower");
	      StdDraw.text(400, 400, "und die andren Tower mehr Zeit haben ");
	      StdDraw.text(400, 375, "die Schiffe anzugreifen");
	      
	      StdDraw.textLeft(200, 300, "Viel Spass beim spielen wünscht MPPCC");
	     
	      StdDraw.picture(WIDTH/2, HEIGHT/10-50, "back.png");
	      while(true){
	    	  if(StdDraw.mouseX() > 404 && StdDraw.mouseX() < 623 && StdDraw.mouseY() < 29  && StdDraw.mouseY() > 16){
	            
	            if(StdDraw.mousePressed() == true) {
	               
	               //System.out.println("MOUSE PRESSED!!");   
	               MainMenu.drawMainMenu();
	                  
	            }
	         }
	      }
	}
	
	
public static void watchMouse(){
	 if(StdDraw.mousePressed()){
		 if(StdDraw.mouseX()>=650 && StdDraw.mouseX()<=850 && StdDraw.mouseY()>=65 && StdDraw.mouseY()<=85){
			 	if(GameBeta.start==false){
			 		GameBeta.start = true;
			 		
			 		try { Thread.sleep(250); } catch (Exception e) { }
			 	}
			 	else if (GameBeta.pause == true){
			 			GameBeta.pause = false;
			 			System.out.println("MOUSE PRESSED!!2"); 
			 			try { Thread.sleep(250); } catch (Exception e) { }
			 	}
			 	else{
			 		GameBeta.pause = true;
			 		System.out.println("MOUSE PRESSED!!3");
			 		try { Thread.sleep(250); } catch (Exception e) { }
			 	}
		 }
	 }
}
	
	
	      public static void main(String[] args) {
	   
		      
		      // set window size and scaling
		      StdDraw.setCanvasSize(WIDTH, HEIGHT);
		      StdDraw.setXscale(0, WIDTH);
		      StdDraw.setYscale(0, HEIGHT);
 }
	 	
 }
