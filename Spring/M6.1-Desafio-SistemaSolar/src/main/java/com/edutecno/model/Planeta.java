package com.edutecno.model;

import java.util.ArrayList;

import com.edutecno.interfaces.IPlaneta;

public class Planeta implements IPlaneta {

	//atributos
	private String nombre;
	private float tamanho;
	private float distanciaAlSol;
	private ArrayList<Luna> lunas; //inyeccion de Luna en la clase planeta
	
	@Override
	public String getNombre() {
		return nombre;
	}
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public float getTamanho() {
		return tamanho;
	}
	@Override
	public void setTamanho(float tamanho) {
		this.tamanho = tamanho;
	}
	@Override
	public float getDistanciaAlSol() {
		return distanciaAlSol;
	}
	@Override
	public void setDistanciaAlSol(float distanciaAlSol) {
		this.distanciaAlSol = distanciaAlSol;
	}
	@Override
	public ArrayList<Luna> getLunas() {
		return lunas;
	}
	@Override
	public void setLunas(ArrayList<Luna> lunas) {
		this.lunas = lunas;
	}
	@Override
	public String toString() {
		
		return "Planeta: " + nombre + " está a " + distanciaAlSol + "km del sol, su tamaño es de " + tamanho + "km de diámetro y tiene " + lunas.size() + " luna(s)";
//		return "Planeta [nombre=" + nombre + ", tamano=" + tamano + ", distanciaSol=" + distanciaSol + ", lunas="
//		+ lunas + "]";
	}
}
