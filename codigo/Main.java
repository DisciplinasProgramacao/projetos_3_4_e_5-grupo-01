import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

class Main {
public static void main(String[] args) throws FileNotFoundException {


    PlataformaStreaming app = new PlataformaStreaming("Netflix", new Cliente("admin", "123", "admin@admin"));    

    
    System.out.println("Aguarde o carregamente de Arquivos, pode demorar um pouco...");

    //subindo arquivo series
    BufferedReader reader = null;
    // System.out.println("Series-------------------------------");
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
    // System.out.println("Filmes--------------------------------");
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
    

    // System.out.println("Espectadores-------------------------------");
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


    // System.out.println("Audiencia-------------------------------");
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
    while(valid){
        id++;
        System.out.println("O que deseja fazer a seguir?\n1 - Listar Todas as Mídias Cadastradas\n2 - Listar Todos Espectadores Cadastrados\n3 - Cadastrar Nova Mídia\n4 - Cadastrar Novo Espectador\n0 - Encerrar");

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

                    app.adicionarMidia(new Filme(nome, Filme.GENEROS[Integer.parseInt(genero)], Filme.IDIOMAS[Integer.parseInt(idioma)], Integer.parseInt(duracao), 0, id, data));

                    System.out.println("Filme adicionado com sucesso");
                }
                else if(opcao ==2){
                    System.out.println("Não implementado Ainda");
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
            case 0: 
                valid = false;
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    
    }

 


    // try{        
    //     Scanner leitorCSV = new Scanner(arquivoSerie);
    //     leitorCSV.useDelimiter(";");

    //     while (leitorCSV.hasNext()) {
    //         String linha = leitorCSV.nextLine();

    //         app.adicionarMidia(Serie.carregaSerie(linha));
    //     }
    //     leitorCSV.close();

    //     leitorCSV = new Scanner(arquivoFilme);

    //     while (leitorCSV.hasNext()) {
    //         String linha = leitorCSV.nextLine();

    //         app.adicionarMidia(Filme.carregaFilme(linha));
    //     }

    //     leitorCSV.close();

        
    // } catch (FileNotFoundException e) {
    //     System.out.println("Arquivo CSV não encontrado!");
    // }


    // //espectadores
    // File arquivoCSV = new File("../arquivos/POO_Espectadores.csv");
    // try {
    //     Scanner leitorCSV = new Scanner(arquivoCSV);

    //     leitorCSV.useDelimiter(";");

    //     while (leitorCSV.hasNext()) {
    //         String linha = leitorCSV.nextLine();

    //         app.carregaEspectador(linha);

    //     }

    //     leitorCSV.close();

    // } catch (FileNotFoundException e) {
    //     System.out.println("Arquivo CSV não encontrado!");
    // }


        //
}
}