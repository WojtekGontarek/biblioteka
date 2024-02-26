import ksiazka.Autor;
import ksiazka.Ksiazka;
import wypozyczenie.Egzemplarz;
import wypozyczenie.Wypozyczenie;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteka biblioteka = new Biblioteka();
        Scanner scanner = new Scanner(System.in);
        String menu = "1. wyszukaj ksiazke autora\n"+
                "2 dodaj egzemplarz\n"+
                "3 pozycz ksiazke\n"+
                "4 oddaj ksiazke\n"+
                "5 wyjscie"
        ;

        while (true){
            System.out.println("Wybierz:");
            System.out.println(menu);
            int wybor = scanner.nextInt();
            scanner.nextLine();
            switch (wybor){
                case 1:
                    Autor szukanyAutor = biblioteka.stworzAutora();
                    biblioteka.wyszukajKsiazke(szukanyAutor);
                    break;
                case 2:
                    biblioteka.dodajKsiazke();
                    break;
                case 3:
                    Egzemplarz wypozyczanaKsiazka = biblioteka.wyszukajWolnyEgzeplarz(biblioteka.wyszukajKsiazke(scanner.nextLine()));
                    if (wypozyczanaKsiazka==null) {
                        System.out.println("Nie ma wolnego egzemplarza tej ksiazki");
                        break;
                    }
                    Wypozyczenie wypozyczenie = new Wypozyczenie(wypozyczanaKsiazka);
                    break;
                case 4:
                    String tytulOddawanejKsiazki = scanner.nextLine();

                    for (Wypozyczenie w :
                            biblioteka.wypozyczenia) {
                        if (Objects.equals(w.getTytulKsiazki(), tytulOddawanejKsiazki)){
                            double kara = w.oddaj();
                            if (kara>0){
                                System.out.println("oddałeś ksiażke za późno. kara: "+String.valueOf(kara));
                                break;
                            }
                            System.out.println("Ksiazka oddaja prawidlowo");
                            break;
                        }
                    }
                case 5:
                    return;

            }
        }

    }
}