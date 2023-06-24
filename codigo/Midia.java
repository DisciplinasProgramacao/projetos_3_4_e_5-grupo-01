import java.util.HashMap;

import excecoes.usuarioNaoPodeComentarException;

/**
 * Classe que representa uma mídia em geral.
 */
public class Midia {

	private String nome;
	private Generos genero;
	private Idiomas idioma;
	private int audiencia;
	private String dataLancamento;
	private int id;
	private HashMap<Cliente, Avaliacao> notas;
	private boolean lancamento;
	private double mediaNotas;

	/**
	 * Construtor da classe Midia.
	 *
	 * @param nome           o nome da mídia.
	 * @param genero         o gênero da mídia.
	 * @param idioma         o idioma da mídia.
	 * @param audiencia      a audiência da mídia.
	 * @param dataLancamento a data de lançamento da mídia.
	 * @param id             o ID da mídia.
	 */

	public Midia(String nome, Generos genero, Idiomas idioma, int audiencia, String dataLancamento, int id) {
		this.nome = nome;
		this.audiencia = audiencia;
		this.dataLancamento = dataLancamento;
		this.id = id;
		this.idioma = idioma;
		this.genero = genero;
		this.notas = new HashMap<Cliente, Avaliacao>();
		this.lancamento = false;
		this.mediaNotas = calcMedia();
	}

	/**
	 * Verifica se a mídia é um lançamento.
	 *
	 * @return true se a mídia é um lançamento, false caso contrário.
	 */
	public boolean isLancamento() {
		return lancamento;
	}

	/**
	 * Define se a mídia é um lançamento.
	 *
	 * @param lancamento true se a mídia é um lançamento, false caso contrário.
	 */
	public void setLancamento(boolean lancamento) {
		this.lancamento = lancamento;
	}

	/**
	 * Torna a mídia um lançamento.
	 */
	public void tornarLancamento() {
		setLancamento(true);
	}

	/**
	 * Obtém o mapa de notas da mídia.
	 *
	 * @return o mapa de notas da mídia.
	 */
	public HashMap<Cliente, Avaliacao> getNotas() {
		return notas;
	}

	/**
	 * Define o mapa de notas da mídia.
	 *
	 * @param notas o mapa de notas da mídia.
	 */
	public void setNotas(HashMap<Cliente, Avaliacao> notas) {
		this.notas = notas;
	}

	/**
	 * Adiciona uma avaliação à mídia feita por um cliente.
	 *
	 * @param cliente   o cliente que fez a avaliação.
	 * @param avaliacao a avaliação feita pelo cliente.
	 * @throws usuarioNaoPodeComentarException se o cliente não puder comentar na
	 *                                         avaliação.
	 */
	public void adicionarAvaliacao(Cliente cliente, Avaliacao avaliacao) throws usuarioNaoPodeComentarException {
		if(avaliacao.getComentario() != null) {
			if(cliente.isComum()) {
				System.out.println("entrou");
				throw new usuarioNaoPodeComentarException("Apenas clientes especialistas e profissionais podem comentar");
			}else if (cliente.isEspecialista() || cliente instanceof clienteProfissional){
				notas.put(cliente, avaliacao);
				cliente.adicionarAvaliacao(this, avaliacao);
			}else {
				System.out.println("?");
			}
		}else {
			cliente.adicionarAvaliacao(this, avaliacao);
			notas.put(cliente, avaliacao);
		}
		
		
		
		
//		if (cliente.isEspecialista() || cliente instanceof clienteProfissional) {
//			notas.put(cliente, avaliacao);
//			cliente.adicionarAvaliacao(this, avaliacao);
//		} else if (avaliacao.getComentario()== null) {
//			throw new usuarioNaoPodeComentarException("Apenas clientes especialistas e profissionais podem comentar");
//		} else {
//			cliente.adicionarAvaliacao(this, avaliacao);
//			notas.put(cliente, avaliacao);
//		}
	}

	/**
	 * Verifica se a mídia possui avaliação feita pelo cliente especificado.
	 *
	 * @param cliente o cliente a ser verificado.
	 * @return true se a mídia possui avaliação do cliente, false caso contrário.
	 */
	public boolean possuiAvaliacao(Cliente cliente) {
		return notas.containsKey(cliente);
	}

	/**
	 * Obtém o nome da mídia.
	 *
	 * @return o nome da mídia.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome da mídia.
	 *
	 * @param nome o nome da mídia.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Obtém o gênero da mídia.
	 *
	 * @return o gênero da mídia.
	 */
	public Generos getGenero() {
		return genero;
	}

	/**
	 * Define o gênero da mídia.
	 *
	 * @param genero o gênero da mídia.
	 */
	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	/**
	 * Obtém o idioma da mídia.
	 *
	 * @return o idioma da mídia.
	 */
	public Idiomas getIdioma() {
		return idioma;
	}

	/**
	 * Define o idioma da mídia.
	 *
	 * @param idioma o idioma da mídia.
	 */
	public void setIdioma(Idiomas idioma) {
		this.idioma = idioma;
	}

	/**
	 * Obtém a audiência da mídia.
	 *
	 * @return a audiência da mídia.
	 */
	public int getAudiencia() {
		return audiencia;
	}

	/**
	 * Define a audiência da mídia.
	 *
	 * @param audiencia a audiência da mídia.
	 */
	public void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
	}

	/**
	 * Obtém a data de lançamento da mídia.
	 *
	 * @return a data de lançamento da mídia.
	 */
	public String getDataLancamento() {
		return dataLancamento;
	}

	/**
	 * Define a data de lançamento da mídia.
	 *
	 * @param dataLancamento a data de lançamento da mídia.
	 */
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	/**
	 * Obtém o ID da mídia.
	 *
	 * @return o ID da mídia.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Define o ID da mídia.
	 *
	 * @param id o ID da mídia.
	 */
	public void setId(int id) {
		this.id = id;
	}

	// incrementa a audiencia da serie toda vez que ela for assistida por algum
	// cliente
	public void registrarAudiencia() {

		setAudiencia(getAudiencia() + 1);

	}

	/**
	 * Retorna uma representação em formato de String da mídia.
	 *
	 * @return uma String contendo informações da mídia.
	 */
	public String toString() {
		return "Mídia:\n" +
				"ID: " + getId() + "\n" +
				"Nome: " + getNome() + "\n" +
				"Gênero: " + getGenero() + "\n" +
				"Idioma: " + getIdioma() + "\n" +
				"Audiência: " + getAudiencia() + "\n" +
				"Data de Lançamento: " + getDataLancamento() + "\n";
	}

	/**
	 * Calcula a média de notas dessa mídia
	 */
	public double calcMedia() {

		double soma = 0;
		int quantidade = 0;

		for (Avaliacao a : notas.values()) {
			soma += a.getNota();
			quantidade++;
		}

		if (quantidade > 0) {
			return soma / quantidade;
		} else {
			return 0;
		}

	}

	/**
	 * Retorna a média das notas da mídia.
	 *
	 * @return a média das notas da mídia.
	 */
	public double getMediaNotas() {
		return this.mediaNotas;
	}

	/**
	 * Define a média das notas da mídia.
	 *
	 * @param mediaNotas a média das notas da mídia.
	 */
	public void setMediaNotas(float mediaNotas) {
		this.mediaNotas = mediaNotas;
	}

}
