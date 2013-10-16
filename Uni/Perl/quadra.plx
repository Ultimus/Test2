#!usr/bin/perl

use strict;
use warnings;

print "Geben sie eine Zahl ein: \n";
my $n = <STDIN>;
chomp $n;   #chomp löscht blöde \n am Ende einer Eingabe

my @range= (1..$n);
my $sum = 0;
for(@range){

	$sum += $_**2;  #**ist pow
}

print "Summe: $sum\n" 

