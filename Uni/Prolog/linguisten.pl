card3min([_H|_T]). 

eins_mit_drei([H,_,H|_T]).

ein_gleiches_element([H|_T], [H_|T_]) :-
	member(H, [H_|T_]).

ein_gleiches_element([_H|T], [H_|T_]) :-
	ein_gleiches_element(T,[H_|T_]).

prefix([],_List).

prefix([H|T_],[H|T]) :-
	prefix(T_,T).
	

postfix([],_).

postfix(Result, List) :-
	reverse(List, Y),
	prefix(X,Y),
	reverse(X, Result),!.

/*
infix([],_).

infix([H|T_], [H|T]) :-
	infix(T_,T).

infix([H_|T_], [_|T]) :-
	infix([H_|T_], T).
*/

 infix(I,L) :- !,
	append(_,I,L1), 
	append(L1,_,L).

zensur([a,b|T]) :-
zensur(T),!.

zensur([a,b]):-!.


flatten([],[]).

flatten([H|T], Result) :-
	flatten(H,HRes),
	flatten(T,TRes),
	append(HRes,TRes, Result),!.

flatten(X,[X]) :-
	X \= [], X \= [_,_].
 
member(X,[X|_]).
member(X,[_|T]):-
	member(X,T).



member2(X,[X,_]).
member2(X,[_|T]):-
	flatten([_|T],Y),
	member(X,Y),!.

dcg--> "a",dcga;
	"b",dcgb;
	[].
dcga--> "a",dcga;
	"b",dcgb;
	[].
dcgb-->"b",dcgb;
	[].

/*dcg_aN_bN --> a(I), b(I), c(I).
a(i) --> [].
a(i(I)) --> [a], a(I).
b(i) --> [].
b(i(I)) --> [b], b(I).
c(i) --> [].
c(i(I)) --> [c],c(I).
*/

s--> np, vp.
vp --> v(nom,_,_),np(akk,_,_).
np --> det(_),n(_).
np --> pn.
pn(nom,sg,fem)--> [maria].
det(_,_,_)-->[den].
n(akk,sg,male) --> [mann].
v(nom,sg,fem) --> [sieht].

ultra_dcg --> a(I), b(J), c(I), d(J).
a(i) --> [].
a(i(I)) --> [a], a(I).
b(j) --> [].
b(j(J)) --> [b],b(J).
c(i) --> [].
c(i(I)) --> [c], c(I).
d(j) --> [].
d(j(J)) --> [d], d(J).

mylength([],0).
mylength([_|T],Temp):-
	mylength(T,Result),
	Temp is Result + 1.


disjoint([],[]).

disjoint([H|T],[H|Result]):-
	\+member(H,Result),
	disjoint(T,Result).

element([],[]).
element([H|_], [H|_]).
element([H|T], [_|T1]):-
	element([H|T], T1),!.

distinct([],[]).
distinct([H|T],C) :- member(H,T),!, distinct(T,C).
distinct([H|T],[H|C]) :- distinct(T,C).



fib(1,1):-!.
fib(2,1):-!.
fib(X,Y) :-
	X1 is X-1, fib(X1,R1),
	X2 is X-2, fib(X2,R2),
	Y is R1 + R2.


fak(0,1):-!.
fak(1,1):-!.
fak(X,N):-
	Temp is X-1,
	fak(Temp,R),
	N is X*R. 


qs([],[]).
qs([H|T],S):-
partition(T,H,L,B),
qs(L,LS),
qs(B,BS),
append(LS,[H|BS],S).

partition([],_,[],[]).
partition([H|T],X,[H|L],B):-
H =< X,
partition(T,X,L,B).
partition([H|T],X,L,[H|B]):-
H > X,
partition(T,X,L,B).


%power(Exp, Base, Result)

power(0,X,1).
power(1,X,X).

power(X,Y,R):-
	X1 is X-1,
	power(X1,Y,Temp),
	R is Temp*Y.


