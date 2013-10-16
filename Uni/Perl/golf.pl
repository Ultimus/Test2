#!usr/bin/perl
-l print map$_=$ARGV[($.+=!--$.[$.])%2],@.=(0)x pop

