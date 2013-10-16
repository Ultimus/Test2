qs([],[]).
qs([H|T], Result):-
	split(H,T,Lower, Greater), 
	qs(Lower,Res1),
	qs(Greater, Res2),
	app(Res1, [H|Res2], Result).
    
app([],L, L).
app([H|T], L, [H|R1]) :- app(T, L, R1).

split(Pivot, List, LowerEq, Greater) :-
	lower_eq(Pivot, List,[], LowerEq),
	greater_eq(Pivot, List,[], Greater).

lower_eq().




	% app/3 concatenates two lists
	% split splits a list in two parts
	% Part A contains elements <= Pivot	
	% Part B contains elements > Pivot

