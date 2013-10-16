%%%% __________ split __________ %%%

% Idee ist es, dass split 1 split 2 aufruft. so entszeht aus der Liste [1,2,3,4] die Teillisten [1,3] und [2,4]

split(List, Split1, Split2) :-		
    split1(List, Split1, Split2).

split1([], [], []).    % base case
split1([H|T], [H|Split1], Split2) :-
    split2(T, Split1, Split2).

split2([], [], []).
split2([H|T], Split1, [H|Split2]) :-
    split1(T, Split1, Split2).

%%%% __________ merge __________ %%%

merge([], L, L) :- !.    % base case
merge(L, [], L) :- !.	% 2. base case

merge([H1|T1], [H2|T2], [H1|R]) :-	
    H1 =< H2, !,     		% ist Kopf von der ersten Liste <= Kopf der 2. Liste, füge H1 in die Liste ein. 
    merge(T1, [H2|T2], R).

merge([H1|T1], [H2|T2], [H2|R]) :-
    H1 > H2, !,			% ist H1 größer füge H2 in die Liste ein, man beachte die rekursion
    merge([H1|T1], T2, R).

%%%% __________ merge_sort __________ %%%

merge_sort([], []) :- !.	% base case
merge_sort([X], [X]) :- !.	
merge_sort(L, R) :-
    split(L, L1, L2),		% rufe split auf
    merge_sort(L1, R1),		% sortiere 1 Teilfole
    merge_sort(L2, R2),		% sortiere 2. Teilfolge
    merge(R1, R2, R).		% füge die Resultate zusammen
