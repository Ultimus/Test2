#!usr/bin/perl

use strict;
use warnings;



print "Bitte geben sie eine Zahl ein: \n";
my $var = <STDIN>;
chomp $var;


printf "%b\n ",$var;


