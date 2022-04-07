package org.bonn.ooka.buchungssystem.ss2022;

import org.bonn.ooka.buchungssystem.ss2022.advancedSearch.HotelRetrievalAdvanced;
import org.bonn.ooka.buchungssystem.ss2022.advancedSearch.HotelSucheAdvancedProxy;
import org.bonn.ooka.buchungssystem.ss2022.logger.Logger;

import java.util.*;

public class SucheFassade {
    private Map<String, Object> proxies;
    private Caching caching;
    private Logger logger;

    public SucheFassade(){
        this.caching = new CachingImpl();
        this.logger = new Logger();
        this.proxies = new HashMap<>();

        this.proxies.put("suche", new HotelSucheProxy(new HotelRetrieval(this.caching), this.logger));
        this.proxies.put("sucheAdvanced", new HotelSucheAdvancedProxy(new HotelRetrievalAdvanced(this.caching), this.logger));
    }

    public List<String> listProxies(){
        return new ArrayList<>(this.proxies.keySet());
    }

    public Object getProxy(String name){
        return this.proxies.get(name);
    }
}
