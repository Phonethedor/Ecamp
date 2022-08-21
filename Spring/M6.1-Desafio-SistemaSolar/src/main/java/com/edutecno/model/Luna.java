package com.edutecno.model;

import com.edutecno.interfaces.ILuna;

public class Luna implements ILuna {
	
	//atributos
	public String nombre;
	public float diametro;
	public float tiempoOrbita;
	
	//constructor vacio esta internamente declarado si no existe otro constructor
	
	@Override
	public String getNombre() {
		return nombre;
	}
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public float getDiametro() {
		return diametro;
	}
	@Override
	public void setDiametro(float diametro) {
		this.diametro = diametro;
	}
	@Override
	public float getTiempoOrbita() {
		return tiempoOrbita;
	}
	@Override
	public void setTiempoOrbita(float tiempoOrbita) {
		this.tiempoOrbita = tiempoOrbita;
	}
	@Override
	public String toString() {
		
		return "Luna de nombre " + nombre + " que mide " + diametro + "km de diámetro y el tiempo que orbita es de " + tiempoOrbita + " días";		
		//return "Luna [nombre=" + nombre + ", diametro=" + diametro + ", tiempoOrbita=" + tiempoOrbita + "]";
	}
}
