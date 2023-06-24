
import java.util.Random;

/**
 * A classe Serie representa uma série de TV que é uma forma de mídia.
 * A série possui características específicas, como a quantidade de episódios.
 * Ela herda os atributos e métodos da classe Midia.
 */
public class Serie extends Midia {
    private int quantidadeEpisodios;

    /**
     * Construtor da classe Serie que recebe informações sobre a série, como nome, gênero, idioma, quantidade de episódios, audiência, ID da série e data de lançamento.
     * Chama o construtor da superclasse Midia para inicializar os atributos herdados.
     *
     * @param nome               O nome da série.
     * @param genero             O gênero da série.
     * @param idioma             O idioma da série.
     * @param quantidadeEpisodios A quantidade de episódios da série.
     * @param audiencia          A audiência da série.
     * @param idSerie            O ID da série.
     * @param dataLancamento     A data de lançamento da série.
     */
    public Serie(String nome, Generos genero, Idiomas idioma, int quantidadeEpisodios, int audiencia, int idSerie, String dataLancamento) {
        super(nome, genero, idioma, audiencia, dataLancamento, idSerie);
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    /**
     * Obtém a quantidade de episódios da série.
     *
     * @return A quantidade de episódios.
     */
    public int getQuantidadeEpisodios() {
        return quantidadeEpisodios;
    }

    /**
     * Define a quantidade de episódios da série.
     *
     * @param quantidadeEpisodios A quantidade de episódios.
     */
    public void setQuantidadeEpisodios(int quantidadeEpisodios) {
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    /**
     * Carrega uma série a partir de uma linha de dados.
     * A linha é dividida em campos separados por ponto e vírgula.
     * Os campos são utilizados para criar uma instância de série com valores aleatórios para a quantidade de episódios.
     *
     * @param linha A linha de dados contendo as informações da série.
     * @return A instância de série carregada com os dados da linha.
     */
    public static Serie carregaSerie(String linha) {
        String regex = ";";
        String[] campos = null;

        if (linha != null) {
            campos = linha.split(regex);
            int id = Integer.parseInt(campos[0].trim());
            String nome = campos[1];
            String dataLancamento = campos[2];

            Random random = new Random();
            int qtdEp = random.nextInt(24);

            Serie serie = new Serie(nome, Generos.POLICIAL, Idiomas.PTBR, qtdEp, 0, id, dataLancamento);
            return serie;
        }
        return null;
    }
}


