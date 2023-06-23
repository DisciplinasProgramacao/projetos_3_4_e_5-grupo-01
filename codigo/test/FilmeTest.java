
import org.junit.Test;


import static org.junit.Assert.*;

import org.junit.Before;

public class FilmeTest {
    Filme f;
    @Before
    public void setUp() throws Exception{
        f = new Filme("Matrix", Generos.ACAO, Idiomas.ENG, 5400, 0, 01,
         "01/01/1999");
    }
    @Test
    public void registrarAudienciaTest(){

        f.registrarAudiencia();
    
        assertEquals(1, f.getAudiencia());
        
      }
    @Test
    public void getduracaoTest(){
    	assertEquals(5400, f.getDuracaoSeg());
        
      }
    @Test
    public void getGenero(){
    	assertEquals(Generos.ACAO, f.getGenero());
        
      }
    
    @Test
    public void getDataLancamento(){
    	assertEquals("01/01/1999", f.getDataLancamento());
        
      }
}
