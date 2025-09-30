package trabalhoQuaseTudoGostoso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Lista de usuários cadastrados
    static final List<Usuario> USUARIOS = new ArrayList<>();

    // Lista de preparos cadastrados
    static final List<Preparo> PREPAROS = new ArrayList<>();

    // Lista de receitas cadastradas
    static final List<Receita> RECEITAS = new ArrayList<>();

    static final Scanner SC = new Scanner(System.in);
    static final DateTimeFormatter DATA_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        while (true) {
            menu(); // Exibe o menu principal
            String op = SC.nextLine().trim();
            switch (op) {
                case "1":
                    cadastrarUsuario();
                    break;
                case "2":
                    cadastrarPreparo();
                    break;
                case "3":
                    cadastrarReceita();
                    break;
                case "4":
                    listarUsuarios();
                    break;
                case "5":
                    listarPreparos();
                    break;
                case "6":
                    listarReceitas();
                    break;
                case "0":
                    System.out.println("Saiu.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
        }
    }

    private static void menu() {
        System.out.println("\n ______________________");
        System.out.println("|         MENU         |");
        System.out.println("|----------------------|");
        System.out.println("| 1. Cadastrar usuário |");
        System.out.println("|----------------------|");
        System.out.println("| 2. Cadastrar preparo |");
        System.out.println("|----------------------|");
        System.out.println("| 3. Cadastrar receita |");
        System.out.println("|----------------------|");
        System.out.println("| 4. Listar usuários   |");
        System.out.println("|----------------------|");
        System.out.println("| 5. Listar preparos   |");
        System.out.println("|----------------------|");
        System.out.println("| 6. Listar receitas   |");
        System.out.println("|----------------------|");
        System.out.println("| 0. Sair              |");
        System.out.println("|______________________|");

        System.out.print("\nEscolha: ");
    }

    // Cadastra um novo usuário
    private static void cadastrarUsuario() {
        System.out.println("Novo Usuário");
        System.out.print("Nome: ");
        String nome = SC.nextLine().trim();
        LocalDate dtNasc = lerData("Data de nascimento (dd/MM/yyyy): ");
        String email = lerEmail("Email: ");
        USUARIOS.add(new Usuario(nome, email, dtNasc));
        System.out.println("Usuário cadastrado.");
    }

    private static void cadastrarPreparo() {
        System.out.println("Novo Preparo");
        Preparo p = new Preparo();
        String linha;

        System.out.println("Digite os passos. Para concluir o cadastro, digite '0' em uma nova linha");

        do {
            linha = SC.nextLine();
            if (!linha.equals("0")) {
                p.adicionarPasso(linha);
            }
        } while (!linha.equals("0"));

        PREPAROS.add(p);
        System.out.println("Preparo cadastrado.");
    }

    // Cadastra uma nova receita
    private static void cadastrarReceita() {
        if (USUARIOS.isEmpty()) {
            System.out.println("Cadastre um usuário primeiro.");
            return;
        }
        if (PREPAROS.isEmpty()) {
            System.out.println("Cadastre um preparo primeiro.");
            return;
        }

        System.out.println("=== Nova Receita ===");
        System.out.print("Título: ");
        String titulo = SC.nextLine().trim();

        listarUsuarios();
        Usuario criador = USUARIOS.get(lerIndice("\nEscolha o usuário: ", USUARIOS.size()));

        System.out.print(
                "\nCategoria (1. Brasileira, 2. Fastfood, 3. Francesa, 4. Italiana, 5. Japonesa, 6. Mexicana, 7. Saudavel): ");
        Categoria cat = Categoria.fromInput(SC.nextLine());

        System.out.print("\nDificuldade (1. Iniciante, 2. Amador, 3. Profissional): ");
        Dificuldade dif = Dificuldade.fromInput(SC.nextLine());

        listarPreparos();
        Preparo prep = PREPAROS.get(lerIndice("\nEscolha o preparo: ", PREPAROS.size()));

        RECEITAS.add(new Receita(titulo, criador, cat, dif, prep));
        System.out.println("Receita cadastrada.");
    }

    // Lista todos os usuários cadastrados
    private static void listarUsuarios() {
        if (USUARIOS.isEmpty()) {
            System.out.println("Nenhum usuário.");
            return;
        }
        for (int i = 0; i < USUARIOS.size(); i++)
            System.out.println("\n[" + i + "] " + USUARIOS.get(i));
    }

    // Lista todos os preparos cadastrados
    private static void listarPreparos() {
        if (PREPAROS.isEmpty()) {
            System.out.println("Nenhum preparo.");
            return;
        }
        for (int i = 0; i < PREPAROS.size(); i++) {
            System.out.println("\n[" + i + "]");
            System.out.print(PREPAROS.get(i));
        }
    }

    // Lista todas as receitas cadastradas
    private static void listarReceitas() {
        if (RECEITAS.isEmpty()) {
            System.out.println("Nenhuma receita.");
            return;
        }
        for (int i = 0; i < RECEITAS.size(); i++) {
            System.out.println("\n[" + i + "]");
            System.out.println(RECEITAS.get(i));
        }
    }

    // Lê uma data do usuário com validação
    private static LocalDate lerData(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return LocalDate.parse(SC.nextLine().trim(), DATA_BR);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida.");
            }
        }
    }

    // Lê um e-mail do usuário com validação usando regex
    private static String lerEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            if (s.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$"))
                return s;
            System.out.println("Email inválido.");
        }
    }

    // Lê um índice válido dentro de um limite
    private static int lerIndice(String prompt, int limite) {
        while (true) {
            System.out.print(prompt);
            try {
                int i = Integer.parseInt(SC.nextLine().trim());
                if (i >= 0 && i < limite)
                    return i;
            } catch (Exception ignored) {
            }
            System.out.println("Índice inválido.");
        }
    }
}