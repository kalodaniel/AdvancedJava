package org.example.interfaceusage.usage;

import org.example.cache.CacheRead;

public class Hasznalat {
    private final CacheRead cacheRead;
    public Hasznalat(CacheRead cacheRead){
        this.cacheRead = cacheRead;
    }

    public void run(){
        System.out.println(cacheRead.get("titok"));
    }
}
