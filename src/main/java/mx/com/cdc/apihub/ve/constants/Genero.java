package mx.com.cdc.apihub.ve.constants;

public enum Genero {

	MASCULINO('M'),
	FEMENINO('F');
	
	private char genero;
	
	Genero(char genero) {
		this.genero = genero;
	}
	
	public char toChar() {
		return genero;
	}
}
