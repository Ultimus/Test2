package TowerAlpha;

public class Schiff extends Enemy {
	
	static double speed = 1.1;
	
	public Schiff(int xPar, int yPar){
		
		super(xPar, yPar, speed);
			this.hp = 20; // Beispiel jede Jank hat 10 HP muss nicht im Konstrukter uebergeben werden Change 13.05
			this.direction = 1;
			this.width = 100;
			this.heigth = 60;
			this.bounty = 50;
			this.type = 1;
			//this.type = (int)(1+Math.random()*2); // definiert aussehen floss oder schiff
	}
	
	
	public Schiff(int xPar, int yPar, int additionalHP){
		
		super(xPar, yPar, speed);
			this.hp = 20+additionalHP; // Beispiel jede Jank hat 10 HP muss nicht im Konstrukter uebergeben werden Change 13.05
			this.direction = 1;
			this.width = 100;
			this.heigth = 60;
			this.bounty = 50;
			this.type = 1;
			//this.type = (int)(1+Math.random()*2); // definiert aussehen floss oder schiff
	}
	
	public void setPos(int xPar, int yPar){
		
		super.setPos(xPar, yPar);
		
	}

}
