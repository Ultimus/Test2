public class PerfekteZahl2 {
public static void main (String args[]){

int sum = 0;
int zahl = Integer.parseInt(args [0]);

for (int i=1; i<zahl;i++){
if (zahl%i==0){
sum+=i;
}}

if (sum==zahl){
System.out.println("Perfekte Zahl");
}else{
System.out.println("keine Perfekte Zahl");
}





}
}
