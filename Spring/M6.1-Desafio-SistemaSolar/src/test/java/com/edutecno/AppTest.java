package com.edutecno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.edutecno.model.Luna;
import com.edutecno.model.Planeta;

/**
 * Pruebas unitarias Planetas
 */
public class AppTest {
	
	//atributos utilizados para las pruebas, pueden ser final para que no se alteren sus valores
	private Planeta planeta;
	private Luna l1;
	private Luna l2;
	
	//antes se setee el planeta y las lunas
	//se agregan las lunas al planeta
	@Before
	public void setUp() {
		
		//LUNAS MARTE
		l1 = new Luna();
    	l1.setNombre("Deimos");
    	l1.setDiametro(8);
    	l1.setTiempoOrbita(1263);
    	
    	l2 = new Luna();
    	l2.setNombre("Phobos");
    	l2.setDiametro(560);
    	l2.setTiempoOrbita(0.319f);
    	
    	//PLANETA MARTE
    	planeta = new Planeta();
    	planeta.setNombre("Marte");
    	planeta.setDistanciaAlSol(227940000);
    	planeta.setTamanho(6794);
    	planeta.setLunas(new ArrayList<Luna>(Arrays.asList(l1,l2)));
		
	}
	
	@Test
	public void planetaTest() {
		//verificando el nombre del planeta
		assertTrue(planeta.getNombre().equals("Marte"));
		//verficando que planeta no sea null, sea instanciado
		assertNotNull(planeta);
		//verificando el tamaño del planeta
		assertEquals(6794, planeta.getTamanho(), 0);
	}
	
	@Test
	public void lunaTest() {
		//verficando la existencia de dos lunas, verificando que se agregan lunas
		assertTrue(planeta.getLunas().size() == 2);
		//verficando que el nombre de la Luna en el indice 0 corresponda a Deimos
		assertTrue(planeta.getLunas().get(0).getNombre().equals("Deimos"));
		//verificando que la Luna existente en el planeta en el indice 1 corresponda a 
		assertTrue(planeta.getLunas().get(1).equals(l2));	
	}
	
	@Test
	public void cantidadLunas(){
		//verificando cantidad de lunas en el planeta
		assertEquals(2, planeta.getLunas().size());
	}
}
