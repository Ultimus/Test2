import sys
from optparse import OptionParser

def main():
	parser = OptionParser()
	parser.add_option("-r", action="store_true", dest="controller")
	parser.add_option("-i", action="store_false", dest="controller")
	parser.add_option("-n", action="store", type="int", dest="n")
	
	(options, args) = parser.parse_args()
	controller = options.controller
	n = options.n	
	if(controller == True):
		print ("Ergebniss: ",recursiv(n))
	else:
		print("Ergebniss: ",iterative(n))
	
	


def iterative(n):
	result = 1
	for x in xrange(1,n+1):
		result*=x
		print("Berechnung: ",result)
		print("\n")
	return result

def recursiv(n):
	if (n==1): 
		return 1
	print("Berechnung: ",n)
	print("\n")
	return n*recursiv(n-1)
	

if __name__ == "__main__":
    main()
