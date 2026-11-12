package FilaDePrioridade;

public class FilaOrdenada {
    private NoP primeiro = null;
    private NoP ultimo = null;
    private int contador = 0;

    public void enqueque(String elemento, int prioridade) {
        NoP novo = new NoP(elemento, prioridade);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;

        } else if (novo.prioridade < primeiro.prioridade) {
            novo.proximo = primeiro;
            primeiro.anterior = novo;
            primeiro = novo;

        } else if (novo.prioridade >= ultimo.prioridade) {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;

        } else {
            NoP aux = primeiro;

            while (novo.prioridade >= aux.proximo.prioridade) {
                aux = aux.proximo;
            }

            novo.proximo = aux.proximo;
            novo.anterior = aux;
            aux.proximo.anterior = novo;
            aux.proximo = novo;
        }

        contador++;
    }

    public void dequeque() {
        if (contador == 0) {
            System.out.println("Fila vazia");
            return;
        }

        primeiro = primeiro.proximo;

        if (primeiro == null) {
            ultimo = null;
        } else {
            primeiro.anterior = null;
        }

        contador--;
    }

    public NoP peek() {
        if (contador == 0) {
            System.out.println("Fila vazia");
            return null;
        }
        return primeiro;
    }

    public String proximoElemento() {
        if (contador == 0) {
            System.out.println("Fila vazia");
            return null;
        }
        return primeiro.dado;
    }

    public int tamanho() {
        return contador;
    }

    public boolean vazia() {
        return contador == 0;
    }

    public void limpar() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public void exibir() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoP aux = primeiro;

        while (aux != null) {
            sb.append(aux.dado).append("(").append(aux.prioridade).append(")");
            if (aux.proximo != null) {
                sb.append(" ");
            }
            aux = aux.proximo;
        }

        return sb.toString();
    }
}
