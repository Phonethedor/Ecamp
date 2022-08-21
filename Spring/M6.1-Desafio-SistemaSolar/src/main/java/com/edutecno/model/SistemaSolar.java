package com.edutecno.model;

import java.util.ArrayList;

public class SistemaSolar {
	
	//atributos
	private ArrayList<Planeta> planetas;//inyeccion de Planeta como un ArrayList<Planeta>
	
	//getters y setters
	public ArrayList<Planeta> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(ArrayList<Planeta> planetas) {
		this.planetas = planetas;
	}
	//metodo
	public void monstrarPlanetas() {
		for (Planeta planeta : planetas) {
			System.out.println(planeta.toString());
		}
	}
	//metodo
	public void monstrarPlanetasYLunas() {
		for (Planeta planeta : planetas) {
			if (!planeta.getLunas().isEmpty()) {
				System.out.println("Planeta y sus lunas");
				System.out.println(planeta.toString() +" "+ planeta.getLunas());
			}
		}
	}
}
