package classes;

public class GasistaRevision extends Gasista {

	private double costePorRevision;
	private double descuentoPorRevisionMas5;
	private double descuentoPorRevisionMas10;
	public Integer cantidadServicioFinalizados;
	
	public GasistaRevision() {
		
	}

	public GasistaRevision(Integer id, Especialista especialista, String domicilio, Cliente cliente, int cantArtefactos,
			double precioPorArtefacto) {
		super(id, especialista, domicilio, cliente, cantArtefactos, precioPorArtefacto);
		this.costePorRevision = precioPorArtefacto;
	}
	
	@Override
	public double calcularImporteTotal() {
		return costePorRevision * getCantArtefactos() - ((5 < getCantArtefactos() && getCantArtefactos() < 10) ? 
				getCantArtefactos() * (descuentoPorRevisionMas5 / 100) : 0) - 
				((10 < getCantArtefactos()) ? getCantArtefactos() * (descuentoPorRevisionMas10 / 100) : 0);
	}

	@Override
	public void cambiarEspecialista(Especialista nuevoEspecialista) {
		setEspecialista(nuevoEspecialista);
		
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

	
}
