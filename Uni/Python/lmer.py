import sys
import re
import fasta



try:
	fastaFile = sys.argv[1]
	llength = sys.argv[2]  #lmer Laenge
except:
	print("too few arguments ... \a\n")
	sys.exit(1)

def main(fastaFile, llength):
	#Datei einlesen
	data = fasta.Fasta(fastaFile)
	lmap = {}
	sequenceString = data.getSequence("gi|41400038|gb|AY500825.1|") #siehe Fasta Datei
	llist= re.findall(r"[a-zA-Z]{"+str(llength)+ "}",sequenceString)
	
	if llist:
		for elem in llist[:]:
			if elem in lmap:
				temp = lmap[elem]   #Value holen
				temp+=1
				lmap[elem] = temp
			if not elem in lmap:
				lmap[elem] = 1
	#Date schreiben
	FILE = open("Lmer.txt", "w")
	FILE.write("Lmer        " + "Anzahl\n\n")
	for item in sorted(lmap):
		FILE.write( item + "\t\t" + repr(lmap[item])+"\n")

main(fastaFile,llength)
	
