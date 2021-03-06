#!usr/bin/perl

use strict;
use warnings;

#Variablen:

my $first = "ACTGCTGA";
my $second = "ATCGTTG";
my $score;
my $match = 3;
my $mismatch = -1;
my $indel = -2;

my @matrix = ([0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0]); # Anonyme Arrays
	 	    #Alternative über Referenzen von Arrays, die ich dann in einem Array speicher
my @direction = ([0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0]);

		

my $actual = substr($first,2,1);
print "Test: " ,"$actual"x5,"\n"x2;
#Das fancy Zeug klappt nicht, deswegen erst mal die Java Variante :(
#Matrix initialisieren
my $counter = 1;

#Matrix mit ersten mismatch befüllen
for(my $row_i = 0; $row_i < @matrix; $row_i++) {
    for(my $column_i = 0; $column_i < @{$matrix[$row_i]}; $column_i++) {  #erste Möglichkeit auf Arrays zuzugreifen	
        $matrix[$row_i][$column_i] = 0;					  #schönste Möglichkeit auf Zeile und Spalte zuzugreifen
	$matrix[0][$row_i] = -1*$counter;
	$matrix[$row_i][0] = -1*$counter;
    }
	$counter++;
}

#Algorithmus:
#direction 1 = top, 2 = left, 3 = diagonal
for (my $row_i = 1; $row_i< @matrix; $row_i++){
	for(my $column_i=1; $column_i < @{$matrix[$row_i]}; $column_i++){
		unless(substr($first,$row_i-1,1) eq substr($second, $column_i-1,1)){
			my $maximum = $matrix[$row_i-1][$column_i]+ $indel;
			my $dir = 1;
			
			if ($maximum < $matrix[$row_i][$column_i-1]+$indel){
				$maximum= $matrix[$row_i][$column_i-1]+$indel;
				$dir = 2;
			}
			
			if ($maximum <  $matrix[$row_i-1][$column_i-1]+$mismatch){ 
				$maximum = $matrix[$row_i-1][$column_i-1]+$mismatch;
				$dir = 3;
			}
			$matrix[$row_i][$column_i] = $maximum;
			$direction[$row_i][$column_i] = $dir;

		}
		if(substr($first,$row_i-1,1) eq substr($second, $column_i-1,1)){   #je nachdem wie man vergleicht bekommt man andere Ergebnisse
			$matrix[$row_i]->[$column_i] = $matrix[$row_i-1][$column_i-1] + $match;
		}
	
	}	
}

print "Die Scoring Matrix: \n";
for(my $row_i = 0; $row_i < @matrix; $row_i++) {
    for(my $column_i = 0; $column_i < @{$matrix[$row_i]}; $column_i++) {
	print " ", if ($matrix[$row_i][$column_i] <10 && $matrix[$row_i][$column_i]>-1);	
        print "$matrix[$row_i]->[$column_i] ";				#zweite Möglichkeit auf zeile und Spalte korrekt zuzugrifen
    }
    print "\n"
}

print "\nDie Direction Matrix: \n";
for(my $row_i = 0; $row_i < @direction; $row_i++) {
    for(my $column_i = 0; $column_i < @{$direction[$row_i]}; $column_i++) {
	print " ", if ($direction[$row_i][$column_i] <10 && $direction[$row_i][$column_i]>-1);	
        print "$direction[$row_i]->[$column_i] ";				#zweite Möglichkeit auf zeile und Spalte korrekt zuzugrifen
    }
    print "\n"
}

#Traceback wird scheitern, da unten rechts in der Matrix direction = 0 ist






