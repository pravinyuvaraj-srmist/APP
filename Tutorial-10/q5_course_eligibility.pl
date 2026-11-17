% Q5: Advanced programming course eligibility.
% A student must pass both Python Programming and Data Structures.

python_pass(arun).
data_structures_pass(arun).

python_pass(bala).
% Bala failed Data Structures.

python_pass(charan).
data_structures_pass(charan).

% Divya failed Python Programming.
data_structures_pass(divya).

eligible(Student) :-
    python_pass(Student),
    data_structures_pass(Student).

% Query in SWI-Prolog:
% ?- eligible(Student).
% Expected answers: Student = arun ; Student = charan.
