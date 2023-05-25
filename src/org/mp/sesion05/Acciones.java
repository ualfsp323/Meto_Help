package org.mp.sesion05;

import java.util.ArrayList;
import java.util.List;

public class Acciones {
	private List<Accion> acciones;

	public Acciones() {
       this.acciones= new ArrayList<Accion>();
	}
    public  void add(Accion accion) {
    	acciones.add(accion);
    }
	public List getAcciones() {
		ArrayList<Object> copy = new ArrayList<Object>(acciones);
		return copy;
	}
}
