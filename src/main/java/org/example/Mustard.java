package org.example;

public class Mustard {
    private Price mustardTypePrice;
    private String mustardType;

    public Mustard(String mustardType) {
        if (mustardType.toLowerCase().matches("(?:extrahot|common)")) {
            this.mustardType = mustardType.toLowerCase();
        } else {
            this.mustardType = "";
        }
        switch (this.mustardType) {
            case "extrahot":
                this.mustardTypePrice = new Price(1, 10);
                break;
            case "common":
                this.mustardTypePrice = new Price(1, 0);
                break;
            default:
                this.mustardTypePrice = new Price(0, 0);
                break;
        }
    }

    public String getMustardType() {
        return mustardType;
    }

    public Price getMustardTypePrice() {
        return mustardTypePrice;
    }
}
