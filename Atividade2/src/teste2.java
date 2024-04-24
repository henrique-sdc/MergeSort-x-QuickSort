public class teste2 {
    public static void main(String[] args) {
        int tamanho = 100000;

        System.out.println("Tamanho do vetor: " + tamanho);

        int[] vetorAleatorio = new int[tamanho];
        int[] vetorCrescente = new int[tamanho];
        int[] vetorDecrescente = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetorAleatorio[i] = (int) (Math.random() * tamanho);
            vetorCrescente[i] = i;
            vetorDecrescente[i] = tamanho - i - 1;
        }

        String[] metodosPivo = {"a", "b", "c"};
        for (String metodo : metodosPivo) {
            long tempoInicial;
            long tempoFinal;

            int[] vetorTemporario = vetorAleatorio.clone();
            tempoInicial = System.currentTimeMillis();
            quickSort(vetorTemporario, 0, vetorTemporario.length - 1, metodo);
            tempoFinal = System.currentTimeMillis();
            System.out.println("Tempo de execução para o método " + metodo + " no vetor aleatório: " + (tempoFinal - tempoInicial) + " ms");

            vetorTemporario = vetorCrescente.clone();
            tempoInicial = System.currentTimeMillis();
            quickSort(vetorTemporario, 0, vetorTemporario.length - 1, metodo);
            tempoFinal = System.currentTimeMillis();
            System.out.println("Tempo de execução para o método " + metodo + " no vetor crescente: " + (tempoFinal - tempoInicial) + " ms");

            vetorTemporario = vetorDecrescente.clone();
            tempoInicial = System.currentTimeMillis();
            quickSort(vetorTemporario, 0, vetorTemporario.length - 1, metodo);
            tempoFinal = System.currentTimeMillis();
            System.out.println("Tempo de execução para o método " + metodo + " no vetor decrescente: " + (tempoFinal - tempoInicial) + " ms");
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