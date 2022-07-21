package mx.com.cdc.apihub.ve.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Datos del domicilio de la persona a consultar")


public class DomicilioPeticion {
  @SerializedName("direccion")
  private String direccion = null;
  @SerializedName("delegacionMunicipio")
  private String delegacionMunicipio = null;
  @SerializedName("ciudad")
  private String ciudad = null;
  @SerializedName("estado")
  private CatalogoEstados estado = null;
  @SerializedName("codigoPostal")
  private String codigoPostal = null;
  @SerializedName("numeroTelefono")
  private String numeroTelefono = null;
  public DomicilioPeticion direccion(String direccion) {
    this.direccion = direccion;
    return this;
  }
   
  @ApiModelProperty(example = "INSURGENTES SUR 1007", required = true, value = "Reportar el nombre de la calle, número exterior, número interior. Deben considerarse avenida,cerrada, manzana, lote, edificio,departamento etc. Debe contener por lo menos dos cadenas de caracteres para que el registro sea válido, de lo contrario el registro será rechazado.")
  public String getDireccion() {
    return direccion;
  }
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  public DomicilioPeticion delegacionMunicipio(String delegacionMunicipio) {
    this.delegacionMunicipio = delegacionMunicipio;
    return this;
  }
   
  @ApiModelProperty(example = " MIGUEL HIDALGO", value = "Reportar la delegación o municipio a la cual pertenece la dirección contenida en el elemento Dirección.")
  public String getDelegacionMunicipio() {
    return delegacionMunicipio;
  }
  public void setDelegacionMunicipio(String delegacionMunicipio) {
    this.delegacionMunicipio = delegacionMunicipio;
  }
  public DomicilioPeticion ciudad(String ciudad) {
    this.ciudad = ciudad;
    return this;
  }
   
  @ApiModelProperty(example = "MEXICO", required = true, value = "Reportar la ciudad a la cual pertenece la dirección contenida en el elemento Dirección.")
  public String getCiudad() {
    return ciudad;
  }
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }
  public DomicilioPeticion estado(CatalogoEstados estado) {
    this.estado = estado;
    return this;
  }
   
  @ApiModelProperty(required = true, value = "")
  public CatalogoEstados getEstado() {
    return estado;
  }
  public void setEstado(CatalogoEstados estado) {
    this.estado = estado;
  }
  public DomicilioPeticion codigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
    return this;
  }
   
  @ApiModelProperty(example = "11230", required = true, value = "El código postal reportado debeestar compuesto por 5 dígitos. Para que el código postal sea válido deberá corresponder al estado reportado.")
  public String getCodigoPostal() {
    return codigoPostal;
  }
  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }
  public DomicilioPeticion numeroTelefono(String numeroTelefono) {
    this.numeroTelefono = numeroTelefono;
    return this;
  }
   
  @ApiModelProperty(example = "5517207788", value = "")
  public String getNumeroTelefono() {
    return numeroTelefono;
  }
  public void setNumeroTelefono(String numeroTelefono) {
    this.numeroTelefono = numeroTelefono;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DomicilioPeticion domicilioPeticion = (DomicilioPeticion) o;
    return Objects.equals(this.direccion, domicilioPeticion.direccion) &&
        Objects.equals(this.delegacionMunicipio, domicilioPeticion.delegacionMunicipio) &&
        Objects.equals(this.ciudad, domicilioPeticion.ciudad) &&
        Objects.equals(this.estado, domicilioPeticion.estado) &&
        Objects.equals(this.codigoPostal, domicilioPeticion.codigoPostal) &&
        Objects.equals(this.numeroTelefono, domicilioPeticion.numeroTelefono);
  }
  @Override
  public int hashCode() {
    return Objects.hash(direccion, delegacionMunicipio, ciudad, estado, codigoPostal, numeroTelefono);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DomicilioPeticion {\n");
    
    sb.append("    direccion: ").append(toIndentedString(direccion)).append("\n");
    sb.append("    delegacionMunicipio: ").append(toIndentedString(delegacionMunicipio)).append("\n");
    sb.append("    ciudad: ").append(toIndentedString(ciudad)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    codigoPostal: ").append(toIndentedString(codigoPostal)).append("\n");
    sb.append("    numeroTelefono: ").append(toIndentedString(numeroTelefono)).append("\n");
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
