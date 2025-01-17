package org.example;

public class Rivista extends Elementi{
    String periodicita;

public Rivista (String codiceISBN,String titolo,int pubblicazione,int  numeroPagine, String periodicita){
    super(codiceISBN,titolo,pubblicazione,numeroPagine);
    this.periodicita = periodicita;
}

    public String getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(String periodicita){
    this.periodicita = periodicita;
    }
}
