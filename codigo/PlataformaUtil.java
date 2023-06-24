import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PlataformaUtil {
    public static void listarMidias(PlataformaStreaming app){
        for (String chave : app.getMidia().keySet()) {
            Midia instancia = app.getMidia().get(chave);
            System.out.println(instancia.toString());
        }
    }

    public static void listarClientes(PlataformaStreaming app){
        for (String chave : app.getClientes().keySet()) {
            Cliente instancia = app.getClientes().get(chave);
            System.out.println(instancia.toString());
        }
    }

    public static void addFilme(PlataformaStreaming app, String nome, String genero, String idioma, String duracao, String data, String lancamento){

        Random random = new Random();
        int id = 0;

        while(app.existeMidia(String.valueOf(id))){
            id = random.nextInt(10);
        }

        Generos generoSelecionado = Generos.valueOf(genero.toUpperCase());
        Idiomas idiomaSelecionado = Idiomas.valueOf(idioma.toUpperCase());

        Filme filme = new Filme(nome,
                                generoSelecionado, 
                                idiomaSelecionado, 
                                Integer.parseInt(duracao), 
                                0, 
                                id, 
                                data
        );

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

    public static void addSerie(PlataformaStreaming app, String nome, String genero, String idioma, String eps, String data, String lancamento){
        Random random = new Random();
        int id = 0;

        while(app.existeMidia(String.valueOf(id))){
            id = random.nextInt(10);
        }

        Generos generoSelecionado = Generos.valueOf(genero.toUpperCase());
        Idiomas idiomaSelecionado = Idiomas.valueOf(idioma.toUpperCase());


        Serie serie = new Serie(nome, generoSelecionado, idiomaSelecionado, Integer.parseInt(eps), 0, id, data);

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


    public static void cadastrarCliente(PlataformaStreaming app, String nome, String senha, String login, String profissional){
        Cliente user;

        //add midias na lista para ver do cliente
        if(profissional.equals("1")){
            user = new clienteProfissional(nome, senha, login);
        }
        else{
            user = new clienteComum(nome, senha, login);
        }
        

        app.getMidia().forEach((key, value) -> {
            user.adicionaNaListaParaVer(value);
            // System.out.println(value.getNome());
        });

        app.adicionarCliente(user);

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
    }
}
