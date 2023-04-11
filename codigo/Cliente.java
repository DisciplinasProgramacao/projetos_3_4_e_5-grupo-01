
public class Cliente {
		
		private String nomeDeUsuario;
		private String senha;
		private Lista<Serie> listaParaVer;
		private Lista<Serie> listaJaVista;
		
		public Cliente(String nomeDeUsuario, String senha) {
			this.nomeDeUsuario = nomeDeUsuario;
			this.senha = senha;
			this.listaParaVer = new Lista<Serie>();
			this.listaJaVista = new Lista<Serie>();
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
		
		public Lista<Serie> getListaParaVer() {
			return listaParaVer;
		}
		
		public void setListaParaVer(Lista<Serie> listaParaVer) {
			this.listaParaVer = listaParaVer;
		}
		
		public Lista<Serie> getListaJaVista() {
			return listaJaVista;
		}
		
		public void setListaJaVista(Lista<Serie> listaJaVista) {
			this.listaJaVista = listaJaVista;
		}

	  
	  public void adicionaNaLista(Serie serie) {
	    listaParaVer.add(serie);
	  }
		
		public void retirarDaLista(String nomeDaSerie) {
	    listaParaVer.removeS(nomeDaSerie);
	  }
		
	  public Lista<Serie> filtrarPorGenero(String genero) {
	    Lista<Serie> listaFiltrada = new Lista<Serie>();
	    
	    for (Serie s : listaParaVer.allElements(new Serie[0])) {
	        if (s.getGenero().equalsIgnoreCase(genero)) {
	            listaFiltrada.add(s);
	        }
	    }

	    for (Serie s : listaJaVista.allElements(new Serie[0])) {
	        if (s.getGenero().equalsIgnoreCase(genero)) {
	            listaFiltrada.add(s);
	        }
	    }
	    
	    return listaFiltrada;
	}

	  public Lista<Serie> filtrarPorIdioma(String idioma) {
	    Lista<Serie> resultado = new Lista<>();
	    Serie[] todasSeries = null;
	    Serie[] jaVista = null;
	    jaVista = this.listaJaVista.allElements(jaVista);
	    todasSeries = this.listaParaVer.allElements(todasSeries);
	    for(int i =0; i<this.listaParaVer.size();i++){
	      if(todasSeries[i].getIdioma().equals(idioma)){
	        resultado.add(todasSeries[i]);
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
	   * verifica todas as series r
	   * @param serie indica a serie para ser registrada
	   */
	  public Lista<Serie> filtrarPorQtdEpisodios(int qtdEpisodios) {
	    Lista<Serie> resultado = new Lista<>();

	    Serie[] paraVer = null;
	    paraVer = this.listaParaVer.allElements(paraVer);
	    
	    for(int i = 0; i < this.listaParaVer.size(); i++){
	      if(paraVer[i].getQuantidadeEpisodios() == qtdEpisodios){
	        resultado.add(paraVer[i]);
	      }
	    }

	    Serie[] jaVista = null;
	    jaVista = this.listaParaVer.allElements(jaVista);
	    
	    for(int i = 0; i < this.listaJaVista.size(); i++){
	      if(jaVista[i].getQuantidadeEpisodios() == qtdEpisodios){
	        resultado.add(jaVista[i]);
	      }
	    }

	    return resultado;
	  }

	  /**
	     * Verifica a existência dessa série, remove ela da listaPraVer do Cliente e a adiciona na listaJavistas do Cliente
	     * @param serie indica a serie para ser registrada
	     */
	  public void registrarAudiencia(Serie serie) {
	    listaParaVer.removeS(serie.getNome());
	    listaJaVista.add(serie);
	    serie.registrarAudiencia();
	    
	    //verificar a série na hash de séries de "PlataformaStraming", caso ela exisa executa tudo  
	  }
	  
	}