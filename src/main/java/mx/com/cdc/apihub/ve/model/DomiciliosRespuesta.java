package mx.com.cdc.apihub.ve.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;


public class DomiciliosRespuesta {
  @SerializedName("list")
  private List<DomicilioRespuesta> list = null;
  public DomiciliosRespuesta list(List<DomicilioRespuesta> list) {
    this.list = list;
    return this;
  }
  public DomiciliosRespuesta addListItem(DomicilioRespuesta listItem) {
    if (this.list == null) {
      this.list = new ArrayList<DomicilioRespuesta>();
    }
    this.list.add(listItem);
    return this;
  }
   
  @ApiModelProperty(value = "")
  public List<DomicilioRespuesta> getList() {
    return list;
  }
  public void setList(List<DomicilioRespuesta> list) {
    this.list = list;
  }
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DomiciliosRespuesta domiciliosRespuesta = (DomiciliosRespuesta) o;
    return Objects.equals(this.list, domiciliosRespuesta.list);
  }
  @Override
  public int hashCode() {
    return Objects.hash(list);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DomiciliosRespuesta {\n");
    
    sb.append("list: ").append(toIndentedString(list)).append("\n");
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
