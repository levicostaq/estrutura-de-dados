package Lista;

public class ListaDinamica {
    private No primeiro;
    private No ultimo;
    private int contador;

    public ListaDinamica() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public void adicionar(int elemento) {
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

    public void adicionar(int posicao, int elemento) {
        if (posicao < 0 || posicao > contador) {
            System.out.println("Posicao invalida");
            return;
        }

        if (posicao == contador) {
            adicionar(elemento);
            return;
        }

        No novo = new No(elemento);

        if (posicao == 0) {
            novo.proximo = primeiro;
            primeiro.anterior = novo;
            primeiro = novo;
            contador++;
            return;
        }

        No anterior = pesquisar(posicao - 1);
        No seguinte = anterior.proximo;

        novo.anterior = anterior;
        novo.proximo = seguinte;
        anterior.proximo = novo;
        seguinte.anterior = novo;

        contador++;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= contador) {
            System.out.println("Posicao invalida");
            return;
        }

        No alvo = pesquisar(posicao);

        if (alvo.anterior == null) {
            primeiro = alvo.proximo;
        } else {
            alvo.anterior.proximo = alvo.proximo;
        }

        if (alvo.proximo == null) {
            ultimo = alvo.anterior;
        } else {
            alvo.proximo.anterior = alvo.anterior;
        }

        contador--;
    }

    public void remover() {
        if (contador == 0) {
            System.out.println("Lista vazia");
            return;
        }
        remover(contador - 1);
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

    public int buscar(int posicao) {
        No aux = pesquisar(posicao);
        if (aux == null) {
            System.out.println("Posicao invalida");
            return -1;
        }
        return aux.dado;
    }

    public int indiceDe(int elemento) {
        No aux = primeiro;
        int i = 0;

        while (aux != null) {
            if (aux.dado == elemento) {
                return i;
            }
            aux = aux.proximo;
            i++;
        }
        return -1;
    }

    public int tamanho() {
        return contador;
    }

    public void limpar() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public boolean contem(int elemento) {
        return indiceDe(elemento) != -1;
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
