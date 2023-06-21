package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Set;

import java.util.Iterator;
import java.util.Map;

public class EmpresaDeServicios implements Empresa {

	private HashMap<Integer,Especialista> listaEspecialistas;
	private Set<Cliente> listaClientes;
	private HashMap<Integer, Servicio> listaServicios;
	private HashMap<String, Double> listaFacturaciones;
	private Integer contServicios = -1;
	private Integer cantServiciosFinalizados = 0;
	private Integer cantServiciosARealizar = 0;
	private Integer cantEspecialistasRegistrados = 0;
	private Integer cantClientesRegistrados = 0;
	private Double recaudacionTotal = 0.0;
	private String[] especialidades = {"Electricidad", "Pintura", "PinturaEnAltura", "GasistaInstalacion", "GasistaRevision"};
	

	public EmpresaDeServicios() {
		this.listaClientes = new HashSet<Cliente>();
		this.listaEspecialistas = new HashMap<Integer,Especialista>();
		this.listaServicios = new HashMap<Integer, Servicio>();
		this.listaFacturaciones = new HashMap<String, Double>();
		this.contServicios = contServicios;
		this.cantServiciosFinalizados = cantServiciosFinalizados;
		this.cantServiciosARealizar = cantServiciosARealizar;;
		this.cantEspecialistasRegistrados = cantEspecialistasRegistrados;
		this.cantClientesRegistrados = cantClientesRegistrados;
		this.recaudacionTotal = recaudacionTotal;
		this.especialidades = especialidades;
		
	}
	
	

	@Override
	public void registrarCliente(int dni, String nombre, String telefono) {
		if (buscarCliente(dni) != null)
			throw new RuntimeException("DNI ya existente");
		this.listaClientes.add(new Cliente(dni, nombre, telefono));
		incrementarCantClientesRegistrados();

	}

	@Override
	public void registrarEspecialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		if (existeEspecialista(nroEspecialista)) {
			throw new RuntimeException("Especialista ya registrado");
		}else if(!verificarEspecialidad(especialidad))
			throw new RuntimeException("Especialista incorrecto");
		Especialista e = new Especialista(nroEspecialista, nombre, telefono, especialidad);
		this.listaEspecialistas.put(nroEspecialista, e);
		incrementarCantEspecialistasRegistrados();

	}

	@Override
	public int solicitarServicioElectricidad(int dni, int nroEspecialista, String direccion, double precioPorHora,
			int horasTrabajadas) {

		String tipo = this.especialidades[0]; // "Electricidad"
		if (buscarCliente(dni) == null)
			throw new RuntimeException("DNI inexistente");
		if (!existeEspecialista(nroEspecialista))
			throw new RuntimeException("ID Especialista inexistente");
		if (!buscarEspecialista(nroEspecialista).getEspecialidad().equals(tipo))
			throw new RuntimeException("Especialista N: " + nroEspecialista + " no aplica al servicio solicitado");
		if (precioPorHora <= 0 || horasTrabajadas <= 0)
			throw new RuntimeException("valores invalidos");

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio electricidad = new Electricidad(this.contServicios, e, direccion, buscarCliente(dni), precioPorHora,
				horasTrabajadas);

		this.listaServicios.put(contServicios, electricidad);
		e.addServicioHistorial(electricidad);
		electricidad.setTipoServicio(tipo);
		incrementarCantServiciosARealizar();
		incrementarContServicios();

		return electricidad.getId();
	}

	@Override
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado) {

		String tipo = especialidades[1]; //"Pintura"
		if (buscarCliente(dni) == null)
			throw new RuntimeException("DNI inexistente");
		if (!existeEspecialista(nroEspecialista))
			throw new RuntimeException("ID Especialista inexistente");
		if (!buscarEspecialista(nroEspecialista).getEspecialidad().equals(tipo))
			throw new RuntimeException("Especialista N: " + nroEspecialista + " no aplica al servicio solicitado");
		if (metrosCuadrados <= 0 || precioPorMetroCuadrado <= 0)
			throw new RuntimeException("valores invalidos");

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio pintura = new Pintura(this.contServicios, e, direccion, buscarCliente(dni), precioPorMetroCuadrado,
				metrosCuadrados);

		this.listaServicios.put(contServicios, pintura);
		e.addServicioHistorial(pintura);
		pintura.setTipoServicio(tipo);
		incrementarCantServiciosARealizar();
		incrementarContServicios();

		return pintura.getId();
	}

	@Override
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado, int piso, double seguro, double alqAndamios) {

		String tipo = this.especialidades[2]; //"PinturaEnAltura"
		if (buscarCliente(dni) == null)
			throw new RuntimeException("DNI inexistente");
		if (!existeEspecialista(nroEspecialista))
			throw new RuntimeException("ID Especialista inexistente");
		if (!buscarEspecialista(nroEspecialista).getEspecialidad().equals(tipo))
			throw new RuntimeException("Especialista N: " + nroEspecialista + " no aplica al servicio solicitado");
		if (metrosCuadrados <= 0 || precioPorMetroCuadrado <= 0 || piso <= 0 || seguro <= 0 || alqAndamios <= 0)
			throw new RuntimeException("valores invalidos");

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio altura = new PinturaEnAltura(this.contServicios, e, direccion, buscarCliente(dni),
				precioPorMetroCuadrado, metrosCuadrados, piso, seguro, alqAndamios);

		this.listaServicios.put(contServicios, altura);
		e.addServicioHistorial(altura);
		altura.setTipoServicio(tipo);
		incrementarCantServiciosARealizar();
		incrementarContServicios();

		
		return altura.getId();
	}

	@Override
	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {

		String tipo = this.especialidades[3]; //"GasistaInstalacion" 
		if (buscarCliente(dni) == null)
			throw new RuntimeException("DNI inexistente");
		if (!existeEspecialista(nroEspecialista))
			throw new RuntimeException("ID Especialista inexistente");
		if (!buscarEspecialista(nroEspecialista).getEspecialidad().equals(tipo))
			throw new RuntimeException("Especialista N: " + nroEspecialista + " no aplica al servicio solicitado");
		if (cantArtefactos <= 0 || precioPorArtefacto <= 0)
			throw new RuntimeException("valores invalidos");

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio instalacion = new GasistaInstalacion(this.contServicios, e, direccion, buscarCliente(dni),
				cantArtefactos, precioPorArtefacto);

		this.listaServicios.put(contServicios, instalacion);
		e.addServicioHistorial(instalacion);
		instalacion.setTipoServicio(tipo);
		incrementarCantServiciosARealizar();
		incrementarContServicios();

		
		return instalacion.getId();
	}

	@Override
	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {

		String tipo = this.especialidades[4]; //"GasistaRevision"
		if (buscarCliente(dni) == null)
			throw new RuntimeException("DNI inexistente");
		if (!existeEspecialista(nroEspecialista))
			throw new RuntimeException("ID Especialista inexistente");
		if (!buscarEspecialista(nroEspecialista).getEspecialidad().equals(tipo))
			throw new RuntimeException("Especialista N: " + nroEspecialista + " no aplica al servicio solicitado");
		if (cantArtefactos <= 0 || precioPorArtefacto <= 0)
			throw new RuntimeException("valores invalidos");

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio revision = new GasistaRevision(this.contServicios, e, direccion, buscarCliente(dni), cantArtefactos,
				precioPorArtefacto);

		this.listaServicios.put(contServicios, revision);

		e.addServicioHistorial(revision);
		incrementarContServicios();
		revision.setTipoServicio(tipo);
		incrementarCantServiciosARealizar();

		return revision.getId();
	}

	@Override
	public double finalizarServicio(int codServicio, double costoMateriales) {

		Servicio s = buscarServicio(codServicio);
		s.finalizarServicio();
		incrementarCantServiciosFinalizados();
		decrementarCantServiciosARealizar();
		double costoFinal = s.calcularImporteTotal() + costoMateriales;
		s.setImporteFinal(costoFinal);
		incrementarRecaudacionTipoServicio(s.getTipoServicio(), costoFinal);
		incrementarRecaudacionTotal(costoFinal);
		return costoFinal;
	}

	@Override
	public Map<String, Integer> cantidadDeServiciosRealizadosPorTipo() {
		Integer elec = 0, pintura = 0, altura = 0, gasrev = 0, gasins = 0;
		String el = this.especialidades[0], pin = this.especialidades[1], al = this.especialidades[2], 
		gi = this.especialidades[3], gr = this.especialidades[4];
		for (Servicio s : this.listaServicios.values()) {
			if (s.getTipoServicio().equals(el) && s.isFinalizado()) { // "Electricidad"
				elec++;
			} else if (s.getTipoServicio().equals(pin) && s.isFinalizado()) { // "Pintura"
				pintura++;
			} else if (s.getTipoServicio().equals(al) && s.isFinalizado()) { // "PinturaEnAltura"
				altura++;
			} else if (s.getTipoServicio().equals(gi) && s.isFinalizado()) { // "GasistaInstalacion"
				gasins++;
			} else if (s.getTipoServicio().equals(gr) && s.isFinalizado()) { // "GasistaRevision"
				gasrev++;
			}
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put(el, elec);
		map.put(pin, pintura);
		map.put(al, altura);
		map.put(gi, gasins);
		map.put(gr, gasrev);

		return map;
	}

	@Override
	public double facturacionTotalPorTipo(String tipoServicio) {

		return listaFacturaciones.get(tipoServicio);
	}

	@Override
	public double facturacionTotal() {

//		return listaFacturaciones.values().stream().mapToDouble(Double::doubleValue).sum();
		return this.recaudacionTotal;
	}

	@Override
	public void cambiarResponsable(int codServicio, int nroEspecialista) {

		if (!existeEspecialista(nroEspecialista)) {
			throw new RuntimeException("No se encuentra especialista N: " + nroEspecialista);
		}
		if(!existeServicio(codServicio)) {
			throw new RuntimeException("No se encuentra servicio N: " + codServicio);
		}
		Servicio s = buscarServicio(codServicio);
		Especialista e = buscarEspecialista(nroEspecialista);
		if(!s.getTipoServicio().equals(e.getEspecialidad())) {
			throw new RuntimeException("Especialista invalido");
		}else {
			s.cambiarEspecialista(e);
		}

	}

	@Override
	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista) {

		if (!existeEspecialista(nroEspecialista)) {
			throw new RuntimeException("No se encuentra especialista N: " + nroEspecialista);
		}
		Especialista e = buscarEspecialista(nroEspecialista);
		StringBuilder build = new StringBuilder();

		for (Servicio s : e.getHistorialServiciosRealizados()) {
			build.append(" + [ ");
			build.append(s.getId());
			build.append(" - ");
			build.append(e.getEspecialidad());
			build.append(" ] ");
			build.append(s.getDireccion());
			build.append(("\n"));
		}
		String listado = build.toString();
		return listado;
	}

	private boolean existeEspecialista(int nroEspecialista) {
		return this.listaEspecialistas.containsKey(nroEspecialista);
	}
	
	private boolean existeServicio(int codServicio) {
		return this.listaServicios.containsKey(codServicio);
	}

	public Especialista buscarEspecialista(int nroEspecialista) {
		return this.listaEspecialistas.get(nroEspecialista);
	}

	public Cliente buscarCliente(int dni) {
		for (Cliente c : this.listaClientes) {
			if (c.hashCode() == dni) {
				return c;
			}
		}
		return null;
	}

	public Servicio buscarServicio(Integer codServicio) {
		if (!this.listaServicios.containsKey((Integer) codServicio))
			throw new RuntimeException("No se encuentra el codigo de servicio N: " + codServicio);
		return this.listaServicios.get(codServicio);
	}

	private boolean verificarEspecialidad(String especialidad) {
		return TipoServicio.esTipoServicio(especialidad);
	}
	
	public void incrementarRecaudacionTipoServicio(String tipo, double facturacion) {
		if(!this.listaFacturaciones.containsKey(tipo)) {
			this.listaFacturaciones.put(tipo, facturacion);
		}else {
			Double f = this.listaFacturaciones.get(tipo);
			this.listaFacturaciones.replace(tipo, f, f + facturacion);
		}
	}
	
	public void incrementarRecaudacionTotal(double facturacion) {
		this.recaudacionTotal += facturacion;
	}
	
	public void incrementarCantClientesRegistrados() {
		this.cantClientesRegistrados++;
	}
	
	public void incrementarCantEspecialistasRegistrados() {
		this.cantEspecialistasRegistrados++;
	}
	
	public void incrementarContServicios() {
		this.contServicios++;
	}
	
	public void incrementarCantServiciosARealizar() {
		this.cantServiciosARealizar++;
	}
	
	public void decrementarCantServiciosARealizar() {
		this.cantServiciosARealizar--;
	}
	
	public void incrementarCantServiciosFinalizados() {
		this.cantServiciosFinalizados++;
	}
	
	
	// metodo para agregar una especialidad, como pedia en la primera parte.
	public void agregarEspecialidad(String especialidad) {
		String[] lista = Arrays.copyOf(this.especialidades, this.especialidades.length +1);
		lista[this.especialidades.length] = especialidad;
		this.especialidades = lista;
	}
	
	public String especialidadesToString() {
		String c = "[";
		for(int i = 0; i < this.especialidades.length; i++) {
			if(i != this.especialidades.length-1)
				c = c + this.especialidades[i] + " , ";
			else
				c = c + this.especialidades[i] + "]";
		}
		return c;
	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("El Tano Construcciones|");
		build.append("TotalFacturacion = ");
		build.append(facturacionTotal());
		build.append(" | ");
		build.append("Cantidad de Servicios finalizados: ");
		build.append(this.cantServiciosFinalizados);
		build.append(" | ");
		build.append("Cantidad de Servicios a realizar: ");
		build.append(this.cantServiciosARealizar);
		build.append(" | ");
		build.append("Cantidad de Especialistas registrados: ");
		build.append(this.cantEspecialistasRegistrados);
		build.append(" | ");
		build.append("Cantidad de clientes Registrados; ");
		build.append(this.cantClientesRegistrados);
		
		String fin = build.toString();

		return fin;
	}

}
