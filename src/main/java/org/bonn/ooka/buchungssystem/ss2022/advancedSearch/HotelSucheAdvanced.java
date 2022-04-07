package org.bonn.ooka.buchungssystem.ss2022.advancedSearch;

import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;

public interface HotelSucheAdvanced {
    Hotel[] getHotelByNameAndMinSterne(String name, int minSterne);
    void openSession();
    void closeSession();
}
