package classes;

import java.util.ArrayList;
 
public class Conjunto<T> {

	private ArrayList<T> conjunto;
	private int posicion;
	
	public Conjunto() {
		conjunto = new ArrayList<>();
		posicion = -1;
		
	}
	
	public int tamanio() {
		return conjunto.size();
	}
	
	public boolean vacio() {
		return tamanio() == 0;
	}
	
	public void agregar(T elemento) {
	
		if (!pertenece(elemento)){
			conjunto.add(elemento);
		}else
			throw new RuntimeException();
	}
	
	public T dameUno() {
		if(vacio())    //si el conjunto esta vacio.
			return null;
		if (posicion == tamanio())
			posicion = -1;
		return conjunto.get(posicion++);  //o ++posicion
	}
	
	private boolean pertenece(T elemento) {
		return conjunto.contains(elemento);
	}
	
	public String toString() {
		String elementos = "{";
		for(int i = 0; i < tamanio(); i++) {
			if(i == tamanio()-1)
				elementos += conjunto.get(i) + "}";
			else
				elementos += conjunto.get(i) + ",";
		}
		return elementos;
	}
	
	public void union (Conjunto<T> c) {
		if(c.tamanio() != 0) {
			for(T elem : c.conjunto) {
					agregar(elem);
				}
			}
	}

	private Conjunto<T> union2(T elem) {
		Conjunto<T> unionConj = new Conjunto<>();
		unionConj.agregar(elem);
		return unionConj;
	}
	
	public void interseccion1(Conjunto<T> c) {
		if(c.tamanio() != 0) {
			for(T elem : c.conjunto) {
				if(this.pertenece(elem)) {
					this.conjunto.remove(elem);
				}
			}
		}
	}
	
	private Conjunto<T> interseccion2(T elem){
		Conjunto<T> interseccionConj = new Conjunto<>();
		if(pertenece(elem)) {
			interseccionConj.agregar(elem);
		}
		return interseccionConj;
	}
}
