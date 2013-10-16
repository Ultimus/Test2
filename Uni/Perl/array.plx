#!usr/bin/perl

use strict;
use warnings;

my @array = (1..9);

$array[5] = 12;
my $_;

for (;@array;){ 
push @array, 2 if ($_ % 3 == 0);
$_ = pop(@array);

print "$_\n";
}
