
import java.util.Random;

public class Filme extends Midia {
	static final String[] GENEROS = { "romance", "acao", "comedia" };
	static final String[] IDIOMAS = { "PT-BR", "PT-PG", "ENG" };
	private int duracaoSeg;

	public Filme(String nome, String genero, String idioma, int duracaoSeg, int audiencia, int idFilme,
			String dataLancamento) {
		super(nome, genero, idioma, audiencia, dataLancamento, idFilme);
		this.duracaoSeg = duracaoSeg;

	}

	public void setDuracaoSeg(int duracaoSeg) {
		this.duracaoSeg = duracaoSeg;
	}

	public static Filme carregaFilme(String linha) {
		
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
			int duracao = random.nextInt(10800 - 3600 + 1) + 3600;
			//10800 - 3600

			Filme filme = new Filme(nome, GENEROS[genero], IDIOMAS[idioma], duracao, 0, id, dataLancamento);
			return filme;
		}


		// if (linha != null) {
		// 	campos = linha.split(regex);
		// 	int aux = Integer.parseInt(campos[3]) * 60;
		// 	//IdFilme;Nome;DataDeLançamento;Duração(min)
		// 	Filme filme = new Filme(campos[1], GENEROS[gerador.nextInt(3)], IDIOMAS[gerador.nextInt(3)],
		// 			aux, gerador.nextInt(0, 100000), Integer.parseInt(campos[0]), campos[2]);
		// 	return filme;
		// }
		return null;
	}

	public int getDuracaoSeg() {
		return duracaoSeg;
	}

	
}
