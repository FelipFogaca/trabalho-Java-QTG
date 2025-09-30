package trabalhoQuaseTudoGostoso;

public enum Categoria {
    BRASILEIRA,
    FASTFOOD,
    FRANCESA,
    ITALIANA,
    JAPONESA,
    MEXICANA,
    SAUDAVEL;

    public static Categoria fromInput(String s) {
        if (s == null)
            return null;
        switch (s.trim().toLowerCase()) {
            case "1":
                return BRASILEIRA;

            case "2":
                return FASTFOOD;

            case "3":
                return FRANCESA;

            case "4":
                return ITALIANA;

            case "5":
                return JAPONESA;

            case "6":
                return MEXICANA;

            case "7":
                return SAUDAVEL;
            default:
                throw new IllegalArgumentException("Categoria inválida: " + s);
        }
    }
}