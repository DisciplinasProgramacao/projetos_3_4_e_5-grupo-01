import java.util.HashMap;
import java.util.Scanner;

/**
 *Classe que representa um Cliente de uma plataforma de streaming.
*/
public class Cliente {
		
		private String nomeDeUsuario;
		private String senha;
		private String login;
		private Lista<Midia> listaParaVer;
		private Lista<Midia> listaJaVista;
		private HashMap<Midia, Integer> notas;
		
		public Cliente(String nomeDeUsuario, String senha, String login) {
			this.nomeDeUsuario = nomeDeUsuario;
			this.senha = senha;
			this.login = login;
			this.listaParaVer = new Lista<Midia>();
			this.listaJaVista = new Lista<Midia>();
			this.notas = new HashMap<Midia, Integer>();
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}
		
		public String getNomeDeUsuario() {
			return nomeDeUsuario;
		}
		
		public void setNomeDeUsuario(String nomeDeUsuario) {
			this.nomeDeUsuario = nomeDeUsuario;
		}
		
		public String getSenha() {
			return senha;
		}
		
		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		public Lista<Midia> getListaParaVer() {
			return listaParaVer;
		}
		
		public void setListaParaVer(Lista<Midia> listaParaVer) {
			this.listaParaVer = listaParaVer;
		}
		
		public Lista<Midia> getListaJaVista() {
			return listaJaVista;
		}
		
		public void setListaJaVista(Lista<Midia> listaJaVista) {
			this.listaJaVista = listaJaVista;
		}

		/**
		 * Adiciona na lista de assistir no futuro
		*/
		public void adicionaNaListaParaVer(Midia serie) {
			listaParaVer.add(serie);
		}
		/**
		 * Adiciona na lista de séries já vistas
		*/
		public void adicionaNaListaVistas(Midia serie) {
			listaParaVer.add(serie);
		}
		/**
		 * Retira da lista de assistir futuramente, mídia foi assistida
		*/
		public void retirarDaLista(String nomeDaMidia) {
			listaParaVer.removeS(nomeDaMidia);
		}
	        /**
		 * Filtra a Lista por gênero
		 @param genero O gênero pelo qual a lista vai ser filtrada
		 @return A lista filtrada
		*/
	  public Lista<Midia> filtrarPorGenero(String genero) {
	    Lista<Midia> listaFiltrada = new Lista<Midia>();
	    
	    for (Midia s : listaParaVer.allElements(new Midia[0])) {
	        if (s.getGenero().equalsIgnoreCase(genero)) {
	            listaFiltrada.add(s);
	        }
	    }

	    for (Midia s : listaJaVista.allElements(new Midia[0])) {
	        if (s.getGenero().equalsIgnoreCase(genero)) {
	            listaFiltrada.add(s);
	        }
	    }
	    
	    return listaFiltrada;
	}
		 /**
		 * Filtra a Lista por idioma
		 @param genero O idioma pelo qual a lista vai ser filtrada
		 @return A lista filtrada
		*/
	  public Lista<Midia> filtrarPorIdioma(String idioma) {
	    Lista<Midia> resultado = new Lista<>();
	    Midia[] todasMidias = null;
	    Midia[] jaVista = null;
	    jaVista = this.listaJaVista.allElements(jaVista);
	    todasMidias = this.listaParaVer.allElements(todasMidias);
	    for(int i =0; i<this.listaParaVer.size();i++){
	      if(todasMidias[i].getIdioma().equals(idioma)){
	        resultado.add(todasMidias[i]);
	      }
	    }
	    for(int i =0; i<this.listaJaVista.size();i++){
	      if(jaVista[i].getIdioma().equals(idioma)){
	        resultado.add(jaVista[i]);
	      }
	    }
	    return resultado;
	  }

	  /**
	   * Filtra a Lista por quantidade de episódios
	   @param qtdEpisodios O número (int) de episódios pelo qual a lista vai ser filtrada
	   @return A lista filtrada
	  */
	  public Lista<Midia> filtrarPorQtdEpisodios(int qtdEpisodios) {
	    Lista<Midia> resultado = new Lista<>();

	    Midia[] paraVer = null;
	    paraVer = this.listaParaVer.allElements(paraVer);
	    
	    for(int i = 0; i < this.listaParaVer.size(); i++){
	      if(((Serie) paraVer[i]).getQuantidadeEpisodios() == qtdEpisodios){
	        resultado.add(paraVer[i]);
	      }
	    }

	    Midia[] jaVista = null;
	    jaVista = this.listaParaVer.allElements(jaVista);
	    
	    for(int i = 0; i < this.listaJaVista.size(); i++){
	      if(((Serie) jaVista[i]).getQuantidadeEpisodios() == qtdEpisodios){
	        resultado.add(jaVista[i]);
	      }
	    }

	    return resultado;
	  }

	  /**
	     * Verifica a existência dessa série, remove ela da listaPraVer do Cliente e a adiciona na listaJavistas do Cliente
	     * @param serie indica a serie para ser registrada
	     */
	  public void registrarAudiencia(Midia m) {
	    listaParaVer.removeS(m.getNome());
	    listaJaVista.add(m);
	    m.registrarAudiencia();
	    
	    //verificar a série na hash de séries de "PlataformaStraming", caso ela exisa executa tudo  
	  }
	  
	/**
	 Método responsável por avaliar uma mídia.
	 @param mid - Objeto do tipo Midia que será avaliado
	*/
	public void avaliar(Midia mid) {
		Midia[] midias = new Midia[listaJaVista.size()];
		midias = listaJaVista.allElements(midias);
		int avaliacao;
		Scanner scan = new Scanner( System.in );
		
		for (Midia m: midias) {
			if(m.getId() == mid.getId()) {

				if(!notas.containsKey(m)){
					System.out.println("Qual nota deseja dar para: " + m.getNome());
					avaliacao = scan.nextInt();
					while(avaliacao > 10 || avaliacao < 0) {
						System.out.println("A avaliação deve ser um número entre 0 e 10, por favor tente novamente");
						avaliacao = scan.nextInt();
					}
					notas.put(m, avaliacao);
				}
				else{
					Integer a = notas.get(m);
					System.out.println("Deseja atualizar a nota da mídia: " + m.getNome() + "\n a nota atual é: " + a);
					System.out.println("1- Sim \n 2- Não");
					avaliacao = scan.nextInt();

					if (avaliacao == 1 ) {
						System.out.println("Qual será a nova nota?");
						avaliacao = scan.nextInt();

						while(avaliacao > 10 || avaliacao < 0) {
							System.out.println("A avaliação deve ser um número entre 0 e 10, por favor tente novamente");
							avaliacao = scan.nextInt();
						}

						notas.replace(m, a, avaliacao);
					}
				} 
			}
			else {
				System.err.println("Sua lista de mídias vistas está vazia, veja alguma mídia para que seja possível avaliar algo");
			}
		}

		scan.close();
		
	}
	/**
	 Retorna a nota atribuída a uma determinada mídia.
	 @param m a mídia cuja nota será consultada.
	 @return a nota atribuída à mídia, ou -1 se a mídia ainda não foi avaliada.
	*/
	public Integer notaDaMidia(Midia m){

		if(notas.containsKey(m)){
			return notas.get(m);
		}

		return -1;
	}
	/**
	 Retorna uma representação em String do objeto da classe Usuario contendo o nome e login do usuário.
	 @return uma String no formato "Nome: [nome do usuário]\nLogin: [login do usuário]"
	*/
	public String toString(){
		return "Nome: " + getNomeDeUsuario() + "\nLogin: " + getLogin();
	}
	  
}
