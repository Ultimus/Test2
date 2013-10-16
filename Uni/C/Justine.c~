#include <stdio.h>
#include <stdlib.h>

void code(){
	char c;
	int rng = rand()%126+33; // 33 -126
	int i;
	char *code= malloc (sizeof(char)*10);


	for (i = 0; i< 10; ){
		rng = (int)rand()%93+33;
		printf ("RNG: %d\n",rng);
		if (rng > 32 && rng < 127){
			code[i] = rng;
			if (code[i]>32 && code[i]<127){
				i++;
				printf ("%c und in Zahlen %d\n", code[i], code[i]);
			}		
				
		}
	}
}
void decode(){
	
}	
	



int main(){

	char c;

	printf ("Was möchsten sie tun? :\n 1: codieren\n2:code ausgeben\n");
	scanf ("%c",&c);
	if (c == '1') code();
	else if (c== '2') decode();
	else return 0;

return 0;


}


	
	
