// Arquivo: Refeicao.java

import java.util.ArrayList;
import java.util.List;

public class Refeicao {
    private Produto proteina;
    private List<Produto> acompanhamentos;
    private Produto bebida;

    public Refeicao() {
        this.acompanhamentos = new ArrayList<>();
    }

    public void setProteina(Produto proteina) {
        this.proteina = proteina;
    }

    public void adicionarAcompanhamento(Produto acompanhamento) {
        acompanhamentos.add(acompanhamento);
    }

    public void setBebida(Produto bebida) {
        this.bebida = bebida;
    }

    public double calcularTotal() {
        double total = proteina.getPreco();
        for (Produto acompanhamento : acompanhamentos) {
            total += acompanhamento.getPreco();
        }
        total += bebida.getPreco();
        return total;
    }
}
