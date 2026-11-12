package Lista;

public class ListaEstatica {
    private int vetor[];
    private int contador;

    public ListaEstatica() {
        this(10);
    }

    public ListaEstatica(int n) {
        vetor = new int[n];
        contador = 0;
    }

    public void adicionar(int elemento) {
        if (contador == vetor.length) {
            System.out.println("Lista cheia");
            return;
        }
        vetor[contador] = elemento;
        contador++;
    }

    public void inserirNoFim(int valor) {
        adicionar(valor);
    }

    public void adicionar(int posicao, int elemento) {
        if (contador == vetor.length) {
            System.out.println("Lista cheia");
            return;
        }

        if (posicao < 0 || posicao > contador) {
            System.out.println("Posicao invalida");
            return;
        }

        for (int i = contador; i > posicao; i--) {
            vetor[i] = vetor[i - 1];
        }

        vetor[posicao] = elemento;
        contador++;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= contador) {
            System.out.println("Posicao invalida");
            return;
        }

        for (int i = posicao; i < contador - 1; i++) {
            vetor[i] = vetor[i + 1];
        }

        contador--;
    }

    public void remover() {
        if (contador == 0) {
            System.out.println("Lista vazia");
            return;
        }
        contador--;
    }

    public int buscar(int posicao) {
        if (posicao < 0 || posicao >= contador) {
            System.out.println("Posicao invalida");
            return -1;
        }
        return vetor[posicao];
    }

    public int tamanho() {
        return contador;
    }

    public void limpar() {
        contador = 0;
    }

    public boolean contem(int elemento) {
        for (int i = 0; i < contador; i++) {
            if (vetor[i] == elemento) {
                return true;
            }
        }
        return false;
    }

    public void exibir() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < contador; i++) {
            sb.append(vetor[i]);
            if (i < contador - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
