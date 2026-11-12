package Fila;

public class FilaEstatica {
    private Object[] v;

    private int ini = 0;
    private int fim = -1;

    public FilaEstatica() {
        this(10);
    }

    public FilaEstatica(int n) {
        v = new Object[n];
    }

    public void enqueque(Object elemento) {
        if (fim == v.length - 1) {
            System.out.println("Fila cheia");
            return;
        }
        fim++;
        v[fim] = elemento;
    }

    public void dequeque() {
        if (estaVazia()) {
            System.out.println("Fila vazia");
            return;
        }
        ini++;
    }

    public Object peek() {
        if (estaVazia()) {
            System.out.println("Fila vazia");
            return null;
        }
        return v[ini];
    }

    public int tamanho() {
        if (estaVazia()) {
            return 0;
        }
        return fim - ini + 1;
    }

    public boolean estaVazia() {
        return ini > fim;
    }

    public void clear() {
        ini = 0;
        fim = -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = ini; i <= fim; i++) {
            sb.append(v[i]);
            if (i < fim) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
