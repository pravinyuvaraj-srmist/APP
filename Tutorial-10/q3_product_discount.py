"""Q3: Pure function and functional operations for a festival discount."""

prices = [750.0, 1200.0, 2500.0, 999.0, 1800.0]

def discounted_price(price):
    """Return a 20% discounted price without changing the input."""
    return price * 0.80 if price > 1000 else price

# c) Identify products costing more than Rs. 1,000.
eligible_prices = list(filter(lambda price: price > 1000, prices))

# b) Apply the pure function to eligible products.
discounted_eligible = list(map(discounted_price, eligible_prices))

# Also show the complete revised price list.
revised_prices = list(map(discounted_price, prices))

print("Original prices:", prices)
print("Products eligible for discount:", eligible_prices)
print("Discounted eligible prices:", [round(p, 2) for p in discounted_eligible])
print("All prices after applicable discount:", [round(p, 2) for p in revised_prices])

# d) discounted_price depends only on its argument and returns a new value.
# It does not modify the original list, so the function is pure.
