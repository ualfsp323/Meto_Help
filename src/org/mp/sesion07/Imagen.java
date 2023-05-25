package org.mp.sesion07;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.mp.sesion05.ElementoNoEncontradoException;

public class Imagen extends Banda {
	private String formatoImagen;
	private String tipoImagen;
	private int lineas;
	private int columnas;
	private ArrayList<Banda> bandas;

	public Imagen(int lineas, int columnas, String formatoImagen, String tipoImagen) {
		super();
		this.lineas = lineas;
		this.columnas = columnas;
		this.formatoImagen = formatoImagen;
		this.tipoImagen = tipoImagen;
		this.bandas= new ArrayList<Banda>();

	}

	public Number[] getDatosPixel(int x, int y) {
			Number b[] = null;	
		for( int i = 0; i < x; i++ ) {
			
		    for( int j = 0; j < y; j++ ) {
             Number a=  getDatoXY(x,y);
             b [j]= a;
             }
		}
		return b;
	}

	public void anadirBanda(Banda<?> bandai) {
        ObjectOutputStream.
        ObjectImputStream
		Banda<Integer> banda = new Banda(bandai.getNombreBanda(), (T[][]) bandai.getDatos());
		bandas.add(bandai);

	}

	public Imagen extraerImagen(int x1, int y1, int x2, int y2) throws XYFueraImagenException{
		BufferedImage imagen = ImageIO.read(ImagenDAO.leerArchivo(null));
	    BufferedImage subImagen = imagen.getSubimage(x1, y1, x2 - x1, y2 - y1);
	    return new Imagen(subImagen);
	}

	public void eliminarBanda(int i) {
           bandas.remove(i)		;
	}

	public ArrayList<Banda<?>> getBandas() {
	    return bandas;

	}

	public int getNumeroBandas() {
		return bandas.size();
	}

	public int getLineas() {
		BufferedImage image;
		try {
			image = ImageIO.read(new File("ruta/a/la/imagen.jpg"));
		int lineas = image.getHeight();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lineas;
	}
	public int getColumnas() {
		BufferedImage image;
		try {
			image = ImagenDAO.leerArchivo(getNombreBanda());
		int columnas = image.getWidth();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return columnas;
	}

	public String getTipoImagen() {
		File file = new File("ruta/a/tu/imagen.jpg");
        BufferedImage image = ImageIO.read(file);
        String format = image.getFormatName();
        return format;
	}

	public void setTipoImagen(String tipoImg) {
	    this.tipoImagen = tipoImg;
		
	}

	public String getFormatoImagen() {
		String format = null;

		 format = ImageIO.read(ImagenDAO.leerArchivo(null)).getFormatName();
		 return format;
	}


	
	
}
