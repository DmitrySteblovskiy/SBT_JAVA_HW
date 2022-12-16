package org.example.factory;

import org.example.model.Client;
import org.example.model.ClientType;
import org.example.parser.JsonObject;
import org.example.parser.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Client2CaseFactory implements AbstractFactory {

    public Client create(String arg) throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(arg + ".json");

        if (Objects.nonNull(resourceAsStream)) {
            String json = new String(resourceAsStream.readAllBytes(), StandardCharsets.UTF_8);

            JsonObject jsonObject = (JsonObject) JsonParser.parse(json);

            String type = jsonObject.get("clientType").toString();

            ClientType clientType = ClientType.valueOf(type);

            return clientType.createClient(jsonObject);
        }

        return null;
    }
}