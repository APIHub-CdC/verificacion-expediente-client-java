package mx.com.cdc.apihub.ve.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;


public class DomicilioRespuesta {
  @SerializedName("direccion")
  private String direccion = null;
  @SerializedName("coloniaPoblacion")
  private String coloniaPoblacion = null;
  @SerializedName("delegacionMunicipio")
  private String delegacionMunicipio = null;
  @SerializedName("ciudad")
  private String ciudad = null;
  @SerializedName("estado")
  private String estado = null;
  @SerializedName("codigoPostal")
  private String codigoPostal = null;
  @SerializedName("numeroTelefono")
  private String numeroTelefono = null;
  @SerializedName("index")
  private String index = null;
  public DomicilioRespuesta direccion(String direccion) {
    this.direccion = direccion;
    return this;
  }
   
  @ApiModelProperty(example = "N", value = "")
  public String getDireccion() {
    return direccion;
  }
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  public DomicilioRespuesta coloniaPoblacion(String coloniaPoblacion) {
    this.coloniaPoblacion = coloniaPoblacion;
    return this;
  }
   
  @ApiModelProperty(example = "X", value = "")
  public String getColoniaPoblacion() {
    return coloniaPoblacion;
  }
  public void setColoniaPoblacion(String coloniaPoblacion) {
    this.coloniaPoblacion = coloniaPoblacion;
  }
  public DomicilioRespuesta delegacionMunicipio(String delegacionMunicipio) {
    this.delegacionMunicipio = delegacionMunicipio;
    return this;
  }
   
  @ApiModelProperty(example = "Y", value = "")
  public String getDelegacionMunicipio() {
    return delegacionMunicipio;
  }
  public void setDelegacionMunicipio(String delegacionMunicipio) {
    this.delegacionMunicipio = delegacionMunicipio;
  }
  public DomicilioRespuesta ciudad(String ciudad) {
    this.ciudad = ciudad;
    return this;
  }
   
  @ApiModelProperty(example = "M", value = "")
  public String getCiudad() {
    return ciudad;
  }
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }
  public DomicilioRespuesta estado(String estado) {
    this.estado = estado;
    return this;
  }
   
  @ApiModelProperty(example = "Y", value = "")
  public String getEstado() {
    return estado;
  }
  public void setEstado(String estado) {
    this.estado = estado;
  }
  public DomicilioRespuesta codigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
    return this;
  }
   
  @ApiModelProperty(example = "N", value = "")
  public String getCodigoPostal() {
    return codigoPostal;
  }
  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }
  public DomicilioRespuesta numeroTelefono(String numeroTelefono) {
    this.numeroTelefono = numeroTelefono;
    return this;
  }
   
  @ApiModelProperty(example = "M", value = "")
  public String getNumeroTelefono() {
    return numeroTelefono;
  }
  public void setNumeroTelefono(String numeroTelefono) {
    this.numeroTelefono = numeroTelefono;
  }
  public DomicilioRespuesta index(String index) {
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
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DomicilioRespuesta domicilioRespuesta = (DomicilioRespuesta) o;
    return Objects.equals(this.direccion, domicilioRespuesta.direccion) &&
        Objects.equals(this.coloniaPoblacion, domicilioRespuesta.coloniaPoblacion) &&
        Objects.equals(this.delegacionMunicipio, domicilioRespuesta.delegacionMunicipio) &&
        Objects.equals(this.ciudad, domicilioRespuesta.ciudad) &&
        Objects.equals(this.estado, domicilioRespuesta.estado) &&
        Objects.equals(this.codigoPostal, domicilioRespuesta.codigoPostal) &&
        Objects.equals(this.numeroTelefono, domicilioRespuesta.numeroTelefono) &&
        Objects.equals(this.index, domicilioRespuesta.index);
  }
  @Override
  public int hashCode() {
    return Objects.hash(direccion, coloniaPoblacion, delegacionMunicipio, ciudad, estado, codigoPostal, numeroTelefono, index);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DomicilioRespuesta {\n");
    
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    coloniaPoblacion: ").append(toIndentedString(coloniaPoblacion)).append("\n");
    sb.append("    delegacionMunicipio: ").append(toIndentedString(delegacionMunicipio)).append("\n");
    sb.append("    ciudad: ").append(toIndentedString(ciudad)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    codigoPostal: ").append(toIndentedString(codigoPostal)).append("\n");
    sb.append("    numeroTelefono: ").append(toIndentedString(numeroTelefono)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
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
