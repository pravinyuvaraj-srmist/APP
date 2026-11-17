"""Q4: Daily electricity consumption using filter(), map(), and reduce()."""
from functools import reduce

consumption = [8, 12, 9, 15, 11, 7, 14]  # units per day
RATE_PER_UNIT = 6

# a) Days with consumption greater than 10 units.
high_consumption = list(filter(lambda units: units > 10, consumption))

# b) Calculate the cost for each day.
daily_costs = list(map(lambda units: units * RATE_PER_UNIT, consumption))

# c) Total electricity consumption for all recorded days.
total_units = reduce(lambda total, units: total + units, consumption, 0)

# d) Pure bill function: computes a bill without changing consumption.
def electricity_bill(readings, rate=RATE_PER_UNIT):
    return sum(map(lambda units: units * rate, readings))

print("Consumption above 10 units:", high_consumption)
print("Daily costs (Rs.):", daily_costs)
print("Total consumption:", total_units, "units")
print(f"Total electricity bill: Rs. {electricity_bill(consumption):.2f}")
print("Original readings remain:", consumption)
