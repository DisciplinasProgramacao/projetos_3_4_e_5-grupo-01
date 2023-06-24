import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import excecoes.ClienteNaoProfissional;
import excecoes.usuarioNaoPodeComentarException;

/**
 * A classe abstrata Cliente representa um cliente genérico, contendo
 * informações como nome de usuário, senha, login,
 * listas de mídias para ver e mídias já vistas, além de métodos para gerenciar
 * essas informações e adicionar avaliações.
 */
public abstract class Cliente {

	private String nomeDeUsuario;
	private String senha;
	private String login;
	private Lista<Midia> listaParaVer;
	private HashMap<Midia, LocalDate> listaJaVista;
	private HashMap<Midia, Avaliacao> notas;

	/**
	 * Cria um novo cliente com o nome de usuário, senha e login especificados.
	 *
	 * @param nomeDeUsuario o nome de usuário do cliente
	 * @param senha         a senha do cliente
	 * @param login         o login do cliente
	 */
	public Cliente(String nomeDeUsuario, String senha, String login) {
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
		this.login = login;
		this.listaParaVer = new Lista<Midia>();
		this.notas = new HashMap<Midia, Avaliacao>();
		this.listaJaVista = new HashMap<Midia, LocalDate>();
	}

	/**
	 * Obtém o login do cliente.
	 *
	 * @return o login do cliente
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Define o login do cliente.
	 *
	 * @param login o login do cliente
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Obtém o nome de usuário do cliente.
	 *
	 * @return o nome de usuário do cliente
	 */
	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}

	/**
	 * Define o nome de usuário do cliente.
	 *
	 * @param nomeDeUsuario o nome de usuário do cliente
	 */
	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}

	/**
	 * Obtém a senha do cliente.
	 *
	 * @return a senha do cliente
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Define a senha do cliente.
	 *
	 * @param senha a senha do cliente
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Obtém a lista de mídias para ver do cliente.
	 *
	 * @return a lista de mídias para ver do cliente
	 */
	public Lista<Midia> getListaParaVer() {
		return listaParaVer;
	}

	/**
	 * Define a lista de mídias para ver do cliente.
	 *
	 * @param listaParaVer a lista de mídias para ver do cliente
	 */
	public void setListaParaVer(Lista<Midia> listaParaVer) {
		this.listaParaVer = listaParaVer;
	}

	/**
	 * Obtém a lista de mídias já vistas pelo cliente, juntamente com as datas em
	 * que foram vistas.
	 *
	 * @return a lista de mídias já vistas pelo cliente
	 */
	public HashMap<Midia, LocalDate> getListaJaVista() {
		return listaJaVista;
	}

	/**
	 * Define a lista de mídias já vistas pelo cliente, juntamente com as datas em
	 * que foram vistas.
	 *
	 * @param listaJaVista a lista de mídias já vistas pelo cliente
	 */
	public void setListaJaVista(HashMap<Midia, LocalDate> listaJaVista) {
		this.listaJaVista = listaJaVista;
	}

	/**
	 * Obtém as avaliações feitas pelo cliente para as mídias.
	 *
	 * @return as avaliações feitas pelo cliente
	 */
	public HashMap<Midia, Avaliacao> getNotas() {
		return notas;
	}

	/**
	 * Define as avaliações feitas pelo cliente para as mídias.
	 *
	 * @param notas as avaliações feitas pelo cliente
	 */
	public void setNotas(HashMap<Midia, Avaliacao> notas) {
		this.notas = notas;
	}

	/**
	 * Adiciona uma avaliação para uma mídia feita pelo cliente.
	 *
	 * @param midia     a mídia que será avaliada
	 * @param avaliacao a avaliação feita pelo cliente
	 */
	public void adicionarAvaliacao(Midia midia, Avaliacao avaliacao) {
		notas.put(midia, avaliacao);
	}

	/**
	 * Adiciona uma mídia à lista de mídias para ver do cliente.
	 *
	 * @param m a mídia a ser adicionada
	 */
	public void adicionaNaListaParaVer(Midia m) {
		listaParaVer.add(m);
	}

	/**
	 * Adiciona uma mídia à lista de mídias já vistas pelo cliente, registrando a
	 * data atual.
	 *
	 * @param m a mídia a ser adicionada
	 */
	public void adicionaNaListaVistas(Midia m) {
		listaJaVista.put(m, LocalDate.now());
	}

	/**
	 * Retira da lista para ver do cliente
	 * 
	 * @param nomeDaMidia Mídia a ser retirada da lista
	 */
	public void retirarDaLista(String nomeDaMidia) {
		for (int i = 0; i < listaParaVer.size(); i++) {
			if (listaParaVer.get(i).getNome().equals(nomeDaMidia))
				listaParaVer.remove(i);
		}
		listaParaVer.removeS(nomeDaMidia);
	}

	/**
	 * Retorna a data em que o cliente assistiu a mídia especificada.
	 *
	 * @param m a mídia para a qual se deseja obter a data de visualização
	 * @return a data em que o cliente assistiu a mídia, ou null se não foi
	 *         assistida
	 */
	public boolean jaAssistiu(Midia m) {

		return listaJaVista.containsKey(m);
	}

	/**
	 * Filtra todas as mídias pelo genero
	 * 
	 * @param genero Idioma a ser buscado
	 * @return listaFiltrada Lista com as mídias que possuem esse genero
	 */
	public Lista<Midia> filtrarPorGenero(Generos genero) {
		Lista<Midia> listaFiltrada = new Lista<Midia>();

		for (Midia s : listaParaVer.allElements(new Midia[0])) {
			if (s.getGenero() == genero) {
				listaFiltrada.add(s);
			}
		}

		for (HashMap.Entry<Midia, LocalDate> s : listaJaVista.entrySet()) {
			Midia midia = s.getKey();
			LocalDate data = s.getValue();
			if (midia.getGenero() == genero) {
				listaFiltrada.add(midia);
			}
		}

		return listaFiltrada;
	}

	/**
	 * Filtra todas as mídias pelo idioma
	 * 
	 * @param idioma Idioma a ser buscado
	 * @return listaFiltrada Lista com as mídias que possuem esse idioma
	 */
	public Lista<Midia> filtrarPorIdioma(Idiomas idioma) {
		Lista<Midia> listaFiltrada = new Lista<Midia>();

		for (Midia s : listaParaVer.allElements(new Midia[0])) {
			if (s.getIdioma() == idioma) {
				listaFiltrada.add(s);
			}
		}

		for (HashMap.Entry<Midia, LocalDate> s : listaJaVista.entrySet()) {
			Midia midia = s.getKey();
			LocalDate data = s.getValue();
			if (midia.getIdioma() == idioma) {
				listaFiltrada.add(midia);
			}
		}

		return listaFiltrada;

	}

	/**
	 * Filtra todas as mídias por quantidade de episódios
	 * 
	 * @param qtdEpisodios Quantidade de episódios que deve ser feita a filtragem
	 * @return resultado Lista com as mídias que possuem quantidade de episódios
	 *         definida
	 * @throws Exception IllegalArgumentException
	 */
	public Lista<Midia> filtrarPorQtdEpisodios(int qtdEpisodios) {
		try {
			Lista<Midia> resultado = new Lista<>();

			Midia[] paraVer = null;
			paraVer = this.listaParaVer.allElements(paraVer);

			for (int i = 0; i < this.listaParaVer.size(); i++) {
				if (((Serie) paraVer[i]).getQuantidadeEpisodios() == qtdEpisodios) {
					resultado.add(paraVer[i]);
				}
			}

			Midia[] jaVista = null;
			jaVista = this.listaParaVer.allElements(jaVista);

			for (int i = 0; i < this.listaJaVista.size(); i++) {
				if (((Serie) jaVista[i]).getQuantidadeEpisodios() == qtdEpisodios) {
					resultado.add(jaVista[i]);
				}
			}

			return resultado;
		} catch (Exception e) {
			throw new IllegalArgumentException("Unexpected error");
		}

	}

	/**
	 * Registra a audiência de uma mídia pelo cliente profissional.
	 *
	 * @param m a mídia para a qual a audiência será registrada
	 * @throws ClienteNaoProfissional caso o cliente não seja um cliente
	 *                                profissional
	 */
	public void registrarAudiencia(Midia m) throws ClienteNaoProfissional {

		if (!(this instanceof clienteProfissional)) {
			throw new ClienteNaoProfissional();
		}

		LocalDate dataAtual = LocalDate.now();
		listaParaVer.removeS(m.getNome());
		listaJaVista.put(m, dataAtual);
		m.registrarAudiencia();

		try {
			// Cria um FileWriter com o modo de append
			FileWriter fileWriter = new FileWriter("audiencia.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// Escreve o conteúdo no arquivo
			bufferedWriter.newLine();
			bufferedWriter.write(this.login + ";" + "A" + ";" + m.getId());

			// Fecha o BufferedWriter
			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao registrar sua audiencia: " + e.getMessage());
		}

	}

	/**
	 * Retorna a nota dada à mídia
	 * 
	 * @param m a midia buscada
	 */
	public Float notaDaMidia(Midia m) {
		if (notas.containsKey(m)) {
			Avaliacao a = notas.get(m);
			return a.getNota();
		}
		return -1.0f;
	}

	public String toString() {
		return "Nome: " + getNomeDeUsuario() + "\nLogin: " + getLogin();
	}

	/**
	 * Verifica se o cliente é especialista, retornando true caso positivo e false
	 * caso negativo
	 * 
	 * @return true Cliente é especialista
	 * @return false CLiente não é especialista
	 */
	public boolean isEspecialista() throws usuarioNaoPodeComentarException {

		int cont = 0;
		for (HashMap.Entry<Midia, LocalDate> s : listaJaVista.entrySet()) {
			Midia midia = s.getKey();
			LocalDate data = s.getValue();
			LocalDate umMes = LocalDate.now().minusMonths(1);
			if (data.isAfter(umMes)) {
				cont++;
			}
		}
		if (cont >= 5) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Verifica se o cliente é comum, retornando true caso positivo e false caso
	 * negativo
	 * 
	 * @return true Cliente é comum
	 * @return false CLiente não é comum
	 */
	public boolean isComum() {

		int cont = 0;
		for (HashMap.Entry<Midia, LocalDate> s : listaJaVista.entrySet()) {
			Midia midia = s.getKey();
			LocalDate data = s.getValue();
			LocalDate umMes = LocalDate.now().minusMonths(1);
			if (data.isAfter(umMes)) {
				cont++;
			}
		}
		if (cont < 0) {
			throw new RuntimeException("Nao e possivel ter um numero negativo");
		}
		if (cont < 5) {
			return true;
		} else {
			return false;
		}
	}
}
