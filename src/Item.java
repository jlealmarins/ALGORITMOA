public class Item {
    private int peso;   // Quantidade de espaço que o item ocupa
    private int valor;  // Valor do item (lucro potencial ou impacto de atender à demanda)

    public Item(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }
}
