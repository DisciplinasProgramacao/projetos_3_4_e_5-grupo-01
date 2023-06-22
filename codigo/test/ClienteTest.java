package test;
import org.junit.Test;

import Avaliacao;
import Cliente;
import Filme;
import Midia;
import Serie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import excecoes.ClienteNaoProfissional;
import excecoes.usuarioNaoPodeComentarException;

public class ClienteTest{

  Serie s1;
  Cliente c1;
  Cliente c2;
  Cliente c3;
  
  @Before
	public void setUp() throws Exception {
   s1 = new Serie ("teste1", Generos.ACAO , Idiomas.PTBR , 5 , 0, 0, "1/10/2020");
   c1 = new clienteComum("Cliente teste1", "1234", "login");
   c2 = new clienteProfissional("Cliente teste1", "1234", "login");
   c3 = new clienteEspecialista("vinicius", "1234", "vinicius@gmail.com");
  }

  @Test
  public void testAdicionarNaListaParaVer(){
    assertEquals(0, c1.getListaParaVer().size());
    c1.adicionaNaListaParaVer(s1);
    assertEquals(1, c1.getListaParaVer().size());
  }

  @Test
  public void testRetiraDaLista() {
    c1.adicionaNaListaParaVer(s1);
    assertEquals(1, c1.getListaParaVer().size());
    c1.retirarDaLista(s1.getNome());
    assertEquals(0, c1.getListaParaVer().size());
  }

  @Test
  public void testFiltrarPorGenero() {
      Generos genero = Generos.ACAO; 
      Lista<Midia> resultado = c1.filtrarPorGenero(genero);
      
      for (int i = 0; i < resultado.size(); i++) {
          Midia midia = resultado.get(i);
          assertEquals(genero, midia.getGenero());
      }
  }
  

  @Test
  public void testFiltrarPorIdioma() {
     c1.adicionaNaListaParaVer(s1);
     Idiomas idioma = Idiomas.PTBR;
     
     Lista<Midia> resultado = c1.filtrarPorIdioma(idioma);
    
     for (int i = 0; i < resultado.size(); i++) {
         Midia midia = resultado.get(i);
         assertEquals(idioma, midia.getIdioma());
     }
    
    
  }

  @Test
  public void testFiltrarPorQtdEpisodios() {
      c1.adicionaNaListaParaVer(s1);
      assertEquals(5,s1.getQuantidadeEpisodios());
    
  }

  @Test
  public void testRegistrarAudiencia() throws ClienteNaoProfissional {
      try {
          c1.registrarAudiencia(s1);
          fail("Uma exceção ClienteNaoProfissional deveria ter sido lançada.");
      } catch (ClienteNaoProfissional e) {
          assertEquals("Cliente nao pode assistir nenhum lançamento, pois não possui o perfil profissional", e.getMessage());
      }

      try {
          c2.registrarAudiencia(s1);
      } catch (ClienteNaoProfissional e) {
          fail("Uma exceção ClienteNaoProfissional não deveria ter sido lançada.");
      }

      HashMap<Midia, LocalDate> a = c2.getListaJaVista();
      assertEquals(1, a.size());
  }


  @Test 
  public void testAvaliacao() throws usuarioNaoPodeComentarException, ClienteNaoProfissional{
    Midia m1 = new Midia("Hora de Aventura", Generos.ACAO, Idiomas.PTBR, 0, "23/10/2005", 0);
    Avaliacao v = new Avaliacao(3, "12/03/2023");

    c2.adicionaNaListaParaVer(m1);
    c2.registrarAudiencia(m1);

    m1.adicionarAvaliacao(c2, v);

    Float result = c2.notaDaMidia(m1);

    assertEquals(3.0f, result, 0.001);
  }
}
