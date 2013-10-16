#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int* ableitung(int *function);

int main(){
	printf ("Sie möchten also eine Kurvendiskussion durchführen.\nBitte geben sie den multiplikator des ersten Polynoms ein: ");

	int *function;
	function = malloc(3*sizeof(int)); 
	get("&d",function[0]);
	
	printf ("\n%d",function[0]); 	
	
	printf ("Ist das Polynom 2. grades?\n[y,n]\n\n");
	char input;
	cget ("&c",input);
	if (input == 'n'){
		printf("Funktionen über dem 2. Grad können nicht berechnet werden.\n");
		return EXIT_FAILURE;
	}
	
	function[1] = 2;
	printf ("Bitte zweiten Faktor eingeben: \n");
	cget ("&d",function[2]);
	
	printf ("Bitte geben sie den letzten summanden ein: \n");
	cget ("&d", function[2]); 

	ableitung(function);
	


	return 0;
	}


	int* ableitung(int *function){
		int *div = malloc (2*sizeof(int));
		div[0] = function[0] * function[1];
		div [1] = function [2];
		printf ("\nDie Ableitung: %dx %d", div[0], div[1]);
		
		return div;
	}

	double* NST (int *function){
		double *null = malloc(2*sizeof(double));
		if (function[0] != 0){
			int p = function[2]/ function[0];
			int q = function[3] / function[0];
			null[0] = ((p/2) + (sqrt((p/2)*(p/2) - q)));
			null[1] = ((p/2) - (sqrt((p/2)*(p/2) -q)));
		}
		return null;
			
	}



