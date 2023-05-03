import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Main {
public static void main(String[] args) {


    PlataformaStreaming app = new PlataformaStreaming();

    File arquivoSerie = new File("../arquivos/POO_Filmes.csv");
    File arquivoFilme = new File("../arquivos/POO_Series.csv");

    //System.out.println(arquivoFilme);
        //subindo arquivos de filme e series
    try{        
        Scanner leitorCSV = new Scanner(arquivoSerie);
        leitorCSV.useDelimiter(";");

        while (leitorCSV.hasNext()) {
            String linha = leitorCSV.nextLine();

            app.adicionarMidia(Serie.carregaSerie(linha));
        }
        leitorCSV.close();

        leitorCSV = new Scanner(arquivoFilme);

        while (leitorCSV.hasNext()) {
            String linha = leitorCSV.nextLine();

            app.adicionarMidia(Filme.carregaFilme(linha));
        }

        leitorCSV.close();

        
    } catch (FileNotFoundException e) {
        System.out.println("Arquivo CSV não encontrado!");
    }


    //espectadores
    File arquivoCSV = new File("../arquivos/POO_Espectadores.csv");
    try {
        Scanner leitorCSV = new Scanner(arquivoCSV);

        leitorCSV.useDelimiter(";");

        while (leitorCSV.hasNext()) {
            String linha = leitorCSV.nextLine();

            app.carregaEspectador(linha);

        }

        leitorCSV.close();

    } catch (FileNotFoundException e) {
        System.out.println("Arquivo CSV não encontrado!");
    }


        //
}
}