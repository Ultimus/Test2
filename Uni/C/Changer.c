#include <stdio.h>

int main(){
	int a;

	printf ("Bitte Zahl eingeben: \n");
	scanf ("%d",&a);
	int money[] = {0,0,0,0};
	while (a >0){
		if (a - 50 >=0){
			money[0]+=1;
			a-=50; continue;}
		else if (a - 10 >=0){
			money [1] +=1;
			a-=10; continue;}
		else if (a-5 >=0){
			money [2] +=1;
			a -=5; continue;}
		else { money[3] +=1;
				a -=1; continue;
				
	}
}
	printf ("%d 50 Cent Münzen: \n", money[0]);
	printf ("%d 10 Cent Münzen: \n", money[1]);
	printf ("%d 5 Cent Münzen: \n", money[2]);
	printf ("%d 1 Cent Münzen: \n", money[3]);
	return 0;
}
