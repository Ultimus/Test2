/*
 * StillePost.c
 *
 *  Created on: 07.08.2011
 *      Author: Maximilian Arendt
 */

#include <assert.h>
#include <ctype.h>
#include <errno.h>
#include <float.h>
#include <limits.h>
#include <locale.h>
#include <math.h>
#include <setjmp.h>
#include <signal.h>
#include <stdarg.h>
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
	


int main (int argc, char *argv[]){
	FILE *data1;
	FILE *data2;
	FILE *data3;
	
	char *text_X;
	char *text_Y;
	int length_X;
	int length_Y;
	int stream_pos_X = 0; //gibt an, ab wann die datei weiter gelesen werden soll
	int stream_end_X;
	int stream_pos_Y = 0;
	int stream_end_Y;	
	int ***matrix;//lokale matrix
	char c;//zeichenvariable
	int l;//größe der lokalen matrix
	int k; //größe der lokalen matrix
	int o; //größe der globalen matrix
	int m; //größe der globalen matrix
	int n = atoi(argv[3]);	//wandelt aus dem String in int um
	int ***global_matrix;
	int i; //Zählvariable	
	int j; //Zählvariable
	int global_i;//Zählvariable für die globale Matrix
	int global_j;//Zählvariable für die globale Matrix
	long length=0;
	char *result;
	int result_counter = 0;
	int score;

	int x;
	if (argc != 5){
		printf ("Fehler bei der Parametereingabe: nicht genügend Parameter vorhanden\n");
		return EXIT_FAILURE;
	} 
	//datei 3 öffnen und prüfen ob sie existiert
	data3 = fopen(argv[4], "w");
	if (data3 == NULL){

		printf("Fehler beim schreiben der Datei!\n");
		return EXIT_FAILURE;
	}
	
	//Datei 1 einlesen
	
	i = 0;
	data1 = fopen (argv[1], "r");
	
	if (data1== NULL){
		printf ("Fehler! Datei 1 nicht gefunden!\n");
		return EXIT_FAILURE;
	}
	
	printf ("Datei 1 geöffnet.\n");
		while ((c = fgetc(data1)) != EOF){
			length++;

		}
			

					
		length_X = length-1;//-1 weil sonst aus unbekannten gründen ein Stern am Ende der Nachricht eingelesen wird
		

		if ((length_X % n) != 0){
		printf ("Fehler! Parameter n teilt länge der Datei nicht restlos! Beide Dateien müssen gleichlang sein!");
		return EXIT_FAILURE;
		}

		length =0;

		data2 =fopen(argv[2], "r");
		if (data2 == NULL){
			printf ("Fehler! Datei 2 nicht gefunden.\n");
			return EXIT_FAILURE;	
		}
		while ((c = fgetc(data2)) != EOF){
			length++;

		}
		length_Y = length-1;
				

		printf ("Datei 2 geöffnet.\n");
	//Globale Matrix initialisieren
	


	m = (length_X/n)+1; //länge der globalen matrix
	o = (length_Y/n)+1;

	

	text_X = malloc(m*sizeof(char));
	text_Y = malloc(o*sizeof(char));


	global_matrix = malloc (m *sizeof (int **));
	if (NULL == global_matrix){
		printf (" Fehler! Nicht genügend virtueller Speicher vorhanden!");
		return EXIT_FAILURE;
	}
	
	for (i=0; i < m; i++){
		global_matrix[i] = malloc (o * sizeof (int*));
		if ( NULL == global_matrix[i]){
			printf (" Fehler! Nicht genügend virtueller Speicher vorhanden!");
			return EXIT_FAILURE;
		}
	}

	
	for (i = 0; i < m; i++){
		for (j =0; j < o; j++){
			global_matrix[i][j] = malloc (2*sizeof (int));
			if (NULL == global_matrix[i][j]){
				printf (" Fehler! Nicht genügend virtueller Speicher vorhanden!");
				return EXIT_FAILURE;
			}		
		}
	}

	//lokale matrix initialisieren

	l=n+1; //länge der lokalen Matrix festlegen
	k=n+1;

	matrix = malloc (l *sizeof (int **));
	if (NULL == matrix){
		printf (" Fehler! Nicht genügend virtueller Speicher vorhanden!");
		return EXIT_FAILURE;
	}
	
	for (i=0; i < l; i++){
		matrix[i] = malloc (k * sizeof (int*));
		if ( NULL == matrix[i]){
			printf (" Fehler! Nicht genügend virtueller Speicher vorhanden!");
			return EXIT_FAILURE;
		}
	}
	
	for (i = 0; i < l; i++){
		for (j =0; j < k; j++){
			matrix[i][j] = malloc (2*sizeof (int));
			if (NULL == matrix[i][j]){
				printf (" Fehler! Nicht genügend virtueller Speicher vorhanden!");
				return EXIT_FAILURE;
			}		
		}
	}



	//globaler Algorithmus
	stream_end_X = n;
	stream_end_Y = n;
	stream_pos_X = 0;
	fseek(data1, 0,SEEK_SET);
	fseek(data2, 0,SEEK_SET);


	printf ("Algorithmus startet!\n");
	for(global_i =0; global_i < m; global_i++){
	
		//wenn global_i erhöht wird, muss text_X weiterlesen, text_Y fängt von neu an
		fseek(data1,stream_pos_X,SEEK_SET);

		if (global_i > 0){//verhindert komische zeichen			
			for(i = 0; i < stream_end_X; i++){
				c = fgetc(data1);
				if (c !=32 && c <=90){
					c += 32;
					text_X[i] = c;		
				}else{
					text_X[i] = c;					
				}
			}

		
		//Stream zeiger neu setzen
		stream_pos_X += n;
		}

		stream_pos_Y = 0;
		stream_end_Y = n;		

		for (global_j = 0; global_j < o; global_j++){
			

			if (global_j > 0){//verhindert komische zeichen
			
				//text_Y mit zeichen füttern
				fseek(data2,stream_pos_Y,SEEK_SET);
					
				for(i = 0; i <stream_end_Y; i++){
					c = fgetc(data2);
					if (c !=32 && c <=90){
						c += 32;
						text_Y[i] = c;
						
					}else{
						text_Y[i] = c;					
					}
				}	

			//Stream zeiger neu setzen
			stream_pos_Y += n;
			} 
						
		//Bedingungen der globalen Matrix
		if (global_i == 0 && global_j == 0){
			global_matrix[global_i][global_j][0] = 0;
			global_matrix[global_i][global_j][1] = 0;
			
		}else{ //verhindert Speicherzugriffsfehler	
				
				if (global_i != 0 && global_j ==0){
					global_matrix[global_i][global_j][0] = 0;
					global_matrix[global_i][global_j][1] =	1;
					
				

				}else if (global_i ==0 && global_j !=0){
						global_matrix[global_i][global_j][0] = 0;
						global_matrix[global_i][global_j][1] =	3; 
					
				

				}else if (global_i != 0 && global_j != 0){
							//lokales Ergebniss wird erst benötigt, wenn ein diagonaler Pfeil berechnet wird.
							for (i= 0; i < l; i++){
								for (j=0; j< k; j++){
								//printf ("TextX: ");
								for (x = 0; x< n; x++){
									//printf ("%c", text_X[x]);
								}
								//printf ("TextY: "); 
								for (x = 0; x< n; x++){
									//printf ("%c", text_Y[x]);
								}
								/* Matrix [x][y][0] enthält den Score Matrix[x][y][1] enthält den Richtunsgvektor
								 * 0= leere Menge (Backtracking hört auf
							 	* 1= Pfeil nach oben
							 	* 2 = Pfeil nach links oben (Score erhöhen und Buchstaben merken)
							 	* 3 = Pfeil nach links
							 	*/
	
								// falls(i=0)∧(j=0)
								if (i == 0 && j == 0){
									matrix [i][j][0] = 0;
									matrix [i][j][1] = 0;
								}
				
								//falls (i = 0) ∧ (j != 0)
								else if (i == 0 && j != 0){
									matrix [i][j][0] = 0;
									matrix [i][j][1] = 3;
				
								}
				
								//falls (i != 0) ∧ (j = 0)
								else if (i != 0 && j == 0){
									matrix [i][j][0] = 0;
									matrix [i][j][1] = 1;
								}
					

								else if(i != 0 && j != 0){	//verhindert Speicherzugriffsfehler		

									//falls (xi = yj ) ∧ (i != 0) ∧ (j != 0)
									if ((text_X[i-1] == text_Y[j-1]) && (i!=0 && j!=0) ){
										matrix[i][j][0] = matrix[i-1][j-1][0]+1;
										matrix [i][j][1] = 2;									
									
									}
				
									//falls (xi != yj ) ∧ (b[i − 1][j] ≥ b[i][j − 1]) ∧ (i != 0) ∧ (j != 0)
									else if (text_X[i-1] != text_Y[j-1] && matrix[i-1][j][0] >= matrix [i][j-1][0] && i!=0 && j!=0){
						

										matrix[i][j][0] = matrix [i-1][j][0];
										matrix[i][j][1] = 1;
									}
				
				
									//falls (xi != yj ) ∧ (b[i − 1][j] !>= b[i][j − 1]) ∧ (i != 0) ∧ (j != 0)
									else if (text_X[i-1] != text_Y[j-1] && (matrix[i-1][j][0] < matrix[i][j-1][0]) && (i!=0) && (j != 0)){
						

										matrix [i][j][0] = matrix [i][j-1][0];
										matrix[i][j][1] = 3;
									}
								}
							}
						}
					
					
					score = matrix[l-1][k-1][0];
					/*for (i =0; i < l; i++){
						for (j =0; j< k; j++){
				
							printf ("%d   ", matrix[i][j][1]);
						}
						printf ("\n");
					}
					printf ("\n");
					*/
						
						global_matrix[global_i][global_j][0] = calcS(global_matrix[global_i-1][global_j][0], global_matrix[global_i][global_j-1][0], score+ global_matrix[global_i-1][global_j-1][0]);			
						global_matrix[global_i][global_j][1] = calcP(global_matrix[global_i-1][global_j][0], global_matrix[global_i][global_j-1][0], score + global_matrix[global_i-1][global_j-1][0]);
					// Matrix zurücksetzen, falls beim nächsten Schleifendurchlauf ein neues Ergebnis benötigt wird
					for (i =0; i< l; i++){
						for (j = 0; j < k; j++){
							matrix[i][j][0] =0;
							matrix [i][j][1] =0;
						}
					}
	
			}	}
		}
		
	}

	//die globale matrix ist nun berechnet, es folgt das backtracking um die Lösung zu ermitteln
	

	printf ("\nScore der globalen Matrix:\n\n");

	for (i =0; i < l; i++){
		for (j =0; j< k; j++){
				
			printf ("%d   ", global_matrix[i][j][0]);
		}
		printf ("\n");
	}
	printf ("\n");

	printf ("Die Richtungsvektoren der globalen Matrix: \n\n0: ende\t1: Pfeil oben\t2: Pfeil diagonal\t3: Pfeil links\n\n");

	for (i =0; i < l; i++){
		for (j =0; j< k; j++){
				
			printf ("%d   ", global_matrix[i][j][1]);
		}
		printf ("\n");
	}
	printf ("\n");

	//globales backtracking
	
	//speicher reservieren für ergebnisstring
	result = malloc (global_matrix[l-1][k-1][0]*sizeof(char));
	

	global_i = m-1;
	global_j = o-1;

	//printf ("global_i: %d\n", global_i);

	while (global_i != 0 && global_j != 0){
			/*for (x =0; x < n; x++){
					printf ("%c", text_X[x]);
				}
			
			printf ("ende: %d\n", global_matrix[global_i][global_j][1]);
			printf ("global_i: %d\n", global_i);
			printf ("global_j: %d\n\n", global_j);
			*/

			if (global_matrix[global_i][global_j][1] == 1){//y koordinate anpassen				
				global_i--;
			}else if (global_matrix[global_i][global_j][1] == 3){//x koordinate anpassen
				global_j--;

			}else if(global_matrix[global_i][global_j][1] == 2){
							
				//passendes textstück einlesen
				stream_pos_X = ((global_i-1) * n);
				stream_pos_Y = ((global_j-1) *n);

				
				fseek (data1, stream_pos_X, SEEK_SET); 				
				for (i = 0; i < stream_end_X; i++){
					c = fgetc(data1);
					if (c!=32 && c <= 90){
						c += 32;
						text_X[i] = c;
						
					}else{
						text_X[i] = c;
						
					}
				}

				fseek(data2,stream_pos_Y,SEEK_SET);
					
				for(i = 0; i <stream_end_Y; i++){
					c = fgetc(data2);
					if (c !=32 && c <=90){
						c += 32;
						text_Y[i] = c;						
					}else{
						text_Y[i] = c;					
					}
				}

				global_i--;
				global_j--;

			
				for (i= 0; i < l; i++){
					for (j=0; j< k; j++){
			
						/* Matrix [x][y][0] enthält den Score Matrix[x][y][1] enthält den Richtunsgvektor
						* 0= leere Menge (Backtracking hört auf
						* 1= Pfeil nach oben
						* 2 = Pfeil nach links oben (Score erhöhen und Buchstaben merken)
						* 3 = Pfeil nach links
						*/
	
						// falls(i=0)∧(j=0)
						if (i == 0 && j == 0){
							matrix [i][j][0] = 0;
								matrix [i][j][1] = 0;
						}
				
						//falls (i = 0) ∧ (j != 0)
						if (i == 0 && j != 0){
							matrix [i][j][0] = 0;
							matrix [i][j][1] = 3;
						}
				
						//falls (i != 0) ∧ (j = 0)
						if (i != 0 && j == 0){
							matrix [i][j][0] = 0;
							matrix [i][j][1] = 1;
						}
					

						if(i != 0 && j != 0){	//verhindert Speicherzugriffsfehler		

							//falls (xi = yj ) ∧ (i != 0) ∧ (j != 0)
							if ((text_X[i-1] == text_Y[j-1]) && (i!=0 && j!=0) ){
								matrix[i][j][0] = matrix[i-1][j-1][0]+1;
								matrix [i][j][1] = 2;
								
							}
				
							//falls (xi != yj ) ∧ (b[i − 1][j] ≥ b[i][j − 1]) ∧ (i != 0) ∧ (j != 0)
							if (text_X[i-1] != text_Y[j-1] && matrix[i-1][j][0] >= matrix [i][j-1][0] && i!=0 && j!=0){
								matrix[i][j][0] = matrix [i-1][j][0];
								matrix[i][j][1] = 1;
							}
				
				
							//falls (xi != yj ) ∧ (b[i − 1][j] !>= b[i][j − 1]) ∧ (i != 0) ∧ (j != 0)
							if (text_X[i-1] != text_Y[j-1] && (matrix[i-1][j][0] < matrix[i][j-1][0]) && (i!=0) && (j != 0)){
								matrix [i][j][0] = matrix [i][j-1][0];
								matrix[i][j][1] = 3;
							}
						}
					}
				}
				
				//lokales backtracking
				i = l-1;
				j = k-1;
				
				while (i != 0 && j!= 0){ 
					if (matrix[i][j][1] == 1){//y koordinate anpassen				
						i--;
					}else if( matrix[i][j][1] == 3){
						j--; //x koordinate anpassen
					}else if(matrix[i][j][1] == 2){
						result[result_counter] = text_X[i-1];
						result_counter++;
						i--;
						j--;
						
						
					}
				}

					// Matrix zurücksetzen, falls beim nächsten Schleifendurchlauf ein neues Ergebnis benötigt wird
				for (i =0; i< l; i++){
					for (j = 0; j < k; j++){
						matrix[i][j][0] =0;
						matrix [i][j][1] =0;
					}
				}
				
			}
			
	}
	//ergebniss in datei schreiben
	
	printf ("Ergebnisstring: \n");
	for(i = result_counter; i >= 0; i--){
		fputc(result[i], data3);	
		printf ("%c", result[i]);
	}
	
	printf ("\nAnzahl der globalen Übereinstimmungen: %d\n", global_matrix[m-1][o-1][0]);
	


	//speicher wieder in umgekehrter Reihenfolge freigeben

	free (result);

	for ( i = 0; i < l; i++) {
		for( k = 0; j < k; k++){
			free(matrix[i][j]);
		}
		free(matrix[i]);
	}
	free(matrix);

	for (i =0; i < m; i++){
		for (j=0; j < o; j++){
			free (global_matrix[i][j]);
		}
		free (global_matrix[i]);
	}
	free (global_matrix);

	free (text_Y);
	free (text_X);
	

	fclose(data1);
	fclose(data2);
	fclose (data3);

	return EXIT_SUCCESS;
}



	int calcS(int second, int third, int first){//maxscore nach präferenz bestimmen
		if (second > first) return second;
		if (third > first) return third;
		return first; 
	}

	int calcP(int top, int left, int dia){// zur erinerrung 1= hoch, 2 = diagonal, 3 = links
			if (top > dia) return 1;
			else if (left > dia && left > top) return 3;
			else return 2;
	}
		

