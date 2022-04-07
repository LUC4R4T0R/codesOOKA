package org.bonn.ooka.buchungssystem.ss2022.advancedSearch;

import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;
import org.bonn.ooka.buchungssystem.ss2022.logger.Logger;

public class HotelSucheAdvancedProxy implements HotelSucheAdvanced {

    private HotelRetrievalAdvanced hotelRetrievalAdvanced;
    private Logger logger;
    public HotelSucheAdvancedProxy(HotelRetrievalAdvanced hotelRetrievalAdvanced, Logger logger){
        this.logger = logger;
        this.hotelRetrievalAdvanced = hotelRetrievalAdvanced;
    }

    public Hotel[] getHotelByNameAndMinSterne(String name, int minSterne){
        this.logger.log("Suchwort: "+name+" minSterne: "+minSterne);
        return this.hotelRetrievalAdvanced.getHotelByNameAndMinSterne(name, minSterne);
    }

    public void openSession(){
        this.hotelRetrievalAdvanced.openSession();
    }

    public void closeSession(){
        this.hotelRetrievalAdvanced.closeSession();
    }
}
