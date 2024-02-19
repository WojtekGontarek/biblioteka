import ksiazka.Autor;
import ksiazka.Gatunek;
import ksiazka.Ksiazka;
import wypozyczenie.Egzemplarz;
import wypozyczenie.Wypozyczenie;

import java.util.ArrayList;

public class Biblioteka {
    ArrayList<Ksiazka> ksiazki = new ArrayList<>();
    ArrayList<Egzemplarz> egzemplarze = new ArrayList<>();
    ArrayList<Wypozyczenie> wypozyczenia = new ArrayList<>();

    public Ksiazka wyszukajKsiazke(String tytul){
        for (Ksiazka ksiazka: ksiazki) {
            if (ksiazka.getTytul().equals(tytul)) return ksiazka;
        }
        return null;
    }
    public ArrayList<Ksiazka> wyszukajKsiazke(Autor autor){
        ArrayList<Ksiazka> znalezioneKsiazki = new ArrayList<>();
        for (Ksiazka ksiazka: ksiazki) {
            if (ksiazka.getAutor().equals(autor)) znalezioneKsiazki.add(ksiazka);
        }

        return (znalezioneKsiazki.isEmpty()) ? null : znalezioneKsiazki;
    }
    public ArrayList<Ksiazka> wyszukajKsiazke(Gatunek gatunek){
        ArrayList<Ksiazka> znalezioneKsiazki = new ArrayList<>();
        for (Ksiazka ksiazka: ksiazki) {
            if (ksiazka.getGatunek().equals(gatunek)) znalezioneKsiazki.add(ksiazka);
        }

        return (znalezioneKsiazki.isEmpty()) ? null : znalezioneKsiazki;
    }
    public Egzemplarz wyszukajWolnyEgzeplarz(Ksiazka szukanaKsiazka){
        for (Egzemplarz egzemplarz: egzemplarze) {
            if (egzemplarz.getKsiazka().equals(szukanaKsiazka)
                    && egzemplarz.getStan() == Egzemplarz.Stan.WOLNY) return egzemplarz;
        }
        return null;

    }

}
