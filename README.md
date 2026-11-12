# Estruturas de Dados em Java

Implementações das estruturas de dados clássicas feitas do zero em Java, sem usar as coleções prontas da linguagem (`ArrayList`, `LinkedList`, `Stack`, `Queue`, `HashMap`).

Cada estrutura aparece nas duas formas: **estática**, com arranjo de tamanho fixo e controle de ocupação, e **dinâmica**, encadeada por nós. A ideia é poder comparar as duas lado a lado e entender onde cada uma ganha.

Projeto desenvolvido ao longo da disciplina de Estruturas de Dados na Universidade de Fortaleza (UNIFOR).

---

## Estruturas implementadas

| Pacote | Classes | Descrição |
|---|---|---|
| `Lista` | `ListaEstatica`, `ListaDinamica`, `No` | Inserção e remoção em qualquer posição, busca por índice e por elemento |
| `Pilha` | `PilhaEstatica`, `PilhaDinamica`, `No` | Estrutura LIFO: o último a entrar é o primeiro a sair |
| `Fila` | `FilaEstatica`, `FilaDinamica`, `No` | Estrutura FIFO: o primeiro a entrar é o primeiro a sair |
| `FilaDePrioridade` | `FilaOrdenada`, `FilaNaoOrdernada`, `NoP` | A saída segue a prioridade do elemento, não a ordem de chegada |
| `TabelaHash` | `HashFechado` | Tabela hash com encadeamento: cada posição guarda uma lista dinâmica |

---

## Estática e dinâmica

A diferença entre as duas versões não é de estilo, é de custo.

A **estática** guarda tudo num arranjo de tamanho fixo e usa uma variável de ocupação para saber onde a estrutura termina. Acessar uma posição é imediato, porque o endereço é calculado. Em compensação, inserir ou remover no começo obriga a deslocar todo o resto, e a estrutura tem um teto: enche.

A **dinâmica** cria um nó por elemento, cada um apontando para o próximo. Não tem teto e inserir no começo custa sempre o mesmo, porque é só trocar uma referência. O preço é que chegar à posição N significa percorrer N nós, e cada nó gasta memória a mais para guardar a referência.

| Operação | Estática | Dinâmica |
|---|---|---|
| Acessar posição N | O(1) | O(n) |
| Inserir no início | O(n) | O(1) |
| Inserir no fim | O(1) | O(1) |
| Remover do início | O(n) | O(1) |
| Buscar por valor | O(n) | O(n) |

> A inserção no fim da lista dinâmica é O(1) porque a classe guarda uma referência para o último nó. Sem ela, seria O(n).

Na fila de prioridade a troca aparece de outro jeito. A **ordenada** paga na inserção, porque precisa achar o lugar certo do elemento, e a remoção é imediata. A **não ordenada** insere direto no fim e paga na remoção, que precisa varrer tudo para achar a maior prioridade.

| Operação | Ordenada | Não ordenada |
|---|---|---|
| Inserir | O(n) | O(1) |
| Remover o mais prioritário | O(1) | O(n) |

Na tabela hash, a posição do elemento é calculada a partir do próprio valor, então a busca não depende do tamanho da estrutura. Quando dois elementos caem na mesma posição, eles ficam encadeados numa lista. O custo médio é O(1), mas degrada para O(n) se todos colidirem na mesma posição.

---

## Como executar

Requer JDK 17 ou superior.

```bash
git clone https://github.com/levicostaq/estrutura-de-dados.git
cd estrutura-de-dados/src
javac -d ../out $(find . -name "*.java")
java -cp ../out Main
```

A classe `Main` exercita todas as estruturas e imprime o resultado de cada operação, incluindo os casos de borda: lista cheia, fila vazia, posição inválida.

---

## Em andamento

- `HeapMax` — heap máximo com subida e descida
- Árvore binária de busca
- Grafos com busca em largura e profundidade

---

## Licença

MIT
