import java.util.HashMap;
public class Engine{

	public Stellung[] setupDatabase(){
		Stellung[] Kamasutra = new Stellung[3];
		Kamasutra[0] = new Stellung(1,"","Von Hinten");
		Kamasutra[1]= new Stellung(2,"", "Frau oben");
		Kamasutra[2] = new Stellung (3, "", "69");
		
		return Kamasutra;
	} 

	public Stellung roll(){
		//int num = (int)Math.random() *40 + 1;
		double RNG = Math.random()*3;
		System.out.println("RNG: "+RNG); 
		Stellung[] Kamasutra = setupDatabase();
		return Kamasutra[(int)RNG];
	}
			



}
