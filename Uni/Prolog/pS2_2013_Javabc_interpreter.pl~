
:- use_module(javabc_parser).

% contains also instr/3 facts

%:- use_module(basic_blocks).
%:- use_module(dataflow).

run(Out) :- parse, execute(Out).
bb1 :- parse, bb.
df :- dataflow_analysis.
df1 :- parse, dataflow_analysis.
run1(Out) :- parse1, execute(Out).
run2(Out) :- parse2, execute(Out).

execute(Output) :- execute([],Output). % Parameters should be [0/Para1,...]
execute(Parameters,Output) :- statistics(runtime,_),
   init_env(Parameters,Start),
   interpreter_loop(0,Start,Output),
   statistics(runtime,[_T1,T2]),
   print(runtime_ms(T2)),nl,
   flush_output(user).


interpreter_loop(PC,In,Out) :-
     print('> '),print(PC), print('   '), print(In), %%
	instr(PC,Opcode,Size), !,
	NextPC is PC+Size,
	 print('  --> '),print(Opcode),nl, %%
	ex_opcode(Opcode,NextPC,In,Out).
interpreter_loop(PC,_In,_Out) :-
    print('*** Unknown instruction label: '), print(PC),nl,
	fail.

ex_opcode(nop,NextPC,In,Out) :- interpreter_loop(NextPC,In,Out).
ex_opcode(return,_,Env,Env).
ex_opcode(ireturn,_,In,Out) :- pop(In,Ret,Out),
   print('Return value: '), print(Ret),nl.
ex_opcode(goto(Label),_,In,Out) :-
    interpreter_loop(Label,In,Out).
ex_opcode(istore(Var),NextPC,In,Out) :-
    pop(In,Top,In2),
    store(In2,Var,Top,Out2),
    interpreter_loop(NextPC,Out2,Out).
ex_opcode(pop,NextPC,In,Out) :-
    pop(In,_Discarded,Out2),
    interpreter_loop(NextPC,Out2,Out).
ex_opcode(iload(Var),NextPC,In,Out) :-
    load(Var,In,Val),
    push(In,Val,Out2),
    interpreter_loop(NextPC,Out2,Out).
ex_opcode(iconst(Const),NextPC,In,Out) :-
    push(In,Const,Out2),
    interpreter_loop(NextPC,Out2,Out).
ex_opcode(if(OP,Label),NextPC,In,Out) :-
    pop(In,RHSVAL1,In1),
    pop(In1,RHSVAL2,In2),
    if_then_else(OP,RHSVAL1,RHSVAL2,Label,NextPC,In2,Out).
ex_opcode(if1(OP,Cst,Label),NextPC,In,Out) :-
    pop(In,RHSVAL1,In2),
    if_then_else(OP,RHSVAL1,Cst,Label,NextPC,In2,Out).
ex_opcode(iop(OP),NextPC,In,Out) :-
    pop(In,RHSVAL1,In1),
    pop(In1,RHSVAL2,In2),
    ex_op(OP,RHSVAL1,RHSVAL2,Res),
    push(In2,Res,Out2),
    interpreter_loop(NextPC,Out2,Out).
ex_opcode(iinc(Var,Offset),NextPC,In,Out) :-
    load(Var,In,Val),
    ex_op(+,Val,Offset,Res),
    store(In,Var,Res,Out2),
    interpreter_loop(NextPC,Out2,Out).
ex_opcode(println(Var),NextPC,In,Out) :-  /* artificial opcode for debugging */
    load(Var,In,Val),
    print('Value of variable '), print(Var), print(' = '), print(Val),nl,
    interpreter_loop(NextPC,In,Out).
    
if_then_else(OP,Arg1,Arg2,TrueLabel,_FalseLabel,In,Out) :-
    test_op(OP,Arg1,Arg2), %print(test_op(OP,Arg1,Arg2)),nl,
    interpreter_loop(TrueLabel,In,Out).
if_then_else(OP,Arg1,Arg2,_TrueLabel,FalseLabel,In,Out) :-
    false_op(OP,Arg1,Arg2),
    interpreter_loop(FalseLabel,In,Out).

ex_op(OP,A1,A2,R) :- ex_op_concrete(OP,A1,A2,R).

%addition

ex_op_abstract(+,pos,pos,pos).
ex_op_abstract(+,pos, neg, top).
ex_op_abstract(+,pos,zero,pos).
ex_op_abstract(+,zero,pos,pos).
ex_op_abstract(+,neg,neg,neg).
ex_op_abstract(+,neg,zero,neg).
ex_op_abstract(+,zero,neg,neg).

%subtraction

ex_op_abstract(-,pos,pos,top).
ex_op_abstract(-,neg,neg, top).
ex_op_abstract(-, pos, zero, pos).
ex_op_abstract(-, neg,zero, neg).
ex_op_abstract(-, zero, neg, pos).
ex_op_abstract(-,zero,pos, neg).
ex_op_abstract(-,pos,neg, pos).
ex_op_abstract(-,neg,pos, neg).



%multiplikation

ex_op_abstract(*,pos,pos,pos).
ex_op_abstract(*,pos,neg,neg).
ex_op_abstract(*,neg,pos,neg).
ex_op_abstract(*,pos,zero,zero).
ex_op_abstract(*,zero,pos,zero).
ex_op_abstract(*,zero,neg,zero).
ex_op_abstract(*,neg,neg,pos).
ex_op_abstract(*, neg, zero,zero).


%modulo
ex_op_abstract(mod,pos,pos,pos).
ex_op_abstract(mod, pos,neg, neg).
ex_op_abstract(mod,neg,neg,neg).
ex_op_abstract(mod, neg, pos, pos).
ex_op_abstract(mod, zero, _, zero).
ex_op_abstract(mod, _, zero, bottom).
 

  
/*
ex_op_concrete(*,A1,A2,R) :- R is A1 * A2.
ex_op_concrete(+,A1,A2,R) :- R is A1 + A2.
ex_op_concrete(-,A1,A2,R) :- R is A1 - A2.
ex_op_concrete(mod,A1,A2,R) :- R is A2 mod A1.
*/
test_op(OP,A1,A2) :- test_op_abstract(OP1,A1,A2,Result). %test_op_concrete(OP,A1,A2).

test_op_abstract(=,A1,A2,top) :- A1 = A2.
test_op_abstract('!=',A1,A2,top) :- A1 \= A2.
test_op_abstract(<,A1,A2, top) :- A1 < A2.
test_op_abstract(>,A1,A2, top) :- A1 > A2.
test_op_abstract(<=,A1,A2, bottom) :- A1 =< A2.
test_op_abstract(>=,A1,A2, bottom) :- A1 >= A2.

/*
test_op_concrete(=,A1,A2) :- A1 = A2.
test_op_concrete('!=',A1,A2) :- A1 \= A2.
test_op_concrete(<,A1,A2) :- A1 < A2.
test_op_concrete(>,A1,A2) :- A1 > A2.
test_op_concrete(<=,A1,A2) :- A1 =< A2.
test_op_concrete(>=,A1,A2) :- A1 >= A2.
*/
false_op(OP,A1,A2) :- false_op_concrete(OP,A1,A2).
/*
false_op_concrete(=,A1,A2) :- A1 \= A2.
false_op_concrete('!=',A1,A2) :- A1 = A2.
false_op_concrete(<,A1,A2) :- A1 >= A2.
false_op_concrete(>,A1,A2) :- A1 =< A2.
false_op_concrete(<=,A1,A2) :- A1 > A2.
false_op_concrete(>=,A1,A2) :- A1 < A2.
*/



/* --------------------------------------- */
/*  Generic Environment Related Predicates */
/* --------------------------------------- */

init_env(Parameters,env([],Parameters)). % Parameters should be [0/Para1,...]

pop(env([X|S],Vars),Top,R) :- !, Top=X, R=env(S,Vars).
pop(E,_,_) :- print('*** Could not pop from stack: '),print(E),nl,fail.

push(env(S,Vars),X,env([X|S],Vars)).

store(env(Stack,Vars),Key,Value,env(Stack,NVars)) :-
    update(Vars,Key,Value,NVars).
    
load(Key,env(_S,Env),Val) :- lookup(Key,Env,Val).

/* --------------------------------------- */


/* update(OldEnv, VariableName, NewValue, NewEnv) */
update([],Key,Value,[Key/Value]).
update([Key/_Value2|T],Key,Value,[Key/Value|T]).
update([Key2/Value2|T],Key,Value,Res) :- Key2 \= Key,
   (Key @< Key2 -> Res = [Key/Value, Key2/Value2|T]
              ;  (Res = [Key2/Value2|BT], update(T,Key,Value,BT))
   ).

/* lookup(VariableName, Env, CurrentValue) */
lookup(Key,[],_) :- print('*** could not find variable: ') ,print(Key),nl,
     Value=undefined.  /* This can be due to parameters which are passed as variables  0..n-1 */
lookup(Key,[Key/Value|_T],Value).
lookup(Key,[Key2/_Value2|T],Value) :-
   (Key @> Key2 -> lookup(Key,T,Value) ; 
     Key \= Key2 -> print('*** could not find variable: ') ,print(Key),nl,Value=undefined).

% --------------------------------

consult_without_redefine_warning(File) :-
    prolog_flag(redefine_warnings, Old, off),
    prolog_flag(single_var_warnings, Old2, off),
    (consult(File)
    -> OK=true ; OK=false),
    prolog_flag(redefine_warnings, _, Old),
    prolog_flag(single_var_warnings, _, Old2),
    OK=true.

%switch :- consult_without_redefine_warning('alternate_environment.pl').
abstract :- consult_without_redefine_warning('abstract_environment.pl').
%abstractnd :- consult_without_redefine_warning('abstract_environment_non_det.pl').
cp :- consult_without_redefine_warning('abstract_constpropagation.pl').
bta :- consult_without_redefine_warning('abstract_bta.pl').
