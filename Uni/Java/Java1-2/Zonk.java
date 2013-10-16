public class Zonk{
    public static void main(String[] in){
        if(in.length != 2) {
            System.out.println("Usage Zonk N Strategy");
        }

        int winCounter = 0;

        int N =Integer.parseInt(in[0]);
        int strategy =Integer.parseInt(in[1]);

boolean zufall = false;

	if (strategy == 3){
	zufall = true;}

        for (int i=0; i<N; i++) {
            int price = (int)(1.0+(Math.random()*3));
            int selected = (int)(1.0+(Math.random()*3));
       
   
 
if (zufall==true)
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

