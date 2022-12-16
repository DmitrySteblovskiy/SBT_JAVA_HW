package org.example.model;

import java.util.Objects;

public class HoldingClient extends Client {

    private final String name;

    private final String customHoldingField;

    private final int inn;

    public HoldingClient(String name, int inn, String customHoldingField) {
        this.name = name;
        this.inn = inn;
        this.customHoldingField = customHoldingField;
    }

    public String getName() {
        return name;
    }

    public int getInn() {
        return inn;
    }

    public String getCustomHoldingField() {
        return customHoldingField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoldingClient that = (HoldingClient) o;
        return inn == that.inn && Objects.equals(name, that.name) && Objects.equals(customHoldingField, that.customHoldingField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customHoldingField, inn);
    }

    @Override
    public String toString() {
        return "HoldingClient{"
                + " name='" + name + '\''
                + ", customHoldingField='" + customHoldingField + '\''
                + ", inn=" + inn
                + '}';
    }
}
