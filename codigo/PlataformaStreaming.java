import java.util.HashMap;


public class PlataformaStreaming{
	private String nome;
	private HashMap<String, Midia> midia;
	private HashMap<String, Cliente> clientes;
	private Cliente clienteAtual;


	public PlataformaStreaming(String nome, Cliente clienteAtual) {
		this.nome = nome;
		this.midia = new HashMap<String, Midia>();
		this.clientes = new HashMap<String, Cliente>();
		this.clienteAtual = clienteAtual;
	}

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
		return clienteAtual;
	}
	public void setClienteAtual(Cliente clienteAtual) {
		this.clienteAtual = clienteAtual;
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
		this.midia.put(Integer.toString(midia.getId()), midia);
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
		String regex = ";";
		String[] campos = null;

		if (linha != null) {
			campos = linha.split(regex);
		    String nome = campos[0];
			// System.out.println(nome);
			String login = campos[1];
			String senha = campos[2];

			// Cliente c = clientes.get(login);
			Cliente c = new Cliente(nome, senha, login);

			clientes.put(login, c);
		}
	}

	public void carregaAudiencia(String linha) {
		String regex = ";";
		String[] campos = null;

		if (linha != null) {
			campos = linha.split(regex);
			String login = campos[0];
			// System.out.println(login);
			String jaVisto = campos[1];
			String idMidia = campos[2];
			

			try{
				Midia m = midia.get(idMidia);
				// System.out.println(m.toString());

				if(m != null){
					Cliente c = clientes.get(login);

					if (jaVisto.equals("F")) { //nao assitido
						c.adicionaNaListaParaVer(m);

					} else if (jaVisto.equals("A")) { //ja assistido
						c.adicionaNaListaVistas(m);
						m.registrarAudiencia();
					}	
				}

				return;
				
			} catch (Exception e){
				System.out.println(e);
				return;
			}

			
		}
	}

}
