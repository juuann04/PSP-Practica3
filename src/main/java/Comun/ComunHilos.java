package Comun;

import java.net.Socket;

public class ComunHilos {

	private final int MAX_CONEXIONES;
	private int conexionesTotales;
	private int conexcionesActuales;
	private Socket[] tablaDeConexiones;
	private String mensajes;

	public ComunHilos(int MAX_CONEXIONES) {
		this.MAX_CONEXIONES = MAX_CONEXIONES;
	}

	public int getConexionesTotales() {
		return conexionesTotales;
	}

	public void setConexionesTotales(int conexionesTotales) {
		this.conexionesTotales = conexionesTotales;
	}

	public int getConexcionesActuales() {
		return conexcionesActuales;
	}

	public void setConexcionesActuales(int conexcionesActuales) {
		this.conexcionesActuales = conexcionesActuales;
	}

	public String getMensajes() {
		return mensajes;
	}

	public void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}
}