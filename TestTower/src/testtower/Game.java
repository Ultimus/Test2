package testtower;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;



public class Game {
	
	Enemy[] jank;
	int eCount = 1;	
	
	Path[] path;
	int ways = 4;
			
	public Game(){
		
	path = new Path[ways];
	
	path[0] = new Path(10,20, 1, 1);
	path[1] = new Path(20,20, 2, 2);
	path[2] = new Path(20,10, 3, 3);
	path[3] = new Path(10,10, 0, 0);
	
	jank = new Enemy[eCount];
	
	jank[0] = new Jank(10, 10);
	
	}
	
	// Change 15.05.11 by Philip Baues
	
	/*
	List enemyList; 
	List towerList = new List();
	
	Path[] pathArray;
	int ways = 4;
	
	Enemy e1;
	
	public Game() {
		
		enemyList = new List();
		
		e1 = new Jank(10,10,3, true);
		
		pathArray[0] = new Path(10,20, 1, 1);
		pathArray[1] = new Path(20,20, 2, 2);
		pathArray[2] = new Path(20,10, 3, 3);
		pathArray[3] = new Path(10,10, 0, 0);	
		
		for(int i = 0; i <1; i++){
			
			
			enemyList.add(e1);
			
		}
	}
	
	// End Change
	*/
	public void fuehreAus(){
		for (int i = 0; i < 10; i++) {
			this.enemyDirection();
			this.EnemyMove();
			
			System.out.println(jank[0].getX()+" , "+jank[0].getY());

		}//Die Wege sind so gesetzt dass der Gegner ein Quadrat entlang geht
		
		//Man sollte auch drauf achten die Geschw des Gegners nicht groesser als
		//eine Pathgroesse zu setzen, da er sonst im Nirgendwo landet...
	}
	
	public void enemyDirection(){
		
		for(int k = 0; k< eCount; k++){ //als erstes Werden die Gegner durchgezaehlt
			for(int i = 0; i<ways; i++){//und dannach ueberprueft wie sie zu laufen haben
			
				if(Math.abs(jank[k].getX()- path[i].getX())<= path[i].getSize() &&
					Math.abs(jank[k].getY()- path[i].getY()) <= path[i].getSize()
				){
					jank[k].setDirection(path[i].getDirection());
				
				}//if
			}//for
	}//for enemy
	}//enemy Direction
	
	
	public void EnemyMove(){
		
		for(int k = 0; k< eCount; k++){
			int xPos =	jank[k].getX();
			int yPos = jank[k].getY();
			
			if(jank[k].getDirection() == 0){
				jank[k].setPos(xPos,yPos+jank[k].getSpeed());
			}//nach Oben
			
			if(jank[k].getDirection() == 1){
				jank[k].setPos(xPos+jank[k].getSpeed(),yPos);
			}//nach rechts
			
			if(jank[k].getDirection() == 2){
				jank[k].setPos(xPos,yPos-jank[k].getSpeed());

			}//nach unten
		
			if(jank[k].getDirection() == 3){
				jank[k].setPos(xPos-jank[k].getSpeed(),yPos);
			}//nach links
		}//for
	}//EnemyMove

	public static void main(String[] args){
		
		Game anwendung;
		anwendung = new Game();
		anwendung.fuehreAus();
	}

}//class
	
	
	
