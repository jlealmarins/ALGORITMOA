public class Mochila {
    private int capacidadeRestante;   // Quanto de capacidade de estoque ainda resta
    private int valorTotal;           // Valor acumulado dos itens estocados
    private double estimativaValor;   // Estimativa de valor futuro (heurística)

    public Mochila(int capacidadeRestante, int valorTotal, double estimativaValor) {
        this.capacidadeRestante = capacidadeRestante;
        this.valorTotal = valorTotal;
        this.estimativaValor = estimativaValor;
    }

    public int getCapacidadeRestante() {
        return capacidadeRestante;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public double getEstimativaValor() {
        return estimativaValor;
    }
}
