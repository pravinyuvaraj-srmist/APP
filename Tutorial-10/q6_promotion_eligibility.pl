% Q6: Employee promotion eligibility.
% Conditions: at least 5 years' experience, completed training,
% and performance rating of at least 4.

employee(ravi, 6, completed, 5).
employee(priya, 3, completed, 4).
employee(kumar, 8, not_completed, 5).
employee(meena, 7, completed, 4).

eligible_for_promotion(Name) :-
    employee(Name, Years, completed, Rating),
    Years >= 5,
    Rating >= 4.

% Query in SWI-Prolog:
% ?- eligible_for_promotion(Employee).
% Expected answer: Employee = meena ; Employee = ravi.
