import java.util.ArrayList;
import java.util.List;

// Arquivo: Pedido.java

public class Pedido {
    private int numeroPedido;
    private Cliente cliente;
    private Produto proteina;
    private List<Produto> acompanhamentos;
    private Produto bebida;

    public Pedido(Cliente cliente, int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.acompanhamentos = new ArrayList<>();
    }

    public void escolherProteina(Produto proteinaEscolhida) {
        this.proteina = proteinaEscolhida;
    }

    public void escolherAcompanhamento(Produto acompanhamentoEscolhido) {
        if (acompanhamentos.size() < 3) {
            acompanhamentos.add(acompanhamentoEscolhido);
        } else {
            System.out.println("Você já escolheu 3 acompanhamentos. Não é possível adicionar mais.");
        }
    }

    public void escolherBebida(Produto bebidaEscolhida) {
        this.bebida = bebidaEscolhida;
    }

    public double calcularTotal() {
        double total = proteina.getPreco();
        for (Produto acompanhamento : acompanhamentos) {
            total += acompanhamento.getPreco();
        }
        total += bebida.getPreco();
        return total;
    }

    public void mostrarDetalhes() {
        System.out.println("\nPedido Número: " + numeroPedido);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Proteína: " + proteina.getNome() + " - R$" + proteina.getPreco());
        System.out.println("Acompanhamentos:");
        for (Produto acompanhamento : acompanhamentos) {
            System.out.println(acompanhamento.getNome() + " - R$" + acompanhamento.getPreco());
        }
        System.out.println("Bebida: " + bebida.getNome() + " - R$" + bebida.getPreco());
        System.out.println("TOTAL DO PEDIDO: R$" + calcularTotal());
    }

    public String getDetalhesPedido() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Pedido Numero ").append(numeroPedido).append(":\n");
        detalhes.append("Nome cliente: ").append(cliente.getNome()).append("\n");
        detalhes.append("Endereço do cliente: ").append(cliente.getEndereco()).append("\n");
        detalhes.append("Proteína: ").append(proteina.getNome()).append(" - R$").append(proteina.getPreco()).append("\n");
        detalhes.append("Acompanhamentos:\n");
        for (Produto acompanhamento : acompanhamentos) {
            detalhes.append("- ").append(acompanhamento.getNome()).append(" - R$").append(acompanhamento.getPreco()).append("\n");
        }
        detalhes.append("Bebida: ").append(bebida.getNome()).append(" - R$").append(bebida.getPreco()).append("\n");
        detalhes.append("TOTAL DO PEDIDO: R$").append(calcularTotal());
        return detalhes.toString();
    }
    
}
