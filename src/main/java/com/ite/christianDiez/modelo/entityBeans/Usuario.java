package com.ite.christianDiez.modelo.entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private int idUsuario;

	private String direccion;

	private String email;

	private int enabled;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REGISTRO")
	private Date fechaRegistro;

	private String nombre;

	private String password;

	private String username;

	public Usuario() {
	}

	public Usuario(int idUsuario, String direccion, String email, int enabled, Date fechaRegistro, String nombre,
			String password, String username) {
		super();
		this.idUsuario = idUsuario;
		this.direccion = direccion;
		this.email = email;
		this.enabled = enabled;
		this.fechaRegistro = fechaRegistro;
		this.nombre = nombre;
		this.password = password;
		this.username = username;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", direccion=" + direccion + ", email=" + email + ", enabled="
				+ enabled + ", fechaRegistro=" + fechaRegistro + ", nombre=" + nombre + ", password=" + password
				+ ", username=" + username + "]";
	}

}