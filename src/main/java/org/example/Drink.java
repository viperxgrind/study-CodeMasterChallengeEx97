package org.example;

public class Drink {
    private Price drinkTypePrice;
    private String drinkType;

    public Drink(String drinkType) {
        if (drinkType.toLowerCase().matches("(?:cola|coffee|tea|mineral|pepsi|juice|fanta|sprite)")) {
            this.drinkType = drinkType.toLowerCase();
        } else {
            this.drinkType = "";
        }
        switch (this.drinkType) {
            case "cola":
                this.drinkTypePrice = new Price(1, 0);
                break;
            case "coffee":
                this.drinkTypePrice = new Price(2, 0);
                break;
            case "tea":
                this.drinkTypePrice = new Price(1, 50);
                break;
            case "mineral":
                this.drinkTypePrice = new Price(1, 80);
                break;
            case "pepsi":
                this.drinkTypePrice = new Price(1, 10);
                break;
            case "juice":
                this.drinkTypePrice = new Price(3, 0);
                break;
            case "fanta":
                this.drinkTypePrice = new Price(0, 80);
                break;
            case "sprite":
                this.drinkTypePrice = new Price(0, 70);
                break;
            default:
                this.drinkTypePrice = new Price(0, 0);
        }

    }

    public String getDrinkType() {
        return drinkType;
    }

    public Price getDrinkTypePrice() {
        return drinkTypePrice;
    }
}
