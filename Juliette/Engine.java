import java.util.HashMap;
public class Engine{

	public HashMap setupDatabase(){
		HashMap<Number, Stellung> map = new HashMap<Number, Stellung>();
		Stellung atergo = new Stellung(1,"","Von Hinten");
		Stellung reiten= new Stellung(2,"", "Frau oben");
		Stellung neunundsechzig = new Stellung (3, "", "69");
		
		map.put(1, atergo);
		map.put(2, reiten);
		map.put(3, neunundsechzig);
		return map;
	} 

	public void roll (){
		int num = (int)Math.random() * (3-1)+ 1;
		HashMap<Number, Stellung> map;
		map = setupDatabase();


		
	}
			



}
