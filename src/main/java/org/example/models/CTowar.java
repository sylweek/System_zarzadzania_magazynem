package org.example.models;

import java.util.Date;
import java.util.Objects;

public abstract class CTowar {
    private int identyfikator;
    Date dataPrzyjecia;
    private double cena;
    

    public CTowar() {}

    public CTowar(int identyfikator, Date dataPrzyjecia, double cena){
        this.identyfikator = identyfikator;
        this.dataPrzyjecia = dataPrzyjecia;
        this.cena = cena;
    }
    //zwraca tekstowa reprezentacje obiektu
    public String toString() {
        return identyfikator + "," + dataPrzyjecia + "," + cena;
    }
        //porownoje
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CTowar cTowar = (CTowar) obj;
        return identyfikator == cTowar.identyfikator;
    }
    //oblicza skrot wartosci identyfikatora towaru
    public int hashCode() {
        return Objects.hash(identyfikator);
    }
    //porownoje
    public int compereTo(CTowar cTowar) {
        return Integer.compare(this.identyfikator, cTowar.identyfikator);
    }
    //zwraca idnetyfikator towaru
    public int getIdentyfikator() {
        return identyfikator;
    }
    //ustawia idnetyfikator towaru
    public void setIdentyfikator(int identyfikator) {
        this.identyfikator = identyfikator;
    }
    public Date getCData() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(Date dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }
    public double cena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
