#!usr/bin/perl

use strict;
use warnings;

open FASTA, "nf.fasta" or die $!;
my @sequenz;
my $i=0;

while (<FASTA>){
	if ($_ =~/\>(\w|[[:punct:]])*/i){#Hier stimmt etwas nicht.
		$sequenz[$i++] = $1;  #key finden
	}
	$sequenz[$i] = $_;
}
#my %sequenzH = @sequenz;

open LOG, "> output.txt" or die $!;
select LOG;
print @sequenz;

		
