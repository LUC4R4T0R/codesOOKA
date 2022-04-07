package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelRetrieval implements HotelSuche{

    private final DBAccess dbAccess;

    public HotelRetrieval(){
        this.dbAccess = new DBAccess();
    }

    public Hotel[] getHotelByName(String name) {
        List<String> hotelList = this.dbAccess.getObjects(42, name);
        List<Hotel> hotels = new ArrayList<>();
        for(int i = 0; i + 2 < hotelList.size(); i += 3){
            hotels.add(new Hotel(hotelList.get(i), hotelList.get(i+1), hotelList.get(i+2)));
        }
        return hotels.toArray(new Hotel[0]);
    }

    public void openSession(){

    }
}
