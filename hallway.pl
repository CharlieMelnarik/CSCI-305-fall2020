/*Charlie Melnarik*/

logic([match(_, 1), match(_, 2), match(_, 3), match(_, 4), match(_, 5)]).
notadjacent(A,B) :- (A > B+1; A < B-1).
hallway(X) :- logic(X),
        member(match(hunter, V),X),
        member(match(laura, U), X),
        member(match(ramey, W), X),
        member(match(arnie, Y), X),
        member(match(addiley, Z), X),

        V \= 5,
        U \= 1,
        W > U,
        Y \= 1,
        Y \= 5,
        notadjacent(Y,Z),
        notadjacent(Y,U).

