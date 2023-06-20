import excecoes.midiaJaAvaliadaException;

public class clienteEspecialista extends Cliente implements Avalia{

    public clienteEspecialista(String nomeDeUsuario, String senha, String login) {
        super(nomeDeUsuario, senha, login);
        //TODO Auto-generated constructor stub
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


        midia.adicionarAvaliacao(this, avaliacao);
        adicionarAvaliacao(midia, avaliacao.getNota());
    }
}