package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;

import java.util.Arrays;

public class test {
    public static void main(String[] args){
        HotelSuche suche = new HotelSucheProxy(new HotelRetrieval());

        suche.openSession();
        Hotel[] hotels = suche.getHotelByName("*");
        suche.closeSession();

        Arrays.stream(hotels).forEach(System.out::println);
    }
}
