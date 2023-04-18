import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	
	/*
	 * Metódo para adicionar o cliente na tabela
	 * 
	 * @param cliente indica o cliente a ser adicionado
	 */
	public void adicionarCliente(Cliente cliente) {
		this.clientes.put(nome, cliente);
	}

	/*
	 * filtra o genero passado por parametro e adiciona na lista filtrada
	 * 
	 * @param genero indica o genero a ser buscado
	 * 
	 * @return Uma lista do tipo Serie com os generos buscados
	 */
	public Lista<Serie> filtrarPorGenero(String genero) {
		Lista<Serie> listaFiltrada = new Lista<Serie>();
		for (Entry<String, Serie> entry : series.entrySet()) {
			Serie s = entry.getValue();
			if (s.getGenero().equals(genero)) {
				listaFiltrada.add(s);
			}
		}

		return listaFiltrada;
	}

}
