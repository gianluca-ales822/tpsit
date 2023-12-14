package it.edu.iisgubbio;

public class Priorità {

    public static void main(String[] args) {
        String[] processo = new String[4];
        int[] tArrivo = new int[4];
        int[] tEse = new int[4];
        int[] tServizio = new int[4];
        int[] priorità = new int[4];
        double[] tAttesa = new double[4];
        double media = 0;

        processo[0] = "P0";
        processo[1] = "P1";
        processo[2] = "P2";
        processo[3] = "P3";

        tArrivo[0] = 0;
        tArrivo[1] = 1;
        tArrivo[2] = 2;
        tArrivo[3] = 3;

        tEse[0] = 5;
        tEse[1] = 3;
        tEse[2] = 8;
        tEse[3] = 6;

        priorità[0] = 1;
        priorità[1] = 2;
        priorità[2] = 1;
        priorità[3] = 3;

        // Ordina i processi in base alla priorità (ordine decrescente)
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3 - x; y++) {
                if (priorità[y] < priorità[y + 1]) {
                    // Scambia i valori di priorità e gli altri relativi ai processi
                    int timePriorità = priorità[y];
                    priorità[y] = priorità[y + 1];
                    priorità[y + 1] = timePriorità;

                    // Scambia i valori degli altri array corrispondenti ai processi
                    String timeProcesso = processo[y];
                    processo[y] = processo[y + 1];
                    processo[y + 1] = timeProcesso;

                    int tempArrivo = tArrivo[y];
                    tArrivo[y] = tArrivo[y + 1];
                    tArrivo[y + 1] = tempArrivo;

                    int tempoEse = tEse[y];
                    tEse[y] = tEse[y + 1];
                    tEse[y + 1] = tempoEse;
                }
            }
        }

        // Calcola i tempi di servizio, attesa e la media totale
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                tServizio[0] = 0;
                tAttesa[0] = 0;
            } else {
                tServizio[i] = tServizio[i - 1] + tEse[i - 1];
                tAttesa[i] = tServizio[i] - tArrivo[i];
                media = media + tAttesa[i] / 4;
            }
            System.out.println("Processo: " + processo[i]);
            System.out.println("Priorità: " + priorità[i]);
			System.out.println("Tempo di arrivo: " + tArrivo[i]);
			System.out.println("Tempo di Esecuzione: " + tEse[i]);
			System.out.println("Tempo di servizio: "+tServizio[i]);
			System.out.println("Tempo di attesa: "+tAttesa[i]);
        }
        System.out.println("Media tempi di attesa: "+media);
    }
}
