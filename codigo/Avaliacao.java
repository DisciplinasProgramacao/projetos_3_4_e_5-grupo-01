/**
 * A classe Avaliacao representa uma avaliação de uma mídia, contendo informações como a nota, o comentário e a data da avaliação.
 */
public class Avaliacao {

    private float nota;
    private String comentario;
    private String data;

    /**
     * Cria uma nova instância de Avaliacao com a nota, comentário e data especificados.
     *
     * @param nota a nota da avaliação
     * @param comentario o comentário da avaliação
     * @param data a data da avaliação
     */
    public Avaliacao(float nota, String comentario, String data) {
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }

    /**
     * Cria uma nova instância de Avaliacao apenas com a nota e a data especificadas.
     * O comentário será definido como nulo.
     *
     * @param nota a nota da avaliação
     * @param data a data da avaliação
     */
    public Avaliacao(float nota, String data) {
        this.nota = nota;
        this.comentario = null;
        this.data = data;
    }

    /**
     * Obtém a nota da avaliação.
     *
     * @return a nota da avaliação
     */
    public float getNota() {
        return nota;
    }

    /**
     * Define a nota da avaliação.
     *
     * @param nota a nota da avaliação
     */
    public void setNota(float nota) {
        this.nota = nota;
    }

    /**
     * Obtém o comentário da avaliação.
     *
     * @return o comentário da avaliação
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Define o comentário da avaliação.
     *
     * @param comentario o comentário da avaliação
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Obtém a data da avaliação.
     *
     * @return a data da avaliação
     */
    public String getData() {
        return data;
    }

    /**
     * Define a data da avaliação.
     *
     * @param data a data da avaliação
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Retorna uma representação em formato de string da avaliação.
     *
     * @return uma string representando a avaliação
     */
    @Override
    public String toString() {
        return "Avaliacao {" +
                "nota=" + nota +
                ", comentario='" + comentario + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
