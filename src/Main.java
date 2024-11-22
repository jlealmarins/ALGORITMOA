import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //ENTRADA DE DADOS
        Scanner scanner = new Scanner(System.in);

        //CAPACIDADE MAX DA MOCHILA
        System.out.print("Digite a capacidade máxima da mochila: ");
        int capacidadeMaxima = scanner.nextInt();

        Item[] itens = {
            new Item(15, 75),
            new Item(22, 95),
            new Item(18, 110),
            new Item(25, 80),
            new Item(10, 50),
            new Item(30, 125),
            new Item(12, 65),
            new Item(28, 115),
            new Item(20, 90),
            new Item(16, 85),
            new Item(24, 100),
            new Item(27, 105),
            new Item(14, 70),
            new Item(35, 130)
        };

        //RESOLVE O PROBLEMA COM A*
        int valorMaximo = MochilaAEstrela.resolverMochilaAEstrela(itens, capacidadeMaxima);

        System.out.println("O valor máximo obtido na mochila é: " + valorMaximo);
    }
}
