package com.edutecno.interfaces;

import java.util.ArrayList;

import com.edutecno.model.Luna;

public interface IPlaneta {
	
	public String getNombre();
	public void setNombre(String nombre);
	public float getTamanho();
	public void setTamanho(float tamanho);
	public float getDistanciaAlSol();
	public void setDistanciaAlSol(float distanciaAlSol);
	public ArrayList<Luna>getLunas();
	public void setLunas(ArrayList<Luna> lunas);

}
