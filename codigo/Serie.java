package proj345;

import java.util.Random;

public class Serie {
	private static final String[] GENEROS = {"romance", "acao", "comedia"};
	private static final String[] IDIOMAS = {"PT-BR", "PT-PG", "ENG"};
	private String nome;
	private String genero;
	private String idioma;
	private int quantidadeEpisodios;
	private int audiencia;
	private long idSerie;
	private String dataLancamento;
  
	public Serie(String nome, String genero, String idioma, int quantidadeEpisodios, int audiencia, long idSerie, String dataLancamento) {
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.quantidadeEpisodios = quantidadeEpisodios;
		this.audiencia = audiencia;
		this.idSerie = idSerie;
		this.dataLancamento = dataLancamento;
	}
  
	public String getNome() {
		return nome;
	}
  
	public void setNome(String nome) {
		this.nome = nome;
	}
  
	public String getGenero() {
		return genero;
	}
  
	public void setGenero(String genero) {
		this.genero = genero;
	}
  
	public String getIdioma() {
		return idioma;
	}
  
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
  
	public int getQuantidadeEpisodios() {
		return quantidadeEpisodios;
	}
  
	public void setQuantidadeEpisodios(int quantidadeEpisodios) {
		this.quantidadeEpisodios = quantidadeEpisodios;
	}
  
	public int getAudiencia() {
		return audiencia;
	}
  
	public void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
	}
  
	public static String[] getGeneros() {
		return GENEROS;
	}
	public long getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(long idSerie) {
		this.idSerie = idSerie;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

  //incrementa a audiencia da serie toda vez que ela for assistida por algum Cliente.
	public void registrarAudiencia(){
    
    setAudiencia(this.audiencia + 1);
  
  }
  public Serie carregaSerie(String linha) {
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
