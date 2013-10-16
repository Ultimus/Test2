delta(q0,[a|T],[c]):- delta(q0,T,[a]).
delta(q0,[a|T],[S]):- delta(q0,T,[a|S]).
delta(q0,[b|T],[a|S]):- delta(q1,T,[b|S]).
delta(q1,[b|T],[b|S]):- delta(q1,T,S).
delta(q1,[b|T],[a|S]):- delta(q1,T,[b|S]).
delta(q1,_,[c|T]):-delta(q2,_,T).
delta(q2,[],[]). 
