"""Q4: Vehicle velocity, acceleration, rest times, and displacement via SymPy."""
import sympy as sp

t = sp.symbols("t", real=True)
s = t**3 - 6*t**2 + 9*t + 5

velocity = sp.diff(s, t)
acceleration = sp.diff(velocity, t)
rest_times = sp.solve(sp.Eq(velocity, 0), t)

# The question does not specify interval endpoints; use [0, 3] as an
# explicit example interval. Change these values for another interval.
start_time = 0
end_time = 3
displacement_change = sp.integrate(velocity, (t, start_time, end_time))

print("Displacement s(t):", s)
print("Velocity v(t):", velocity)
print("Acceleration a(t):", acceleration)
print("Vehicle is momentarily at rest at t =", rest_times)
print(f"Displacement change from t={start_time} to t={end_time}:",
      displacement_change)
