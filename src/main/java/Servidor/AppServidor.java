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

		// ArrayList<AtiendeServidor> misClientes = new ArrayList<AtiendeServidor>();
		AtiendeServidor listaDeClientes[] = new AtiendeServidor[5];
		while (true) {
			Socket miSocket = miServerSocket.accept();
			
			for (AtiendeServidor aT : listaDeClientes) {
				AtiendeServidor respuestasServidor = new AtiendeServidor(miSocket, listaDeClientes);

				// misClientes.add(respuestasServidor);
				respuestasServidor.start();
			}
			
			
		}
	}
}