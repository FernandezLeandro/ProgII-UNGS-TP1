package classes;

import java.util.ArrayList;

public class Especialista {

	private int idEspecialista;
	private String nombre;
	private String telefono;
	private String especialidad;
	private ArrayList<Servicio> historialServiciosRealizados;
	
	public Especialista() {
		
	}

	public Especialista(int idEspecialista, String nombre, String telefono, String especialidad) {
		this.idEspecialista = idEspecialista;
		this.nombre = nombre;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}

	public ArrayList<Servicio> getHistorialServiciosRealizados() {
		return historialServiciosRealizados;
	}

	public void addServicioHistorial(Servicio servicio) {
		historialServiciosRealizados.add(servicio);
	}
	

	
}
