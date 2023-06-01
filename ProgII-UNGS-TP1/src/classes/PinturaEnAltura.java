package classes;

public class PinturaEnAltura extends Pintura {

	private double costeSeguro;

	private double aumentoAlquilerAndamio;
	private int piso;
	
	public PinturaEnAltura() {
		
	}
	
	public PinturaEnAltura(Integer id, Especialista especialista, String domicilio, Cliente cliente, double costePorM2,
			double superficieEnM2,int piso, double costeSeguro, double aumentoAlquilerAndamio) {
		super(id, especialista, domicilio, cliente, costePorM2, superficieEnM2);
		this.costeSeguro = costeSeguro;
		this.aumentoAlquilerAndamio = aumentoAlquilerAndamio;
	}

	@Override
	public double calcularImporteTotal() {
		return getCostePorM2() * getSuperficieEnM2() + costeSeguro * (((piso > 5) ? aumentoAlquilerAndamio / 100 : 1)) ;
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
