package mx.com.cdc.apihub.ve.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "<b>Y - Coincide</b><br><b>N - No coincide</b><br><b>M - No tenemos el campo</b><br><b>X - No no entregaron el dato en la consulta</b><br>")


public class Respuesta {
  @SerializedName("personas")
  private PersonaRespuesta personas = null;
  public Respuesta personas(PersonaRespuesta personas) {
    this.personas = personas;
    return this;
  }
   
  @ApiModelProperty(value = "")
  public PersonaRespuesta getPersonas() {
    return personas;
  }
  public void setPersonas(PersonaRespuesta personas) {
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
    Respuesta respuesta = (Respuesta) o;
    return Objects.equals(this.personas, respuesta.personas);
  }
  @Override
  public int hashCode() {
    return Objects.hash(personas);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Respuesta {\n");
    
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
