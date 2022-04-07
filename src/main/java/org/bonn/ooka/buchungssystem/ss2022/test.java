package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;

import java.util.Arrays;

public class test {
    public static void main(String[] args){
        HotelSuche suche = new HotelSucheProxy(new HotelRetrieval(new CachingImpl()));

        suche.openSession();
        Hotel[] hotels = suche.getHotelByName("Maier");
        Arrays.stream(hotels).forEach(System.out::println);

        suche.closeSession();
        Hotel[] hotels2 = suche.getHotelByName("Maier");

        Arrays.stream(hotels2).forEach(System.out::println);
    }
}
