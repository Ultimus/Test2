#include <stdlib.h>
#include <stdio.h>
 
int main( void )
{
  char const Text[] = "Hello proggen.org\n";
  unsigned int index;
 
  for( index = 0; Text[index] != '\0'; ++index )
    fputc( Text[index], stdout ); 
 
  return EXIT_SUCCESS; 
}
