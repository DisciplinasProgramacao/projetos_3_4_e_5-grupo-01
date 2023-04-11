import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestSerie{

  Serie s1;
  
  @BeforeEach
	void setUp() throws Exception {
   s1 = new Serie("Serie teste1", "Drama" , "Português" , 5 , 0);
  }

  @Test
  public void registrarAudienciaTest(){

    s1.registrarAudiencia();

    assertEquals(1, s1.getAudiencia());
    
  }
}
