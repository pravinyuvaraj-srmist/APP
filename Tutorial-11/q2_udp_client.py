"""Q2 UDP client: send a temperature reading to the monitoring server."""
import socket

HOST = "127.0.0.1"
PORT = 50001

reading = input("Enter temperature in Celsius: ").strip()
try:
    float(reading)  # Validate before sending.
except ValueError:
    raise SystemExit("Please enter a valid numeric temperature.")

with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as client:
    client.sendto(reading.encode("utf-8"), (HOST, PORT))

print("Temperature reading sent.")
