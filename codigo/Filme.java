import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Filme {
	private String nome;
	private String genero;
	private String idioma;
	private int duracaoSeg;
	private int audiencia;
  
	public Filme(String nome, String genero, String idioma, int duracaoSeg, int audiencia) {
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.duracaoSeg = duracaoSeg;
		this.audiencia = audiencia;
	}
  
	public String getNome() {
		return nome;
	}
  
	public void setNome(String nome) {
		this.nome = nome;
	}
  
	public String getGenero() {
		return genero;
	}
  
	public void setGenero(String genero) {
		this.genero = genero;
	}
  
	public String getIdioma() {
		return idioma;
	}
  
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
  
	public int getDuracaoSeg() {
		return duracaoSeg;
	}
  
	public void setDuracaoSeg(int duracaoSeg) {
		this.duracaoSeg = duracaoSeg;
	}
  
	public int getAudiencia() {
		return audiencia;
	}
  
	public void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
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
