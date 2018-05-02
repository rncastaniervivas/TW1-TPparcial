package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Punto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPunto;
	private String latitud;
	private String longitud;
	
	public Long getId() {
		return idPunto;
	}
	public void setId(Long id) {
		this.idPunto = id;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	
}
