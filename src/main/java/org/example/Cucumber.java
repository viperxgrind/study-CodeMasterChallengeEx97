package org.example;

class Cucumber {
    private Price cucumberTypePrice;
    private String cucumberType;

    public Cucumber(String cucumberType) {
        if (cucumberType.toLowerCase().matches("(?:long|classic|cornishon)")) {
            this.cucumberType = cucumberType.toLowerCase();
        } else {
            this.cucumberType = "";
        }
        switch (this.cucumberType) {
            case "long":
                this.cucumberTypePrice = new Price(0, 20);
                break;
            case "classic":
                this.cucumberTypePrice = new Price(0, 30);
                break;
            case "cornishon":
                this.cucumberTypePrice = new Price(0, 50);
                break;
            default:
                this.cucumberTypePrice = new Price(0, 0);
        }
    }

    public String getCucumberType() {
        return cucumberType;
    }

    public Price getCucumberTypePrice() {
        return cucumberTypePrice;
    }
}
