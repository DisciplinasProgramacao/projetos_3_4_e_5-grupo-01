import excecoes.midiaJaAvaliadaException;
import excecoes.usuarioNaoPodeComentarException;

/**
 * A interface Avalia define um contrato para avaliar uma mídia com base em uma avaliação.
 */
public interface Avalia {
    
    /**
     * Avalia a mídia específica.
     *
     * @param midia a mídia avaliada
     * @param avaliacao a avaliação feita pelo cliente
     * @throws midiaJaAvaliadaException caso a mídia já tenha sido avaliada pelo cliente anteriormente
     * @throws usuarioNaoPodeComentarException caso o usuário não tenha permissão para comentar na avaliação
     */
    void avaliarMidia(Midia midia, Avaliacao avaliacao) throws midiaJaAvaliadaException, usuarioNaoPodeComentarException;
}
