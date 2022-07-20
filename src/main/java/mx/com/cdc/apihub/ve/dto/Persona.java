package mx.com.cdc.apihub.ve.dto;

import java.time.format.DateTimeFormatter;

import mx.com.cdc.apihub.ve.facade.dto.PersonaFacade;

public final class Persona {

	String nombres;
	String apellidoPaterno;
	String apellidoMaterno;
	String fechaNacimiento;
	String RFC;
	String CURP;
	String claveElectorIFE;
	Character sexo;
	Domicilios domicilios;
	
	static Persona buildFromFacade(PersonaFacade facade) {
		
		Persona persona = new Persona();
		persona.apellidoMaterno = facade.getApellidoMaterno();
		persona.apellidoPaterno = facade.getApellidoPaterno();
		persona.claveElectorIFE = facade.getClaveElectorIfe();
		persona.CURP			= facade.getCurp();
		persona.fechaNacimiento	= facade.getFechaNacimiento().format(DateTimeFormatter.ISO_DATE);
		persona.nombres			= facade.getNombre();
		persona.RFC				= facade.getRfc();
		persona.sexo			= facade.getGenero().toChar();
		persona.domicilios		= Domicilios.buildFromFacade(facade.getListDomicilio());
		
		return persona;
	}
}
