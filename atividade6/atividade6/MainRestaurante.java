import java.util.Scanner;

public class MainRestaurante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuRestaurante menu = new MenuRestaurante();

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
                    menu.criarPedido();
                    break;
                case 2:
                    menu.listarPedidos();
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
