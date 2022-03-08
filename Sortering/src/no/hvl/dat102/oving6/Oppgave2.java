package no.hvl.dat102.oving6;

public class Oppgave2 {

    // Utvalgssortering
    public static <T extends Comparable<T>> void utvalgsSortering(T[] data) {
        int minstePos;
        for (int i = 0; i < data.length - 1; i++) {
            minstePos = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[minstePos]) < 0) {
                    minstePos = j;
                }
            }
            T tmp = data[i];
            data[i] = data[minstePos];
            data[minstePos] = tmp;
        }
    }
    // Sortering ved innsetting
    public static <T extends Comparable<T>> void sorteringVedInnsetting(T[] data) {
        for (int i = 1; i < data.length; i++) {
            T nokkel = data[i];
            int p = i;

            while (p > 0 && nokkel.compareTo(data[p - 1]) < 0) {
                data[p] = data[p - 1];
                p--;
            }
            data[p] = nokkel;
        }
    }

    private static <T> void swap(T[] tab, int i, int j) {
        T tmp = tab[i];
        tab[i] = tab[j];
        tab[j] = tmp;
    }

    private static <T extends Comparable<T>> int finnPartisjon(T[] data, int min, int maks) {
        T temp, pivot;
        int midten = (min + maks) / 2;
        pivot = data[midten];
        swap(data, midten, min);

        int venstre = min + 1;
        int hoyre = maks;
        while (venstre < hoyre) {

            while (venstre < hoyre && data[venstre].compareTo(pivot) <= 0) {
                venstre++;
            }
            while (data[hoyre].compareTo(pivot) > 0) {
                hoyre--;
            }
            if (venstre < hoyre) {
                swap(data, venstre, hoyre);
            }
        }
        swap(data, min, hoyre);
        return hoyre;
    }

    // Kvikksortering
    public static <T extends Comparable<T>> void kvikkSort(T[] data, int min, int maks) {
        if (min < maks) {
            int posPivot = finnPartisjon(data, min, maks);
            kvikkSort(data, min, posPivot - 1);
            kvikkSort(data, posPivot + 1, maks);
        }
    }

    private static <T extends Comparable<T>> void flette(T[] tabell, int forste, int midten, int siste) {

        int storrelse = siste - forste + 1;
        T[] hjelpeTabell =  (T[]) (new Comparable[storrelse]);

        int forsteV = forste;
        int sisteV = midten;
        int forsteH = midten + 1;
        int sisteH = siste;

        int h = 0;

        while (forsteV <= sisteV && forsteH <= sisteH) {
            if (tabell[forsteV].compareTo(tabell[forsteH]) <= 0) {
                hjelpeTabell[h] = tabell[forsteV];
                forsteV++;
            } else {
                hjelpeTabell[h] = tabell[forsteH];
                forsteH++;
            }
            h++;
        }

        while (forsteV <= sisteV) {
            hjelpeTabell[h] = tabell[forsteV];
            forsteV++;
            h++;
        }

        while (forsteH <= sisteH) {
            hjelpeTabell[h] = tabell[forsteH];
            forsteH++;
            h++;
        }

        h = 0;
        for (int indeks = forste; indeks <= siste; indeks++) {
            tabell[indeks] = hjelpeTabell[h];
            h++;
        }
    }

    // Flettesortering
    public static <T extends Comparable<T>> void fletteSort(T[] tabell, int forste, int siste) {
        if (forste < siste) {
            int midten = (forste + siste) / 2;
            fletteSort(tabell, forste, midten);
            fletteSort(tabell, midten + 1, siste);
            flette(tabell, forste, midten, siste);
        }
    }

    public static void main(String[] args) {
        Integer[] tab = { 69, 96, 21, 36, 78, 666, 999, 23, 54, 1 };
        // utvalgsSortering(tab);
        // sorteringVedInnsetting(tab);
        //fletteSort(tab, 0, tab.length - 1);
        kvikkSort(tab, 0, tab.length -1);

        for (Integer e : tab) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}


