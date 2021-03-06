package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelRetrieval implements HotelSuche{

    private final DBAccess dbAccess;
    private final Caching caching;

    public HotelRetrieval(Caching caching){
        this.caching = new CachingProxy(caching);
        this.dbAccess = new DBAccess();
    }

    public Hotel[] getHotelByName(String name) {
        List<Object> objects = this.caching.fetchResult(name);
        if(objects != null) {
            return objects.stream().map(Hotel.class::cast).toArray(Hotel[]::new);
        }

        List<String> hotelList = this.dbAccess.getObjects(42, name);
        List<Hotel> hotels = new ArrayList<>();
        for(int i = 0; i + 2 < hotelList.size(); i += 3){
            hotels.add(new Hotel(hotelList.get(i), hotelList.get(i+1), hotelList.get(i+2)));
        }
        this.caching.cacheResult(name, hotels.stream().map(Object.class::cast).collect(Collectors.toList()));
        return hotels.toArray(new Hotel[0]);
    }

    public void openSession(){
        this.dbAccess.openConnection();
    }

    public void closeSession() {
        this.dbAccess.closeConnection();
    }
}
