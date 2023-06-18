package test;
import org.junit.Before;
import org.junit.Test;

import Cliente;
import Lista;
import Midia;
import PlataformaStreaming;
import Serie;

import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PlataformaStreamingTest {
    private PlataformaStreaming plataforma;

    @Before
    public void setUp() {
        plataforma = new PlataformaStreaming();
        plataforma.setNome("Minha Plataforma");
        plataforma.setSeries(new HashMap<String, Midia>());
        plataforma.setClientes(new HashMap<String, Cliente>());
    }

    @Test
    public void testLogin() {
        Cliente cliente1 = new Cliente("joao123", "senha123", "login");
        Cliente cliente2 = new Cliente("maria456", "senha456", "login2");
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
        assertNull(plataforma.getClienteAtual());
    }

    @Test
    public void testAdicionarSerie() {
        Serie serie1 = new Serie("Serie 1", "Genero 1", "Idioma 1", 10, 0, 1, "01/1/2000");
        Serie serie2 = new Serie("Serie 2", "Genero 2", "Idioma 2", 20, 0, 2, "10/10/2010");

        plataforma.adicionarMidia(serie1);
        assertEquals(1, plataforma.getMidia().size());
        assertEquals(serie1, plataforma.getMidia().get("Serie 1"));

        plataforma.adicionarMidia(serie2);
        assertEquals(2, plataforma.getMidia().size());
        assertEquals(serie2, plataforma.getMidia().get("Serie 2"));
    }

    @Test
    public void testAdicionarCliente() {
        Cliente cliente1 = new Cliente("Joao", "joao123", "senha123");
        Cliente cliente2 = new Cliente("Maria", "maria123", "senha456");

        plataforma.adicionarCliente(cliente1);
        assertEquals(1, plataforma.getClientes().size());
        assertEquals(cliente1, plataforma.getClientes().get("joao123"));

        plataforma.adicionarCliente(cliente2);
        assertEquals(2, plataforma.getClientes().size());
        assertEquals(cliente2, plataforma.getClientes().get("maria123"));
    }
    
    @Test
    public void testFiltrarPorGenero() {
        Serie s1 = new Serie("The Crown", "drama", "inglês", 10, 1, 0, "12/12/2012");
        Serie s2 = new Serie("Stranger Things", "ficção", "inglês", 20, 1, 2, "17/02/2004");
        plataforma.getMidia().put("1", s1);
        plataforma.getMidia().put("2", s2);

        Lista<Midia> listaFiltrada = plataforma.filtrarPorGenero("drama");

        assertEquals(1, listaFiltrada.size());
    }

    @Test
    public void testFiltrarPorIdioma() {
        Serie s1 = new Serie("The Crown", "drama", "inglês", 10, 1, 0, "12/12/2012");
        Serie s2 = new Serie("Stranger Things", "ficção", "inglês", 20, 1, 2, "17/02/2004");
        plataforma.getMidia().put("1", s1);
        plataforma.getMidia().put("2", s2);

        Lista<Midia> listaFiltrada = plataforma.filtrarPorIdioma("inglês");

        assertEquals(2, listaFiltrada.size());
    }

    @Test
    public void testFiltrarPorQtdEpisodios() {
        Serie s1 = new Serie("The Crown", "drama", "inglês", 10, 1, 0, "12/12/2012");
        Serie s2 = new Serie("Stranger Things", "ficção", "inglês", 20, 1, 2, "17/02/2004");
        plataforma.getMidia().put("1", s1);
        plataforma.getMidia().put("2", s2);

        Lista<Midia> listaFiltrada = plataforma.filtrarPorQtdEpisodios(10);

        assertEquals(1, listaFiltrada.size());
    }

    @Test
    public void testRegistrarAudiencia() {
        Serie s1 = new Serie("The Crown", "drama", "inglês", 10, 1, 0, "12/12/2012");
        plataforma.getMidia().put("1", s1);

        plataforma.registrarAudiencia(s1);
        assertEquals(1, s1.getAudiencia());

        plataforma.registrarAudiencia(s1);
        assertEquals(2, s1.getAudiencia());
    }
}
