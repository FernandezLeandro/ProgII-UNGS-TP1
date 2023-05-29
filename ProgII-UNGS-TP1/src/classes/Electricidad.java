package classes;

public class Electricidad extends Servicio {

	private double valorPorHora;
	private int cantidadHoras;
	public int cantidadServiciosFinalizados;
	
	
	public Electricidad() {
		
	}
	
	public Electricidad(Long id, Especialista especialista, String domicilio, Cliente cliente, double valorPorHora,
			int cantidadHoras, int cantidadServiciosFinalizados) {
		super(id, especialista, domicilio, cliente);
		this.valorPorHora = valorPorHora;
		this.cantidadHoras = cantidadHoras;
		this.cantidadServiciosFinalizados = cantidadServiciosFinalizados;
	}
	

	@Override
	public double calcularImporteTotal() {
		return cantidadHoras * valorPorHora;
	}

	@Override
	public void cambiarEspecialista(Especialista nuevoEspecialista) {
		this.setEspecialista(nuevoEspecialista);
		
	}

	@Override
	public boolean finalizado() {
		return this.finalizado();
	}

	@Override
	public void finalizarServicio() {
		if(!this.isFinalizado()) {
			this.setFinalizado(true);
			incrementarCantidadServiciosFinalizados();
		}
	}
	
}
