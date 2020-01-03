package com.thymeleafdemo.demo.entity;

public enum Assignment {
    CEO ("Ceo"),
    DEVELOPER ("Developer"),
    ASSISTANT ("Assistant");

    private final String value;

    private Assignment(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public com.thymeleafdemo.demo.entity.Assignment[] getValues() {
        return this.values();
    }

}
