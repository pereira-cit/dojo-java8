package com.ciandt.ddig.dojo.model;

/**
 * Entidade que representa um Exame
 */
public class Exam {

    private String name;
    private String code;
    private Double price;

    public Exam(final String name, final String code, Double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public Exam() {

    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }
}
