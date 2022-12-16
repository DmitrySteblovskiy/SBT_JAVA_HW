package org.example.factory;

public class FactoryProvider {
    public static AbstractFactory getFactory(boolean choice) {
        if (choice) {
            return new Client1CaseFactory();
        } else {
            return new Client2CaseFactory();
        }
    }
}