package classes;

public abstract class Servicio {

	private Long id;
	private double totalFacturacion;
	private Especialista especialista;
	private String domicilio;
	private Cliente cliente;
	private Boolean finalizado;
	private int cantidadServiciosFinalizados = 0;
	
	public Servicio() {
		
	}
	
	
	public Servicio(Long id, Especialista especialista, String domicilio, Cliente cliente) {
		super();
		this.id = id;
		this.especialista = especialista;
		this.domicilio = domicilio;
		this.cliente = cliente;
	}
	
	public abstract double calcularImporteTotal();
	
	public void incrementarCantidadServiciosFinalizados() {
		cantidadServiciosFinalizados++;
	}
	
	public abstract void cambiarEspecialista(Especialista nuevoEspecialista);
	
	public abstract boolean finalizado();
	
	public abstract void finalizarServicio();
	

	public Boolean isFinalizado() {
		return finalizado;
	}


	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}
	
}
