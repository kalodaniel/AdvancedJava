package org.example.interfaceusage.usage;

import org.example.cache.Cache;
import org.example.interfaceusage.Hasznos;
import org.example.interfaceusage.Hasznos2;

public class Main {
    public static void main(String args[]){
        Cache cache = new Cache();

        cache.set("titok",123);

        Hasznalat hasznalat = new Hasznalat(cache);
        hasznalat.run();
    }
}
