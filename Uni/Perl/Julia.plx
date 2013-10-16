use strict;
use warnings;

my $rng = int(rand(30));



my $var = 1;
my $i=0;
my $find = 0;
my $range = 30;
my @numbers = ($range);
$numbers[0] = $rng;


while (scalar(@numbers) !=$range){
	$rng = int(rand($range));
	$find = 0;
	for ($i = 0; $i < scalar(@numbers) && $find != 1; $i++){
		if ($numbers[$i] == $rng){
			$find = 1;
		} 
	}
	if ($find == 0){
		if($rng == 0){ $rng = $range;}
	$numbers[$var-1] = $rng;
	$var++;
	}
}
for ($i = 0; $i < scalar(@numbers); $i++){
	print "$i : $numbers[$i]\n";
}

#print "Array: @numbers\n"
		




