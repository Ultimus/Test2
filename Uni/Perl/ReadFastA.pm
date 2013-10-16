package BioinfAlg2::ReadFastA;

use strict;

# Konstruktor für neue Instanzen der Klasse 'ReadFastA'
sub new {

    # Beim Aufruf des Konstruktors wird automatisch der Klassenname als erster
    # Parameter übergeben.
    my $class = shift;
    my ($fn, $rf);


    # zweites Argument Dateiname
    if (@_) {
        $fn = shift;
    }
    else {
        $fn = "";
    }

    # Deklarieren eines Zeigers (Referenz) auf einen leeren Hash.
    $rf = {};
  
    # Klasse zuweisen
    bless ($rf, $class);
  
    # Daten, hier ein Dateiname
    $rf -> filename($fn);
    
    # Referenz zurückgeben
    return $rf;

}


# Methode Filename 
sub filename {

    my $rf = shift;
    
    if (@_) {
        $rf -> {filename} = shift;
    }
    
    return $rf -> {filename};
    
}


# FastA Datei einlesen
sub read_sequence {
     
    my $rf = shift;
    
    my (@ids, @seqs, $i, $tmp_seq);
    
    # Dateiname abspeichern
    if (@_) {
        $rf -> {filename} = shift;
    }

    open(IN, "<", $rf -> filename)
        || die "failed to open file: ".$rf -> filename.": $!\a\n";


    # variant string
   local $/ = ">";
    
    while (<IN>) {
        chomp;
        if (m/^(.+)           # Sequenzname
               \n             # erstes new line
               (?s)           # Modifikator einschalten: ". trifft alles"
               (.+)$/x) {     # die Sequenz
            push(@ids,  $1);
            $tmp_seq = $2;
            $tmp_seq =~ s/\s//g;      # Leerzeichen entfernen
            push(@seqs, $tmp_seq);
        }
    }
    
    # variant array
#     $i = -1;
#     while (<IN>) {
#         if (m/^>(.*)/) {
#             $i++;
#             $seqs[$i] = "";
#             $ids[$i]  = $1;
#         }
#         #elsif (m/^;/) {
#             #next;
#         #}
#         else {
#             chomp;
#             $tmp_seq = $_;
#             $tmp_seq =~ s/\s//g;
#             $seqs[$i] = $seqs[$i] . $tmp_seq;
#         }
#     }

    close (IN);
    
    my $sequences = BioinfAlg2::FastA -> new;

    $sequences -> id(\@ids);
    $sequences -> sequence(\@seqs);
    
    return($sequences);

}

# für use bzw. require
1;

__END__


=pod

=head1 NAME

  BioinfAlg2

=head1 SYNOPSIS

  use BioinfAlg2::ReadFastA;
  use BioinfAlg2::FastA;

=head1 DESCRIPTION

  Das Modul BioinfAlg2 stellt Methoden bereit, um Sequenzen im
  im FastA-Format zu verarbeiten.
  
=head1 USAGE

  Eine neue Instanz der Klasse BioinfAlg2::ReadFastA erzeugen
  my $seqfile = BioinfAlg2::ReadFastA -> new();
  
  Die Variable $file enthaelt einen Dateinamen
  my $fasta   = $seqfile -> read_sequence($file);

  Die Methode read_sequence() liest die Datei ein. Das Objekt
  $seqfile enthält den Dateinamen. Das Object $fasta ist eine
  Instanz der Klasse BioinfAlg2::Fasta und enthält
  Referenzen auf zwei Arrays, und zwar @ids (die Sequenz-ids)
  und @seqs (die Sequenzen).

  my $id         = $fasta   -> get_id();
  my $seq        = $fasta   -> get_sequence();

  Die Klasse FastA stellt zwei Methoden zur Verfuegung:
  id()          gibt eine Referenz auf @ids zurueck.
  sequence()    gibt eine Referenz auf @seqs zurueck.

=head1 INSTALLATION

  Das Verzeichnis BioinfAlg2/ kann irgendwo auf der Festplatte
  liegen. Wenn BioinfAlg2/ nicht in @INC liegt, muss der Pfad mit
  use lib "<Pfad>"; im Skript eingebunden werden:

  use lib "/home/gabriel/lib";

  Das Verzeichnis /home/gabriel/lib/ enthaelt
  das Verzeichnis BioinfAlg2/.

=cut
