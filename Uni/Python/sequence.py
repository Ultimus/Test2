""" Speichern von DNA- oder Aminosaeuresequenzen

Sequence -- speichert Sequenzen

#------------------------#
|        Sequence        |
#------------------------#
| __seq: dictionary      |
| __seqN: integer        |
| __ord: character       |
#------------------------#
| getSequence()          |
| getAllSequences()      |
| getAllSequencesInOrd() |
| setSequence()          |
| getNumSeq()            |
| getAllIds()            |
| getAllIdsInOrd()       |
#------------------------#
"""

import sys

class Sequence(object):

    # ------------------------------------------------------------------------ #

    # Konstruktor
    def __init__(self, id, sequence):
  
        seqN = len(id)
        if (seqN != len(sequence)):
            print("'id' and 'sequence' must have same length")
            sys.exit(1)
  
        self.__seq = {}
        self.__ord = []
        for i in range(seqN):
            self.__seq[id[i]] = sequence[i]
            self.__ord.append(id[i])
        
        self.__seqN = seqN

    # ------------------------------------------------------------------------ #

    # bestimmte Sequenz ausgeben
    def getSequence(self, id):
        return(self.__seq[id])

    # ------------------------------------------------------------------------ #

    # alle Sequenzen ausgeben
    def getAllSequences(self):
        return(list(self.__seq.values()))

    # ------------------------------------------------------------------------ #

    # Alle Sequenzen wie eingegeben ausgeben
    def getAllSequencesInOrd(self):
        se = []
        for i in self.__ord:
            se.append(self.__seq[i])
        return(se)


    # ------------------------------------------------------------------------ #

    # neue Sequenz einsetzten, alte ersetzten
    def setSequence(self, id, sequence):
        if id not in self.__seq:
            self.__seqN += 1
        #self.__seq.update({id:sequence})
        self.__seq[id] = sequence

    # ------------------------------------------------------------------------ #

    # Anzahl der gespeicherten Sequenzen ausgeben
    def getNumSeq(self):
        return(self.__seqN)

    # ------------------------------------------------------------------------ #

    # Alle id's ausgeben
    def getAllIds(self):
        return(list(self.__seq.keys()))

    # ------------------------------------------------------------------------ #

    # Alle id's wie eingegeben ausgeben
    def getAllIdsInOrd(self):
        return(self.__ord)
#         for i in self.__ord:
#             id.append(self.__seq[i])
#         return(id)

    # ------------------------------------------------------------------------ #

    # print methode
    def __str__(self):
        n = self.getNumSeq()
        if n > 1:
            return(str(self.getNumSeq()) + " Sequenzen gespeichert")
        else:
            return("nur eine Sequenz gespeichert")



# Testumgebung
if __name__ == "__main__":
    test = Sequence(["first", "second", "third"], ["GCTA", "ACGT", "TGCA"])
    print(test)
    print("Sequenz: ", test.getSequence("second"))
    test.setSequence("first", "AAACCCGGGTTT")
    print(test)
    print("Sequenz: ", test.getSequence("first"))
    print("Sequenz: ", test.getSequence("third"))
    test.setSequence("fourth", "GCGCGC")
    print(test)
    print(test.getAllIds())
