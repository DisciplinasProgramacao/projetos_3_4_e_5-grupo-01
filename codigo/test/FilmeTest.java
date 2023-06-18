package test;
import org.junit.Test;

import Filme;

import static org.junit.Assert.*;

import org.junit.Before;

public class FilmeTest {
    Filme f;
    @Before
    public void setUp() throws Exception{
        f = new Filme("Matrix", "Ficção-científica", "PT-BR", 5400, 0, 01,
         "01/01/1999");
    }
    @Test
    public void registrarAudienciaTest(){

        f.registrarAudiencia();
    
        assertEquals(1, f.getAudiencia());
        
      }
}
