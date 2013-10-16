#!usr/bin/perl

use warnings;
use strict;


my $carlo = 0;
my @result;

until ($carlo ==1000){
	my $X;
	my $RNG;
	my $counter=0;
	until ($counter == 60){
		$RNG = int(rand(6))+1;
		$X++ if ($RNG == 6);
		$counter++;
	}
	$result[$X][0]++;
	$result[$X][1] = $X;
	$carlo++;
}
 for (my $i=0; $i< scalar@result; $i++){
	print "$result[$i][1]: $result[$i][0]\n" if ($result[$i][0] != 0);
}

	 


