import excecoes.midiaJaAvaliadaException;
import excecoes.usuarioNaoPodeComentarException;

/**
 * A classe clienteComum representa um cliente comum que herda as características da classe Cliente e implementa a interface Avalia.
 */
public class clienteComum extends Cliente implements Avalia {

    /**
     * Constrói um objeto clienteComum com o nome de usuário, senha e login especificados.
     *
     * @param nomeDeUsuario o nome de usuário do cliente comum
     * @param senha a senha do cliente comum
     * @param login o login do cliente comum
     */
    public clienteComum(String nomeDeUsuario, String senha, String login) {
        super(nomeDeUsuario, senha, login);
    }

    /**
     * Constrói um objeto clienteComum com base em um clienteEspecialista existente.
     *
     * @param clienteEspecialista o cliente especialista a partir do qual o cliente comum será criado
     */
    public clienteComum(clienteEspecialista clienteEspecialista) {
        super(clienteEspecialista.getNomeDeUsuario(), clienteEspecialista.getSenha(), clienteEspecialista.getLogin());
    }

    /**
     * Avalia uma mídia específica com a avaliação fornecida pelo cliente.
     *
     * @param midia a mídia a ser avaliada
     * @param avaliacao a avaliação feita pelo cliente
     * @throws midiaJaAvaliadaException se o cliente já tiver avaliado a mídia anteriormente
     * @throws usuarioNaoPodeComentarException se o cliente não tiver permissão para comentar na avaliação
     */
    @Override
    public void avaliarMidia(Midia midia, Avaliacao avaliacao) throws midiaJaAvaliadaException, usuarioNaoPodeComentarException {
        if (midia.possuiAvaliacao(this)) {
            throw new midiaJaAvaliadaException("Você já avaliou esta mídia anteriormente.");
        }

        if (avaliacao.getComentario() != null) {
            throw new usuarioNaoPodeComentarException("Esse usuário não pode comentar na avaliação.");
        }
        adicionarAvaliacao(midia, avaliacao);
    }
}
