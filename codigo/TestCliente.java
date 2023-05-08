import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCliente{

  Serie s1;
  Cliente c1;
  
  @BeforeEach
	void setUp() throws Exception {
   s1 = new Serie ("Serie teste1", "Drama" , "Português" , 5 , 0);
   c1 = new Cliente("Cliente teste1", "1234");
  }

  @Test
  public void testAdicionarNaLista(){
    assertEquals(0, c1.getListaParaVer());
    c1.adicionaNaLista(s1);
    assertEquals(1, c1.getListaParaVer());
  }

  @Test
  public void testRetiraDaLista() {
    c1.adicionaNaLista(s1);
    assertEquals(1, c1.getListaParaVer());
    c1.retirarDaLista();
    assertEquals(0, c1.getListaParaVer());
  }

  @Test
  public void testFiltrarPorGenero(){
    c1.adicionaNaLista(s1);
    assertEquals(1, c1.filtrarPorGenero("Drama").size());
  }

  @Test
  public void testFiltrarPorIdioma() {
     c1.adicionaNaLista(s1);
    assertEquals(1, c1.filtrarPorIdioma("Português").size());
  }

  @Test
  public void testFiltrarPorQtdEpisodios() {
    c1.adicionaNaLista(s1);
    assertEquals(1, c1.filtrarPorQtdEpisodios(5).size());
  }

  @Test
  public void testRegistrarAudiencia() {
    c1.adicionaNaLista(s1);
    assertEquals(1, c1.getListaParaVer());
    c1.registrarAudiencia(s1);
     assertEquals(0, c1.getListaParaVer());
     assertEquals(1, c1.getListaJaVista());

    assertEquals(1, s1.getListaJaVista());
  }

  @Test 
  public void testAvaliacao(){
    Midia m1 = new Midia("Hora de Aventura", Filme.GENEROS[0], Filme.IDIOMAS[0], 0, "23/10/2005", 0);
    Cliente c1 = new Cliente("vinicius", "1234", "vinicius@gmail.com");

    c1.adicionaNaListaParaVer(m1);
    c1.registrarAudiencia(m1);

    c1.avaliar(m1);

    Integer result = c1.notaDaMidia(m1);

    assertEquals("", 8, result, 0);
  }
}