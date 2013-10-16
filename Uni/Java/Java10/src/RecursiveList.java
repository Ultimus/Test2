import static org.junit.Assert.*;
import org.junit.*;


public class RecursiveList implements IList {
	private ConsCell Cell = new ConsCell();

	public int find (double value){
		ConsCell temp = Cell;
		return find (value, temp, 0);
	}

	private int find (double value, ConsCell temp, int count){
		if (Double.compare (value, temp.getValue()) == 0){
			return count;
		}
		if (temp.getNext()== null){
			return -1;
		}
		return find (value, temp.getNext(), (count+1));
	}

	public double get(int index, ConsCell temp, int count){
		if (index == count){
			return temp.getValue();
		}
		if (temp.getNext()==null){
			return Double.NaN;
		}
		return get(index, temp.getNext(), (count+1));
	}
}
