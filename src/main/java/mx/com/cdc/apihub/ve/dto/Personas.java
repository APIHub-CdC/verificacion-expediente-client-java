package mx.com.cdc.apihub.ve.dto;

import java.util.ArrayList;
import java.util.List;

import mx.com.cdc.apihub.ve.facade.dto.PersonaFacade;

public final class Personas {

	String folio;
	List<Persona> list;
	
	static Personas buildFromFacade(String folio, List<PersonaFacade> listPersonaFacade) {
		List<Persona> personaList = new ArrayList<>();
		
		for (PersonaFacade facade : listPersonaFacade) {
			personaList.add(Persona.buildFromFacade(facade));
		}
		
		Personas personas = new Personas();
		personas.folio = folio;
		personas.list = personaList;
		
		return personas;
	}
}
