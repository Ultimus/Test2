import java.util.LinkedList;

public class Unit {



    int actualX;
    int actualY;
	int x,y, id;
	int type;
	int range;
	int move;
	int atk;
    int def;
    int faction;
    boolean clicked;
    LinkedList<String> states= new LinkedList<String>();


	
	public Unit(int x, int y, int id){
		this.x=x;
		this.y=y;
        this.id = id;
		
	}

    public void displayMoveRange(){

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getActualX() {
        return actualX;
    }

    public void setActualX(int actualX) {
        this.actualX = actualX;
    }

    public int getActualY() {
        return actualY;
    }

    public void setActualY(int actualY) {
        this.actualY = actualY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getFaction() {
        return faction;
    }

    public void setFaction(int faction) {
        this.faction = faction;
    }

    public LinkedList<String> getStates() {
        return states;
    }

    public void setStates(LinkedList<String> states) {
        this.states = states;
    }

}
