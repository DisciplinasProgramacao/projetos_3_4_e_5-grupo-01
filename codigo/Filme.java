package proj345;

import java.util.Random;

public class Filme {
	private static final String[] GENEROS = {"romance", "acao", "comedia"};
	private static final String[] IDIOMAS = {"PT-BR", "PT-PG", "ENG"};
	private String nome;
	private String genero;
	private String idioma;
	private int duracaoSeg;
	private int audiencia;
	private long idFilme;
	private String dataLancamento;
  
	public Filme(String nome, String genero, String idioma, int duracaoSeg, int audiencia, long idFilme, String dataLancamento) {
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.duracaoSeg = duracaoSeg;
		this.audiencia = audiencia;
		this.idFilme = idFilme;
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
  
	public int getDuracaoSeg() {
		return duracaoSeg;
	}
  
	public void setDuracaoSeg(int duracaoSeg) {
		this.duracaoSeg = duracaoSeg;
	}
  
	public int getAudiencia() {
		return audiencia;
	}
  
	public void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
	}
	
	public Filme carregaFilme(String linha) {
        String regex = ",";
        String[] campos = null;
        Random gerador = new Random();

            if (linha != null) {
                campos = linha.split(regex);
                Filme filme = new Filme (campos[1], GENEROS[gerador.nextInt(3)], IDIOMAS[gerador.nextInt(3)], gerador.nextInt(24), gerador.nextInt(0, 100000), Integer.parseInt(campos[0]), campos[2]);
                return filme;
            }
            return null;
    }

	public long getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(long idFilme) {
		this.idFilme = idFilme;
	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
}

