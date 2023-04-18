import java.util.HashMap;

public class PlataformaStreaming{
	private String nome;
	private HashMap<String,Serie> series;
	private HashMap<String,Cliente> clientes;
	private Cliente ClienteAtual;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public HashMap<String, Serie> getSeries() {
		return series;
	}
	public void setSeries(HashMap<String, Serie> series) {
		this.series = series;
	}
	public HashMap<String, Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(HashMap<String, Cliente> clientes) {
		this.clientes = clientes;
	}
	public Cliente getClienteAtual() {
		return ClienteAtual;
	}
	public void setClienteAtual(Cliente clienteAtual) {
		ClienteAtual = clienteAtual;
	}

}
