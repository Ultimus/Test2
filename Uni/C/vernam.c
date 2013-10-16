#include<stdio.h>


int main(int argc, char** argv){

	unsigned char text[10000];
	char c;
	int index = 0;
	unsigned int histogramm[256];
	while(scanf ("%c",&c)!= EOF){
		text[index] = c;
		printf ("%c", c);
		histogramm[c]++;
		index++;
	}
	int last= index;
	for (index =0; index < 256; index++){
		printf ("%d : %d\n",index, histogramm[index]);
	}
		
	int key = 'e'^42;
	printf ("Key: %d\n", key);
	for (index =0; index <last; index++){
		text[index] = (text[index]^key);
		printf ("%c",text[index]);

	}

return 0;
}
	
	
