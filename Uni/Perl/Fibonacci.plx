#!usr/bin/perl

use strict;
use warnings;

my $x= 0;
my $y = 1;
my $sum =0;
my $counter=0;

until($counter++==100){
	$sum=$x+$y;
	$x = $y;
	$y=$sum;
	print"$counter: $sum\n";
}


