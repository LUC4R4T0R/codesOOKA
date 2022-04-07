package org.bonn.ooka.buchungssystem.ss2022;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingImpl implements Caching{
    private final Map<String, List<Object>> cache;

    public CachingImpl(){
        this.cache = new HashMap<>();
    }

    @Override
    public void cacheResult(String key, List<Object> value) {
        this.cache.put(key, value);
    }

    @Override
    public List<Object> fetchResult(String key) {
        try {
            return this.cache.get(key);
        }catch (Exception e){
            return null;
        }
    }
}
