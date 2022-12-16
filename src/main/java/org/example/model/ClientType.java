package org.example.model;

import org.example.parser.JsonObject;

public enum ClientType {

    INDIVIDUAL {
        @Override
        public Client createClient(JsonObject json) {

            String firstName = json.get("first_name").toString();
            String lastName = json.get("last_name").toString();

            return new IndividualClient(firstName, lastName);
        }
    },

    LEGAL_ENTITY {
        @Override
        public Client createClient(JsonObject json) {

            String name = json.get("name").toString();
            int inn = json.get("inn").toNumber();

            return new LegalEntityClient(name, inn);
        }
    },

    HOLDING {
        @Override
        public Client createClient(JsonObject json) {

            String name = json.get("name").toString();
            String customHoldingField = json.get("customHoldingField").toString();
            int inn = json.get("inn").toNumber();

            return new HoldingClient(name, inn, customHoldingField);
        }
    };

    public abstract Client createClient(JsonObject json);
}
