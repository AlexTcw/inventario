package com.converter.csvjson.service.util;

public class ExtractedFields {

	private String nombre;
	private String tokenActivacion;
	private String email;

	public ExtractedFields() {
		super();
	}

	public ExtractedFields(String nombre, String tokenActivacion, String email) {
		super();
		this.nombre = nombre;
		this.tokenActivacion = tokenActivacion;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTokenActivacion() {
		return tokenActivacion;
	}

	public void setTokenActivacion(String tokenActivacion) {
		this.tokenActivacion = tokenActivacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
