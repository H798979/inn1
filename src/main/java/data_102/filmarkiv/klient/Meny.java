package data_102.filmarkiv.klient;

import data_102.filmarkiv.adt.FilmarkivADT;
import data_102.filmarkiv.impl.Film;
import data_102.filmarkiv.impl.Sjanger;


public class Meny {

    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv; 

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt(); 
        this.filmarkiv = filmarkiv; 
    }

    public void start() {
        filmarkiv.leggTilFilm(new Film(1, "David Fincher", "Fight Club", 1999, Sjanger.ACTION, "20th Century Fox"));
        filmarkiv.leggTilFilm(new Film(2, "Denis Villeneuve", "Dune Part 2", 2024, Sjanger.SCIFI, "Warner Brothers"));
        filmarkiv.leggTilFilm(new Film(3, "Christopher Nolan", "Oppenheimer", 2024, Sjanger.DRAMA, "Universal Pictures"));

        tekstgr.skrivUtStatistikk(filmarkiv);
        tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "Dune Part 2");
    }
}
