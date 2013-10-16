#usr/bin/perl

use warnings;
use strict;


# open FILE, "nlexample.txt" or die $!;
my $lineno = 1;

while (<>){
	print $lineno++;
	print ": $_";
}


