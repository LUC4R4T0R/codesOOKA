package org.bonn.ooka.buchungssystem.ss2022;

public class Hotel {
    private int id;
    private String name;
    private String ort;
    private int sterne;
    private String kontact;

    public int getId() {
        return id;
    }

    public Hotel setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Hotel setName(String name) {
        this.name = name;
        return this;
    }

    public String getOrt() {
        return ort;
    }

    public Hotel setOrt(String ort) {
        this.ort = ort;
        return this;
    }

    public int getSterne() {
        return sterne;
    }

    public Hotel setSterne(int sterne) {
        this.sterne = sterne;
        return this;
    }

    public String getKontact() {
        return kontact;
    }

    public Hotel setKontact(String kontact) {
        this.kontact = kontact;
        return this;
    }
}
