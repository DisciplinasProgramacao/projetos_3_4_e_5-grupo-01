import excecoes.midiaJaAvaliadaException;
import excecoes.usuarioNaoPodeComentarException;

/**
 * A classe clienteProfissional representa um cliente profissional que herda as características da classe Cliente e implementa a interface Avalia.
 */
public class clienteProfissional extends Cliente implements Avalia {

    /**
     * Constrói um objeto clienteProfissional com o nome de usuário, senha e login especificados.
     *
     * @param nomeDeUsuario o nome de usuário do cliente profissional
     * @param senha a senha do cliente profissional
     * @param login o login do cliente profissional
     */
    public clienteProfissional(String nomeDeUsuario, String senha, String login) {
        super(nomeDeUsuario, senha, login);
    }

    /**
     * Avalia uma mídia específica com a avaliação fornecida pelo cliente profissional.
     *
     * @param midia a mídia a ser avaliada
     * @param avaliacao a avaliação feita pelo cliente profissional
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
