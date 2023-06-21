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
		this.historialServiciosRealizados = new ArrayList<>();
	}

	public ArrayList<Servicio> getHistorialServiciosRealizados() {
		return this.historialServiciosRealizados;
	}

	public void addServicioHistorial(Servicio servicio) {
		historialServiciosRealizados.add(servicio);
	}

	public int getIdEspecialista() {
		return idEspecialista;
	}

	public void setIdEspecialista(int idEspecialista) {
		this.idEspecialista = idEspecialista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	
	
	

	
}
