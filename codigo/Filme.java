
import java.util.Random;

public class Filme extends Midia {
	private static final String[] GENEROS = { "romance", "acao", "comedia" };
	private static final String[] IDIOMAS = { "PT-BR", "PT-PG", "ENG" };
	private int duracaoSeg;

	public Filme(String nome, String genero, String idioma, int duracaoSeg, int audiencia, long idFilme,
			String dataLancamento) {
		super(nome, genero, idioma, audiencia, dataLancamento, idFilme);
		this.duracaoSeg = duracaoSeg;

	}

	public void setDuracaoSeg(int duracaoSeg) {
		this.duracaoSeg = duracaoSeg;
	}

	public Filme carregaFilme(String linha) {
		String regex = ",";
		String[] campos = null;
		Random gerador = new Random();

		if (linha != null) {
			campos = linha.split(regex);
			Filme filme = new Filme(campos[1], GENEROS[gerador.nextInt(3)], IDIOMAS[gerador.nextInt(3)],
					gerador.nextInt(24), gerador.nextInt(0, 100000), Integer.parseInt(campos[0]), campos[2]);
			return filme;
		}
		return null;
	}

	public int getDuracaoSeg() {
		return duracaoSeg;
	}

}
