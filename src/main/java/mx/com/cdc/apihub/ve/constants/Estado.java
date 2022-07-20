package mx.com.cdc.apihub.ve.constants;

public enum Estado {

	AGUASCALIENTES("AGS"), 
	BAJA_CALIFORNIA_NORTE("BC"), 
	BAJA_CALIFORNIA_SUR("BCS"), 
	CAMPECHE("CAMP"), 
	COAHIULA("COAH"), 
	COLIMA("COL"), 
	CHIAPAS("CHIS"), 
	CHIHUAHUA("CHIH"), 
	DISTRITO_FEDERAL("DF"), 
	CIUDAD_DE_MEXICO("CDMX"),
	DURANGO("DGO"), 
	GUANAJUATO("GTO"), 
	GUERRERO("GRO"), 
	HIDALGO("HGO"), 
	JALISCO("JAL"), 
	MEXICO("MEX"), 
	MICHOACAN("MICH"), 
	MORELOS("MOR"), 
	NAYARIT("NAY"), 
	NUEVO_LEON("NL"), 
	OAXACA("OAX"), 
	PUEBLA("PUE"), 
	QUERETARO("QRO"), 
	QUINTANA_ROO("QROO"), 
	SAN_LUIS_POTOSI("SLP"), 
	SINALOA("SIN"), 
	SONORA("SON"), 
	TABASCO("TAB"), 
	TAMAULIPAS("TAMP"), 
	TLAXCALA("TLAX"), 
	VERACRUZ("VER"), 
	YUCATAN("YUC"), 
	ZACATECAS("ZAC");
	
	private String clave;
	
	Estado(String clave) {
		this.clave = clave;
	}
	
	@Override
	public String toString() {
		return clave;
	}
}
