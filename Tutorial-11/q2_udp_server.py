"""Q2 UDP server: receive and display sensor temperature readings."""
import socket

HOST = "127.0.0.1"
PORT = 50001

with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as server:
    server.bind((HOST, PORT))
    print(f"UDP temperature server listening on {HOST}:{PORT}")
    print("UDP is suitable because sensor readings are small and frequent; low latency")
    print("and low overhead are useful, and occasional packet loss can be tolerated.")
    print("Unlike TCP, UDP does not establish a connection or guarantee delivery/order.")

    while True:
        data, address = server.recvfrom(1024)
        reading = data.decode("utf-8").strip()
        try:
            temperature = float(reading)
            print(f"Temperature from {address}: {temperature:.2f} °C")
        except ValueError:
            print(f"Invalid temperature reading from {address}: {reading!r}")
