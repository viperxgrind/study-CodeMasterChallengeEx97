package org.example;

public class Tomato {
    private Price tomatoTypePrice;
    private String tomatoType;

    public Tomato(String tomatoType) {
        if (tomatoType.toLowerCase().matches("(?:cherry|bullheart|common)")) {
            this.tomatoType = tomatoType.toLowerCase();
        } else {
            this.tomatoType = "";
        }
        switch (this.tomatoType) {
            case "cherry":
                this.tomatoTypePrice = new Price(0, 10);
                break;
            case "bullheart":
                this.tomatoTypePrice = new Price(0, 20);
                break;
            case "common":
                this.tomatoTypePrice = new Price(0, 30);
                break;
            default:
                this.tomatoTypePrice = new Price(0, 0);
        }
    }

    public String getTomatoType() {
        return tomatoType;
    }

    public Price getTomatoTypePrice() {
        return tomatoTypePrice;
    }
}
