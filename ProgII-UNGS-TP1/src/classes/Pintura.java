package classes;

public class Pintura extends Servicio {

	private double costePorM2;
	private double superficieEnM2;
	public int cantidadServiciosFinalizados;
	
	public Pintura() {
		
	}
	
	public Pintura(Long id, Especialista especialista, String domicilio, Cliente cliente, double costePorM2,
			double superficieEnM2, int cantidadServiciosFinalizados) {
		super(id, especialista, domicilio, cliente);
		this.costePorM2 = costePorM2;
		this.superficieEnM2 = superficieEnM2;
		this.cantidadServiciosFinalizados = cantidadServiciosFinalizados;
	}
	
	public double calcularImporteTotal(Integer superficieEnM2) {
		return 0;
	}
	
}
