package TowerAlpha;

public class CanonBall extends Thread {
	
	public double x;
	public double y;
	public double targetX;
	public double targetY;
	public int towerID;
	public int enemyID;
	public double factor;
	
	public CanonBall(int towerID, int enemyID, double factor, double xPar, double yPar, double targetXPar, double targetYPar){
	   this.towerID = towerID;
	   this.enemyID = enemyID;
		this.x = xPar;
		this.y = yPar;
		this.targetX = targetXPar;
		this.targetY = targetYPar;
	}

	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public double getTargetX(){
		return this.targetX;
	}

	public double getTargetY(){
		return this.targetY;
	}
	
	public void setX(int xPar){
		this.x = xPar;
	}
	
	public void setY(int yPar){
		this.y = yPar;
	}
	
   public int getTower(){
      return this.towerID;
   }
   
   public int getEnemy(){
      return this.enemyID;
   }
   
   public void setFactor(double factor){
      this.factor = factor;
   }
   
   public double getFactor(){
      return this.factor;
   }
	
	
	//public void run(){
		
	//}
}
