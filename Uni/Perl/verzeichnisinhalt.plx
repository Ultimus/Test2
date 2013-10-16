#!usr/bin/perl

opendir DH, "$ARGV[0]" or die "Couldn't open directory: $!";
@files = glob("*");
for(@files){
	print "$_\n";
}

