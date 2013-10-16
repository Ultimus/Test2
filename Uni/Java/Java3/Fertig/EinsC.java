public class EinsC{
 public static void main(String[] args){

 String[] s0 = {"G", "A", "T", "C"};

 String[] cent = new String[100];
 

 boolean[] s = new boolean[4];

 for(int j = 0; j < 25 ; j++){

  	for(int i = 0; i<4 ; i = i){
 
  		 int random = (int)(1.0+(Math.random()*4));
 
  			 if(random == 1 && !(s[0] == true)){ cent[j*4+i]= s0[0]; s[0]= true; i++;}

  			 if(random == 2 && !(s[1] == true)){ cent[j*4+i]= s0[1]; s[1]= true; i++;}

  			 if(random == 3 && !(s[2] == true)){ cent[j*4+i]= s0[2]; s[2]= true; i++;}
 
  			 if(random == 4 && !(s[3] == true)){ cent[j*4+i]= s0[3]; s[3]= true; i++;} 
  
  
   }

  for(int r = 0; r<4; r++){

   s[r]= false;

  } 
   
 }


 	for(int g = 0; g<100; g++)
{

  		System.out.print(cent[g]);
 
  
  		if(((g+1)%4)==0){
   
   		System.out.print("\t");
}



 		if(((g+1)%8)==0)
{
   
   		System.out.println();

}

 }
 
 System.out.println("");
 
 }
}
