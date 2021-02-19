package Cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import utilidades.Leer;

public class AppCliente {

	static final String ip = "localhost";
	static final int puerto = 4444;

	public static void main(String[] args) throws IOException {

		// Obtenemos conexion e inicializamos
		Socket socket = new Socket(ip, puerto);

		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
		String inputUsuario;
		String nombreUsuario = "";
		AtiendeCliente hiloCliente = new AtiendeCliente(socket);
		hiloCliente.start();

		do {
			if (nombreUsuario.equals("")) {
				System.out.println("Introduce tu nombre");
				inputUsuario = Leer.pedirCadena();
				nombreUsuario = inputUsuario;
				output.println("[Nuevo cliente se ha unido " + nombreUsuario + "]");
				if (inputUsuario.equals("*")) {
					break;
				}
			} else {
				inputUsuario = Leer.pedirCadena();
				output.println(nombreUsuario + " dice: " + inputUsuario);
				if (inputUsuario.equals("*")) {
					break;
				}
			}
		} while (!inputUsuario.equals("*"));
		socket.close();
		System.out.println("Cliente cerrado");
	}
}