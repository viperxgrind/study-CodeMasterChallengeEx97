package org.example;

public class Chips {
    private Price chipsTypePrice;
    private String chipsType;

    public Chips(String chipsType) {
        if (chipsType.toLowerCase().matches("(?:pringles|lays|naturals|nachos)")) {
            this.chipsType = chipsType.toLowerCase();
        } else {
            this.chipsType = "";
        }
        switch (this.chipsType) {
            case "pringles":
                this.chipsTypePrice = new Price(1, 0);
                break;
            case "lays":
                this.chipsTypePrice = new Price(0, 80);
                break;
            case "naturals":
                this.chipsTypePrice = new Price(1, 50);
                break;
            case "nachos":
                this.chipsTypePrice = new Price(1, 20);
                break;
            default:
                this.chipsTypePrice = new Price(0, 0);
                break;
        }
    }

    public String getChipsType() {
        return chipsType;
    }

    public Price getChipsTypePrice() {
        return chipsTypePrice;
    }
}
