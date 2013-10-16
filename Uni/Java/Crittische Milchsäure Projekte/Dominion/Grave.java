public class Grave{
	public Grave (){
		Card card;
		Node next;
	}

	public void addtograve (Card card){ 	
			Node second = first;
			first = new Node();
			first.item = item;
			first.next = second;
	}
	

	public Grave shufflegrave (){
		}
	public boolean isEmpty (){return first==null;}

	public Grave gravetolib (){
		while (!isEmpty){
			 
			Card card = first.card;
			Library.next = card;
			first= first.next;	
		}
	}
}
