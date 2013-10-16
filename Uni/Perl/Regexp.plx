#!usr/bin/perl

use strict;
use warnings;

my $string = "ThiS Is a sTrIng tO pRacTice soMe Python funCtIons.";

$string =~ tr/[A-Z]/[a-z]/;
print "b) $string\n";

$string =~ tr/[a-z]/[A-Z]/;

print "c) $string\n";

$string =~ s/some/a lot of/i;

print "d) $string\n";
