:- begin_tests(arithmetic).

test(nat) :-
	nat(0),
	nat(s(0)),
	nat(s(s(0))).

test(make_nat) :-
	make_nat(0, 0),
	make_nat(1, s(0)),
	make_nat(2, s(s(0))),
	make_nat(3, s(s(s(0)))).

test(add) :-
	add(0, 0, 0),
	add(s(0), 0, s(0)),
	add(s(0), s(0), s(s(0))),
	add(s(0), s(s(0)), s(s(s(0)))),
	add(0, s(0), s(0)).

test(sub) :-
    make_nat(1, N1),
    make_nat(2, N2),
    make_nat(3, N3),
    make_nat(4, N4),
    
    sub(0, 0, 0),
    sub(N2, N1, N1),
    sub(N2, N2, 0),
    sub(N1, N2, 0),
    sub(N4, N1, N3).

test(mul, [nondet]) :-
	mul(0, _, 0),
	make_nat(6, N6),
	mul(s(s(0)), s(s(s(0))), N6),
	mul(_, 0, 0),
	make_nat(2, N2),
	mul(N2, s(0), N2),
	mul(s(0), s(0), s(0)).

test(pow, [nondet]) :-
	make_nat(1, N1),
	make_nat(2, N2),
	make_nat(3, N3),
	make_nat(4, N4),
	make_nat(8, N8),
	make_nat(16, N16),

	pow(0, 0, N1),
	pow(0, N1, 0),
	pow(N16, N1, N16),
	pow(N1, N2, N1),
	pow(N2, N2, N4),
	pow(N2, N3, N8),
	pow(N4, N2, N16).

test(fac, [nondet]) :-
	make_nat(1, N1),
	make_nat(2, N2),
	make_nat(3, N3),
	make_nat(4, N4),
	make_nat(6, N6),
	make_nat(24, N24),

	fac(0, N1),
	fac(N1, N1),
	fac(N2, N2),
	fac(N3, N6),
	fac(N4, N24).

test(lt) :-
	lt(0, s(0)),
	\+ lt(0, 0),
	make_nat(2, N2),
	make_nat(4, N4),
	lt(N2, N4).

test(mod, [nondet]) :-
	make_nat(1, N1),
	make_nat(2, N2),
	make_nat(3, N3),
	make_nat(5, N5),

	mod(N2, N1, 0),
	mod(N2, N2, 0),
	mod(N2, N3, N2),
	mod(N5, N3, N2).

test(pow2, [nondet]) :-
	make_nat(1, N1),
	make_nat(2, N2),
	make_nat(3, N3),
	make_nat(4, N4),
	make_nat(8, N8),
	make_nat(16, N16),

	pow2(0, 0, N1),
	pow2(0, N1, 0),
	pow2(N16, N1, N16),
	pow2(N1, N2, N1),
	pow2(N2, N2, N4),
	pow2(N2, N3, N8),
	pow2(N4, N2, N16).

:- end_tests(arithmetic).

:- begin_tests(lists).

test(is_a_list) :-
    is_a_list([]),
    is_a_list([1]),
    is_a_list([1, 2]).

test(app) :-
    app([1], [2], [1, 2]),
    app([], [1], [1]),
    app([1], [], [1]).

test(rev) :-
    rev([], []),
    rev([1], [1]),
    rev([1, 2, 3], [3, 2, 1]).

test(infix) :-
    infix([], [1, 2, 3]),
    infix([1], [1, 2, 3]),
    infix([2], [1, 2, 3]),
    infix([3], [1, 2, 3]),
    infix([1, 2], [1, 2, 3]),
    infix([2, 3], [1, 2, 3]),
    infix([1, 2, 3], [1, 2, 3]).

test(suffix, [nondet]) :-
    suffix([], [1, 2, 3]),
    suffix([3], [1, 2, 3]),
    suffix([2, 3], [1, 2, 3]),
    suffix([1, 2, 3], [1, 2, 3]).

test(prefix) :-
    prefix([], [1, 2, 3]),
    prefix([1], [1, 2, 3]),
    prefix([1, 2], [1, 2, 3]),
    prefix([1, 2, 3], [1, 2, 3]).

test(element_of, [nondet]) :-
    element_of(1, [1, 2, 3]),
    element_of(2, [1, 2, 3]),
    element_of(3, [1, 2, 3]).

test(del_element, [nondet]) :-
    del_element(1, [1, 2, 3], [2, 3]),
    del_element(2, [1, 2, 3], [1, 3]),
    del_element(3, [1, 2, 3], [1, 2]).

:- end_tests(lists).

:- begin_tests(trees).

test(is_tree) :-
    is_tree(t(a, [])),
    is_tree(t(a, [t(b, []), t(c, [])])).

test(preorder) :-
    t2l_pre(t(a, [t(b, []), t(c, [])]), [a, b, c]).

test(postorder) :-
    t2l_post(t(a, [t(b, []), t(c, [])]), [b, c, a]).

test(height) :-
    height(t(a, []), 1),
    height(t(a, [t(b, [t(c, []), t(d, [t(e, [])])])]), 4).

:- end_tests(trees).
