import sys

#MERKE!!! PYTHON VERSHET KEINE UMLAUTE!!!



dictio={}#dictionary

words="Hab ich was in Haskell vorbereitet"

while words != "":
	words = raw_input("Bitte geben sie Woerter ein: ")
	if words != "":
		dictio[words] = len(words)
else:
	alphasort = sorted(dictio)  #sortiere nach alphabet
	keysort = sorted(dictio, key= dictio.get)  #sortiere nach Schluessel
	print (alphasort, keysort)

#Wieder mit Hilfe von Jarno
