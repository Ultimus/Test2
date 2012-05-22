package TowerAlpha;

public class Kanone3 extends Tower{
	
	public Kanone3 (int x, int y){
		super (x,y);
		this.damage = 7;
		this.level = 3;
		this.range = 200;
		this.size = 30;
		this.speed = 10;
		this.coolDown = 100;
		this.waited = 0; //Turm hat 0 Sekunden zu Beginn gewartet bis er zuletzt geschossen hat
		this.cost = 1000;
		this.effect = 5;//tower stunned
		this.type = 7;
		this.upgradeCost = 0;
	}
}
