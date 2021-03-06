/*:- begin_tests(gray_code).

% predicates needed for test
one_bit_different(Bits1, Bits2) :-
    one_bit_different(Bits1, Bits2, 0).
one_bit_different([], [], 1).
one_bit_different([B1|Bits1], [B2|Bits2], NumDiff) :-
    (B1 == B2
    ->
        one_bit_different(Bits1, Bits2, NumDiff)
    ;
        NumDiff1 is NumDiff + 1,
        one_bit_different(Bits1, Bits2, NumDiff1)
    ).

check_gray_code([H|T]) :-
    check_gray_code([H|T], H).
check_gray_code([H], First) :-
    !, one_bit_different(H, First).
check_gray_code([H1|[H2|T]], First) :-
    one_bit_different(H1, H2),
    check_gray_code([H2|T], First).

generator(N, N, [N]) :- !.
generator(A, B, [A|R]) :-
    A < B,
    A1 is A + 1,
    plunit_gray_code:generator(A1, B, R).

test(gray_code_1) :-
    gray_code(1, [[0], [1]]).

test(gray_code_3) :-
    gray_code(3, [[0, 0, 0],
                  [0, 0, 1],
                  [0, 1, 1],
                  [0, 1, 0],
                  [1, 1, 0],
                  [1, 1, 1],
                  [1, 0, 1],
                  [1, 0, 0]]).

test(gray_code_exhaustive, 
        forall((plunit_gray_code:generator(1, 15, L), member(N, L)))) :-
    gray_code(N, Code),
    check_gray_code(Code).

:- end_tests(gray_code).


:- begin_tests(sudoku).

% predicates needed for tests
check_sublists([]).
check_sublists([Sublist|Rest]) :-
	!, sort(Sublist, Sorted),
	Sorted == [1, 2, 3, 4],
	check_sublists(Rest).

check_rows([]).
check_rows([H|T]) :-
	is_list(H),
	H = [X1, X2, X3, X4],
	var(X1), var(X2),
	var(X3), var(X4),
	check_rows(T).

test(make_rows) :-
	make_rows(4, Rows),
	is_list(Rows),
	length(Rows, 4),
	check_rows(Rows).

test(set_list_constraints) :-
	set_list_constraints([X, _, Z, _]),
	\+ (X == 1, Z == 1).

test(get_cols) :-
	L = [[X1, X2],
	     [X3, X4]],
	get_cols(L, 2, Cols),
	Cols = [[Y1, Y2],
			[Y3, Y4]],
	Y1 == X1,
	Y2 == X3,
	Y3 == X2,
	Y4 == X4.

test(get_square_tiny) :-
    get_square([[a]], 1, 1, 1, [a]).

test(get_square_small) :-
    S = [[a1, a2,  a3, a4],
         [b1, b2,  b3, b4],

         [c1, c2,  c3, c4],
         [d1, d2,  d3, d4]],
    get_square(S, 2, 1, 1, R1),
    R1 == [a1, a2,
           b1, b2],

    get_square(S, 2, 2, 1, R2),
    R2 == [c1, c2,
          d1, d2],

    get_square(S, 2, 1, 2, R3),
    R3 == [a3, a4,
           b3, b4],

    get_square(S, 2, 2, 2, R4),
    R4 == [c3, c4,
           d3, d4].

test(get_square_big) :-
    S = [[x1, x2, x3,  x4, x5, x6,  x7, x8, x9],
         [y1, y2, y3,  y4, y5, y6,  y7, y8, y9],
         [z1, z2, z3,  z4, z5, z6,  z7, z8, z9],
         %
         [w1, w2, w3,  w4, w5, w6,  w7, w8, w9],
         [q1, q2, q3,  q4, q5, q6,  q7, q8, q9],
         [a1, a2, a3,  a4, a5, a6,  a7, a8, a9],
         %
         [e1, e2, e3,  e4, e5, e6,  e7, e8, e9],
         [r1, r2, r3,  r4, r5, r6,  r7, r8, r9],
         [d1, d2, d3,  d4, d5, d6,  d7, d8, d9]],
    %
    get_square(S, 3, 1, 1, S1),
    S1 == [x1, x2, x3,
           y1, y2, y3,
           z1, z2, z3],
    %
    get_square(S, 3, 2, 2, S2),
    S2 == [w4, w5, w6,
           q4, q5, q6,
           a4, a5, a6],
    %
    get_square(S, 3, 3, 1, S3),
    S3 == [e1, e2, e3,
           r1, r2, r3,
           d1, d2, d3].

test(get_square_small) :-
    S = [[a1, a2,  a3, a4],
         [b1, b2,  b3, b4],

         [c1, c2,  c3, c4],
         [d1, d2,  d3, d4]],

    get_squares(S, 2, Squares),
    ground(Squares),
    length(Squares, 4),
    member([a1, a2, b1, b2], Squares), !,
    member([a3, a4, b3, b4], Squares), !,
    member([c1, c2, d1, d2], Squares), !,
    member([c3, c4, d3, d4], Squares), !.

test(format) :-
	% Sudoku should be a list of lists,
	% each sublist should contain 4 elements.
	sudoku(2, S), !,
	ground(S),
	is_list(S),
	check_sublists(S),
    get_cols(S, 4, Cols),
    check_sublists(Cols),
    get_squares(S, 2, Squares),
    check_sublists(Squares).

:- end_tests(sudoku).


:- begin_tests(fibonacci).

test(fib, 
        forall((member((N, F), [ 
        (1,1),
        (2,1),
        (3,2),
        (4,3),
        (5,5),
        (6,8),
        (7,13),
        (8,21),
        (9,34),
        (10,55),
        (11,89),
        (12,144),
        (13,233),
        (14,377),
        (15,610),
        (16,987),
        (17,1597),
        (18,2584),
        (19,4181),
        (20,6765),
        (21,10946),
        (22,17711),
        (23,28657),
        (24,46368),
        (25,75025),
        (26,121393),
        (27,196418),
        (28,317811),
        (29,514229),
        (30,832040),
        (31,1346269),
        (32,2178309),
        (33,3524578),
        (34,5702887),
        (35,9227465),
        (36,14930352),
        (37,24157817),
        (38,39088169),
        (39,63245986),
        (40,102334155),
        (41,165580141),
        (42,267914296),
        (43,433494437),
        (44,701408733),
        (45,1134903170),
        (46,1836311903),
        (47,2971215073),
        (48,4807526976),
        (49,7778742049),
        (50,12586269025)])))) :-
    fib(N, FibRes),
    FibRes == F.

:- end_tests(fibonacci).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
:-dynamic fib/2.


% Fibonacci

fib(1,1):-!.
fib(2,1):-!.
fib(N,Fibnumber):-
	None is N-1,
	Ntwo is N-2,
	fib(None,X),
	fib(Ntwo,Y),
	Fibnumber is X+Y,
	asserta(fib(N,Fibnum)).
	
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Greycode

% grey_code(N, Code)
grey_code(1, [[0],[1]]):-!.

grey_code(N, [H|T]):-
	N>1,
	Nnew is N-1,
	grey_code(Nnew, [0,H|T]);
	grey_code(Nnew, [1,H|T]).





