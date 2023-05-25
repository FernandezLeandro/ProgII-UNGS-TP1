package classes;

public class PinturaEnAltura extends Servicio {

	private double costeSeguro;
	private double valorAndamio;
	private double aumentoAlquilerAndamio;
	
	public PinturaEnAltura() {
		
	}
	
	public PinturaEnAltura(Long id, Especialista especialista, String domicilio, Cliente cliente, double costeSeguro,
			double valorAndamio, double aumentoAlquilerAndamio) {
		super(id, especialista, domicilio, cliente);
		this.costeSeguro = costeSeguro;
		this.valorAndamio = valorAndamio;
		this.aumentoAlquilerAndamio = aumentoAlquilerAndamio;
	}
	
	public double calcularImporteTotal(Integer superficieEnM2, Integer cantidadAndamios) {
		return 0;
	}
	
}
