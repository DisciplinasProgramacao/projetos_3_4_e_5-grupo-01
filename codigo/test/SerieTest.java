package test;
import org.junit.Test;

import Serie;

import static org.junit.Assert.*;

import org.junit.Before;

public class SerieTest {

	Serie s1;

	@Before
	public void setUp() throws Exception {
		s1 = new Serie("Serie teste1", Generos.ACAO, Idiomas.ENG, 5, 0, 1, "01/1/2000");
	}

	@Test
	public void registrarAudienciaTest() {

		s1.registrarAudiencia();

		assertEquals(1, s1.getAudiencia());
	}
}
