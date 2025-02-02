package data_102.filmarkiv.klient;

import data_102.filmarkiv.adt.FilmarkivADT;
import data_102.filmarkiv.impl.Film;
import data_102.filmarkiv.impl.Sjanger;


public class Tekstgrensesnitt {

    public Film lesFilm() {
        return new Film(4, "Richard Curtis", "About Time", 2013, Sjanger.ROMCOM, "Universal Pictures");
    }

    public void skrivUtFilm(Film film) {
        if (film != null) {
            System.out.println("Film nummer: " + film.getFilmnr()); 
            System.out.println("Tittel: " + film.getTittel()); 
            System.out.println("Produsent: " + film.getProd()); 
            System.out.println("År: " + film.getYear()); 
            System.out.println("Sjanger: " + film.getSjanger()); 
            System.out.println("Filmselskap: " + film.getSelskap()); 
            
        }
    }

    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng); 
        for (Film film : filmer) {
            skrivUtFilm(film); 
        }
    }

    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekProdusent(delstreng);
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Antall filmer totalt: " + arkiv.antall());
        for (Sjanger sjanger : Sjanger.values()) { 
            System.out.println("Antall filmer i sjanger " + sjanger + ": " + arkiv.antall(sjanger));
        }
    }

}