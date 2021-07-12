:- ensure_loaded(library(clpfd)).
% ===========================================================================
% AUTHORSHIP
% ---------------------------------------------------------------------------
% Fan Jia
% login ID: jfj
% student ID: 1013015
% Project1 "Math Puzzle" solution file written by Prolog
% ===========================================================================
% PROBLEM DESCRIPTION
% ---------------------------------------------------------------------------
% A maths puzzle is a square grid of squares, each to be filled in with a
% single digit 1–9 (zero is not permitted) satisfying these constraints:
%
%   • each row and each column contains no repeated digits;
%   • all squares on the diagonal line from upper left to lower right
%     contain he same value; and
%   • the heading of reach row and column (leftmost square in a row and
%     topmost square in a column) holds either the sum or the product of
%     all the digits in that row or column
%
% Note that the row and column headings are not considered to be part of
% the row or column, and so may be filled with a number larger than a single
% digit. The upper left corner of the puzzle is not meaningful.
%
% When the puzzle is originally posed, most or all of the squares will be
% empty, with the headings filled in. The goal of the puzzle is to fill in
% all the squares according to the rules. A proper maths puzzle will have
% at most one solution.
%
% Here is an example puzzle as posed (left) and solved (right) :
%  ____ ____ ____ ____    ____ ____ ____ ____
% |    | 14 | 10 | 35 |  |    | 14 | 10 | 35 |
%  --------------------  --------------------
% | 14 |    |    |    |  | 14 |  7 |  2 |  1 |
% | 15 |    |    |    |  | 15 |  3 |  7 |  5 |
% | 28 |    |  1 |    |  | 28 |  4 |  1 |  7 |
%  ---- ---- ---- ----    ---- ---- ---- ----
%
% You will write Prolog code to solve maths puzzles. Your program should
% supply a predicate puzzle_solution(Puzzle) that holds when Puzzle is
% the representation of a solved maths puzzle.
%
% A maths puzzle will be represented as a list of lists, each of the same
% length, representing a single row of the puzzle. The first element of
% each list is considered to be the header for that row. Each element but
% the first of the first list in the puzzle is considered to be the header
% of the corresponding column of the puzzle. The first element of the first
% element of the list is the corner square of the puzzle, and thus is
% ignored.
% ===========================================================================
% PROBLEM ASSUMPTIONS
% ---------------------------------------------------------------------------
% You can assume that when your puzzle_solution/1 predicate is called, its
% argument will be a proper list of proper lists, and all the header squares
% of the puzzle (plus the ignored corner square) are bound to integers. Some
% of the other squares in the puzzle may also be bound to integers, but the
% others will be unbound. When puzzle_solution/1 succeeds, its argument must
% be ground. You may assume your code will only be tested with proper puzzles,
% which have at most one solution. Of course, if the puzzle is not solvable,
% the predicate should fail, and it should never succeed with a puzzle argument
% that is not a valid solution
% ===========================================================================
% PROGRAM
% ---------------------------------------------------------------------------
% We have three constraints described above. Diagonal elements will be the
% same before and after transposition, therefore, we check second constraint
% first. Then get ride of the first row (headings in the matrix) and check
% other constraints mentioned in the description through check_rows/1. Then
% do the same operation for transposed Puzzle so that columns can meet the
% constraints
%
% puzzle_solution/1 takes a puzzle matrix as argument and check if it meets
% all constraints as well as solve unknown values in the matrix
puzzle_solution(Puzzle) :-
    check_diagonal(Puzzle),
    Puzzle = [_|RestRowList0],
    check_rows(RestRowList0),
    transpose(Puzzle, TPuzzle),
    TPuzzle = [_|RestRowList1],
    check_rows(RestRowList1).
% ---------------------------------------------------------------------------

% ---------------------------------------------------------------------------
% Predicates for satisfying:
% • all squares on the diagonal line from upper left to lower right
%   contain he same value
%
% check_diagonal/1 takes whole puzzle as argument and get ride of heading row
% then get upper-left element as DiagValue (element at row1,column1 indexing
% from 0), through a helper predicate check_diagonal/3 checking if elements
% at nth row and nth column have same value
%
% [_|BodyRows] : whole puzzle matrix
check_diagonal([_|BodyRows]) :-
    [FirstRow|RestRows] = BodyRows,
    nth0(1, FirstRow, DiagValue),
    check_diagonal(2, RestRows, DiagValue).
% helper predicate for check_diagonal/1, iterate nth row nth column by an
% incremental variable Index and recursive call
%
% Index                : current diagonal elements index in current row
% [CurrentRow|RestRows]: list of rows
% DiagValue            : diagonal value
check_diagonal(_,[],_).
check_diagonal(Index,[CurrentRow|RestRows],DiagValue) :-
    nth0(Index, CurrentRow, DiagValue),
    NextIndex = Index + 1,
    check_diagonal(NextIndex, RestRows, DiagValue).
% ---------------------------------------------------------------------------

% ---------------------------------------------------------------------------
% Predicates for satisfying:
%   • each row and each column contains no repeated digits;
%   • the heading of reach row and column (leftmost square in a row and
%     topmost square in a column) holds either the sum or the product of
%     all the digits in that row or column
check_rows([]).
check_rows([CurrentRow|RestRowList]) :-
    [SumOrProduct|ElementsList] = CurrentRow,
    check_range(ElementsList),
    check_no_duplicate(ElementsList),
    check_sum_or_product(SumOrProduct,ElementsList),
    check_rows(RestRowList).
% ---------------------------------------------------------------------------

% ---------------------------------------------------------------------------
% helper predicate, get sum of a list
sum_list([], Sum, Sum).
sum_list([E|Es], Sum0, Sum) :-
    Sum1 = Sum0 + E,
    sum_list(Es, Sum1, Sum).

sum_list(List, Sum) :-
    sum_list(List, 0, Sum).
% ---------------------------------------------------------------------------

% ---------------------------------------------------------------------------
% helper predicate, get product of a list
product_list([], Product, Product).
product_list([E|Es], Product0, Product) :-
    Product1 = Product0 * E,
    product_list(Es, Product1, Product).

product_list(List, Product) :-
    product_list(List, 1, Product).
% ---------------------------------------------------------------------------

% ---------------------------------------------------------------------------
% helper predicate, check if all elements in a list is digits from 1-9
check_range([]).
check_range([H|T]) :-
    H in [1,2,3,4,5,6,7,8,9],
    check_range(T).
% ---------------------------------------------------------------------------

% ---------------------------------------------------------------------------
% helper predicate, check if all elements in a list is distinct
check_no_duplicate(Row) :-
    all_distinct(Row).
% ---------------------------------------------------------------------------

% ---------------------------------------------------------------------------
% helper predicate, check if SumOrProduct is either sum or product of list
% ElementsList
check_sum_or_product(SumOrProduct, ElementsList) :-
    sum_list(ElementsList,SumOrProduct).
check_sum_or_product(SumOrProduct, ElementsList) :-
    product_list(ElementsList,SumOrProduct).
% ---------------------------------------------------------------------------