package tests;

import java.io.File;
import java.util.ArrayList;

import core.DecoderXML;
import core.Mensaje;
import core.Pair;

/**
 * TestDesempaquetado para pruebas de desempaquetamiento de archivos XML
 * 
 */
public class TestDesempaquetado {

	public static void main(String[] args) {
		String dir = System.getProperty("user.home") + File.separator + "productor_consumidor_files";
		String nombre_archivo = "documentoProductorConsumidor";
		DecoderXML desempaquetador = new DecoderXML(dir + File.separator + nombre_archivo + ".xml");
		Pair<Boolean, ArrayList<Mensaje>> desempaquetado = new Pair<Boolean, ArrayList<Mensaje>>(
				desempaquetador.desempaquetar());
		if (desempaquetado.first()) {
			for (Mensaje mensaje : desempaquetado.second()) {
				System.out.println(mensaje.getFecha());
				System.out.println(mensaje.getInteres());
				System.out.println(mensaje.getResumen());
				System.out.println(mensaje.getNoticia());
			}
		} else {
			System.out.println("No se ha podido desempaquetar el mensaje");
		}
	}
}
