package test;
import Avaliacao;
import Cliente;
import Filme;
import Midia;
import Serie;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import excecoes.ClienteNaoProfissional;
import excecoes.usuarioNaoPodeComentarException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PlataformaStreamingTest {
    private PlataformaStreaming plataforma;
    Random random = new Random();
    Serie s1;
    Serie s2;
    Cliente c1;
    Cliente c2;
    Avaliacao a1;

    @Before
    public void setUp() {
        plataforma = new PlataformaStreaming();
        plataforma.setNome("Minha Plataforma");
        plataforma.setSeries(new HashMap<String, Midia>());
         s1 = new Serie("The Crown", Generos.DRAMA, Idiomas.ENG, 10, 6,4,"12/03/2342");
         s2 = new Serie("Stranger Things", Generos.AVENTURA, Idiomas.ENG, 20, 1, 2, "17/02/2004");
         c1 = new clienteProfissional("teste1", "1234", "login");
         c2 = new clienteProfissional("teste2", "1234", "dsa");
         a1= new Avaliacao(10, "sdada", "12/02/2000");
         try {
			c1.registrarAudiencia(s1);
		} catch (ClienteNaoProfissional e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
         try {
			s1.adicionarAvaliacao(c1, a1);
		} catch (usuarioNaoPodeComentarException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
    }
    
    public  void criador() {
    	Random random = new Random();
    	for (int i = 0; i < 100; i++) {
    	    String nomeSerie = "Série " + i;
    	    Generos genero = Generos.DRAMA;
    	    Idiomas idioma = Idiomas.ENG;
    	    int duracao = 10;
    	    int audiencia = random.nextInt(10001);
    	    int id = random.nextInt(1001);
    	    String dataLancamento = "12/03/2342";

    	    Serie serie = new Serie(nomeSerie, genero, idioma, duracao, audiencia, id, dataLancamento);
    	    plataforma.adicionarMidia(serie);
    	}

    	List<Serie> seriesDisponiveis = new ArrayList<>(plataforma.getMidia().values().stream()
    	        .filter(midia -> midia instanceof Serie)
    	        .map(midia -> (Serie) midia)
    	        .collect(Collectors.toList()));
    	for (int i = 0; i < 100; i++) {
    	    String nomeCliente = "Cliente" + i;
    	    String senhaCliente = "senha" + i;
    	    String loginCliente = "login" + i;

    	    Cliente cliente = new clienteProfissional(nomeCliente, senhaCliente, loginCliente);

    	    try {
    	        cliente.registrarAudiencia(s1);
    	    } catch (ClienteNaoProfissional e) {
//    	        e.printStackTrace();
    	    }

    	    plataforma.adicionarCliente(cliente);

    	    for (Serie serie : seriesDisponiveis) {
    	        int nota = random.nextInt(11);
    	        String data = "Data " + i;

    	        Avaliacao avaliacao = new Avaliacao(nota,data);

    	        try {
    	            serie.adicionarAvaliacao(cliente, avaliacao);
    	        } catch (usuarioNaoPodeComentarException e) {
//    	            e.printStackTrace();
    	        }
    	    }
    	}
    	}

    @Test
    public void testLogin() {
        Cliente cliente1 = new clienteComum("joao123", "senha123", "login");
        Cliente cliente2 = new clienteComum("maria456", "senha456", "login2");
        plataforma.adicionarCliente(cliente1);
        plataforma.adicionarCliente(cliente2);

        boolean clienteLogado = plataforma.login("login", "senha123");
        assertTrue(clienteLogado);
        assertEquals(cliente1, plataforma.getClienteAtual());

        clienteLogado = plataforma.login("login2", "senha456");
        assertTrue(clienteLogado);
        assertEquals(cliente2, plataforma.getClienteAtual());

        clienteLogado = plataforma.login("login", "senha456");
        assertFalse(clienteLogado);
    }

    @Test
    public void testAdicionarSerie() {
        Serie serie1 = new Serie("Serie 1", Generos.ACAO, Idiomas.PTBR, 10, 0, 1, "01/1/2000");
        Serie serie2 = new Serie("Serie 2", Generos.ANIME, Idiomas.PTPG, 10, 0, 2, "01/6/2003");

        plataforma.adicionarMidia(serie1);
        assertEquals(1, plataforma.getMidia().size());

  
        assertEquals(serie1, plataforma.getMidia().get("1"));

        plataforma.adicionarMidia(serie2);

        assertEquals(2, plataforma.getMidia().size());
        assertEquals(serie2, plataforma.getMidia().get("2"));
    }

    @Test
    public void testAdicionarCliente() {
        Cliente cliente1 = new clienteComum("Joao", "joao123", "senha123");
        Cliente cliente2 = new clienteComum("Maria", "maria123", "senha456");

        plataforma.adicionarCliente(cliente1);
//        System.out.println(plataforma.getClientes());
        assertEquals(1, plataforma.getClientes().size());
        assertEquals(cliente1, plataforma.getClientes().get("Joao"));
        
        
        

        plataforma.adicionarCliente(cliente2);
        assertEquals(2, plataforma.getClientes().size());
        assertEquals(cliente2, plataforma.getClientes().get("Maria"));
    }
    
    @Test
    public void testFiltrarPorGenero() {
        plataforma.getMidia().put("1", s1);
        plataforma.getMidia().put("2", s2);

        Lista<Midia> listaFiltrada = plataforma.filtrarPorGenero(Generos.DRAMA);

        assertEquals(1, listaFiltrada.size());
    }

    @Test
    public void testFiltrarPorIdioma() {
        plataforma.getMidia().put("1", s1);
        plataforma.getMidia().put("2", s2);

        Lista<Midia> listaFiltrada = plataforma.filtrarPorIdioma(Idiomas.ENG);

        assertEquals(2, listaFiltrada.size());
    }

    @Test
    public void testFiltrarPorQtdEpisodios() {
        plataforma.getMidia().put("1", s1);
        plataforma.getMidia().put("2", s2);

        Lista<Midia> listaFiltrada = plataforma.filtrarPorQtdEpisodios(10);

        assertEquals(1, listaFiltrada.size());
    }

    @Test
    public void testTop10MidiasMelhorAvaliacao() {
    	criador();
        List<Midia> top10 = plataforma.top10MidiasMelhorAvaliacao();
        
        assertEquals(10, top10.size());
        
    }

    @Test
    public void testTop10MidiasMelhorAvaliacaoSeparadaPorGenero() {
    	criador();
        List<Midia> top10PorGenero = plataforma.top10MidiasMelhorAvaliacaoSeparadaPorGenero();
        assertEquals(10, top10PorGenero.size());
    }

    @Test
    public void testTop10MidiasMaisVisualizacaoSeparadaPorGenero() {
    	criador();
        List<Midia> top10PorGenero = plataforma.top10MidiasMaisVisualizacaoSeparadaPorGenero();
        assertEquals(10, top10PorGenero.size());
    }

    @Test
    public void testClienteMaisAssistiuMidiasNumMidias() {
    	plataforma.adicionarCliente(c1);
    	try {
			c1.registrarAudiencia(s1);
		} catch (ClienteNaoProfissional e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
        Map<Integer, Cliente> mapaClientes = plataforma.clienteMaisAssistiuMidiasNumMidias();
        assertEquals(1, mapaClientes.size());
        assertEquals(c1, mapaClientes.get(1));
         
    }

    @Test
    public void testClienteMaisAvaliouNumAvaliacoes() {
    	criador();
        Map.Entry<String, Cliente> entry = plataforma.clienteMaisAvaliouNumAvaliacoes();
        Assertions.assertNotNull(entry);
    }

    @Test
    public void testClientesMaisDe15Avaliacoes() {
    	criador();
        double porcentagem = plataforma.clientesMaisDe15Avaliacoes();
        Assertions.assertEquals(100, porcentagem);
    }
    @Test
    public void existeMidia() {
    	plataforma.adicionarMidia(s1);
    	assertTrue(plataforma.existeMidia("4"));
    }
    @Test 
    public void getMidiaEspecifica() {
    	plataforma.adicionarMidia(s1);
    	Midia confirmacao = plataforma.getMidiaEspecifica("4");
    	assertEquals(s1, confirmacao);
    }
}