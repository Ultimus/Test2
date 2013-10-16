t.
f.

and(t,t) :- true.
or(t,t):-
	true.
or(t,f):- 
	true.
or(f,t):-
	true.
or(f,f):-
	false.

not(t):- false.
not(f):- true.


wff(formula):-
	and(X,Y);
	or(X,Y);
	not(X).



is_atomic_expr(Term):-
	nonvar(Term),
	functor(Term,_,0).

is_literal(Term):-
	is_atomic_expr(Term);
	is_atomic_expr(not(Term)).


simplify_expr(not(not(Term)),Simplified):-
	simplify_expr(_,Term).

simplify_expr(not(and(X,Y)),Simplified):-
	simplify_expr(_,not(X)or(not(Y)).



