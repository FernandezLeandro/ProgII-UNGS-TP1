package classes;

public abstract class Servicio {

	private Integer id;
	private double totalFacturacion;
	private Especialista especialista;
	private String domicilio;
	private Cliente cliente;
	private Boolean finalizado = false;
	public int cantidadServiciosFinalizados = 0;
	private String tipoServicio;

	public Servicio() {

	}

	public Servicio(Integer id, Especialista especialista, String domicilio, Cliente cliente) {
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
	
	public abstract void setImporteFinal(double costoFinal);
	
	public abstract double getImporteFinal();

	public Boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	public Integer getId() {
		return this.id;
	}

	public Especialista getEspecialista() {
		return this.especialista;
	}

	public String getDireccion() {
		return this.domicilio;
	}

	public String getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(String tipo) {
		this.tipoServicio = tipo;
	}

	public int getCantServiciosFinalizados() {
		return this.cantidadServiciosFinalizados;
	}
}
