#include <stdio.h>


text_X = malloc(length_X*sizeof(char));
		i=0;
		fseek(data1,0,0);
					
		for(i = 0; i <length_X; i++){
			c = fgetc(data1);
			if (c !=32 && c <=90){
				c += 32;
				text_X[i] = c;
						
			}else{
				text_X[i] = c;					
			}
		}
	}else {
			printf ("Datei nicht gefunden");
			return EXIT_FAILURE;
	}
		
	fclose(data1);
	


	//Datei 2 einlesen
	data2 = fopen (argv[2], "r");
			
		if (data2 != NULL){

			i=0;
			while ((c = fgetc(data2)) != EOF){
				i++;
				
			}
					
							
			length_Y = i-1;
			text_Y = malloc(length_Y*sizeof(char));
			i=0;
			fseek(data2,0,0);
						
			while ((c= fgetc(data2))!= EOF){
				if (c !=32 && c <=90){
					c += 32;
					text_Y[i] = c;				
				}else{
					text_Y[i] = c;					
				}
				i++;
			}
				
		}else {
			printf ("Datei nicht gefunden");
			return EXIT_FAILURE;
		}
				
	fclose(data2);
