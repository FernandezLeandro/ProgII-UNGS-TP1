package classes;

public class Gasista extends Servicio {

	private Integer cantidadArtefactos;
	public Integer cantidadServicioFinalizados;
	private double importeFinal;

	public Gasista() {

	}

	public Gasista(Integer id, Especialista especialista, String domicilio, Cliente cliente, int cantArtefactos,
			double precioPorArtefacto) {
		super(id, especialista, domicilio, cliente);
		
		this.cantidadArtefactos = cantArtefactos;

	}

	@Override
	public double calcularImporteTotal() {
		return 0;
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

	public double getCantArtefactos() {
		return this.cantidadArtefactos;
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
