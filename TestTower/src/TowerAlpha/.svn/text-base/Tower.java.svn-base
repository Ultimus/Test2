package TowerAlpha;

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
	public int coolDown;
	public int waited; 		//Variable die im Objekt selber den CoolDown Hochz�hlen kann
	public int cost;
	public int effect;
	public int type;		// 1 = normale Kanone    2 = Rum Kanone
	public boolean apeThrow;		//fuer Animation von Rape auf der Rummkanone notwendig 
	public int millTurn = 0;
	public int upgradeCost;
	
	
	public Tower(int xPar, int yPar){
		
		this.x = xPar;
		this.y = yPar;
		
	}
	
	
	
	public int getUpgradeCost(){
		
		return this.upgradeCost;
	}
	
	
	public void setTurn(int x){
		
		this.millTurn = x;
	}

	public int getMillTurn(){
		
		return this.millTurn;
	}
	
	public boolean getApeThrow(){
		
		return this.apeThrow;
	}
	
	public void setApeThrow(boolean throwPar){
		
		this.apeThrow = throwPar;
	}
	
	public void setEffect (int effect){
		this.effect= effect;
	}
	public int getEffect (){
		return this.effect;
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
	
	public int getSize(){
		return this.size;
	}
	
	public int getRange(){
		return this.range;
	}
	
	public int getDamage(){
		return this.damage;
	}
	
	public int getCoolDown(){
		return this.coolDown;
	}
	
	public int getWaited(){
		return this.waited;
	}
	
	public void setWaited(int par){
		this.waited = par;
	}
	
	public int getCost(){
		return this.cost;
	}
	
	public int getTyp(){
		return this.type;
	}
}