package org.example.parser;

public class JsonParser {

    public static JsonDataType parse(String str) {

        str = str.substring(1, str.length() - 1);

        String[] keyValues = str.split(",");

        JsonObject jo = new JsonObject();

        for (String keyValue : keyValues) {

            JsonDataType jdb;

            String[] kv = keyValue.split(":");
            kv[0] = kv[0].trim();
            kv[0] = kv[0].substring(1, kv[0].length() - 1);
            kv[1] = kv[1].trim();

            if (kv[1].charAt(0) == '"') {
                jdb = new JsonString();
                jdb.setValue(kv[1].substring(1, kv[1].length() - 1));
            } else {
                jdb = new JsonInteger();
                jdb.setValue(Integer.parseInt(kv[1]));
            }

            jo.set(kv[0], jdb);
        }

        return jo;
    }

}