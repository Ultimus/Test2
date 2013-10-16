public class MyQueue{

	private ConsCell first;
	private ConsCell pointer;	

	public MyQueue(){
	}

	private void offer (double d){ //Fügt d in die Warteschlange ein
		while( getNext != null){
			pointer = getNext();
		}
		this.pointer.setNext(d);
		this.setvalue = d; //brauch ich das?
	}


	private double peek(){ //Gibt den ersten Wert der Warteschlange aus ohne ihn zu entfernen
		System.out.println (this.first);
	}

	
	private int size(){ //Gibt die Anzahl der Elemente der Warteschlange zurück
		int counter = 0;
		while (getNext != null){
			counter++;
		}
	return counter;
	}

