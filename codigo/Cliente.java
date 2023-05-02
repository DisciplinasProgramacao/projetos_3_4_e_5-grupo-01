
public class Cliente {
		
		private String nomeDeUsuario;
		private String senha;
		private Lista<Midia> listaParaVer;
		private Lista<Midia> listaJaVista;
		
		public Cliente(String nomeDeUsuario, String senha) {
			this.nomeDeUsuario = nomeDeUsuario;
			this.senha = senha;
			this.listaParaVer = new Lista<Midia>();
			this.listaJaVista = new Lista<Midia>();
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

	  
	  public void adicionaNaLista(Midia serie) {
	    listaParaVer.add(serie);
	  }
		
		public void retirarDaLista(String nomeDaMidia) {
	    listaParaVer.removeS(nomeDaMidia);
	  }
		
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
	   * verifica todas as series r
	   * @param serie indica a serie para ser registrada
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
	  public void registrarAudiencia(Midia serie) {
	    listaParaVer.removeS(serie.getNome());
	    listaJaVista.add(serie);
	    serie.registrarAudiencia();
	    
	    //verificar a série na hash de séries de "PlataformaStraming", caso ela exisa executa tudo  
	  }
	  
	}
