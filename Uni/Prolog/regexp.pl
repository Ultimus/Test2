

%:- op(1150, xfy, '|').

re(A) --> {atomic(A)}, [A].
re(cat(A,B)) --> re(A),re(B).
re(or(A,B)) --> re(A) ; re(B).
re(star(_)) --> [].
re(star(A)) --> re(A),re(star(A)).
 
test(S) :- re(cat(a,cat(star(or(a,b)),b)),S,[]).
test2(S) :- re(cat(a,cat(star(or(a,b)),b)),S,R), print(R),nl,fail.