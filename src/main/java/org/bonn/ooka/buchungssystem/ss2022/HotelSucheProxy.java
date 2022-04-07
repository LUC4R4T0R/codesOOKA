package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;

public class HotelSucheProxy implements HotelSuche{

    private HotelRetrieval hotelRetrieval;
    public HotelSucheProxy(HotelRetrieval hotelRetrieval){
        this.hotelRetrieval = hotelRetrieval;
    }

    public Hotel[] getHotelByName(String name){
        return this.hotelRetrieval.getHotelByName(name);
    }

    public void openSession(){
        this.hotelRetrieval.openSession();
    }

    public void closeSession(){
        this.hotelRetrieval.closeSession();
    }
}
