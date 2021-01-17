package org.example;

public class BreadRoll {
    private String breadRollType;
    private Price breadRollPrice;

    public BreadRoll(String breadRollType) {
        if (breadRollType.toLowerCase().matches("(?:white|white_sesame|rye|rye_sesame)")) {
            this.breadRollType = breadRollType.toLowerCase();
        } else {
            this.breadRollType = "";
        }
        switch (breadRollType.toLowerCase()) {
            case "white":
                this.breadRollPrice = new Price(0, 20);
                break;
            case "white_sesame":
                this.breadRollPrice = new Price(0, 30);
                break;
            case "rye":
                this.breadRollPrice = new Price(0, 40);
                break;
            case "rye_sesame":
                this.breadRollPrice = new Price(0, 50);
                break;
            default:
                this.breadRollPrice = new Price(0, 0);
        }
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public Price getBreadRollPrice() {
        return breadRollPrice;
    }
}
