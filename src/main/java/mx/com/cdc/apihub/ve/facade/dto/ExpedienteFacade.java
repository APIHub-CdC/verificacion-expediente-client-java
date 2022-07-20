package mx.com.cdc.apihub.ve.facade.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mx.com.cdc.apihub.ve.dto.ExpedienteRequest;

public final class ExpedienteFacade {

	private final String folio;
	private final String folioOtorgante;
	private final List<PersonaFacade> listPersona;
	
	public static class Builder {
		
		private String folio;
		private String folioOtorgante;
		private List<PersonaFacade> listPersona = new ArrayList<>();
		
		public Builder folio(String folio) {
			this.folio = folio;
			return this;
		}
		
		public Builder folioOtorgante(String folioOtorgante) {
			this.folioOtorgante = folioOtorgante;
			return this;
		}
		
		public Builder addPersona(PersonaFacade persona) {
			this.listPersona.add(persona);
			return this;
		}
		
		public ExpedienteFacade build() {
			return new ExpedienteFacade(
					folio, 
					folioOtorgante, 
					listPersona);
		}
	}
	
	private ExpedienteFacade(
			String folio,
			String folioOtorgante,
			List<PersonaFacade> listPersona) {
		
		this.folio = folio;
		this.folioOtorgante = folioOtorgante;
		this.listPersona = listPersona;
	}
	
	public String getFolio() {
		return folio;
	}
	
	public String getFolioOtorgante() {
		return folioOtorgante;
	}
	
	public List<PersonaFacade> getListPersona() {
		return listPersona;
	}
	
	public String toJsonString() throws IOException {
		return ExpedienteRequest.toJsonFromFacade(this);
	}
}
