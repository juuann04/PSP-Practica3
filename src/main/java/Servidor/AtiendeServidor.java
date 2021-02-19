package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class AtiendeServidor extends Thread {

	private Socket socket;
	// private AtiendeServidor hilosClientes[];
	private ArrayList<AtiendeServidor> hilosClientes;
	private PrintWriter output;

	public AtiendeServidor(Socket socket, ArrayList<AtiendeServidor> hilosClientes) {
		this.socket = socket;
		this.hilosClientes = hilosClientes;
	}

	@Override
	public void run() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// IMPRIMIR TODOS LOS MENSAJES
			output = new PrintWriter(socket.getOutputStream(), true);

			while (true) {
				String outputString = input.readLine();
				if (outputString.equals("*")) {
					break;
				}
				imprimirClientes(outputString);
				System.out.println("(Recibido en servidor) " + outputString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void imprimirClientes(String outputString) {
		for (AtiendeServidor miAtiendeServidor : hilosClientes) {
			miAtiendeServidor.output.println(outputString);
		}
	}
}