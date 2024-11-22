public class Heuristica {

    public static double calcularHeuristica(Item[] itens, int capacidadeRestante, int valorTotal, int index) {
        int capacidade = capacidadeRestante;
        double estimativaValor = valorTotal;


        for (int i = index; i < itens.length; i++) { // RODA TODOS OS ITENS QUE SERÃO INCLUIDOS NA MOCHILA
            if (itens[i].getPeso() <= capacidade) { // CHECA SE A MOCHILA TEM CAPACIDADE DE COLOCAR O ITEM
                capacidade -= itens[i].getPeso(); // SUBTRAI O PESO DO ITEM PELA CAPACIDADE DA MOCHILA
                estimativaValor += itens[i].getValor(); // SOMA O VALOR(IMPACTO) NA ESTIMATIVA DE VALOR DA MOCHILA
            } else {                                    // CASO A MOCHILA NÃO TENHA CAPACIDADE ADCIONA UMA FRAÇÃO DO ITEM
                estimativaValor += (capacidade / (double) itens[i].getPeso()) * itens[i].getValor(); // ADCIONA A FRACÃO DO ITEM PELA CAPACIDADE SUPORTADA
                break;
            }
        }
        return estimativaValor; // RETORNA UM VALOR DE ESTIMATIVA
    }
}
