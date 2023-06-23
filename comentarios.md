# Comentários - Projeto 4 (30/05)

## Nota base: 8,75

### Comentários

- Instruções de uso não preenchido
- Não fizeram video de apresentação
- Organizem as pastas do repositório
- Criem um source folder diferente para comportar os testes
- Uma possível solução ao implementar a classe Avaliacao seria definir uma interface de Avaliadores para diferenciar os Clientes
- Ao realizar a avaliação de uma mídia mais de uma vez, está apenas atulizando para a última nota, onde era esperado bloquear essa operação
- Não valida o cliente especialista para realizar comentários
- Rever necessidade de toString() na Midia
- Diagrama desatualizado, não contempla a avaliação, por exemplo


- Comentários parcialmente realizados, vejam também pois alguns comentários estão incondizentes e incompletos, exemplo disso:

        /**
	   * verifica todas as series r
	   * @param serie indica a serie para ser registrada
	    * @throws Exception 
	   */

	  public Lista<Midia> filtrarPorQtdEpisodios(int qtdEpisodios) throws Exception {

----
	
- Aderência às classes do diagrama: 1/2 pontos
- Requisitos de corretamente implementados: 5,75/14 pontos
    - só pode avaliar o que tiver visto		2/2 pontos
    - avaliar, calcular e exibir media 		1,25/2 pontos
    - cliente não pode avaliar 2x			1/3 pontos
    - especialistas podem comentar			0/4 pontos
    - verificação de especialistas			1,5/3 pontos
	
- Documentação de código: 1/2 pontos

- Implementação na aula inicial: 1/2 pontos (02/05)
    - arquivos JavaDoc  
    - diagrama atualizado 
    - backlog de pendências

----