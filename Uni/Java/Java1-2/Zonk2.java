public class Zonk{
public static void main(String[] in){
    
String[] in2= new String[2];
in2[0]=in[0];

if (in.length==1){

	in2[1]="1";
        Zonk(in2);

	in2[1]="2";
	Zonk(in2);

	in2[1]="3";
	Zonk(in2);
      }
}

public static void Zonk(String[] in){
        
if(in.length != 2) {
            System.out.println("Usage Zonk N Strategy");
}

	//Anzahl Gewinne
        int winCounter = 0;

	//Anzahl?
        int N =Integer.parseInt(in[0]);

	//Strategie
        int strategy =Integer.parseInt(in[1]);

        boolean Newstr = false;

	if (strategy == 3)
          Newstr = true;

        for (int i=0; i<N; i++) {
            int price = (int)(1.0+(Math.random()*3));
            int selected = (int)(1.0+(Math.random()*3));
       
   
 
	if (Newstr==true)
          strategy = (int) (1.0 +(Math.random ()*2));
  
            if(strategy == 1) {
                // Strategy 1 always change the selection
                if (selected != price) winCounter++;
            }
            else {
                // Strategy 2 always keep the selection
                if (selected == price) winCounter++;
            }}

        System.out.println("P(win)="+((double)winCounter/N));

    }

}

