package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextStatementTest {

    @Test
    void checkTextStatementGeneration() {

        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie("Interstellar", Movie.REGULAR), 10));

        TextStatement textStatement = new TextStatement("customerABC", rentals);

        assertEquals("Rental Record for customerABC\n" +
                "\tInterstellar\t14.0\n" +
                "Amount owed is 14.0\n" +
                "You earned 1 frequent renter points", textStatement.generate());
    }

}