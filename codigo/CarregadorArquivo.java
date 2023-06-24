import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CarregadorArquivo {
    public static void carregarArquivos(PlataformaStreaming app){
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

    }
}
