package Comun;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ComunHilos {
	
	// VARIABLES
	private static int conexionesMax = 10;
	private int conexionesTotales;
	private int conexcionesActuales;
	private Socket[] tablaDeConexiones = new Socket[10];
	private String mensajes;

	// CONSTRUCTOR
	public ComunHilos(int conexionesMax) {
		this.conexionesMax = conexionesMax;
		this.conexionesTotales = 0;
		this.conexcionesActuales = 0;
		this.mensajes = "";
	}

	// SETTERS Y GETTERS
	

	// OTROS METODOS
	public synchronized void anadirMensaje(String mensaje, String nombreUsuario) throws IOException {
		String mensajeConUsuario = nombreUsuario + ": " + mensaje;
		mensajes += mensajeConUsuario;

		for (int i = 0; i < conexcionesActuales; i++) {
			if (tablaDeConexiones == null) {
				PrintWriter output = new PrintWriter(tablaDeConexiones[i].getOutputStream(), true);
				output.println(mensajeConUsuario);
			}
		}
	}

	public synchronized void anadirCliente(Socket conexion) throws IOException {
		if (tablaDeConexiones == null) {
			tablaDeConexiones[conexionesTotales] = conexion;
		}
		conexionesTotales++;
		conexcionesActuales++;
		PrintWriter output = new PrintWriter(conexion.getOutputStream(), true);
		output.println(mensajes);
	}
}