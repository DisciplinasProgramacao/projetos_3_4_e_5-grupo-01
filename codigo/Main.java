import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthToggleButtonUI;

class Main {
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
                for (String chave : app.getMidia().keySet()) {
                    Midia instancia = app.getMidia().get(chave);
                    System.out.println(instancia.toString());
                }
                break;
            case 2:
                for (String chave : app.getClientes().keySet()) {
                    Cliente instancia = app.getClientes().get(chave);
                    System.out.println(instancia.toString());
                }
                break;
            case 3:
                System.out.println("Deseja Adicionar um filme ou serie? (1-filme/2-serie)");
                opcao = scanner.nextInt();
                scanner.nextLine();
                if(opcao == 1){
                    System.out.println("Qual é o nome do filme?");
                    String nome = scanner.nextLine();
                    System.out.println("Genero: 1 - romance | 2 - acao | 3 - comedia");
                    String genero = scanner.nextLine();
                    System.out.println("Idiomas: 1 - PT-BR | 2 - PT-PG | 3 - ENG");
                    String idioma = scanner.nextLine();
                    System.out.println("Data de lançamento: dd/mm/yyyy");
                    String data = scanner.nextLine();
                    System.out.println("Duração do filme sem segundos");
                    String duracao = scanner.nextLine();


                    while(app.existeMidia(String.valueOf(id))){
                        id = random.nextInt(10);
                    }

                    app.adicionarMidia(new Filme(nome, Filme.GENEROS[Integer.parseInt(genero)], Filme.IDIOMAS[Integer.parseInt(idioma)], Integer.parseInt(duracao), 0, id, data));

                    System.out.println("Filme adicionado com sucesso");
                }
                else if(opcao ==2){
                    System.out.println("Qual é o nome do série?");
                    String nome = scanner.nextLine();
                    System.out.println("Genero: 1 - romance | 2 - acao | 3 - comedia");
                    String genero = scanner.nextLine();
                    System.out.println("Idiomas: 1 - PT-BR | 2 - PT-PG | 3 - ENG");
                    String idioma = scanner.nextLine();
                    System.out.println("Data de lançamento: dd/mm/yyyy");
                    String data = scanner.nextLine();
                    System.out.println("quantidadeEpisodios");
                    String eps = scanner.nextLine();

                    while(app.existeMidia(String.valueOf(id))){
                        id = random.nextInt(10);
                    }

                    app.adicionarMidia(new Serie(nome, Serie.GENEROS[Integer.parseInt(genero)], Serie.IDIOMAS[Integer.parseInt(idioma)], Integer.parseInt(eps), 0, id, data));

                    System.out.println("Série adicionado com sucesso");
                }
                else{
                    System.out.println("Opção Inválida");
                }
                break;
            case 4:
                scanner.nextLine();
                System.out.println("Qual é o nome do Cliente?");
                String nome = scanner.nextLine();
                System.out.println("Qual é a senha do Cliente?");
                String senha = scanner.nextLine();
                System.out.println("Qual é o login do Cliente?");
                String login = scanner.nextLine();

                app.adicionarCliente(new Cliente(nome, senha, login));

                System.out.println("Cliente Adicionado com sucesso");


                break;
            case 5:


                scanner.nextLine();

                System.out.println("Qual é a senha do Cliente?");
                senha = scanner.nextLine();
                System.out.println("Qual é o login do Cliente?");
                login = scanner.nextLine();

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
                    System.out.println("Login com sucesso");
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
}