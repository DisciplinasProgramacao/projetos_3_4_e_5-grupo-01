import java.io.*;
import java.util.Random;
import java.util.Scanner;

import excecoes.ClienteNaoProfissional;

import java.time.LocalDate;
import java.util.Map;


class Main {

    // TODO: atualizar cadastro de midias de lançamento
    // TODO: atualizar clientes profissionais

    // TODO: cliente avalia midia já assistida 

    
public static void main(String[] args) throws FileNotFoundException {


    PlataformaStreaming app = new PlataformaStreaming("Netflix", new Cliente("admin", "123", "admin@admin"));    

    
    System.out.println("Aguarde o carregamente de Arquivos...");
    BufferedReader reader = null;

    //subindo arquivo series
    try {
        reader = new BufferedReader(new FileReader("series.txt"));
        String linha;

        reader.readLine();
        while ((linha = reader.readLine()) != null) {
            // System.out.println(linha);

            app.adicionarMidia(Serie.carregaSerie(linha));
        }

    } catch (IOException e) {
        e.printStackTrace();
    }


    //subindo arquivos filmes
    try {
        reader = new BufferedReader(new FileReader("filmes.txt"));
        String linha;

        reader.readLine();
        while ((linha = reader.readLine()) != null) {
            // System.out.println(linha);

            app.adicionarMidia(Filme.carregaFilme(linha));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    

    //subindo arquivos de clientes
    try {
        reader = new BufferedReader(new FileReader("espectadores.txt"));
        String linha;

        reader.readLine();
        while ((linha = reader.readLine()) != null) {
            // System.out.println(linha);
            
            app.carregaEspectador(linha);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }


    //subindo arquivos de audiencia
    try {
        reader = new BufferedReader(new FileReader("audiencia.txt"));
        String linha;

        reader.readLine();
        while ((linha = reader.readLine()) != null) {
            // System.out.println(linha);

            app.carregaAudiencia(linha);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }



    Scanner scanner = new Scanner(System.in);

    System.out.println("Carregamento Completo.");


    boolean valid = true;
    int id = 0;
    Random random = new Random();
    
    //menu principal da aplicação
    while(valid){
        id++;
        System.out.println("O que deseja fazer a seguir?\n1 - Listar Todas as Mídias Cadastradas\n2 - Listar Todos Espectadores Cadastrados\n3 - Cadastrar Nova Mídia\n4 - Cadastrar Novo Espectador\n5 - Fazer Login \n0 - Encerrar");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                //listar todas midias
                for (String chave : app.getMidia().keySet()) {
                    Midia instancia = app.getMidia().get(chave);
                    System.out.println(instancia.toString());
                }
                break;
            case 2:
                // listar todos clientes
                for (String chave : app.getClientes().keySet()) {
                    Cliente instancia = app.getClientes().get(chave);
                    System.out.println(instancia.toString());
                }
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
                    System.out.println("Genero: 0 - romance | 1 - acao | 2 - comedia");
                    String genero = scanner.nextLine();
                    System.out.println("Idiomas: 0 - PT-BR | 1 - PT-PG | 2 - ENG");
                    String idioma = scanner.nextLine();
                    System.out.println("Data de lançamento: dd/mm/yyyy");
                    String data = scanner.nextLine();
                    System.out.println("Duração do filme sem segundos");
                    String duracao = scanner.nextLine();


                    while(app.existeMidia(String.valueOf(id))){
                        id = random.nextInt(10);
                    }

                    Filme filme = new Filme(nome, Filme.GENEROS[Integer.parseInt(genero)], Filme.IDIOMAS[Integer.parseInt(idioma)], Integer.parseInt(duracao), 0, id, data);

                    if(lancamento.equals("1")){
                        filme.tornarLancamento();
                    }

                    app.adicionarMidia(filme);

                    try {
                        // Cria um FileWriter com o modo de append
                        FileWriter fileWriter = new FileWriter("filmes.txt", true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        // Escreve o conteúdo no arquivo
                        bufferedWriter.newLine();
                        bufferedWriter.write( id+";"+nome+";"+data+";"+duracao);

                        // Fecha o BufferedWriter
                        bufferedWriter.close();
                        System.out.println("Filme adicionado com sucesso");
                    } catch (IOException e) {
                        System.out.println("Ocorreu um erro ao adicionar conteúdo ao arquivo: " + e.getMessage());
                    }
                    
                }
                //midia é série
                else if(opcao ==2){
                    System.out.println("Qual é o nome do série?");
                    String nome = scanner.nextLine();
                    System.out.println("Genero: 0 - romance | 1 - acao | 2 - comedia");
                    String genero = scanner.nextLine();
                    System.out.println("Idiomas: 0 - PT-BR | 1 - PT-PG | 2 - ENG");
                    String idioma = scanner.nextLine();
                    System.out.println("Data de lançamento: dd/mm/yyyy");
                    String data = scanner.nextLine();
                    System.out.println("quantidadeEpisodios");
                    String eps = scanner.nextLine();

                    while(app.existeMidia(String.valueOf(id))){
                        id = random.nextInt(10);
                    }

                    Serie serie = new Serie(nome, Serie.GENEROS[Integer.parseInt(genero)], Serie.IDIOMAS[Integer.parseInt(idioma)], Integer.parseInt(eps), 0, id, data);

                    if(lancamento.equals("1")){
                        serie.tornarLancamento();
                    }

                    app.adicionarMidia(serie);

                    try {
                        // Cria um FileWriter com o modo de append
                        FileWriter fileWriter = new FileWriter("series.txt", true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        // Escreve o conteúdo no arquivo
                        bufferedWriter.newLine();
                        bufferedWriter.write( id+";"+nome+";"+data);

                        // Fecha o BufferedWriter
                        bufferedWriter.close();
                        System.out.println("Série adicionado com sucesso");
                    } catch (IOException e) {
                        System.out.println("Ocorreu um erro ao adicionar conteúdo ao arquivo: " + e.getMessage());
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
                

                //add midias na lista para ver do cliente
                Cliente cliente = new Cliente(nome, senha, login);

                if(profissional.equals("1")){
                    cliente.tornarProfissional();
                }

                app.getMidia().forEach((key, value) -> {
                    cliente.adicionaNaListaParaVer(value);
                    // System.out.println(value.getNome());
                });


                app.adicionarCliente(cliente);

                try {
                    // Cria um FileWriter com o modo de append
                    FileWriter fileWriter = new FileWriter("espectadores.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    // Escreve o conteúdo no arquivo
                    bufferedWriter.newLine();
                    bufferedWriter.write(nome+";"+login+";"+senha);

                    // Fecha o BufferedWriter
                    bufferedWriter.close();
                    System.out.println("Cliente Adicionado com sucesso");
                } catch (IOException e) {
                    System.out.println("Ocorreu um erro ao adicionar conteúdo ao arquivo: " + e.getMessage());
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
                        perfil(app);
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
                    String gen = Filme.GENEROS[genero];
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
                    Lista<Midia> resultado = user.filtrarPorGenero(Filme.GENEROS[idioma]);

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
                        
                        m.avaliar(user, avaliacao);
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

}