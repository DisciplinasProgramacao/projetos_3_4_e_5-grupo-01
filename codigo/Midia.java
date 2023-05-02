
public class Midia {

	private String nome;
	private String genero;
	private String idioma;
	private int audiencia;
	private String dataLancamento;
	private long id;

	public Midia(String nome, String genero, String idioma, int audiencia,String dataLancamento,long id) {
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.audiencia = audiencia;
		this.dataLancamento = dataLancamento;
		this.id = id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}