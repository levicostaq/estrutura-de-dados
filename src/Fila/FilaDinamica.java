package Fila;

public class FilaDinamica {
    private No primeiro = null;
    private No ultimo = null;
    private int contador = 0;

    public FilaDinamica() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public void enqueque(int elemento) {
        No novo = new No(elemento);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
        }

        contador++;
    }

    public void dequeque() {
        if (contador == 0) {
            System.out.println("Fila Vazia!");
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

    public void adicionar(int elemento) {
        enqueque(elemento);
    }

    public void remover() {
        dequeque();
    }

    public No pesquisar(int posicao) {
        if (posicao < 0 || posicao >= contador) {
            return null;
        }

        No aux = primeiro;
        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }
        return aux;
    }

    public int peek() {
        if (contador == 0) {
            System.out.println("Fila Vazia!");
            return -1;
        }
        return primeiro.dado;
    }

    public boolean empty() {
        return contador == 0;
    }

    public int buscar(int posicao) {
        No aux = pesquisar(posicao);
        if (aux == null) {
            System.out.println("Posicao invalida");
            return -1;
        }
        return aux.dado;
    }

    public int tamanho() {
        return contador;
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
        No aux = primeiro;

        while (aux != null) {
            sb.append(aux.dado);
            if (aux.proximo != null) {
                sb.append(" ");
            }
            aux = aux.proximo;
        }

        return sb.toString();
    }
}
