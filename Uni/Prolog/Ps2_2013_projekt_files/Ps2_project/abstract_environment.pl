
/* --------------------------------------- */
/*  Generic Environment Related Predicates */
/* --------------------------------------- */


/* A simple abstract domain:
   0, pos, neg, top */

% 0 represent just 0
% pos represents all strictly positive numbers
% neg represents all strictly negative numbers
% top represents all numbers

:- consult(abstract_interpreter_loop).
%:- consult_without_redefine_warning(abstract_interpreter_loop).

abstract_domain_element(0).
abstract_domain_element(pos).
abstract_domain_element(neg).
abstract_domain_element(top).

lub(X,X,R) :- !,R=X.
lub(X,Y,top) :- X\=Y.


% abstract a single value into an abstract one
abstract_value(X,AV) :- number(X),!,
   (X=0 -> AV=0 
     ; (X>0 -> AV = pos ; AV = neg)
   ).
abstract_value(X,X).



aex_op(/,0,_,0).
aex_op(/,_,0,_):- print('*** Divison by Zero ***'), fail.
aex_op(/,X,X,X).
aex_op(/,neg,pos,neg).
aex_op(/,pos,neg,neg).
aex_op(/,_,top,top).
aex_op(/,top,X,top) :- X\=0.

aex_op(pow,0,_,0).
aex_op(pow,pos,pos,pos).
aex_op(pow,pos,neg,pos).
aex_op(pow,_,0,pos).
aex_op(pow,neg,pos,top).
aex_op(pow,neg,neg,top).
aex_op(pow,neg,top,top).
aex_op(pow,top,_,top).


aex_op(*,0,_,0).
aex_op(*,pos,X,X).
aex_op(*,neg,0,0).
aex_op(*,neg,pos,neg).
aex_op(*,neg,neg,pos).
aex_op(*,neg,top,top).
aex_op(*,top,0,0).
aex_op(*,top,X,top) :- X\=0.

aex_op(mod,0,_,_) :- print('*** Division by zero ***'),nl,fail.
aex_op(mod,X,0,0) :- X\=0.
aex_op(mod,X,pos,top) :- X\=0. % actually 0 or pos
aex_op(mod,X,neg,top) :- X\=0. % actually 0 or neg
aex_op(mod,X,top,top) :- X\=0.

aex_op(+,0,X,X).
aex_op(+,pos,0,pos).
aex_op(+,pos,pos,pos).
aex_op(+,pos,neg,top).
aex_op(+,pos,top,top).
aex_op(+,neg,0,neg).
aex_op(+,neg,pos,top).
aex_op(+,neg,neg,neg).
aex_op(+,neg,top,top).
aex_op(+,top,_,top).


aex_op(-,X,0,X).
aex_op(-,_,top,top).
aex_op(-,top,X,top) :- X\=top.
aex_op(-,pos,pos,top).
aex_op(-,pos,neg,pos).
aex_op(-,neg,pos,neg).
aex_op(-,neg,neg,top).
aex_op(-,0,pos,neg).
aex_op(-,0,neg,pos).



% Redefinition of predicate from javabc_interpreter.pl:
test_op(<=,X,X).
test_op(<=,top,X) :- X \= top.
test_op(<=,neg,X) :- X \= neg.
test_op(<=,0,pos).
test_op(<=,0,top).
test_op(<=,pos,top).

test_op(<,top,_).
test_op(<,neg,_).
test_op(<,0,pos).
test_op(<,0,top).
test_op(<,pos,pos).
test_op(<,pos,top).

test_op(=,top,_).
test_op(=,X,top) :- X \= top.
test_op(=,0,0).
test_op(=,pos,pos).
test_op(=,neg,neg).
	
test_op('!=',X,Y) :- (X\=0 ; Y\=0).

test_op(>=,X,Y) :- test_op(<=,Y,X).
test_op(>,X,Y) :- test_op(<,Y,X).


% Redefinition of predicate from javabc_interpreter.pl:
false_op(<,A1,A2) :- test_op(>=,A1,A2).
false_op(>,A1,A2) :- test_op(<=,A1,A2).
false_op(<=,A1,A2) :- test_op(>,A1,A2).
false_op(>=,A1,A2) :- test_op(<,A1,A2).
false_op(=,A1,A2) :- test_op('!=',A1,A2).
false_op('!=',A1,A2) :- test_op(=,A1,A2).




/* --------------------------------------- */
/* The code generator */

gen_pop(env(Stack,_)) :- length(Stack,Len), print('LOAD_ab S'),print(Len). /* need to look up exact instruction */
gen_push(env(Stack,_)) :- length(Stack,Len), L1 is Len+1, print('STORE_ab S'),print(L1).
gen_push_const(env(Stack,_),Const) :- length(Stack,Len), L1 is Len+1,
     print('STOREimm_ab S'),print(L1), print(' '), print(Const).
gen_store(Var) :- print('STORE_ab V'),print(Var).
gen_load(Var) :- print('LOAD_ab V'),print(Var).

gencode(nop,_PC,_Size,_AEnv) :- print('nop').
gencode(return,_PC,_Size,_AEnv) :- print('hlt').
gencode(ireturn,_PC,_Size,env([_X],_)) :- print('hlt').
gencode(goto(Label),_PC,_Size,_AEnv) :- 
     /* if offset <255 use ppi otherwise load a+b and ppab or use xrg */
     gen_store(0),nl,
     print('xrg '), print(Label),nl,
     print('INSERT at destination '),gen_load(0).
gencode(istore(Var),_PC,_Size,AEnv) :-
    gen_pop(AEnv),nl,
    gen_store(Var).
gencode(pop,_PC,_Size,AEnv) :-
    gen_pop(AEnv).
gencode(iload(Var),_PC,_Size,AEnv) :-
    gen_load(Var),nl,
    gen_push(AEnv).
gencode(iconst(Const),_PC,_Size,AEnv) :- gen_push_const(AEnv,Const).
%gencode(if(OP,Label),_PC,_Size,AEnv) :- fail.
gencode(if1(OP,Cst,Label),_PC,_Size,AEnv) :-
    gen_pop(AEnv),nl,
    print('COMP_ab_imm '), print(OP), print(' '), print(Cst), nl,
    print('xrjal '), print(Label).
gencode(iop(OP),_PC,_Size,AEnv) :-
    gen_pop(AEnv),nl, AEnv = env([_|S2],LV),
    gen_pop(env(S2,LV)),nl,
    print(OP),nl, S2 = [_|S3],
    gen_push(env(S3,LV)).
gencode(iinc(Var,Offset),_PC,_Size,_AEnv) :- 
     print('LOAD_ab+i V'), print(Var), print('+'), print(Offset),nl,
     gen_store(Var).
gencode(println(_Var),_PC,_Size,_AEnv) :-  /* artificial opcode for debugging */
    print('nop').




:- nl,print('Use aint to run abstract interpreter'),nl.



