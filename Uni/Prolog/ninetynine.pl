my_last(X,[X]):-!.
my_last(X,[_|T]):-
	my_last(X,T).

 my_secondlast(X,[X,_]):-!.
my_secondlast(X,[_|T]):-
	my_secondlast(X,T).

element_at(X,List,N):-
	element_acc(X,List, N,N).

element_acc(X,[X|_],1,_N):-!.

element_acc(X,[_H|T],Y,N):-
	Temp is Y-1,
	element_acc(X,T,Temp,N).

% 1.04
my_length([],0).
my_length([_],1).

my_length([_H|T],X):-
	my_length(T,Temp),
	X is Temp +1.

my_reverse([],[]).
my_reverse([H|T],Result):-
	append(H,R, Result),
	my_reverse(T,R).


