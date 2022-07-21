package mx.com.cdc.apihub.ve.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

public class PersonasRespuestas {
  @SerializedName("apellidoPaterno")
  private String apellidoPaterno = null;
  @SerializedName("apellidoMaterno")
  private String apellidoMaterno = null;
  @SerializedName("nombres")
  private String nombres = null;
  @SerializedName("fechaNacimiento")
  private String fechaNacimiento = null;
  @SerializedName("RFC")
  private String RFC = null;
  @SerializedName("CURP")
  private String CURP = null;
  @SerializedName("claveElectorIFE")
  private String claveElectorIFE = null;
  @SerializedName("sexo")
  private String sexo = null;
  @SerializedName("index")
  private String index = null;
  @SerializedName("ocurrioError")
  private String ocurrioError = null;
  @SerializedName("descripcionError")
  private String descripcionError = null;
  @SerializedName("domicilios")
  private DomiciliosRespuesta domicilios = null;
  public PersonasRespuestas apellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
    return this;
  }
   
  @ApiModelProperty(example = "Y", value = "")
  public String getApellidoPaterno() {
    return apellidoPaterno;
  }
  public void setApellidoPaterno(String apellidoPaterno) {
    this.apellidoPaterno = apellidoPaterno;
  }
  public PersonasRespuestas apellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
    return this;
  }
   
  @ApiModelProperty(example = "Y", value = "")
  public String getApellidoMaterno() {
    return apellidoMaterno;
  }
  public void setApellidoMaterno(String apellidoMaterno) {
    this.apellidoMaterno = apellidoMaterno;
  }
  public PersonasRespuestas nombres(String nombres) {
    this.nombres = nombres;
    return this;
  }
   
  @ApiModelProperty(example = "Y", value = "")
  public String getNombres() {
    return nombres;
  }
  public void setNombres(String nombres) {
    this.nombres = nombres;
  }
  public PersonasRespuestas fechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
    return this;
  }
   
  @ApiModelProperty(example = "Y", value = "")
  public String getFechaNacimiento() {
    return fechaNacimiento;
  }
  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
  public PersonasRespuestas RFC(String RFC) {
    this.RFC = RFC;
    return this;
  }
   
  @ApiModelProperty(example = "N", value = "")
  public String getRFC() {
    return RFC;
  }
  public void setRFC(String RFC) {
    this.RFC = RFC;
  }
  public PersonasRespuestas CURP(String CURP) {
    this.CURP = CURP;
    return this;
  }
   
  @ApiModelProperty(example = "X", value = "")
  public String getCURP() {
    return CURP;
  }
  public void setCURP(String CURP) {
    this.CURP = CURP;
  }
  public PersonasRespuestas claveElectorIFE(String claveElectorIFE) {
    this.claveElectorIFE = claveElectorIFE;
    return this;
  }
   
  @ApiModelProperty(example = "X", value = "")
  public String getClaveElectorIFE() {
    return claveElectorIFE;
  }
  public void setClaveElectorIFE(String claveElectorIFE) {
    this.claveElectorIFE = claveElectorIFE;
  }
  public PersonasRespuestas sexo(String sexo) {
    this.sexo = sexo;
    return this;
  }
   
  @ApiModelProperty(example = "X", value = "")
  public String getSexo() {
    return sexo;
  }
  public void setSexo(String sexo) {
    this.sexo = sexo;
  }
  public PersonasRespuestas index(String index) {
    this.index = index;
    return this;
  }
   
  @ApiModelProperty(example = "1", value = "")
  public String getIndex() {
    return index;
  }
  public void setIndex(String index) {
    this.index = index;
  }
  public PersonasRespuestas ocurrioError(String ocurrioError) {
    this.ocurrioError = ocurrioError;
    return this;
  }
   
  @ApiModelProperty(example = "false", value = "")
  public String getOcurrioError() {
    return ocurrioError;
  }
  public void setOcurrioError(String ocurrioError) {
    this.ocurrioError = ocurrioError;
  }
  public PersonasRespuestas descripcionError(String descripcionError) {
    this.descripcionError = descripcionError;
    return this;
  }
   
  @ApiModelProperty(example = "Solicitud: Usuario o Password incorrecto", value = "")
  public String getDescripcionError() {
    return descripcionError;
  }
  public void setDescripcionError(String descripcionError) {
    this.descripcionError = descripcionError;
  }
  public PersonasRespuestas domicilios(DomiciliosRespuesta domicilios) {
    this.domicilios = domicilios;
    return this;
  }
   
  @ApiModelProperty(value = "")
  public DomiciliosRespuesta getDomicilios() {
    return domicilios;
  }
  public void setDomicilios(DomiciliosRespuesta domicilios) {
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
    PersonasRespuestas personasRespuestas = (PersonasRespuestas) o;
    return Objects.equals(this.apellidoPaterno, personasRespuestas.apellidoPaterno) &&
        Objects.equals(this.apellidoMaterno, personasRespuestas.apellidoMaterno) &&
        Objects.equals(this.nombres, personasRespuestas.nombres) &&
        Objects.equals(this.fechaNacimiento, personasRespuestas.fechaNacimiento) &&
        Objects.equals(this.RFC, personasRespuestas.RFC) &&
        Objects.equals(this.CURP, personasRespuestas.CURP) &&
        Objects.equals(this.claveElectorIFE, personasRespuestas.claveElectorIFE) &&
        Objects.equals(this.sexo, personasRespuestas.sexo) &&
        Objects.equals(this.index, personasRespuestas.index) &&
        Objects.equals(this.ocurrioError, personasRespuestas.ocurrioError) &&
        Objects.equals(this.descripcionError, personasRespuestas.descripcionError) &&
        Objects.equals(this.domicilios, personasRespuestas.domicilios);
  }
  @Override
  public int hashCode() {
    return Objects.hash(apellidoPaterno, apellidoMaterno, nombres, fechaNacimiento, RFC, CURP, claveElectorIFE, sexo, index, ocurrioError, descripcionError, domicilios);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonasRespuestas {\n");
    
    sb.append("    apellidoPaterno: ").append(toIndentedString(apellidoPaterno)).append("\n");
    sb.append("    apellidoMaterno: ").append(toIndentedString(apellidoMaterno)).append("\n");
    sb.append("    nombres: ").append(toIndentedString(nombres)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
    sb.append("    RFC: ").append(toIndentedString(RFC)).append("\n");
    sb.append("    CURP: ").append(toIndentedString(CURP)).append("\n");
    sb.append("    claveElectorIFE: ").append(toIndentedString(claveElectorIFE)).append("\n");
    sb.append("    sexo: ").append(toIndentedString(sexo)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    ocurrioError: ").append(toIndentedString(ocurrioError)).append("\n");
    sb.append("    descripcionError: ").append(toIndentedString(descripcionError)).append("\n");
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
