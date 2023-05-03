import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PlataformaStreaming{
	private String nome;
	private HashMap<String, Midia> midia;
	private HashMap<String, Cliente> clientes;
	private Cliente ClienteAtual;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public HashMap<String, Midia> getMidia() {
		return midia;
	}

	public void setSeries(HashMap<String, Midia> midia) {
		this.midia = midia;
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
	
	
	 /**
     * Verifica com base na hash de clientes os usuários presentes e aquele que possui nome de usuario e senha iguais aos passados como parâmetro é setado como cliente atual 
     * @param nomeUsuario indica o nome do usuario
     * @param senha indica a senha do usuario
     */
	public Cliente login(String nomeUsuario, String senha) {
		for (Cliente c : clientes.values()) {
			if (c.getNomeDeUsuario().equals(nomeUsuario) && c.getSenha().equals(senha)) {
				
				setClienteAtual(c);
				return c;
			}
		}
		
		return null;
		
	}
	
	/**
     * Adiciona uma serie na lista de series  
     * @param serie
     */
	public void adicionarMidia(Midia midia) {
		((Map<String, Midia>) midia).put(midia.getNome(), midia);
	}
	
	/**
     * Adiciona o cliente na lista de clientes   
     * @param cliente
     */
	public void adicionarCliente(Cliente cliente) {
		clientes.put(cliente.getNomeDeUsuario(), cliente);
	}
	
	/**
     * Filtra a lista de series por genero  
     * @param genero indica o genero a ser filtrado 
     * @return listaFiltrada retorna uma nova lista com as series do genero indicado
     */
	public Lista<Midia> filtrarPorGenero(String genero) {
		Lista<Midia> listaFiltrada = new Lista<Midia>();
		for (Midia m : midia.values()) {
			if (m.getGenero().equals(genero)) {
				listaFiltrada.add(m);
			}
		}

		return listaFiltrada;
	}
	 
		
	/**
     * Filtra a lista de series por idioma  
     * @param idioma indica o idioma a ser filtrado 
     * @return listaFiltrada retorna uma nova lista com as series do idioma indicado
     */
	 public Lista<Midia> filtrarPorIdioma(String idioma) {
		 Lista<Midia> lista = new Lista<Midia>();
		 for (Midia m : midia.values()) {
			 if (m.getIdioma().equals(idioma)) {
				 lista.add(m);
			 }
		 }
		 
		 return lista;
		 
	 }
	 
		/**
     * Filtra a lista de series por quantidade de episodios   
     * @param quantEpisodios indica a quantidade a ser filtrada 
     * @return listaFiltrada retorna uma nova lista com as series da quantidade indicada
     */
		public Lista<Midia> filtrarPorQtdEpisodios(int quantEpisodios) {
			Lista<Midia> listaFiltrada = new Lista<Midia>();
			for (Midia m : midia.values()) {
				if (((Serie) m).getQuantidadeEpisodios() == quantEpisodios) {
					listaFiltrada.add(m);
				}
			}

			return listaFiltrada;
			
		}

		//incrementa a audiencia da serie toda vez que ela for assistida por algum Cliente.
		public void registrarAudiencia(Serie serie) {
			serie.setAudiencia(serie.getAudiencia() + 1);
		}
		
	// /**
	//  * 
	//  * @throws IOException
	//  */
	// public String[] carregaArquivo(String caminhoArquivo) throws IOException {
	//     String csvFilePath = caminhoArquivo;
	//     String linha = "";
	//     String regex = ",";
	//     String[] campos = null;

	//     try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
	//         linha = br.readLine();
	//         if (linha != null) {
	//             campos = linha.split(regex);
	//         }
	//     } catch (IOException e) {
	//         System.out.println("Ocorreu um erro no arquivo");
	//     }

	//     return campos;
	// }

	public void carregaEspectador(String linha) {
		String regex = ",";
		String[] campos = null;

		if (linha != null) {
			campos = linha.split(regex);
			String login = campos[0];
			clientes.get(login);
		}
	}

	public void carregaAudiencia(String linha) {
		String regex = ",";
		String[] campos = null;

		if (linha != null) {
			campos = linha.split(regex);
			String idSerie = campos[2];
			String login = campos[0];
			midia.get(idSerie);
		}
	}

	public void colocaLista() {

	}

}
