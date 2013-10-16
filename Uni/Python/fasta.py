""" Lesen von Dateien im FastA-Format

Fasta -- speichert Sequenzen

#------------------------#
|        Sequence        |
#------------------------#
             ^
             | 
#------------------------#
|          Fasta         |
#------------------------#
| __filename: dictionary |
#------------------------#
| getFilename()          |
| writeFasta()           |
#------------------------#
"""

import sys
import re
from sequence import Sequence

class Fasta(Sequence):

    # ------------------------------------------------------------------------ #

    # Konstruktor
    def __init__(self, filename):

        # FastA-Datei oeffnen
        try:
            FASTAFILE = open(filename, "r")
        except:
            print("cannot open file: '" + filename + "': " + str(sys.exc_info()[1]))
            sys.exit(1)

        # FastA-Datei lesen
        seqN = -1
        ids  = []
        seq  = []
        patt = re.compile(r"\s+")

        for line in FASTAFILE:
            if (seqN == -1) and not (line.startswith(">")):
                print("input file is not in FastA format")
                sys.exit(1)

            line = line.rstrip()
            if (line.startswith(">")):
                # Anzahl der Sequenzen
                seqN += 1

                # Sequenz id: alles bis zum ersten Leerzeichen
                id = line.lstrip(">")
                id = id.split(None, 1)
                ids.append(str(id[0]))
                seq.append("")
            elif (line.startswith(";")):
                # ignoriere Kommentare
                continue
            else:
                # Sequenz (von Leerzeichen befreit) anfuegen
                seq[seqN] += str(re.sub(patt, "", line))

        FASTAFILE.close()

        # object konstruieren
        Sequence.__init__(self, ids, seq)
        self.__filename = filename
        

    # ------------------------------------------------------------------------ #

    # Dateinamen ausgeben
    def getFilename(self):
        return(self.__filename)

    # ------------------------------------------------------------------------ #

    # FastA-Datei schreiben
    def writeFasta(self, filename, step = 80):

        # FastA-Datei erstellen
        try:
            FASTAFILE = open(filename, "w")
        except:
            print("cannot open file: '" + filename + "': " + str(sys.exc_info()[1]))
            sys.exit(1)

        ids = self.getAllIds()
        
        for id in ids:
            seq  = self.getSequence(id)
            FASTAFILE.write(">{}\n{}\n" .format(str(id),
                            "\n".join(seq[i:i+step] for i in range(0, len(seq), step))))

        FASTAFILE.close()
        
