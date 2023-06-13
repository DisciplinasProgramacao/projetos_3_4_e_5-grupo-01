package excecoes;

public class ClienteNaoProfissional extends Exception{
    public ClienteNaoProfissional(){
        super("Cliente nao pode assistir nenhum lançamento, pois não possui o perfil profissional");
    }
}
