/*:- begin_tests(lists).

test(palindrome) :-
	palindrome([]),
	palindrome([a]),
	palindrome([a, b, a]),
	palindrome([a, b, b, a]),
	\+ palindrome([a, b]).

test(k_members, [nondet]) :-
    findall(X1, k_members([a, b, c], 1, X1), L1),
    length(L1, 3),
    member([a], L1),
    member([b], L1),
    member([c], L1),

    findall(X2, k_members([a, b, c], 2, X2), L2),
    length(L2, 6),
    member([a, b], L2),
    member([a, c], L2),
    member([b, a], L2),
    member([b, c], L2),
    member([c, a], L2),
    member([c, b], L2),

    findall(X3, k_members([a, b, c], 3, X3), L3),
    length(L3, 6). % a, b, c in all possible orders

:- end_tests(lists).

:- begin_tests(polynomials).

test(sort) :-
    pol_sort([], []),
    pol_sort([(1, 2), (3, 4)], [(3, 4), (1, 2)]),
    pol_sort([(6, 2), (1, 4)], [(1, 4), (6, 2)]).

test(add) :-
    pol_add([(1, 1)], [], [(1, 1)]),
    pol_add([], [(1, 1)], [(1, 1)]),
    pol_add([(1, 1)], [(2, 3), (4, 1)], [(2, 3), (5, 1)]),
    pol_add([(2, 2)], [(3, 3)], [(3, 3), (2, 2)]).

test(mul) :-
    pol_mul([], [(2, 3), (5, 6)], []),
    pol_mul([(2, 3), (5, 6)], [], []),
    pol_mul([(1, 2), (2, 1)], [(1, 2), (4, 1), (1, 0)],
            [(1, 4), (6, 3), (9, 2), (2, 1)]).

test(differentiate) :-
    pol_diff([], []),
    pol_diff([(2, 3), (1, 2), (5, 0)], [(6, 2), (2, 1)]).

test(eval) :-
    pol_eval([], 5, 0),
    pol_eval([(3, 0)], 5, 3),
    pol_eval([(2, 3), (2, 1), (5, 0)], 3, 65).

:- end_tests(polynomials).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
*/

palindrome([]).
palindrome(List):-
	reverse(List,List).

% k_members(List, K, Members)
k_members(List,0,List). 

k_members(List, K ,Members):-
	k_members(List, K, _Acc, Members).

k_members([HList|TList], K, Acc, [HList|Members]):-
	Acc is K-1,
	k_members([TList], Acc, Acc, [HList|Members]);
	k_members([TList], Acc, Acc, [Members]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%% pol_sort(Polynom, SortedPolynom).

pol_sort([], []).

pol_sort(Polynom, SortedPolynom):-
	find_smallest(Polynom, Smallest),
	pol_sort(Polynom, [Smallest|SortedPolynom]).

find_smallest([], 0):-!.
find_smallest([H|T], Smallest):-
	H<Smallest,
	(
	Smallest is H
	),
	find_smallest([T], Smallest).

pol_add([],[],[]).
pol_add(X,[],X).
pol_add([],X,X).

pol_add(Pol1, Pol2, Sum):-
	pol_sort(Pol1, SPol1),
	pol_sort(Pol1,Spol1),
	














