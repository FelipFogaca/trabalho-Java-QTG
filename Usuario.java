package trabalhoQuaseTudoGostoso;

import java.time.LocalDate;

public class Usuario {
    String nome;
    String email;
    LocalDate dtNasc;

    public Usuario(String nome, String email, LocalDate dtNasc) {
        this.nome = nome;
        this.email = email;
        this.dtNasc = dtNasc;
    }

    public String getTitulo() {
        return nome;
    }

    public String getCriador() {
        return email;
    }

    public LocalDate getCategoria() {
        return dtNasc;
    }

    @Override
    public String toString() {
        return "Usuário: " + nome +
                "\nEmail: " + email +
                "\nData de Nascimento: " + dtNasc;
    }
}