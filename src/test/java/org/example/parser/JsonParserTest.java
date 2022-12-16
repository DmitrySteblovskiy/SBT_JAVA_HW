package org.example.parser;

import org.example.factory.AbstractFactory;
import org.example.factory.FactoryProvider;
import org.example.model.Client;
import org.example.model.HoldingClient;
import org.example.model.IndividualClient;
import org.example.model.LegalEntityClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonParserTest {

    @Test
    void testLegalEntityClient2Case() throws IOException {

        LegalEntityClient clientExpected = new LegalEntityClient("ООО Матрешка", 13242352);

        AbstractFactory factory = FactoryProvider.getFactory(false);
        Client clientActual = factory.create("legal-entity");

        assertEquals(clientExpected, clientActual);
    }

    @Test
    void testIndividualClient2Case() throws IOException {

        IndividualClient clientExpected = new IndividualClient("Вася", "Петров");

        AbstractFactory factory = FactoryProvider.getFactory(false);
        Client clientActual = factory.create("individual");

        assertEquals(clientExpected, clientActual);
    }

    @Test
    void testHoldingClient2Case() throws IOException {

        HoldingClient clientExpected = new HoldingClient("АСТ", 13242352, "value");

        AbstractFactory factory = FactoryProvider.getFactory(false);
        Client clientActual = factory.create("holding");

        assertEquals(clientExpected, clientActual);
    }

    @Test
    void testLegalEntityClient1Case() throws IOException {

        LegalEntityClient clientExpected = new LegalEntityClient("ООО Матрешка", 13242352);

        AbstractFactory factory = FactoryProvider.getFactory(true);
        Client clientActual = factory.create("legal-entity");

        assertEquals(clientExpected, clientActual);
    }

    @Test
    void testIndividualClient1Case() throws IOException {

        IndividualClient clientExpected = new IndividualClient("Вася", "Петров");

        AbstractFactory factory = FactoryProvider.getFactory(true);
        Client clientActual = factory.create("individual");

        assertEquals(clientExpected, clientActual);
    }

    @Test
    void testHoldingClient1Case() throws IOException {

        HoldingClient clientExpected = new HoldingClient("АСТ", 13242352, "value");

        AbstractFactory factory = FactoryProvider.getFactory(true);
        Client clientActual = factory.create("holding");

        assertEquals(clientExpected, clientActual);
    }
}