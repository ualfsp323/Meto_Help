package org.mp.sesion06;
import org.apache.commons.math3.*;
import org.apache.commons.math3.stat.StatUtils;

import java.io.IOException;
import java.util.Locale;

public class Estadistica {
private ConjuntoDatos cd;
	public Estadistica(ConjuntoDatos cd) throws IOException {
          this.cd=cd = new ConjuntoDatos(cd.getArchivoTexto(), cd.getSeparador(),cd.getLocale());
        }
	public double max(String columna) throws IOException {
		
		double[] columnaDatos=cd.getColumna(columna);
		
		double maximo = StatUtils.max(columnaDatos);
		return maximo;
	}
	public double min(String columna) throws IOException {
	double[] columnaDatos=cd.getColumna(columna);
		
		double minimo = StatUtils.min(columnaDatos);
		return minimo;
	}
	public double suma(String columna) throws IOException {
	double[] columnaDatos=cd.getColumna(columna);
		
		double suma = StatUtils.sum(columnaDatos);
		return suma;		
	}
	public double media(String columna) throws IOException {
	double[] columnaDatos=cd.getColumna(columna);
		
		double media = StatUtils.mean(columnaDatos);
		return media;
	}

}
