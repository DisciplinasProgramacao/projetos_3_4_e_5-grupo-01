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
	public void adicionarSerie(Serie serie) {
		series.put(serie.getNome(), serie);
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
	public Lista<Serie> filtrarPorGenero(String genero) {
		Lista<Serie> listaFiltrada = new Lista<Serie>();
		for (Serie s : series.values()) {
			if (s.getGenero().equals(genero)) {
				listaFiltrada.add(s);
			}
		}

		return listaFiltrada;
	}
	 
		
	/**
     * Filtra a lista de series por idioma  
     * @param idioma indica o idioma a ser filtrado 
     * @return listaFiltrada retorna uma nova lista com as series do idioma indicado
     */
	 public Lista<Serie> filtrarPorIdioma(String idioma) {
		 Lista<Serie> lista = new Lista();
		 for (Serie s : series.values()) {
			 if (s.getIdioma().equals(idioma)) {
				 lista.add(s);
			 }
		 }
		 
		 return lista;
		 
	 }
	 
		/* 
		 * @param quantEpisodios 
		 * @retorn listaFiltrada */
		public Lista<Serie> filtrarPorQtdEpisodios(int quantEpisodios) {
			Lista<Serie> listaFiltrada = new Lista<Serie>();
			for (Serie s : series.values()) {
				if (s.getQuantidadeEpisodios() == quantEpisodios) {
					listaFiltrada.add(s);
				}
			}

			return listaFiltrada;
			
		}

		//incrementa a audiencia da serie toda vez que ela for assistida por algum Cliente.
		public void registrarAudiencia(Serie serie) {
			serie.setAudiencia(serie.getAudiencia() + 1);
		}
	/**
	 * 
	 * @throws IOException
	 */
	public void carregaArquivo() throws IOException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Qual o caminho do arquivo CSV");
		String csvFilePath = scan.nextLine();
		String linha = "";
		String regex = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))){
			while ((linha = br.readLine()) != null) {
				String[] campos = linha.split(regex);
			
			} 
		} catch (IOException e) {
			System.out.println("Ocorreu um erro no arquivo");
		}
	}
}
