package com.github.fttroy.prettyJson.enums;


public enum Reason {
    MOTIVATIONAL("motivational"),
    FUNNY("funny"),
    LOVE("love");

    private final String value;

    Reason(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
