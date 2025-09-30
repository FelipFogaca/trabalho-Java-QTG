package trabalhoQuaseTudoGostoso;

public class Receita {
    String titulo;
    Usuario criador;
    Categoria categoria;
    Dificuldade dificuldade;
    Preparo preparo;

    public Receita(String titulo, Usuario criador, Categoria categoria, Dificuldade dificuldade, Preparo preparo) {
        this.titulo = titulo;
        this.criador = criador;
        this.categoria = categoria;
        this.dificuldade = dificuldade;
        this.preparo = preparo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Usuario getCriador() {
        return criador;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public Preparo getPreparo() {
        return preparo;
    }

    @Override
    public String toString() {
        return "Receita: " + titulo +
                "\nCriador: " + criador +
                "\nCategoria: " + categoria +
                "\nDificuldade: " + dificuldade +
                "\nPreparo: " + preparo;
    }
}