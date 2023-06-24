import java.io.*;
import java.util.Scanner;


class Main {
    //java -Xmx8g s

    // TODO: atualizar cadastro de midias de lançamento
    // TODO: atualizar clientes profissionais

    // TODO: cliente avalia midia já assistida 

    
public static void main(String[] args) throws FileNotFoundException {


    PlataformaStreaming app = new PlataformaStreaming("Netflix", new clienteComum("admin", "123", "admin@admin"));    

    
    try {

        //carregamento de arquivos
        CarregadorArquivo.carregarArquivos(app);
        System.out.println("Carregamento Completo.");

    } catch (Exception e) {
        System.out.println("Houve um erro no carregamento dos arquivos");
        System.out.println(e.getStackTrace());
    }

    
    Scanner scanner = new Scanner(System.in);


    boolean valid = true;
    
    //menu principal da aplicação
    while(valid){
        System.out.println("O que deseja fazer a seguir?\n1 - Listar Todas as Mídias Cadastradas\n2 - Listar Todos Espectadores Cadastrados\n3 - Cadastrar Nova Mídia\n4 - Cadastrar Novo Espectador\n5 - Fazer Login \n0 - Encerrar");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                //listar todas midias
                PlataformaUtil.listarMidias(app);
                break;
            case 2:
                // listar todos clientes
                PlataformaUtil.listarClientes(app);
                break;
            case 3:
                //adicionar nova midia
                System.out.println("Deseja Adicionar um filme ou serie? (1-filme/2-serie)");
                opcao = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Essa mídia é um lançamento? 1 - sim | 2 - não");
                String lancamento = scanner.nextLine();

                if(opcao == 1){
                    System.out.println("Qual é o nome do filme?");
                    String nome = scanner.nextLine();
                    System.out.println("Genero (Não utilize acentos nem careacteres especiais): ACAO,\r\n" + //
                            "    ANIME,\r\n" + //
                            "    AVENTURA,\r\n" + //
                            "    COMEDIA,\r\n" + //
                            "    DOCUMENTARIO,\r\n" + //
                            "    DRAMA,\r\n" + //
                            "    POLICIAL,\r\n" + //
                            "    ROMANCE,\r\n" + //
                            "    SUSPENSE");
                    String genero = scanner.nextLine();
                    System.out.println("Idiomas:\n     PTBR,\r\n" + //
                            "    PTPG,\r\n" + //
                            "    ENG;");
                    String idioma = scanner.nextLine();
                    System.out.println("Data de lançamento: dd/mm/yyyy");
                    String data = scanner.nextLine();
                    System.out.println("Duração do filme sem segundos");
                    String duracao = scanner.nextLine();

                    try {
                        PlataformaUtil.addFilme(app, nome, genero, idioma, duracao, data, lancamento);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    
                }
                //midia é série
                else if(opcao ==2){
                    System.out.println("Qual é o nome do série?");
                    String nome = scanner.nextLine();
                    System.out.println("Genero (Não utilize acentos nem careacteres especiais): ACAO,\r\n" + //
                            "    ANIME,\r\n" + //
                            "    AVENTURA,\r\n" + //
                            "    COMEDIA,\r\n" + //
                            "    DOCUMENTARIO,\r\n" + //
                            "    DRAMA,\r\n" + //
                            "    POLICIAL,\r\n" + //
                            "    ROMANCE,\r\n" + //
                            "    SUSPENSE");
                    String genero = scanner.nextLine();
                    System.out.println("Idiomas:\n     PTBR,\r\n" + //
                            "    PTPG,\r\n" + //
                            "    ENG;");
                    String idioma = scanner.nextLine();
                    System.out.println("Data de lançamento: dd/mm/yyyy");
                    String data = scanner.nextLine();
                    System.out.println("quantidadeEpisodios");
                    String eps = scanner.nextLine();

                    try {
                        PlataformaUtil.addSerie(app, nome, genero, idioma, eps, data, lancamento);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                  
                }
                else{
                    System.out.println("Opção Inválida");
                }
                break;
            case 4: 
                //cadastrar novo cliente
                scanner.nextLine();
                System.out.println("Qual é o nome do Cliente?");
                String nome = scanner.nextLine();
                System.out.println("Qual é o login do Cliente?");
                String login = scanner.nextLine();
                System.out.println("Qual é a senha do Cliente?");
                String senha = scanner.nextLine();
                System.out.println("O cliente é um profissional? 1-sim | 2-nao");
                String profissional = scanner.nextLine();
                
                try {
                    PlataformaUtil.cadastrarCliente(app, nome, senha, login, profissional);
                } catch (Exception e) {
                    System.out.println("Não foi possivel cadastrar cliente");
                    System.out.println(e.getStackTrace());
                    // TODO: handle exception
                }

                break;
            case 5:
                //fazer login

                scanner.nextLine();

                System.out.println("Qual é o login do Cliente?");
                login = scanner.nextLine();
                System.out.println("Qual é a senha do Cliente?");
                senha = scanner.nextLine();

                Boolean validacao = app.login(login, senha);

                while(!validacao){
                    System.out.println("Usuário Não encontrado");
                    System.out.println("Qual é a senha do Cliente?");
                    senha = scanner.nextLine();
                    System.out.println("Qual é o login do Cliente?");
                    login = scanner.nextLine();

                    validacao = app.login(login, senha);
                }

                if(validacao){
                    System.out.println("Login com sucesso\nSeja bem vindo(a) " + app.getClienteAtual().getNomeDeUsuario());

                    try {
                        ClienteUtil.perfil(app);
                    } catch (Exception e) {
                        System.out.println("Houve um erro em sua conta, tente novamente mais tarde, você foi desconectado");
                        app.setClienteAtual(null);
                        System.out.println(e);
                    }

                    System.out.println("Logout feito com sucesso");
                }
                else{
                    System.out.println("Houve um erro no login");
                }
                
                break;
            case 0:
                valid = false;
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}

// public static void perfil(PlataformaStreaming app) throws Exception{
    
// }

}