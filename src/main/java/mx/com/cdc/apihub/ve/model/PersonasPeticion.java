package mx.com.cdc.apihub.ve.model;


import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

public class PersonasPeticion {
  @SerializedName("nombres")
  private String nombres = null;
  @SerializedName("apellidoPaterno")
  private String apellidoPaterno = null;
  @SerializedName("apellidoMaterno")
  private String apellidoMaterno = null;
  @SerializedName("fechaNacimiento")
  private String fechaNacimiento = null;
  @SerializedName("RFC")
  private String RFC = null;
  @SerializedName("CURP")
  private String CURP = null;
  @SerializedName("claveElectorIFE")
  private String claveElectorIFE = null;
  @SerializedName("sexo")
  private CatalogoSexo sexo = null;
  @SerializedName("domicilios")
  private Domicilios domicilios = null;
  
  public PersonasPeticion nombres(String nombres) {
    this.nombres = nombres;
    return this;
  }
   
  @ApiModelProperty(example = "JUAN", required = true, value = "")
  public String getNombres() {
    return nombres;
  }
  public void setNombres(String nombres) {
    this.nombres = nombres;
  }
  public PersonasPeticion apellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
    return this;
  }
   
  @ApiModelProperty(example = "PRUEBA", required = true, value = "")
  public String getApellidoPaterno() {
    return apellidoPaterno;
  }
  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }
  public PersonasPeticion apellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
    return this;
  }
   
  @ApiModelProperty(example = "SIETE", required = true, value = "")
  public String getApellidoMaterno() {
    return apellidoMaterno;
  }
  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }
  public PersonasPeticion fechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
    return this;
  }
   
  @ApiModelProperty(example = "1980-01-07", required = true, value = "")
  public String getFechaNacimiento() {
    return fechaNacimiento;
  }
  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  public PersonasPeticion RFC(String RFC) {
    this.RFC = RFC;
    return this;
  }
   
  @ApiModelProperty(example = "PUSJ800107", value = "")
  public String getRFC() {
    return RFC;
  }
  public void setRFC(String RFC) {
    this.RFC = RFC;
  }
  public PersonasPeticion CURP(String CURP) {
    this.CURP = CURP;
    return this;
  }
   
  @ApiModelProperty(example = "SAZR010101HCMLNS09", value = "")
  public String getCURP() {
    return CURP;
  }
  public void setCURP(String CURP) {
    this.CURP = CURP;
  }
  public PersonasPeticion claveElectorIFE(String claveElectorIFE) {
    this.claveElectorIFE = claveElectorIFE;
    return this;
  }
   
  @ApiModelProperty(example = "000000000000", value = "")
  public String getClaveElectorIFE() {
    return claveElectorIFE;
  }
  public void setClaveElectorIFE(String claveElectorIFE) {
    this.claveElectorIFE = claveElectorIFE;
  }
  public PersonasPeticion sexo(CatalogoSexo sexo) {
    this.sexo = sexo;
    return this;
  }
   
  @ApiModelProperty(value = "")
  public CatalogoSexo getSexo() {
    return sexo;
  }
  public void setSexo(CatalogoSexo sexo) {
    this.sexo = sexo;
  }
  public Domicilios domicilios(Domicilios domicilios) {
    this.domicilios = domicilios;
    return this.domicilios;
  }
   
  @ApiModelProperty(value = "")
  public Object getDomicilios() {
    return domicilios;
  }
  public void setDomicilios(Domicilios domicilios) {
    this.domicilios = domicilios;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonasPeticion personasPeticion = (PersonasPeticion) o;
    return Objects.equals(this.nombres, personasPeticion.nombres) &&
        Objects.equals(this.apellidoPaterno, personasPeticion.apellidoPaterno) &&
        Objects.equals(this.apellidoMaterno, personasPeticion.apellidoMaterno) &&
        Objects.equals(this.fechaNacimiento, personasPeticion.fechaNacimiento) &&
        Objects.equals(this.RFC, personasPeticion.RFC) &&
        Objects.equals(this.CURP, personasPeticion.CURP) &&
        Objects.equals(this.claveElectorIFE, personasPeticion.claveElectorIFE) &&
        Objects.equals(this.sexo, personasPeticion.sexo) &&
        Objects.equals(this.domicilios, personasPeticion.domicilios);
  }
  @Override
  public int hashCode() {
    return Objects.hash(nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, RFC, CURP, claveElectorIFE, sexo, domicilios);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonasPeticion {\n");
    
    sb.append("    nombres: ").append(toIndentedString(nombres)).append("\n");
    sb.append("    apellidoPaterno: ").append(toIndentedString(apellidoPaterno)).append("\n");
    sb.append("    apellidoMaterno: ").append(toIndentedString(apellidoMaterno)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
    sb.append("    RFC: ").append(toIndentedString(RFC)).append("\n");
    sb.append("    CURP: ").append(toIndentedString(CURP)).append("\n");
    sb.append("    claveElectorIFE: ").append(toIndentedString(claveElectorIFE)).append("\n");
    sb.append("    sexo: ").append(toIndentedString(sexo)).append("\n");
    sb.append("    domicilios: ").append(toIndentedString(domicilios)).append("\n");
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
