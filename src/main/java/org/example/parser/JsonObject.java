package org.example.parser;

import java.util.HashMap;

public class JsonObject extends JsonDataType {

    public JsonObject() {
        type = DataType.OBJECT;
        data = new HashMap<String, JsonDataType>();
    }

    public void set(String key, JsonDataType value) {
        ((HashMap<String, JsonDataType>) data).put(key, value);
    }

    public JsonDataType get(String key) {
        return ((HashMap<String, JsonDataType>) data).get(key);
    }

    public int size() {
        return ((HashMap<String, JsonDataType>) data).size();
    }
}