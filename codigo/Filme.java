import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Filme extends Midia{
		
	private int duracaoSeg;
  
	public Filme(String nome, String genero, String idioma, int duracaoSeg, int audiencia) {
		super(nome,genero,idioma,audiencia);
		this.duracaoSeg = duracaoSeg;

	}
  
  
	public int getDuracaoSeg() {
		return duracaoSeg;
	}
  
	public void setDuracaoSeg(int duracaoSeg) {
		this.duracaoSeg = duracaoSeg;
	}
  
	
	public void carregaFilme(String caminhoArquivo, Filme filme) throws IOException {
        String linha;
        String regex = ",";
        String[] campos = null;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            linha = br.readLine();
            if (linha != null) {
                campos = linha.split(regex);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro no arquivo");
        }

    }
}
