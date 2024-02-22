import ksiazka.Autor;
import ksiazka.Gatunek;
import ksiazka.Ksiazka;
import wypozyczenie.Egzemplarz;
import wypozyczenie.Wypozyczenie;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteka {
    Scanner scanner = new Scanner(System.in);
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
    public void dodajKsiazke(){
        System.out.println("Podaj tytuł: ");
        String tytul = scanner.nextLine();
        System.out.println("Podaj gatunek (k -> kryminal; p -> populano-naukowe; f -> fantastyka; b -> biografia): ");
        Gatunek gatunek = switch (scanner.nextLine()){
            case "p" -> Gatunek.POPULARNO_NAUKOWE;
            case "f" -> Gatunek.FANTASTYKA;
            case "b" -> Gatunek.BIOGRAFIA;
            default -> Gatunek.KRYMINAL;
        };

        System.out.println("Podaj autora: ");
        Autor autor = stworzAutora();
        System.out.println("Podaj rok wydania: ");
        int rokWydania = Integer.parseInt(scanner.nextLine());
        Ksiazka nowaKsiazka = new Ksiazka(tytul, gatunek, autor, rokWydania);
        for (Ksiazka k :
                ksiazki) {
            if (k.equals(nowaKsiazka)){
                System.out.println("Ksiazka juz istnieje");
                return;
            }
        }
        ksiazki.add(nowaKsiazka);

    }
    public Autor stworzAutora(){
        System.out.println("Podaj imie autora: ");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko autora: ");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj rok urodzenia: ");
        int rokUrodzenia = Integer.parseInt(scanner.nextLine());
        System.out.println("Podaj rok smierci (jesli autor zyje wpisz 0): ");
        int rokSmierci = Integer.parseInt(scanner.nextLine());
        return new Autor(imie, nazwisko, rokUrodzenia, rokSmierci);
    }

}
