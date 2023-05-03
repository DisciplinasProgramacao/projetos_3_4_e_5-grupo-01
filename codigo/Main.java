import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Main {
  public static void main(String[] args) {
    File arquivoCSV = new File("caminho/do/arquivo.csv");

        try {
            Scanner leitorCSV = new Scanner(arquivoCSV);

            leitorCSV.useDelimiter(";");

            while (leitorCSV.hasNext()) {
                String linha = leitorCSV.nextLine();
            }

            leitorCSV.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo CSV não encontrado!");
        }
  }
}