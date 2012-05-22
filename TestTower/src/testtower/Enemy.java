package testtower;


public abstract class Enemy{
	
	public int x;
	public int y;
	public int speed;
	public int direction;
	public int hp;
	public int width;
	public int heigth;
	
	
	public Enemy(int xPar, int yPar, int speedPar){
		
		this.x = xPar;
		this.y = yPar;
		this.speed = speedPar;
		
	}
	
	//HP getter und setter von Philip Baues 13.05.11 - 14 uhr
	
	public void setHP (int hpPar) {
		
		this.hp = hpPar;
	
	}
	
	public int getHP () {
	
		return this.hp;
	
	}
	
	//End Change
	
	public void setPos(int xPar, int yPar){
		
		this.x = xPar;
		this.y = yPar;
	}
	
	public void setDirection(int par){
		this.direction = par;
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
	
	public int getDirection(){
		return this.direction;
	}
	
	public int getSpeed(){
		return this.speed;
	}
	
	public int getWidth(){		
		return this.width;
	}
	
	public int getHeigth(){
		return this.heigth;
	}
	
}
