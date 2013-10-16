#!usr/bin/perl

print "Bitte geben sie einen String ein: \n";
$pal = <STDIN>;
chomp $pal;

$rev = reverse $pal;

print "$rev\n";

# iterativ:
for($i = 0; $i < length($pal); $i++){
	$act = substr($pal, $i, 1);
	print "$i : $act";
	$act2 = substr($rev, $i, 1);
	print "   $act2\n";
	unless($act eq $act2){
		print "Der String ist kein Palindrom!\n";
		exit;
	}
}

print "Der String ist ein Palindrom!\n";


