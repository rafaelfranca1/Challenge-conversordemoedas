import java.util.Scanner;

public class Menu {
    public void show() {
        Scanner scan = new Scanner(System.in); // Criando o Scanner uma única vez

        while (true) {
            String menu = """
                \n*****************************************************
                seja bem-vindo/a ao conversor de moedas :)
                
                1) dolar > euro 
                2) euro > dolar
                3) dolar > real brasileiro
                4) real brasileiro > dolar
                5) dolar > yen japones
                6) yen japones > dolar
                7) sair
                *****************************************************
                escolha uma opcao valida:""";

            System.out.print(menu);

            if (!scan.hasNextInt()) { // Verifica se há um número antes de tentar ler
                System.out.println("\nEntrada inválida. Por favor, insira um número.");
                scan.next(); // Limpa a entrada inválida
                continue;
            }

            int opcao = scan.nextInt();
            scan.nextLine(); // Limpa a quebra de linha após nextInt()

            if (opcao == 7) {
                System.out.println("\nfinalizando o programa...");
                break; // Sai do loop e finaliza o programa corretamente
            }

            String moedaAtual = "", moedaDestino = "";

            switch (opcao) {
                case 1 -> { moedaAtual = "USD"; moedaDestino = "EUR"; }
                case 2 -> { moedaAtual = "EUR"; moedaDestino = "USD"; }
                case 3 -> { moedaAtual = "USD"; moedaDestino = "BRL"; }
                case 4 -> { moedaAtual = "BRL"; moedaDestino = "USD"; }
                case 5 -> { moedaAtual = "USD"; moedaDestino = "JPY"; }
                case 6 -> { moedaAtual = "JPY"; moedaDestino = "USD"; }
                default -> {
                    System.out.println("\nOpção inválida. Tente novamente.");
                    continue;
                }
            }

            System.out.print("\nDigite um valor para ser convertido: ");

            if (!scan.hasNextDouble()) { // Garante que a entrada seja um número
                System.out.println("\nValor inválido. Por favor, insira um número.");
                scan.next(); // Limpa a entrada inválida
                continue;
            }

            double valor = scan.nextDouble();
            scan.nextLine(); // Consome a quebra de linha pendente

            Conversao conversor = new Conversao(moedaAtual, moedaDestino);
            double resultado = conversor.converteMoeda(valor);
            System.out.printf("\nO valor %.2f [%s] corresponde ao valor final de > %.2f [%s]\n",
                    valor, moedaAtual, resultado, moedaDestino);
        }
    }
}
