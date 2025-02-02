package data_102.filmarkiv.impl;

import java.util.ArrayList;
import java.util.List;

import data_102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmarkiv;
    private int antall;

    public Filmarkiv(int kapasitet) {
        filmarkiv = new Film[kapasitet];
        antall = 0;
    }
    
    @Override
    public Film finnFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getFilmnr() == filmnr) {
                return filmarkiv[i];
            }
        }
        return null;
    }
    
    @Override
    public void leggTilFilm(Film nyFilm) {
        for (int i = 1; i < antall; i++) {
            if (filmarkiv[i].getFilmnr() == nyFilm.getFilmnr() || antall >= filmarkiv.length) {
                System.out.println("Film er allrede lagt til");
                break;
        
            } else {
                filmarkiv[antall] = nyFilm;
                antall++;
                break;
            }
        }
 
    }
    
    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getFilmnr() == filmnr) {
                filmarkiv[i] = filmarkiv[antall - 1];
                filmarkiv[antall - 1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Film[] soekTittel(String delstreng) {
        List<Film> resultat = new ArrayList<>();
        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                resultat.add(filmarkiv[i]);
            }
        }
        return trimTab(resultat.toArray(new Film[0]), resultat.size());
    }

    @Override 
    public Film[] soekProdusent(String delstreng) {
        List<Film> resultat = new ArrayList<>();
        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getProd().toLowerCase().contains(delstreng.toLowerCase())) {
                resultat.add(filmarkiv[i]);
            }
        }
        return trimTab(resultat.toArray(new Film[0]), resultat.size());
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        for (int i = 0; i < antall; i++) {
            if (filmarkiv[i].getSjanger() == sjanger) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int antall() {
        return antall;
    }

    public void utvid() {
        Film[] nyTabell = new Film[filmarkiv.length * 2];
        System.arraycopy(filmarkiv, 0, nyTabell, 0, filmarkiv.length);
        filmarkiv = nyTabell;
    }

    private Film[] trimTab(Film[] tab, int n) {
        Film[] nyTabell = new Film[n];
        System.arraycopy(tab, 0, nyTabell, 0, n);
        return nyTabell;
    }
}