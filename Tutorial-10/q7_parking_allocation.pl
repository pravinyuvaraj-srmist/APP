% Q7: Rule-based parking allocation.
% Facts describe each slot, its vehicle type, and availability.

slot(s1, car, available).
slot(s2, bike, occupied).
slot(s3, car, available).
slot(s4, bike, available).
slot(s5, car, occupied).

available_slot(VehicleType, Slot) :-
    slot(Slot, VehicleType, available).

% Query for available car parking:
% ?- available_slot(car, Slot).
% Expected answers: Slot = s1 ; Slot = s3.
