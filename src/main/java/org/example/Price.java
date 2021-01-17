package org.example;

public class Price {
    private int dollars;
    private int cents;

    public Price(int dollars, int cents) {
        if (dollars > -1 && cents >= 0 && cents < 100) {
            this.dollars = dollars;
            this.cents = cents;
        } else if (dollars > -1 && cents >= 100) {
            this.dollars = dollars + (cents / 100);
            this.cents = cents % 100;
        } else {
            this.dollars = -1;
            this.cents = -1;
        }
    }

    public int getDollars() {
        return Math.max(this.dollars, -1);
    }

    public int getCents() {
        return Math.max(this.cents, -1);
    }
}
