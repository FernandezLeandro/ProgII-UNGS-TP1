package classes;

public class PinturaEnAltura extends Pintura {

	private double costeSeguro;

	private double aumentoAlquilerAndamio = 20/100;
	private int piso;
	private double alquilerAndamio;
	private double importeFinal;
	
	public PinturaEnAltura() {
		
	}
	
	public PinturaEnAltura(Integer id, Especialista especialista, String domicilio, Cliente cliente, double costePorM2,
			double superficieEnM2,int piso, double costeSeguro, double alquilerAndamio) {
		super(id, especialista, domicilio, cliente, costePorM2, superficieEnM2);
		this.costeSeguro = costeSeguro;
		this.aumentoAlquilerAndamio = aumentoAlquilerAndamio;
		this.alquilerAndamio = alquilerAndamio;
	}

	@Override
	public double calcularImporteTotal() {
		return getCostePorM2() * getSuperficieEnM2() + this.costeSeguro + 
				(((piso > 5) ? this.alquilerAndamio * this.aumentoAlquilerAndamio : this.alquilerAndamio)) ;
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
		this.setFinalizado(true);
		incrementarCantidadServiciosFinalizados();
	}
	
	@Override
	public void setImporteFinal(double costoFinal) {
		this.importeFinal = costoFinal;
	}
	
	@Override
	public double getImporteFinal() {
		return this.importeFinal;
	}
	
}
