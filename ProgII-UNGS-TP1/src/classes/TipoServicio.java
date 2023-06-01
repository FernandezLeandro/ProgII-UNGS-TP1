package classes;

public enum TipoServicio {
	ELECTRICIDAD("Electricidad"),
	PINTURA("Pintura"),
	PINTURA_EN_ALTURA("PinturaEnAltura"),
	GASISTA_INSTALACION("GasistaInstalacion"),
	GASISTA_REVISION("GasistaRevision");
	

	TipoServicio(String names) {
		this.names = names;
	}

	private String names;
	/*
	 * Este metodo obtiene la lista de valores de los enums (Electricidad, Pintura, etc) y si matchea con alguno, retorna el booleano
	 * Entonces, si le pasamos un tipo que no existe por ejemplo "Carpintero" devolvera falso
	 */
	public static boolean esTipoServicio(String value) {
	      for (TipoServicio b : TipoServicio.values()) {
	        if (b.names.equals(value)) {
	          return true;
	        }
	      }
	      return false;
	    }
	public String getName() {
		return this.names;
	}
}
