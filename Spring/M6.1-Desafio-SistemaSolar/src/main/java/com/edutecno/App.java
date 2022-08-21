package com.edutecno;

import java.util.ArrayList;
import java.util.Arrays;

import com.edutecno.model.Luna;
import com.edutecno.model.Planeta;
import com.edutecno.model.SistemaSolar;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
       
    	//construir cada luna
    	//construir cada planeta
    	//asignar cada luna a cada planeta
    	
    	//TIERRA
    	Luna lunaTierra = new Luna();
    	lunaTierra.setNombre("Luna");
    	lunaTierra.setDiametro(384400);
    	lunaTierra.setTiempoOrbita(27322);
    	
    	Planeta planetaTierra = new Planeta();
    	planetaTierra.setNombre("Tierra");
    	planetaTierra.setTamanho(12756);
    	planetaTierra.setDistanciaAlSol(149600000);
    	planetaTierra.setLunas(new ArrayList<Luna>(Arrays.asList(lunaTierra)));
    	
    	//MARTE
    	Luna lunaMarte1 = new Luna();
    	lunaMarte1.setNombre("Deimos");
    	lunaMarte1.setDiametro(8);
    	lunaMarte1.setTiempoOrbita(1263);
    	
    	Luna lunaMarte2 = new Luna();
    	lunaMarte2.setNombre("Phobos");
    	lunaMarte2.setDiametro(560);
    	lunaMarte2.setTiempoOrbita(0.319f);
    	
    	Planeta planetaMarte = new Planeta();
    	planetaMarte.setNombre("Marte");
    	planetaMarte.setDistanciaAlSol(227940000);
    	planetaMarte.setTamanho(6794);
    	planetaMarte.setLunas(new ArrayList<Luna>(Arrays.asList(lunaMarte1,lunaMarte2)));
    	
    	//MERCURIO
    	Planeta planetaMercurio = new Planeta();
    	planetaMercurio.setNombre("Mercurio");
    	planetaMercurio.setDistanciaAlSol(57910000);
    	planetaMercurio.setTamanho(4880);
    	planetaMercurio.setLunas(new ArrayList<Luna>());
    	
    	//VENUS
    	Planeta planetaVenus = new Planeta();
    	planetaVenus.setNombre("Venus");
    	planetaVenus.setDistanciaAlSol(108200000);
    	planetaVenus.setTamanho(12104);
    	planetaVenus.setLunas(new ArrayList<Luna>());
    	
    	//planetaJupiter
    	Luna lunaplanetaJupiter1 = new Luna();
    	lunaplanetaJupiter1.setNombre("Callisto");
    	lunaplanetaJupiter1.setDiametro(4800);
    	lunaplanetaJupiter1.setTiempoOrbita(16689);
    	
    	Luna lunaplanetaJupiter2 = new Luna();
    	lunaplanetaJupiter2.setNombre("Europa");
    	lunaplanetaJupiter2.setTiempoOrbita(3551);
    	lunaplanetaJupiter2.setDiametro(3126);
    	
    	Planeta planetaJupiter = new Planeta();
    	planetaJupiter.setNombre("planetaJupiter");
    	planetaJupiter.setDistanciaAlSol(778330000);
    	planetaJupiter.setTamanho(142984);
    	planetaJupiter.setLunas(new ArrayList<Luna>(Arrays.asList(lunaplanetaJupiter1,lunaplanetaJupiter2)));
    	
    	//planetaSaturno
    	Luna lunaplanetaSaturno1 = new Luna();
    	lunaplanetaSaturno1.setNombre("Aegir");
    	lunaplanetaSaturno1.setDiametro(6);
    	lunaplanetaSaturno1.setTiempoOrbita(1116.5f);
    	
    	Luna lunaplanetaSaturno2 = new Luna();
    	lunaplanetaSaturno2.setNombre("Albiorix");
    	lunaplanetaSaturno2.setTiempoOrbita(783);
    	lunaplanetaSaturno2.setDiametro(30);
    	
    	Planeta planetaSaturno = new Planeta();
    	planetaSaturno.setNombre("planetaSaturno");
    	planetaSaturno.setDistanciaAlSol(1429400000);
    	planetaSaturno.setTamanho(108728);
    	planetaSaturno.setLunas(new ArrayList<Luna>(Arrays.asList(lunaplanetaSaturno1,lunaplanetaSaturno2)));
  
    	//URANO
    	Luna lunaUrano1 = new Luna();
    	lunaUrano1.setNombre("Ariel");
    	lunaUrano1.setDiametro(1160);
    	lunaUrano1.setTiempoOrbita(2520);
    	
    	Luna lunaUrano2 = new Luna();
    	lunaUrano2.setNombre("Belinda");
    	lunaUrano2.setTiempoOrbita(0.624f);
    	lunaUrano2.setDiametro(75260);
    	
    	Planeta planetaUrano = new Planeta();
    	planetaUrano.setNombre("Urano");
    	planetaUrano.setDistanciaAlSol(2870990000f);
    	planetaUrano.setTamanho(51118);
    	planetaUrano.setLunas(new ArrayList<Luna>(Arrays.asList(lunaUrano1,lunaUrano2)));
    	
    	//NEPTUNO
    	Luna lunaNeptuno1 = new Luna();
    	lunaNeptuno1.setNombre("Despina");
    	lunaNeptuno1.setDiametro(160);
    	lunaNeptuno1.setTiempoOrbita(0.40f);
    	
    	Luna lunaNeptuno2 = new Luna();
    	lunaNeptuno2.setNombre("Galatea");
    	lunaNeptuno2.setDiametro(140);
    	lunaNeptuno2.setTiempoOrbita(0.33f);
    	
    	Planeta planetaNeptuno = new Planeta();
    	planetaNeptuno.setNombre("Neptuno");
    	planetaNeptuno.setDistanciaAlSol(4504300000f);
    	planetaNeptuno.setTamanho(49532);
    	planetaNeptuno.setLunas(new ArrayList<Luna>(Arrays.asList(lunaNeptuno1,lunaNeptuno2)));
  	
    	//SISTEMA SOLAR
    	SistemaSolar sistemaSolar = new SistemaSolar();
    	sistemaSolar.setPlanetas(new ArrayList<Planeta>(Arrays.asList(
    															planetaTierra,
    															planetaMarte,
    															planetaMercurio,
    															planetaVenus,
    															planetaJupiter,
    															planetaSaturno,
    															planetaUrano,
    															planetaNeptuno)));
    	
    	
    	sistemaSolar.monstrarPlanetas();
    	sistemaSolar.monstrarPlanetasYLunas();
    }
}
