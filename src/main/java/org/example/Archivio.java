package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;




public class Archivio {
    private List<Elementi> catalogo;

    public Archivio(){
        this.catalogo = new ArrayList<>();
    }

    public void aggiungi(Elementi elementi) throws Exception {
        if (catalogo.stream().anyMatch(e -> e.getCodiceISBN().equals(elementi.getCodiceISBN()))) {
            throw new Exception("Codice ISBN già presente");
        }
        catalogo.add(elementi);
        catalogo.forEach(e -> System.out.println("Catalogo contiene: " + e.getCodiceISBN())); // Debug
    }


    public Elementi ricercaCodice(String isbn) throws Exception {
        return catalogo.stream()
                .filter(e -> e.getCodiceISBN().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new Exception("Codice " + isbn + " non trovato"));
    }


    public void rimuovi(String isbn) throws Exception{
        Elementi elementi = ricercaCodice(isbn);
        catalogo.remove(elementi);
    }

    public List<Libro> ricercaAutore(String autore){
        return catalogo.stream()
                .filter(e -> e instanceof Libro)
                .map(e -> (Libro) e)
                .filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
    }

    public List<Libro> ricercaGenere(String genere){
        return catalogo.stream()
                .filter(e -> e instanceof Libro)
                .map(e -> (Libro) e)
                .filter(libro -> libro.getGenere().equalsIgnoreCase(genere))
                .collect(Collectors.toList());
    }


    public List<Elementi> ricercaTitolo(String titolo) {
        return catalogo.stream()
                .filter(e -> e.getTitolo().equalsIgnoreCase(titolo))
                .collect(Collectors.toList());
    }


    public void aggiornaElemento(String isbn, Elementi nuovoElemento) throws Exception {
        Elementi elemetoDaAggiornare = ricercaCodice(isbn);
        catalogo.remove(elemetoDaAggiornare);
        catalogo.add(nuovoElemento);
    }

    public List<Elementi> ricercaPerAnno(int anno) {
        return catalogo.stream()
                .filter(e -> e.getPubblicazione() == anno)
                .collect(Collectors.toList());
    }


    public void statistiche(){
        long totaleLibri = catalogo.stream().filter(e -> e instanceof Libro).count();
        long totaleRiviste = catalogo.stream().filter(e -> e instanceof Rivista).count();

        Elementi elementoMaxPagine = catalogo.stream()
                .max(Comparator.comparingInt(Elementi::getNumeroPagine))
                .orElse(null);

        double mediaPagine = catalogo.stream()
                .mapToInt(Elementi::getNumeroPagine)
                .average()
                .orElse(0);



        System.out.println("Statistiche del catalogo:");
        System.out.println("Totale libri: " + totaleLibri);
        System.out.println("Totale riviste: " + totaleRiviste);
        System.out.println("Elemento con il maggior numero di pagine: " +
                (elementoMaxPagine != null
                        ? elementoMaxPagine.getTitolo() + " (" + (elementoMaxPagine instanceof Libro ? "Libro" : "Rivista") + ")"
                        : "Nessuno"));
        System.out.println("Media delle pagine: " + mediaPagine);
        System.out.println("----------");

    }
}
