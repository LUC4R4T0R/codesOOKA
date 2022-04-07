package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;
import org.bonn.ooka.buchungssystem.ss2022.logger.Logger;

public class HotelSucheProxy implements HotelSuche{

    private HotelRetrieval hotelRetrieval;
    private Logger logger;
    public HotelSucheProxy(HotelRetrieval hotelRetrieval, Logger logger){
        this.logger = logger;
        this.hotelRetrieval = hotelRetrieval;
    }

    public Hotel[] getHotelByName(String name){
        this.logger.log("Suchwort: "+name);
        return this.hotelRetrieval.getHotelByName(name);
    }

    public void openSession(){
        this.hotelRetrieval.openSession();
    }

    public void closeSession(){
        this.hotelRetrieval.closeSession();
    }
}
