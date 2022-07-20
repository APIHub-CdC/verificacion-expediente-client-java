package mx.com.cdc.apihub.ve.dto;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.cdc.apihub.ve.facade.dto.ExpedienteFacade;

public final class ExpedienteRequest {

	private final String FolioOtorgante;
	private final Personas personas;
	
	private ExpedienteRequest(ExpedienteFacade facade) {
		FolioOtorgante = facade.getFolioOtorgante();
		personas = Personas.buildFromFacade(facade.getFolio(), facade.getListPersona());
	}
	
	public static String toJsonFromFacade(ExpedienteFacade facade) throws IOException {
		
		ExpedienteRequest request = new ExpedienteRequest(facade);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		return mapper.writeValueAsString(request);
	}
}
