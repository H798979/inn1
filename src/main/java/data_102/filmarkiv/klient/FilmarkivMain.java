package data_102.filmarkiv.klient;

import data_102.filmarkiv.adt.FilmarkivADT;
import data_102.filmarkiv.impl.Filmarkiv;

public class FilmarkivMain {
    public static void main(String[] args) {
        FilmarkivADT filmarkiv = new Filmarkiv(10);
        Meny meny = new Meny(filmarkiv);
        meny.start();
    }
}