nat(0).
nat(s(X)):-nat(X).

make_nat(0,0).
make_nat(Zahl, PrologZahl) :-
	nat(Zahl).


