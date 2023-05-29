package classes;

public class Gasista extends Servicio {

	private double costePorInstalacion;
	private double costePorRevision;
	private double descuentoPorRevisionMas5;
	private double descuentoPorRevisionMas10;
	private String tipoServicio;
	public Integer cantidadServicioFinalizados;
	
	public Gasista() {
		
	}
	
	public Gasista(Long id, Especialista especialista, String domicilio, Cliente cliente, double costePorInstalacion,
			double costePorRevision, double descuentoPorRevisionMas5, double descuentoPorRevisionMas10,
			String tipoServicio, Integer cantidadServicioFinalizados) {
		super(id, especialista, domicilio, cliente);
		this.costePorInstalacion = costePorInstalacion;
		this.costePorRevision = costePorRevision;
		this.descuentoPorRevisionMas5 = descuentoPorRevisionMas5;
		this.descuentoPorRevisionMas10 = descuentoPorRevisionMas10;
		this.tipoServicio = tipoServicio;
		this.cantidadServicioFinalizados = cantidadServicioFinalizados;
	}
	
//	public double calcularImporteTotal(Integer cantidadArtefactos) {
//		return 0;
//	}

	@Override
	public double calcularImporteTotal(Integer cantidadArtefactos) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
