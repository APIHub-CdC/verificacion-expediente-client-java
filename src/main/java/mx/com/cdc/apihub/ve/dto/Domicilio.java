package mx.com.cdc.apihub.ve.dto;

import mx.com.cdc.apihub.ve.facade.dto.DomicilioFacade;

public final class Domicilio {

	String direccion;
	String delegacionMunicipio;
	String ciudad;
	String estado;
	String codigoPostal;
	String numeroTelefono;
	
	static Domicilio buildFromFacade(DomicilioFacade facade) {
		
		Domicilio domicilio = new Domicilio();
		domicilio.ciudad				= facade.getCiudad();
		domicilio.codigoPostal			= facade.getCodigoPostal();
		domicilio.delegacionMunicipio	= facade.getDelegacionMunicipio();
		domicilio.direccion				= facade.getDireccion();
		domicilio.estado				= facade.getEstado().toString();
		domicilio.numeroTelefono		= facade.getNumeroTelefono();
		
		return domicilio;
	}
}
