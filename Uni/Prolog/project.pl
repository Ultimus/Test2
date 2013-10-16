% Eingabe in String ohne Whitespace umwandeln 

clear_input(Input,Result):-
	clear_input(Input,[],Result),!.

clear_input([], Acc, Result):-
	reverse(Acc, Result).

clear_input([H|T], Acc, Result):-
	(
		H=9;
		H=10;
		H=13;
		H=32
	),
	clear_input(T,Acc, Result).

clear_input([H|T], Acc, Result):-
	clear_input(T,[H|Acc],Result).



/*** PARSER ***/


% parse(ProgrammSource, SyntaxTree)

parse(Input, AST):-
	clear_input(Input, Result),
	parse_statement(AST, Result,[]), !,
	search_loop(AST).


/******************************************
* Grammatik:

* S-> assignment | loop | if-else | pass
* assignment -> var() ":=" expression()
* var -> x (Number)
* number -> {0,...,9}number
* loop -> "LOOP" var "DO" instruction() "END"
* if -> "IF" expression() "=" expression() "THEN" instruction() "END" | "IF" expression() "=" expression() "THEN" instruction() "ELSE"   instruction() "END"
* expression -> term() "+" expression | term() "-" expression | factor()
* factor -> term() "*" factor() | term() "**" factor() | term()
* term -> number() | var() | "-" term | "(" expression() ")"

*********************************************/


% all statements are splitt by ';'

parse_statement(AST)--> assignment(AST). % assignments do not end with a ';'

parse_statement(AST)--> assignment(Praefix),       %assignments are splitt by ';'
			";",
			parse_statement(Suffix), 
			{AST=statement(Praefix,Suffix)}.

parse_statement(AST)--> loop(AST).

parse_statement(AST)--> loop(Praefix),
			";",
			parse_statement(Suffix), 
			{AST=statement(Praefix,Suffix)}.

parse_statement(AST)--> if(AST).

parse_statement(AST)--> if(Praefix),
			";",
			parse_statement(Suffix), 
			{AST=statement(Praefix,Suffix)}.

parse_statement(AST)--> pass(AST).

parse_statement(AST)--> pass(Praefix), 
	";", 
	parse_statement(Suffix), 
	{AST= statement(Praefix,Suffix)}.




assignment(AST)--> var(Praefix),
	":=",
	expression(Suffix),
	{AST=assign(Praefix,Suffix)}.

var(AST)-->"x",
	number(Num),
	{AST=id(Num)}.



loop(AST)-->"LOOP",
	var(Var),
	"DO",
	parse_statement(Statement),
	"END",
	{AST=loop(Var, Statement)}.
/*
if(AST)--> "IF",
	expression(Exp1),
	"=",
	expression(Exp2),
	"THEN",
	parse_statement(Inst),
	"END",
	{AST=if(Exp1,Exp2,Inst)}.
*/
% if_else

if(AST)-->"IF",
	expression(Leftexp),
	"=",
	expression(Rightexp),
	"THEN",
	parse_statement(LeftStatement),
	"ELSE",
	parse_statement(RightStatement),
	"END",
	{AST=if(Leftexp,Rightexp,LeftStatement,RightStatement)}.

pass(AST)--> "PASS", {AST = pass}. 

/*
* Prioritys: 
*		expression = low
* 		factor = middle
*		term = high
*/


expression(AST) --> factor(Factor), expression_(Factor,AST).

% expression_ changes the associativity in the syntax tree

expression_(Acc, AST) --> "+", !, factor(Factor), {Temp = add(Acc,Factor)}, expression_(Temp,AST).

expression_(Acc, AST) --> "-", !, factor(Factor), {Temp = sub(Acc, Factor)}, expression_(Temp,AST).

expression_(Acc, Acc) --> [].


% factor(AST) --> term(Term), factor(AST).

factor(AST) -->
	     term(Term),
	     "**",
	     factor(Fac),
 	     {AST=pow(Term,Fac)}.		% order changed

factor(AST) --> term(Term), "*", factor(Fac),{AST = mul(Term,Fac)}.

factor(AST) --> term(AST).

% Assoziativity is correct at pow


term(AST) --> number(AST).

term(AST) --> var(AST).

term(AST) --> "-",
		term(T),
		{AST=signed(T)}.

term(AST) --> "(",
		expression(Exp),
		")",
		{AST=bracket(Exp)}.
/*
number(AST) --> id(AST).
number(digit(D)) --> [D], {(number(D) ; var(D)), between(0,99999999999,D)}.
*/


number(AST) --> "0", 
		{AST=0}; 
		readnumber([], List), 
		{ 
		atomic_list_concat(List,X), 
		atom_number(X, AST) 
		}.


readnumber( Acc, Number )-->"1", {append([1], Acc, Number)}; 
			"2", {append([2], Acc, Number)};
			"3", {append([3], Acc, Number)};
			"4", {append([4], Acc, Number)};	
			"5", {append([5], Acc, Number)};	
			"6", {append([6], Acc, Number)};
			"7", {append([7], Acc, Number)};
			"8", {append([8], Acc, Number)};	
			"9", {append([9], Acc, Number)};
			"0", {append([0], Acc, Number)};
			% if the number contains more than one digit:
			"1", readnumber(Acc, Acc_),{append([1], Acc_,Number)};
			"2", readnumber(Acc, Acc_), {append([2], Acc_, Number)}; 
			"3", readnumber(Acc, Acc_), {append([3], Acc_, Number)}; 
			"4", readnumber(Acc, Acc_), {append([4], Acc_, Number)}; 
			"5", readnumber(Acc, Acc_), {append([5], Acc_, Number)}; 
			"6", readnumber(Acc, Acc_), {append([6], Acc_, Number)};
			"7", readnumber(Acc, Acc_), {append([7], Acc_, Number)}; 
			"8", readnumber(Acc, Acc_), {append([8], Acc_, Number)}; 
			"9", readnumber(Acc, Acc_), {append([9], Acc_, Number)}; 
			"0", readnumber(Acc, Acc_), {append([0], Acc_, Number)}.


% the following code searches for Loops in the AST and if it finds one triggers the check_loop_for_error  

/*** Search and find loops ***/

search_loop(add(_,_)).
search_loop(sub(_,_)).
search_loop(mul(_,_)).
search_loop(pow(_,_)).
search_loop(signed(_)).
search_loop(pass).
search_loop(bracket(_)).
search_loop(assign(_,_)).
search_loop(id(_)).

search_loop(if(_,_,FirstStatement,SecondStatement)) :-
	search_loop( FirstStatement),
	search_loop( SecondStatement).

search_loop(statement(Praefix, Suffix)) :-
	search_loop(Praefix),
	search_loop(Suffix).

search_loop( loop(id(Var), Statement)) :-
	check_loop_for_error( Var, Statement),!.



check_loop_for_error(Acc, id(Acc)) :- append([id], [Acc], X),
						atomic_list_concat(X,Y), 
						catch(throw(loop_variable_error(Y)), loop_variable_error, write('caught loop_variable_error')), 
						false, !, 
						fail.
% catch(throw(abc), abc, write('caught abc error')). does not work

/*** Check Loops for errors ***/

check_loop_for_error(Acc, statement(Praefix, Suffix)) :-
	check_loop_for_error(Acc, Praefix),
	check_loop_for_error(Acc, Suffix).

check_loop_for_error(Acc, assign(Praefix, Suffix)) :-
	check_loop_for_error(Acc, Praefix),
	check_loop_for_error(Acc, Suffix).

check_loop_for_error(Acc, add(Praefix,Suffix)) :-
	check_loop_for_error(Acc, Praefix),
	check_loop_for_error(Acc, Suffix).

check_loop_for_error(Acc, sub(Praefix,Suffix)) :-
	check_loop_for_error(Acc, Praefix),
	check_loop_for_error(Acc, Suffix).

check_loop_for_error(Acc, mul(Praefix,Suffix)) :-
	check_loop_for_error(Acc, Praefix),
	check_loop_for_error(Acc, Suffix).

check_loop_for_error(Acc, pow(Praefix,Suffix)) :-
	check_loop_for_error(Acc, Praefix),
	check_loop_for_error(Acc, Suffix).

check_loop_for_error(Acc, loop(id(Acc_), statement(Praefix, Suffix))) :-
	Acc_ \= Acc,
	check_loop_for_error(Acc_, Praefix),
	check_loop_for_error(Acc_, Suffix),
	check_loop_for_error(Acc, Praefix),
	check_loop_for_error(Acc, Suffix).

check_loop_for_error(Acc, loop(id(Acc_), Statement)) :-
	Acc_ \= Acc,
        check_loop_for_error(Acc_, Statement),
	check_loop_for_error(Acc, Statement).

check_loop_for_error(Acc,signed(Term)) :-
	check_loop_for_error(Acc, Term).

check_loop_for_error(_Acc, pass).
  
check_loop_for_error( Acc, id(Number)) :-
	Acc \= Number.

check_loop_for_error(_Acc, Number) :-
	number(Number).




/*** INTERPRETER ***/
% interpret(SyntaxTree, InputEnv, OutputEnv)



interpret(statement(Praefix, Suffix), Acc, Result) :-
	interpret(Praefix, Acc, Temp),
	interpret(Suffix, Temp, Result),!.

interpret(if(FirstExp, SecondExp, FirstInst, SecondInst), Acc, Result) :-
	interpret(FirstExp, Acc, Var),
	interpret(SecondExp, Acc, Var_),
	(
		Var = Var_ 
		->
		interpret(FirstInst,Acc,Result)
		;
		interpret(SecondInst,Acc,Result)
	).  % if else construction

interpret(loop(id(X), Statement), Acc, Result) :-
	search_for_variable(X,Acc,Loop),		% search for variable in input environment
	interpret_loop(Loop,Statement, Acc, Result).


interpret(assign(id(ID), Assignment), Acc, Result) :-
	interpret(Assignment, Acc, Value),
	save_variable(ID, Acc, Value, Result),!.		% save variable in output

interpret(Int, _Acc, Int) :-		
	integer(Int).

interpret(pass, Acc, Acc).

interpret(add(Praefix, Suffix), Acc, Result) :-
	interpret(Praefix, Acc, PraefixResult),
	interpret(Suffix, Acc, SuffixResult),
	Result is PraefixResult + SuffixResult.
 
interpret(sub(Praefix, Suffix), Acc, Result) :-
	interpret(Praefix, Acc, PraefixResult),
	interpret(Suffix, Acc, SuffixResult),
	Result is PraefixResult - SuffixResult.


interpret(mul(Praefix, Suffix), Acc, Result) :-
	interpret(Praefix, Acc, PraefixResult),
	interpret(Suffix, Acc, SuffixResult),
	Result is PraefixResult * SuffixResult.

interpret(pow(Praefix, Suffix), Acc, integer(Result)) :-		% pow in integer casten
	interpret(Praefix, Acc, PraefixResult),
	interpret(Suffix, Acc, SuffixResult),
	Result is PraefixResult ** SuffixResult.

interpret(signed(Input), Acc, Result) :-
	interpret(Input, Acc, Result_),
	Result is Result_ *(-1).

interpret(bracket(Input), Acc, Result) :-
	interpret((Input), Acc, Result).

interpret(id(X), Acc, Result) :-
	search_for_variable(X,Acc,Result).



interpret_loop(0, _Statement, _Acc, _Result). % end loop if variable is 0

interpret_loop(X, Statement, Acc, Result) :-
	Temp is X-1,
	interpret(Statement, Acc, Acc_),
	interpret_loop(Temp, Statement, Acc_, Result).





% variable predicates (search, save and remove)

search_for_variable(Var, [(id(Var), num(Number) )|_T],Number).

search_for_variable( Var, [(id(_N), num(_Assignment))|T], Result):-
	search_for_variable( Var, T, Result),!.

search_for_variable( Var, [], _Result):-
	append([id], [Var], Temp),
 	atomic_list_concat(Temp,X), 
	throw(id_not_found_error(X)),
	fail,!.


save_variable(ID, [], Assign, [(id(ID), num(Assign))]).

save_variable(ID, AccList, Assign, [(id(ID), num(Assign))| NewList]):-
	remove_variable(ID, AccList, NewList),!.			% each variable should just be once in the output



% remove_variable(_Var, [], []).

remove_variable(Var, AccList, Result) :-
	remove_variable(Var, AccList, [], Result).

remove_variable(_Var, [], Acc, Acc).

remove_variable(Var, [(id(ID), num(Number))|T], Acc, Result) :-
	Var \= ID,
	remove_variable(Var, T, [(id(ID), num(Number))|Acc], Result).

remove_variable(Var, [(id(Var), num(_Number))|T], Acc, Result) :-
	append(Acc, T, Result).





%%% TESTS %%%

test_wrapper(Test) :-
	write(Test), write(' ...'),
	(
	call(Test), 
	write('success'),nl
	;
	write('fail'),nl
	).


	
	

test_parse :-
	parse("x0 := 1", T),
	T == assign(id(0), 1).

test_parse_2 :-
	parse("x1 := 777", T),
	T == assign(id(0), 11),
	write('.'), nl.

test_parse_3 :-
	parse("x1 := x2", T),
	T == assign(id(1), id(2)).


test_parse_4 :-
	parse("x1 := 4 + 5",T),
	T == assign(id(1), add(4, 5)).

test_parse_5 :-
	parse("x0 := 88 - 66",T),
	T == assign(id(0), sub(88,66)).

test_parse_6 :- 
	parse("x0 := 77 * 99",T),
	T == assign(id(0), mul(77, 99)).

test_parse_7 :-
	parse("x0 := 55 ** 101",T),
	T == assign(id(0), pow(55, 101)).

test_parse_8 :-
	parse("x0 := 55 ** 101 ** 202",T),
	T == assign(id(0), pow(55, pow(101, 202))).

test_parse_9 :-
	parse("LOOP x1 DO x2 := x2 + x3 END", T),
	T == loop(id(1), assign(id(2), add(id(2), id(3)))).

test_parse_10 :-
	parse("LOOP x1 DO LOOP x2 DO x3:= 99 END END",T),
	T == loop(id(1), loop(id(2), assign(id(3), 99))).

test_parse_11 :-
	parser("IF x0 = x1 THEN x0 := 17 ELSE x0 := 16 END", T),
	T == if(id(0), id(1), assign(id(0), 17), assign(id(0), 16)).

test_parse_12 :-
	parse("LOOP x1 DO PASS END",T),
	T == loop(id(1), pass).

test_parse_13 :-
	parse("LOOP x1 DO LOOP x2 DO x2 := 5**8 END END",T),
	T == loop(id(1), loop(id(2), assign(id(2), pow(5, 8)))).



test_search_loop :-
	search_loop(id(5)).

test_search_loop_2 :-
	search_loop(assign(id(5), 7)).

test_search_loop_3 :-
	search_loop(mul(5,7)).

test_search_loop_4 :-
	search_loop(if(id(4), id(1), assign(id(0), 17), statement(assign(id(0), 16), assign(id(1), add(signed(1), mul(bracket(sub(17, signed(signed(4)))), 5)))))).


test_search_loop_5 :-
	T = loop(id(1), statement(assign(id(0), 2), statement(assign(id(0), add(mul(id(2), id(3)), 1)), statement(pass, assign(id(0), mul(2, 3)))))),
	search_loop(T).



test_check_loop_for_error_1 :-
	check_loop_for_error(mul(5,7)).

test_check_loop_for_error_2 :-
	search_loop(statement(loop(id(1), assign(id(2), add(id(2), 1))), loop(id(1), assign(id(2), add(id(2), 2))))).




test_interpret_1 :-
	interpret(statement(assign(id(1), 1), assign(id(2), 2)), [], Out),
Out = [ (id(2), num(2)), (id(1), num(1))].


test_interpret_2 :-
	P = "x0 := 1 + 2 * 3 ** 4 ",
        parse(P, T),
        interpret(T, [], Out),
P = [120, 48, 32, 58, 61, 32, 49, 32, 43|...],
T = assign(id(0), add(1, mul(2, pow(3, 4)))),
Out = [ (id(0), num(163))].



test_interpret_3 :-
	parse("x1 := 2**3**4",T),
	interpret(T,[], Out),
	Out = [(id(1), num(integer(2417851639229258349412352)))].

test_interpret_4 :- % test for if statements
	interpret(statement(assign(id(0), 0), if(id(0), 0, assign(id(0), add(id(0), 1)), assign(id(0), add(id(0), 2)))),[],Out),
	Out = [ (id(0), num(1))].

test_interpret_5 :- %fibonacci
	P = "x1 := 0; x2 := 1;
         IF x0 = 0 THEN PASS ELSE
             LOOP x0 DO
                x3 := x2;
                x2 := x2 + x1;
                x1 := x3
         END END",
    parse(P, T),
    interpret(T, [(id(0), num(5))], _Out),
	P = [120, 49, 32, 58, 61, 32, 48, 59, 32|...],
	T = statement(assign(id(1), 0), statement(assign(id(2), 1), if(id(0), 0, pass, loop(id(0), statement(assign(id(3), id(2)), statement(assign(id(2), add(id(2), id(1))), assign(id(1), id(3)))))))).
	
	








run_all_tests :-
	nl, nl, write('Running tests ...'), nl, nl,
	test_parse,
	test_parse_2,
	test_parse_3,
	test_parse_4,
	test_parse_5,
	test_parse_6,
	test_parse_7,
	test_parse_8,
	test_parse_9,
	test_parse_10,
	test_parse_11,
	test_parse_12,
	test_parse_13,
	test_search_loop,
	test_search_loop_2,
	test_search_loop_3,
	test_search_loop_4,
	test_search_loop_5,
	test_check_loop_for_error_1,
	test_check_loop_for_error_2,
	test_interpret_1,
	test_interpret_2,
	test_interpret_3,
	test_interpret_4,
	test_interpret_5.





/*factor(AST) --> term(Term).

factor(AST) --> term(Term), "**", factor(Factor),{AST = pow(Term, Factor)}.

factor(AST) --> term(Praefix),
	      "*",
	      factor(Suffix),
	      {AST=mul(Praefix,Suffix)}.


factor(AST) -->
	     term(Term),
	     "**",
	     factor(Fac),
 	     {AST=pow(Fac,Term)}.

factor(AST) --> term(AST).

factor_(Acc,AST) --> [].

factor_(Acc, AST) --> "*", !, term(Term), {Temp = mul(Acc, Term)}, factor_(Temp, AST).

*/
