package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

public class CachingProxy implements Caching{
    private Caching caching;

    public CachingProxy(Caching caching){
        this.caching = caching;
    }

    @Override
    public void cacheResult(String key, List<Object> value) {
        this.caching.cacheResult(key, value);
    }

    @Override
    public List<Object> fetchResult(String key) {
        return this.caching.fetchResult(key);
    }
}
