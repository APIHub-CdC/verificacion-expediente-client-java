package mx.com.cdc.apihub.ve.facade.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import mx.com.cdc.apihub.ve.constants.Genero;

public class PersonaFacade {

	private final String nombre;
	private final String apellidoPaterno;
	private final String apellidoMaterno;
	private final LocalDate fechaNacimiento;
	private final String rfc;
	private final String curp;
	private final String claveElectorIfe;
	private final Genero genero;
	private final List<DomicilioFacade> listDomicilio;
	
	public final static class Builder {
		
		private String nombre;
		private String apellidoPaterno;
		private String apellidoMaterno;
		private LocalDate fechaNacimiento;
		private String rfc;
		private String curp;
		private String claveElectorIfe;
		private Genero genero;
		private List<DomicilioFacade> listDomicilio = new ArrayList<>();
		
		public Builder nombre(String nombre) {
			this.nombre = nombre;
			return this;
		}
		
		public Builder apellidoPaterno(String apellidoPaterno) {
			this.apellidoPaterno = apellidoPaterno;
			return this;
		}
		
		public Builder apellidoMaterno(String apellidoMaterno) {
			this.apellidoMaterno = apellidoMaterno;
			return this;
		}
		
		public Builder fechaNacimiento(LocalDate fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
			return this;
		}
		
		public Builder rfc(String rfc) {
			this.rfc = rfc;
			return this;
		}
		
		public Builder curp(String curp) {
			this.curp = curp;
			return this;
		}
		
		public Builder claveElectorIfe(String claveElectorIfe) {
			this.claveElectorIfe = claveElectorIfe;
			return this;
		}
		
		public Builder genero(Genero genero) {
			this.genero = genero;
			return this;
		}
		
		public Builder addDomicilio(DomicilioFacade domicilio) {
			this.listDomicilio.add(domicilio);
			return this;
		}
		
		public PersonaFacade build() {
			return new PersonaFacade(
					nombre, 
					apellidoPaterno, 
					apellidoMaterno, 
					fechaNacimiento, 
					rfc, 
					curp, 
					claveElectorIfe, 
					genero,
					listDomicilio);
		}
	}
	
	private PersonaFacade(
			String nombre,
			String apellidoPaterno,
			String apellidoMaterno,
			LocalDate fechaNacimiento,
			String rfc,
			String curp,
			String claveElectorIfe,
			Genero genero,
			List<DomicilioFacade> listDomicilio) {
		
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.rfc = rfc;
		this.curp = curp;
		this.claveElectorIfe = claveElectorIfe;
		this.genero = genero;
		this.listDomicilio = listDomicilio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getRfc() {
		return rfc;
	}
	
	public String getCurp() {
		return curp;
	}
	
	public String getClaveElectorIfe() {
		return claveElectorIfe;
	}
	
	public Genero getGenero() {
		return genero;
	}
	
	public List<DomicilioFacade> getListDomicilio() {
		return listDomicilio;
	}
}
