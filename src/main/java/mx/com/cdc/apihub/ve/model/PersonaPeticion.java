package mx.com.cdc.apihub.ve.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

public class PersonaPeticion {
	@SerializedName("FolioOtorgante")
	private String folioOtorgante = null;
	@SerializedName("personas")
	private Personas personas = null;

	public PersonaPeticion folioOtorgante(String folioOtorgante) {
		this.folioOtorgante = folioOtorgante;
		return this;
	}

	@ApiModelProperty(example = "12345", required = true, value = "")
	public String getFolioOtorgante() {
		return folioOtorgante;
	}

	public void setFolioOtorgante(String folioOtorgante) {
		this.folioOtorgante = folioOtorgante;
	}

	public Personas personas(Personas personas) {
		this.personas = personas;
		return this.personas;
	}

	@ApiModelProperty(required = true, value = "")
	public Personas getPersonas() {
		return personas;
	}

	public void setPersonas(Personas personas) {
		this.personas = personas;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PersonaPeticion personaPeticion = (PersonaPeticion) o;
		return Objects.equals(this.folioOtorgante, personaPeticion.folioOtorgante)
				&& Objects.equals(this.personas, personaPeticion.personas);
	}

	@Override
	public int hashCode() {
		return Objects.hash(folioOtorgante, personas);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PersonaPeticion {\n");

		sb.append("    folioOtorgante: ").append(toIndentedString(folioOtorgante)).append("\n");
		sb.append("    personas: ").append(toIndentedString(personas)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
