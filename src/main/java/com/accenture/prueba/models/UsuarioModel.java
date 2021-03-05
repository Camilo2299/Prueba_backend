package com.accenture.prueba.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id", unique = true, nullable = false)
	private long idUsuario;

	@Column(name = "usuario_nombre", nullable = false, unique = false)
	private String nombreUsuario;
	
	@Column(name = "usuario_apellido", nullable = false, unique = false)
	private String apellidoUsuario;

	@Column(name = "usuario_cedula", nullable = false, unique = true)
	private String cedula;

	@Column(name = "usuario_direccion", nullable = false, unique = false)
	private String direccion;

	@Column(name = "usuario_barrio", nullable = false, unique = false)
	private String barrio;
	
	@Column(name = "usuario_ciudad", nullable = false, unique = false)
	private String ciudad;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public UsuarioModel() {

	}

	public UsuarioModel(long idUsuario, String nombreUsuario, String apellidoUsuario, String cedula, String direccion,
			String barrio, String ciudad) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.cedula = cedula;
		this.direccion = direccion;
		this.barrio = barrio;
		this.ciudad = ciudad;
	}

	

}
