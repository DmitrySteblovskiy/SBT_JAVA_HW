package org.example.model;

import java.util.Objects;

public class LegalEntityClient extends Client {

    private final String name;

    private final int inn;

    public LegalEntityClient(String name, int inn) {
        this.name = name;
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public int getInn() {
        return inn;
    }

    @Override
    public String toString() {
        return "LegalEntityClient{"
                + " name='" + name + '\''
                + ", inn=" + inn
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegalEntityClient that = (LegalEntityClient) o;
        return inn == that.inn && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inn);
    }
}
