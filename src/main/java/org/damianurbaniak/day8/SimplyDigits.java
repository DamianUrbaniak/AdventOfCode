package org.damianurbaniak.day8;

public enum SimplyDigits {
    ONE(2),
    FOUR(4),
    SEVEN(3),
    EIGHT(7);

    private final Integer message;

    SimplyDigits(Integer message) {
        this.message = message;
    }

    public Integer getMessage() {
        return message;
    }
}
