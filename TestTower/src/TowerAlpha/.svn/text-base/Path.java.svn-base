package TowerAlpha;


public class Path {
	
	public int x;
	public int y;
	
	private int size = 60;			// 60 entspricht 100 Pixeln im Quadrat wegen der Zeichnung
	
	public int direction;
	public int image;
	
	public Path(int xPar, int yPar, int directionPar, int imagePar){
		
		this.x = xPar;
		this.y = yPar;
		if(directionPar <0 || directionPar >4) this.direction = 0; else
		this.direction = directionPar;
		this.image = imagePar;
		
	}
	
	public int getX(){
			return this.x;
	}
	
	public int getY(){
		return this.y;		
	}
	
	public int getSize(){
		return this.size;
	}
	
	public void setDirection(int par){
		if(par <0 || par >4) this.direction = 0; else
		this.direction = par;
	}
	
	public int getDirection(){
		
		return this.direction;
	}
	
	public int getImage(){
		return this.image;
	}

}
