:-use_module(javabc_parser).
:- dynamic currentPc/1.  %aktueller Programmcounter


analyse(Output) :- 
	init_env(Start),
	assert(currentPc(0)), %pc wird mit 0 initialisert um beim Beginn der Java bc Datei zu starten
	analyse_loop(0,Start,Output),
	flush_output(user).




analyse_loop(Pc,In,Out):- 
	retract(currentPc(_)),
	assert(currentPc(Pc)),
	instr(Pc,Code,Size),
	NextPc is Pc+Size,
	analyse_code(Code, NextPc, In,Out).

analyse_loop(Pc,_,_):- print('<<<<<<<Unknown Instruction Label: '), print(Pc), nl, fail.




analyse_code(nop,NextPc,In,Out) :- analyse_loop(NextPc, In, Out).  
analyse_code(return, _, Env, Env).
analyse_code(ireturn, _,In, Out):- pop(In, _, Out).
analyse_code(goto(_Label), Pc, In, Out):- analyse_loop(Pc, In, Out).
analyse_code(istore(Var), NextPc, In, Out):-    pop(In,_,In2), 	
					        currentPc(Pc),	
						store(In2, Var, defined(Pc), Out2), %wird istore aufgerufen, dann ist die Variable zumindest definiert
						analyse_loop(NextPc, Out2, Out).

analyse_code(pop, NextPc, In, Out):-
					pop(In, _, Out2),
					analyse_loop(NextPc, Out2, Out).

analyse_code(iload(Var), NextPc, In, Out):-	%wenn iload aufgerufen wird auf eine nicht existente variable wird sie mit "not_defined" gekennzeichnet
						load(Var, In, Val),
						currentPc(Pc),
						(
						Val = not_defined
						->
						store(In,Var,not_defined(Pc), Out2);
						store(In,Var,used,Out2)	%wenn dia Variable bereits definiert ist, wird sie durch iload benutzt und bekommt den Tag used
						),
						push(Out2,_,Out3),
						analyse_loop(NextPc,Out3,Out).


analyse_code(iconst(Const),NextPc,In,Out):-
						push(In,Const,Out2),
						analyse_loop(NextPc, Out2, Out).

analyse_code(if(_Op,_Label), NextPc, In, Out):-
						pop(In,_Val1, In1),
						pop(In1, _Val2, Out2),
						analyse_loop(NextPc, Out2, Out).

analyse_code(if1(_Op,_Constant,_Label), NextPc, In, Out):-
						pop(In,_Val1,Out2),
						analyse_loop(NextPc, Out2, Out).


analyse_code(iop(Op), NextPc, In, Out):-
						pop(In,Val1, In1),
						pop(In1, Val2,In2),
						analyse_code(Op,Val1,Val2,Result),
						push(In2,Result, Out2),
						analyse_loop(NextPc, Out2, Out).

analyse_code(iinc(Var,_Offset), NextPc, In, Out):-
						load(Var, In, _Val),
						store(In, Var, used, Out2),
						analyse_loop(NextPc, Out2, Out).

analyse_code(println(Var), Pc, In, Out):-
						load(Var, In, _Val),
						store(In, Var, used, Out2),
						analyse_loop(Pc, Out2, Out).

%iinc und println ändern den Tag einer Variable auf used

analyse_code(_,used,_,used).
analyse_code(_,_,used,used).
analyse_code(_,defined,_,used).
analyse_code(_,_,defined,used).
%alle anderen operationen sind unwichtig

/* --------------------------------------- */
/*  Generic Environment Related Predicates */
/* --------------------------------------- */

init_env(env([],[])).

pop(env([X|S], Vars), Top, Result) :- !, Top=X, Result=env(S,Vars).
pop(_,_,_):- fail.

push(env(S,Vars), X, env([X|S], Vars)).

store(env(Stack, Vars), Key, Value, env(Stack, NewVars)):-
						update(Vars, Key, Value, NewVars).

load(Key,env(_S,Env),Val):-lookup(Key,Env,Val).

update([],Key,Value,[Key/Value]).
update([Key/_Value|T],Key,Value,[Key/Value|T]). %Variable neuen Wert zuweisen
update([Key/Value|T], Key1, Value1, Res):-
						Key\=Key1,
						(Key1@<Key 
						->
						Res= [Key1/Value1, Key/Value|T];
						Res= [Key/Value|BT], update(T, Key1, Value1, BT)
						).

lookup(_Key,[], not_defined). %Wenn die variable noch nicht in der Liste vorkommt ist sie not_defined
lookup(Key, [Key/Value|_T],Value).
lookup(Key, [Key1/_Value1|T], Value):- Key @> Key1, lookup(Key,T,Value).


consult_without_redefine_warning(File) :-
    prolog_flag(redefine_warnings, Old, off),
    prolog_flag(single_var_warnings, Old2, off),
    (consult(File)
    -> OK=true ; OK=false),
    prolog_flag(redefine_warnings, _, Old),
    prolog_flag(single_var_warnings, _, Old2),
    OK=true.

abstract :- consult_without_redefine_warning('abstract_environment.pl').
cp :- consult_without_redefine_warning('abstract_constpropagation.pl').
bta :- consult_without_redefine_warning('abstract_bta.pl').
				






								
	
