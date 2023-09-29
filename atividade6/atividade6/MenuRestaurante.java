import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRestaurante {
    private List<Pedido> pedidos;
    private int proximoNumeroPedido;

    public MenuRestaurante() {
        this.pedidos = new ArrayList<>();
        this.proximoNumeroPedido = 1;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU DO RESTAURANTE ---");
            System.out.println("1- Criar pedido");
            System.out.println("2- Listar pedidos");
            System.out.println("3- Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    criarPedido();
                    break;
                case 2:
                    listarPedidos();
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void criarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Digite o endereço do cliente: ");
        String enderecoCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, enderecoCliente);
        Pedido pedido = new Pedido(cliente, proximoNumeroPedido++);

        // Escolher proteína
        System.out.println("\nEscolha sua proteína:");
        boolean escolhaProteinaValida = false;
        Produto proteinaEscolhida = null;

        while (!escolhaProteinaValida) {
            exibirOpcoesMenu(Produto.getOpcoesProteina());
            int escolhaProteina = scanner.nextInt();
            if (escolhaProteina >= 1 && escolhaProteina <= Produto.getOpcoesProteina().size()) {
                proteinaEscolhida = Produto.getOpcoesProteina().get(escolhaProteina - 1);
                pedido.escolherProteina(proteinaEscolhida);
                System.out.println(proteinaEscolhida.getNome() + " adicionada ao pedido.");
                escolhaProteinaValida = true;
            } else {
                System.out.println("Opção inválida, escolha outra proteína.");
            }
        }

        // Escolher acompanhamentos
        System.out.println("\nEscolha 3 acompanhamentos:");
        List<Produto> acompanhamentosEscolhidos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            boolean escolhaAcompanhamentoValida = false;
            Produto acompanhamentoEscolhido = null;

            while (!escolhaAcompanhamentoValida) {
                exibirOpcoesMenu(Produto.getOpcoesAcompanhamento());
                System.out.print("Escolha o " + (i + 1) + "º acompanhamento: ");
                int escolhaAcompanhamento = scanner.nextInt();
                if (escolhaAcompanhamento >= 1 && escolhaAcompanhamento <= Produto.getOpcoesAcompanhamento().size()) {
                    acompanhamentoEscolhido = Produto.getOpcoesAcompanhamento().get(escolhaAcompanhamento - 1);
                    pedido.escolherAcompanhamento(acompanhamentoEscolhido);
                    System.out.println(acompanhamentoEscolhido.getNome() + " adicionado ao pedido.");
                    acompanhamentosEscolhidos.add(acompanhamentoEscolhido);
                    escolhaAcompanhamentoValida = true;
                } else {
                    System.out.println("Opção inválida, escolha outro acompanhamento.");
                }
            }
        }

        // Escolher bebida
        System.out.println("\nEscolha sua bebida:");
        boolean escolhaBebidaValida = false;
        Produto bebidaEscolhida = null;

        while (!escolhaBebidaValida) {
            exibirOpcoesMenu(Produto.getOpcoesBebida());
            int escolhaBebida = scanner.nextInt();
            if (escolhaBebida >= 1 && escolhaBebida <= Produto.getOpcoesBebida().size()) {
                bebidaEscolhida = Produto.getOpcoesBebida().get(escolhaBebida - 1);
                pedido.escolherBebida(bebidaEscolhida);
                System.out.println(bebidaEscolhida.getNome() + " adicionada ao pedido.");
                escolhaBebidaValida = true;
            } else {
                System.out.println("Opção inválida, escolha outra bebida.");
            }
        }

        // Adicionar o pedido à lista de pedidos
        pedidos.add(pedido);

        System.out.println("\nPedido criado com sucesso!");

        // Exibir os detalhes do pedido
        System.out.println("\nDETALHES DO PEDIDO:");
        System.out.println(pedido.getDetalhesPedido());

    }

    public void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("\nNenhum pedido registrado.");
        } else {
            System.out.println("\n--- LISTA DE PEDIDOS ---");
            for (Pedido pedido : pedidos) {
                pedido.mostrarDetalhes();
            }
        }
    }

    public void exibirOpcoesMenu(List<Produto> opcoes) {
        for (int i = 0; i < opcoes.size(); i++) {
            System.out.println((i + 1) + "- " + opcoes.get(i).getNome() + " - R$" + opcoes.get(i).getPreco());
        }
    }

    public static void main(String[] args) {
        MenuRestaurante menu = new MenuRestaurante();
        menu.exibirMenu();
    }
}
