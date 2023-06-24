/**
 * Enumeração dos idiomas possíveis para uma mídia.
 */

public enum Idiomas {
    PTBR,
    PTPG,
    ENG;

    
/**
 * Retorna o idioma do enum Idiomas com base no índice fornecido.
 *
 * @param index O índice do idioma desejado.
 * @return O idioma correspondente ao índice.
 * @throws IllegalArgumentException Se o índice fornecido for inválido.
 */
public static Idiomas getByIndex(int index) {
    Idiomas[] idiomas = Idiomas.values();
    if (index >= 0 && index < idiomas.length) {
        return idiomas[index];
    } else {
        throw new IllegalArgumentException("Índice inválido");
    }
}
}
