public class QuickSort {
    public static void main(String[] args) {
        int[] tamanhos = {10000, 100000, 1000000};

        for (int tamanho : tamanhos) {
            System.out.println("Tamanho do vetor: " + tamanho);

            int[] vetorA = new int[tamanho];
            int[] vetorB = new int[tamanho];
            int[] vetorC = new int[tamanho];

            for (int i = 0; i < tamanho; i++) {
                vetorA[i] = (int) (Math.random() * tamanho);
                vetorB[i] = vetorA[i]; 
                vetorC[i] = vetorA[i]; 
            }

            String[] metodosPivo = {"a", "b", "c"};
            for (String metodo : metodosPivo) {
                long tempoInicial = System.currentTimeMillis();

                int[] vetorTemporario;
                if (metodo.equals("a")) {
                    vetorTemporario = vetorA;
                } else if (metodo.equals("b")) {
                    vetorTemporario = vetorB;
                } else {
                    vetorTemporario = vetorC;
                }

                quickSort(vetorTemporario, 0, vetorTemporario.length - 1, metodo);

                long tempoFinal = System.currentTimeMillis();

                System.out.println("Tempo de execução para o método " + metodo + ": " + (tempoFinal - tempoInicial) + " ms");
            }
            System.out.println();
            System.out.println("---------------------------------");
            System.out.println();
        }
    }

    public static void quickSort(int[] vetor, int primeiro, int ultimo, String metodoPivo) {
        if (primeiro < ultimo) {
            int indicePivo = separar(vetor, primeiro, ultimo, metodoPivo);

            quickSort(vetor, primeiro, indicePivo - 1, metodoPivo);
            quickSort(vetor, indicePivo + 1, ultimo, metodoPivo);
        }
    }

    public static int escolherPivo(int[] vetor, int primeiro, int ultimo, String metodo) {
        switch (metodo) {
            case "a":
                return vetor[primeiro]; 
            case "b":
                return vetor[ultimo];
            case "c":
                int meio = primeiro + (ultimo - primeiro) / 2;
                return vetor[meio];
            default:
                return vetor[primeiro];
        }
    }

    public static int separar(int[] vetor, int primeiro, int ultimo, String metodoPivo) {
        int pivo = escolherPivo(vetor, primeiro, ultimo, metodoPivo);
        int i = primeiro + 1, f = ultimo;

        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }

        vetor[primeiro] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
}
