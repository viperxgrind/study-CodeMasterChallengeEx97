package org.example;

class Cheese {
    private Price cheeseTypePrice;
    private String cheeseType;

    public Cheese(String cheeseType) {
        if (cheeseType.toLowerCase().matches("(?:chadder|masdam|edam|tilsiter)")) {
            this.cheeseType = cheeseType.toLowerCase();
        } else {
            this.cheeseType = "";
        }
        switch (this.cheeseType) {
            case "chadder":
                this.cheeseTypePrice = new Price(2, 50);
                break;
            case "masdam":
                this.cheeseTypePrice = new Price(2, 90);
                break;
            case "edam":
                this.cheeseTypePrice = new Price(3, 0);
                break;
            case "tilsiter":
                this.cheeseTypePrice = new Price(2, 20);
                break;
            default:
                this.cheeseTypePrice = new Price(0, 0);
                break;
        }
    }

    public String getCheeseType() {
        return cheeseType;
    }

    public Price getCheeseTypePrice() {
        return cheeseTypePrice;
    }
}
