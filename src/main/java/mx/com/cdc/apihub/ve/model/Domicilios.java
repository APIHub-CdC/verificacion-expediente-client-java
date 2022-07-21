package mx.com.cdc.apihub.ve.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Domicilios {

	@SerializedName("list")
	private List<DomicilioPeticion> list = null;

	public List<DomicilioPeticion> getList() {
		return list;
	}

	public void setList(List<DomicilioPeticion> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Domicilios [list=" + list + "]";
	}
	
	
	
}
