% line comment1
% line comment2
predicate-declaration(Variable, "String", const) :-
    predicate-referenced(Variable, [Head1|[Head1|Tail]],1).

predicate-referenced(A, B, C).
predicate-referenced(A, B).

sum_list([], Sum, Sum).
sum_list([E|Es], Sum0, Sum) :-
    Sum1 = Sum0 + E,
    sum_list(Es, Sum1, Sum).

% sum_list(List, Sum) :-
%     sum_list(List, 0, Sum).
