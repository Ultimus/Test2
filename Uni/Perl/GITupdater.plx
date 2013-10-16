#!usr/bin/perl

use strict;
use warnings;

$_ = 51;
until ($_ > 55){
print ("Gruppe$_: \n");
system("cd /home/maximilian/Arbeitsfläche/Uni/Propra/Propra13/gruppe$_  && git pull");
system("cd /home/maximilian/Arbeitsfläche/Uni/Propra/Propra13/gruppe$_ && git reset --hard");
$_++;
}



