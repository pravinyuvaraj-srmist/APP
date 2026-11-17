"""Q1 TCP server: return an examination result for a register number."""
import socket

HOST = "127.0.0.1"
PORT = 50000

# Demonstration result database. Replace with a real database when required.
RESULTS = {
    "101": "Pass - 85%",
    "102": "Pass - 92%",
    "103": "Fail - 48%",
    "104": "Pass - 76%",
}

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
    server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    server.bind((HOST, PORT))
    server.listen()
    print(f"TCP result server listening on {HOST}:{PORT}")

    while True:
        connection, address = server.accept()
        with connection:
            print("Connected by", address)
            register_number = connection.recv(1024).decode("utf-8").strip()
            result = RESULTS.get(register_number, "No result found for this register number.")
            connection.sendall(result.encode("utf-8"))
