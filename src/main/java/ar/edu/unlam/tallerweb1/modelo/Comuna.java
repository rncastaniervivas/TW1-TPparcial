package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comuna {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idComuna;
	private String nombre;
	@ManyToOne(fetch = FetchType.LAZY)
	private Barrio barrio;
	
	public Long getIdComuna() {
		return idComuna;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Barrio getBarrio() {
		return barrio;
	}
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	
}
