package org.example;

public class Lettuce {
    private Price lettuceTypePrice;
    private String lettuceType;

    public Lettuce(String lettuceType) {
        if (lettuceType.toLowerCase().matches("(?:oaky|romaine|arugula)")) {
            this.lettuceType = lettuceType.toLowerCase();
        } else {
            this.lettuceType = "";
        }

        switch (this.lettuceType) {
            case "oaky":
                this.lettuceTypePrice = new Price(1,10);
                break;
            case "romaine":
                this.lettuceTypePrice = new Price(1,20);
                break;
            case "arugula":
                this.lettuceTypePrice = new Price(1,30);
                break;
            default:
                this.lettuceTypePrice = new Price(0,0);
                break;
        }
    }

    public String getLettuceType() {
        return lettuceType;
    }

    public Price getLettuceTypePrice() {
        return lettuceTypePrice;
    }
}
