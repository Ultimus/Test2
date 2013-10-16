checklist([_|_]):-!.


list_member([H|_],H):-!.
list_member([_|T],X):-
	list_member(T,X).

palindrom(List):-
	reverse(List, List).


append_flat([],[]):-!.
append_flat([H|T],[H|R]):-
	checklist(H)\=true,
	append_flat(T,R).

append_flat([H|_],R):-
	checklist(H),
	append_flat(H,R).

remove([],_,[]):-!.
remove([H|T],E,[H|R]):-
	H\=E,
	remove(T,E,R).
remove([H|T],H,R):-
	remove(T,H,R).

empty([]):-!.

insert(List,X,Y,R):-
	append(List,(X,Y),R).



