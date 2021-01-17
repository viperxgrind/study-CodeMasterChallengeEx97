package org.example;

public class Meat {
    private String meatType;
    private Price meatTypePrice;

    public Meat(String meatType) {
        if (meatType.toLowerCase().matches("(?:beef|pork|chicken|fish)")) {
            this.meatType = meatType.toLowerCase();
        } else {
            this.meatType = "";
        }
        switch (meatType.toLowerCase()) {
            case "beef":
                this.meatTypePrice = new Price(1, 50);
                break;
            case "pork":
                this.meatTypePrice = new Price(1, 60);
                break;
            case "chicken":
                this.meatTypePrice = new Price(1, 70);
                break;
            case "fish":
                this.meatTypePrice = new Price(1, 80);
                break;
            default:
                this.meatTypePrice = new Price(0,0);
        }
    }

    public String getMeatType() {
        return meatType;
    }

    public Price getMeatTypePrice() {
        return meatTypePrice;
    }
}
