package org.mp.sesion06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.*;

public class UtilidadArchivos {
	private ArrayList lista;
    public UtilidadArchivos() {
    	this.lista = new ArrayList();
    }
	public static void copiar(File origen, File destino) throws IOException {
		FileInputStream Org = new FileInputStream(origen);
		FileOutputStream Des = new FileOutputStream(destino);
		byte[] buf = new byte[1024];
		int len; 
		
		while ((len = Org.read(buf)) > 0) {
			Des.write(buf, 0, len);
		}

		Org.close();
		Des.close();
	}

	
   	public ArrayList listarDirectoriosArchivos(File dir) {

        lista.clear();

	   listarDirectoriosArchivosRec(dir);
			
		return lista;
	}

       private void listarDirectoriosArchivosRec(File dir) {
   		File[] ficheros = dir.listFiles();

   		for (int i=0;i<ficheros.length;i++) {
   			if (ficheros[i].isDirectory()) {
				listarDirectoriosArchivosRec(ficheros[i]);
			} else {
				lista.add(ficheros[i]);
			}   			}
       }


	 
    	
		public void zip(File dir, String salida, String nombreFichero) {
			listarDirectoriosArchivos(dir);
			 
			try {
				String ArchivoSalida = salida + File.pathSeparator + nombreFichero;
				FileOutputStream fos = new FileOutputStream(ArchivoSalida);

				ZipOutputStream zos = new ZipOutputStream(fos);
				for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
					File elemento = (File) iterator.next();
					if (elemento.isFile()) {
						FileInputStream fis = new FileInputStream(elemento.getAbsolutePath());
					
					zos.putNextEntry(new ZipEntry(elemento.getAbsolutePath()));

					byte[] bytes = new byte[1024];
					int length;
					while ((length = fis.read(bytes)) >= 0) {
						zos.write(bytes, 0, length);
					}

					zos.closeEntry();
					fis.close();
				}
				}
				zos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
