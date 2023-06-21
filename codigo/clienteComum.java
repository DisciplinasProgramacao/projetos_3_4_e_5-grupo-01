import excecoes.midiaJaAvaliadaException;
import excecoes.usuarioNaoPodeComentarException;

public class clienteComum extends Cliente implements Avalia {

    public clienteComum(String nomeDeUsuario, String senha, String login) {
        super(nomeDeUsuario, senha, login);
    }

    public clienteComum(clienteEspecialista clienteEspecialista) {
        super(clienteEspecialista.getNomeDeUsuario(), clienteEspecialista.getSenha(), clienteEspecialista.getLogin());
    }

    /**
     * Avalia a mídias específica, retornando true caso tudo ocorra como o esperado  
     * @param midia a midia avaliada
     * @param avaliacao indica a avaliação feita pelo cliente
     */
    @Override
	public void avaliarMidia(Midia midia, Avaliacao avaliacao) throws midiaJaAvaliadaException,usuarioNaoPodeComentarException {
        if (midia.possuiAvaliacao(this)) {
            throw new midiaJaAvaliadaException("Você já avaliou esta mídia anteriormente.");
        }

        if(avaliacao.getComentario() != null){
            throw new usuarioNaoPodeComentarException("Esse usuário não pode comentar na avaliação.");
        }
        adicionarAvaliacao(midia, avaliacao.getNota());
    }
    
}
