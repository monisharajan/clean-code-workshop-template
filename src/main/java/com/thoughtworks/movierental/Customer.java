package com.thoughtworks.movierental;

public class Customer {

    private final String name;
    private Rentals rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new Rentals();
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement(name, rentals).generate();
    }

    public String htmlstatement() {
        return new HtmlStatement(name, rentals).generate();
    }

}
