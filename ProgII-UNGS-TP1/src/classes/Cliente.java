package classes;

import java.util.ArrayList;

public class Cliente {

	private int dni;
	private String nombre;
	private String numeroContacto;
	
	public Cliente() {
		
	}
	
	public Cliente(int dni, String nombre, String numeroContacto) {
		this.dni = dni;
		this.nombre = nombre;
		this.numeroContacto = numeroContacto;
	}
	
	@Override
	public int hashCode() {
		return dni;
	}
	
	
}
