package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Comun.ComunHilos;

public class AtiendeCliente extends Thread {

	// VARIABLES
	private ComunHilos comunHilos;
	private Socket socket;
	private PrintWriter output;

	// CONSTRUCTOR
	public AtiendeCliente(Socket socket, ComunHilos comunHilos) {
		this.socket = socket;
		this.comunHilos = comunHilos;
	}

	// OTRO METODOS
	@Override
	public void run() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
			String nombre = input.readLine();
			while (true) {
				String outputString = input.readLine();
				if (outputString.equals("*")) {
					break;
				}
				comunHilos.anadirMensaje(outputString, nombre);
				comunHilos.anadirCliente(socket);
				System.out.println("(Recibido en servidor) " + outputString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}