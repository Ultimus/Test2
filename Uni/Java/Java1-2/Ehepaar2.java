public class Ehepaar2{
public static void main (String args[]){

int male = 0;
int female = 0;
double r;
for (int i =1; i<= 1000; i++){
	r=Math.random(); 
if (r < 0.5)
		male++;
	else 
		female++;
}

System.out.println ("Jungen: "+male);
System.out.println ("Mädchen: "+female);
}}
