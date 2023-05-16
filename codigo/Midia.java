import java.util.HashMap;
public class Midia {

	private String nome;
	private String genero;
	private String idioma;
	private int audiencia;
	private String dataLancamento;
	private int id;
	private HashMap<Cliente, Avaliacao> notas;
	
	public Midia(String nome, String genero, String idioma, int audiencia,String dataLancamento, int id) {
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.audiencia = audiencia;
		this.dataLancamento = dataLancamento;
		this.id = id;
		this.notas = new HashMap<Cliente, Avaliacao>();
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

	public int getAudiencia() {
		return audiencia;
	}

	public void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
	}

	// incrementa a audiencia da serie toda vez que ela for assistida por algum
	// Cliente.
	public void registrarAudiencia() {

		setAudiencia(getAudiencia() + 1);

	}

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
     * Avalia a mídias específica, retornando true caso tudo ocorra como o esperado  
     * @param c indica o cliente que fez a avaliação
     * @param avaliacao indica a avaliação feita pelo cliente
     */
	public Boolean avaliar(Cliente c, Avaliacao avaliacao) {
		if (!notas.containsKey(c) ) {
			notas.put(c, avaliacao);
			return true;
		}else {
			//Verificar como conseguir o valor antigo da avaliacao
			Avaliacao avaliacaoAntiga = notas.get(c);
			notas.replace(c, avaliacaoAntiga, avaliacao);
			return true;
		}
		
	}
	

}
