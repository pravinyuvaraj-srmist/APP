"""Q3: Expand, factor, simplify expressions and solve a quadratic using SymPy."""
import sympy as sp

x = sp.symbols("x")
expression = (x + 2) * (x + 3)

expanded = sp.expand(expression)
factorized = sp.factor(expanded)
simplified = sp.simplify((x**2 + 2*x + 1) / (x + 1))
equation = sp.Eq(x**2 - 5*x + 6, 0)
solutions = sp.solve(equation, x)

print("Original expression:", expression)
print("Expanded expression:", expanded)
print("Factorized expression:", factorized)
print("Simplified expression:", simplified)
print("Quadratic equation:", equation)
print("Production quantity solution(s):", solutions)
