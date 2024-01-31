package gianluca.progetto;

import java.util.Random;

public class Griddy {
    // Dichiarazione delle variabili di istanza
    private int v1 = 5;
    private int v2 = 10;
    private int v3 = 11;
    private int v4 = 2;

    // Variabili per tenere traccia delle occorrenze
    private int countV1 = 0;
    private int countV2 = 0;
    private int countV3 = 0;
    private int countV4 = 0;
    private int discardedCount = 0;
    private int consecutiveCount = 0;
    private int repeatedPairsCount = 0;

    // Variabili per tenere traccia dell'ultimo numero estratto
    private int ultimoNumeroRandom = -1;
    private int lastLastRandomNumber = -1;

    public static void main(String[] args) {
        Griddy griddy = new Griddy(); // Creazione di un'istanza della classe Griddy
        griddy.playRandomVideos();    // Chiamata al metodo che avvia i video
    }

    public void playRandomVideos() {
        // Ciclo che continua fino a quando almeno una variabile è maggiore di zero
        while (v1 > 0 || v2 > 0 || v3 > 0 || v4 > 0) {
            int randomNumber;
            // Genera numeri casuali fino a quando non ne viene generato uno diverso dal precedente
            do {
                randomNumber = getRandomNumber();
            } while ((randomNumber == ultimoNumeroRandom && variabiliAzero()) || stessoNumeroDeSeguito(randomNumber));

            // Aggiornamento delle variabili di istanza
            lastLastRandomNumber = ultimoNumeroRandom;
            ultimoNumeroRandom = randomNumber;
            consecutiveCount++;

            System.out.println("Numero casuale " + randomNumber);
            // Switch che gestisce il decremento della variabile associata al numero generato
            switch (randomNumber) {
                case 1:
                    if (v1 > 0) {
                        v1--;
                        countV1++;
                        System.out.println("Uno");
                    } else {
                        discardedCount++;
                    }
                    break;
                case 2:
                    if (v2 > 0) {
                        v2--;
                        countV2++;
                        System.out.println("Due");
                    } else {
                        discardedCount++;
                    }
                    break;
                case 3:
                    if (v3 > 0) {
                        v3--;
                        countV3++;
                        System.out.println("Tre");
                    } else {
                        discardedCount++;
                    }
                    break;
                case 4:
                    if (v4 > 0) {
                        v4--;
                        countV4++;
                        System.out.println("Quattro");
                    } else {
                        discardedCount++;
                    }
                    break;
                default:
                    System.out.println("en ce");
            }

            // Puoi ora utilizzare v1, v2, v3, v4 al di fuori del main o di questo metodo
            System.out.println("v1: " + v1);
            System.out.println("v2: " + v2);
            System.out.println("v3: " + v3);
            System.out.println("v4: " + v4);

            // Controlla se sono stati estratti due numeri uguali di seguito
            if (randomNumber == lastLastRandomNumber) {
                repeatedPairsCount++;
                System.out.println("Coppia ripetuta!");
            }

            // Resetta il conteggio se il numero è diverso dall'ultimo
            if (randomNumber != ultimoNumeroRandom) {
                consecutiveCount = 0;
            }
        }

        // Stampa delle statistiche alla fine del gioco
        System.out.println("Tutte le variabili sono a 0. Fine del gioco.");
        System.out.println("Conteggio delle occorrenze:");
        System.out.println("Numero 1: " + countV1);
        System.out.println("Numero 2: " + countV2);
        System.out.println("Numero 3: " + countV3);
        System.out.println("Numero 4: " + countV4);
        System.out.println("Scartati a causa di variabili a 0: " + discardedCount);
        System.out.println("Coppie ripetute: " + repeatedPairsCount);
    }

    private int getRandomNumber() {
        // Utilizza la classe Random per generare un numero casuale tra 1 e 4
        return new Random().nextInt(4) + 1;
    }

    private boolean variabiliAzero() {
        // Verifica se tutte le variabili sono a 0
        return v1 == 0 && v2 == 0 && v3 == 0 && v4 == 0;
    }

    private boolean stessoNumeroDeSeguito(int currentNumber) {
        // Verifica se lo stesso numero è stato estratto due volte di seguito
        return consecutiveCount >= 2 && currentNumber == ultimoNumeroRandom;
    }
}
