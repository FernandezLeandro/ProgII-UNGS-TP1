package classes;

import java.util.Map;

public class EmpresaDeServicios implements Empresa{
	
	private Conjunto<Especialista> listaEspecialistas;
	private Conjunto<Cliente> listaClientes;
	private Diccionario<Long,Servicio> listasServicios;
	
	public EmpresaDeServicios () {
		this.listaClientes = new Conjunto<Cliente>();
		this.listaEspecialistas = new Conjunto <Especialista>();
		this.listasServicios = new Diccionario<Long,Servicio>();
	}

	@Override
	public void registrarCliente(int dni, String nombre, String telefono) {
		listaClientes.agregar(new Cliente(dni, nombre, telefono));
		
	}

	@Override
	public void registrarEspecialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		listaEspecialistas.agregar(new Especialista(nroEspecialista,nombre,telefono,especialidad));
		
	}

	@Override
	public int solicitarServicioElectricidad(int dni, int nroEspecialista, String direccion, double precioPorHora,
			int horasTrabajadas) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado, int piso, double seguro, double alqAndamios) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double finalizarServicio(int codServicio, double costoMateriales) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Integer> cantidadDeServiciosRealizadosPorTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double facturacionTotalPorTipo(String tipoServicio) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double facturacionTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cambiarResponsable(int codServicio, int nroEspecialista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista) {
		// TODO Auto-generated method stub
		return null;
	}

}
