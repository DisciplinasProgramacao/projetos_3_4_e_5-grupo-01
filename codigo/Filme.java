
/**
 *Classe que representa um Filme, uma subclasse de Midia.
 *Contém métodos e atributos específicos de filmes.
*/
public class Filme extends Midia {
	/**
	 *Os gêneros possíveis para um filme.
	*/
	//public static final String[] GENEROS = { "romance", "acao", "comedia" };
	/**
	 *Os idiomas disponíveis para um filme.
	*/
	//public static final String[] IDIOMAS = { "PT-BR", "PT-PG", "ENG" };
	/**
	 *A duração do filme em segundos.
	*/
	private int duracaoSeg;
	/**
	 *Construtor da classe Filme.
	 *@param nome o nome do filme.
	 *@param genero o gênero do filme.
	 *@param idioma o idioma do filme.
	 *@param duracaoSeg a duração do filme em segundos.
	 *@param audiencia a audiência do filme.
	 *@param idFilme o id do filme.
	 *@param dataLancamento a data de lançamento do filme.
	*/

	public Filme(String nome, Generos acao, Idiomas PTBR, int duracao, int audiencia, int id, String dataLancamento) {
		super(nome, acao, PTBR, audiencia, dataLancamento, id);
		this.duracaoSeg = duracao;
	}

	public int getDuracaoSeg() {
		return duracaoSeg;
	}

	public void setDuracaoSeg(int duracaoSeg) {
		this.duracaoSeg = duracaoSeg;
	}
	/**
	 *Método que carrega um filme a partir de uma linha de texto em um arquivo.	
	 *@param linha a linha de texto a ser carregada.
	 *@return o objeto Filme correspondente à linha de texto.
	*/
	public static Filme carregaFilme(String linha) {
		
		String regex = ";";
        String[] campos = null;

		if (linha != null) {
			campos = linha.split(regex);
			int id = Integer.parseInt(campos[0].trim());
			String nome = campos[1];
			String dataLancamento = campos[2];
			int duracao = Integer.parseInt(campos[3]);

			// int duracao = random.nextInt(10800 - 3600 + 1) + 3600;
			

			Filme filme = new Filme(nome, Generos.ACAO, Idiomas.PTBR, duracao, 0, id, dataLancamento);

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

	
}
