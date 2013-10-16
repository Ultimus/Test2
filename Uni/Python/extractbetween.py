import sys

def extract_between(s1, a, b):
	s2=[]
	for x in s1:
		if x >= a and x < b:
			s2.append(x)
	sorted(s2)
	print(s2)
	
	
def vokale(string):
	a = set('aeiou')
	counter = 0
	for x in string:
		if x & a:
			counter +=1
	print(counter)
