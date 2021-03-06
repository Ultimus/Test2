/*:- begin_tests(trees_and_lists).

test(count_leaves) :-
    count_leaves(t(1, nil, nil), 1),
    count_leaves(t(3, t(2, nil, nil), nil), 1),
    count_leaves(t(3, t(2, nil, nil), t(5, nil, nil)), 2),
    count_leaves(t(3, t(2, t(1, nil, nil), t(2.5, nil, nil)), t(5, nil, nil)), 3).

test(extract_subtree, [nondet]) :-
    T1 = t(1, nil, nil),
    extract_subtree(T1, 1, T1),
    \+ extract_subtree(T1, 2, T1),
    %
    extract_subtree(t(5, t(3, nil, nil), t(7, t(6, nil, nil), nil)),
           7, t(7, t(6, nil, nil), nil)).

test(extract_subtree_several_solutions, [nondet]) :-
    T = t(5, t(5, t(4, t(4, nil, nil), nil), nil), nil),
    findall(X, extract_subtree(T, 4, X), L1),
    member(t(4, nil, nil), L1),
    member(t(4, t(4, nil, nil), nil), L1),
    length(L1, 2).

test(is_heap) :-
    is_heap(t(1, nil, nil)),
    is_heap(t(1, t(0, nil, nil), t(-1, nil, nil))),
    \+ is_heap(t(1, t(2, nil, nil), t(-1, nil, nil))),
    is_heap(t(1, t(1, nil, nil), t(-1, nil, nil))).

:- end_tests(trees_and_lists).

:- begin_tests(ivos_challenge).

test(my_univ1) :-
	my_univ1(a, [a]),
	my_univ1(f(a, b), [f, a, b]),
	my_univ1([1, 2], ['.', 1, [2]]),
	\+ my_univ1(_, [f]).

test(my_univ2) :-
	my_univ2(X1, [f]), X1 == f,
	my_univ2(X2, [f, a, b]), X2 == f(a, b),
	my_univ2(X3, ['.', 1, [2]]), X3 == [1, 2],
	\+ my_univ2(_, _).

test(my_univ) :-
	f(a, b) =.. X,
	my_univ(f(a, b), X),
	%
	Term = [1, 2, f(a, b, c)],
	Term =.. Y,
	my_univ(Term, Y),
	%
	\+ my_univ(_, _),
	%
	T =.. [a, 1],
	my_univ(T, [a, 1]).

test(my_eq) :-
	my_eq(X1, X1),
	\+ my_eq(_, _),
	my_eq(1, 1),
	my_eq(a, a),
	\+ my_eq(a, b),
	my_eq([1, 2], [1, 2]),
	my_eq(f(a, b, c), f(a, b, c)),
	\+ my_eq(f(a, b, _), f(a, b, _)),
	my_eq(f(X2, Y2), f(X2, Y2)),
	\+ my_eq(f(X3, _), f(X3, _)).

:- end_tests(ivos_challenge).

% dummy predicates needed for test
square(X, Y) :-
	Y is X ^ 2.

inc(X, Y) :-
	Y is X + 1.

add(X, Y, Z) :-
	Z is X + Y.

:- begin_tests(functional_programming).

test(compose_and_evaluate) :-
	compose_and_evaluate(square, inc, 4, 25.0).

test(map_square) :-
	map(square, [1, 2, 3], [1.0, 4.0, 9.0]).

test(map_length) :-
	map(length, [[], [a], [a, b]], [0, 1, 2]).

test(reduce_add) :-
	reduce(add, 0, [1, 2, 3, 4, 5], 15).

:- end_tests(functional_programming).

%%% ______________________________________________________ %%%
*/


count_leaves(t(_X,nil,nil),1).

% allgemeiner Fall

count_leaves(t(_,Left,Right),Result):-
	count_leaves(Left,R_left),
	count_leaves(Right,R_right),
	Result is R_left+R_right.

% links

count_leaves(t(_,Left,nil),Result):-
	count_leaves(Left,Result).
% rechts

count_leaves(t(_,nil,Right),Result):-
	count_leaves(Right,Result).



extract_subtree(t(X,nil,nil),X,t(X,nil,nil)).

extract_subtree(Bin_tree(X,Left,Right),Key,Sub_tree):-
	Key /+ X, 
	(
	extract_subtree(Left,Key,Sub_tree);
	extract_subtree(Right,Key,Sub_tree).
	)
	
extract_subtree(Bin_tree(X,Left,nil),Key,Sub_tree(Key,Left,Right)):-
	extract_subtree(Left,Key,Sub_tree(Key,Left,Right)).

extract_subtree(Bin_tree(X,nil,Right),Key,Sub_tree(Key,Left,Right)):-
	extract_subtree(Right,Key,Sub_tree8Key,Left,Right)).

% extract_subtree(Bin_tree(Key,Left,Right),Key,Sub_tree(Key,Left,Right)).



is_heap(t(X,nil,nil)).

is_heap(t(X,(t(Y,Left,Right),nil)):-
	X > Y,
	is_heap(t(Y,Left,_),
	is_heap(t(Y,_,Right).
	


square(X, Y) :-
	Y is X ^ 2.

inc(X, Y) :-
	Y is X + 1.

add(X, Y, Z) :-
	Z is X + Y.











