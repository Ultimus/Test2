#include <stdio.h>

int f (int x);
int g (int x);


int main (){

	int x;

	printf ("Bitte eine Zahl x eingeben: ");
	scanf ("%d", &x);

	printf ("Ergebniss: %d", f(x));
}

	int f (int x){
	if (x == 0) return 1;
	else return f(x-1) + g(x-1);
	}

	int g (int x){
	if (x == 0) return 1;
	else return g(x-1) * f(x-1);
	}

