/**
 * Enumeração dos gêneros possíveis para uma mídia.
 */
public enum Generos {
    ACAO,
    ANIME,
    AVENTURA,
    COMEDIA,
    DOCUMENTARIO,
    DRAMA,
    POLICIAL,
    ROMANCE,
    SUSPENSE;

    /**
     * Retorna o gênero do enum Generos com base no índice fornecido.
     *
     * @param index O índice do gênero desejado.
     * @return O gênero correspondente ao índice.
     * @throws IllegalArgumentException Se o índice fornecido for inválido.
     */
    public static Generos getByIndex(int index) {
        Generos[] generos = Generos.values();
        if (index >= 0 && index < generos.length) {
            return generos[index];
        } else {
            throw new IllegalArgumentException("Índice inválido");
        }
    }

}
