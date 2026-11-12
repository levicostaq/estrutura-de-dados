package Pilha;

public class PilhaEstatica {
    private int contador;
    private int vetor[];

    public PilhaEstatica() {
        this(10);
    }

    public PilhaEstatica(int n) {
        vetor = new int[n];
        contador = 0;
    }

    public void empilhar(int n) {
        if (contador == vetor.length) {
            System.out.println("Pilha cheia");
            return;
        }
        vetor[contador] = n;
        contador++;
    }

    public void desempilhar() {
        if (contador == 0) {
            System.out.println("Pilha vazia");
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

    public boolean contem(int elemento) {
        for (int i = 0; i < contador; i++) {
            if (vetor[i] == elemento) {
                return true;
            }
        }
        return false;
    }

    public void limpar() {
        contador = 0;
    }

    public int tamanho() {
        return contador;
    }

    public int topo() {
        if (contador == 0) {
            System.out.println("Pilha vazia");
            return -1;
        }
        return vetor[contador - 1];
    }

    public boolean vazia() {
        return contador == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = contador - 1; i >= 0; i--) {
            sb.append(vetor[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
