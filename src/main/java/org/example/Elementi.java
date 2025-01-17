package org.example;

public abstract class Elementi {
    private String codiceISBN;
    private String titolo;
    private int pubblicazione;
    private int numeroPagine;


public Elementi(String codiceISBN,String titolo,int pubblicazione,int  numeroPagine){
    this.codiceISBN = codiceISBN;
    this.titolo = titolo;
    this.pubblicazione = pubblicazione;
    this.numeroPagine = numeroPagine;
}

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getPubblicazione() {
        return pubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }


}
