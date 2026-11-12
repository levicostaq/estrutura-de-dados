import Lista.ListaDinamica;
import Lista.ListaEstatica;
import Pilha.PilhaDinamica;
import Pilha.PilhaEstatica;
import Fila.FilaDinamica;
import Fila.FilaEstatica;
import FilaDePrioridade.FilaOrdenada;
import FilaDePrioridade.FilaNaoOrdernada;
import TabelaHash.HashFechado;

public class Main {

    public static void main(String[] args) {
        testarListaEstatica();
        testarListaDinamica();
        testarPilhaEstatica();
        testarPilhaDinamica();
        testarFilaEstatica();
        testarFilaDinamica();
        testarFilaOrdenada();
        testarFilaNaoOrdenada();
        testarTabelaHash();
    }

    private static void titulo(String t) {
        System.out.println();
        System.out.println("===== " + t + " =====");
    }

    // ---------------------------------------------------------------- LISTA

    private static void testarListaEstatica() {
        titulo("Lista Estatica");

        ListaEstatica lista = new ListaEstatica(5);
        lista.adicionar(7);
        lista.adicionar(3);
        lista.adicionar(5);
        System.out.println("Depois de adicionar 7, 3 e 5: " + lista);

        lista.adicionar(0, 10);
        System.out.println("Inserindo 10 na posicao 0:    " + lista);

        lista.remover(2);
        System.out.println("Removendo a posicao 2:        " + lista);

        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println("Contem 5? " + lista.contem(5));
        System.out.println("Contem 99? " + lista.contem(99));
        System.out.println("Posicao invalida devolve: " + lista.buscar(50));
    }

    private static void testarListaDinamica() {
        titulo("Lista Dinamica");

        ListaDinamica lista = new ListaDinamica();
        lista.adicionar(7);
        lista.adicionar(3);
        lista.adicionar(5);
        System.out.println("Depois de adicionar 7, 3 e 5: " + lista);

        lista.adicionar(0, 10);
        System.out.println("Inserindo 10 na posicao 0:    " + lista);

        lista.adicionar(2, 99);
        System.out.println("Inserindo 99 na posicao 2:    " + lista);

        lista.remover(0);
        System.out.println("Removendo a posicao 0:        " + lista);

        lista.remover();
        System.out.println("Removendo o ultimo:           " + lista);

        System.out.println("Tamanho: " + lista.tamanho());
        System.out.println("Indice do 99: " + lista.indiceDe(99));
        System.out.println("Contem 7? " + lista.contem(7));
    }

    // ---------------------------------------------------------------- PILHA

    private static void testarPilhaEstatica() {
        titulo("Pilha Estatica");

        PilhaEstatica pilha = new PilhaEstatica(3);
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);
        System.out.println("Do topo para a base: " + pilha);
        System.out.println("Topo: " + pilha.topo());

        pilha.empilhar(4);

        pilha.desempilhar();
        System.out.println("Depois de desempilhar: " + pilha);
        System.out.println("Tamanho: " + pilha.tamanho() + " | Vazia? " + pilha.vazia());
    }

    private static void testarPilhaDinamica() {
        titulo("Pilha Dinamica");

        PilhaDinamica pilha = new PilhaDinamica();
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        System.out.println("Do topo para a base: " + pilha);
        System.out.println("Topo: " + pilha.peek() + " | Tamanho: " + pilha.size());

        pilha.pop();
        System.out.println("Depois de pop: " + pilha);

        pilha.pop();
        pilha.pop();
        System.out.println("Pilha vazia? " + pilha.empty());
        pilha.pop();
    }

    // ----------------------------------------------------------------- FILA

    private static void testarFilaEstatica() {
        titulo("Fila Estatica");

        FilaEstatica fila = new FilaEstatica(4);
        fila.enqueque("A");
        fila.enqueque("B");
        fila.enqueque("C");
        System.out.println("Fila: " + fila);
        System.out.println("Primeiro da fila: " + fila.peek() + " | Tamanho: " + fila.tamanho());

        fila.dequeque();
        System.out.println("Depois de dequeque: " + fila);
        System.out.println("Primeiro da fila: " + fila.peek() + " | Tamanho: " + fila.tamanho());

        fila.dequeque();
        fila.dequeque();
        System.out.println("Vazia? " + fila.estaVazia());
        fila.dequeque();
    }

    private static void testarFilaDinamica() {
        titulo("Fila Dinamica");

        FilaDinamica fila = new FilaDinamica();
        fila.enqueque(1);
        fila.enqueque(2);
        fila.enqueque(3);
        System.out.println("Fila: " + fila + " | Tamanho: " + fila.tamanho());
        System.out.println("Primeiro da fila: " + fila.peek());

        fila.dequeque();
        System.out.println("Depois de dequeque: " + fila + " | Tamanho: " + fila.tamanho());

        fila.dequeque();
        fila.dequeque();
        System.out.println("Vazia? " + fila.empty() + " | Tamanho: " + fila.tamanho());
        fila.dequeque();
    }

    // ----------------------------------------------- FILA DE PRIORIDADE

    private static void testarFilaOrdenada() {
        titulo("Fila de Prioridade Ordenada");

        FilaOrdenada fila = new FilaOrdenada();
        fila.enqueque("rotina", 5);
        fila.enqueque("urgente", 1);
        fila.enqueque("media", 3);
        fila.enqueque("baixa", 9);
        System.out.println("Ordenada na insercao: " + fila);

        System.out.println("Proximo a sair: " + fila.proximoElemento());
        fila.dequeque();
        System.out.println("Depois de dequeque:   " + fila);
        System.out.println("Tamanho: " + fila.tamanho());
    }

    private static void testarFilaNaoOrdenada() {
        titulo("Fila de Prioridade Nao Ordenada");

        FilaNaoOrdernada fila = new FilaNaoOrdernada();
        fila.enqueque("rotina", 5);
        fila.enqueque("urgente", 1);
        fila.enqueque("media", 3);
        System.out.print("Na ordem de chegada: ");
        fila.exibir();

        fila.dequeque();
        System.out.print("Depois de dequeque (sai a maior prioridade): ");
        fila.exibir();

        System.out.println("Tamanho: " + fila.tamanho());
        System.out.println("Contem 'media'? " + fila.contem("media"));
    }

    // --------------------------------------------------------- TABELA HASH

    private static void testarTabelaHash() {
        titulo("Tabela Hash com encadeamento");

        HashFechado tab = new HashFechado(8);
        tab.add(30);
        tab.add(13);
        tab.add(35);
        tab.add(21);
        tab.add(18);
        tab.add(47);
        tab.add(14);

        System.out.print(tab);
        System.out.println("Total de elementos: " + tab.tamanho());
        System.out.println("Contem 21? " + tab.contem(21));

        tab.remove(21);
        System.out.println("Depois de remover o 21, contem 21? " + tab.contem(21));
        System.out.println("Total de elementos: " + tab.tamanho());
    }
}
