package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Farmacia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFarmacia;
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	@OneToOne(cascade = CascadeType.ALL)
	private Direccion direccion;
	@OneToOne(cascade = CascadeType.ALL)
	private Punto geoLocalizacion;
	
	public Farmacia(String nombre, String diaDeTurno){
		this.nombre = nombre;
		this.diaDeTurno = diaDeTurno;
	}
	
	public Farmacia(){
		
	}
	
	public Long getId() {
		return idFarmacia;
	}
	public void setId(Long id) {
		this.idFarmacia = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Punto getGeoLocalizacion() {
		return geoLocalizacion;
	}
	public void setGeoLocalizacion(Punto geoLocalizacion) {
		this.geoLocalizacion = geoLocalizacion;
	}
	public String getDiaDeTurno() {
		return diaDeTurno;
	}
	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}
	
}