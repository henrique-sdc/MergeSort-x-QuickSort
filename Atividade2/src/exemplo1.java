import java.io.IOException;

public class exemplo1 {

    public static void main(String[] args) throws IOException {

        int quantidade = 100000;
        int[] vetor = new int[quantidade];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * quantidade);
        }

        long tempoInicial, tempoFinal;

        // QuickSort com pivô sendo o primeiro elemento do vetor
        tempoInicial = System.currentTimeMillis();
        quickSortFirst(vetor, 0, vetor.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("QuickSort com pivô sendo o primeiro elemento: " + (tempoFinal - tempoInicial) + " ms");

        // QuickSort com pivô sendo o último elemento do vetor
        tempoInicial = System.currentTimeMillis();
        quickSortLast(vetor, 0, vetor.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("QuickSort com pivô sendo o último elemento: " + (tempoFinal - tempoInicial) + " ms");

        // QuickSort com pivô sendo o elemento do meio do vetor
        tempoInicial = System.currentTimeMillis();
        quickSortMiddle(vetor, 0, vetor.length - 1);
        tempoFinal = System.currentTimeMillis();
        System.out.println("QuickSort com pivô sendo o elemento do meio: " + (tempoFinal - tempoInicial) + " ms");
    }

    private static void quickSortFirst(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separarFirst(vetor, inicio, fim);
            quickSortFirst(vetor, inicio, posicaoPivo - 1);
            quickSortFirst(vetor, posicaoPivo + 1, fim);
        }
    }

    private static void quickSortLast(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separarLast(vetor, inicio, fim);
            quickSortLast(vetor, inicio, posicaoPivo - 1);
            quickSortLast(vetor, posicaoPivo + 1, fim);
        }
    }

    private static void quickSortMiddle(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separarMiddle(vetor, inicio, fim);
            quickSortMiddle(vetor, inicio, posicaoPivo - 1);
            quickSortMiddle(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int separarFirst(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
            else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

    private static int separarLast(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim];
        int i = inicio, f = fim - 1;
        while (i <= f) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[f])
                f--;
            else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[fim] = vetor[i];
        vetor[i] = pivo;
        return i;
    }

    private static int separarMiddle(int[] vetor, int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        int pivo = vetor[meio];
        int i = inicio, f = fim;
        while (i <= f) {
            while (vetor[i] < pivo)
                i++;
            while (vetor[f] > pivo)
                f--;
            if (i <= f) {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        return i;
    }
}
