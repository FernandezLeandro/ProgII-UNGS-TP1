package classes;

public class Gasista extends Servicio {

	private double costePorInstalacion;
	private double costePorRevision;
	private double descuentoPorRevisionMas5;
	private double descuentoPorRevisionMas10;
	private String tipoServicio;
	private Integer cantidadArtefactosRevisar;
	private Integer cantidadArtefactosInstalar;
	public Integer cantidadServicioFinalizados;
	
	public Gasista() {
		
	}
	
	public Gasista(Long id, Especialista especialista, String domicilio, Cliente cliente, double costePorInstalacion,
			double costePorRevision, double descuentoPorRevisionMas5, double descuentoPorRevisionMas10,
			String tipoServicio, Integer cantidadServicioFinalizados, Integer cantidadArtefactosRevisar, Integer cantidadArtefactosInstalar) {
		super(id, especialista, domicilio, cliente);
		this.costePorInstalacion = costePorInstalacion;
		this.costePorRevision = costePorRevision;
		this.descuentoPorRevisionMas5 = descuentoPorRevisionMas5;
		this.descuentoPorRevisionMas10 = descuentoPorRevisionMas10;
		this.tipoServicio = tipoServicio;
		this.cantidadServicioFinalizados = cantidadServicioFinalizados;
		this.cantidadArtefactosRevisar = cantidadArtefactosRevisar;
		this.cantidadArtefactosInstalar = cantidadArtefactosInstalar;
	}
	
//	public double calcularImporteTotal(Integer cantidadArtefactos) {
//		return 0;
//	}

	@Override
	public double calcularImporteTotal() {
		return ((cantidadArtefactosInstalar * costePorInstalacion) + (cantidadArtefactosRevisar * costePorRevision - ((cantidadArtefactosRevisar > 5) ? costePorRevision * 0.1 * cantidadArtefactosRevisar : 0 )) - ((cantidadArtefactosRevisar > 10) ? costePorRevision * 0.15 * cantidadArtefactosRevisar : 0));
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
		if(!this.isFinalizado()) {
			this.setFinalizado(true);
			incrementarCantidadServiciosFinalizados();
		}
	}

	
}
