package org.example.parser;

public abstract class JsonDataType {

    protected DataType type;

    protected Object data;

    protected JsonDataType() {
        type = DataType.NONE;
    }

    public void setValue(Object value) {
        data = value;
    }

    public String toString() {
        return data.toString();
    }

    public int toNumber() {
        return (int) data;
    }

    public enum DataType {
        NONE,
        STRING,
        INTEGER,
        OBJECT
    }
}