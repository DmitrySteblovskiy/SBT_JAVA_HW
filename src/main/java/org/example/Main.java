package org.example;

import org.example.factory.AbstractFactory;
import org.example.factory.FactoryProvider;
import org.example.model.Client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length > 0) {
            String arg = args[0];

            AbstractFactory factory = FactoryProvider.getFactory(false);
            Client client = factory.create(arg);

            System.out.println(client);
        }
    }
}