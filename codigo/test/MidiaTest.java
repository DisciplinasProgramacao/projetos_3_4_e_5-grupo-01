package test;
import org.junit.Test;

import Avaliacao;
import Cliente;
import Midia;

import static org.junit.Assert.*;

import org.junit.Before;

public class MidiaTest {

    private Midia midia;
    private Cliente c1;
    private Cliente c2;

    @Before
    public void setUp() {
        midia = new Midia("Nome da Mídia", "Gênero", "Idioma", 0, "Data de Lançamento", 1);
        c1 = new Cliente("Cliente teste1", "1234", "login");
        c2 = new Cliente("Cliente teste2", "4321", "login2");
    }
    @Test
    public void testRegistrarAudiencia() {
        int audienciaInicial = midia.getAudiencia();
        midia.registrarAudiencia();
        int novaAudiencia = midia.getAudiencia();
        assertEquals(audienciaInicial + 1, novaAudiencia);
    }
    @Test
    public void testAvaliar() {
        Avaliacao avaliacao1 = new Avaliacao();
        Avaliacao avaliacao2 = new Avaliacao();

        boolean resultado1 = midia.avaliar(c1, avaliacao1);
        boolean resultado2 = midia.avaliar(c2, avaliacao2);

        assertTrue(resultado1);
        assertTrue(resultado2);

        assertEquals(avaliacao1, midia.getNotas().get(c1));
        assertEquals(avaliacao2, midia.getNotas().get(c2));
    }
    @Test
    public void testCalcMedia() {
        Avaliacao avaliacao1 = new Avaliacao();
        avaliacao1.setNota(5);
        Avaliacao avaliacao2 = new Avaliacao();
        avaliacao2.setNota(4);
        Avaliacao avaliacao3 = new Avaliacao();
        avaliacao3.setNota(3);

        midia.avaliar(c1, avaliacao1);
        midia.avaliar(c2, avaliacao2);
        midia.avaliar(c1, avaliacao3);

        double media = midia.calcMedia();
        assertEquals(4.0, media, 0.001);
    }
}
