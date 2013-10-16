import sys
import re
import fasta



try:
	fastaFile = sys.argv[1]
	maxdistance = sys.argv[2]  #maximale Hammingdistanz
except:
	print("too few arguments ... \a\n")
	sys.exit(1)

def main(fastaFile, maxdistance):
	#Datei einlesen
	muster = "GATGGT"
	data = fasta.Fasta(fastaFile)
	lmap = {}
	sequenceString = data.getSequence("gi|41400038|gb|AY500825.1|") #siehe Fasta Datei
	llist= re.findall(r"[a-zA-Z]{"+str(len(muster))+ "}",sequenceString)
	
	if llist:
		for elem in llist[:]:
			if elem in lmap:
				temp = lmap[elem]   #Value holen
				temp+=1
				lmap[elem] = temp
			if not elem in lmap:
				lmap[elem] = 1

	#Hamming Distanz berechnen und aussortieren
	for elem in lmap:
		distance = 0
		telem = str(elem)
		length = len(muster)
		for i in range(0, length-1):
			if muster[i] != elem[i]:
				distance+=1
		if distance >= maxdistance:
			del lmap[item]


	#Date schreiben
	FILE = open("Hamming.txt", "w")
	FILE.write("Lmer        " + "Anzahl\n\n")
	for item in sorted(lmap):
		FILE.write( item + "\t\t" + repr(lmap[item])+"\n")

main(fastaFile,maxdistance)
	
