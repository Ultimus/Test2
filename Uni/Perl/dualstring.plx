#!usr/bin/perl

use strict;
use warnings;


print "Geben sie den ersten String ein: \n";
my $first = <STDIN>;
chomp ($first);

print ("Danke! Geben sie bitte den 2. String ein: \n");
my $second = <STDIN>;
chomp $second;  #Wer braucht bitte Klammern?

my $new= $first.$second;  #so cincateniert man in Perl Strings


my @array = (1..10); #Voll das coole feature
for(@array){ #Noch ein geiles feature
print "$_: $new\n"   #das letzte Semikolon immer vergessen!!! $_ kann man auch weglassen, dann ist es hässlich aber cool
}




