

public class Midia {

	private String nome;
	private String genero;
	private String idioma;
	private int audiencia;

	public Midia(String nome, String genero, String idioma, int audiencia) {
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.audiencia = audiencia;
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
}
