#include <stdio.h>

int main(){
	int counter, feins, fzwei;
	int i = 0;
	fzwei = 1;
	feins = 0;
	printf ("Bitte Zahl eingeben: ");
	scanf ("%d", &counter);
 
	int result;
	for (i=1; i< counter; i++){
		result = feins + fzwei;
		feins = fzwei;
		fzwei = result;
	}
	printf ("Die %dte Fibonacci Zahl ist: %d", counter, result);
}


