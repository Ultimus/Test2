import sys

input = []
negnull=[]
pos=[]
hundred=[]
thousand=[]

temp=""

while temp!="q":	#Solange einlesen bis q eingegeben wird (ist nicht ganz wie kbht() in C)
	temp = raw_input("Bitte geben sie beliebige Zahlen ein: \n") #Zahlen von der Konsole einlesen
	if temp != "q":
		input.append(temp)
else:
	for item in input[:]:
		item = int(item)  #als int casten
		if item <= 0:
			negnull.append(item)
	
		elif item >0 and item <=100:
			pos.append(item)
	
		elif item > 100 and item <=1000:
			hundred.append(item)

		elif item >1000:
			thousand.append(item)

	print(negnull, pos, hundred, thousand)  #Listen ausgeben






#mit großer Hilfe von Jarno


	
