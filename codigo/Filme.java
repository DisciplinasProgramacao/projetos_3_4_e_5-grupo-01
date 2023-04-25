public class Filme {
	private String nome;
	private int dataLancamento;
	private int duracaoSeg;
	private int idFilme;
  
	public Filme(String nome, int duracaoSeg, int idFilme, int dataLancamento) {
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.duracaoSeg = duracaoSeg;
		this.idFilme = idFilme;
	}
  
	public String getNome() {
		return nome;
	}
  
	public void setNome(String nome) {
		this.nome = nome;
	}
  
	public int getDataLancamento() {
		return dataLancamento;
	}
  
	public void setDataLancamento(int dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
  
	public int duracaoSeg() {
		return duracaoSeg;
	}
  
	public void setDuracaoSeg(int duracaoSeg) {
		this.duracaoSeg = duracaoSeg;
	}
  
	public int getIdFilme() {
		return idFilme;
	}
  
	public void setAudiencia(int idFilme) {
		this.idFilme = idFilme;
	}
	
}
