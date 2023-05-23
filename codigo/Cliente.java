import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Cliente {
		
		private String nomeDeUsuario;
		private String senha;
		private String login;
		private Lista<Midia> listaParaVer;
		private HashMap<Midia,LocalDate> listaJaVista;
		private HashMap<Midia, Integer> notas;
		
		public Cliente(String nomeDeUsuario, String senha, String login, Lista<Midia> listaParaVer) {
			this.nomeDeUsuario = nomeDeUsuario;
			this.senha = senha;
			this.login = login;
			this.listaParaVer = new Lista<Midia>();
			this.listaJaVista = new HashMap<Midia,LocalDate>();
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
		
		public HashMap<Midia,LocalDate> getListaJaVista() {
			return listaJaVista;
		}
		
		public void setListaJaVista(HashMap<Midia,LocalDate> listaJaVista) {
			this.listaJaVista = listaJaVista;
		}

		
		public void adicionaNaListaParaVer(Midia serie) {
			listaParaVer.add(serie);
		}
		public void adicionaNaListaVistas(Midia serie) {
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

	    for (HashMap.Entry<Midia, LocalDate> s : listaJaVista.entrySet()) {
	        Midia midia = s.getKey();
	        LocalDate data = s.getValue();
	        if (midia.getGenero().equalsIgnoreCase(genero)) {
	            listaFiltrada.add(midia);
	        }
	    }
	    
	    return listaFiltrada;
	}

	  public Lista<Midia> filtrarPorIdioma(String idioma) throws Exception {
		  try {
			  Lista<Midia> resultado = new Lista<>();
			    Midia[] todasMidias = null;
			    todasMidias = this.listaParaVer.allElements(todasMidias);
			    for (int i = 0; i < this.listaParaVer.size(); i++) {
			        if (todasMidias[i].getIdioma().equals(idioma)) {
			            resultado.add(todasMidias[i]);
			        }
			    }
			    for (HashMap.Entry<Midia, LocalDate> s : listaJaVista.entrySet()) {
			        Midia midia = s.getKey();
			        LocalDate data = s.getValue();
			        if (midia.getIdioma().equals(idioma)) {
			            resultado.add(midia);
			        }
			    }
			    return resultado;
		  }catch (Exception e) {
			throw new Exception("Unexpected erro");
		}
		    
		}


	  /**
	   * verifica todas as series r
	   * @param serie indica a serie para ser registrada
	 * @throws Exception 
	   */
	  public Lista<Midia> filtrarPorQtdEpisodios(int qtdEpisodios) throws Exception {
		  try {
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
		  }catch (Exception e) {
			  throw new Exception("Unexpected error");
		}
	    
	  }

	  /**
	     * Verifica a existência dessa série, remove ela da listaPraVer do Cliente e a adiciona na listaJavistas do Cliente
	     * @param serie indica a serie para ser registrada
	     */
	  public void registrarAudiencia(Midia m) {
	    listaParaVer.removeS(m.getNome());
	    listaJaVista.put(m,LocalDate.now());
	    m.registrarAudiencia();
	    
	    //verificar a série na hash de séries de "PlataformaStraming", caso ela exisa executa tudo  
	  }
	  
	
	public Integer notaDaMidia(Midia m){

		if(notas.containsKey(m)){
			return notas.get(m);
		}

		return -1;
	}

	public String toString(){
		return "Nome: " + getNomeDeUsuario() + "\nLogin: " + getLogin();
	}
	  
	public boolean isEspecialista() throws Exception {
		try {
			int cont =0;
			for (HashMap.Entry<Midia, LocalDate> s : listaJaVista.entrySet()) {
		        Midia midia = s.getKey();
		        LocalDate data = s.getValue();
		        LocalDate umMes = LocalDate.now().minusMonths(1);
		        if(data.isAfter(umMes)) {
		        	cont++;
		        }
		    }
			if(cont >=5) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			throw new Exception("Unexpected error");
		}
	}
}
