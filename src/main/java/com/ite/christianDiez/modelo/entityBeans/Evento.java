package com.ite.christianDiez.modelo.entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the eventos database table.
 * 
 */
@Entity
@Table(name = "eventos")
@NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EVENTO")
	private int idEvento;

	@Column(name = "AFORO_MAXIMO")
	private int aforoMaximo;

	private String descripcion;

	private String destacado;

	private String direccion;

	private int duracion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;

	@Column(name = "MINIMO_ASISTENCIA")
	private int minimoAsistencia;

	private String nombre;

	private BigDecimal precio;

	// uni-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name = "ID_TIPO")
	private Tipo tipo;

	public Evento() {
	}

	public Evento(int idEvento, int aforoMaximo, String descripcion, String destacado, String direccion, int duracion,
			String estado, Date fechaInicio, int minimoAsistencia, String nombre, BigDecimal precio, Tipo tipo) {
		super();
		this.idEvento = idEvento;
		this.aforoMaximo = aforoMaximo;
		this.descripcion = descripcion;
		this.destacado = destacado;
		this.direccion = direccion;
		this.duracion = duracion;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.minimoAsistencia = minimoAsistencia;
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public int getAforoMaximo() {
		return this.aforoMaximo;
	}

	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDestacado() {
		return this.destacado;
	}

	public void setDestacado(String destacado) {
		this.destacado = destacado;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getMinimoAsistencia() {
		return this.minimoAsistencia;
	}

	public void setMinimoAsistencia(int minimoAsistencia) {
		this.minimoAsistencia = minimoAsistencia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvento;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		if (idEvento != other.idEvento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", aforoMaximo=" + aforoMaximo + ", descripcion=" + descripcion
				+ ", destacado=" + destacado + ", direccion=" + direccion + ", duracion=" + duracion + ", estado="
				+ estado + ", fechaInicio=" + fechaInicio + ", minimoAsistencia=" + minimoAsistencia + ", nombre="
				+ nombre + ", precio=" + precio + ", tipo=" + tipo + "]";
	}

}