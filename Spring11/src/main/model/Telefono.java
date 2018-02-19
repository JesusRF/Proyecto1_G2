package com.ejemplos.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@SuppressWarnings("unused")
@Entity
@Table(name = "TELEFONOS")
public class Telefono implements Serializable {
	public static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTelefonos;
	private String telefono;
	@JoinColumn(name = "idPersona", referencedColumnName = "id")
	//@ManyToOne
	private int idPersona;

	public Telefono() {
	}

	public Telefono(Integer idTelefonos, String telefono) {
		this.idTelefonos = idTelefonos;
		this.telefono = telefono;
	}

	public int getIdTelefonos() {
		return idTelefonos;
	}

	public void setIdTelefonos(int idTelefonos) {
		this.idTelefonos = idTelefonos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	@Override
	public String toString() {
		return "Telefonos [idTelefonos=" + idTelefonos + ", telefono=" + telefono + ", idPersona=" + idPersona + "]";
	}

}