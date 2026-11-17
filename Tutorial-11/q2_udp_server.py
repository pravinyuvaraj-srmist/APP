"""Q2 UDP server: receive and display sensor temperature readings."""
import socket

HOST = "127.0.0.1"
PORT = 50001

with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as server:
    server.bind((HOST, PORT))
    print(f"UDP temperature server listening on {HOST}:{PORT}")

    while True:
        data, address = server.recvfrom(1024)
        reading = data.decode("utf-8").strip()
        try:
            temperature = float(reading)
            print(f"Temperature from {address}: {temperature:.2f} °C")
        except ValueError:
            print(f"Invalid temperature reading from {address}: {reading!r}")
