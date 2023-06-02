package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Set;

import java.util.Iterator;
import java.util.Map;

public class EmpresaDeServicios implements Empresa {

	private Set<Especialista> listaEspecialistas;
	private Set<Cliente> listaClientes;
	private HashMap<Integer, Servicio> listaServicios;
	private Integer contServicios = -1;
	private Integer cantServiciosFinalizados = 0;
	private Integer cantServiciosARealizar = 0;
	private Integer cantEspecialistasRegistrados = 0;
	private Integer cantClientesRegistrados = 0;

	public EmpresaDeServicios() {
		this.listaClientes = new HashSet<Cliente>();
		this.listaEspecialistas = new HashSet<Especialista>();
		this.listaServicios = new HashMap<Integer, Servicio>();
		this.contServicios = contServicios;
		this.cantServiciosFinalizados = cantServiciosFinalizados;
		this.cantServiciosARealizar = cantServiciosARealizar;;
		this.cantEspecialistasRegistrados = cantEspecialistasRegistrados;
		this.cantClientesRegistrados = cantClientesRegistrados;
	}

	@Override
	public void registrarCliente(int dni, String nombre, String telefono) {
		if (buscarCliente(dni) != null)
			throw new RuntimeException("DNI ya existente");
		listaClientes.add(new Cliente(dni, nombre, telefono));
		this.cantClientesRegistrados++;

	}

	@Override
	public void registrarEspecialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		if (!existeEspecialista(nroEspecialista) && verificarEspecialidad(especialidad)) {
			listaEspecialistas.add(new Especialista(nroEspecialista, nombre, telefono, especialidad));
			this.cantEspecialistasRegistrados++;
		} else
			throw new RuntimeException("Especialista ya registrado");

	}

	@Override
	public int solicitarServicioElectricidad(int dni, int nroEspecialista, String direccion, double precioPorHora,
			int horasTrabajadas) {

		if (buscarCliente(dni) == null)
			throw new RuntimeException("DNI inexistente");
		if (!existeEspecialista(nroEspecialista))
			throw new RuntimeException("ID Especialista inexistente");
		if (!buscarEspecialista(nroEspecialista).getEspecialidad().equals("Electricidad"))
			throw new RuntimeException("Especialista N: " + nroEspecialista + " no aplica al servicio solicitado");
		if (precioPorHora <= 0 || horasTrabajadas <= 0)
			throw new RuntimeException("valores invalidos");

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio electricidad = new Electricidad(this.contServicios, e, direccion, buscarCliente(dni), precioPorHora,
				horasTrabajadas);

		listaServicios.put(contServicios, electricidad);
		e.addServicioHistorial(electricidad);
		electricidad.setTipoServicio("Electricidad");
		this.cantServiciosARealizar++;
		this.contServicios++;

		return electricidad.getId();
	}

	@Override
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado) {

		if (buscarCliente(dni) == null)
			throw new RuntimeException("DNI inexistente");
		if (!existeEspecialista(nroEspecialista))
			throw new RuntimeException("ID Especialista inexistente");
		if (!buscarEspecialista(nroEspecialista).getEspecialidad().equals("Pintura"))
			throw new RuntimeException("Especialista N: " + nroEspecialista + " no aplica al servicio solicitado");
		if (metrosCuadrados <= 0 || precioPorMetroCuadrado <= 0)
			throw new RuntimeException("valores invalidos");

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio pintura = new Pintura(this.contServicios, e, direccion, buscarCliente(dni), precioPorMetroCuadrado,
				metrosCuadrados);

		listaServicios.put(contServicios, pintura);
		e.addServicioHistorial(pintura);
		pintura.setTipoServicio("Pintura");
		this.cantServiciosARealizar++;
		this.contServicios++;

		return pintura.getId();
	}

	@Override
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado, int piso, double seguro, double alqAndamios) {

		if (buscarCliente(dni) == null)
			throw new RuntimeException("DNI inexistente");
		if (!existeEspecialista(nroEspecialista))
			throw new RuntimeException("ID Especialista inexistente");
		if (!buscarEspecialista(nroEspecialista).getEspecialidad().equals("PinturaEnAltura"))
			throw new RuntimeException("Especialista N: " + nroEspecialista + " no aplica al servicio solicitado");
		if (metrosCuadrados <= 0 || precioPorMetroCuadrado <= 0 || piso <= 0 || seguro <= 0 || alqAndamios <= 0)
			throw new RuntimeException("valores invalidos");

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio altura = new PinturaEnAltura(this.contServicios, e, direccion, buscarCliente(dni),
				precioPorMetroCuadrado, metrosCuadrados, piso, seguro, alqAndamios);

		listaServicios.put(contServicios, altura);
		e.addServicioHistorial(altura);
		altura.setTipoServicio("PinturaEnAltura");
		this.cantServiciosARealizar++;
		this.contServicios++;

		return altura.getId();
	}

	@Override
	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {

		if (buscarCliente(dni) == null)
			throw new RuntimeException("DNI inexistente");
		if (!existeEspecialista(nroEspecialista))
			throw new RuntimeException("ID Especialista inexistente");
		if (!buscarEspecialista(nroEspecialista).getEspecialidad().equals("GasistaInstalacion"))
			throw new RuntimeException("Especialista N: " + nroEspecialista + " no aplica al servicio solicitado");
		if (cantArtefactos <= 0 || precioPorArtefacto <= 0)
			throw new RuntimeException("valores invalidos");

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio instalacion = new GasistaInstalacion(this.contServicios, e, direccion, buscarCliente(dni),
				cantArtefactos, precioPorArtefacto);

		listaServicios.put(contServicios, instalacion);
		e.addServicioHistorial(instalacion);
		instalacion.setTipoServicio("GasistaInstalacion");
		this.cantServiciosARealizar++;
		this.contServicios++;

		return instalacion.getId();
	}

	@Override
	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {

		if (buscarCliente(dni) == null)
			throw new RuntimeException("DNI inexistente");
		if (!existeEspecialista(nroEspecialista))
			throw new RuntimeException("ID Especialista inexistente");
		if (!buscarEspecialista(nroEspecialista).getEspecialidad().equals("GasistaRevision"))
			throw new RuntimeException("Especialista N: " + nroEspecialista + " no aplica al servicio solicitado");
		if (cantArtefactos <= 0 || precioPorArtefacto <= 0)
			throw new RuntimeException("valores invalidos");

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio revision = new GasistaRevision(this.contServicios, e, direccion, buscarCliente(dni), cantArtefactos,
				precioPorArtefacto);

		listaServicios.put(contServicios, revision);

		e.addServicioHistorial(revision);
		this.contServicios++;
		revision.setTipoServicio("GasistaRevision");
		this.cantServiciosARealizar++;

		return revision.getId();
	}

	@Override
	public double finalizarServicio(int codServicio, double costoMateriales) {

		Servicio s = buscarServicio(codServicio);
		s.finalizarServicio();
		this.cantServiciosFinalizados++;
		this.cantServiciosARealizar--;
		double costoFinal = s.calcularImporteTotal() + costoMateriales;
		s.setImporteFinal(costoFinal);
		return costoFinal;
	}

	@Override
	public Map<String, Integer> cantidadDeServiciosRealizadosPorTipo() {
		Integer elec = 0, pintura = 0, altura = 0, gasrev = 0, gasins = 0;
		String el = "Electricidad", pin = "Pintura", al = "PinturaEnAltura", gr = "GasistaRevision", gi = "GasistaInstalacion";
		for (Servicio s : listaServicios.values()) {
			if (s.getTipoServicio().equals(el)) {
				elec++;
			} else if (s.getTipoServicio().equals(pin) && s.isFinalizado()) {
				pintura++;
			} else if (s.getTipoServicio().equals(al) && s.isFinalizado()) {
				altura++;
			} else if (s.getTipoServicio().equals(gr) && s.isFinalizado()) {
				gasrev++;
			} else if (s.getTipoServicio().equals(gi) && s.isFinalizado()) {
				gasins++;
			}
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put(el, elec);
		map.put(pin, pintura);
		map.put(al, altura);
		map.put(gr, gasrev);
		map.put(gi, gasins);

		return map;
	}

	@Override
	public double facturacionTotalPorTipo(String tipoServicio) {

		double total = 0;
		for (Servicio s : listaServicios.values()) {
			if (s.getTipoServicio().equals(tipoServicio)) {
				total += s.getImporteFinal();
			}
		}
		return total;
	}

	@Override
	public double facturacionTotal() {

		double total = 0;
		for (Servicio s : listaServicios.values()) {
			total += s.getImporteFinal();
		}
		return total;
	}

	@Override
	public void cambiarResponsable(int codServicio, int nroEspecialista) {

		if (!existeEspecialista(nroEspecialista)) {
			throw new RuntimeException("No se encuentra especialista N: " + nroEspecialista);
		}
		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio servicio = buscarServicio(codServicio);
		// La especialidad puede cambiar si es de algun tipo de pintura, por eso se
		// comprueba si es en altura o no
		if (servicio.getTipoServicio().equals(TipoServicio.PINTURA.getName())
				|| servicio.getTipoServicio().equals(TipoServicio.PINTURA_EN_ALTURA.getName())) {
			if (e.getEspecialidad().equals(TipoServicio.PINTURA.getName()) 
					|| e.getEspecialidad().equals(TipoServicio.PINTURA_EN_ALTURA.getName())) {
				
				servicio.getEspecialista().addServicioHistorial(servicio);
				buscarServicio(codServicio).setEspecialista(e);
			} else
				throw new RuntimeException();
		} else {
			// Se comprueba que sea del mismo tipo de especialidad, sin la validacion de
			// arriba decia que Pintura!= PinturaEnAltura, y no es la idea ya que un pintor
			// puede hacer ambos
			if (!servicio.getTipoServicio().equals(e.getEspecialidad())) {
				throw new RuntimeException();
			} else
				servicio.getEspecialista().addServicioHistorial(servicio);
				buscarServicio(codServicio).setEspecialista(e);
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
		boolean encontro = false;
		if (!listaEspecialistas.isEmpty()) {
			Iterator<Especialista> it = listaEspecialistas.iterator();
			while (it.hasNext()) {
				if (it.next().getIdEspecialista() == nroEspecialista) {
					encontro = true;
				}
			}
		}
		return encontro;
	}

	public Especialista buscarEspecialista(int nroEspecialista) {
		for (Especialista e : listaEspecialistas) {
			if (nroEspecialista == e.getIdEspecialista()) {
				return e;
			}
		}
		return null;
	}

	public Cliente buscarCliente(int dni) {
		for (Cliente c : listaClientes) {
			if (c.hashCode() == dni) {
				return c;
			}
		}
		return null;
	}

	public Servicio buscarServicio(Integer codServicio) {
		if (!listaServicios.containsKey((Integer) codServicio))
			throw new RuntimeException("No se encuentra el codigo de servicio N: " + codServicio);
		Servicio s = listaServicios.get(codServicio);
		return s;
	}

	private boolean verificarEspecialidad(String especialidad) {
		return TipoServicio.esTipoServicio(especialidad);
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
