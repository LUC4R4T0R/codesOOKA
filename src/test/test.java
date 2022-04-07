import org.bonn.ooka.buchungssystem.ss2022.CachingImpl;
import org.bonn.ooka.buchungssystem.ss2022.HotelRetrieval;
import org.bonn.ooka.buchungssystem.ss2022.HotelSuche;
import org.bonn.ooka.buchungssystem.ss2022.HotelSucheProxy;
import org.bonn.ooka.buchungssystem.ss2022.advancedSearch.HotelRetrievalAdvanced;
import org.bonn.ooka.buchungssystem.ss2022.advancedSearch.HotelSucheAdvanced;
import org.bonn.ooka.buchungssystem.ss2022.advancedSearch.HotelSucheAdvancedProxy;
import org.bonn.ooka.buchungssystem.ss2022.hotel.Hotel;
import org.bonn.ooka.buchungssystem.ss2022.logger.Logger;

import java.util.Arrays;

public class test {
    public static void main(String[] args){
        //HotelSuche suche = new HotelSucheProxy(new HotelRetrieval(new CachingImpl()), new Logger());
        HotelSucheAdvanced suche2 = new HotelSucheAdvancedProxy(new HotelRetrievalAdvanced(new CachingImpl()), new Logger());

        /*suche.openSession();
        Hotel[] hotels = suche.getHotelByName("Maier");
        Arrays.stream(hotels).forEach(System.out::println);

        suche.closeSession();
        Hotel[] hotels2 = suche.getHotelByName("Maier");
        Arrays.stream(hotels2).forEach(System.out::println);
        */

        suche2.openSession();
        Hotel[] hotels3 = suche2.getHotelByNameAndMinSterne("", 4);
        suche2.closeSession();

        Arrays.stream(hotels3).forEach(System.out::println);
    }
}
