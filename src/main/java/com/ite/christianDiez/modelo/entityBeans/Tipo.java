package com.ite.christianDiez.modelo.entityBeans;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tipos database table.
 * 
 */
@Entity
@Table(name = "tipos")
@NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO")
	private int idTipo;

	private String descripcion;

	private String nombre;

	public Tipo() {
	}

	public Tipo(int idTipo, String descripcion, String nombre) {
		super();
		this.idTipo = idTipo;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tipo))
			return false;
		Tipo other = (Tipo) obj;
		if (idTipo != other.idTipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tipo [idTipo=" + idTipo + ", descripcion=" + descripcion + ", nombre=" + nombre + "]";
	}

}