public class EinsC{
 public static void main(String[] args0){

 String[] s0 = {"G", "A", "T", "C"};

 String[] ottimo = new String[100];
 

 boolean[] s = new boolean[4];

 for(int j = 0; j < 25 ; j++){

  for(int i = 0; i<4 ; i = i){
 
   int random = (int)(1.0+(Math.random()*4));
 
   if(random == 1 && !(s[0] == true)){ ottimo[j*4+i]= s0[0]; s[0]= true; i++;}

   if(random == 2 && !(s[1] == true)){ ottimo[j*4+i]= s0[1]; s[1]= true; i++;}

   if(random == 3 && !(s[2] == true)){ ottimo[j*4+i]= s0[2]; s[2]= true; i++;}
 
   if(random == 4 && !(s[3] == true)){ ottimo[j*4+i]= s0[3]; s[3]= true; i++;} 
  
  
   }//for

  for(int r = 0; r<4; r++){

   s[r]= false;

  }//For Boolean zurücksetzen 
   
 }//for aussen


 for(int g = 0; g<100; g++){

  System.out.print(ottimo[g]);
 
  
  if(((g+1)%4)==0){
   
   System.out.print("\t");

  }//if
  
  if(((g+1)%8)==0){
   
   System.out.println();

  }//if


 }//for
 
 System.out.println("");
 

 }//public static void
}//class