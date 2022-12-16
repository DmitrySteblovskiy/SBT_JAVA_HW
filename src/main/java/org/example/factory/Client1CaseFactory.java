package org.example.factory;

import org.example.model.*;
import org.example.parser.JsonObject;
import org.example.parser.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Client1CaseFactory implements AbstractFactory {

    public Client create(String arg) throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(arg + ".json");

        if (Objects.nonNull(resourceAsStream)) {
            String json = new String(resourceAsStream.readAllBytes(), StandardCharsets.UTF_8);
            JsonObject jsonObject = (JsonObject) JsonParser.parse(json);
            String type = jsonObject.get("clientType").toString();
            ClientType clientType = ClientType.valueOf(type);

            if (clientType == ClientType.INDIVIDUAL) {
                String firstName = jsonObject.get("first_name").toString();
                String lastName = jsonObject.get("last_name").toString();
                return new IndividualClient(firstName, lastName);
            } else if (clientType == ClientType.HOLDING) {
                String name = jsonObject.get("name").toString();
                int inn = jsonObject.get("inn").toNumber();
                String customHoldingField = jsonObject.get("customHoldingField").toString();
                return new HoldingClient(name, inn, customHoldingField);
            } else {
                String name = jsonObject.get("name").toString();
                int inn = jsonObject.get("inn").toNumber();
                return new LegalEntityClient(name, inn);
            }
        }
        return null;
    }
}