package classes;

public class PinturaEnAltura extends Pintura {

	private double costeSeguro;
	private double valorAndamio;
	private double aumentoAlquilerAndamio;
	private int piso;
	
	public PinturaEnAltura() {
		
	}
	
	public PinturaEnAltura(Long id, Especialista especialista, String domicilio, Cliente cliente, double costePorM2,
			double superficieEnM2, int cantidadServiciosFinalizados, double costeSeguro, double valorAndamio,
			double aumentoAlquilerAndamio) {
		super(id, especialista, domicilio, cliente, costePorM2, superficieEnM2, cantidadServiciosFinalizados);
		this.costeSeguro = costeSeguro;
		this.valorAndamio = valorAndamio;
		this.aumentoAlquilerAndamio = aumentoAlquilerAndamio;
	}

	@Override
	public double calcularImporteTotal() {
		return getCostePorM2() * getSuperficieEnM2() + costeSeguro + valorAndamio + ((piso > 5) ? aumentoAlquilerAndamio * valorAndamio : 0) ;
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
