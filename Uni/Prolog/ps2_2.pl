accept(List):-
	one(List).

one([H|T]):-
	H=d,
	two(T).

two([H|T]):-
	H=a,two(T);
	H=b, two(T);
	H=d, four(T);
	H=c, three(T);
	H=e, five(T).

three([H|T]):-
	H=d, six(T).

four([]):-!.

five([]):-!.

six([H|T]):-
	H=c,five(T).


llength([],0):-!.

llength([_|T],R):-
	llength(T,Temp),
	R is Temp+1.

 
		


todl(List, Dl-X,X) :-
    append(List, X, Dl).
	


