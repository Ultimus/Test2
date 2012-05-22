package TowerAlpha;

import java.awt.Font;
import java.util.LinkedList;

public class GameBeta {
	
	static final int WIDTH = 1024; // 1280x720 
	static final int HEIGHT = 720; // 1024x720

	public static 			LinkedList<Enemy> enemies;
	public static 			LinkedList<Tower> towers;
	public static 			LinkedList<CanonBall> balls;
	public static 			LinkedList<Bomb> bombs;
	
	static int 				pathsize = 20; // Laenge des Weges
	public static			Path[] path;
	public static  boolean running = true;
	
	public static int 		lifes = 10;
	public static int 		gold = 600;
	public static int 		gameTime = 25;
	
	public static int wavelevel = 1;
	public static int waveHPBonus = 0;
	public static int waveSpawn = 0;
	
	// falls KanonenTurm gebaut wird diese Variable wahr und die Methode PositionTower aktiv
	public static boolean buildCanon; 
	public static boolean buildRum;
	public static boolean buildMill;
	
	public static int canonRadius = 200;
	public static int rumCanonRadius = 180;
	public static int millRadius = 170;

	
	
	public static int canonSizeX = 40;
	
	public static int rumSize= 50;
	
	
	public static int	canonButtonX =	WIDTH-180;
	public static int	canonButtonY = HEIGHT -40;
	public static int	schaedelPos = 375;
	
	public static int rumButtonX = WIDTH -120;
	
	public static int millButtonX = WIDTH - 60;
	
	public static double 	upgradeX = 0;
	public static double	upgradeY = 0;
	public static boolean 	upgrade;
	public static int 		upgradeIndex = 0;
	public static boolean towerCost;
	
	
	//RichtWert fuer neue Schiffe auf welcher Hoehe sie erscheinen sollen
	public static int startY = 510;					
	public static int waveCounter = 0;
	
	// Hinweis oder Warnmeldungen fuer den Spieler
	public static String message = "";
	
	public static String playername = "";
	public static int score = 0;
	
	// sounds on or off?
	public static boolean sounds = true;
	
	
	public static boolean start = false;
	public static boolean pause = false;
	
	
	//Variablen fuer den InGameShop
	
	
	public static boolean shop = false;
	
	
	public static int heartX = /*WIDTH/2 - 20;*/ 580;
	public static int heartY = /*HEIGHT /2 + 60;*/ 420;
	
	public static int damageX =WIDTH/2+100;// 600;
	public static int damageY = HEIGHT/2 - 60;//300;
	
	public static int continueX = WIDTH/2 +200;
	public static int continueY =  HEIGHT/2 - 200;
	
	public static int damageBoost = 0;

	
	// MAIN
	public static void main(String[] args){
		
		enemies = new LinkedList<Enemy>();
		towers = new LinkedList<Tower>();
		balls = new LinkedList<CanonBall>();
		bombs = new LinkedList<Bomb>();
		
		int dice = (int)(Math.random()*4);
		
		if(dice == 0){
			mapOne(); 
		}else{
			if(dice == 1){	
				mapTwo();
				
			}else{
				if(dice == 2){
					mapRandom();
				}else{
					mapThree();
				}
			}
		} // erstellt ein Array des Weges	
	
		
		setWindow();
		

		while(lifes > -10) { 
		   //Game Loop
			
		   if(lifes > 0){
 
		   
			//sortEnemy();
   			wave();
   			enemyDirection();
   			enemyMove();
   			checkHP();
   			stillslowed();
   			stillstunned();
   			HandleDot();
   			watchMouse();
   			
   			
   			StdDraw.clear(StdDraw.MM_SEABLUE);
   			StdDraw.picture(WIDTH/2+125, HEIGHT/2, "background5.png");
   			
   			setWay(path);
   		
   			StdDraw.picture(WIDTH-107, schaedelPos-18, "SchadelHinten.png"); //357
   			
   			drawShip();
   			
   			
   			StdDraw.picture(WIDTH-54,schaedelPos, "SchadelVorne.png");
   			
   			drawTowers();
   			drawBombs();
   			drawLifes();
   			shoot();
   			drawBalls();
			watchUpgrade();
   			
   
   			
   			mouseSetCanon();
   			mouseSetRum();
   			mouseSetRMill();
   			drawInterface();
   			
   			keyCheck();
   			
   			
   			while(shop){
   				
   				StdDraw.clear();
   				

   	   			StdDraw.clear(StdDraw.MM_SEABLUE);
   	   			StdDraw.picture(WIDTH/2+125, HEIGHT/2, "background5.png");
   	   			setWay(path);
   				StdDraw.picture(WIDTH/2, HEIGHT/2, "HeartShop.png");
   				StdDraw.text(heartX+100, heartY, "700 G");
   				StdDraw.text(damageX+100, damageY, "2000 G");
   				
   				drawLifes();
   				shopMouseCheck();
   				StdDraw.show(100);
   				
   			}
   			
			while(pause==true){
					keyCheck();
			}
 
		   } else {
		      
			   gameover();
			   
			}

			StdDraw.show(gameTime); // refresh time
			
		}//Gane Loop ende
		
      //if(1 == HighScore.upload(playername, score)){
         //System.out.println("Error whilst uploading highscore!");
      //}
      //MainMenu.drawHighscore();
		//String[] args2 = {};
		//MainMenu.main(args2);
		System.exit(0);
		
	}
	
	// displays the message centered at top in red letters
	public static void showMessage(){
	   
	  StdDraw.setPenColor(StdDraw.RED);
	  StdDraw.setFont(new Font("Arial", Font.PLAIN, 20));
	  StdDraw.text(WIDTH/2, HEIGHT-HEIGHT/8, message);
	  StdDraw.setPenColor();
	  StdDraw.setFont();
				   
	}
	
	public static void wave(){
		
		Schiff ship1;
		Floss floss1;
		Drache drache1;
	
		ship1 = new Schiff(-100,startY,wavelevel); // zufaellig Schiff oder Floss waehlen
		floss1 = new Floss(-230, startY+30,wavelevel);
		drache1 = new Drache(-350,startY+30,wavelevel);
	
		
		//Es gibt immer 5 Wellen, die sich nach jedem Durchlauf wiederholen, allerdings steigen die HP der Gegner mit jeder Welle +1
		
		if(wavelevel % 5 == 1){
			if(waveCounter >= 300){
				int randomCounter;
				randomCounter = (int)(2*Math.random());
				if(randomCounter == 0)enemies.add(floss1);
				else enemies.add(ship1);
				waveCounter = 0;
				waveSpawn++;
			}
			if(waveSpawn >10){			//sollte eigentlich 10 sein								!!!!!!!!!!!!! �ndern vor Abgabe
				wavelevel++;
				waveSpawn = 0;
				
				//shop = true;			//	Nur Fuer Testzwecke
			}
			
		}// Wave Level 1
		
		if(wavelevel % 5 == 2){
			if(waveCounter >= 300){
				int randomCounter;
				randomCounter = (int)(3*Math.random());
				if(randomCounter == 1){
					enemies.add(floss1);
				}else{
					if(randomCounter == 0)enemies.add(drache1);
					else enemies.add(ship1);
				}
				waveCounter = 0;
				waveSpawn++;
			}
			if(waveSpawn >10){
				wavelevel++;
				waveSpawn = 0;
			}
			
		}// Wave Level 2
		
		
		
		if( wavelevel % 5 == 3){
			if(waveCounter >= 300){						//Gibt alle 300 Perioden zufaellig einen oder zwei Gegner aus
				int randomCounter;
				randomCounter = (int)(3*Math.random());
			

				if(randomCounter == 0){
					enemies.add(ship1);
					enemies.add(floss1);	
				
					waveSpawn = waveSpawn+2;
			
				}else{
			
					if(randomCounter ==1)enemies.add(drache1);
					else enemies.add(floss1);
					waveSpawn = waveSpawn+1;
				}
				waveCounter = 0;
			}
			
			if(waveSpawn >10){
				wavelevel++;
				waveSpawn = 0;
			}
		}//WaveLevel3
		
		
		
		if(wavelevel % 5 == 4){
			if(waveCounter >= 300){
				int randomCounter;
				randomCounter = (int)(3*Math.random());
				if(randomCounter == 1){
					enemies.add(floss1);
					enemies.add(drache1);
				}
				else{
					enemies.add(ship1);
					enemies.add(drache1);
				}
				waveCounter = 0;
				waveSpawn+=2;
			}
			if(waveSpawn >10){
				wavelevel++;
				waveSpawn = 0;
			}
			
		}// Wave Level 4
		
		
		if(wavelevel % 5 == 0){
			if(waveCounter >= 300){
				int randomCounter;
				randomCounter = (int)(2*Math.random());
				if(randomCounter == 1){
					if(waveSpawn < 11){				// < 11 Damit nicht unendlich viele Gegner spawnen und ide Karte wechseln kann
						enemies.add(floss1);
						enemies.add(drache1);
						enemies.add(ship1);
						waveSpawn = waveSpawn+3;
					}
				}
				else{
					if(waveSpawn < 11){
						enemies.add(floss1);
						enemies.add(drache1);
						waveSpawn = waveSpawn+2;
					}
				}
				waveCounter = 0;
				
			}
			if(waveSpawn >10){
				
				if(enemies.isEmpty()){
					System.out.println ("enemies ist empty");
					int dice = (int)(Math.random()*4);
					
					if(dice == 0){
						mapOne(); 
					}else{
						if(dice == 1){	
							mapTwo();
							
						}else{
							if(dice == 2){
								mapRandom();
							}else{
								mapThree();
							}
						}
					} // erstellt ein Array des Weges	
				
					wavelevel++;
					waveSpawn = 0;
					shop = true;
					
				}
				
			}
			
		}
		
		
		
		waveCounter++;
		
	}
	
	public static void enemyDirection(){			//uebergebe eine GegnerListe die die Richtung der enthaltenden Gegner ermittelt
		
		Enemy compareE; 
		
		for(int k = 0; k< enemies.size(); k++){ //als erstes Werden die Gegner durchgezaehlt
			for(int i = path.length-1; i>=0; i--){//und dannach ueberprueft wie sie zu laufen haben. Rueckwaerts um zu fruehe Kurven zu vermeiden
			
				compareE = (Enemy)enemies.get(k);
				
				if(Math.abs(compareE.getX()-path[i].getX())<=path[i].getSize() &&
						Math.abs(compareE.getY()-path[i].getY())<= path[i].getSize()){
					
					compareE.setDirection(path[i].getDirection());
					enemies.add(k, compareE);
					enemies.remove(k+1);
				
				}//if
			}//for
		}//for enemy
	}//enemy Direction
	
	
	
	
	
									
	public static void enemyMove(){								//Methode die die Koordinaten der Gegner in der Enemy Liste bestimmt
		
		Enemy compareE; 
		
		for(int k = 0; k < enemies.size(); k ++){
			
			compareE = (Enemy)enemies.get(k);
			double xPos =	compareE.getX();
			double yPos = compareE.getY();
			
			
			if(compareE.getDirection() == 0){
				compareE.setPos(xPos,yPos+compareE.getSpeed()*1.5);
			}//nach Oben
			
			if(compareE.getDirection() == 1){
				compareE.setPos(xPos+compareE.getSpeed()*1.5,yPos);
			}//nach rechts
			
			if(compareE.getDirection() == 2){
				compareE.setPos(xPos,yPos-compareE.getSpeed()*1.5);

			}//nach unten
		
			if(compareE.getDirection() == 3){
				compareE.setPos(xPos-compareE.getSpeed()*1.5,yPos);
			}//nach links
			enemies.add(k, compareE);
			enemies.remove(k+1);
			
		}
		
	}
	
	
	
	   public static void setWindow() {
		      
         if(MainMenu.game_launched == false) {
		      StdDraw.setCanvasSize(WIDTH, HEIGHT);
		      StdDraw.setXscale(0, WIDTH);
		      StdDraw.setYscale(0, HEIGHT);
         }
         
	      StdDraw.setPenColor(StdDraw.BLACK);
         StdDraw.setFont(new Font("Arial", Font.PLAIN, 20));

	   }
	  
	   
	 public static void setWay(Path[] pathParArray) {			//�bergebe einen Weg Array der gezeichnet wird
		      
		   // Way: 4 weil alles < 4 noch im Meer ist und das Bild weg.png Sand mit drin hat, sieht einfach bloed aus :D
		   for(int i = 0; i < pathParArray.length; i++){
			 if(pathParArray[i].getImage()==1)  StdDraw.picture(pathParArray[i].getX(), pathParArray[i].y, "WegH.png");
			 if(pathParArray[i].getImage()==2) StdDraw.picture(pathParArray[i].getX(), pathParArray[i].y, "WegV.png");
			 if(pathParArray[i].getImage()==3) StdDraw.picture(pathParArray[i].getX(), pathParArray[i].y, "WegKurveLO.png");
			 if(pathParArray[i].getImage()==4) StdDraw.picture(pathParArray[i].getX(), pathParArray[i].y, "WegKurveOR.png");
			 if(pathParArray[i].getImage()==5) StdDraw.picture(pathParArray[i].getX(), pathParArray[i].y, "WegKurveUR.png");
			 if(pathParArray[i].getImage()==6) StdDraw.picture(pathParArray[i].getX(), pathParArray[i].y, "WegKurveLU.png");
		   }
	}
	 
	 
	 public static void drawLifes(){		//Lebensz�hler und Gold zeichnen
		 
		 String tempLifes = Integer.toString(lifes);
		 StdDraw.picture(100, 90, "Rolle4.png");
		 Font temp = new Font("SansSerif", Font.BOLD, 25);
		 StdDraw.setFont(temp);
		 StdDraw.picture(60, 110, "Herz.png");
		 StdDraw.text(115, 108, tempLifes);
		 StdDraw.picture(60, 70, "Muenze.png");
		 String tempGold = Integer.toString(gold);
		 StdDraw.text(115, 68, tempGold);
		 StdDraw.setFont();
		  
	 }
	 
	 
	 public static void drawShip(){			//�bergebe eine Liste an Gegnern die an der aktuellen Position gemalt werden
		 
		 Enemy compareE;					//Tempor�rer Gegner zum Vergleich der Koordinaten
		 String hpString;
		 for(int i = 0; i < enemies.size(); i++){
			 
			 compareE = (Enemy)enemies.get(i); 
			 
			 // Floss oder Schiff
			 if(compareE.getType() == 1){
				StdDraw.picture(compareE.x + 5, compareE.y+15, "testschiff1schatten.png");
			    StdDraw.picture(compareE.x, compareE.y+20, "schiff2.png");
			 }
			 if(compareE.getType()== 2){
				StdDraw.picture(compareE.x + 25, compareE.y, "FlossSchatten.png");
			    StdDraw.picture(compareE.x, compareE.y, "Floss2.png");
			 }
			 
			 if(compareE.getType()== 3){
				 StdDraw.picture(compareE.x + 15, compareE.y+15, "DracheSchatten.png");
				 StdDraw.picture(compareE.x-10, compareE.y+15, "Drache.png"); 
			 }
			 hpString = ""+compareE.getHP();
			 StdDraw.text(compareE.getX(), compareE.getY(),  hpString);
			 
			 
		 }
	 }
	 
	 
	 public static void drawBombs(){
		 
		 Bomb bomb;
		 
		 for(int i = 0; i < bombs.size(); i++){
			 
			 bomb = (Bomb)bombs.get(i);
			 
			 for(int k = 0; k < 5; k++){
				 
				 if(bomb.getMove()< 400){
				 
					StdDraw.picture(bomb.getB1X(k), bomb.getB1Y(k), "Bomb1.png");
				 	StdDraw.picture(bomb.getB2X(k), bomb.getB2Y(k), "Bomb2.png");
				 	StdDraw.picture(bomb.getB3X(k), bomb.getB3Y(k), "Bomb3.png");
				 }else{
					 StdDraw.picture(bomb.getB1X(k), bomb.getB1Y(k), "Bomb1.png", 40*bomb.getSmaller(), 34*bomb.getSmaller());
					 StdDraw.picture(bomb.getB2X(k), bomb.getB2Y(k), "Bomb2.png", 35*bomb.getSmaller(), 33*bomb.getSmaller());
					 StdDraw.picture(bomb.getB3X(k), bomb.getB3Y(k), "Bomb3.png", 17*bomb.getSmaller(), 14*bomb.getSmaller());
					 
					 bomb.setSmaller();
				 }
				 
				 bomb.b1move();
				 bomb.b2move();
				 bomb.b3move();
				 
				 }
			 

			 if(bomb.getSmaller()<0.1){
				 bombs.remove(i);
			 
			 }
			 
		 }
		 
	 }
	 
    
   // zeichnet Kanonenkugeln
   public static void drawBalls() {
                  
      Tower tower;
      Enemy ship;
      CanonBall ball;
      boolean hit = true;  // edited by Max: 30.6.11
      double evade = Math.random();// edited by Max: 30.6.11
      
      
      
      // alle Kanonenkugeln durchlaufen
      for(int i = 0; i < balls.size(); i++) {

         ball = balls.get(i);
         
         try {   
            
            ship = enemies.get(ball.getEnemy());
            tower = towers.get(ball.getTower());
            
            if (ship.getType() == 3){//Abfrage ob Schiff ausweicht
          	  if (evade <= 0.1){		
          		  hit = false;		
          	  }						
            }						
   
            // loescht Kanonenkugeln die nicht mehr sichtbar sind und falsch fliegen
            if(ship.getX() == ball.getX() && ship.getY() == ball.getY() || ball.getX() > WIDTH || ball.getX() < 0 || ball.getY() > HEIGHT || ball.getY() < 0)
               balls.remove(i);
            
            //System.out.println(ball.getFactor());
            
            // Range
            double dx = Math.abs(ship.getX()-tower.getX());
            double dy = Math.abs(ship.getY()-tower.getY());

            
            // nur Kugeln berechnen, die innerhalb der Reichweite sind
            if(Math.sqrt(dx*dx + dy*dy) <= tower.getRange()) {
               
               // setzt ball koords neu
               ball.setX((int) (tower.getX()-(tower.getX()-ship.getX()) * ball.getFactor()));
               ball.setY((int) (tower.getY()-(tower.getY()-ship.getY()) * ball.getFactor()));
               
               
               
               ball.setFactor(ball.getFactor() + 0.04); // set ball coords, 0.04 = speed
               
               if(ball.getFactor() > 1) {
                  
                  // zieht HP vom Schiff bei Treffer ab
                  int hp = ship.getHP();
                  
                 if (hit == true){ //trefferabfrage
                  ship.setHP(hp-(tower.getDamage()+damageBoost));
                  
                  // play hit sound
                  //Sound.play("sounds/explosion.wav");
                  if(sounds == true) new Soundexplosion().play();
                  
                 }
                 
                 if (hit == true && tower.effect == 1){//slowed, falls RUmkanone trifft
                	 if (ship.effected == 0){
                	 ship.effected = 1;
                 	 ship.timer = System.currentTimeMillis();
                 	 	if (tower.getTyp() == 2) ship.speed *=0.25;
                 	 	if (tower.getTyp() == 5) ship.speed *=0.30;
                 	 	if (tower.getTyp() == 8) ship.speed *=0.5;
                	 }else{ ship.timer = System.currentTimeMillis(); //verlängert slowtimer falls geslowter Gegner getroffen wird
                	 }
                 }
                 
                 if (hit == true && (tower.effect == 2 || tower.effect == 4 || tower.effect == 5)){ //stunned, falls Tower Effekt 2 hat
                	 if (ship.effected == 0|| ship.effected == 1){
                		 ship.speed *= 0;
                		 if (tower.effect == 2) ship.effected = 2;
                		 if (tower.effect == 4) ship.effected = 4;
                		 if (tower.effect == 5) ship.effected = 5;
                		 
                	 ship.timer = System.currentTimeMillis();
                	 }else{ ship.timer = System.currentTimeMillis();
                	 }
                 }
                 
                 
                 if (hit == true && tower.effect == 3){//setzt dot auf true oder aktualisiert wenn dot schon wirkt
                	 if (ship.dot == false){
                		 ship.setDot(true);
                		 ship.setDotLevel(1);
                	 }
                	 else if (ship.getDotLevel() <3 )ship.setDotLevel(ship.getDotLevel()+1);
                	 
                 }
                 if (hit == true && tower.effect == 6){
                	 if (ship.dot == false){
                		ship.setDot(true);
                		ship.setDotLevel(2);
                	 }
                	 else if (ship.getDotLevel() <= 4) ship.setDotLevel (ship.getDotLevel()+2);
                 }
                 
                 if (hit == true && tower.effect == 7){
                	 if (ship.dot == false){
                		 ship.setDot(true);
                		 ship.setDotLevel(3);
                	 }
                	 else if (ship.getDotLevel() <=6 ) ship.setDotLevel (ship.getDotLevel()+3);
               
                 }
                 
                  enemies.remove(ball.getEnemy());
                  enemies.add(ball.getEnemy(), ship);
                  
                  balls.remove(i); //ball.setFactor(0.0); Bug Fix: loescht Balls sobald getroffen
                  
               } else {
                  
                  
                  if(tower.getTyp() == 1 || tower.getTyp() == 4 || tower.getTyp() == 7) {
                     StdDraw.picture(ball.getX(), ball.getY(), "ball.png"); // zeichnet Kugel
                  }
                  if(tower.getTyp()==2 || tower.getTyp() == 5 || tower.getTyp() == 8){
                     StdDraw.picture(ball.getX(), ball.getY(), "Fass.png"); // zeichnet Fass
                  }
                  if(tower.getTyp() == 3 || tower.getTyp () == 6 || tower.getTyp() == 9){
                	  StdDraw.picture(ball.getX(), ball.getY(), "Pilz.png");	// zeichnet Pilz
                  }
                  
                     
                  //StdDraw.picture(ball.getX() + 5, ball.getY() + 5, "ballschatten2.png");// zeichnet Kugelschatten NOT

               }
               
            }
            
         } catch (Exception e) {
            //System.out.println("Debug 1");
         }
            
   
      }
      
   }
	 
   public static void checkHP(){								//entfernt Gegner aus der Liste falls sie abgeschossen wurden
		 Enemy compareE;
		 
		 for(int i = 0; i<enemies.size(); i++){
			 compareE = (Enemy)enemies.get(i);
			 
			 if(compareE.getHP()<=0){
				
				 Bomb bomb = new Bomb(compareE.getX(), compareE.getY());
				 bombs.add(bomb);
				 
				 enemies.remove(i);								//Hier kann man noch weitere Aktionen hineinschreiben was passieren soll wenn ein Schiff zerstoert wird
				 gold = gold + compareE.getBounty();
				 score++; // highscore liste
					 
			 }
			 if(compareE.getX()>(WIDTH+50)){					//Abfrage, ob Gegner am Ende angekommen sind
				 
				 enemies.remove(i);								//Gegner aus Liste entfernen;
				 lifes--;										//Leben - 1
				 
			
			 }
		 }
	 }
	 

	 
	 /*
	  * 	Tower Typen:
	  * 	1 = Kanone
	  * 	2 = RumKanone
	  * 
	  */
	 
	 public static boolean checkBuildable(int xPar, int yPar, int towerTypePar){		//checkt ob man an der uebergebenen Position bauen kann
		 
		 for(int i = 0; i < path.length; i++){
			 if(Math.abs(path[i].getX()-xPar) <path[i].getSize() && Math.abs(path[i].getY()-yPar) <path[i].getSize()){
			    message = "Verbotene Turm-Position! Der Turm kann nicht auf dem Weg der Feinde gebaut werden!";
				 return false;
			 }
		 }
		 
		 Tower compareT;
		 for(int i = 0; i< towers.size(); i++){
			 compareT = (Tower)towers.get(i);
		
			 if(towerTypePar == 1){		//Normale Kanone
				 if(Math.abs(compareT.getX()-xPar)<compareT.getSize() && Math.abs(compareT.getY()-yPar)<compareT.getSize()){
				    message = "Verbotene Turm-Position! Der Turm ist zu nah an einem anderen Turm!";
					 return false;
				 }
			 }
			 
			 if(towerTypePar == 2){		//RumKanone
				 if(Math.abs(compareT.getX()-xPar)<compareT.getSize()+20 && Math.abs(compareT.getY()-yPar)<compareT.getSize()){
				    message = "Verbotene Turm-Position! Der Turm ist zu nah an einem anderen Turm!";
					 return false;
				 }
			 }
			 
		 }	 
		
		 if(StdDraw.mouseX()>=(WIDTH-300) && StdDraw.mouseY()>= HEIGHT-100){
			 return false;
		 }
		 message = "";
		 return true;
	 }
	 
	 
	 public static void buildKanone(int xPar, int yPar){		//Baue an X,Y einen KanonenTurm
		 
		 Tower canon = new Kanone(xPar, yPar);
		 
		 if (gold - canon.getCost() >= 0){						//Abfrage, ob noch genug Gold vorhanden ist, um Tower zu setzen.
		    message = "";
		    boolean isSet = false;									//wenn in der For Schleife kein Turm gesetzt wird, wird er falls diese Variable false ist gesrtzt
			 
				 if(checkBuildable(xPar, yPar, 1)==true){
					 
					 Tower compareT;
					 for(int i = 0; i<towers.size(); i++){
							compareT = towers.get(i);
								if(compareT.getY() < yPar && isSet == false) {
									towers.add(i, canon);		//add Tower der im Vordergrund steht vor Hinteren Towers
									isSet = true;
								}
					}//for
					 if(isSet==false)towers.add(canon);
					 gold = gold - canon.getCost();
				 }	 
		 } else {
		    message = "Zu wenig Gold zum Bauen des Turms!";
		 }
	 }
	 
	 public static void buildRum(int xPar, int yPar){
		 Tower rum = new Rumkanone(xPar,yPar);
		 
		 if (gold >= rum.getCost()){						//Abfrage, ob noch genug Gold vorhanden ist, um Tower zu setzen.

		    message = "";
		    boolean isSet = false;									//wenn in der For Schleife kein Turm gesetzt wird, wird er falls diese Variable false ist gesrtzt
			 
				 if(checkBuildable(xPar, yPar, 2)==true){			//Typ 2 da RumKanone
					 
					 Tower compareT;
					 for(int i = 0; i<towers.size(); i++){
							compareT = towers.get(i);
								if(compareT.getY() < yPar && isSet == false) {
									towers.add(i, rum);		//add Tower der im Vordergrund steht vor Hinteren Towers
									isSet = true;
								}
					}//for
					 if(isSet==false)towers.add(rum);
					 gold = gold - rum.getCost();
				 }	 
		 } else {
		    message = "Zu wenig Gold zum Bauen des Turms!";
		 }
		 		 
	 }
	 
	 
	 public static void buildMill(int xPar, int yPar){		//Baue an X,Y einen KanonenTurm
		 
		 Tower canon = new Windmill(xPar, yPar);
		 
		 if (gold - canon.getCost() >= 0){						//Abfrage, ob noch genug Gold vorhanden ist, um Tower zu setzen.
		    message = "";
		    boolean isSet = false;									//wenn in der For Schleife kein Turm gesetzt wird, wird er falls diese Variable false ist gesrtzt
			 
				 if(checkBuildable(xPar, yPar, 1)==true){
					 
					 Tower compareT;
					 for(int i = 0; i<towers.size(); i++){
							compareT = towers.get(i);
								if(compareT.getY() < yPar && isSet == false) {
									towers.add(i, canon);		//add Tower der im Vordergrund steht vor Hinteren Towers
									isSet = true;
								}
					}//for
					 if(isSet==false)towers.add(canon);
					 gold = gold - canon.getCost();
				 }	 
		 } else {
		    message = "Zu wenig Gold zum Bauen des Turms!";
		 }
	 }
	 
	 
	 
	 public static void drawTowers(){							//Zeichnet die T�rme die in der Towers Liste enthalten sind
		 Tower compareT;
		 if(!towers.isEmpty()){
			 		 
			 for(int i = 0; i < towers.size(); i++){
				 compareT = towers.get(i);
				 if(compareT.getTyp()==1){
					 StdDraw.picture(compareT.getX() + 15, compareT.getY()+30, "TurmSchatten2.png");
					 StdDraw.picture(compareT.getX(), compareT.getY()+30, "Turm1Stufe1.png");
				 }
				 
				 if(compareT.getTyp()==4){
					 
					 StdDraw.picture(compareT.getX() + 15, compareT.getY()+30, "TurmSchatten2.png");
					 StdDraw.picture(compareT.getX(), compareT.getY()+30, "Turm1Stufe2.png");
				 }
				 if (compareT.getTyp() == 7){
					 StdDraw.picture(compareT.getX() + 15, compareT.getY()+30, "TurmSchatten2.png");
					 StdDraw.picture(compareT.getX(), compareT.getY()+30, "turm1.png");
					 
				 }
				 if(compareT.getTyp()==2 || compareT.getTyp() == 5 || compareT.getTyp() == 8 ){
					 
						StdDraw.picture(compareT.getX()+15,compareT.getY()+5, "RumKanoneSchatten.png");
						
						if(compareT.getTyp() == 2)
						StdDraw.picture(compareT.getX(),compareT.getY()+5, "RumKanoneStufe1.png");
						else StdDraw.picture(compareT.getX(),compareT.getY()+5, "RumKanone.png");
						
						if(compareT.getApeThrow()){
							
							StdDraw.picture(compareT.getX()+60, compareT.getY()+40, "RapeSchatten2.png");		//AFFE schmeisset Fass
							StdDraw.picture(compareT.getX()+20, compareT.getY()+35, "RapeApe2.png");		//AFFE schmeisset Fass
						}
						else{
							
							StdDraw.picture(compareT.getX()+57, compareT.getY()+38, "RapeSchatten1.png");
							StdDraw.picture(compareT.getX()+20, compareT.getY()+35, "RapeApe1.png");
						}
						if(compareT.getTyp()== 8) StdDraw.picture(compareT.getX()+20, compareT.getY()+56, "Hut.png");
				}
				 
				
				 
				
				 if(compareT.getTyp()==3 || compareT.getTyp()==6 || compareT.getTyp()==9){

						StdDraw.picture(compareT.getX()+15,compareT.getY()+20, "Windmuehle2Schatten.png");
						StdDraw.picture(compareT.getX()+25,compareT.getY()+30, "Windmuehle1Schatten.png", compareT.getMillTurn());
						StdDraw.picture(compareT.getX(),compareT.getY()+20, "Windmuehle2.png");						
						if(compareT.getTyp()==9)	StdDraw.picture(compareT.getX()-5,compareT.getY()+30, "Windmuehle1.png", compareT.getMillTurn());
						if(compareT.getTyp()==3)	StdDraw.picture(compareT.getX()-5,compareT.getY()+30, "WindmuehleStufe1.png", compareT.getMillTurn());
						if(compareT.getTyp()==6)	StdDraw.picture(compareT.getX()-5,compareT.getY()+30, "WindmuehleStufe2.png", compareT.getMillTurn());
						
							if(compareT.millTurn >360) compareT.setTurn(1);
						
						int turn = compareT.getMillTurn()+1;
						compareT.setTurn(turn);
				 }
				 
			}//for
			 
		}
				 

			 
	}
	 
	 public static void shoot(){
		 
		 Enemy compareE;
		 Tower compareT;
		 double dx = 0;
		 double dy = 0;
		 //int hp = 0;
		 int waitedPar = 0;
		 
		 Enemy slowEnemy = new Schiff(1,1);
		 boolean isEnemy2 = false;
		 boolean isInRange = false;
		 int reminderEnemy = 0;
		 boolean alreadySlowed = false; 			//Falls alle Slow sind, wird in eine Schleife gesprungen um den ersten in Reichweite erneut zu verlangsamen
		 
		 for(int i = 0; i < towers.size(); i++){
		    
			 compareT = towers.get(i);
			 
			 if( (compareT.getTyp()==2 || compareT.getTyp() == 5 || compareT.getTyp() == 8)  && compareT.getWaited()>= (int)(compareT.coolDown/2)) 
				 compareT.setApeThrow(false); 
			 
			 if(compareT.getWaited() >= compareT.getCoolDown()){	
				 
				 
				 
				 for(int k = 0; k< enemies.size(); k++){
				    
					 compareE = enemies.get(k);
					 
					 // range check
					 dx = Math.abs(compareE.getX()-compareT.getX());
					 dy = Math.abs(compareE.getY()-compareT.getY());
					 if(Math.sqrt(dx*dx+dy*dy)<=compareT.getRange()){
						 
						 isInRange = true;
						 
						// play sound
				    	//Sound.play("sounds/canonball_shot.wav");
						 if(sounds == true) new Soundcanon().play();
						
						 if(compareT.getTyp()== 1|| compareT.getTyp() == 4 || compareT.getTyp() == 7){
						    // KanonenKugel wird der Liste Balls hinzugef�gt
							 balls.add(new CanonBall(i, k, 0.1, compareT.getX(), compareT.getY(), compareE.getX(), compareE.getY()));
							
							// wait timer resetten
							 compareT.setWaited(0);
							 break;
						 }
						 
						 
						 if(compareT.getTyp()==2 || compareT.getTyp() == 5 || compareT.getTyp() == 8){
						
							 compareT.setApeThrow(true);
							 
							 slowEnemy = compareE;
							 isEnemy2 = true;
							
							 reminderEnemy = k;
							 if(compareE.getEffected() !=1){
								 
								 // add ball to queue
								 balls.add(new CanonBall(i, k, 0.1, compareT.getX(), compareT.getY(), compareE.getX(), compareE.getY()));
 
								 
								// wait timer resetten
								 compareT.setWaited(0);
								 alreadySlowed = true;
								 break;
								 
							 	}
							 
						 	}

						 if(compareT.getTyp()==3 || compareT.getTyp() == 6 || compareT.getTyp() == 9){
								
							 
							 slowEnemy = compareE;
							 isEnemy2 = true;
							
							 reminderEnemy = k;
							 if(compareE.getDot()==false){
								 
								 // add ball to queue
								 balls.add(new CanonBall(i, k, 0.1, compareT.getX(), compareT.getY(), compareE.getX(), compareE.getY()));
 
								 
								// wait timer resetten
								 compareT.setWaited(0);
								 alreadySlowed = true;
								 break;
								 
							 	}
							 
						 	}
						 
					}
			
					 
				 }
				 
				//Fall abfangen falls alle Gegner in Reichweite Slow sind, der Turm aber dann trotzdem den Slow effeckt am erstbesten vergr��ert
				if(alreadySlowed == false && isInRange && isEnemy2){
					 balls.add(new CanonBall(i, reminderEnemy, 0.1, compareT.getX(), compareT.getY(), slowEnemy.getX(), slowEnemy.getY()));
					// wait timer resetten
					 compareT.setWaited(0);
					 alreadySlowed = true;
					 break;
							
				}
			 }
			 
			 waitedPar = compareT.getWaited();
			 compareT.setWaited(waitedPar+1);
			 towers.remove(i);
			 towers.add(i, compareT);
		}	 
	 }
	 
	 
	 
	 
	 public static void mapOne(){
		 
//////////////////Draw Route	/////////////////////////////////////////////////
			/*
			 * Image 1 Horizontaler Weg
			 * Image 2 Vertikaler Weg
			 * Image 3 Kurve Oeffnung von links nach oben
			 * Image 4 Kurve Oeffnung von oben nach rechts
			 * Image 5 Kurve Oeffnung von rechts nach unten
			 * Image 6 Kurve Oeffnung von links nach unten
			 * 
			 */
		 
		 startY = 510;	
		 schaedelPos = 375;
		 
		 pathsize = 20;
		 path = new Path[pathsize];
		 
			for(int i = 0; i< 5; i++){
				
			   // StartY +5 damit die Schiffe relativ mittig gezeichnet werden 
				path[i] = new Path(100*i+150, startY+5, 1,1);	
			
			} 
			
				path[4] = new Path(498,startY+5,2,6);		//Kreuzungen sollten sich ueberlappen da sonst Schiffe und Flosse zu frueh abbiegen und ueber Land fahren
			
			for(int i = 5; i< 8; i++){
				
				   // StartY +5 damit die Schiffe relativ mittig gezeichnet werden 
					path[i] = new Path(500, startY+5-(i-4)*100, 2,2);	
				
				} 
			
			path[8] = new Path(500,startY+5-(3*100+60),1,4);
			path[9] = new Path(500+100,startY+5-(3*100+60),1,1);
			path[10] = new Path(500+200,startY+5-(3*100+60),1,1);
			path[11] = new Path(500+250,startY+5-(3*100+60),0,3);
			path[12] = new Path(500+250,startY+5-(3*100+60)+100,0,2);
			path[13] = new Path(500+250,startY+5-(3*100+60)+150,1,5);
			
			
			for(int i = 14; i< 20; i++){
				
				   // StartY +5 damit die Schiffe relativ mittig gezeichnet werden 
					path[i] = new Path(500+250+(100*(i-13)),startY+5-(4*100)+190,1,1);	
				
				} 
			 
	 }
	 
	 
	 public static void mapTwo(){
		 
		 startY = 200;
		 schaedelPos = 375;

		 pathsize = 34;
		 path = new Path[pathsize];
		 
		 
			for(int i = 0; i< 3; i++){
				
			   // StartY +5 damit die Schiffe relativ mittig gezeichnet werden 
				path[i] = new Path(100*i+163, startY+5, 1,1);	
			
			} 
			
			path[3] = new Path(413,startY+5,0,3);
			
			 
			for(int i = 4; i< 6; i++){
				
			   // StartY +5 damit die Schiffe relativ mittig gezeichnet werden 
				path[i] = new Path(413, startY+5+100+100*(i-4), 0,2);	
			
			} 
			
			path[6] = new Path(410,startY+5+270,3,6);
			path[7] = new Path(313, startY+5+270, 3, 1);
			path[8] = new Path(253, startY+5+273, 0, 4);
			
			path[9] = new Path(253, startY+5+373, 0, 2);
			path[10] = new Path(253, startY+5+413, 0, 2);
			path[10] = new Path(253, startY+5+443, 1, 5);
			path[11] = new Path(353, startY+5+443, 1, 1);
			path[12] = new Path(453, startY+5+443, 1, 1);
			path[13] = new Path(553, startY+5+443, 1, 1);
			path[14] = new Path(653, startY+5+443, 1, 1);
			path[15] = new Path(700, startY+5+443, 2, 6);
			path[16] = new Path(700, startY+5+343, 2, 2);
			path[17] = new Path(700, startY+5+290, 2, 2);
			path[19] = new Path(697, startY+5+243, 3, 3);
			path[18] = new Path(630, startY+5+241, 3, 1);
			path[20] = new Path(570, startY+5+243, 2, 5);
			
			for(int i = 21; i< 24 ; i++){
				
				   // StartY +5 damit die Schiffe relativ mittig gezeichnet werden 
				path[i] = new Path(570, startY+5+143-100*(i-21), 2, 2);
				
				} 
		 
			path[24] = new Path(567, startY+5-113, 1, 4);
		 
			path[25] = new Path(667, startY+5-115, 1, 1);
			path[26] = new Path(767, startY+5-115, 1, 1);
			path[27] = new Path(810, startY+5-113, 0, 3);
			path[28] = new Path(810, startY+5-13, 0, 2);
			path[29] = new Path(810, startY+5+60, 0, 2);
			path[30] = new Path(810, startY+5+102, 1, 5);
			path[31] = new Path(910, startY+5+102, 1, 1);
			path[32] = new Path(1010, startY+5+102, 1, 1);
			path[33] = new Path(1110, startY+5+102, 1, 1);
	 
	 }// Map 2
	 
	 
public static void mapThree(){
		 
		 startY = 200;
		 schaedelPos = 590;
		
		 pathsize = 34;
		 
		 path = new Path[pathsize];
		 
		 for(int i = 0; i < 8; i++){
			 path[i] = new Path(160+i*100, startY+5, 1, 1);
		 }
		 
		 path[8] = new Path(830, startY+5, 1, 1);
		 path[9] = new Path(920, startY+7, 0, 3);
		 path[10] = new Path(920, startY+7+100, 0, 2);
		 path[11] = new Path(920, startY+7+140, 0, 2);
		 path[12] = new Path(920, startY+7+190, 3, 6);
		 
		 for(int i = 0; i < 6; i++){
			 path[i+13] = new Path(820-i*100, startY+7+190, 3, 1);
		 }
		 
		 path[19] = new Path(250, startY+7+190, 0, 4);
		 path[20] = new Path(250, startY+7+280, 0, 2);
		 path[21] = new Path(250, startY+7+340, 0, 2);
		 path[22] = new Path(250, startY+7+390, 1, 5);
		 
		 for(int i = 0; i < 4; i++){
			 path[i+23] = new Path(350+i*100, startY+7+390, 1, 1);
		 }
		 
		 path[27] = new Path(700, startY+7+390, 1, 1);
		 path[29] = new Path(750, startY+7+390, 2, 6);
		 path[28] = new Path(750, startY+7+370, 2, 2);
		 path[30] = new Path(750, startY+7+315, 1, 4);
		 
		 path[31] = new Path(850, startY+7+315, 1, 1);
		 path[32] = new Path(950, startY+7+315, 1, 1);
		 path[33] = new Path(1050, startY+7+315, 1, 1);
		 
	 }// Map 3
	 
	 
	 
	 
	 
	 public static void mapRandom(){
		 
		 //Diese Karte wird zufaellig aus je 2 linken und 2 rechten Teilen generiert

		 pathsize = 27;
		 path = new Path[pathsize];
		 
		 int dice = (int)(Math.random()*2);
		 
		 if(dice == 1){
			 
			 startY = 200;
			 
			 for(int i = 0; i< 2; i++){
					
				   // StartY +5 damit die Schiffe relativ mittig gezeichnet werden 
					path[i] = new Path(45*i+163, startY+5, 1,1);	
				
				} 
			 path[2] = new Path(253, startY+5+2, 0, 3);
			 path[3] = new Path(255,startY+5+102,0,2);
			 path[4] = new Path(255, startY+5+202,0, 2);
			 path[5] = new Path(255, startY+5+250,1, 5);
			 path[6] = new Path(355, startY+5+250, 1, 1);
			 path[7] = new Path(355, startY+5+250, 1, 1);
			 path[8] = new Path(400, startY+5+250, 2, 6);
			 path[9] = new Path(402, startY+5+150, 2, 2);
			 path[11] = new Path(400, startY+5+100, 2,4);
			 path[10] = new Path(450, 600+5-302, 1, 1);
			 
		 }else{
			 
			 startY = 600;
			 
			 for(int i = 0; i< 3; i++){
					
				   // StartY +5 damit die Schiffe relativ mittig gezeichnet werden 
					path[i] = new Path(100*i+163, startY+5, 1,1);	
				
				} 
			 path[3] = new Path(413,startY+5,2,6);
			 path[4] = new Path(415, startY+5-100,2, 2);
			 path[5] = new Path(413, startY+5-150,3, 3);
			 path[6] = new Path(313, startY+5-152, 3, 1);
			 path[7] = new Path(250, startY+5-150, 2, 5);
			 path[8] = new Path(250, startY+5-250, 2, 2);
			 path[9] = new Path(250, startY+5-300, 1, 4);
			 path[10] = new Path(350, startY+5-302, 1,1);
			 path[11] = new Path(450, startY+5-302, 1, 1);
			 
		 }
		 
		 dice = (int)(Math.random()*2);
		 
		 if(dice == 0){
			 
			 schaedelPos = 500;
			 
			 path[12] = new Path(550, 600+5-302, 1, 1);
			 path[13] = new Path(600, 600+5-302, 2, 6);
			 path[14] = new Path(602, 600+5-402, 2, 2);
			 path[15] = new Path(602, 600+5-502, 2, 2);
			 path[16] = new Path(600, 600+5-552, 1, 4);
			 path[17] = new Path(700, 600+5-554, 1, 1);
			 path[18] = new Path(800, 600+5-554, 1, 1);
			 path[19] = new Path(850, 600+5-554, 0, 3);
			 
			 path[20] = new Path(850, 600+5-454, 0, 2);
			 path[21] = new Path(850, 600+5-354, 0, 2);
			 path[22] = new Path(850, 600+5-254, 0, 2);
			 path[23] = new Path(850, 600+5-204, 0, 2);
			 path[24] = new Path(850, 600+5-170, 1, 5);
			 path[25] = new Path(950, 600+5-170, 1, 1);
			 path[26] = new Path(1050, 600+5-170, 1, 1);
		 }else{
			 
			 
			 schaedelPos = 200;
			 
			 path[12] = new Path(550, 600+5-302, 1, 1);
			 path[13] = new Path(600, 600+5-302, 0, 3);
			 path[14] = new Path(602, 600+5-202, 0, 2);
			 path[15] = new Path(602, 600+5-102, 0, 2);
			 path[16] = new Path(600, 600+5-52, 1, 5);
			 path[17] = new Path(700, 600+5-52, 1, 1);
			 path[18] = new Path(800, 600+5-52, 1, 1);
			 path[19] = new Path(850, 600+5-52, 2, 6);
			 
			 path[20] = new Path(850, 600+5-152, 2, 2);
			 path[21] = new Path(850, 600+5-252, 2, 2);
			 path[22] = new Path(850, 600+5-352, 2, 2);
			 path[23] = new Path(850, 600+5-402, 2, 2);
			 path[24] = new Path(850, 600+5-470, 1, 4);
			 path[25] = new Path(950, 600+5-470, 1, 1);
			 path[26] = new Path(1050, 600+5-470, 1, 1);
			 
			 
		 }
		 
	 }
	 
	 
	 
	 public static void drawInterface(){
		 
		 StdDraw.picture(WIDTH-90,HEIGHT-30, "RolleHorizontal.png");
		 StdDraw.picture(canonButtonX, canonButtonY, "TurmButton1.png");
		 StdDraw.picture (rumButtonX, canonButtonY, "TurmButtonRum.png");
		 StdDraw.picture(millButtonX, canonButtonY, "TurmButton3.png");
		
		StdDraw.picture(WIDTH-80, 30, "WaveInterface.png");
		StdDraw.text(WIDTH-90, 15, "Wave   "+wavelevel);
		StdDraw.text(WIDTH-90, 37, "Score  "+score);
		
		if(towerCost){
			StdDraw.text(canonButtonX, canonButtonY+28, 200+" G");

		 	StdDraw.text(rumButtonX+3, canonButtonY+28, 180 +" G" );

		 	StdDraw.text(millButtonX+5, canonButtonY+28, 230+" G");
		}
	 }
	 
	 

	 public static void watchMouse(){
		 
		 
		 
		 if(StdDraw.mouseX()>WIDTH-250 && StdDraw.mouseY()> HEIGHT-100){
			 
			 towerCost = true;
		}else{
			towerCost = false;
		}
		 
		 if(StdDraw.mousePressed()){
			 
			 
			 
		   	if(Math.abs(StdDraw.mouseX()-canonButtonX)<=40 && Math.abs(StdDraw.mouseY()-canonButtonY)<=40 ){
				 buildCanon = true;
				 buildRum = false;
				 buildMill = false;
			 }
		   	
		   	if(Math.abs(StdDraw.mouseX()-rumButtonX)<=40 && Math.abs(StdDraw.mouseY()-canonButtonY)<=40 ){
				 buildRum = true;
				 buildCanon = false;
				 buildMill = false;
				
			 }
		   	
		   	if(Math.abs(StdDraw.mouseX()-millButtonX)<=40 && Math.abs(StdDraw.mouseY()-canonButtonY)<=40 ){
				 buildMill = true;
				 buildCanon = false;
				 buildRum = false;
				
			 }
		   	
		   	if(upgrade == false){
		   	for(int i = 0; i < towers.size(); i++){
		   		
		   		if( Math.abs( towers.get(i).getX()-StdDraw.mouseX() ) <= towers.get(i).getSize() &&
		   		Math.abs( towers.get(i).getY()-StdDraw.mouseY() ) <= towers.get(i).getSize()){
		   			
		   			upgradeIndex = i;
		   			upgrade = true;
		   			upgradeX = towers.get(i).getX();
		   			if(towers.get(i).getY() < HEIGHT-150 )	upgradeY = towers.get(i).getY()+ 100;
		   			else	upgradeY = towers.get(i).getY()- 70;
		   		}
		   	}
		   	}
		   	
		   	if(upgrade){
		   		
		   		
		   		if(Math.abs( StdDraw.mouseX()-(upgradeX))>100 || Math.abs(StdDraw.mouseY()-(upgradeY))>100){
		   			
		   			upgrade = false;
		   		}

				if(Math.abs( StdDraw.mouseX()-upgradeX-30)<35 && Math.abs(StdDraw.mouseY()-(upgradeY-10))<35){
					upgrade = true;
					sellTower(upgradeIndex);
				}
				
				if(Math.abs( StdDraw.mouseX()-upgradeX+30)<35 && Math.abs(StdDraw.mouseY()-(upgradeY-10))<33){
					upgrade = true;
					upgradeTower (upgradeIndex);
				}
				
		   		
				if( Math.abs( StdDraw.mouseX()-(upgradeX+85))<20 && Math.abs(StdDraw.mouseY()-(upgradeY+45))<=20 ){
					upgrade = false;
				}
			}
				 
				 
				 
			 
			 
		   	
		   	
		 }// MousePressed
		
	 }
	 
	 public static void upgradeTower(int index){
			Tower tower = towers.get(upgradeIndex);
			Tower upgraded;
			
			if (tower.getTyp() == 1){
				upgraded = new Kanone2 (tower.getX(), tower.getY());
				
			}else if (tower.getTyp() == 4){
				upgraded = new Kanone3 (tower.getX(), tower.getY());
				}
			else if (tower.getTyp() == 3){
				upgraded = new Windmill2 (tower.getX(), tower.getY());
			}
			else if (tower.getTyp() == 6){
				upgraded = new Windmill3 (tower.getX(), tower.getY());
			}
			else if (tower.getTyp() == 2){
				upgraded = new Rumkanone2 (tower.getX(), tower.getY());
			}
			else if (tower.getTyp() == 5){
				upgraded = new Rumkanone3 (tower.getX(), tower.getY());
			}
			else {
				message = "Tower kann nicht upgradet werden!";
				return;
			}
				if (gold- upgraded.getCost() >= 0){
				
						towers.remove(upgradeIndex);
						towers.add(upgradeIndex, upgraded);		//add Tower der im Vordergrund steht vor Hinteren Towers
					
					 gold = gold - upgraded.getCost();
				}else message = "Zu wenig Gold zum upgraden des Turms!";
	 		
			upgrade = false;
					
		}
		
		public static void sellTower (int index){
			Tower tower = towers.get (upgradeIndex);
			int money = tower.getCost();
			towers.remove(upgradeIndex);
			gold += (int)(money *0.5);
			upgrade = false;
		}
	 
	 
	 public static void watchUpgrade(){
		 
		 if(upgrade){
			 
			 StdDraw.picture(upgradeX, upgradeY, "RolleTurm.png");
			 
			 int type = towers.get(upgradeIndex).getTyp();
			 
			 if(type==1 || type==4 || type==7 ) StdDraw.setPenColor(StdDraw.RED);
			 if(type==2 || type==5 || type==8 ) StdDraw.setPenColor(StdDraw.BLUE);
			 if(type==3 || type==6 || type==9 ) StdDraw.setPenColor(StdDraw.YELLOW);
			 
			 StdDraw.circle(towers.get(upgradeIndex).getX(), towers.get(upgradeIndex).getY(), towers.get(upgradeIndex).getRange());
			 StdDraw.setPenColor(StdDraw.BLACK);
			 if(towers.get(upgradeIndex).getUpgradeCost() != 0)
			 StdDraw.text(upgradeX-40, upgradeY-37, towers.get(upgradeIndex).getUpgradeCost()+" G");
			 else 	 StdDraw.text(upgradeX, upgradeY-37,"Max. Ausbaustufe");
			 
			 
			 
		 }
		 
	 }
	 
	 public static void stillslowed (){ //Nach 1,7 Sekunden hört der slow auf
		 Enemy ship;
		 for (int i = 0; i < enemies.size(); i++){
			 ship = enemies.get(i);
			 if (ship.effected == 1 && ship.effected != 2){
				 if ((ship.timer+1700) <= System.currentTimeMillis()){
					 ship.effected = 0;
					 if (ship.type == 1) ship.speed = 1;
			 		 if (ship.type == 2) ship.speed = 1.8;
			 		 if (ship.type == 3) ship.speed = 1.2;
				 }
			 }
		 }
	 }
	 
	 public static void stillstunned (){
		 Enemy ship;
		 	for (int i = 0; i < enemies.size(); i++){
		 		ship = enemies.get(i);
		 		if (ship.effected == 2 && ship.timer + 200 <= System.currentTimeMillis()) ship.effected =0;	
		 		if (ship.effected == 4 && ship.timer +300 <= System.currentTimeMillis()) ship.effected = 0;
		 		if (ship.effected == 5 && ship.timer +500 <= System.currentTimeMillis()) ship.effected = 0;
		 		
		 		if (ship.effected == 0){
		 			if (ship.type == 1) ship.speed = 1;
		 			if (ship.type == 2) ship.speed = 2;
		 			if (ship.type == 3) ship.speed = 1.2;
		 		}
		 	}
	 }
	 
		 
	 
	 public static void HandleDot(){					// HandleDot Methode wird in DrawShips durchgelafen um einen weiteren schleifen Durchlauf von
		 	// den Schiffen zu vermeiden
		 	Enemy e;
		 	for (int i = 0; i <enemies.size(); i++){
		 		e = enemies.get(i);
		 		if(e.getDot()){
		    
		 			if(e.getDotTimer()%40 == 0){
		 				int hp = e.getHP();
		 				e.setHP(hp-e.getDotLevel());
		 				
		 			}
		 		}
		    
		 		if(e.getDotTimer() > 300){
		     
		 			e.setDotTimer(0);
		 			e.setDot(false);
		 		}
		 		
		 		long dot = e.getDotTimer();
		 		e.setDotTimer(dot+1);
	 		}
		}
	 
	 
	 public static void mouseSetCanon(){
		 
		 if(buildCanon == true) {
				if(checkBuildable((int)StdDraw.mouseX(),(int)StdDraw.mouseY(),1) && gold >= 200 && ( StdDraw.mouseX()<=(WIDTH-300) || StdDraw.mouseY()<= HEIGHT-100) ){
					
					StdDraw.picture((int)StdDraw.mouseX(),(int)StdDraw.mouseY()+30, "turm1.png");
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.circle((int)StdDraw.mouseX(),(int)StdDraw.mouseY(), canonRadius);
					StdDraw.setPenColor(StdDraw.BLACK);			
					
				 }
				
				 if(StdDraw.mousePressed() && ( StdDraw.mouseX()<=(WIDTH-300) || StdDraw.mouseY()<= HEIGHT-100) ){
					 buildKanone((int)StdDraw.mouseX(),(int)StdDraw.mouseY());
					 buildCanon = false;
					 
				 }
				 showMessage();
			 }
		 
		 
	 }
	 
	 
	 public static void mouseSetRum(){
		 
		 if(buildRum == true) {
				if(checkBuildable((int)StdDraw.mouseX(),(int)StdDraw.mouseY(),2) && gold >= 180  && ( StdDraw.mouseX()<=(WIDTH-300) || StdDraw.mouseY()<= HEIGHT-100)){
					
					StdDraw.picture((int)StdDraw.mouseX(),(int)StdDraw.mouseY()+5, "RumKanone.png");
					StdDraw.picture(StdDraw.mouseX()+20, StdDraw.mouseY()+35, "RapeApe1.png");
					StdDraw.setPenColor(StdDraw.BLUE);
					StdDraw.circle((int)StdDraw.mouseX(),(int)StdDraw.mouseY(), rumCanonRadius);
					StdDraw.setPenColor(StdDraw.BLACK);			
					
				 }
				
				 if(StdDraw.mousePressed()  && ( StdDraw.mouseX()<=(WIDTH-300) || StdDraw.mouseY()<= HEIGHT-100)  ){
					 buildRum((int)StdDraw.mouseX(),(int)StdDraw.mouseY());
					 buildRum = false;
					 
				 }
				 showMessage();
			 }
		 
		 
	 }
	 
	 public static void mouseSetRMill(){
		 
		 if(buildMill == true) {
				if(checkBuildable((int)StdDraw.mouseX(),(int)StdDraw.mouseY()+10,2) && gold >= 230  && ( StdDraw.mouseX()<=(WIDTH-300) || StdDraw.mouseY()<= HEIGHT-100)){
					
					StdDraw.picture((int)StdDraw.mouseX(),(int)StdDraw.mouseY()+30, "Windmuehle2.png");
					StdDraw.picture(StdDraw.mouseX()-5, StdDraw.mouseY()+40, "Windmuehle1.png");
					StdDraw.setPenColor(StdDraw.YELLOW);
					StdDraw.circle((int)StdDraw.mouseX(),(int)StdDraw.mouseY(), millRadius);
					StdDraw.setPenColor(StdDraw.BLACK);			
					
				 }
				
				 if(StdDraw.mousePressed()  && ( StdDraw.mouseX()<=(WIDTH-300) || StdDraw.mouseY()<= HEIGHT-100)  ){
					 buildMill((int)StdDraw.mouseX(),(int)StdDraw.mouseY()+10);
					 buildMill = false;
					 
				 }
				 showMessage();
			 }
		 
		 
	 }
	 
	 
	 public static void keyCheck() {
	       
	       char key = 0;
	       
	       if(StdDraw.hasNextKeyTyped()){
	            key = StdDraw.nextKeyTyped();
	       }
	       
	       
	       // debug
	       /*
	       if( key != 0 && ( (key >= 97 && key <= 122) || (key >= 48 && key <= 57) ))
	       System.out.println( (int)key + " pressed! ");
	       */
	       
	       // mute sounds
	       if(key == 'm'){
	          
	          if(sounds == true){
	        	  sounds = false;
	          } else {
	        	  sounds = true;
	          }
	          
	          
	       }
	       
	       //fast forward
	       if(key == 'f'){
	    	   if(gameTime == 25) gameTime = 1;
	    	   else gameTime = 25;
	    	   
	       }
	       
	       //pause
	       if(key == 'p'){	
	    	   if(pause == true){
	    		   	pause = false;
	    	   }
	    	   else{
	    		   	pause = true;
	    	   }
	       }
	       //Start
	       if(key=='n'){
	    	   start = true;
	    	   
	       }

	       // developer cheats
	       /*
	       if(key == 'j'){
	          lifes = 0;
	       }
	       // add enemy schiff
	       if(key == 's'){ //
	          enemies.add(new Schiff(-100,startY));
	       }
	       // add enemy floss
	       if(key == 'd'){ 
	          enemies.add(new Floss(-100,startY+30)); 
	       }
	       // cash
	       if(key == 'c'){ 
	          gold += 1000;
	       }*/

	       // bind 1, 2 ... to towers
	       if(key == '1'){
	             buildCanon = true;
	             buildRum = false;
	             buildMill = false;
	             upgrade = false;
	       }
	      
	       if(key == '2'){
	          buildRum = true;
	          buildCanon = false;
	          buildMill = false;
	          upgrade = false;
	       }
	       
	       if(key == '3'){
	    	  buildRum = false;
		      buildCanon = false;
		      buildMill = true;
		      upgrade = false;
	    	   
	       }
	       
	       /*
	       if(playername.length() < 3 && key != 0){
	          
	          String key2 = "";
	          key2 = String.valueOf(key);
	       
	          playername = playername.concat(key2);
	       
	         StdDraw.text(WIDTH/2, HEIGHT/2, playername);
	         System.out.println(playername);
	       }
	       */
	       
	    }
	 
	 public static void gameover(){
	    
	    StdDraw.picture(WIDTH/2, HEIGHT/2+100, "game_over.png");
	    StdDraw.picture(WIDTH/2, HEIGHT/2, "game_over_your_name.png");
	    StdDraw.show(10);
       
       while(playername.length() < 5){
          
          char key = 0;
          if(StdDraw.hasNextKeyTyped()){
               key = StdDraw.nextKeyTyped();
          }
          
          
          
          if( key != 0 && ( (key >= 97 && key <= 122)  || ( key >= 48 && key <= 57 ) ) ){
             
             String key2 = "";
             key2 = String.valueOf(key);
          
             if(key2 != "" && key2 != ";"){
            	 
            	 
            	 StdDraw.text(WIDTH/2+5+playername.length()*40, HEIGHT/2, String.valueOf(key).toUpperCase());
                 StdDraw.show(10);
                 playername = playername.concat(key2);
                
             }
             
             playername = playername.toUpperCase();
             
             //System.out.println(playername);
             
             key = 0;
             try { Thread.sleep(250); } catch (Exception e) { }
          }
          
       }
       
       // upload score to highscore database
       int r = 0;
       r = HighScore.upload(playername, score);
       
       if(r != 0){
    	   System.out.println("Highscore Upload Failed! (Name = " + playername + ", Score = " + score + ", Error = " + r + ")");
       }
       
       lifes = -100;

	    
	 }
	 
	 
	 public static void sortEnemy(){
		 
		 Enemy enemy;
		 
		 for(int i = 0; i < enemies.size();i++){
			 
			 for(int k = i; k < enemies.size(); k++){
				 
				 enemy = enemies.get(k);
				 if(enemies.get(i).getX() < enemy.getX()){
					 enemies.add(i, enemy);
					 enemies.remove(k);
				 }
			 }
			 
		 }
	 }
	 
	 
	 
	 public static void shopMouseCheck(){
		 
		 // Ueberprueft die Maus im Shop Zustand zwischen dem Wechseln der Karten
		 
		 if(StdDraw.mousePressed()){
			 
			 
			// System.out.println("X: "+StdDraw.mouseX() + "Y: "+ StdDraw.mouseY());
			 
			   	if(Math.abs(StdDraw.mouseX()-continueX)<=100 && Math.abs(StdDraw.mouseY()-continueY)<=30 ){
					shop = false;
					Tower tower;
					for(int i = towers.size(); i > 0; i--){
						tower = towers.get(i-1);
						gold += tower.cost*0.7;
						towers.remove(i-1);
					}
				 }
			   	if (Math.abs(StdDraw.mouseX()- damageX) <= 50 && Math.abs(StdDraw.mouseY() - damageY)<=50){
			   		if (gold - 2000 >= 0){
			   			//System.out.println ("Geaped!");
			   			damageBoost++;
			   			gold-= 2000;
			   		}
			   	}
			   	if (Math.abs (StdDraw.mouseX() - heartX) <= 30 && Math.abs(StdDraw.mouseY() - heartY) <= 30){
			   		if (gold - 500>= 0){
			   			//System.out.println ("Love is in the air!");
			   			lifes++;
			   			gold-= 500;
			   		}
			   	}
		 }
		 
		 
		 
	 }

	 
	 
}
