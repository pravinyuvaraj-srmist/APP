"""Q1 TCP client: request an examination result from the server."""
import socket

HOST = "127.0.0.1"
PORT = 50000

register_number = input("Enter student register number: ").strip()
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client:
    client.connect((HOST, PORT))
    client.sendall(register_number.encode("utf-8"))
    result = client.recv(1024).decode("utf-8")

print("Examination result:", result)
