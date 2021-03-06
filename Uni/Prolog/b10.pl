:- use_module(library(plunit)).


:- begin_tests(difference_lists).

test(list_to_dl) :-
	list_to_dl([], L1), L1 =@= X1-X1,
	list_to_dl([1], L2), L2 =@= [1|X2]-X2,
	list_to_dl([1, 2], L3), L3 =@= [1, 2|X3]-X3,
	list_to_dl([1, 2, 3], L4), L4 =@= [1, 2, 3|X4]-X4.

test(dl_append) :-
	dl_append([1, 2|X]-X, [3, 4|Y]-Y, L1), L1 == [1, 2, 3, 4|Y]-Y.
/*
test(dl_to_list) :-
	dl_to_list(X-X, L1), L1 == [],
	dl_to_list([1|Y]-Y, L2), L2 == [1],
	dl_to_list([1, 2|Z]-Z, L3), L3 == [1, 2].

:- end_tests(difference_lists).


:- begin_tests(parentheses).

test(simple) :-
	parse_pars("()", 1),
	parse_pars("(<>)", 2),
	\+ parse_pars("{{})", _),
	parse_pars("(([]<>))", 4),
	parse_pars("(<>)<[]>[{}]{()}", 8).

:- end_tests(parentheses).


:- begin_tests(logic).

test(basic) :-
    parse_logic("true", T1), T1 == true,
    parse_logic("false", T2), T2 == false.

test(or) :-
    parse_logic("true or true", T1), T1 == or(true, true),
    parse_logic("true or true or false", T2), 
    T2 == or(or(true, true), false).

test(and) :-
    parse_logic("true and true", T1), T1 == and(true, true),
    parse_logic("true and true and false", T2), 
    T2 == and(and(true, true), false).

test(precedence) :-
    parse_logic("true and false or true", T1),
    T1 == or(and(true, false), true),
    %
    parse_logic("true or false and true", T2),
    T2 == or(true, and(false, true)).

test(parentheses) :-
    parse_logic("true or (false or true)", T1),
    T1 == or(true, or(false, true)),
    %
    parse_logic("(true or false) or true", T2),
    T2 == or(or(true, false), true).

test(not) :-
    parse_logic("not(true and false)", T),
    T == not(and(true, false)).

:- end_tests(logic).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

*/
% list_to_dl(List, DL)
	
list_to_dl(List,DL):-
	append(List, X-X,DL).


% dl_append(DL1,DL2,DL3)

dl_append(DL1-DL2,DL2-DL3,DL1-DL3).

% dl_to_list(DL, List)

entferne(_, [], []).
entferne(X, [X|Rest], Neue):-
       entferne(X, Rest, Neue).
entferne(X, [Y|Rest], [Y|Neue]):-
       X\=Y, entferne(X, Rest, Neue).


% parse_pairs(Source,NumPairs)

parse_pairs([],0).
parse_pairs(Source,NumPairs):-
	parse_pairsS(Source,_Stack,NumPairs).

parse_pairsS([],_,0):-!.
parse_pairsS([H|T],[HS|TS],NumPairs):-
	(	H==40->
		parse_pairsS(T,[H,HS|TS],NumPairs)
	;
		H==41,HS==40->
		Acc is Numpairs+1,
		parse_pairsS(T,TS,Acc)
	).
	

% parse_logic(Source).

parse_logic("true").
parse_logic("false"):-fail,!.

parse_logic([H|T]):-
	parse_logic(H),"and",parse_logic(T).
	
			
