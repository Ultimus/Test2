#!usr/bin/perl

#Da Python mich ärgert mach ich mal in perl weiter:


use strict;
use warnings;

my $counter =0;
my $rng=0;

until($rng==42){
	$rng= int(rand(50));
	$counter++;
}
print "$counter\n"

