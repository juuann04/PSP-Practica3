package Cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Servidor.AtiendeServidor;
import utilidades.Leer;

public class AppCliente {
	
	// VARIABLES
	static final String ip = "localhost";
	static final int puerto = 5555;

	public static void main(String[] args) throws IOException {
		// VARIABLES
		Socket miSocket = new Socket(ip, puerto);
		BufferedReader input = new BufferedReader(new InputStreamReader(miSocket.getInputStream()));
		PrintWriter output = new PrintWriter(miSocket.getOutputStream(), true);
		String mensajeQueEscribeElCliente = "";
		String nombreUsuario = "";
		AtiendeServidor hiloCliente = new AtiendeServidor(miSocket);
		
		hiloCliente.start();
		while (!mensajeQueEscribeElCliente.equals("*")) {
			if (nombreUsuario.equals("")) {
				System.out.println("Nombre de usuario");
				nombreUsuario = Leer.pedirCadena();
				output.println(nombreUsuario);
			} else {
				mensajeQueEscribeElCliente = Leer.pedirCadena();
				output.println(nombreUsuario + " dice: " + mensajeQueEscribeElCliente);
			}
		}
		System.exit(0);
	}
}