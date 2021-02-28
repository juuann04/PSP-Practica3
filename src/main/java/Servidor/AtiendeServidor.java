package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AtiendeServidor extends Thread {

	// VARIABLES
	private Socket socket;
	private DataOutputStream salida;

	// CONSTRUCTOR
	public AtiendeServidor(Socket socket) {
		this.socket = socket;
	}

	// OTRO METODOS
	@Override
	public void run() {
		try {
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			salida = new DataOutputStream(socket.getOutputStream());
			while (true) {
				String respuestaDelServidor = entrada.readUTF();
				System.out.println(respuestaDelServidor);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}