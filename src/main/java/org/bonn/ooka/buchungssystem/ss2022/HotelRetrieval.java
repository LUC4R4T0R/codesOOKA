package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelRetrieval implements HotelSuche{

    private final DBAccess dbAccess;
    private final Caching caching;

    public HotelRetrieval(Caching caching){
        this.caching = caching;
        this.dbAccess = new DBAccess();
    }

    public Hotel[] getHotelByName(String name) {
        List<Object> objects = this.caching.fetchResult(name);
        if(objects != null) {
            List<Hotel> cachedHotels = objects.stream().map(o -> (Hotel) o).collect(Collectors.toList());
            return cachedHotels.toArray(new Hotel[0]);
        }

        List<String> hotelList = this.dbAccess.getObjects(42, name);
        List<Hotel> hotels = new ArrayList<>();
        for(int i = 0; i + 2 < hotelList.size(); i += 3){
            hotels.add(new Hotel(hotelList.get(i), hotelList.get(i+1), hotelList.get(i+2)));
        }
        this.caching.cacheResult(name, hotels.stream().map(o -> (Object) o).collect(Collectors.toList()));
        return hotels.toArray(new Hotel[0]);
    }

    public void openSession(){

    }
}
