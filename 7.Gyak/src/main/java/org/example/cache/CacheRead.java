package org.example.cache;

public interface CacheRead {
    int get(String name);
    boolean empty();
}
