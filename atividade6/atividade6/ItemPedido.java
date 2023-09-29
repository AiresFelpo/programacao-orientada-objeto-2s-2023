// Arquivo: ItemPedido.java

public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public String toString() {
        return produto.getNome() + " - " + quantidade + " x " + produto.getPreco() + " = " + calcularSubtotal();
    }
}
