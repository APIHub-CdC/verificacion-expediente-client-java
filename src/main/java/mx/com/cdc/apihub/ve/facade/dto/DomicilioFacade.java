package mx.com.cdc.apihub.ve.facade.dto;

import mx.com.cdc.apihub.ve.constants.Estado;

public class DomicilioFacade {

	private final String direccion;
	private final String coloniaPoblacion;
	private final String delegacionMunicipio;
	private final String ciudad;
	private final Estado estado;
	private final String codigoPostal;
	private final String numeroTelefono;
	
	private DomicilioFacade(
			String direccion,
			String coloniaPoblacion,
			String delegacionMunicipio,
			String ciudad,
			Estado estado,
			String codigoPostal,
			String numeroTelefono) {
		
		this.direccion = direccion;
		this.coloniaPoblacion = coloniaPoblacion;
		this.delegacionMunicipio = delegacionMunicipio;
		this.ciudad = ciudad;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
		this.numeroTelefono = numeroTelefono;
	}
	
	public static class Builder {
		
		private String direccion;
		private String coloniaPoblacion;
		private String delegacionMunicipio;
		private String ciudad;
		private Estado estado;
		private String codigoPostal;
		private String numeroTelefono;
		
		public Builder direccion(String direccion) {
			this.direccion = direccion;
			return this;
		}
		
		public Builder coloniaPoblacion(String coloniaPoblacion) {
			this.coloniaPoblacion = coloniaPoblacion;
			return this;
		}
		
		public Builder delegacionMunicipio(String delegacionMunicipio) {
			this.delegacionMunicipio = delegacionMunicipio;
			return this;
		}
		
		public Builder ciudad(String ciudad) {
			this.ciudad = ciudad;
			return this;
		}
		
		public Builder estado(Estado estado) {
			this.estado = estado;
			return this;
		}
		
		public Builder codigoPostal(String codigoPostal) {
			this.codigoPostal = codigoPostal;
			return this;
		}
		
		public Builder numeroTelefono(String numeroTelefono) {
			this.numeroTelefono = numeroTelefono;
			return this;
		}
		
		public DomicilioFacade build() {
			return new DomicilioFacade(
					direccion, 
					coloniaPoblacion, 
					delegacionMunicipio, 
					ciudad, 
					estado, 
					codigoPostal, 
					numeroTelefono);
		}
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getColoniaPoblacion() {
		return coloniaPoblacion;
	}
	
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
}
