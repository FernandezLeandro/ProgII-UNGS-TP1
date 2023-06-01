package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Set;

import java.util.Iterator;
import java.util.Map;

public class EmpresaDeServicios implements Empresa{
	
	private Set<Especialista> listaEspecialistas;
	private Set<Cliente> listaClientes;
	private HashMap<Integer,Servicio> listaServicios;
	private Integer contServicios= -1;
	
	public EmpresaDeServicios () {
		this.listaClientes = new HashSet<Cliente>();
		this.listaEspecialistas = new HashSet<Especialista>();
		this.listaServicios = new HashMap<Integer,Servicio>();
		this.contServicios = contServicios;
	}

	@Override
	public void registrarCliente(int dni, String nombre, String telefono) {
		listaClientes.add(new Cliente(dni, nombre, telefono));
		
	}

	@Override
	public void registrarEspecialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		if(!existeEspecialista(nroEspecialista)) {
			listaEspecialistas.add(new Especialista(nroEspecialista,nombre,telefono,especialidad));
		} else
			throw new RuntimeException ("Especialista ya registrado");
		
	}

	@Override
	public int solicitarServicioElectricidad(int dni, int nroEspecialista, String direccion, double precioPorHora,
			int horasTrabajadas) {
		
		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio electricidad = new Electricidad(this.contServicios, e, 
				direccion, buscarCliente(dni), precioPorHora, horasTrabajadas);
		
		listaServicios.put(contServicios, electricidad);
		e.addServicioHistorial(electricidad);
		electricidad.setTipoServicio("Electricidad");
		this.contServicios++;
		
		return electricidad.getId();
	}

	@Override
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado) {
		
		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio pintura = new Pintura(this.contServicios, e, direccion, 
				buscarCliente(dni), precioPorMetroCuadrado, metrosCuadrados);
		
		listaServicios.put(contServicios, pintura);
		e.addServicioHistorial(pintura);
		pintura.setTipoServicio("Pintura");
		this.contServicios++;
		
		return pintura.getId();
	}

	@Override
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrado, int piso, double seguro, double alqAndamios) {
		
		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio altura = new PinturaEnAltura(this.contServicios, e, direccion, 
				buscarCliente(dni), precioPorMetroCuadrado, metrosCuadrados, piso, seguro, alqAndamios);
		
		listaServicios.put(contServicios, altura);
		e.addServicioHistorial(altura);
		altura.setTipoServicio("Altura");
		this.contServicios++;
		
		return altura.getId();
	}

	@Override
	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {

		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio instalacion = new GasistaInstalacion(this.contServicios, e,
				direccion, buscarCliente(dni), cantArtefactos, precioPorArtefacto);
		
		listaServicios.put(contServicios, instalacion);
		e.addServicioHistorial(instalacion);
		instalacion.setTipoServicio("GasistaInstalacion");
		this.contServicios++;
		
		return instalacion.getId();
	}

	@Override
	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos,
			double precioPorArtefacto) {
		
		Especialista e = buscarEspecialista(nroEspecialista);
		Servicio revision = new GasistaRevision(this.contServicios, e, 
				direccion, buscarCliente(dni), cantArtefactos, precioPorArtefacto);
		
		listaServicios.put(contServicios, revision);
		
		e.addServicioHistorial(revision);
		this.contServicios++;
		revision.setTipoServicio("GasistaRevision");
		
		return revision.getId();
	}

	@Override
	public double finalizarServicio(int codServicio, double costoMateriales) {
		
		buscarServicio(codServicio).finalizarServicio();
		double suma = buscarServicio(codServicio).calcularImporteTotal();
		System.out.println("suma " + suma);
		return buscarServicio(codServicio).calcularImporteTotal() + costoMateriales;
	}

	@Override
	public Map<String, Integer> cantidadDeServiciosRealizadosPorTipo() {
		Integer elec = 0, pintura = 0, altura = 0, gasrev = 0, gasins = 0;
		String el = "Electricidad", pin = "Pintura", al = "Altura", gr = "GasistaRevision", gi = "GasistaInstalacion";
		for(Servicio s: listaServicios.values()) {
			if(s.getTipoServicio().equals(el)) {
				elec++;
			}else if(s.getTipoServicio().equals(pin)) {
				pintura++;
			}else if(s.getTipoServicio().equals(al)) {
				altura++;
			}else if(s.getTipoServicio().equals(gr)) {
				gasins++;
			}else if(s.getTipoServicio().equals(gi)) {
				gasrev++;
			}
		}
		HashMap<String,Integer> map = new HashMap<String,Integer>();
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
		for(Servicio s : listaServicios.values()) {
			if(s.getTipoServicio().equals(tipoServicio)) {
				total += s.calcularImporteTotal();
				System.out.println("total= " + total);
			}
		}
//		System.out.println("total= " + total);
		return total;
	}

	@Override
	public double facturacionTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cambiarResponsable(int codServicio, int nroEspecialista) {
		
		if(!existeEspecialista(nroEspecialista)) {
			throw new RuntimeException("No se encuentra especialista N° " + nroEspecialista);
		}
		Especialista e = buscarEspecialista(nroEspecialista);
		buscarServicio(codServicio).setEspecialista(e);
		
	}

	@Override
	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista) {
		
		if(!existeEspecialista(nroEspecialista)) {
			throw new RuntimeException("No se encuentra especialista N| " + nroEspecialista);
		}
		Especialista e = buscarEspecialista(nroEspecialista);
		StringBuilder build = new StringBuilder();
		
		for(Servicio s : e.getHistorialServiciosRealizados()) 
		{
			build.append("+ [");
			build.append(s.getId());
			build.append(" - ");
			build.append(e.getEspecialidad());
			build.append("] ");
			build.append(s.getDireccion());
			build.append(System.getProperty("line.separator"));
		}
		String listado = build.toString();
		return listado;
	}

	private boolean existeEspecialista(int nroEspecialista) {
		boolean encontro= false;
		if(!listaEspecialistas.isEmpty()) {
			Iterator <Especialista> it = listaEspecialistas.iterator();
			while (it.hasNext()) {
				if(it.next().getIdEspecialista() == nroEspecialista) {
					encontro = true;
				}
			}
		}
		return encontro;
	}
	
	public Especialista buscarEspecialista(int nroEspecialista) {
		for(Especialista e : listaEspecialistas) {
			if(nroEspecialista == e.getIdEspecialista()) {
				return e;
			}
		}
		return null;
	}
	
	public Cliente buscarCliente(int dni) {
		for(Cliente c : listaClientes) {
			if(c.hashCode() == dni) {
				return c;
			}
		}
		return null;
	}
	
	public Servicio buscarServicio(Integer codServicio) {
		if(!listaServicios.containsKey((Integer)codServicio))
			throw new RuntimeException("No se encuentra el codigo de servicio N° " + codServicio);
		Servicio s = listaServicios.get(codServicio);
		return s;
	}
	

}
