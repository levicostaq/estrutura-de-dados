package FilaDePrioridade;

public class FilaNaoOrdernada {
    private NoP primeiro;
    private NoP ultimo;
    private int contador;


    public FilaNaoOrdernada() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public void enqueque(String elemento, int prioridade) {
        NoP novo = new NoP(elemento, prioridade);

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
        if(contador == 0) {
            return;
        }
        NoP aux = primeiro;
        NoP alvo = primeiro;

        while (aux != null) {
            if (aux.prioridade < alvo.prioridade) {
                alvo = aux;
            }
            aux = aux.proximo;
        }
        if(alvo != primeiro) {
             alvo.anterior.proximo = alvo.proximo;
        } else {
            primeiro = primeiro.proximo;
        }

        if(alvo != ultimo) {
            alvo.proximo.anterior = alvo.anterior;
        } else {
            ultimo = ultimo.anterior;
        }

        contador--;


    }

    public NoP pesquisar(int posicao) {
        NoP aux = primeiro;


        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }
        return aux;
    }

    public NoP pesquisarPrioridade(int prioridade) {
        NoP aux = primeiro;


        while(aux != null && aux.prioridade != prioridade) {
            aux = aux.proximo;
        }
        return aux;
    }

    public NoP buscar(int posicao) {
        return pesquisar(posicao);
    }

    public int tamanho() {
        return contador;
    }

    public void limpar() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public boolean contem(String elemento) {
        NoP aux = primeiro;
        while (aux != null) {
            if (aux.dado.equals(elemento)) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    public void exibir() {
        NoP aux = primeiro;
        while(aux != null) {
            System.out.print(aux.dado + "(" + aux.prioridade + ") ");
            aux = aux.proximo;
        }
        System.out.println();
    }
}
