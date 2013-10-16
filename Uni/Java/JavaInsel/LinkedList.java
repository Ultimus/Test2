public class LinkedList{
	private class Node {
		private String item;
		private Node next;
	}

	private Node third = new Node();
	private Node second = new Node();
	private Node first = new Node();

		public boolean isEmpty (){ return first==null;}

		public void push (String item){ 	
			Node second = first;
			first = new Node();
			first.item = item;
			first.next = second;
		}

		public String pop(){ 
			String item = first.item;
			first= first.next;
			return item;
		}
		
		public void print(){
			push ("hübsch");
			push ("ist");
			push ("Tanja");
		
		while (pop() != null)
		System.out.println (pop());
		}

	
	
}
