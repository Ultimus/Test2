% The Abstract Interpreter Loop
% and memoization table

% Following predicates need to be defined:
%  lub/3
%  abstract_value/2
%  aex_op/4
%  test_op/3, false_op/3

% ---------------------------------

:- dynamic memo/2, sol/2.

% The abstract interpreter loop:
aint :- check_abstract_operations,
        print('Starting ABSTRACT Interpretation'),nl,
        %execute(_X),
        fail.
aint :- print('FIXPOINT reached'),nl,
        print('ABSTRACT INFORMATION AT PROGRAM POINTS: '),nl,
        instr(PC,Opcode,_Size),memo(PC,AEnv),
        print(PC), print(' : '), print(Opcode), print(' : '), print(AEnv),nl,
    %    (gencode(Opcode,PS,Size,AEnv) -> true
    %       ; (nl,print(gencode_failed(Opcode,PS,_Size,AEnv)),nl)
    %    ),nl,
        fail.
aint :- nl,flush_output(user).

% ---------------------------------

% Some code to check the validity of the abstract operations

abstract_operation(*).
abstract_operation(-).
abstract_operation(+).

abstract_test(<=).
abstract_test(<).
abstract_test(=).
abstract_test('!=').

check_abstract_operations :-
  print('Checking abstract operations: '),
  abstract_operation(OP), print(OP), print(' '),
  check_abstract_operation(OP),fail.
check_abstract_operations :-
  abstract_test(OP), print(OP), print(' '),
  check_abstract_test(OP),fail.
check_abstract_operations :- nl.

check_abstract_operation(OP) :-
  abstract_domain_element(A),
  abstract_domain_element(B),
  (aex_op(OP,A,B,C)
     ->  ((aex_op(OP,A,B,C2),C2 \=C) -> 	
      nl,print('### Abstract Operation defined twice: '), print(OP),
      print(' for '), print(A), print(' '), print(B),
      print(' : '), print(C), print(' or '), print(C2),nl
           ; (abstract_domain_element(C) -> true
               ; nl,print('### Abstract Operation returns illegal value: '), print(OP),
	             print(' for '), print(A), print(' '), print(B),
	             print(' : '), print(C))
       )
     ;   nl,print('### Abstract Operation undefined: '), print(OP),
         print(' for '), print(A), print(' '), print(B),nl
  ),fail.
check_abstract_operation(_).

check_abstract_test(OP) :- 
  abstract_domain_element(A),
  abstract_domain_element(B),
  ((test_op(OP,A,B) ; false_op(OP,A,B))
     ->  true
     ;   nl,print('### Abstract Test undefined: '), print(OP),
         print(' for '), print(A), print(' '), print(B),nl
  ),fail.
check_abstract_test(_).

% ---------------------------------


% Patching the concrete interpreter


% Redefinition of predicate from javabc_interpreter.pl:
init_env(env([],[])) :- retractall(memo(_,_)).


% Redefinition of predicate from javabc_interpreter.pl:
push(env(S,Vars),Value,env([AV|S],Vars)) :-
   abstract_value(Value,AV).

% Redefinition of predicate from javabc_interpreter.pl:
store(env(Stack,Vars),Key,Value,env(Stack,NVars)) :-
    abstract_value(Value,AV),
    update(Vars,Key,AV,NVars).

% Redefinition of predicate from javabc_interpreter.pl:
ex_op(OP,A1,A2,R) :- abstract_value(A1,AV1),
	   abstract_value(A2,AV2),
	   aex_op(OP,AV1,AV2,R).

% Redefinition of predicate from javabc_interpreter.pl:
interpreter_loop(PC,In,_Out) :- print(PC), print(': '),
   lub_program_point(PC,In,AIn,Change),
   (Change=true -> 
     (instr(PC,Opcode,Size),
      NextPC is PC+Size,
      print(Opcode),print(' '), print(AIn),nl,
      ex_opcode(Opcode,NextPC,AIn,_)
     )
    ; print(fix(AIn)),nl
   ).


lub_program_point(PC,env(S,Vars),Res,Change) :- 
  (retract(memo(PC,env(SM,VarsM)))
     -> lub_stack(S,SM,SR), %print(lub_stack(PC,S,SM,SR)),
        lub_local_vars(Vars,VarsM,VarsR),
          % print(lub_local_vars(PC,Vars,VarsM,VarsR)),
        Res = env(SR,VarsR), assert(memo(PC,Res)),
        (Res=env(SM,VarsM) -> Change=false
           ; print(' <REANALYZE> '),Change = true)
     ;  assert(memo(PC,env(S,Vars))), 
        Res = env(S,Vars),
        Change=true
  ).

lub_stack([],[],[]).
lub_stack([],[_|_],_) :-
   nl,print('***'),nl,print('*** Illegal bytecode: Varying stack pattern at PC'),nl,print('***'),nl,nl,fail.
lub_stack([_|_],[],_) :-
  nl,print('***'),nl,print('*** Illegal bytecode: Varying stack pattern at PC'),nl,print('***'),nl,nl,fail.
lub_stack([H1|T1],[H2|T2], [H3|T3]) :-
   lub(H1,H2,H3),
   lub_stack(T1,T2,T3).
   
lub_local_vars([],X,X).
lub_local_vars([H|T],[],[H|T]).
lub_local_vars([Key/Val1|T1],[Key/Val2|T2],[Key/Val3|T3]) :- !,
   lub(Val1,Val2,Val3),
   lub_local_vars(T1,T2,T3).
lub_local_vars([Key1/Val1|T1],[Key2/Val2|T2],[H|T3]) :- Key1 \= Key2,
  (Key1 @<Key2 
    -> (H=Key1/Val1, lub_local_vars(T1,[Key2/Val2|T2],T3))
    ;  (H=Key2/Val2, lub_local_vars([Key1/Val1|T1],T2,T3))
  ).
