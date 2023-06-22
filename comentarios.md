## Correção Projeto 3 (branch de 03/05)

### Nota base: 12,6

### Comentários
- Backlog parcialmente preenchido
- Instruções de uso não preenchido
- Video enviado
- Diagrama desatualizado
- Deveriam criar source folder diferete para os testes
- Documentação incompleta
- Testes da classe Serie muito superficial
- Rever uso de equalsIgnoreCase() em filtrarPorGenero() do Cliente
- Método avaliar() utiliza apenas Series como entidade
- Não é uma boa prática deixar entrada de dados (scanner) em classes de regra de negócio (Cliente)
- Quando Filme e Serie compartilha mesmo elementos (genero e idioma) os mesmos poderiam estar em Midia
- Rever necessidade de getGeneros()
- Porque na carga de dados estão lendo apenas 3 campos dos filmes?
- Não implementaram todas as filtragens especificadas
- Organizem os elementos do repositorio
- Sugiro criar métodos para facilitar o processo de carga
- Remover trechos de código comentado
- Não estão salvando em arquivo
- Não estão exercitando as filtragens


1. Aderência às classes do diagrama: 1,25/2 pontos
  - Diagramas

2. Requisitos de corretamente implementados: 8,6/12 pontos
  - Carga de dados					2/2 pontos
  - Cadastro + salvar dados			1/2 pontos
  - Robustez básica					1/1 ponto
  - Clientes							1,75/2 pontos
	Listas, audiência sem repet
  - Séries							0,75/1 ponto
	 - audiência
  - Filme/Herança de mídia			0,6/1 ponto
  - Buscas 							1,5/3 pontos
	 - nome, gênero, idioma

3. Documentação de código: 1,5/4 pontos

4. Implementação na aula inicial: 1,25/2 pontos (cliente e série testados)
