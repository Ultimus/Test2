package testtower;

import java.util.LinkedList;

public class Game2 {

	public LinkedList<Enemy> enemies;
	
	public Jank ship1, ship2;
	int pathsize = 10;
	public Path[] path = new Path[pathsize];
	public static  boolean running = true;
	
	
	
	public Game2(){
		
		enemies = new LinkedList<Enemy>();
		ship1 = new Jank(0,375);
		ship2 = new Jank(200, 400);
		
		enemies.add(ship1);
		enemies.add(ship2);
		
		for(int i = 0; i< pathsize; i++){
			
			path[i] = new Path(100*i+137, 375, 1,1);	 //137 damit die GUI Position stimmt / 375 Pixelwert		
			
		}
		
		
		
		GUI2.init(path,enemies);
		

		
		
		
	}//Game2 Konstruktor
	
	
	public void fuehreAus(){
	
		
		while(ship1.getX()<700){
			
			this.enemyDirection();
			this.enemyMove();
			
			GUI2.init(path,enemies);
			
			System.out.println(ship1.getX());
		}
	
		
		
	}
	
	
	
	public void enemyDirection(){
		
		Enemy compareE; 
		
		for(int k = 0; k< enemies.size(); k++){ //als erstes Werden die Gegner durchgezaehlt
			for(int i = path.length-1; i>=0; i--){//und dannach ueberprueft wie sie zu laufen haben. Rueckwaerts um zu fruehe Kurven zu vermeiden
			
				compareE = (Enemy)enemies.get(k);
				
				if(Math.abs(compareE.getX()+compareE.getWidth()/2-path[i].getX())<=path[i].getSize() &&
						Math.abs(compareE.getY()+compareE.getHeigth()/2-path[i].getY())<= path[i].getSize()){
					
					compareE.setDirection(path[i].getDirection());
				
				}//if
			}//for
		}//for enemy
	}//enemy Direction
	
	
	public void enemyMove(){
		
		Enemy compareE; 
		
		for(int k = 0; k < enemies.size(); k ++){
			
			compareE = (Enemy)enemies.get(k);
			int xPos =	compareE.getX();
			int yPos = compareE.getY();
			
			
			if(compareE.getDirection() == 0){
				compareE.setPos(xPos,yPos+compareE.getSpeed());
			}//nach Oben
			
			if(compareE.getDirection() == 1){
				compareE.setPos(xPos+compareE.getSpeed(),yPos);
			}//nach rechts
			
			if(compareE.getDirection() == 2){
				compareE.setPos(xPos,yPos-compareE.getSpeed());

			}//nach unten
		
			if(compareE.getDirection() == 3){
				compareE.setPos(xPos-compareE.getSpeed(),yPos);
			}//nach links
			
		}
		
	}
	
	public static void main(String[] args){
		
		Game2 anwendung;
		anwendung = new Game2();
		anwendung.fuehreAus();
	}

}
