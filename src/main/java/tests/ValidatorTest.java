package tests;

import static org.junit.Assert.assertTrue;

import javax.xml.bind.Validator;

import org.junit.Before;
import org.junit.Test;

import core.Validador;

public class ValidatorTest {

	private String xsd;
	private String xmlOk;
	private String xmlRoto;

	@Before
	public void setUp() throws Exception {
		this.xsd = "documentoProductorConsumidor.xsd";
		this.xmlOk = "documentoProductorConsumidor.xml";
		this.xmlRoto = "documentoProductorConsumidorRoto.xml";
	}

	@Test
	public void test() {
		assertTrue(Validador.validate(xmlOk, xsd));
	}

	@Test
	public void testRoto() {
		assertTrue(!Validador.validate(xmlRoto, xsd));
	}

}
