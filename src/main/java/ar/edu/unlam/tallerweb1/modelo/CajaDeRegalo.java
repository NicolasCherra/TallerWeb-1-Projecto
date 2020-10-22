package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CajaDeRegalo")
public class CajaDeRegalo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroDeCaja;
	private String nombre;
	private String descripcion;
	private Integer precio;
	private Integer cantidadPersonas;
	private String imagen;
	// private Categoria categoria;

	/*
	 * public CajaDeRegalo (String nombre, String descripcion, Double precio) {
	 * this.nombre = nombre; this.descripcion = descripcion; this.precio = precio; }
	 */

	public Integer getNumeroDeCaja() {
		return numeroDeCaja;
	}

	public void setNumeroDeCaja(Integer numeroDeCaja) {
		this.numeroDeCaja = numeroDeCaja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
