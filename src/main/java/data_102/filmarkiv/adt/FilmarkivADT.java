package data_102.filmarkiv.adt;

import data_102.filmarkiv.impl.Film;
import data_102.filmarkiv.impl.Sjanger;

public interface FilmarkivADT {
    /**
     * Hente en film med gitt nr fra arkivet 
     * @param nr nr på filmen som skal hentes
     * @return film med gitt nr (om ikke finnes returneres null)
     */
    Film finnFilm(int nr);

    /**
     * legger til en ny film 
     * @param nyFilm 
     */
    void leggTilFilm(Film nyFilm);

    /**
     * sletter en film med gitt nr 
     * @param filmnr nr på filmen som skal slettes
     * @return true dersom filmen ble slettet, false ellers
     */
    boolean slettFilm(int filmnr);

    /**
    * Søker og henter Filmer med en gitt delstreng i tittelen.
    * @param delstreng som må være i tittel
    * @return tabell med filmer som har delstreng i tittel
    */
    Film[] soekTittel(String delstreng);

    /**
    * Søker og henter filmer med en gitt delstreng i filmprodusent
    * @param delstreng
    * @return tabell med filmer som har delstreng i produsent
    */
    Film[] soekProdusent(String delstreng);

    /**
    * Finner antall filmer med gitt sjanger
    * @param sjanger
    * @return antall filmer av gitt sjanger.
    */
    int antall(Sjanger sjanger);

    /**
    * @return antall filmer i arkivet
    */
    int antall();
    
}
