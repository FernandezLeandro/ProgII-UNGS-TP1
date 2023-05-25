package classes;

import java.util.ArrayList;

public class Cliente {

	private Long dni;
	private String nombre;
	private String numeroContacto;
	private ArrayList<Servicio> listaServiciosPendientes;
	
	public Cliente() {
		
	}
	
	public Cliente(Long dni, String nombre, String numeroContacto) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.numeroContacto = numeroContacto;
	}
	
	public void addServicioPendiente(Servicio servicio) {
		
	}
	
	public void removeServicioPendiente(Servicio servicio) {
		
	}
	
	
}
