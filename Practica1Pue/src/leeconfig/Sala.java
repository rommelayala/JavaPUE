package leeconfig;

import java.util.ArrayList;

public class Sala {
	String nombre;
	ArrayList<Fecha> semana = new ArrayList<Fecha>();

	public Sala(String nombre, ArrayList<Fecha> semana) {
		super();
		this.nombre = nombre;
		this.semana = semana;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Fecha> getSemana() {
		return semana;
	}

	public void setSemana(ArrayList<Fecha> semana) {
		this.semana = semana;
	}

}
