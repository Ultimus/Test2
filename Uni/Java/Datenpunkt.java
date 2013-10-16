public class Datenpunkt{

	public final DoublePair pos;
	public final int value;

	public Datenpunkt(DoublePair pos, int value){
		this.pos = pos;
		this.value = value;

	}

	public Datenpunkt (double x, double y, int value){
		this.pos = new DoublePair(x,y);
		this.value = value;
	}
}
