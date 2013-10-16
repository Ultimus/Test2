import sys
def fib(n):
	a,b = 0,1
	x = 0
	while x != n:
		a,b = b, a+b
		x+=1
	print(b)


	
