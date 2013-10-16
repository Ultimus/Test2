public class Massacre{

	public static boolean ende = false;
	
	
	//Spieler Koordinaten
	
	public static double xPos = 12;
	public static double yPos = 10;
	public static double speed = 0;
	
	public static  boolean jump = false;
	public static boolean fall = false;
	public static double jumpDistance = 0;
	
	public static boolean saw = false;
	
	
	public static int folge = 1;
	public static char d = 'm';
	
	//Umgebung
	
	public static double floor = 10;
	public static double xback = 190;
	public static double left = 10;
	public static double right = 60;
	
	//Zombie
	
	public static double[] enemyX = {80, 89, 103, 110, 120	};
	public static boolean[] enemyAlive = {false, false, false, false, false};
	public static double ani = 1;
	public static int bli = 1;
	public static boolean blood = false;
	public static int corpse = 0;
	public static double[] tot = {300, 300, 300, 300, 300, 300, 300, 300, 300, 300};
	
	

	public static void main(String[] args){
	
		StdDraw.setCanvasSize(800, 500);
		StdDraw.setXscale(0, 80);
		StdDraw.setYscale(0,50);
	
	
	
		while(!ende){
			StdDraw.clear();
			background();
			leichen();
			control();
			enemy();
			splatter();
			
			StdDraw.show(20);
		}
	
	}

	
	public static void control(){
	
		move();
		draw();
		
	}
	
	public static void move(){
	
		
		if(StdDraw.hasNextKeyTyped()){
			d = StdDraw.nextKeyTyped();	
			
		}
					
		if(d =='l'){
			if(xPos < right) xPos = xPos +.5;
			
		}
		if(d == 'j'){
			
			if(xPos > left)xPos = xPos - .5;
			
		}
		
					
		if(jump == false || fall == false){
			if(d == 'a'){
				jump = true;
				d = 'm';	
				}
		}
		air();
		
		if(d == 's'){
		saw = true;
		folge = 1;
		d = 'm';
		
		for(int a = 0; a < 5; a++){
								if(Math.abs(enemyX[a]-xPos)<= 5){
									enemyAlive[a] = false;
									blood = true;
								}
							}
		
		}
	}

	public static void air(){
		
			if(jump){
				
				yPos = (-((jumpDistance-4)*(jumpDistance-4))+16.5)+floor;
				jumpDistance = jumpDistance +0.3;	
				if(yPos<=floor){
					jump = false;
					jumpDistance = 0;
					yPos = floor;	
				}
						
			}
	}
	
	public static void background(){
		StdDraw.picture(xback,25, "Hintergr.gif");	
		if(xPos <= left && xback <= 190 && d == 'j'){

			xback = xback +0.5;
			for(int a = 0; a < 5; a++) enemyX[a] = enemyX[a]+0.5;
			for(int a = 0; a < 10; a++) tot[a] = tot[a]+0.5;
		}

		if(xPos >= right && xback >= -110 && d=='l'){
			
			xback = xback - 0.5;
			for(int a = 0; a < 5; a++) enemyX[a] = enemyX[a]-0.5;
			for(int a = 0; a < 10; a++) tot[a] = tot[a]-0.5;
		
		}
	}
	
	public static void draw(){
		
			
		if(d == 'l'){
			if(folge == 1 || folge == 2)	StdDraw.picture(xPos,yPos, "r1.gif");
			if(folge == 3 || folge == 4) StdDraw.picture(xPos,yPos, "r2.gif");
			if(folge == 5 || folge == 6) StdDraw.picture(xPos,yPos, "r3.gif");
			
			folge++;
			if(folge > 6) folge = 1;
		}else{
		
			if(d == 'j'){
				if(folge == 1 || folge == 2)	StdDraw.picture(xPos,yPos, "l1.gif");
				if(folge == 3 || folge == 4) StdDraw.picture(xPos,yPos, "l2.gif");
				if(folge == 5 || folge == 6) StdDraw.picture(xPos,yPos, "l3.gif");
			
				folge++;
				if(folge > 6) folge = 1;
			}else{
								
					if( saw){
							if(folge == 1 || folge == 2)	StdDraw.picture(xPos,yPos, "s1.gif");
							if(folge == 3 || folge == 4) StdDraw.picture(xPos,yPos, "s2.gif");
							if(folge == 5 || folge == 6) StdDraw.picture(xPos,yPos, "s3.gif");
							
							/*for(int a = 0; a < 5; a++){
								if(Math.abs(enemyX[a]-xPos)<= 5){
									enemyAlive[a] = false;
									blood = true;
								}
							}*/
			
						folge++;
						if(folge >= 6) saw = false;
					
					}else{
					StdDraw.picture(xPos,yPos, "c1.gif");
				}
			}
		}
		
	
	}//draw
		
	
	
	public static void enemy(){
		
		
		
		for(int a = 0; a < 5; a++){
		
			if(enemyAlive[a]){
				enemyX[a] = enemyX[a] - Math.random()*0.7;
				
				if(ani <= 2 && ani >=1 )StdDraw.picture(enemyX[a],floor+1, "z1.gif");
				if(ani <= 3 && ani >=2) StdDraw.picture(enemyX[a],floor+1, "z2.gif");
				if( ani >=3) 			StdDraw.picture(enemyX[a],floor+1, "z3.gif");
				ani = ani+0.5;
				if(ani >= 4) ani = 1;
				
				if(enemyX[a] <= -20) enemyX[a] = 100+ Math.random()*80;
						
			}else{
				enemyX[a] = 100+Math.random()*80;
				enemyAlive[a] = true;
			
			}
		}//for
	
	}
	
	public static void	splatter(){
	
		if(blood){
		
			if(bli==1){
				StdDraw.picture(xPos+3,floor+1, "b1.gif");
				
				tot[corpse]= xPos;
				corpse ++;
				if(corpse >=10) corpse = 1;
			}
			if(bli==2) StdDraw.picture(xPos+3,floor+1, "b2.gif");
			if(bli==3) StdDraw.picture(xPos+3,floor+1, "b3.gif");
			if(bli==4) StdDraw.picture(xPos+3,floor+1, "b4.gif");
			if(bli==5) StdDraw.picture(xPos+3,floor+1, "b5.gif");
			bli ++;
			
			
			
			if(bli >5){
				bli = 1;
				blood = false;
			}
		}
	
		
	}
	
	public static void leichen(){
		
		for(int a = 0; a< 10; a++){
			StdDraw.picture(tot[a],floor, "tot.gif");
		}
	}
	
	
}