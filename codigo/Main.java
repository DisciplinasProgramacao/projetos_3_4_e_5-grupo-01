import java.io.*;
import java.util.Scanner;


class Main {
    //java -Xmx8g MeuApp

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
<<<<<<< HEAD
                    System.out.println("Genero (Não utilize acentos nem careacteres especiais): ACAO,\r\n" + //
                            "    ANIME,\r\n" + //
                            "    AVENTURA,\r\n" + //
                            "    COMEDIA,\r\n" + //
                            "    DOCUMENTARIO,\r\n" + //
                            "    DRAMA,\r\n" + //
                            "    POLICIAL,\r\n" + //
                            "    ROMANCE,\r\n" + //
                            "    SUSPENSE");
=======
                    System.out.println("Genero: 0 - acao | 1 - anime | 2 - aventura | 3 - comédia | 4 - documentario | 5 - drama | 6 - policial | 7 - romance | 8 - romance | 9 - suspense");
>>>>>>> f9e6bc3939292e9206e01f2444c944043e076fae
                    String genero = scanner.nextLine();
                    System.out.println("Idiomas:\n     PTBR,\r\n" + //
                            "    PTPG,\r\n" + //
                            "    ENG;");
                    String idioma = scanner.nextLine();
                    System.out.println("Data de lançamento: dd/mm/yyyy");
                    String data = scanner.nextLine();
                    System.out.println("Duração do filme sem segundos");
                    String duracao = scanner.nextLine();

<<<<<<< HEAD
=======

                    while(app.existeMidia(String.valueOf(id))){
                        id = random.nextInt(10);
                    }

                    Filme filme = new Filme(nome, Generos.getByIndex(Integer.parseInt(genero)), Idiomas.getByIndex(Integer.parseInt(idioma)), Integer.parseInt(duracao), 0, id, data);

                    if(lancamento.equals("1")){
                        filme.tornarLancamento();
                    }

                    app.adicionarMidia(filme);

>>>>>>> f9e6bc3939292e9206e01f2444c944043e076fae
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
<<<<<<< HEAD
                    System.out.println("Genero (Não utilize acentos nem careacteres especiais): ACAO,\r\n" + //
                            "    ANIME,\r\n" + //
                            "    AVENTURA,\r\n" + //
                            "    COMEDIA,\r\n" + //
                            "    DOCUMENTARIO,\r\n" + //
                            "    DRAMA,\r\n" + //
                            "    POLICIAL,\r\n" + //
                            "    ROMANCE,\r\n" + //
                            "    SUSPENSE");
=======
                    System.out.println("Genero: 0 - acao | 1 - anime | 2 - aventura | 3 - comedia | 4 - documentario | 5 - drama | 6 - policial | 7 - romance | 8 - romance | 9 - suspense");
>>>>>>> f9e6bc3939292e9206e01f2444c944043e076fae
                    String genero = scanner.nextLine();
                    System.out.println("Idiomas:\n     PTBR,\r\n" + //
                            "    PTPG,\r\n" + //
                            "    ENG;");
                    String idioma = scanner.nextLine();
                    System.out.println("Data de lançamento: dd/mm/yyyy");
                    String data = scanner.nextLine();
                    System.out.println("quantidadeEpisodios");
                    String eps = scanner.nextLine();

<<<<<<< HEAD
=======
                    while(app.existeMidia(String.valueOf(id))){
                        id = random.nextInt(10);
                    }

                    Serie serie = new Serie(nome, Generos.getByIndex(Integer.parseInt(genero)), Idiomas.getByIndex(Integer.parseInt(idioma)), Integer.parseInt(eps), 0, id, data);

                    if(lancamento.equals("1")){
                        serie.tornarLancamento();
                    }

                    app.adicionarMidia(serie);

>>>>>>> f9e6bc3939292e9206e01f2444c944043e076fae
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

<<<<<<< HEAD
// public static void perfil(PlataformaStreaming app) throws Exception{
    
// }
=======
public static void perfil(PlataformaStreaming app) throws Exception{
    Scanner scanner = new Scanner(System.in);
    Cliente user = app.getClienteAtual();

    while(true){
        System.out.println("Qual operação deseja fazer?\n1 - Lista de Para ver\n2 - Lista de já assistidos\n3 - Filtrar por Quantidade de Epsodios\n4 - Filtrar Por Gênero\n5 - Filtrar por Idioma\n6 - Assistir Alguma Midia\n7 - Avaliar Mídia\n8 - Minhas Avaliações\n0 - Logout");
        int opt = scanner.nextInt();

        if(opt == 1){

            Midia[] arr = new Midia[user.getListaParaVer().size()];
            arr = user.getListaParaVer().allElements(arr);
            System.out.println(arr.length);

            for(Midia m : arr){
                System.out.println(m.toString() + "\n");
            }
            
        }
        else if(opt == 2){

            for (Map.Entry<Midia, LocalDate> m : user.getListaJaVista().entrySet()) {
                Midia mJaAssistida = m.getKey();
                // LocalDate diaDaView = m.getValue();
                System.out.println(mJaAssistida.toString() + "\n");
            }
            
        }
        else if(opt == 3){
            //filtragem por quantidade de ep
            System.out.println("Digite a quantidade de ep que deseja buscar:");
            int qtdEp = scanner.nextInt();

            Lista<Midia> resultado = app.filtrarPorQtdEpisodios(qtdEp);

            Midia[] arr = new Midia[user.getListaParaVer().size()];
            arr = resultado.allElements(arr);

            if(arr == null){
                System.out.println("Nenhuma Mídia foi encontrada");
            }
            else{
                System.out.println(arr.length);

                for(Midia m : arr){
                    if(m != null){
                        System.out.println(m.toString() + "\n");
                    }
                    
                }
            }

        }
        else if(opt == 4){
            //filtragem por genero
            System.out.println("1 - Comedia\n2 - Romance\n3 - Ação");
            try {
                int genero = scanner.nextInt();
                if(genero == 1 || genero == 2 || genero == 3){
                    Generos gen = Generos.getByIndex(genero);
                    Lista<Midia> resultado = user.filtrarPorGenero(gen);

                    Midia[] arr = new Midia[user.getListaParaVer().size()];
                    arr = resultado.allElements(arr);
        
                    if(arr == null){
                        System.out.println("Nenhuma Mídia foi encontrada");
                    }
                    else{
                        System.out.println(arr.length);
        
                        for(Midia m : arr){
                            System.out.println(m.toString() + "\n");
                        }
                    }
                }
                else{
                    System.out.println("Genero Inválido");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Genero Inválido");
            }
        
        }
        else if(opt == 5){
            //filtragem por idioma
            System.out.println("1 - PT-BR\n2 - PT-PG\n3 - ENG");
            try {
                int idioma = scanner.nextInt();
                if(idioma == 1 || idioma == 2 || idioma == 3){
                    Lista<Midia> resultado = user.filtrarPorIdioma(Idiomas.getByIndex(idioma));

                    Midia[] arr = new Midia[user.getListaParaVer().size()];
                    arr = resultado.allElements(arr);
        
                    if(arr == null){
                        System.out.println("Nenhuma Mídia foi encontrada");
                    }
                    else{
                        System.out.println(arr.length);
        
                        for(Midia m : arr){
                            System.out.println(m.toString() + "\n");
                        }
                    }
                }
                else{
                    System.out.println("Idioma Inválido");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Idioma Inválido" + e);
            }
        }
        else if(opt == 6){
            System.out.println("Digite o ID da mídia que deseja assistir");
            
            try {
                scanner.nextLine();
                String id = scanner.nextLine();
                Midia m = app.getMidiaEspecifica(id);

                if(m != null){
                    System.out.println("Audiência registrada");
                    user.registrarAudiencia(m);
                }
                else{
                    System.out.println("Essa mídia não foi encontrada");
                }
            }
            catch(ClienteNaoProfissional e){
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Não foi possível assistir essa mídia.");
                System.out.println(e);
            }
        }
        else if(opt == 7){
            System.out.println("Digite o ID da mídia que deseja avaliar (Você precisa ter assistido ela antes):");

            try {
                scanner.nextLine();
                String id = scanner.nextLine();

                Midia m = app.getMidiaEspecifica(id);

                if(m != null){
                    
                    LocalDate diaAssistido = user.jaAssistiu(m);
                    if(diaAssistido != null){
                        float nota = -1;
                        while(true){
                            System.out.println("Qual nota você deseja dar? 1 - 5");
                            try {
                                nota = scanner.nextFloat();
                            } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("Valor inválido");
                            }
                            

                            if(nota >= 0 && nota <= 5){
                                break;
                            }
                            else{
                                System.out.println("Valor inválido");
                            }
                        }

                        System.out.println("Deixe um comentário, caso contrário deixe em branco.");
                        scanner.nextLine();
                        String desc = scanner.nextLine();

                        LocalDate diaAtual = LocalDate.now();
                        Avaliacao avaliacao = new Avaliacao(nota, desc, diaAtual.toString());
                        
                        clienteProfissional.avaliar(user, avaliacao);
                        System.out.println("Avaliação feita com sucesso.");

                        try {
                            FileWriter fileWriter = new FileWriter("avaliacoes.txt", true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
                            bufferedWriter.newLine();
                            bufferedWriter.write(user.getLogin()+";"+m.getId()+";"+nota+";"+desc+";"+diaAtual.toString());
        
                            bufferedWriter.close();
                        } catch (IOException e) {
                            System.out.println("Ocorreu um erro ao adicionar conteúdo ao arquivo: " + e.getMessage());
                        }
                    }
                    else{
                        System.out.println("Você não assistiu ainda essa mídia, tente assisti-lá para depois fazer sua avaliação");
                    }
                }
                else{
                    System.out.println("Essa mídia não foi encontrada");
                }
            } catch (Exception e) {   
                System.out.println(e);
            }
        }
        else if(opt == 8){
            //minhas avalicações
            try {
                user.getListaJaVista().forEach((key, value) -> {
                    key.getNotas().forEach((keyNota, valueNota) -> {
                        if(keyNota.getLogin() == user.getLogin()){
                            System.out.println("Mídia: "+key.getNome());
                            System.out.println(valueNota.toString());
                        }
                    });
                });
            } catch (Exception e) {
                System.out.println("Não foi possível buscar suas avaliações");
                System.out.println(e);
            }
            


        }
        else if(opt == 0){
            break;
        }
        else{
            System.out.println("Opção inválida");
        }
    }

    return;
}
>>>>>>> f9e6bc3939292e9206e01f2444c944043e076fae

}