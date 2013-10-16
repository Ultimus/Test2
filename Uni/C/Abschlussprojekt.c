#include <stdio.h>
#define lengthX = ;
#define lengthY =;

char convert[] (char textone[]);

int main(int args, char X[]){
	char c;
	FILE *datei;
	datei=fopen(X, "r");
	 while( (c=fgetc(datei)) != EOF){
	         putchar(c);
	   }

  return 0;
}


char convert[] (textone[]){
	char c;
	int i;
	for (i=0; c != EOF; i++){
		c = textone[i];
		if (c>= 65 && <=90){
			textone[i] += 32; 
		}
	}
}

int checklength (char[] textone){
	char c;
	int counter;
	while (c != "\0"){
		counter++;
	}
	return counter;
}

	char globalmatrix(char textX[], char textY[]){
		char matrix[lengthX][lengthY];
		return matrix;
	}