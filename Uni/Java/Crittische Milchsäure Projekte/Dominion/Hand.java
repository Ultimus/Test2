public class Hand{

	public Hand hand (){
		handsize = 0;
	}	
	public Hand discard (Card card){
		if (Handsize <= 0){
			System.out.println ("Keine handkarten zum abwerfen vorhanden.");
			return;/*wohin?*/
		}
		addgrave (card);
		Handsize--;
		return hand;
	}

	public Hand draw (){
		Handsize++;
		Card card = new Card(library.next);
		/*add to hand*/
		return hand;
	}

	public Hand disjunk (Card card){
		if (Handsize <= 0){
			System.out.println ("Keine handkarten zum entsorgen vorhanden.");
			return;/*wohin?*/
		}
		addtrash (card);
		Handsize--;
		return Hand;
	}

}
