package classes;

public class Gasista extends Servicio {

	private String tipoServicio;
	private Integer cantidadArtefactos;
	public Integer cantidadServicioFinalizados;
	
	public Gasista() {
		
	}
	
	public Gasista(Integer id, Especialista especialista, String domicilio, Cliente cliente, int cantArtefactos, 
			double precioPorArtefacto) {
		super(id, especialista, domicilio, cliente);
		
		this.tipoServicio = tipoServicio;
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
		if(!this.isFinalizado()) {
			this.setFinalizado(true);
			incrementarCantidadServiciosFinalizados();
		}
	}
	
	public double getCantArtefactos() {
		return this.cantidadArtefactos;
	}

	
}
