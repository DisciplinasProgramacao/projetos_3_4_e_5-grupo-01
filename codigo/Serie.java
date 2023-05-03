
import java.util.Random;

public class Serie extends Midia{
	private static final String[] GENEROS = {"romance", "acao", "comedia"};
	private static final String[] IDIOMAS = {"PT-BR", "PT-PG", "ENG"};
	private int quantidadeEpisodios;
  
	public Serie(String nome, String genero, String idioma, int quantidadeEpisodios, int audiencia, long idSerie, String dataLancamento) {
		super(nome,genero,idioma,audiencia,dataLancamento,idSerie);
		this.quantidadeEpisodios = quantidadeEpisodios;
	}
  

	public int getQuantidadeEpisodios() {
		return quantidadeEpisodios;
	}
  
	public void setQuantidadeEpisodios(int quantidadeEpisodios) {
		this.quantidadeEpisodios = quantidadeEpisodios;
	}
  
  
	public static String[] getGeneros() {
		return GENEROS;
	}


  	static public Serie carregaSerie(String linha) {
        String regex = ",";
        String[] campos = null;
        Random gerador = new Random();

            if (linha != null) {
                campos = linha.split(regex);
                Serie serie = new Serie (campos[1], GENEROS[gerador.nextInt(3)], IDIOMAS[gerador.nextInt(3)], gerador.nextInt(24), gerador.nextInt(0, 100000), Integer.parseInt(campos[0]), campos[2]);
                return serie;
            }
            return null;
    }

}
