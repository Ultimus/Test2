package testtower;

public abstract class Tower {

	//Added 15.05.11 by Philip Baues
	
	public int x;
	public int y;
	public int range;
	public int damage;
	public int level;
	public int size;
	public int speed;
	public double lastShot;
	
	public Tower(int xPar, int yPar){
		
		this.x = xPar;
		this.y = yPar;
		
	}
	
	public void setPos(int xPar, int yPar) {
		
		this.x = xPar;
		this.y = yPar;
		
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setX(int par){
		this.x = par;
	}
	
	public void setY(int par){
		this.y = par;
	}
	
}