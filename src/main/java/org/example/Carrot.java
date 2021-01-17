package org.example;

public class Carrot {
    private Price carrotTypePrice;
    private String carrotType;

    public Carrot(String carrotType) {
        if (carrotType.toLowerCase().matches("(?:mini|common)")) {
            this.carrotType = carrotType.toLowerCase();
        } else {
            this.carrotType = "";
        }
        switch (this.carrotType) {
            case "mini":
                this.carrotTypePrice = new Price(0, 10);
                break;
            case "common":
                this.carrotTypePrice = new Price(0, 20);
                break;
            default:
                this.carrotTypePrice = new Price(0, 0);
                break;
        }
    }

    public String getCarrotType() {
        return carrotType;
    }

    public Price getCarrotTypePrice() {
        return carrotTypePrice;
    }
}
