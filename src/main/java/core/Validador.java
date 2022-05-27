package core;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Valida semanticamente un archivo XML
 *
 */
public class Validador {
	
	private String ruta_nombre_xmlFile;
	private String ruta_nombre_schemaFile;
	
	/**
	 * Constructor para crear objeto que valide semanticamente un archivo XML
	 * @param nombre_xmlFile ruta (nombre incluido) del archivo XML
	 * @param nombre_schemaFile ruta (nombre incuido) del archivo XSD
	 */
	public Validador(String nombre_xmlFile, String nombre_schemaFile){
		this.ruta_nombre_xmlFile = nombre_xmlFile;
		this.ruta_nombre_schemaFile = nombre_schemaFile;
	}
	
	/**
	 * Validar semanticamente un arhivo XML
	 * @return si el arhivo es valido
	 */
	public boolean validar() {
		// XML a validar
		Source xmlFile = new StreamSource(new File(this.ruta_nombre_xmlFile));
		// Esquema con el que comparar
		Source schemaFile = new StreamSource(new File(this.ruta_nombre_schemaFile));
		
		// Preparación del esquema
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema;
		try {
			schema = schemaFactory.newSchema(schemaFile);
		} catch (SAXException e) {
			return false;
		}
		
		// Creacion del validador
		Validator validator = schema.newValidator();
		
		// Definicion del manejador de excepciones del validador
		final List<SAXParseException> exceptions = new LinkedList<SAXParseException>();
		validator.setErrorHandler(new ErrorHandler() {
			public void warning(SAXParseException exception)
					throws SAXException {
				exceptions.add(exception);
			}

			public void fatalError(SAXParseException exception)
					throws SAXException {
				exceptions.add(exception);
			}

			public void error(SAXParseException exception) throws SAXException {
				exceptions.add(exception);
			}
		});
		
		// Validacion del XML
		try {
			validator.validate(xmlFile);
		} catch (SAXException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		if (exceptions.size() == 0) {
			return true; //IS VALID
		} else {
			return false; //IS INVALID
		}
	}
	
	/**
	 * Valida el xml.
	 *
	 * @param xml the xml
	 * @param xsd the xsd
	 * @return true, if successful
	 */
	public static boolean validate(String xml, String xsd) {

		try {
			// XML a validar
			Source xmlFile = new StreamSource(new File(xml));
			// Esquema con el que comparar
			Source schemaFile = new StreamSource(new File(xsd));
			// Preparaci�n del esquema
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(schemaFile);
			// Creaci�n del validador
			javax.xml.validation.Validator validator = schema.newValidator();
			// Definici�n del manejador de excepciones del validador
			final List exceptions = new LinkedList();
			validator.setErrorHandler(new ErrorHandler() {
				public void warning(SAXParseException exception) throws SAXException {
					exceptions.add(exception);
				}

				public void fatalError(SAXParseException exception) throws SAXException {
					exceptions.add(exception);
				}

				public void error(SAXParseException exception) throws SAXException {
					exceptions.add(exception);
				}
			});
			// Validaci�n del XML
			validator.validate(xmlFile);
			if (exceptions.size() == 0) {
				System.out.println("FILE " + xmlFile.getSystemId() + " IS VALID");
			} else {
				System.out.println("FILE " + xmlFile.getSystemId() + " IS INVALID");
				return false;
			}
		} catch (SAXException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
	
}
