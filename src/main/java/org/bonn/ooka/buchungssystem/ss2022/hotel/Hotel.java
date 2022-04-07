package org.bonn.ooka.buchungssystem.ss2022.hotel;

public class Hotel {
    private int id;
    private String name;
    private String ort;
    private int sterne;
    private String kontact;

    public Hotel(String id, String name, String ort){
        this.id = Integer.parseInt(id);
        this.name = name;
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ort='" + ort + '\'' +
                ", sterne=" + sterne +
                ", kontact='" + kontact + '\'' +
                '}';
    }

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
