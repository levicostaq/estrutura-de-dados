package FilaDePrioridade;

public class NoP {
    NoP proximo;
    int prioridade;
    NoP anterior;
    String dado;

    public NoP(String dado, int prioridade) {
        this.proximo = null;
        this.anterior = null;
        this.dado = dado;
        this.prioridade = prioridade;
    }
}
