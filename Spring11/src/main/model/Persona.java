package com.ejemplos.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

@Entity //Cada vez que se crea una tabla.
@Table(name = "PERSONA") // Tabla de nombre PERSONA
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "idPersonas") //Una persona tiene varios tel.y direcciones. PK 
	//Colecciones para las otras clases
	private Collection<Direccion> DIRECCIONES;
	private Collection<Telefono> TELEFONOS;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Generación de valores
	@Column(name = "id")
	private int idPersonas;
	private String nombre;
	private String telefono;
	private String direccion;
	//Para evitar colisiones en denominación de nombres
	@ManytoOne
	@XmlTransient
	public Collection<Direccion> getDIRECCIONES() {
		return DIRECCIONES;
	}

	public void setDIRECCIONES(Collection<Direccion> DIRECCIONES) {
		this.DIRECCIONES = DIRECCIONES;
	}

	@XmlTransient
	public Collection<Telefono> getTELEFONOS() {
		return TELEFONOS;
	}

	public void setTELEFONOS(Collection<Telefono> TELEFONOS) {
		this.TELEFONOS = TELEFONOS;
	}

	public Persona() {
	}

	public Persona(String nombre, String telefono, String direccion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public int getIdPersonas() {
		return idPersonas;
	}

	public void setIdPersonas(int idPersonas) {
		this.idPersonas = idPersonas;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [idPersonas=" + idPersonas + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion="
				+ direccion + "]";
	}

}
