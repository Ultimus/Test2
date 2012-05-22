package TowerAlpha;

public class Windmill3 extends Tower{
	public Windmill3(int x, int y){
		super (x,y);
		this.damage = 1;
		this.level = 3;
		this.range = 170;
		this.size = 40;
		this.speed = 15;
		this.coolDown = 90;
		this.waited = 0; //Turm hat 0 Sekunden zu Beginn gewartet bis er zuletzt geschossen hat
		this.cost = 2000;
		this.effect = 7; //Dot lvl 2
		this.type = 9;
		this.upgradeCost = 0;
	}
}

