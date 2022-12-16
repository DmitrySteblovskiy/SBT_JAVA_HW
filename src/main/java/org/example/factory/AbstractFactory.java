package org.example.factory;

import org.example.model.Client;

import java.io.IOException;

public interface AbstractFactory {
    Client create(String animalType) throws IOException;
}