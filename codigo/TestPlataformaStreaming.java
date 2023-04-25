import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestPlataformaStreaming {
    private PlataformaStreaming plataforma;

    @Before
    public void setUp() {
        plataforma = new PlataformaStreaming();
        plataforma.setNome("Minha Plataforma");
        plataforma.setSeries(new HashMap<String, Serie>());
        plataforma.setClientes(new HashMap<String, Cliente>());
    }

    @Test
    public void testLogin() {
        Cliente cliente1 = new Cliente("joao123", "senha123");
        Cliente cliente2 = new Cliente("maria456", "senha456");
        plataforma.adicionarCliente(cliente1);
        plataforma.adicionarCliente(cliente2);

        Cliente clienteLogado = plataforma.login("joao123", "senha123");
        assertNotNull(clienteLogado);
        assertEquals(cliente1, plataforma.getClienteAtual());

        clienteLogado = plataforma.login("maria456", "senha456");
        assertNotNull(clienteLogado);
        assertEquals(cliente2, plataforma.getClienteAtual());

        clienteLogado = plataforma.login("joao123", "senha456");
        assertNull(clienteLogado);
        assertNull(plataforma.getClienteAtual());
    }

    @Test
    public void testAdicionarSerie() {
        Serie serie1 = new Serie("Serie 1", "Genero 1", "Idioma 1", 10, 0);
        Serie serie2 = new Serie("Serie 2", "Genero 2", "Idioma 2", 20, 0);

        plataforma.adicionarSerie(serie1);
        assertEquals(1, plataforma.getSeries().size());
        assertEquals(serie1, plataforma.getSeries().get("Serie 1"));

        plataforma.adicionarSerie(serie2);
        assertEquals(2, plataforma.getSeries().size());
        assertEquals(serie2, plataforma.getSeries().get("Serie 2"));
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
        Serie s1 = new Serie("The Crown", "drama", "inglês", 10);
        Serie s2 = new Serie("Stranger Things", "ficção", "inglês", 20);
        plataforma.getSeries().put("1", s1);
        plataforma.getSeries().put("2", s2);

        Lista<Serie> listaFiltrada = plataforma.filtrarPorGenero("drama");

        assertEquals(1, listaFiltrada.size());
    }

    @Test
    public void testFiltrarPorIdioma() {
        Serie s1 = new Serie("The Crown", "drama", "inglês", 10);
        Serie s2 = new Serie("Stranger Things", "ficção", "inglês", 20);
        plataforma.getSeries().put("1", s1);
        plataforma.getSeries().put("2", s2);

        Lista<Serie> listaFiltrada = plataforma.filtrarPorIdioma("inglês");

        assertEquals(2, listaFiltrada.size());
    }

    @Test
    public void testFiltrarPorQtdEpisodios() {
        Serie s1 = new Serie("The Crown", "drama", "inglês", 10);
        Serie s2 = new Serie("Stranger Things", "ficção", "inglês", 20);
        plataforma.getSeries().put("1", s1);
        plataforma.getSeries().put("2", s2);

        Lista<Serie> listaFiltrada = plataforma.filtrarPorQtdEpisodios(10);

        assertEquals(1, listaFiltrada.size());
    }

    @Test
    public void testRegistrarAudiencia() {
        Serie s1 = new Serie("The Crown", "drama", "inglês", 10);
        plataforma.getSeries().put("1", s1);

        plataforma.registrarAudiencia(s1);
        assertEquals(1, s1.getAudiencia());

        plataforma.registrarAudiencia(s1);
        assertEquals(2, s1.getAudiencia());
    }
}
