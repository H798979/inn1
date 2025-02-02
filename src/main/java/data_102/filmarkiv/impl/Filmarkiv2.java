package data_102.filmarkiv.impl;

import data_102.filmarkiv.adt.FilmarkivADT;
import java.util.ArrayList;
import java.util.List;

public class Filmarkiv2 implements FilmarkivADT {

    private LinearNode<Film> start;
    private int antall; 

    public Filmarkiv2() {
        start = null; 
        antall = 0; 
    }

    @Override
    public Film finnFilm(int filmnr) {
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getFilmnr() == filmnr) {
                return current.data;
            }
            current = current.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm (Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm);
        if (start == null) {
            start = nyNode;
        } else {
            LinearNode<Film> current = start;
            while (current.neste != null) {
                current = current.neste;
            }
            current.neste = nyNode; 
        }
        antall++;
    }

    @Override 
    public boolean slettFilm(int filmnr) {
        if (start == null) {
            return false;
        }
        if (start.data.getFilmnr() == filmnr) {
            start = start.neste; 
            antall--; 
            return true;
        }
        
        LinearNode<Film> forrige = start;
        LinearNode<Film> current = start.neste;

        while (current != null) {
            if (current.data.getFilmnr() == filmnr) {
                forrige.neste = current.neste;
                antall--;
                return true;
            }
            forrige = current;
            current = current.neste;
        } 
        return false;
    } 

    @Override 
    public Film[] soekTittel(String delstreng) {
        List<Film> resultater = new ArrayList<>();
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getTittel().contains(delstreng)) {
                resultater.add(current.data);
            }
            current = current.neste;
        }
        return resultater.toArray(new Film[0]);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        List<Film> resultater = new ArrayList<>();
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getProd().contains(delstreng)) {
                resultater.add(current.data);
            }
            current = current.neste;
        }
        return resultater.toArray(new Film[0]);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        LinearNode<Film> current = start;
        while (current != null) {
            if (current.data.getSjanger() == sjanger) {
                count++;
            }
            current = current.neste;
        }
        return count;
    }

    @Override
    public int antall() {
        return antall;
    }
}
