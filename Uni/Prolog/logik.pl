plattfuss(X) :- keine_ahnung_von_fussball(X).
blockfloete(X) :- isst_chinesisch(X).
weichei(X) :- date_double(X).
jesuslatschen(x) :- vegetarier(x).
isst_chinesisch(x) :- \+date_double(x).
keine_ahnung_von_fussball(x) :- weichei(x).
blockfloete(x) :- angelschein(x).
vegetarier(x) :-plattfuss(x).

