package classes;

public abstract class Servicio {

	private Long id;
	private double totalFacturacion;
	private Especialista especialista;
	private String domicilio;
	private Cliente cliente;
	private Boolean finalizado;
	
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
		
	}
	
	public void cambiarEspecialista(Especialista nuevoEspecialista) {
		
	}
	
	public boolean finalizado() {
		return this.finalizado();
	}
	
	public void finalizarServicio() {
		this.finalizado = true;
	}
	
}
