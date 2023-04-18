package com.inventario.core.entities;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Color {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nombre;
	    
	    @OneToMany(mappedBy = "color")
	    private List<Existencia> existencias;

		public Color() {
			super();
		}

		public Color(Long id, String nombre, List<Existencia> existencias) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.existencias = existencias;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public List<Existencia> getExistencias() {
			return existencias;
		}

		public void setExistencias(List<Existencia> existencias) {
			this.existencias = existencias;
		}
	    
	    

}
