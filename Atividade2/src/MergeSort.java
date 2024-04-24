import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] tamanhos = {10000, 100000, 1000000}; 

        System.out.println("Vetores gerados com valores aleatórios:");
        for (int tamanho : tamanhos) {
            int[] vetor = valoresAleatorios(tamanho);
            long comeco = System.currentTimeMillis();
            mergeSort(vetor, 0, vetor.length - 1);
            long fim = System.currentTimeMillis();
            System.out.println("Vetor de tamanho " + tamanho + " gerado aleatoriamente: " + (fim - comeco) + " ms");
        }
        System.out.println("-------------------------");

        System.out.println("Vetores gerados em ordem decrescente:");
        for (int tamanho : tamanhos) {
            int[] vetor = valoresEmOrdemDescrescente(tamanho);
            long comeco = System.currentTimeMillis();
            mergeSort(vetor, 0, vetor.length - 1);
            long fim = System.currentTimeMillis();
            System.out.println("Vetor de tamanho " + tamanho + " gerado em ordem decrescente: " + (fim - comeco) + " ms");
        }
        System.out.println("-------------------------");

        System.out.println("Tempo de execução do Mergesort para vetores ordenados:");
        for (int tamanho : tamanhos) {
            int[] vetor = valoresVetorOrdenado(tamanho);

            long comeco = System.currentTimeMillis();
            mergeSort(vetor, 0, vetor.length - 1);
            long fim = System.currentTimeMillis();

            System.out.println("Mergesort executado em um vetor de tamanho " + tamanho + " ordenado em ordem crescente: " + (fim - comeco) + " ms");
        }
        System.out.println("-------------------------");
    }

    public static void mergeSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            mergeSort(vetor, esquerda, meio);
            mergeSort(vetor, meio + 1, direita);

            mesclar(vetor, esquerda, meio, direita);
        }
    }

    public static void mesclar(int[] vetor, int esquerda, int meio, int direita) {
        int p1 = meio - esquerda + 1;
        int p2 = direita - meio;

        int[] L = new int[p1];
        int[] R = new int[p2];

        for (int i = 0; i < p1; i++)
            L[i] = vetor[esquerda + i];
        for (int j = 0; j < p2; j++)
            R[j] = vetor[meio + 1 + j];

        int i = 0, j = 0;

        int k = esquerda;
        while (i < p1 && j < p2) {
            if (L[i] <= R[j]) {
                vetor[k] = L[i];
                i++;
            } else {
                vetor[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < p1) {
            vetor[k] = L[i];
            i++;
            k++;
        }

        while (j < p2) {
            vetor[k] = R[j];
            j++;
            k++;
        }
    }

    public static int[] valoresVetorOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i; 
        }
        return vetor;
    }

    public static int[] valoresEmOrdemDescrescente(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - i; 
        }
        return vetor;
    }

    public static int[] valoresAleatorios(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(); 
        }
        return vetor;
    }
}