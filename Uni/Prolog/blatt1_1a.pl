e(A,B) :-
 edge(A,B);
 edge(B,A).


edge(1,2).
edge(2,3).
edge(2,4).
edge(3,5).
edge(4,5).
edge(4,6).
edge(4,7).
edge(6,7).


loop(A) :- e(A,A).

