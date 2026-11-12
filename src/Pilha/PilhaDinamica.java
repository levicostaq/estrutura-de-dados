package Pilha;

public class PilhaDinamica {
    private No topo = null;
    private int cont = 0;

    public void push(int elemento) {
        No novo = new No(elemento);

        if(topo != null) {
            novo.anterior = topo;
            topo.proximo = novo;
        }
        topo = novo;
        cont++;

    }

    public void pop() {

        if(cont == 0) {
            System.out.println("Pilha esta vazia.");
            return;
        }

        topo = topo.anterior;

        if(topo != null) {
            topo.proximo = null;
        }
        cont--;
    }

    public boolean empty() {
        return cont == 0;
    }

    public int peek() {
        if(cont == 0) {
            return -1;
        }
        return topo.dado;
    }

    public int size() {
        return cont;
    }

    public void clear() {
        topo = null;
        cont = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        No aux = topo;

        while(aux != null) {
            sb.append(aux.dado);
            if(aux.anterior != null) {
                sb.append(" ");
            }
            aux = aux.anterior;
        }

        return sb.toString();

    }


}
