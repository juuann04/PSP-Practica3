package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AtiendeServidor extends Thread {
	
	// VARIABLES
	private Socket socket;
	private PrintWriter output;

	// CONSTRUCTOR
	public AtiendeServidor(Socket socket) {
		this.socket = socket;
	}

	// OTRO METODOS
	@Override
	public void run() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream(), true);
			while (true) {
				String respuesta = input.readLine();
				System.out.println(respuesta);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}