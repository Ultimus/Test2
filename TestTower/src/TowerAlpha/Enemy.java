package TowerAlpha;


public abstract class Enemy{
	
	public double x;
	public double y;
	public double speed;
	public double direction;
	public int hp;
	public int width;
	public int heigth;
	public int type;
	public int bounty;
	public int effected;
	public long timer;
	public long dotTimer;
	public int dotLevel; 				// Wird fuer die verschiedenen Stufen der Tuerme angepasst, um zu wissen wie viel Schaden ein Gegner nimmt
	public boolean dot;

	
	
	public Enemy(double xPar, double yPar, double speedPar){
		
		this.x = xPar;
		this.y = yPar;
		this.speed = speedPar;
	
		
	}
	
	public void setDotLevel( int x ){
		this.dotLevel = x;
	}
	
	public int getDotLevel(){
		return this.dotLevel;
	}
	
	public void setDotTimer(long x){
		this.dotTimer = x;
	}
	
	public long getDotTimer(){
		return this.dotTimer;
	}
	
	public void setDot (boolean dot){
		this.dot = dot;
	}
	
	public boolean getDot (){
		return this.dot;
	}
	
	
	// Slowed getter und setter von Max 30.6.11
	
	public void setTimer(long timer){
		this.timer = timer;
	}
	
	public long getTimer(){
		return this.timer;
	}
	
	public void setEffected(int effected){
		this.effected = effected;
	}
	
	public int getEffected (){
		return this.effected;
	}
	
	
	//HP getter und setter von Philip Baues 13.05.11 - 14 uhr
	
	public void setHP (int hpPar) {
		
		this.hp = hpPar;
	
	}
	
	public int getHP () {
	
		return this.hp;
	
	}
	
	//End Change
	
	public void setPos(double xPar, double yPar){
		
		this.x = xPar;
		this.y = yPar;
	}
	
	public void setDirection(double par){
		this.direction = par;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public void setX(int par){
		this.x = par;
	}
	
	public void setY(int par){
		this.y = par;
	}
	
	public double getDirection(){
		return this.direction;
	}
	
	
	public void setSpeed(int speedPar){
		this.speed = speedPar;
		
	}
	
	public double getSpeed(){
		return this.speed;
	}
	
	public int getWidth(){		
		return this.width;
	}
	
	public int getHeigth(){
		return this.heigth;
	}
	
	public void setType(int type){
	   this.type = type;
	}
	
	public int getType(){
	   return this.type;
	}
	
	public void setBounty(int bounty){
		this.bounty = bounty;
	}
	
	public int getBounty(){
		return this.bounty;
	}
	
}
