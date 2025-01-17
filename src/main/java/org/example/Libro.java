package org.example;



public class Libro extends Elementi{
    private String autore;
    private String genere;

public Libro(String codiceISBN,String titolo,int pubblicazione,int  numeroPagine,String autore, String genere){
    super(codiceISBN,titolo,pubblicazione,numeroPagine);
    this.autore = autore;
    this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
