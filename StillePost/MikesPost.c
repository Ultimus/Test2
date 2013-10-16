/*
 *  StillePost.c
 *  Abschluss
 *
 *  Created by Michael Birkhoff on 7/26/11.
 *  Copyright 2011 __MaximusPerversus__. All rights reserved.
 *
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

int main(int argc,char *parameter[]){
	
	
	FILE *datei1;
	FILE *datei2;
	FILE *ausgabeDatei;
	
	char *txt1;
	char *txt2;
	
	char *ausgabe1;
	char *ausgabe2;
	char *ausgabeLines;
	char *ausgabeEqual;
	
	int x = 0;				// Zaehlvariable fuer die AusgabeDatei
	
	
	int zaehler1 = 0;
	int zaehler2 = 0;
	int laenge1 = 0;
	int laenge2 = 0;
	int c = 0;
	
	int gi = 0;		// globale gi fuer die aeusseren for schleifen
	int gk = 0;		// globale gk
	
	int i = 0;
	int k = 0;
	
	int m = 0;		// Matrix Spalte 
	int n = 0;		// Matrix Zeile
	
	int q = atoi(parameter[3]);
	printf("%d",q);
	
	int gm = 0;		// Globale Matrix Spalte
	int go = 0;		// Globale Matrix Zeile
	
	int bi = 0;		// backtrack i und k
	int bk = 0;		// weitere Variablen zum zaehlen von verschachtelten For Schleifen
	
	
	/* Matrix ist Zeiger auf int-Zeiger. */
	int *** matrix;			// lokale Matrix
	
	int *** g;				// globale Matrix
	
	char *** lokalErgebnis;	// Matrix an Chars fuer das globale Ergebnis;
	

	
	if(argc < 5){
		
		printf("Error");
		printf("\n");
		return EXIT_SUCCESS;
	}
	
	datei1 =fopen(parameter[1],"r");
	printf("\n");
	
    if (datei1 ==NULL)
    {  
        printf("Error: can't open file.\n");
    }
    else
    {
		printf("File opend successfully:\n");
		
		
		while( (c=fgetc(datei1)) != EOF) {
			laenge1++; 
		}
		txt1 = malloc(sizeof(char) * laenge1);
		if (txt1 == NULL)
			printf("Error: Not enough space available.");
		
		fseek(datei1, 0, 0);
		
		while( (c=fgetc(datei1)) != EOF) {
			
			if((c!= 32) && (c < 97)){
			
				c = c+32;
			}
				txt1[zaehler1] = c;
				zaehler1 ++;
		}
		zaehler1 = 0;
		
		
		
		
		while (zaehler1< laenge1) {
			printf("%c", txt1[zaehler1]);
			zaehler1 ++;
		}
		
		zaehler1 = 0;
		
		printf("\n\n");
		
	}//Open and Read File1
	
	
	datei2 = fopen(parameter[2],"r");
    if (datei2 == NULL)
    {  
        printf("Error: can't open file.\n");
    }
    else
    {
		printf("File opend successfully:\n");
		
		
		
		while( (c = fgetc(datei2)) != EOF) {
			laenge2++; 
		}
		
		txt2 = malloc(sizeof(char) * laenge2);
		if (txt2 == NULL)
			printf("Error: Not enough space available.");
		
		fseek(datei2, 0, 0);
		
		while( (c=fgetc(datei2)) != EOF) {
			
			if((c!= 32) && (c < 97)){
				
				c = c+32;
			}
			txt2[zaehler2] = c;
			zaehler2 ++;
		}
		zaehler2 = 0;
		
		
		
		while (zaehler2< laenge2) {
			printf("%c", txt2[zaehler2]);
			zaehler2 ++;
		}
		
		printf("\n\n");
		
		
	}//open and read file2
	
	
	

	
	if( (ausgabeDatei = fopen(parameter[4], "w+") ) == NULL){
		
		printf("Error occured on writing OUTPUT Data\n");
		
	}
	
	
	// fputc(azsgabeChar[], ausgabeDatei);		in for schleife nur char weise
	
	
	////////////////////////////					Globale Matrix erstellen					///////////////////////////////////////////////
	
	
	
	gm = laenge1/q+1;
	go = laenge2/q+1;
	

	g = malloc( (gm) * sizeof(int **));
	if(NULL == g) {
		printf("No virtual RAM left ... !");
		return EXIT_FAILURE;
	}
	/* jetzt noch Speicher reservieren für die einzelnen Spalten
	 * der i-ten Zeile */
	for(i = 0; i < gm; i++) {
		g[i] = malloc( (go) * sizeof(int*));
		if(NULL == g[i]) {
            printf("No Space for line %d\n",i);
            return EXIT_FAILURE;
		}
	}
	
	/*Speicher reservieren für die das Tupel*/
	
	for( i = 0; i < gm; i++){
		for (k = 0; k < go; k++) {
			
			g[i][k] = malloc(2 * sizeof(int));
			if(NULL == g[i][k]) {
				printf("No Space for  [%d][%d] \n",i, k);
				return EXIT_FAILURE;
			}
		}		
	}
	
	
	
	
	
	
	
	///////////////////////////				Matrix fuer die lokalen Ergebnisse erstellen		///////////////////////////////////////////////
	
	
	
	lokalErgebnis = malloc( (gm) * sizeof(char **));
	if(NULL == lokalErgebnis) {
		printf("No virtual RAM left ... !");
		return EXIT_FAILURE;
	}
	/* jetzt noch Speicher reservieren für die einzelnen Spalten
	 * der i-ten Zeile */
	for(i = 0; i < gm; i++) {
		lokalErgebnis[i] = malloc( (go) * sizeof(char *));
		if(NULL == lokalErgebnis[i]) {
            printf("No Space for line %d\n",i);
            return EXIT_FAILURE;
		}
		

		
		for (k = 0; k < go; k++) {
			lokalErgebnis[i][k] = malloc( q * sizeof(char));
			if(NULL == lokalErgebnis[i][k]) {
				printf("No Space for  [%d][%d] \n",gi, gk);
				return EXIT_FAILURE;
			}		
		}
	}
	


	for(i = 0; i < gm; i++){
		for(k = 0; k < go; k++){
			for(bi = 0; bi < q; bi ++){
				lokalErgebnis[i][k][bi] = '?';
			}
	
		}
	}
	
	////////////////////////					Lokale Matrix fuer Algorythmus Erzeugen															///////////////////////
	
	m = q+1;		// Setze Spaltenanzahl Laenge des ersten Textes + 1		// changed to q
	n = q+1;		// Setze Spaltenanzahl Laenge des zweiten Textes + 1				
	
	
	
	/* Speicher reservieren für die int-Zeiger (=laenge1) */
	matrix = malloc( (m) * sizeof(int **));
	if(NULL == matrix) {
		printf("No virtual RAM left ... !");
		return EXIT_FAILURE;
	}
	/* jetzt noch Speicher reservieren für die einzelnen Spalten
	 * der i-ten Zeile */
	for(i = 0; i < m; i++) {
		matrix[i] = malloc( (n) * sizeof(int*));
		if(NULL == matrix[i]) {
			printf("No Space for line %d\n",i);
			return EXIT_FAILURE;
		}
	}
	
	/*Speicher reservieren für die das Tupel*/
	
	for( i = 0; i < m; i++){
		for (k = 0; k < n; k++) {
			
			matrix[i][k] = malloc(2 * sizeof(int));
			if(NULL == matrix[i][k]) {
				printf("No Space for  [%d][%d] \n",i, k);
				return EXIT_FAILURE;
			}
		}		
	}
	
	
	
	
	for (gi = 0; gi < gm; gi++) {
				
		for(gk = 0; gk < go; gk++ ){
			
			
			
			

			
			
		//////////////////////////////		Lokale Matrix erstellen  und auswerten		////////////////////////////////////////////////////

			

			///			Bedingungen							///
			/*
			 *		0 = Null Element
			 *		1 = Pfeil nach links
			 *		2 = schraeger Pfeil nach links/oben
			 *		3 = Pfeil nach oben
			 *
			 */
			
			int ausgabeLaenge = 0;
			
			ausgabeLaenge = 0;
			
			if(gi != 0 && gk != 0){
				
		
				for (i = 0; i < m; i++) {
					for ( k = 0; k < n; k++) {
						
						if ( (i == 0) && (k == 0) ) {
							matrix[i][k][0] = 0;
							matrix[i][k][1] = 0;
						}	// falls(i=0)∧(j=0)
						
						if ( (i == 0)  && (k != 0) ) {
							
							matrix[i][k][0] = 0;
							matrix[i][k][1] = 1;
						}	// falls(i=0)∧(j̸=0)
						
						if ( (i != 0) && (k == 0) ) {
							matrix[i][k][0] = 0;
							matrix[i][k][1] = 3;
						}	// falls(i̸=0)∧(j=0)
						
						if ( (i != 0) && (k != 0) ) {
							if( txt1[ ( (gi-1)*q )+i-1] == txt2[ ( (gk-1)*q )+k-1] ){			// i -1 und k -1 da String erst ab MatrixPosition 1 gezaehlt wird
																								//  (Siehe Abschlussprojekt.pdf)
								matrix[i][k][0] = matrix[i-1][k-1][0]+1;						// (b[i−1][j−1]+1,↖)
								matrix[i][k][1] = 2;
							}// falls(xi =yj)
							
							
							if ( (txt1[( (gi-1) * q ) +i-1]!= txt2[ ( (gk-1) * q )+k-1]) && (matrix[i-1][k][0] >= matrix[i][k-1][0]) ) {
								
								matrix[i][k][0] = matrix[i-1][k][0];				// (b[i − 1][j], ↑)
								matrix[i][k][1] = 3;
								
							} // falls(x ̸=y)∧(b[i−1][j]≥b[i][j−1])
							
							if ( (txt1[( (gi-1) * q )+i-1] != txt2[( (gk-1) * q )+k-1]) && (matrix[i-1][k][0] < matrix[i][k-1][0]) ) {
								
								matrix[i][k][0] = matrix[i][k-1][0];				// (b[i][j − 1], ←)
								matrix[i][k][1] = 1;
									
							} // falls(xi ̸=yj)∧(b[i−1][j]<b[i][j−1])
							
							
						} //	∧(i≠ 0)∧(j≠ 0)
						
						
							
						
					}//for innen
				}//for aussen
				
			
			
				i = m-1;
				k = n-1;

				int backtrackZaehler = 1;						// Zaehlt an welcher Stelle der aktuelle Buchstabe kommt bsp char[Konstante - backtrackzaehler]
				char ausgabeChar[ausgabeLaenge+1];
				
				ausgabeLaenge = matrix[i][k][0];		

				i = m-1;
				k = n-1;
				
				while ((i != 0) && (k != 0)) {
					
					if (matrix[i][k][1] == 2) {
						ausgabeChar[ausgabeLaenge-backtrackZaehler] = txt1[((gi-1)*q)+i-1];			// i-1 da char Array
						backtrackZaehler++;
						i--;
						k--;
					}
					if (matrix[i][k][1] == 3) i--;
					if (matrix[i][k][1] == 1) k--;
					
				}
			
			
				if(ausgabeLaenge > 0){	
					
					for (i = 0;  i < ausgabeLaenge+1; i++) {
						lokalErgebnis[gi][gk][i] = ausgabeChar[i]; 

					}
				}
			
			}// if gi und gk != 0 bei lokaler Matrix
			
			
			////////////////				IF Bedingungen Globale Matrix G					/////////////////////////////////////////////
			
		
			if(gi == 0 && gk == 0){			//	(i=0)∧(j=0)
				
				g[gi][gk][0] = 0;
				g[gi][gk][1] = 0;			 // (0,∅)
								
			}else{
			
				if (gi != 0 && gk == 0) {		//	(i≠ 0)∧(j=0)
				
					g[gi][gk][0] = 0;
					g[gi][gk][1] = 3;			// (0,↑)
				
				}else{
			
			
						if (gi == 0 && gk != 0) {		//	(i=0)∧(j̸=0)
				
								g[gi][gk][0] = 0;
								g[gi][gk][1] = 1;		//	(0,←)
				
						}else{							
			
							
							g[gi][gk][0] = maxScore( g[gi-1][gk][0], g[gi][gk-1][0], ausgabeLaenge + g[gi-1][gk-1][0] );//ausgabelänge = lokaler maximalscore
							g[gi][gk][1] = maxDirection( g[gi-1][gk][0], g[gi][gk-1][0], ausgabeLaenge + g[gi-1][gk-1][0] );	
							
							//printf("Max Directions (Zeile %d, Spalte: %d): %d, %d, %d \n", gi, gk, g[gi-1][gk][0], g[gi][gk-1][0], ausgabeLaenge + g[gi-1][gk-1][0] );
							
						
						}//else
				}//else
			}//else
			
			
		}	//for global gk	
		
		
	}		//for global gi
	
	
	
	
	
	//////////////////////////////	ENDE:	Globale Matrix erstellen  und auswerten		////////////////////////////////////////////////////
	

	
	
	int globalBacktrackZaehler = 1;						// Zaehlt an welcher Stelle der aktuelle Buchstabe kommt bsp char[Konstante - backtrackzaehler]
	int globalScore = g[gm-1][go-1][0];
	char globalAusgabe[globalScore];
	
	
	
	
	
	
	if(laenge1 > laenge2){
		
		x = (laenge1 - globalScore)+ laenge1;
		
		ausgabe1 = malloc( x * sizeof(char ) );
		ausgabe2 = malloc( x * sizeof(char ) );
		ausgabeLines = malloc( x * sizeof(char ));
		ausgabeEqual = malloc( x * sizeof(char ));
		
	}else {
		
		x = (laenge2 - globalScore)+ laenge2;
		
		ausgabe1 = malloc( x * sizeof(char));
		ausgabe2 = malloc( x * sizeof(char));
		ausgabeLines = malloc( x * sizeof(char));
		ausgabeEqual = malloc( x * sizeof(char ));
		
	}
	
	int xbacktrack = 1;		// Zaehler fuer die grandiose Textformatausgabe
	for (i = 0; i < x; i++) {
		ausgabe1[i] = '?';
		ausgabe2[i] = '?';
	}
	
	////////////////////////////////				Globales Backtracking							/////////////////////////////////////////
	
	
	
	
	
	gi = gm-1;
	gk = go-1;
	
	while ((gi != 0) && (gk != 0)) {
	
		//printf("gi = %d , gk = %d\n", gi, gk);
		
		if( g[gi][gk][1] == 2){
		
			for(bi = q-1; bi >= 0; bi--){
			
				if( ( lokalErgebnis[gi][gk][bi] > 96 && lokalErgebnis[gi][gk][bi] < 123 ) || lokalErgebnis[gi][gk][bi] == 32 ){
					
					bk = globalScore-globalBacktrackZaehler;
					
					//printf("\nGlobalScore: %d\n bi: %d \n", bk, bi);
					//printf("%c",lokalErgebnis[gi][gk][bi]);
					globalAusgabe[globalScore-globalBacktrackZaehler] = lokalErgebnis[gi][gk][bi];			// i-1 da char Array
					globalBacktrackZaehler++;
				
				}
			}
			
			
			///////
			
			
			
			
			
			for (i = 0; i < m; i++) {
				for ( k = 0; k < n; k++) {
					
					if ( (i == 0) && (k == 0) ) {
						matrix[i][k][0] = 0;
						matrix[i][k][1] = 0;
					}	// falls(i=0)∧(j=0)
					
					if ( (i == 0)  && (k != 0) ) {
						
						matrix[i][k][0] = 0;
						matrix[i][k][1] = 1;
					}	// falls(i=0)∧(j̸=0)
					
					if ( (i != 0) && (k == 0) ) {
						matrix[i][k][0] = 0;
						matrix[i][k][1] = 3;
					}	// falls(i̸=0)∧(j=0)
					
					if ( (i != 0) && (k != 0) ) {
						if( txt1[ ( (gi-1)*q )+i-1] == txt2[ ( (gk-1)*q )+k-1] ){			// i -1 und k -1 da String erst ab MatrixPosition 1 gezaehlt wird
							//  (Siehe Abschlussprojekt.pdf)
							matrix[i][k][0] = matrix[i-1][k-1][0]+1;						// (b[i−1][j−1]+1,↖)
							matrix[i][k][1] = 2;
						}// falls(xi =yj)
						
						
						if ( (txt1[( (gi-1) * q ) +i-1]!= txt2[ ( (gk-1) * q )+k-1]) && (matrix[i-1][k][0] >= matrix[i][k-1][0]) ) {
							
							matrix[i][k][0] = matrix[i-1][k][0];				// (b[i − 1][j], ↑)
							matrix[i][k][1] = 3;
							
						} // falls(x ̸=y)∧(b[i−1][j]≥b[i][j−1])
						
						if ( (txt1[( (gi-1) * q )+i-1] != txt2[( (gk-1) * q )+k-1]) && (matrix[i-1][k][0] < matrix[i][k-1][0]) ) {
							
							matrix[i][k][0] = matrix[i][k-1][0];				// (b[i][j − 1], ←)
							matrix[i][k][1] = 1;
							
						} // falls(xi ̸=yj)∧(b[i−1][j]<b[i][j−1])
						
						
					} //	∧(i≠ 0)∧(j≠ 0)
					
					
					
					
				}//for innen
			}//for aussen
			
			
			
			i = m-1;
			k = n-1;
			
			
			
			
			i = m-1;
			k = n-1;
			
			while (i > 0 || k > 0) {
				
				if (matrix[i][k][1] == 2) {
					
					ausgabe1[x-xbacktrack] = txt1[((gi-1)*q)+i-1];			// i-1 da char Array
					ausgabe2[x-xbacktrack] = txt2[((gk-1)*q)+k-1];
					ausgabeLines[x-xbacktrack] = '|'; 
					ausgabeEqual[x-xbacktrack] = txt1[((gi-1)*q)+i-1];
					
					xbacktrack++;
					i--;
					k--;
				}
				if (matrix[i][k][1] == 3){
					
					ausgabe1[x-xbacktrack] = txt1[ ( (gi-1) * q) + i-1 ];
					ausgabe2[x-xbacktrack] = '_';
					ausgabeLines[x-xbacktrack] = ' '; 
					ausgabeEqual[x-xbacktrack] = ' ';
					
					xbacktrack++;
					

					i--;
				}
				if (matrix[i][k][1] == 1){
					
					ausgabe1[x-xbacktrack] = '_';
					ausgabe2[x-xbacktrack] = txt2[ ( (gk-1) * q) + k-1 ];
					ausgabeLines[x-xbacktrack] = ' '; 
					ausgabeEqual[x-xbacktrack] = ' ';
					
					xbacktrack ++;
					
					
					k--;
				}
			}
			
			
			
			
			
			
			
			//////

			gi--;
			gk--;
		}else{
		
			if (g[gi][gk][1] == 3){
				
				
				for (bi = 0; bi < q ; bi++) {
					
					//printf("%c", txt1[ (gi * q ) - bi -1 ]);
					ausgabe1[x-xbacktrack] = txt1[ (gi * q) - bi-1 ];
					ausgabe2[x-xbacktrack] = '_';
					ausgabeLines[x-xbacktrack] = ' '; 	
					ausgabeEqual[x-xbacktrack] = ' ';
					
					xbacktrack++;
				}
			
				gi--;
				
			}else{
			
				if (g[gi][gk][1] == 1){
									
					
					
					for (bi = 0; bi < q ; bi++) {
						//printf("%c", txt2[ ((gk) * q )-bi-1 ]);
						ausgabe2[x-xbacktrack] = txt2[ ( gk * q ) - bi-1 ];
						ausgabe1[x-xbacktrack] = '_';
						ausgabeLines[x-xbacktrack] = ' '; 	
						ausgabeEqual[x-xbacktrack] = ' ';
						
						xbacktrack++;
					}
					
					gk--;
				
				}
			}
		}
	}
	
	
	printf("\nAusgabeTXT1: ");
	for(i = 0; i < x ; i++) printf("%c", ausgabe1[i]);
	printf("\n");
	
	printf("\nAusgabeLINE: ");
	for(i = 0; i < x ; i++) printf("%c", ausgabeLines[i]);
	printf("\n");

	printf("\nAusgabeTXT2: ");
	for(i = 0; i < x ; i++) printf("%c", ausgabe2[i]);
	printf("\n");
	
	
	
	
	for(i = 0; i < x ; i++)	fputc(ausgabe1[i], ausgabeDatei);
	fputc('\n', ausgabeDatei);
	fputc('\n', ausgabeDatei);
	for(i = 0; i < x ; i++)	fputc(ausgabeLines[i], ausgabeDatei);
	fputc('\n', ausgabeDatei);
	fputc('\n', ausgabeDatei);
	for(i = 0; i < x ; i++)	fputc(ausgabe2[i], ausgabeDatei);
	fputc('\n', ausgabeDatei);
	fputc('\n', ausgabeDatei);
	for(i = 0; i < x ; i++)	fputc('-', ausgabeDatei);
	fputc('\n', ausgabeDatei);
	fputc('\n', ausgabeDatei);
	for(i = 0; i < x ; i++)	fputc(ausgabeEqual[i], ausgabeDatei);
	fputc('\n', ausgabeDatei);
	fputc('\n', ausgabeDatei);
	
	
	fputc('=', ausgabeDatei);
	fputc('>', ausgabeDatei);
	fputc(' ', ausgabeDatei);
	
	for(i = 0; i < globalScore ; i++)	fputc(globalAusgabe[i], ausgabeDatei);
	
	
	
	zaehler2 = 0;
	printf( "Anzahl der Globalen Uebereinstimmungen (Matrixinhalt unten/rechts):\t%d \n\n", globalScore );
	printf("AusgabeChar:\t");
	while ( zaehler2 < globalScore ) {
		printf("%c", globalAusgabe[zaehler2]);
		zaehler2 ++;
	}
	zaehler2 = 0;
	printf("\n\n");
	
	
	
	
	// Globale DeBug Matrix
	
	
	
	
	 for (i = 0; i < gm ; i++) {
		 for (k = 0; k < go; k++) {
			 printf("%d\t", g[i][k][1]);
		 }
	 printf("\n");
	 }
	 
	 printf("\n");											 ///////		DEBUG MATRIX	//
	 
	 for (i = 0; i < gm ; i++) {
		 for (k = 0; k < go; k++) {
			 printf("%d\t", g[i][k][0]);
		 }
	 printf("\n");
	 }
	
	printf("\n %d\n",x);
	
	
	//
	
	/*
	
	for (i = 0; i < gm; i++) {
		for (k = 0; k < go; k++) {
			
			printf("%s \t", lokalErgebnis[i][k]);
			
		}
		printf("\n");
		
	}
	
	*/
	/////////////		End of Program Showing Parameters And Free Space		/////////////////////////////////////////////

	for(i=1; i < argc; i++) {
		printf("parameter[%d] = %s ", i, parameter[i]);
		printf("\n");
	}
	
	
	fclose(ausgabeDatei);
	fclose(datei1);
	fclose(datei2);
	
	
	/* Speicherplatz wieder freigeben.
	 * Wichtig! In umgekehrter Reihenfolge. */
	
	/*Tupel freigeben */
	for ( i = 0; i < m; i++) {
		for( k = 0; k < n; k++){
			free(matrix[i][k]);
		}
		free(matrix[i]);
	}
	free(matrix);
	
	
	/* Speicherplatz wieder freigeben.
	 * Wichtig! In umgekehrter Reihenfolge. */
	
	/*Tupel freigeben */
	for ( i = 0; i < gm; i++) {
		for( k = 0; k < go; k++){
			free(g[i][k]);
		}
		free(g[i]);
	}
	free(g);
	
	
	free(txt1);
	free(txt2);
	free(ausgabe1);
	free(ausgabe2);

	
	
	/* Spalten der i-ten Zeile freigeben 
	for( i = 0; i < m; i++)
		free(matrix[i]);
	/* Jetzt können die leeren Zeilen freigegeben werden. 
	free(matrix);
	*/

	
	
	for ( i = 0; i < gm; i++) {
		for( k = 0; k < go; k++){
			free(lokalErgebnis[i][k]);
		}
		free(lokalErgebnis[i]);
	}
	free(lokalErgebnis);


	
	
	return EXIT_SUCCESS;
	
	
	
	
	
	

}//main

/*

int *max( int x, int y, int z ){					//	s∗ = max(g[i − 1][j],	g[i][j − 1],	si,j + g[i − 1][j − 1])	
	
	int maximal[2];
	
	maximal[0] = z;
	maximal[1] = 2;
	
	if(x > z){
		maximal[0] = x;
		maximal[1] = 3;
	}
	if(y > z){
		maximal[0] = y;
		maximal[1] = 1;
	}
	
	return maximal;
	

}// max Funktion 
 
*/


int maxScore( int x, int y, int z ){
	
	int score = z;
	
	if( x > z )				score = x;
			
	if( y > z && y > x )	score = y;
	
	return score;
}	// maxScore


int maxDirection( int x, int y, int z ){
	
	int direction = 2;
	
	if( x > z )			direction = 3;
		
	if( y > z && y > x) direction = 1;

	return direction;
	
} // maxDirection








