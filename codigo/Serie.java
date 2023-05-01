import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Serie {
	private static final String[] GENEROS = {"romance", "acao", "comedia"};
	private String nome;
	private String genero;
	private String idioma;
	private int quantidadeEpisodios;
	private int audiencia;
  
	public Serie(String nome, String genero, String idioma, int quantidadeEpisodios, int audiencia) {
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.quantidadeEpisodios = quantidadeEpisodios;
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
  
	public int getQuantidadeEpisodios() {
		return quantidadeEpisodios;
	}
  
	public void setQuantidadeEpisodios(int quantidadeEpisodios) {
		this.quantidadeEpisodios = quantidadeEpisodios;
	}
  
	public int getAudiencia() {
		return audiencia;
	}
  
	public void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
	}
  
	public static String[] getGeneros() {
		return GENEROS;
	}

  //incrementa a audiencia da serie toda vez que ela for assistida por algum Cliente.
	public void registrarAudiencia(){
    
    setAudiencia(this.audiencia + 1);
  
  }
  public void carregaArquivo(String caminhoArquivo, Serie serie) throws IOException {
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
