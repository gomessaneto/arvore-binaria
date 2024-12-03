package ab;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Inserindo valores na árvore
        System.out.println("Inserindo valores na árvore...");
        int[] valores = {50, 30, 70, 20, 40, 60, 80};
        for (int valor : valores) {
            arvore.inserir(valor);
            System.out.println("Valor inserido: " + valor);
        }

        // Exibindo a árvore em ordem
        arvore.percorrerEmOrdem();

        // Encontrar o menor valor
        System.out.println("Menor valor na árvore: " + arvore.encontrarMenor());

        // Encontrar o maior valor
        System.out.println("Maior valor na árvore: " + arvore.encontrarMaior());

        // Remover o menor valor
        System.out.println("Removendo o menor valor...");
        arvore.removerMenor();
        System.out.println("Novo menor valor: " + arvore.encontrarMenor());
        arvore.percorrerEmOrdem();

        // Exibir a altura da árvore
        System.out.println("Altura da árvore: " + arvore.calcularAltura());
    }
}