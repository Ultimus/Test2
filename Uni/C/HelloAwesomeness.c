#include <stdio.h>
#define LENGTH 19

int main(){
int i;
char max[] ={'M', 'a', 'x', 'i', 'm', 'i', 'l', 'i', 'a', 'n',' ',  'A', 'r', 'e', 'n', 'd', 't','\0' };
/*String mirko = "Mirko Oleszuk";
String buddy = "Bastian Hustaedte";
*/

	for (i=0; i < LENGTH; i++){
		printf ("%c",max[i]);
	}
	printf ("\n");
}
