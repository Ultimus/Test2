parse(String, Ast):-
	parse_1(Ast,String,[]),!.

parse_1(add(N,Ast))--> parse_2(N),"+",parse_1(Ast).
parse_1(sub(N,Ast))--> parse_2(N),"-", parse_1(Ast).
parse_1(Ast)--> parse_2(Ast).

parse_2(mul(N,Ast))--> parse_3(N), "*", parse_1(Ast).
parse_2(Ast) --> parse_3(Ast).

parse_3(exp(N,Ast))--> number(N),"^", parse_1(Ast).
parse_3(N)--> number(N).
parse_3([])--> [].
	
digit_([N]) --> digit(N).
digit_([N|N1]) --> digit(N), digit_(N1).

number(Ast)--> digit_(N), {name(Conc,N), Ast=Conc}.

digit(48) --> "0".
digit(49) --> "1".
digit(50) --> "2".
digit(51) --> "3".
digit(52) --> "4".
digit(53) --> "5".
digit(54) --> "6".
digit(55) --> "7".
digit(56) --> "8".
digit(57) --> "9".














/*
digit(0) --> "0".
digit(1) --> "1".
digit(2) --> "2".
digit(3) --> "3".
digit(4) --> "4".
digit(5) --> "5".
digit(6) --> "6".
digit(7) --> "7".
digit(8) --> "8".
digit(9) --> "9".*/

