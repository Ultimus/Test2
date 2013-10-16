public class Ehepaar{
public static void main (String args[]){

int male = 0;
int female = 0;

for (int i =1; i<= 1000; i++){
while (male < 1 || female < 1){
	if (Math.random() < 0.5)
		male++;
	else
		female++;
}}
System.out.println ("Jungen: "+male);
System.out.println ("Mädchen: "+female);
}}

