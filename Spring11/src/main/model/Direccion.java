package com.ejemplos.spring.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@SuppressWarnings("unused") //Evitar aviso sobre no uso de esta clase
@Entity
@Table(name = "DIRECCIONES") //Tabla de direcciones
public class Direccion implements Serializable {
	public static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDirecciones;
	private String direccion;
	private String codPostal;
	private String localidad;
	private String provincia;
	@JoinColumn(name = "idPersona", referencedColumnName = "id")
    //@ManyToOne
	private int idPersona;

	public Direccion() {
	}

	public Direccion(Integer idDirecciones, String direccion, String localidad) {
		this.idDirecciones = idDirecciones;
		this.direccion = direccion;
		this.localidad = localidad;
	}

	public int getIdDirecciones() {
		return idDirecciones;
	}

	public void setIdDirecciones(int idDirecciones) {
		this.idDirecciones = idDirecciones;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	@Override
	public String toString() {
		return "Direccion [idDirecciones=" + idDirecciones + ", direccion=" + direccion + ", codPostal=" + codPostal
				+ ", localidad=" + localidad + ", provincia=" + provincia + ", idPersona=" + idPersona + "]";
	}

}
