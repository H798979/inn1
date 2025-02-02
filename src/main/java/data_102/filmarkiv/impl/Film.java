package data_102.filmarkiv.impl;

import java.util.Objects;



public class Film {

    private int filmnr; 
    private String prod;
    private String tittel;
    private int year; 
    private Sjanger sjanger;
    private String selskap; 

    public Film() {
        this(0, "", "", 0, null, "");
    }

    public Film(int filmnr, String prod, String tittel, int year, Sjanger sjanger, String selskap) {
        this.filmnr = filmnr;
        this.prod = prod;
        this.tittel = tittel;
        this.year = year;
        this.sjanger = sjanger;
        this.selskap = selskap;
    }

    public int getFilmnr() {
        return filmnr;
    }
    public String getProd() {
        return prod;
    }    
    public String getTittel() {
        return tittel;
    }
    public int getYear() {
        return year;
    }
    public Sjanger getSjanger() {
        return sjanger;
    }
    public String getSelskap() {
        return selskap;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }
    public void setProd(String prod) {
        this.prod = prod;
    }
    public void setTittel(String tittel) {
        this.tittel = tittel;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }
    public void setSelskap(String selskap) {
        this.selskap = selskap;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false;
        Film film = (Film) obj;
        return filmnr == film.filmnr;
    }  

    @Override 
    public int hashCode() {
        return Objects.hash(filmnr);
    }
}

