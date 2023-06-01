package classes;

public class GasistaInstalacion extends Gasista {

	private double costePorInstalacion;
	public Integer cantidadServicioFinalizados;
	
	public GasistaInstalacion() {
		
	}

	public GasistaInstalacion(Integer id, Especialista especialista, String domicilio, Cliente cliente,
			int cantArtefactos, double precioPorArtefacto) {
		super(id, especialista, domicilio, cliente, cantArtefactos, precioPorArtefacto);
		this.costePorInstalacion = precioPorArtefacto;
	}
	
	@Override
	public double calcularImporteTotal() {
		return costePorInstalacion * getCantArtefactos();
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
