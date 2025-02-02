package Film;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data_102.filmarkiv.impl.Film;
import data_102.filmarkiv.impl.Filmarkiv;
import data_102.filmarkiv.impl.Sjanger;

import static org.junit.jupiter.api.Assertions.*;

class FilmarkivTest {
    private Filmarkiv filmarkiv;

    @BeforeEach
    void setup() {
        filmarkiv = new Filmarkiv(5);
        filmarkiv.leggTilFilm(new Film(1, "David Fincher", "Fight Club", 1999, Sjanger.ACTION, "20th Century Fox"));
        filmarkiv.leggTilFilm(new Film(2, "Denis Villeneuve", "Dune Part 2", 2024, Sjanger.SCIFI, "Warner Brothers"));
        filmarkiv.leggTilFilm(new Film(3, "Christopher Nolan", "Oppenheimer", 2024, Sjanger.HISTORY, "Universal Pictures"));
    }

    @Test
    void testLeggTilFilm() {
        Film nyFilm = new Film(4, "Richard Curdis", "About Time", 2013, Sjanger.SCIFI, "Universal Studios");
        filmarkiv.leggTilFilm(nyFilm);
        assertEquals(4, filmarkiv.antall());
        assertEquals(nyFilm, filmarkiv.finnFilm(4));
    }

    @Test
    void testSlettFilm() {
        assertTrue(filmarkiv.slettFilm(2));
        assertEquals(2, filmarkiv.antall());
        assertNull(filmarkiv.finnFilm(2));
        assertFalse(filmarkiv.slettFilm(10)); 
    }

    @Test
    void testSoekTittel() {
        Film[] result = filmarkiv.soekTittel("Oppenheimer");
        assertEquals(1, result.length);

        result = filmarkiv.soekTittel("SciFi");
        assertEquals(1, result.length);
        assertEquals("SciFi Eventyr", result[0].getTittel());
    }

    @Test
    void testSoekProdusent() {
        Film[] result = filmarkiv.soekProdusent("Cristopher Nolan");
        assertEquals(1, result.length);
    }

    @Test
    void testAntall() {
        assertEquals(1, filmarkiv.antall(Sjanger.ACTION));
        assertEquals(1, filmarkiv.antall(Sjanger.DRAMA));
        assertEquals(1, filmarkiv.antall(Sjanger.HISTORY));
    }
}