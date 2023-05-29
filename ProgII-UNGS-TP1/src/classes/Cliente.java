package classes;

import java.util.ArrayList;

public class Cliente {

	private int dni;
	private String nombre;
	private String numeroContacto;
	private ArrayList<Servicio> listaServiciosPendientes;
	
	public Cliente() {
		
	}
	
	public Cliente(int dni, String nombre, String numeroContacto) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.numeroContacto = numeroContacto;
	}
	
	public void addServicioPendiente(Servicio servicio) {
		if(!servicio.finalizado()) {
			listaServiciosPendientes.add(servicio);
		}
	}
	
	public void removeServicioPendiente(Servicio servicio) {
		if(servicio.finalizado()) {
			listaServiciosPendientes.remove(servicio);
		}
	}
	
	
}
