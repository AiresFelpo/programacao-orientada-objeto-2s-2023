// Arquivo: Produto.java

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Criar listas estáticas para as opções de proteína, acompanhamentos e bebidas
    private static final List<Produto> opcoesProteina = new ArrayList<>();
    private static final List<Produto> opcoesAcompanhamento = new ArrayList<>();
    private static final List<Produto> opcoesBebida = new ArrayList<>();

    public static List<Produto> getOpcoesProteina() {
        return opcoesProteina;
    }

    public static List<Produto> getOpcoesAcompanhamento() {
        return opcoesAcompanhamento;
    }

    public static List<Produto> getOpcoesBebida() {
        return opcoesBebida;
    }

    static {
        opcoesProteina.add(new Produto(1, "Carne", 15.99));
        opcoesProteina.add(new Produto(2, "Peixe", 14.99));
        opcoesProteina.add(new Produto(3, "Frango", 12.99));

        opcoesAcompanhamento.add(new Produto(4, "Arroz", 5.99));
        opcoesAcompanhamento.add(new Produto(5, "Feijão", 4.99));
        opcoesAcompanhamento.add(new Produto(6, "Farofa", 3.99));
        opcoesAcompanhamento.add(new Produto(7, "Batata Frita", 7.99));
        opcoesAcompanhamento.add(new Produto(8, "Pure de Batatas", 6.99));
        opcoesAcompanhamento.add(new Produto(9, "Salada", 4.49));

        opcoesBebida.add(new Produto(10, "Refrigerante lata", 4.49));
        opcoesBebida.add(new Produto(11, "Suco lata", 3.99));
        opcoesBebida.add(new Produto(12, "Suco natural", 5.49));
        opcoesBebida.add(new Produto(13, "Água com gás", 2.99));
    }
}
