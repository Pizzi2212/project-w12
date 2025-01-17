package org.example;

import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        Archivio archivio = new Archivio();
        Scanner scanner = new Scanner(System.in);

        boolean continua = true;
        while (continua) {
            System.out.println("Scegli un'operazione:");
            System.out.println("1. Aggiungi elemento");
            System.out.println("2. Cerca per ISBN");
            System.out.println("3. Rimuovi elemento");
            System.out.println("4. Cerca per anno");
            System.out.println("5. Cerca per autore(libro)");
            System.out.println("6. Cerca per titolo");
            System.out.println("7. Cerca per genere(libro)");
            System.out.println("8. Cerca per periodicità(rivista)");
            System.out.println("9. Aggiorna elemento");
            System.out.println("10. Visualizza statistiche");
            System.out.println("0. Esci");


            int scelta = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (scelta) {
                    case 1:
                       // Aggiunta di un libro o una rivista
                        System.out.println("Che elemento vuoi inserire? 1:Libro -- 2:Rivista");
                        int tipologia = scanner.nextInt();
                        scanner.nextLine();
                        if (tipologia == 1) {
                            System.out.println("Inserisci ISBN:");
                            String isbn = scanner.nextLine();
                            System.out.println("Inserisci titolo:");
                            String titolo = scanner.nextLine();
                            System.out.println("Inserisci anno di pubblicazione:");
                            int anno = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci numero pagine:");
                            int pagine = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci autore:");
                            String autore = scanner.nextLine();
                            System.out.println("Inserisci genere:");
                            String genere = scanner.nextLine();
                            Libro libro = new Libro(isbn, titolo, anno, pagine, autore, genere);
                            archivio.aggiungi(libro);
                            System.out.println("Libro aggiunto con successo!");
                        }
                        else if (tipologia == 2){
                            System.out.println("Inserisci ISBN:");
                            String isbn = scanner.nextLine();
                            System.out.println("Inserisci titolo:");
                            String titolo = scanner.nextLine();
                            System.out.println("Inserisci anno di pubblicazione:");
                            int anno = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci numero pagine:");
                            int pagine = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci la periodicità (la periodicità può essere: settimanale, mensile o semestrale)");
                            String periodicita = scanner.nextLine();
                            Rivista rivista = new Rivista(isbn, titolo, anno, pagine, periodicita);
                            archivio.aggiungi(rivista);
                            System.out.println("Rivista aggiunta con successo!");

                        }else{
                            System.out.println("Tipologia non valida.");
                        }
                        break;
                    case 2:
                        // Ricerca per ISBN
                        System.out.println("Inserisci ISBN da cercare:");
                        String ricercaIsbn = scanner.nextLine();
                        Elementi elemento = archivio.ricercaCodice(ricercaIsbn);
                        System.out.println("Elemento trovato: " + elemento.getTitolo());
                        System.out.println("----------");
                        break;
                    case 3:
                        // Rimozione elemento
                        System.out.println("Inserisci ISBN da rimuovere:");
                        String isbnDaRimuovere = scanner.nextLine();
                        archivio.rimuovi(isbnDaRimuovere);
                        System.out.println("Elemento rimosso con successo!");
                        System.out.println("----------");
                        break;
                    case 4:
                        // Ricerca per anno
                        System.out.println("Inserisci anno di pubblicazione:");
                        int annoRicerca = scanner.nextInt();
                        archivio.ricercaPerAnno(annoRicerca).forEach(e -> System.out.println(e.getTitolo()));
                        System.out.println("----------");
                        break;
                    case 5:
                        // Ricerca per autore
                        System.out.println("Inserisci autore:");
                        String autoreRicerca = scanner.nextLine();
                        archivio.ricercaAutore(autoreRicerca).forEach(lib -> System.out.println(lib.getTitolo()));
                        System.out.println("----------");
                        break;
                    case 6:
                        // Ricerca per titolo
                        System.out.println("Inserisci titolo:");
                        String titoloRicerca = scanner.nextLine();
                        archivio.ricercaTitolo(titoloRicerca).forEach(lib -> System.out.println(lib.getTitolo()));
                        System.out.println("----------");
                        break;
                    case 7:
                        // Ricerca per genere
                        System.out.println("Inserisci genere:");
                        String genereRicerca = scanner.nextLine();
                        archivio.ricercaGenere(genereRicerca).forEach(lib -> System.out.println(lib.getTitolo()));
                        System.out.println("----------");
                        break;
                    case 8:
                        // Ricerca per periodicità
                        System.out.println("Inserisci periodicità:");
                        String periodicitaRicerca = scanner.nextLine();
                        archivio.ricercaPeriodicita(periodicitaRicerca)
                                .forEach(rivista -> System.out.println(rivista.getTitolo()));
                        System.out.println("----------");
                        break;
                    case 9:
                        // Aggiorna elemento
                        System.out.println("Inserisci ISBN dell'elemento da aggiornare:");
                        String isbnAggiornare = scanner.nextLine();
                        System.out.println("Inserisci nuovo titolo:");
                        String nuovoTitolo = scanner.nextLine();
                        System.out.println("Inserisci nuovo anno di pubblicazione:");
                        int nuovoAnno = scanner.nextInt();
                        System.out.println("Inserisci nuovo numero di pagine:");
                        int nuovePagine = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Inserisci nuovo autore:");
                        String nuovoAutore = scanner.nextLine();
                        System.out.println("Inserisci nuovo genere:");
                        String nuovoGenere = scanner.nextLine();
                        Libro nuovoLibro = new Libro(isbnAggiornare, nuovoTitolo, nuovoAnno, nuovePagine, nuovoAutore, nuovoGenere);
                        archivio.aggiornaElemento(isbnAggiornare, nuovoLibro);
                        System.out.println("Elemento aggiornato con successo!");
                        System.out.println("----------");
                        break;
                    case 10:
                        // Visualizza statistiche
                        archivio.statistiche();
                        break;
                    case 0:
                        // Esci
                        continua = false;
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                        System.out.println("----------");
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
                System.out.println("----------");
            }
        }

        scanner.close();
    }
}
