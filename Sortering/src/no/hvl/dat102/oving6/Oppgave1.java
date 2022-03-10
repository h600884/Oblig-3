package no.hvl.dat102.oving6;

import java.util.*;

public class Oppgave1 {

    // Tid: 6.8 + 12.7 + 6.6 + 6.6 + 6.5 + 9 + 6.6 + 6.6 + 6.6 + 9 / 10 = 7
    //sorterer ett tall av gangen.
    public static void Sorter(int[] tab) {
        int j, k;
        for (int i = 1; i < tab.length; i++) {
            j = i - 1;
            k = tab[i];

            while (j >= 0 && tab[j] > k) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = k;
        }
    }

    // Sorterer to tall av gangen
    public static void SorteringAvToEl(int[] tab) {
        int j, k, p;

        for (int i = 1; i < tab.length; i += 2) {
            j = i - 1;
            p = i - 2;
            k = tab[i];

            while (p >= 0 && tab[p] > k + 1) {
                tab[p + 1] = tab[p];
                p--;
            }
            tab[p + 1] = k + 1;

            while (j >= 1 && tab[j] > k) {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = k;
        }
    }

    // Setter inn et tilfeldig tall i en tabell.
    public static void RandomTab(int[] tab) {
        Random tilfeldig = new Random();

        for (int i = 0; i < tab.length; i++) {
            tab[i] = tilfeldig.nextInt(101);
        }
    }


    public static void main(String[] args) {
        // Lager en ny tabell med elementer som skal sorters
        int tab[] = new int[30];

        // Fyller tabellen med tilfeldige tall
        RandomTab(tab);

        // Finner ut tiden det tar for å kjøre programmet
        double startTid = System.nanoTime();

        // Sorterer tabellen i stigende rekkefølge
        //Sorter(tab);
        SorteringAvToEl(tab);

        double sluttTid = System.nanoTime();
        double totalTid = sluttTid - startTid;

        double totalTidISek = totalTid / 1_000_000_000;

        // Skriver ut antall sekunder det tar for å kjøre programmet
        System.out.println(String.format("%.2f", totalTidISek) + " Sekunder");

        //Skriver ut tabellen etter den er sortert
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
    }
}
