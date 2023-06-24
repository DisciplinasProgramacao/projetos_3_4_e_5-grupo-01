/**
 * Classe que representa um Filme, uma subclasse de Midia.
 * Contém métodos e atributos específicos de filmes.
 */
public class Filme extends Midia {
    /**
     * A duração do filme em segundos.
     */
    private int duracaoSeg;

    /**
     * Construtor da classe Filme.
     *
     * @param nome o nome do filme.
     * @param genero o gênero do filme.
     * @param idioma o idioma do filme.
     * @param duracaoSeg a duração do filme em segundos.
     * @param audiencia a audiência do filme.
     * @param idFilme o id do filme.
     * @param dataLancamento a data de lançamento do filme.
     */
    public Filme(String nome, Generos genero, Idiomas idioma, int duracaoSeg, int audiencia, int idFilme, String dataLancamento) {
        super(nome, genero, idioma, audiencia, dataLancamento, idFilme);
        this.duracaoSeg = duracaoSeg;
    }

    /**
     * Obtém a duração do filme em segundos.
     *
     * @return a duração do filme em segundos.
     */
    public int getDuracaoSeg() {
        return duracaoSeg;
    }

    /**
     * Define a duração do filme em segundos.
     *
     * @param duracaoSeg a duração do filme em segundos.
     */
    public void setDuracaoSeg(int duracaoSeg) {
        this.duracaoSeg = duracaoSeg;
    }

    /**
     * Carrega um filme a partir de uma linha de texto em um arquivo.
     *
     * @param linha a linha de texto a ser carregada.
     * @return o objeto Filme correspondente à linha de texto.
     */
    public static Filme carregaFilme(String linha) {
        String regex = ";";
        String[] campos = null;

        if (linha != null) {
            campos = linha.split(regex);
            int idFilme = Integer.parseInt(campos[0].trim());
            String nome = campos[1];
            String dataLancamento = campos[2];
            int duracaoSeg = Integer.parseInt(campos[3]);

            Filme filme = new Filme(nome, Generos.ACAO, Idiomas.PTBR, duracaoSeg, 0, idFilme, dataLancamento);

            return filme;
        }
        return null;
    }
}
