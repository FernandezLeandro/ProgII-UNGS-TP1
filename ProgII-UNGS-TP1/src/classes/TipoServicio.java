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
	
	public static boolean esTipoServicio(String value) {
	      for (TipoServicio b : TipoServicio.values()) {
	        if (b.names.equals(value)) {
	          return true;
	        }
	      }
	      return false;
	    }
}
