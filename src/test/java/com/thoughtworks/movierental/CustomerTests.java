package com.thoughtworks.movierental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    public void checkStatementGeneration() {

        Customer customerOne = new Customer("Shivashish");
        customerOne.addRental(new Rental(new Movie("Interstellar", Movie.REGULAR), 10));
        customerOne.addRental(new Rental(new Movie("Dil Dhadakne Do", Movie.REGULAR), 1));
        customerOne.addRental(new Rental(new Movie("Oppenheimer", Movie.NEW_RELEASE), 5));
        customerOne.addRental(new Rental(new Movie("Minions", Movie.CHILDRENS), 7));
        customerOne.addRental(new Rental(new Movie("Frozen", Movie.CHILDRENS), 2));

        Assertions.assertEquals("Rental Record for Shivashish\n" +
                "\tInterstellar\t14.0\n" +
                "\tDil Dhadakne Do\t2.0\n" +
                "\tOppenheimer\t15.0\n" +
                "\tMinions\t7.5\n" +
                "\tFrozen\t1.5\n" +
                "Amount owed is 40.0\n" +
                "You earned 6 frequent renter points", customerOne.statement());
    }

    @Test
    public void checkStatementGenerationForHtml() {

        Customer customerOne = new Customer("Shivashish");
        customerOne.addRental(new Rental(new Movie("Interstellar", Movie.REGULAR), 10));
        customerOne.addRental(new Rental(new Movie("Dil Dhadakne Do", Movie.REGULAR), 1));
        customerOne.addRental(new Rental(new Movie("Oppenheimer", Movie.NEW_RELEASE), 5));
        customerOne.addRental(new Rental(new Movie("Minions", Movie.CHILDRENS), 7));
        customerOne.addRental(new Rental(new Movie("Frozen", Movie.CHILDRENS), 2));

        Assertions.assertEquals("<h1>Rental Record for <b>Shivashish</b></h1></br>" +
                "&nbspInterstellar&nbsp14.0</br>" +
                "&nbspDil Dhadakne Do&nbsp2.0</br>" +
                "&nbspOppenheimer&nbsp15.0</br>" +
                "&nbspMinions&nbsp7.5</br>" +
                "&nbspFrozen&nbsp1.5</br>" +
                "Amount owed is <b>40.0</b></br>" +
                "You earned <b>6</b> frequent renter points", customerOne.htmlstatement());
    }

}