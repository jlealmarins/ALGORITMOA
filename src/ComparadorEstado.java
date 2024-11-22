import java.util.Comparator;

public class ComparadorEstado implements Comparator<Mochila> {
    @Override
    public int compare(Mochila a, Mochila b) {
        return Double.compare(b.getEstimativaValor(), a.getEstimativaValor()); // Maior valor primeiro
    }
}
