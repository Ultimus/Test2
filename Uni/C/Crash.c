#include <stdio.h>

int main(){
	double i;
	for (i=0.0; i != 1; i+= 0.1){
		printf ("%f ", i );
		if (i > 2) return 0;
	}
	return 0;
}
