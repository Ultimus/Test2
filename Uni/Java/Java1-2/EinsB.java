public class EinsB{
 public static void main(String[] args0){

 String[] s0 = {"G", "A", "T", "C"};
 

 boolean[] s = new boolean[4];

 for(int i = 0; i<4 ; i = i){
 
 int random = (int)(1.0+(Math.random()*4));
 
 if(random == 1 && !(s[0] == true)){ System.out.print(s0[0]); s[0]= true; i++;}

 if(random == 2 && !(s[1] == true)){ System.out.print(s0[1]); s[1]= true; i++;}

 if(random == 3 && !(s[2] == true)){ System.out.print(s0[2]); s[2]= true; i++;}
 
 if(random == 4 && !(s[3] == true)){ System.out.print(s0[3]); s[3]= true; i++;} 
  
 
 }//for
 
 System.out.println();




 }//public static void
}//class