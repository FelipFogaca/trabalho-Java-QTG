package trabalhoQuaseTudoGostoso;

public enum Dificuldade {
    INICIANTE,
    AMADOR,
    PROFISSIONAL;

    public static Dificuldade fromInput(String s) {
        if (s == null)
            return null;
        switch (s.trim().toLowerCase()) {
            case "1":
                return INICIANTE;
            case "2":
                return AMADOR;
            case "3":
                return PROFISSIONAL;
            default:
                throw new IllegalArgumentException("Dificuldade inválida: " + s);
        }
    }
}