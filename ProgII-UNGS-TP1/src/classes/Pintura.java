package classes;

public class Pintura extends Servicio {

	private double costePorM2;
	private double superficieEnM2;
	public int cantidadServiciosFinalizados;
	private double importeFinal;
	
	public Pintura() {
		
	}
	
	public Pintura(Integer id, Especialista especialista, String domicilio, Cliente cliente, double costePorM2,
			double superficieEnM2) {
		super(id, especialista, domicilio, cliente);
		this.costePorM2 = costePorM2;
		this.superficieEnM2 = superficieEnM2;
	}

	@Override
	public double calcularImporteTotal() {
		return costePorM2 * superficieEnM2;
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

	public double getCostePorM2() {
		return costePorM2;
	}

	public double getSuperficieEnM2() {
		return superficieEnM2;
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
