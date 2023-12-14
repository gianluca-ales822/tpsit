package it.edu.iisgubbio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Process {
    String name;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int startTime;  // Aggiunto il tempo di inizio per calcolare il turnaround time
    int endTime;    // Aggiunto il tempo di fine per calcolare il turnaround time

    public Process(String name, int arrivalTime, int burstTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.startTime = -1;  // Inizializzato a -1 per indicare che il processo non è ancora iniziato
        this.endTime = -1;    // Inizializzato a -1 per indicare che il processo non è ancora terminato
    }
}

public class Round_Robin {
    public static List<String[]> roundRobin(List<Process> processes, int timeQuantum) {
        List<String[]> result = new ArrayList<>();
        int time = 0;
        Queue<Process> queue = new LinkedList<>();

        while (true) {
            // Aggiungi i processi che sono arrivati al tempo corrente alla coda
            for (Process process : processes) {
                if (process.arrivalTime <= time && !queue.contains(process) && process.remainingTime > 0) {
                    queue.add(process);
                }
            }

            // Esci dal ciclo se tutti i processi sono stati eseguiti
            if (processes.stream().allMatch(process -> process.remainingTime == 0)) {
                break;
            }

            // Esegui i processi nella coda con il time quantum
            if (!queue.isEmpty()) {
                Process currentProcess = queue.poll();
                if (currentProcess.startTime == -1) {
                    currentProcess.startTime = time;
                }
                int executionTime = Math.min(timeQuantum, currentProcess.remainingTime);
                currentProcess.remainingTime -= executionTime;
                time += executionTime;
                currentProcess.endTime = time;
                result.add(new String[]{currentProcess.name, String.valueOf(currentProcess.startTime), String.valueOf(currentProcess.endTime)});
            } else {
                // Se la coda è vuota, incrementa il tempo corrente
                time++;
            }
        }

        return result;
    }

    public static double calculateAverageTurnaroundTime(List<Process> processes) {
        int totalTurnaroundTime = 0;
        for (Process process : processes) {
            totalTurnaroundTime += (process.endTime - process.arrivalTime);
        }
        return (double) totalTurnaroundTime / processes.size();
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 0, 10));
        processes.add(new Process("P2", 2, 5));
        processes.add(new Process("P3", 4, 8));
        processes.add(new Process("P4", 6, 4));

        int timeQuantum = 3;
        List<String[]> schedule = roundRobin(processes, timeQuantum);

        // Stampare il risultato
        System.out.println("Processo\tTempo Inizio\tTempo Fine");
        for (String[] entry : schedule) {
            System.out.println(entry[0] + "\t\t" + entry[1] + "\t\t" + entry[2]);
        }

        // Calcola e stampa la media del turnaround time
        double averageTurnaroundTime = calculateAverageTurnaroundTime(processes);
        System.out.println("Media Turnaround Time: " + averageTurnaroundTime);
    }
}
