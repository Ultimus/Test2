app(X,Y,Z) :- when((nonvar(X);nonvar(Z)),app2(X,Y,Z)).
app2([],R,R).
app2([H|X],Y,[H|Z]) :- app(X,Y,Z).

lplus(X,Y,Z):-
	var(X),nonvar(Y), X is Z-Y,!;
	var(Y),nonvar(X), Y is Z-X,!;
	var(Z),nonvar(X), nonvar(Y), Z is X+Y,!.

lminus(X,Y,Z):- ( var(X), nonvar(Y) -> X is Z+Y
		; var(Y), nonvar(X) -> Y is Z+X
		; nonvar(X), nonvar(Y) -> Z is X-Y
		).
	


