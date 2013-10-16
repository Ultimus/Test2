:- module(javabc_parser,[parse/0,parse1/0,parse2/0,parse3/0, parse4/0,
                         parse/1,parse_byc_file/1, instr/3, gen_pl/0]).

parse :-
  parse('~/svn_root/TEX/Decco/JavaBC/Power.byc').
parse1 :-
  parse('~/svn_root/TEX/Decco/JavaBC/PowerNeq.byc').
parse2 :-
  parse('~/svn_root/TEX/Decco/JavaBC/ModuloCalc.byc').
parse3 :-
  parse('~/svn_root/TEX/Decco/JavaBC/PowerWithFun.byc').
parse4 :-
  parse('~/svn_root/TEX/Decco/JavaBC/JavaTests/SimpleDFA.byc').

parse(X) :- parse_byc_file(X).
parse_byc_file(File) :-
   print_message(informational,opening(File)),
   see(File),read_file(Txt),seen,
   print_message(informational,read(File)),
   %print(Txt),nl,
   reset,
   print_message(informational,starting_parse),
   program(Txt,[]),!,
   flush_output(user),
   print_message(informational,finished_parsing(File)),
   gen_pl.
parse_byc_file(_) :- print('### Parsing Failed !'),nl.

read_file(Txt) :-
   get_code(CharCode),
   (CharCode<0 -> Txt = []
    ; (Txt = [CharCode|T],
	   read_file(T)
	 )
   ).
   
 
reset :- retractall(instr(_,_,_)), reset_line_count.
              

:- dynamic instr/3.

list :- print('----'),nl,
        instr(Nr,Instr,_Size),
        print(Nr), print(': '), print(Instr),nl,fail.
list :- print('----'),nl,
        flush_output(user).
        

gen_pl :- print('/* Prolog Encoding of Byte Code */'),nl,
          instr(Nr,Instr,Size),
          print(instr(Nr,Instr,Size)), print('.'),nl,
          fail.
gen_pl :- print('/* End of Prolog Encoding */'),nl.


program --> labelled_instr(Nr,Inst,Size),!, {assert(instr(Nr,Inst,Size))},
             %% {print(Nr), print(': '), print(Inst),nl}, %%
             program.
program --> ws,!,program.
program([_|_],_) :- !,print('### Could not find instruction label '), print_line_count, nl. 
program --> "".


labelled_instr(Nr,Inst,Size) -->  label(Nr),!,  %% {print(label(Nr)),nl}, %%
       instr_after_label(Inst,Size).
       
instr_after_label(Inst,Size) --> instr(Inst,Size),!.
instr_after_label(_,_) --> 
    {print('### Could not find valid instruction ')}, {print_line_count}, {nl}, {fail}.

% whitespace
ws --> [13],!, {increment_line_count}, optws.
ws --> [10],!, {increment_line_count}, optws.
ws --> [9],!, optws.
ws --> " ",!, optws.

% Optional whitespace
optws --> [13],!, {increment_line_count}, optws.
optws --> [10],!, {increment_line_count}, optws.
optws --> [9],!,   optws.
optws --> " ",!,   optws.
optws --> "".

label(Nr) --> optws,labelnr(Nr),":",optws.

natural(Prev,Nr) --> digit(Dig),!, {P2 is Prev*10+Dig}, natural(P2,Nr).
natural(Prev,Nr) -->  {Prev=Nr}.


/* instr(PrologOpCode,ByteSize) */
instr(iconst(Int),1) --> "iconst_", digitft(0,5,Int),!.
instr(iconst(-1),1) --> "iconst_m1",!.
instr(iconst(Int),3) --> "sipush", ws, integer(Int),!.  /* treat sipush as iconst */
instr(iconst(Int),2) --> "bipush", ws, integer(Int),!.  /* treat bipush as iconst */
instr(iload(Reg),1) --> "iload_", digitft(0,3,Reg),!.
instr(iload(Reg),2) --> "iload", ws, registernr(Reg),!.
instr(istore(Reg),1) --> "istore_", digitft(0,3,Reg),!.
instr(istore(Reg),2) --> "istore", ws, registernr(Reg),!.
instr(if(=,Label),3) --> "if_icmpeq", ws, labelnr(Label),!.
instr(if(\=,Label),3) --> "if_icmpne", ws, labelnr(Label),!.
instr(if(<,Label),3) --> "if_icmplt", ws, labelnr(Label),!.
instr(if(>=,Label),3) --> "if_icmpge", ws, labelnr(Label),!.
instr(if(>,Label),3) --> "if_icmpgt", ws, labelnr(Label),!.
instr(if(<=,Label),3) --> "if_icmple", ws, labelnr(Label),!.
instr(if1(=,0,Label),3) --> "ifeq", ws, labelnr(Label),!.
instr(if1(\=,0,Label),3) --> "ifne", ws, labelnr(Label),!.
instr(if1(<,0,Label),3) --> "iflt", ws, labelnr(Label),!.
instr(if1(>=,0,Label),3) --> "ifge", ws, labelnr(Label),!.
instr(if1(>,0,Label),3) --> "ifgt", ws, labelnr(Label),!.
instr(if1(<=,0,Label),3) --> "ifle", ws, labelnr(Label),!.
instr(goto(Label),3) --> "goto", ws, labelnr(Label),!.
instr(iop(*),1) --> "imul",!.
instr(iop(+),1) --> "iadd",!.
instr(iop(-),1) --> "isub",!.
instr(iop(mod),1) --> "irem",!.
instr(return,1) --> "return",!.
instr(ireturn,1) --> "ireturn",!.
instr(nop,1) --> "nop",!.
instr(pop,1) --> "pop",!.
instr(iinc(Reg,Inc),3) --> "iinc", ws, registernr(Reg),optws,",",optws, integer(Inc),!.

instr(println(Reg),2) --> "println", ws, registernr(Reg),!.  % artificial opcode for debugging

integer(Nr) --> "-",!,natural(0,NN), {Nr is 0-NN}.
integer(Nr) --> natural(0,Nr).

labelnr(Nr) --> natural(0,Nr).

registernr(Nr) --> natural(0,Nr).

digitft(From,To,Dig) --> digit(Dig), {Dig >= From, Dig =< To}.

digit(0) --> "0".
digit(1) --> "1".
digit(2) --> "2".
digit(3) --> "3".
digit(4) --> "4".
digit(5) --> "5".
digit(6) --> "6".
digit(7) --> "7".
digit(8) --> "8".
digit(9) --> "9".



/* ------------- */
/* line counting */
/* ------------- */

:- dynamic cur_line_number/1.
cur_line_number(1).

print_line_count :-
   cur_line_number(N),
   print('at line '), print(N), print(' ').
  
increment_line_count :-
   retract(cur_line_number(N)),
   N1 is N +1,
   assert(cur_line_number(N1)).
   
reset_line_count :-
   retract(cur_line_number(_N)),
   assert(cur_line_number(1)).
   
   