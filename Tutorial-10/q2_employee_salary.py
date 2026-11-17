"""Q2: Revise eligible salaries by 10% using functional programming."""
from functools import reduce

salaries = [32000, 45000, 38000, 52000, 27500]

# b) Identify employees whose original salary is below Rs. 40,000.
eligible = list(filter(lambda salary: salary < 40000, salaries))

# a) Apply a 10% increment only to eligible salaries.
revised_salaries = list(map(
    lambda salary: salary * 1.10 if salary < 40000 else salary,
    salaries,
))

# c) Calculate total salary expenditure after revision.
total_expenditure = reduce(lambda total, salary: total + salary,
                           revised_salaries, 0)

print("Eligible salaries:", eligible)
print("Revised salaries:", [round(s, 2) for s in revised_salaries])
print(f"Total salary expenditure: Rs. {total_expenditure:.2f}")

# d) Functional operations process each record consistently and concisely.
# map() creates revised values, filter() selects eligible records, and
# the original salaries list remains unchanged.
