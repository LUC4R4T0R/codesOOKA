package org.bonn.ooka.buchungssystem.ss2022.advancedSearch;

import org.bonn.ooka.buchungssystem.ss2022.Caching;
import org.bonn.ooka.buchungssystem.ss2022.DBAccess;
import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelRetrievalAdvanced implements HotelSucheAdvanced {

    private final DBAccess dbAccess;
    private final Caching caching;

    public HotelRetrievalAdvanced(Caching caching){
        this.caching = caching;
        this.dbAccess = new DBAccess();
    }

    public Hotel[] getHotelByNameAndMinSterne(String name, int minSterne) {
        List<Object> objects = this.caching.fetchResult(name+"!SEPERATOR!"+minSterne);
        if(objects != null) {
            return objects.stream().map(Hotel.class::cast).toArray(Hotel[]::new);
        }

        List<String> hotelList = this.dbAccess.getObjects(42, name +  "%\' AND sterne >= "+minSterne+" AND \'%\' = \'");
        List<Hotel> hotels = new ArrayList<>();
        for(int i = 0; i + 2 < hotelList.size(); i += 3){
            hotels.add(new Hotel(hotelList.get(i), hotelList.get(i+1), hotelList.get(i+2)));
        }
        this.caching.cacheResult(name+"!SEPERATOR!"+minSterne, hotels.stream().map(o -> (Object) o).collect(Collectors.toList()));
        return hotels.toArray(new Hotel[0]);
    }

    public void openSession(){
        this.dbAccess.openConnection();
    }

    public void closeSession() {
        this.dbAccess.closeConnection();
    }
}
