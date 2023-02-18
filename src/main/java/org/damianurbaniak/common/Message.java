package org.damianurbaniak.common;

public enum Message {

    FIRST_PART_SOLUTION ("First part solution: "),

    SECOND_PART_SOLUTION ("Second part solution: ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
