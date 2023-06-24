import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.*;
import java.util.Map.Entry;

/**
 * A classe PlataformaStreaming representa uma plataforma de streaming que oferece um catálogo de mídias para os clientes.
 * Cada plataforma possui um nome, um conjunto de mídias disponíveis, um conjunto de clientes registrados e o cliente atualmente logado.
 * A plataforma também pode armazenar uma lista de trailers.
 */
public class PlataformaStreaming {
    private String nome;
    private HashMap<String, Midia> midia;
    private HashMap<String, Cliente> clientes;
    private Cliente clienteAtual;
    private Lista trailers = new Lista();

    /**
     * Construtor da classe PlataformaStreaming que recebe o nome da plataforma e o cliente atualmente logado.
     * Inicializa os atributos nome, midia, clientes e clienteAtual.
     *
     * @param nome          O nome da plataforma de streaming.
     * @param clienteAtual  O cliente atualmente logado na plataforma.
     */
    public PlataformaStreaming(String nome, Cliente clienteAtual) {
        this.nome = nome;
        this.midia = new HashMap<String, Midia>();
        this.clientes = new HashMap<String, Cliente>();
        this.clienteAtual = clienteAtual;
    }

    /**
     * Construtor vazio da classe PlataformaStreaming.
     * Inicializa os atributos midia e clientes como HashMap vazios.
     */
    public PlataformaStreaming() {
        this.midia = new HashMap<String, Midia>();
        this.clientes = new HashMap<String, Cliente>();
    }

    /**
     * Obtém o nome da plataforma de streaming.
     *
     * @return O nome da plataforma.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da plataforma de streaming.
     *
     * @param nome O nome da plataforma.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o conjunto de mídias disponíveis na plataforma.
     *
     * @return O mapa de mídias disponíveis.
     */
    public HashMap<String, Midia> getMidia() {
        return midia;
    }

    /**
     * Verifica se uma mídia com a chave especificada existe no conjunto de mídias disponíveis.
     *
     * @param key A chave da mídia.
     * @return true se a mídia existe, false caso contrário.
     */
    public Boolean existeMidia(String key) {
        return midia.containsKey(key);
    }

    /**
     * Define o conjunto de mídias disponíveis na plataforma.
     *
     * @param midia O mapa de mídias disponíveis.
     */
    public void setMidia(HashMap<String, Midia> midia) {
        this.midia = midia;
    }

    /**
     * Obtém o conjunto de clientes registrados na plataforma.
     *
     * @return O mapa de clientes registrados.
     */
    public HashMap<String, Cliente> getClientes() {
        return this.clientes;
    }

    /**
     * Define o conjunto de clientes registrados na plataforma.
     *
     * @param clientes O mapa de clientes registrados.
     */
    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Obtém o cliente atualmente logado na plataforma.
     *
     * @return O cliente atualmente logado.
     */
    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    /**
     * Define o cliente atualmente logado na plataforma.
     *
     * @param clienteAtual O cliente atualmente logado.
     */
    public void setClienteAtual(Cliente clienteAtual) {
        this.clienteAtual = clienteAtual;
    }


	/**
	 * Verifica com base na hash de clientes os usuários presentes e aquele que
	 * possui nome de usuario e senha iguais aos passados como parâmetro é setado
	 * como cliente atual
	 * 
	 * @param nomeUsuario indica o nome do usuario
	 * @param senha       indica a senha do usuario
	 */
	public boolean login(String login, String senha) {
		for (Cliente c : clientes.values()) {
			if (c.getLogin().equals(login) && c.getSenha().equals(senha)) {

				setClienteAtual(c);
				return true;
			}
		}

		return false;

	}

	/**
	 * Adiciona uma serie na lista de series
	 * 
	 * @param serie
	 */
	public void adicionarMidia(Midia midia) {
		this.midia.put(Integer.toString(midia.getId()), midia);
	}

	public Midia getMidiaEspecifica(String id) {
		Midia m = this.midia.get(id);
		return m;
	}

	/**
	 * Adiciona o cliente na lista de clientes
	 * 
	 * @param cliente
	 */
	public void adicionarCliente(Cliente cliente) {
		clientes.put(cliente.getNomeDeUsuario(), cliente);
	}

	/**
	 * Filtra a lista de series por genero
	 * 
	 * @param genero indica o genero a ser filtrado
	 * @return listaFiltrada retorna uma nova lista com as series do genero indicado
	 */
	public Lista<Midia> filtrarPorGenero(Generos genero) {
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
	 * 
	 * @param idioma indica o idioma a ser filtrado
	 * @return listaFiltrada retorna uma nova lista com as series do idioma indicado
	 */
	public Lista<Midia> filtrarPorIdioma(Idiomas idioma) {
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
	 * 
	 * @param quantEpisodios indica a quantidade a ser filtrada
	 * @return listaFiltrada retorna uma nova lista com as series da quantidade
	 *         indicada
	 */
	public Lista<Midia> filtrarPorQtdEpisodios(int quantEpisodios) {
		Lista<Midia> listaFiltrada = new Lista<Midia>();
		for (Midia m : midia.values()) {
			if (m instanceof Serie) {
				if (((Serie) m).getQuantidadeEpisodios() == quantEpisodios) {
					listaFiltrada.add(m);
				}
			}
		}

		if (listaFiltrada.size() == 0) {
			return null;
		}

		return listaFiltrada;

	}

	public void carregaEspectador(String linha) {
		String regex = ";";
		String[] campos = null;

		if (linha != null) {
			campos = linha.split(regex);
			String nome = campos[0];
			String login = campos[1];
			String senha = campos[2];

			clienteComum c = new clienteComum(nome, senha, login);

			this.midia.forEach((key, value) -> {
				c.adicionaNaListaParaVer(value);
			});

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

			try {
				Midia m = midia.get(idMidia);
				// System.out.println(m.toString());

				if (m != null) {
					Cliente c = clientes.get(login);
					if (jaVisto.equals("A")) { // ja assistido
						// c.adicionaNaListaVistas(m);
						// m.registrarAudiencia();
						c.getListaParaVer().removeS(m.getNome());
						c.getListaJaVista().put(m, LocalDate.now());
						m.registrarAudiencia();
						// c.registrarAudiencia(m);
					}
				}

				return;
			} catch (Exception e) {
				System.out.println(e);
				return;
			}

		}

	}

	/**
	 * Busca as top10 mídias com melhores avaliações com pelo menos 100 avaliações.
	 * As mídias devem estar em ordem decrescente
	 * 
	 * @return top10 List com as 10 mídias com melhor avaliação em ordem decrescente
	 */
	public List<Midia> top10MidiasMelhorAvaliacao() {
		List<Midia> midiasMaior100 = new ArrayList<Midia>();
		midiasMaior100 = midia.values().stream()
				.filter(m -> m.getNotas().size() >= 100)
				.collect(Collectors.toList());

		List<Midia> midiasOrdenadas = midia.values().stream()
				.sorted(Comparator.comparing(Midia::calcMedia).reversed())
				.collect(Collectors.toList());

		List<Midia> top10 = midiasOrdenadas.stream()
				.limit(10)
				.collect(Collectors.toList());

		return top10;
	}


	/**
	 * Busca as top10 mídias com melhores avaliações com pelo menos 100 avaliações e as separa por gênero.
	 * As mídias devem estar em ordem decrescente
	 * 
	 * @return top10PorGenero List com as 10 mídias com melhor avaliação em ordem decrescente
	 */
	public List<Midia> top10MidiasMelhorAvaliacaoSeparadaPorGenero() {
    List<Midia> midiasMaior100 = midia.values().stream()
            .filter(m -> m.getNotas().size() >= 100)
            .collect(Collectors.toList());
    Map<Generos, List<Midia>> midiasPorGenero = midiasMaior100.stream()
            .collect(Collectors.groupingBy(Midia::getGenero));

    List<Midia> top10PorGenero = new ArrayList<>();
    midiasPorGenero.forEach((genero, midias) -> {
        List<Midia> midiasOrdenadas = midias.stream()
                .sorted(Comparator.comparing(Midia::calcMedia).reversed())
                .limit(10)
                .collect(Collectors.toList());
        top10PorGenero.addAll(midiasOrdenadas);
    });
    
    return top10PorGenero;
}


	/**
	 * Busca as top10 mídias com mais vizualizaçõescom pelo menos 100 avaliações separadas por gênero. As
	 * mídias devem estar em ordem decrescente
	 * 
	 * @return top10 List com as 10 mídias com mais vizualizações em ordem
	 *         decrescente
	 */
	public List<Midia> top10MidiasMaisVisualizacaoSeparadaPorGenero() {
    List<Midia> midiasMaior100 = midia.values().stream()
            .filter(m -> m.getAudiencia() >= 100)
            .collect(Collectors.toList());
    Map<Generos, List<Midia>> midiasPorGenero = midiasMaior100.stream()
            .collect(Collectors.groupingBy(Midia::getGenero));

    List<Midia> top10PorGenero = new ArrayList<>();
    midiasPorGenero.forEach((genero, midias) -> {
        List<Midia> midiasOrdenadas = midias.stream()
                .sorted(Comparator.comparing(Midia::getAudiencia).reversed())
                .limit(10)
                .collect(Collectors.toList());
        top10PorGenero.addAll(midiasOrdenadas);
    });

    return top10PorGenero;
}


	/**
	 * Busca o cliente que mais assistiu mídias e quantas mídias ele assistiu
	 * 
	 * @return mapaClientes Filtra e retorna uma Hashmap com o cliente que mais
	 *         assistiu mídias e o número de mídias que ele assistiu
	 */
	public Map<Integer, Cliente> clienteMaisAssistiuMidiasNumMidias() {
		Map<Integer, Cliente> mapaClientes = new HashMap<>();
		getClientes().values().stream()
				.max(Comparator.comparingInt(c -> c.getListaJaVista().size()))
				.ifPresent(cliente -> mapaClientes.put(cliente.getListaJaVista().size(), cliente));
		
		return mapaClientes;
	}

	/**
	 * Busca o cliente que mais avaliou mídias e a quantidade de mídias que ele
	 * avaliou
	 * 
	 * @return Filtra e retorna uma Entry com o cliente que mais
	 *         avaliou mídias e o número de mídias que ele assistiu junto com o
	 *         número de avaliações feitas
	 */
	public Entry<String, Cliente> clienteMaisAvaliouNumAvaliacoes() {
		return getClientes().entrySet().stream()
				.max(Comparator.comparingLong(entry -> getMidia().values().stream()
						.flatMap(m -> m.getNotas().entrySet().stream())
						.filter(nota -> nota.getKey().equals(entry.getKey()))
						.count()))
				.orElse(null);
	}


	/**
	 * Mostra em porcentagem a quantidade de clientes com mais de 15 avaliações que que o sistema possui
	 * 
	 * @return porcentagem do número de clientes que possuem mais de 15 avaliações 
	 */
	public double clientesMaisDe15Avaliacoes() {
		int totalClientes = getClientes().size();
		int numClientesMaisDe15Avaliacoes = (int) getClientes().values().stream()
				.filter(c -> c.getNotas().size() >= 15)
				.count();

		double porcentagem = (double) numClientesMaisDe15Avaliacoes / totalClientes * 100;
		return porcentagem;
	}
	


}
