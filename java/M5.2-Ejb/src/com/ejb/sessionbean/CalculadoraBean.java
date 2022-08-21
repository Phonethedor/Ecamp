package com.ejb.sessionbean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculadoraBean
 */
@Stateless
@LocalBean
public class CalculadoraBean {
	
	
	public CalculadoraBean() {
        // TODO Auto-generated constructor stub
    }
	
    public float add(float x, float y) {
        return x + y;
    }
    
    
    public float subtract(float x, float y) {
        return x - y;
    }

   
    public float mutliply(float x, float y) {
        return x * y;
    }

    
    public float divide(float x, float y) {
        return x / y;
    } 
}
