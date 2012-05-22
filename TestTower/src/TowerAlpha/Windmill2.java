package TowerAlpha;

public class Windmill2 extends Tower{

	public Windmill2(int x, int y){
		super (x,y);
		this.damage = 1;
		this.level = 2;
		this.range = 170;
		this.size = 40;
		this.speed = 15;
		this.coolDown = 90;
		this.waited = 0; //Turm hat 0 Sekunden zu Beginn gewartet bis er zuletzt geschossen hat
		this.cost = 900;
		this.effect = 6; //Dot lvl 2
		this.type = 6;
		this.upgradeCost = 2000;
	}
}
