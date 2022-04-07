package org.bonn.ooka.buchungssystem.ss2022;

import java.util.List;

public interface Caching {
    void cacheResult(String key, List<Object> value);
    List<Object> fetchResult(String key);
}
