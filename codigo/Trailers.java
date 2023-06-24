/**
 * A classe Trailers representa um trailer de uma mídia.
 * Ela contém informações básicas sobre o trailer, como nome, gênero, idioma, ID e data de lançamento.
 */
public class Trailers {
    private String nome;
    private Generos genero;
    private Idiomas idioma;
    private int id;
    private String dataLancamento;

    /**
     * Obtém o nome do trailer.
     *
     * @return O nome do trailer.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do trailer.
     *
     * @param nome O nome do trailer.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o gênero do trailer.
     *
     * @return O gênero do trailer.
     */
    public Generos getGenero() {
        return genero;
    }

    /**
     * Define o gênero do trailer.
     *
     * @param genero O gênero do trailer.
     */
    public void setGenero(Generos genero) {
        this.genero = genero;
    }

    /**
     * Obtém o idioma do trailer.
     *
     * @return O idioma do trailer.
     */
    public Idiomas getIdioma() {
        return idioma;
    }

    /**
     * Define o idioma do trailer.
     *
     * @param idioma O idioma do trailer.
     */
    public void setIdioma(Idiomas idioma) {
        this.idioma = idioma;
    }

    /**
     * Obtém o ID do trailer.
     *
     * @return O ID do trailer.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do trailer.
     *
     * @param id O ID do trailer.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém a data de lançamento do trailer.
     *
     * @return A data de lançamento do trailer.
     */
    public String getDataLancamento() {
        return dataLancamento;
    }

    /**
     * Define a data de lançamento do trailer.
     *
     * @param dataLancamento A data de lançamento do trailer.
     */
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
