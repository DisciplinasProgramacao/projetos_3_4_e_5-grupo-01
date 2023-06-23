import excecoes.midiaJaAvaliadaException;
import excecoes.usuarioNaoPodeComentarException;

public class clienteProfissional extends Cliente implements Avalia {

    public clienteProfissional(String nomeDeUsuario, String senha, String login) {
        super(nomeDeUsuario, senha, login);
    }

    /**
     * Avalia a mídias específica, retornando true caso tudo ocorra como o esperado  
     * @param midia a midia avaliada
     * @param avaliacao indica a avaliação feita pelo cliente
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
