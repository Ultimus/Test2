#!usr/bin/perl

use strict; use warnings;

my $syllable = "ink";

while (<>){
	print if /$syllable$/;
}

