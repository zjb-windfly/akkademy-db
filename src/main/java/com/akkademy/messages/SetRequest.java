package com.akkademy.messages;

/**
 * @author Joel
 * @create 2018-11-24 20:14
 **/
public class SetRequest {
    private final String key;
    private final Object value;

    public SetRequest(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}