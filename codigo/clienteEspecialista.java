import excecoes.midiaJaAvaliadaException;
import excecoes.usuarioNaoPodeComentarException;

/**
 * A classe clienteEspecialista representa um cliente especialista que herda as características da classe Cliente e implementa a interface Avalia.
 */
public class clienteEspecialista extends Cliente implements Avalia {

    /**
     * Constrói um objeto clienteEspecialista com o nome de usuário, senha e login especificados.
     *
     * @param nomeDeUsuario o nome de usuário do cliente especialista
     * @param senha a senha do cliente especialista
     * @param login o login do cliente especialista
     */
    public clienteEspecialista(String nomeDeUsuario, String senha, String login) {
        super(nomeDeUsuario, senha, login);
    }

    /**
     * Constrói um objeto clienteEspecialista com base em um clienteComum existente.
     *
     * @param clienteComum o cliente comum a partir do qual o cliente especialista será criado
     */
    public clienteEspecialista(clienteComum clienteComum) {
        super(clienteComum.getNomeDeUsuario(), clienteComum.getSenha(), clienteComum.getLogin());
    }

    /**
     * Avalia uma mídia específica com a avaliação fornecida pelo cliente especialista.
     *
     * @param midia a mídia a ser avaliada
     * @param avaliacao a avaliação feita pelo cliente especialista
     * @throws midiaJaAvaliadaException se o cliente já tiver avaliado a mídia anteriormente
     */
    @Override
    public void avaliarMidia(Midia midia, Avaliacao avaliacao) throws midiaJaAvaliadaException {
        if (midia.possuiAvaliacao(this)) {
            throw new midiaJaAvaliadaException("Você já avaliou esta mídia anteriormente.");
        }

        try {
            midia.adicionarAvaliacao(this, avaliacao);
        } catch (usuarioNaoPodeComentarException e) {
            e.printStackTrace();
        }
        adicionarAvaliacao(midia, avaliacao);
    }
}
