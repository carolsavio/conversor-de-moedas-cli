import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("Bem-vindo ao conversor de moedas");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("Qual conversão você deseja fazer?");
        System.out.println("""
                
                1) Real => Dólar
                2) Dólar => Real
                3) Dólar => Peso Argentino
                4) Peso Argentino => Dólar
                5) Libras => Real
                6) Real => Libras
                7) Dólar => Libras
                8) Libras => Dólar
                9) Sair
                
                """);
        System.out.print("Digite o número da opção: ");
        int opcao = entrada.nextInt();

        if (opcao < 1 || opcao > 9) {
            System.out.println("Opção inválida! Selecione uma opção válida!");
            return;
        }

        System.out.print("Digite o valor que deseja converter: ");
        double valor = entrada.nextDouble();
        String moedaBase = "";
        String moedaAlvo = "";

        switch (opcao) {
            case 1:
                moedaBase = "BRL"; moedaAlvo = "USD";
                break;
            case 2:
                moedaBase = "USD"; moedaAlvo = "BRL";
                break;
            case 3:
                moedaBase = "USD"; moedaAlvo = "ARS";
                break;
            case 4:
                moedaBase = "ARS"; moedaAlvo = "USD";
                break;
            case 5:
                moedaBase = "GBP"; moedaAlvo = "BRL";
                break;
            case 6:
                moedaBase = "BRL"; moedaAlvo = "GBP";
                break;
            case 7:
                moedaBase = "USD"; moedaAlvo = "GBP";
                break;
            case 8:
                moedaBase = "GBP"; moedaAlvo = "USD";
                break;
            case 9:
                System.out.println("Programa encerrado. Obrigado!");
                break;
            default:
                System.out.println("Opção inválida!");
        }

        ConversorApp app = new ConversorApp();
        Conversor conversor = app.buscaConversor(moedaBase);

        Double taxaConversao = conversor.conversion_rates().get(moedaAlvo);

        if (taxaConversao != null) {
            double resultado = valor * taxaConversao;
            System.out.printf("O valor %.2f %s equivale a %.2f %s%n!", valor, moedaBase, resultado, moedaAlvo);
        } else {
            System.out.println("Moeda de destino não encontrada");
        }
    }
}