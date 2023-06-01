package classes;


public class Tupla<T1,T2> {
	
	private T1 x;
	private T2 y;
	
	private Tupla() {
		
	}
	
	public Tupla(T1 x, T2 y) {
		this.x = x;
		this.y =y;
	}
	
	
	
	public T1 obtenerX() {
		return x;
	}
	
	public T2 obtenerY() {
		return y;
	}
	
	public void establecerX(T1 x) {
		this.x = x;
	}
	
	public void establecerY(T2 y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "[" + this.x + "," + this.y + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(o.getClass() != this.getClass())  //si no son del mismo tipo de dato devuelve false
			return false;
		return (((Tupla<?, ?>) o).obtenerX().equals(this.obtenerX())); //como se sabe q es una tupla, le pido la clave y lo comparo con la clave del ya q esta establecido
	}
}
