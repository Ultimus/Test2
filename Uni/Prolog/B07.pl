:- begin_tests(matrix).

test(sum_matrix) :-
	sum_matrix([[1]], 1),
	sum_matrix([[1, 2], [3, 4], [5, 6]], 21).

test(sum_n_dim_matrix) :-
	C = [[[1, 2], [3, 4], [5, 6]], [[1, 2], [3, 4], [5, 6]]],
	sum_n_dim_matrix(C, 42).

test(transpose) :-
	transpose([[1]], [[1]]),
	transpose([[1, 2], 
			   [3, 4], 
			   [5, 6]], 
			   
			   [[1, 3, 5], 
			    [2, 4, 6]]).

:- end_tests(matrix).


%% Predicates needed for test setup and cleanup. %%
check_clauses([]).
check_clauses([[false-_X, false-_Y]|Rest]) :-
    check_clauses(Rest).

:- begin_tests(colorability).

test(gen_variables) :-
    gen_variables([1, 2], [g, b], Vars),
    length(Vars, 4),
    member((1, g, A), Vars), !, var(A),
    member((1, b, B), Vars), !, var(B),
    member((2, g, C), Vars), !, var(C),
    member((2, b, D), Vars), !, var(D).

test(make__nodes_have_at_most_one_color__clauses, [nondet]) :-
    gen_variables([1, 2], [g, b], Vars),
    make__nodes_have_at_most_one_color__clauses([1, 2], [g, b], Vars, Clauses),
    !, length(Clauses, 2),
    member([false-A, false-B], Clauses),
    member([false-C, false-D], Clauses),
    term_variables([A, B, C, D], TV),
    length(TV, 4).

test(make__each_node_is_colored__clauses, [nondet]) :-
    gen_variables([1, 2], [g, b], Vars),
    make__each_node_is_colored__clauses([1, 2], [g, b], Vars, [], Clauses), !,
    length(Clauses, 2),
    member([true-A, true-B], Clauses),
    member([true-C, true-D], Clauses),
    term_variables([A, B, C, D], TV),
    length(TV, 4).

test(make__neighbors_have_different_colors__clauses, [nondet]) :-
    % consider a circle of three nodes as input graph
    Nodes = [1, 2, 3],
    Edges = [(1, 2), (2, 3), (3, 1)],
    Colors = [r, g, b], % red, green, blue
    gen_variables(Nodes, Colors, Vars),
    make__neighbors_have_different_colors__clauses(
            Nodes, Edges, Colors, Vars, [], Clauses),
    length(Clauses, 18),
    check_clauses(Clauses).

test(compute_colors, [nondet]) :-
    Nodes = [1, 2],
    Edges = [(1, 2)],
    Colors = [green, red],
    compute_colors(Nodes, Edges, Colors, _Vars).

test(compute_colors_big, [nondet]) :-
    Nodes = [1, 2, 3, 4, 5],
    Edges = [(1, 2), (1, 3), (2, 3), (2, 4), (3, 5), (4, 5)],
    Colors = [red, green, blue],
    compute_colors(Nodes, Edges, Colors, Vars),
    print_variables(Vars).

:- end_tests(colorability).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% SAT Solver %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

sat(Clauses, Vars) :-
	problem_setup(Clauses), elim_var(Vars).

elim_var([]).
elim_var([Var | Vars]) :-
	elim_var(Vars), (Var = true; Var = false).

problem_setup([]).
problem_setup([Clause | Clauses]) :-
	clause_setup(Clause),
	problem_setup(Clauses).

clause_setup([Pol-Var | Pairs]) :- 
	set_watch(Pairs, Var, Pol).

set_watch([], Var, Pol) :- Var = Pol.
set_watch([Pol2-Var2 | Pairs], Var1, Pol1):-
	watch(Var1, Pol1, Var2, Pol2, Pairs).

watch(Var1, Pol1, Var2, Pol2, Pairs) :-
	when((nonvar(Var1); nonvar(Var2)),
		(nonvar(Var1) ->
			update_watch(Var1, Pol1, Var2, Pol2, Pairs);
			update_watch(Var2, Pol2, Var1, Pol1, Pairs))).

update_watch(Var1, Pol1, Var2, Pol2, Pairs) :-
	Var1 == Pol1 -> true; set_watch(Pairs, Var2, Pol2).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%




sum_Matrix(Matrix, Sum):- 
sum_Matrix(Matrix, Acc, Sum).

sum_Matrix ([H|T],Acc,Acc):-
	Acc is Acc+H,
	sum_Matrix([T],Acc,Acc).
	

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


gen_variables([H_Nodes|T_Nodes], [H_Colors|T_Colors], Vars):-
	gen_variables([T_Nodes],[H_Colors|T_Colors], [H_Nodes,H_Colors,X|_]);
	gen_variables ([H_Nodes|T_Nodes], [T_Colors], [H_Nodes,H_Colors,X|_]).






