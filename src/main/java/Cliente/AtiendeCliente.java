package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AtiendeCliente extends Thread {

	static final String IP = "localhost";
	static final int PUERTO = 4444;
	private Socket socket;
	private BufferedReader input;

	public AtiendeCliente(Socket socket) throws IOException {
		this.socket = socket;
		this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void run() {
		try {
			while (true) {
				String respuesta = input.readLine();
				System.out.println(respuesta);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}