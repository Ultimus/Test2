make_nat(0, 0).

make_nat(X, s(N)):-
	X >0,
	Temp is X-1,
	make_nat(Temp, N).






 member2(X,[H|T]):-
	member(X,T).
member2(H,[H|_T]):-!.
