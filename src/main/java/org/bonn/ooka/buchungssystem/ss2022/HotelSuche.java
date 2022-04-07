package org.bonn.ooka.buchungssystem.ss2022;

public interface HotelSuche {
    Hotel[] getHotelByName(String name);
    void openSession();
}
