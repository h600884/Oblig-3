package no.hvl.dat102.oppgave1;

import java.util.*;

public class Oppgave1a {

    // Tid: 6.8 + 12.7 + 6.6 + 6.6 + 6.5 + 9 + 6.6 + 6.6 + 6.6 + 9 / 10 = 7
    //sorterer ett tall av gangen.
    public static void Sorter(int[] tab){
        int i,j,k;
        for(i = 1; i < tab.length; i++)
        {
            j = i-1;
            k = tab[i];

            while(j >= 0 && tab[j] > k)
            {
                tab[j + 1] = tab[j];
                j--;
            }
            tab[j + 1] = k;
        }
    }

    // setter inn random tall i en tabell.
    public static void RandomTab(int[]tab){
       Random tilfeldig = new Random();

        for (int i=0; i < tab.length; i++){
            tab[i] = tilfeldig.nextInt();
        }
    }


    public static void main(String[] args) {
         int tab[] = new int[300_000];
        RandomTab(tab);

        double startTid = System.nanoTime();
        Sorter(tab);
        double sluttTid = System.nanoTime();
        double totalTid = sluttTid - startTid;

        double totalTidISek = totalTid / 1_000_000_000;

        System.out.println(String.format("%.2f", totalTidISek) + " Sekunder");

//        for(int i =0; i<tab.length;i++) {
//            System.out.print(tab[i] + " ");
//         }

    }
}

