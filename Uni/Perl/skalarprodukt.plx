#!usr/bin/perl

use strict;
use warnings;

my @vektor1;
my @vektor2;
my $i=0;
print "Bitte geben sie die Länge der Vektoren an: \n";

my $range =<STDIN>;
chomp $range;
my $counter = 0;
my $number;

print "Geben sie die Zahlen des ersten Vektors ein: \n";

until ($counter++ ==$range){
	$number = <STDIN>;
	push @vektor1, $number if (int($number))  #JA, man kann auf Arrays push und pull machen, die if Abfrage ist tatsächlich so möglich
	
}
print "geben sie die Zahlen des 2. Vektors ein: \n";
$counter = 0;
until ($range-- == 0){
	$number = <STDIN>;
	push @vektor2, $number
}

die "Vektoren mit unterschiedlicher Länge\n" if(scalar(@vektor1) != (scalar(@vektor2)));
#die beendet ein programm mit einer Fehlermeldung
#scalar gibt die Länge eines Arrays an
my $sum = 0;

for(@vektor1){
	$sum += $_* $vektor2[$range++];
}

print "Skalarprodukt: $sum\n";

#ich hab mir so viel Mühe gegeben möglichst viele features einzubauen, deswegen würde ich gerne meine Lösung zeigen 

