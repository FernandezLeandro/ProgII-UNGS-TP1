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
	
	public double calcularImporteTotal(Integer cantidadHoras) {
		return 0;
	}
	
}
