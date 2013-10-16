package BioinfAlg2::FastA;

use strict;

# Konstruktor für neue Instanzen der Klasse 'FastA'
sub new {

    my $class = shift;

    my $fas = {};
  
    $fas -> {id}       = [];
    $fas -> {sequence} = [];
    
    # Klasse zuweisen
    bless ($fas, $class);
  
    # Referenz zurückgeben
    return $fas;

}


sub id {

    my $fas = shift;
    
    if (@_) {
        $fas -> {id} = shift;
    }
    
    return $fas -> {id};
    
}

sub sequence {

    my $fas = shift;
    
    if (@_) {
        $fas -> {sequence} = shift;
    }
    
    return $fas -> {sequence};
    
}


1;

__END__

=pod

=head1 DESCRIPTION

  see ReadFasta

=cut
