"""Q1: Student marks using filter(), map(), reduce(), and lambda."""
from functools import reduce

students = [
    ("Arun", 82),
    ("Bala", 45),
    ("Charan", 67),
    ("Divya", 91),
    ("Meena", 38),
]

# a) Select students who scored at least 50.
passed = list(filter(lambda student: student[1] >= 50, students))

# b) Award 5 grace marks, with a maximum score of 100.
grace_marks = list(map(
    lambda student: (student[0], min(student[1] + 5, 100)),
    students,
))

# c) Calculate the total after grace marks.
total = reduce(lambda running_total, student: running_total + student[1],
               grace_marks, 0)

print("Students scoring 50 or above:")
for name, mark in passed:
    print(f"{name}: {mark}")

print("\nMarks after grace marks:")
for name, mark in grace_marks:
    print(f"{name}: {mark}")

print(f"Total marks after grace marks: {total}")

# d) Lambda functions are short anonymous functions. They keep simple
# transformations and conditions close to filter(), map(), and reduce().
