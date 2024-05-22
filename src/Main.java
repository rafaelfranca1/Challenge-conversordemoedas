import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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
                escolha uma opcao valida: """;

        while (true){
            System.out.print(menu);
            int opcao = scan.nextInt();
            String moedaAtual = "";
            String moedaDestino = "";

            switch (opcao) {
                case 1:
                    moedaAtual = "USD";
                    moedaDestino = "EUR";
                    break;
                case 2:
                    moedaAtual = "EUR";
                    moedaDestino = "USD";
                    break;
                case 3:
                    moedaAtual = "USD";
                    moedaDestino = "BRL";
                    break;
                case 4:
                    moedaAtual = "BRL";
                    moedaDestino = "USD";
                    break;
                case 5:
                    moedaAtual = "USD";
                    moedaDestino = "JPY";
                    break;
                case 6:
                    moedaAtual = "JPY";
                    moedaDestino = "USD";
                    break;
                case 7:
                    System.out.println("\nfinalizado!");
                    return;
                default:
                    System.out.println("\nopcao invalida");
                    continue;
            }

            System.out.print("\ndigite um valor para ser convertido: ");
            double valor = scan.nextDouble();

            Conversao conversao = new Conversao(moedaAtual);

            double resultado = conversao.converteMoeda(moedaDestino, valor);
            System.out.println("\no valor " + valor + " [" + moedaAtual + "] corresponde ao valor final de > "
                    + resultado + " [" + moedaDestino + "]");
        }
    }
}