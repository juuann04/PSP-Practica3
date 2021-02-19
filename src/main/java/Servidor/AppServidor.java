package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class AppServidor {

	static final int puerto = 4444;

	public static void main(String[] args) throws IOException {

		ServerSocket miServerSocket = new ServerSocket(puerto);
		System.out.println("Servidor conectado (Puerto " + puerto);

		ArrayList<AtiendeServidor> misClientes = new ArrayList<AtiendeServidor>();
		while (true) {
			Socket miSocket = miServerSocket.accept();
			AtiendeServidor respuestasServidor = new AtiendeServidor(miSocket, misClientes);

			misClientes.add(respuestasServidor);
			respuestasServidor.start();
		}
	}
}