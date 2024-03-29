package org.example.services;

import org.example.exceptions.UsuwanieLiniiException;
import org.example.models.CPojazdRolniczy;
import org.example.utils.CSVWriter;

import java.util.Date;
import java.util.List;

public class PojazdRolniczyService {
    private List<CPojazdRolniczy> pojazdy;

    public PojazdRolniczyService(List<CPojazdRolniczy> pojazdy) {
        this.pojazdy = pojazdy;
    }

    public void dodajNowyPojazd(Date dataPrzyjecia, double cena, String marka, String model, double mocSilnika, String rodzajNapedu, Date dataProdukcji, String rodzajPaliwa, double pojemnoscSilnika, String przeznaczenie, String typPrzekladni, double wydajnoscHydrauliki) {
        int ostatniIdentyfikator = pojazdy.getLast().getIdentyfikator();
        CPojazdRolniczy pojazd = new CPojazdRolniczy(ostatniIdentyfikator + 1, dataPrzyjecia, cena, marka, model, mocSilnika, rodzajNapedu, dataProdukcji, rodzajPaliwa, pojemnoscSilnika, przeznaczenie, typPrzekladni, wydajnoscHydrauliki);
        CSVWriter writer = new CSVWriter();
        writer.dodajLinieDoPliku("src/main/resources/data/PojazdyRolnicze.csv", pojazd.toString());
    }
    public void usunPojazd(int id) throws UsuwanieLiniiException {
        for(int i = 0; i < pojazdy.size(); i++) {
            if(pojazdy.get(i).getIdentyfikator() == id) {
                pojazdy.remove(i);
                CSVWriter writer = new CSVWriter();
                writer.usunLinieZPliku("src/main/resources/data/PojazdyRolnicze.csv", id);
            }
        }
    }
    public void wyszukajPojazdPoNazwie(String nazwa) {
        boolean znaleziono = false;
        for (CPojazdRolniczy pojazd : pojazdy) {
            if (pojazd.getMarka().equalsIgnoreCase(nazwa)) {
                System.out.println("Znaleziono pojazd: " + pojazd);
                znaleziono = true;
            }
        }
        if (!znaleziono) {
            System.out.println("Nie znaleziono pojazdu o nazwie: " + nazwa);
        }
    }
}
