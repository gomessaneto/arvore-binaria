package ab;

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        raiz = null; // Inicializa a árvore vazia
    }

    // Método para inserir valores na árvore
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No no, int valor) {
        if (no == null) {
            return new No(valor); // Cria um novo nodo
        }
        if (valor < no.valor) {
            no.esquerdo = inserirRecursivo(no.esquerdo, valor); // Inserir na subárvore esquerda
        } else if (valor > no.valor) {
            no.direito = inserirRecursivo(no.direito, valor); // Inserir na subárvore direita
        }
        return no; // Retorna o nodo atualizado
    }

    // Método para encontrar o menor valor na árvore
    public int encontrarMenor() {
        if (raiz == null) {
            throw new IllegalStateException("A árvore está vazia. Não é possível encontrar o menor valor.");
        }
        return encontrarMenorRecursivo(raiz);
    }

    private int encontrarMenorRecursivo(No no) {
        if (no.esquerdo == null) {
            return no.valor; // O menor valor está no nodo mais à esquerda
        }
        return encontrarMenorRecursivo(no.esquerdo);
    }

    // Método para encontrar o maior valor na árvore
    public int encontrarMaior() {
        if (raiz == null) {
            throw new IllegalStateException("A árvore está vazia. Não é possível encontrar o maior valor.");
        }
        return encontrarMaiorRecursivo(raiz);
    }

    private int encontrarMaiorRecursivo(No no) {
        if (no.direito == null) {
            return no.valor; // O maior valor está no nodo mais à direita
        }
        return encontrarMaiorRecursivo(no.direito);
    }

    // Método para remover o menor valor da árvore
    public void removerMenor() {
        if (raiz == null) {
            throw new IllegalStateException("A árvore está vazia. Não é possível remover o menor valor.");
        }
        raiz = removerMenorRecursivo(raiz);
    }

    private Nodo removerMenorRecursivo(No no) {
        if (no.esquerdo == null) {
            return no.direito; // Substitui o nodo pelo filho direito
        }
        no.esquerdo = removerMenorRecursivo(no.esquerdo); // Continua descendo à esquerda
        return no;
    }

    // Método para calcular a altura da árvore
    public int calcularAltura() {
        return calcularAlturaRecursivo(raiz);
    }

    private int calcularAlturaRecursivo(No no) {
        if (no == null) {
            return 0; // Árvore vazia tem altura 0
        }
        int alturaEsquerda = calcularAlturaRecursivo(no.esquerdo); // Altura da subárvore esquerda
        int alturaDireita = calcularAlturaRecursivo(no.direito); // Altura da subárvore direita
        return Math.max(alturaEsquerda, alturaDireita) + 1; // Retorna a maior altura + 1
    }

    // Método para exibir os valores da árvore (em ordem)
    public void percorrerEmOrdem() {
        System.out.print("Percorrendo a árvore (em ordem): ");
        percorrerEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void percorrerEmOrdemRecursivo(No no) {
        if (no != null) {
            percorrerEmOrdemRecursivo(no.esquerdo); // Visita o filho esquerdo
            System.out.print(no.valor + " "); // Imprime o valor do nodo
            percorrerEmOrdemRecursivo(no.direito); // Visita o filho direito
        }
    }
}