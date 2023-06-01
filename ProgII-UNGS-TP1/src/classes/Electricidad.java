package classes;

public class Electricidad extends Servicio {

	private double valorPorHora;
	private int cantidadHoras;
	public int cantidadServiciosFinalizados;
	private double importeFinal;

	public Electricidad() {

	}

	public Electricidad(Integer id, Especialista especialista, String domicilio, Cliente cliente, double valorPorHora,
			int cantidadHoras) {
		super(id, especialista, domicilio, cliente);
		this.valorPorHora = valorPorHora;
		this.cantidadHoras = cantidadHoras;
		this.cantidadServiciosFinalizados = cantidadServiciosFinalizados;
		this.importeFinal = importeFinal;
	}

	@Override
	public double calcularImporteTotal() {
		return cantidadHoras * valorPorHora;
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
