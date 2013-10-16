#!/usr/bin/perl -W

use strict;
use warnings;

use BioinfAlg2::ReadFastA;
use BioinfAlg2::FastA;

my $file;

if ($ARGV[0]) {
    $file = $ARGV[0];
}
else {
    print STDERR "too few arguments ...\a\n";
    exit 1;
}

#################################################################
# Einlesen das Fasta-Files
#################################################################

my $seqfile = BioinfAlg2::ReadFastA -> new;

my $fasta = $seqfile -> read_sequence($file);

my $seq = $fasta -> sequence;
my $ids = $fasta -> id;

printf("Eingabedatei: %s\n", $seqfile -> filename);

foreach (@$ids) {
    print $_."\n";
}
