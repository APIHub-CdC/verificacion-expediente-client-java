package mx.com.cdc.apihub.ve.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Personas {

	@SerializedName("Folio")
	private String Folio;
	
	@SerializedName("list")
	private List<PersonasPeticion> list = null;

	public List<PersonasPeticion> getList() {
		return list;
	}

	public void setList(List<PersonasPeticion> list) {
		this.list = list;
	}
	
	public String getFolio() {
		return Folio;
	}
	
	public void setFolio(String Folio) {
		this.Folio = Folio;
	}

	@Override
	public String toString() {
		return "Personas [Folio=" + Folio + ",list=" + list + "]";
	}
	
}
