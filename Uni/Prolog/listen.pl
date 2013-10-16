is_a_list([]).
is_a_list([H|T]).

app([], L, L).
app([H|T], L, [H|R1]):-
	app(T, L, R1).

infix([],[H|T]).
infix([I,IT],[H|T]):-
	I = H,
	infix([I|T],T).
	
	
prefix([],[H|T]).
prefix([P|TP],[H|T]):- 
	P = H,
	(prefix(TP,T);
	  TP = []).


element_of([],[H|T]).
element_of(E,[H|T]):-
	E = H;
	element_of(E,T).
	


len(L,Result):-
	len(L,0,Result).

len([],Acc,Acc).

len([_|T],Acc,Result):-
	Temp is Acc+1,
	len(T,Temp, Result).



flat([],[]).

flat([H|T],Result):-
	
	is_list(H),
	(
	flat(H,Result),
	app(H, [Result],[H|Result]).
	);
	\+is_list(H),
	(
	flat([H|T],Result):-
		flat(H,Result).
	).



	





	


