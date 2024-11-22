import java.util.PriorityQueue;

public class MochilaAEstrela {


    /* O METODO DE RESOLVER O A ESTRELA SERIA DA SEGUINTE FORMA
        CRIA-SE UMA LISTA DE PRIORIDADE PARA RECEBER AS POSSIBILIDADES DE INCREMENTO
        LOGO APÓS É CRIADA UMA MOCHILA INICIAL PARA SER TESTADA

    */

    public static int resolverMochilaAEstrela(Item[] itens, int capacidadeMaxima) {
        PriorityQueue<Mochila> filaPrioridade = new PriorityQueue<>(new ComparadorEstado()); // CRIA UMA FILA DE PRIORIDADE PARA AS MOCHILAS
        Mochila estadoInicial = new Mochila(capacidadeMaxima, 0, Heuristica.calcularHeuristica(itens, capacidadeMaxima, 0, 0)); //CRIANDO UMA MOCHILA COM A CAPACIDADE MAXIMA INFORMADA, E CALCULA A HEURISTICA INICIAL DESSA MOCHILA COM BASE NOS ITENS RECEBIDOS
        filaPrioridade.add(estadoInicial); // ADCIONA A MOCHILA CRIADA NA FILA DE MOCHILAS

        int maiorValor = 0; // INICIA O MAIOR VALOR

        while (!filaPrioridade.isEmpty()) { //LOOP PRA PERCORRER TODA A LISTA DE MOCHILAS
            Mochila estadoAtual = filaPrioridade.poll(); //PEGA A PRIMEIRA MOCHILA DA FILA
            if (estadoAtual.getValorTotal() > maiorValor) { //CHECA SE O VALOR DO ESTADO ATUAL É O MAIOR VALOR ATÉ AGORA
                maiorValor = estadoAtual.getValorTotal(); // CASO SEJA O VALOR DO ESTADO ATUAL VIRA O MAIOR VALOR
            }

            for (int i = 0; i < itens.length; i++) { //LOOP PARA INCREMENTAR O ITEM NA MOCHILA
                if (itens[i].getPeso() <= estadoAtual.getCapacidadeRestante()) { // CHECA SE A MOCHILA SUPORTA O TAMANHO DO ITEM
                    int novaCapacidade = estadoAtual.getCapacidadeRestante() - itens[i].getPeso(); // CALCULA A NOVA CAPACIDADE ADCIONANDO O ITEM
                    int novoValorTotal = estadoAtual.getValorTotal() + itens[i].getValor(); // CALCULA O NOVO VALOR TOTAL ADCIONANDO O ITEM
                    double novaEstimativa = Heuristica.calcularHeuristica(itens, novaCapacidade, novoValorTotal, i + 1); //CALCULA A NOVA ESTIMATIVA COM ESSE ITEM

                    filaPrioridade.add(new Mochila(novaCapacidade, novoValorTotal, novaEstimativa)); //ADCIONA O NOVO ESTATO A LISTA DE PRIORIDADES
                }
            }
        }

        return maiorValor; // RETORNA O MAIOR VALOR
    }

    public static void main(String[] args) {
        Item[] itens = { // VETOR DE ITENS
                new Item(15, 75),  // Item 1
                new Item(22, 95),  // Item 2
                new Item(18, 110), // Item 3
                new Item(25, 80),  // Item 4
                new Item(10, 50),  // Item 5
                new Item(30, 125), // Item 6
                new Item(12, 65),  // Item 7
                new Item(28, 115), // Item 8
                new Item(20, 90),  // Item 9
                new Item(16, 85),  // Item 10
                new Item(24, 100), // Item 11
                new Item(27, 105), // Item 12
                new Item(14, 70),  // Item 13
                new Item(35, 130)  // Item 14
        };

        int capacidadeMaxima = 50; // Capacidade máxima da "mochila" (estoque)

        // Resolve o problema usando A*
        int valorMaximo = resolverMochilaAEstrela(itens, capacidadeMaxima);

        System.out.println("O valor máximo obtido é: " + valorMaximo);
    }
}
