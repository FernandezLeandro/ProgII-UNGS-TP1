package classes;

import java.util.ArrayList;


public class Diccionario<C,V> {

	private ArrayList<Tupla<C, V>> diccionario;
	
	public Diccionario() {
		diccionario = new ArrayList<>();
	}
	
	public boolean agregar(C c, V v) {
		if(!pertenece(c)) {
			diccionario.add(new Tupla(c,v));
			return true;
		}
		return false;
	}
	
	public boolean eliminar (C c) {
		Tupla<C,V> aux = obtenerElemento(c);
		return diccionario.remove(aux);
	}
	
	public Tupla<C,V> obtenerElemento(C c){
	
		Tupla<C,V> temp = null;
		for(Tupla t : diccionario) { // para cada Tupla (t) que esta en diccionario
			if(t.obtenerX().equals(c)) { // el equals solo funciona si son clases propias de java
				temp = t;
			}
		}
		return temp;
	}
	
	public V obtener(C c) {
		Tupla<C,V> temp = null;
		for(Tupla t : diccionario) { // para cada Tupla (t) que esta en diccionario
			if(t.obtenerX().equals(c)) { // el equals solo funciona si son clases propias de java
				temp = t;
			}
		}
		if(temp != null)
			return temp.obtenerY();
		return null;
	}
	
	public boolean pertenece(C c) {
		return obtenerElemento(c) != null;
	}
	
	public Integer tamanio() {
		return diccionario.size();
	}
	
	public boolean estaVacio() {
		return tamanio().equals(0);  // o return diccionario.isEmpty();
	}
	
}
