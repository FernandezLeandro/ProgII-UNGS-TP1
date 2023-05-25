package classes;

import java.util.ArrayList;

public class Especialista {

	private Long idEspecialista;
	private String nombre;
	private Long telefono;
	private String especialidad;
	private ArrayList<Servicio> historialServiciosRealizados;
	
	public Especialista() {
		
	}

	public Especialista(Long idEspecialista, String nombre, Long telefono, String especialidad) {
		this.idEspecialista = idEspecialista;
		this.nombre = nombre;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}

	public ArrayList<Servicio> getHistorialServiciosRealizados() {
		return historialServiciosRealizados;
	}

	public void addServicioHistorial(Servicio servicio) {
		
	}
	

	
}
