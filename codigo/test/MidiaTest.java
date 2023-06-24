
import org.junit.Test;

import excecoes.usuarioNaoPodeComentarException;

import static org.junit.Assert.*;

import org.junit.Before;

public class MidiaTest {
	private Midia midia;
    private Midia midia1;
    private Midia midia2;
    private Midia midia3;
    private Midia midia4;
    private Midia midia5;
    private Midia midia6;
    private Cliente c1;
    private Cliente c2;
    private Cliente c3;

    @Before
    public void setUp() {
    	midia = new Midia("nome", Generos.ACAO, Idiomas.ENG, 3, "23/06/2023", 4);
        midia1 = new Midia("nome", Generos.ACAO, Idiomas.ENG, 3, "23/06/2023", 4);
        midia2 = new Midia("nome", Generos.ACAO, Idiomas.ENG, 3, "23/06/2023", 4);
        midia3 = new Midia("nome", Generos.ACAO, Idiomas.ENG, 3, "23/06/2023", 4);
        midia4 = new Midia("nome", Generos.ACAO, Idiomas.ENG, 3, "23/06/2023", 4);
        midia5 = new Midia("nome", Generos.ACAO, Idiomas.ENG, 3, "23/06/2023", 4);
        midia6 = new Midia("nome", Generos.ACAO, Idiomas.ENG, 3, "23/06/2023", 4);
        c1 = new clienteComum("Cliente teste1", "1234", "login");
        c2 = new clienteEspecialista("Cliente teste2", "4321", "login2");
        c3 = new clienteProfissional("Cliente teste3", "4321", "login3");
    }
    @Test
    public void testLancamento() {
    	assertFalse(midia1.isLancamento());
    	midia1.tornarLancamento();
    	assertTrue(midia1.isLancamento());
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
        Avaliacao avaliacao1 = new Avaliacao(5, "12/02/2006");
        Avaliacao avaliacao2 = new Avaliacao(3, "dsadsada","12/02/2006");
        c2.adicionaNaListaVistas(midia1);
        c2.adicionaNaListaVistas(midia2);
        c2.adicionaNaListaVistas(midia3);
        c2.adicionaNaListaVistas(midia4);
        c2.adicionaNaListaVistas(midia5);

         try {
			midia.adicionarAvaliacao(c1, avaliacao1);
			midia.adicionarAvaliacao(c2, avaliacao2);
		} catch (usuarioNaoPodeComentarException e) {
			
		}

         assertFalse(c2.isComum());
        
        assertEquals(avaliacao1, midia.getNotas().get(c1));
        assertEquals(avaliacao2, midia.getNotas().get(c2));
    }
    @Test
    public void testCalcMedia() {
    	Avaliacao avaliacao1 = new Avaliacao(5, "12/02/2006");
        Avaliacao avaliacao2 = new Avaliacao(10, "12/02/2006");
        Avaliacao avaliacao3 = new Avaliacao(3, "12/02/2006");

        
        try {
			midia.adicionarAvaliacao(c1, avaliacao3);
			midia.adicionarAvaliacao(c3, avaliacao1);
	        midia.adicionarAvaliacao(c2, avaliacao2);
		} catch (usuarioNaoPodeComentarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        double media = midia.calcMedia();
        assertEquals(6.0, media, 0.001);
    }
    
    @Test
    public void testJaAssistiu() {
    	c1.adicionaNaListaVistas(midia1);
    	assertFalse(c1.jaAssistiu(midia));
    	assertTrue(c1.jaAssistiu(midia1));
    }
    
    @Test
    public void testPossuiAvaliacao() {
    	Avaliacao avaliacao1 = new Avaliacao(5, "12/02/2006");
    	assertFalse(midia1.possuiAvaliacao(c1));
    	try {
			midia1.adicionarAvaliacao(c1, avaliacao1);
		} catch (usuarioNaoPodeComentarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(midia1.possuiAvaliacao(c1)); 
    	assertTrue(midia1.possuiAvaliacao(c1));
    }
    
    @Test
    public void testTipoCliente(){
    	Avaliacao avaliacao1 = new Avaliacao(5, "12/02/2006");
        Avaliacao avaliacao2 = new Avaliacao(3, "dsadsada","12/02/2006");
        c1.adicionaNaListaVistas(midia1);
        c1.adicionaNaListaVistas(midia2);
        c1.adicionaNaListaVistas(midia3);
        c1.adicionaNaListaVistas(midia4);
        
        c2.adicionaNaListaVistas(midia1);
        c2.adicionaNaListaVistas(midia2);
        c2.adicionaNaListaVistas(midia3);
        c2.adicionaNaListaVistas(midia4);
        c2.adicionaNaListaVistas(midia5);
        
        try {
			assertTrue(c2.isEspecialista());
			assertFalse(c1.isEspecialista());
		} catch (usuarioNaoPodeComentarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertFalse(c2.isComum());
        assertTrue(c1.isComum());
    }
    @Test
    public void testGetAndSetGenero() {
    	assertEquals(midia1.getGenero(), Generos.ACAO);
    	midia1.setGenero(Generos.DOCUMENTARIO);
    	assertEquals(midia1.getGenero(), Generos.DOCUMENTARIO);
    }
    @Test
    public void testGetAndSetIdiomas() {
    	assertEquals(midia1.getIdioma(), Idiomas.ENG);
    	midia1.setIdioma(Idiomas.PTBR);
    	assertEquals(midia1.getIdioma(), Idiomas.PTBR);
    }
    @Test
    public void testGetAndSetId() {
    	assertEquals(midia1.getId(), 4);
    	midia1.setId(9);
    	assertEquals(midia1.getId(), 9);
    }
}