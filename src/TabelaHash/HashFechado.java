package TabelaHash;

import Lista.ListaDinamica;

public class HashFechado {
    private ListaDinamica[] tabela;

    public HashFechado() {
        this(10);
    }

    public HashFechado(int n) {
        this.tabela = new ListaDinamica[n];
    }

    private int posicaoDe(int elemento) {
        return Math.floorMod(elemento, tabela.length);
    }

    public void add(int elemento) {
        int posicao = posicaoDe(elemento);

        if (tabela[posicao] == null) {
            tabela[posicao] = new ListaDinamica();
        }

        tabela[posicao].adicionar(elemento);
    }

    public void remove(int elemento) {
        int posicao = posicaoDe(elemento);

        if (tabela[posicao] == null) {
            return;
        }

        int indice = tabela[posicao].indiceDe(elemento);

        if (indice != -1) {
            tabela[posicao].remover(indice);
        }
    }

    public boolean contem(int elemento) {
        int posicao = posicaoDe(elemento);

        if (tabela[posicao] == null) {
            return false;
        }

        return tabela[posicao].contem(elemento);
    }

    public int tamanho() {
        int total = 0;

        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {
                total += tabela[i].tamanho();
            }
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tabela.length; i++) {
            sb.append("(").append(i).append("): ");

            if (tabela[i] != null) {
                sb.append(tabela[i]);
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
