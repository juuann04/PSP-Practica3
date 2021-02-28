package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Comun.ComunHilos;

public class AtiendeCliente extends Thread {

	// VARIABLES
	private ComunHilos comunHilos;
	private Socket socket;
	private DataOutputStream salida;

	// CONSTRUCTOR
	public AtiendeCliente(Socket socket, ComunHilos comunHilos) {
		this.socket = socket;
		this.comunHilos = comunHilos;
	}

	// OTRO METODOS
	@Override
	public void run() {
		try {
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			salida = new DataOutputStream(socket.getOutputStream());
			String nombre = entrada.readUTF();
			while (true) {
				String outputString = entrada.readUTF();
				comunHilos.anadirMensaje(outputString);
				comunHilos.anadirCliente(socket);
				System.out.println("Mensaje de " + outputString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}