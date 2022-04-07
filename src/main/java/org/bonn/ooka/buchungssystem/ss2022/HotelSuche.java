package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;

public interface HotelSuche {
    Hotel[] getHotelByName(String name);
    void openSession();
    void closeSession();
}
