
import java.util.Random;

public class Serie extends Midia{
	static final String[] GENEROS = {"romance", "acao", "comedia"};
	static final String[] IDIOMAS = {"PT-BR", "PT-PG", "ENG"};
	private int quantidadeEpisodios;
  
	public Serie(String nome, String genero, String idioma, int quantidadeEpisodios, int audiencia, int idSerie, String dataLancamento) {
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


  public static Serie carregaSerie(String linha) {
        String regex = ";";
        String[] campos = null;
        // Random gerador = new Random();


            if (linha != null) {
                campos = linha.split(regex);
				int id = Integer.parseInt(campos[0].trim());
				// System.out.println(id);
				String nome = campos[1];
				String dataLancamento = campos[2];

				Random random = new Random();
        		int genero = random.nextInt(3);
				int idioma = random.nextInt(3);
				int qtdEp = random.nextInt(24);



				// Serie s = new Serie(nome, )

                Serie serie = new Serie (nome, GENEROS[genero], IDIOMAS[idioma], qtdEp, 0, id, dataLancamento);
                return serie;
            }
            return null;
    }

}
