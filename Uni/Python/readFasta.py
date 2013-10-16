#!/usr/bin/env python3

import sys

sys.path.append("/Users/gabriel/Kurse/algorithmen/lib/python")
import fasta
#from fasta import Fasta


# Argument: Dateiname
try:
    fastaFile = sys.argv[1]
except:
    print("too few arguments ...\a\n")
    sys.exit(1)


# Datei lesen
seq = fasta.Fasta(fastaFile)

# Informationen
print("Habe " + str(seq.getNumSeq()) +
      " Sequenzen aus der Datei " + seq.getFilename() + " gelesen.")

print(seq.getAllIds())
print(seq.getNumSeq())
print(seq.getSequence("nf|0001f"))
seq.setSequence("rababer", "saft")
print(seq.getAllIds())
print(seq.getNumSeq())
seq.setSequence("rababer", "adads")
print(seq.getAllIds())
print(seq.getNumSeq())

seq.writeFasta("blubber.fasta", 80)
