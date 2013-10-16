#!usr/bin/perl

use strict;
use warnings;

my @size;
my @change;
my %sizeH;
my %changeH;
opendir DH, "." or die "Couldn't open the current directory";

my $counter = 0;

print "Dateiname\t      Letzte Änderrung in Tagen\tDateigroesse\n";
while ($_ = readdir(DH)){
	next if $_ eq "." or $_ eq "..";
	print $_, " " x (30-length($_));
	print -A, "\t";
	print -s;
	print "\n";
	#Dateinamen ins array schreiben: 
	$size[$counter] = $_;
	$change[$counter++] = $_;
	#Werte den dateinamen zuweisen.
	$size[$counter] = -s;
	$change[$counter++] = -A;
}



%sizeH = @size;		#Aus einem Array wird ein hash gemacht
%changeH = @change;
open LOG, "> output.txt" or die $!;
select LOG;		#In die Datei schreiben
print "Dateiname\t\t      Letzte Änderrung in Tagen\tDateigroesse\n";


# Das war cool, doch jetzt wird sortiert!
for (sort keys %sizeH){
	print "$_ "," " x (30-length($_)),"$sizeH{$_}\t$changeH{$_}\n";
} 




