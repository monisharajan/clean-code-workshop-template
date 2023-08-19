package com.thoughtworks.movierental;

import static com.thoughtworks.movierental.Constants.*;

class TextStatement {

    private final String customerName;
    private Rentals rentals;

    public TextStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return RENTAL_RECORD_FOR + customerName + "\n";
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie()
                    .getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private String footer() {
        String result = "";
        result += AMOUNT_OWED_IS + rentals.getTotalAmount() + "\n";
        result += YOU_EARNED + rentals.getFrequentRenterPoints()
                + FREQUENT_RENTER_POINTS;
        return result;
    }
}
