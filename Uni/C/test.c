#include <stdio.h>
#include <string.h>
int main(){

	int xn1 = 0;

	char *s1;// = "Max ist ";
	char *s2;// = "ein Gott";

	char *s3;
	strcpy(s1,"MAx ist");
	
	int counter;
	char act;
	
	for (counter = 0; act != '\0'; counter++){
		act = s1[counter];
	}
	printf ("hi");

	int temp = counter;
	for (counter= 0; act != '\0'; counter++){
		act = s2[counter];

	}
	printf ("chicken");
	int _c = counter;
	counter+=temp;
	int i = 0;
	while (counter >0){
		s3[i] = ' ';
		i++;
	}

	printf ("Wodka");

	while (temp >0){
		s3[i] = s1[i];
	}	
	int j = 0;
	printf ("$");
	for (j = 0; _c >0; j++){
		s3[i+j]= s2[j];
		_c--;
	}

	i = 0;
	while (act != '\0'){
		act = s3[i]; 
		printf("%c", act); 
		i++;
	}
}
