#!usr/bin/perl

use strict;
use warnings;
my $string = $ARGV[0];
my @matches = ($string =~ /\d+/g); # g ist wichtig für globales matching
if($string=~ /^[a-zA-Z]\d+[a-zA-Z]$/){
	print "@matches\n";
}
