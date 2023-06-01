package classes;

public class GasistaInstalacion extends Gasista {

	private double costePorInstalacion;
	public Integer cantidadServicioFinalizados;
	private double importeFinal;

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
		setFinalizado(true);
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
