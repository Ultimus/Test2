

:- consult(abstract_interpreter_loop).
%:- consult_without_redefine_warning(abstract_interpreter_loop).

abstract_domain_element(1).
abstract_domain_element(0).
abstract_domain_element(X) :- X \=0, X\=1, number(X).
abstract_domain_element(nac).

lub(X,X,R) :- !,R=X.
lub(_X,_Y,nac).



% Redefinition of predicate from javabc_interpreter.pl:
 
aex_op(OP,X1,X2,R) :- %print(ex_op(OP,X1,X2,R)),nl,
       number(X1), number(X2), ex_op_concrete(OP,X1,X2,R).
aex_op(_,X,Y,nac)  :- \+ number(X) ; \+ number(Y).
 


% Redefinition of predicate from javabc_interpreter.pl:
test_op(OP,X,Y) :- number(X),number(Y),test_op_concrete(OP,X,Y).
test_op(_OP,X,Y) :- \+ number(X) ; \+ number(Y).


% Redefinition of predicate from javabc_interpreter.pl:
false_op(OP,X,Y) :- number(X),number(Y),false_op_concrete(OP,X,Y).
false_op(_OP,X,Y) :- \+ number(X) ; \+ number(Y).

abstract_value(X,X).


:- nl,print('Use aint to run abstract interpreter'),nl.




