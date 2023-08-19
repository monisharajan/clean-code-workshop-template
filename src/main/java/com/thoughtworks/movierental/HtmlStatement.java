package com.thoughtworks.movierental;

import static com.thoughtworks.movierental.Constants.*;

class HtmlStatement {

    private final String customerName;
    private final Rentals rentals;

    public HtmlStatement(String customerName, Rentals rentals) {
        this.customerName = customerName;
        this.rentals = rentals;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h1>" + RENTAL_RECORD_FOR + "<b>" + customerName + "</b>" + "</h1>" + BREAK_STATEMENT;
    }

    private String htmlBody() {
        String result = "";
        for (Rental rental : rentals) {
            result += HTML_TAB_CHAR + rental.getMovie()
                    .getTitle() + HTML_TAB_CHAR +
                    rental.amount() + BREAK_STATEMENT;
        }
        return result;
    }

    private String htmlFooter() {
        String result = "";
        result += AMOUNT_OWED_IS + "<b>" + rentals.getTotalAmount() + "</b>" + BREAK_STATEMENT;
        result += YOU_EARNED + "<b>" + rentals.getFrequentRenterPoints() + "</b>"
                + FREQUENT_RENTER_POINTS;
        return result;
    }
}
