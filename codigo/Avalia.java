import excecoes.midiaJaAvaliadaException;
import excecoes.usuarioNaoPodeComentarException;

public interface Avalia {
    void avaliarMidia(Midia midia, Avaliacao avaliacao) throws midiaJaAvaliadaException, usuarioNaoPodeComentarException;
}
