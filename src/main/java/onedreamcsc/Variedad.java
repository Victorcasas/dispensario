package onedreamcsc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Variedad_table")
public class Variedad {
	@Id @GeneratedValue
	int variedadId;
	@Column(name="Variedad")
	public String variedadNombre;
	@Column(name="Precio", nullable=true)
	private long variedadPrecio;
	@Column(name="Cantidad")
	public long variedadCantidad;
	@Column(name="Restos", nullable=true)
	public long variedadRestos;
	
	public String getVariedadNombre() {
		return variedadNombre;
	}

	public void setVariedadNombre(String variedadNombre) {
		this.variedadNombre = variedadNombre;
	}
	public long getVariedadCantidad() {
		return variedadCantidad;
	}

	public void setVariedadCantidad(long variedadCantidad) {
		this.variedadCantidad = variedadCantidad;
	}

	public long getVariedadPrecio() {
		return variedadPrecio;
	}

	public void setVariedadPrecio(long variedadPrecio) {
		this.variedadPrecio = variedadPrecio;
	}

	public long getVariedadRestos() {
		return variedadRestos;
	}

	public void setVariedadRestos(long variedadRestos) {
		this.variedadRestos = variedadRestos;
	}

	public int getVariedadId() {
		return variedadId;
	}

	public void setVariedadId(int variedadId) {
		this.variedadId = variedadId;
	}

	public Variedad(){}
	
	public Variedad(String variedadNombre, Long aporte){
		this.variedadNombre=variedadNombre;
		this.variedadCantidad=aporte;
	}


	
}