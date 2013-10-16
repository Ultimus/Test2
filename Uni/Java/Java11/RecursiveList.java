public class RecursiveList {

	protected int length;
	protected ConsCell first;
	protected ConsCell pointer;
	
	public RecursiveList() {
		this.first = new ConsCell(Double.NaN);
		this.length = 1;
		this.pointer = this.first;
	}

	public RecursiveList(double value) {
		this.first = new ConsCell(value);
		this.length = 1;
		this.pointer = this.first;
	}
	
	public RecursiveList(ConsCell first) {
		this.first = first;
		int counter = 1;
		this.pointer = first;
		while(pointer.getNext() != null) {
			counter++;
			this.pointer = this.pointer.getNext(); 
		}
		this.pointer = this.first;
		this.length = counter;
	}
		
	public int find(double value) {
		int index = 0;
		this.pointer = this.first;
		while(pointer.getValue() != value) {
			index++;
			this.pointer = this.pointer.getNext();
			if(pointer == null) {
				return -1;
			}
		}
		return index;
	}
	
	public double get(int index) {
		if((index > this.length-1)||(index < 0)) {
			return Double.NaN;
		}
		forward(index);
		double result = pointer.getValue();
		return result;
	}
	

	private void forward(int index) {
		if((index >  this.length-1)||(index < 0)) {
			return;
		}
		this.pointer = this.first;
		int forth = 0;
		while(index > forth) {
			this.pointer = this.pointer.getNext();
			forth++;
		}
	}
	
	public boolean delete(int index) {
		if((index > this.length-1)||(index < 0)) {
			return false;
		}
		if(index == 0){
			if(this.length == 1) {
				this.first.setValue(Double.NaN);
				return true;
			} else {
				this.first = this.first.getNext();
				this.length = this.length-1;
				return true;
			}
		}
		if(index == length-1) {
			forward(index-1);
			this.pointer.setNext(null);
			this.length = this.length-1;
			return true;
		}
		forward(index-1);
		ConsCell help = this.pointer;
		forward(index+1);
		help.setNext(this.pointer);
		this.length = this.length-1;
		return true;
	}
	

	public boolean insert(int index, double value) {
		if(((index > this.length)&&(size() != 0))||(index < 0)) {
			return false;
		}
		ConsCell input = new ConsCell(value, null);
	

		if(index == 0) {	
			if(size() == 0) {
				this.first.setValue(value);
				return true;
			}		
			input.setNext(this.first);
			this.first = input;
			this.length++;
			return true;
		}


		if(index == this.length) {
			append(value);
		}
		


		forward(index+1);
		input.setNext(this.pointer);
		forward(index-1);
		this.pointer.setNext(input);
		this.length++;
		return true;
	}
	

	public boolean swap(int index1, int index2) {
		if((index1 < 0)||(index1 > this.length-1)||(index2 < 0)||(index2 > this.length-1)) { return false; }
		double help1 = 0.0;
		double help2 = 0.0;
		forward(index1);
		help1 = this.pointer.getValue();
		forward(index2);
		help2 = this.pointer.getValue();
		this.pointer.setValue(help1);
		forward(index1);
		this.pointer.setValue(help2);
		return true;
	}
	

	public ConsCell getFirst() {
		return this.first;
	}
	

	public boolean append(double value) {
		ConsCell input = new ConsCell(value, null);
		forward(this.length-1);
		this.pointer.setNext(input);
		this.length++;
		return true;
	}
	
	

	public int size() {
		if((length == 1)&&(first.getValue() == Double.NaN)) {
			return 0;
		} else {
			return this.length;
		}
	}
	
	public void print() {
		System.out.println();
		for(int i=0; i < this.length; i++) {
			forward(i);
			System.out.print(this.pointer.getValue() + " ");
		}
	}
}			
