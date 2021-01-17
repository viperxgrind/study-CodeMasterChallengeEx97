package org.example;

public class Main {
    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger(
                "Base burger",
                new Meat("beef"),
                new BreadRoll("white_sesame"),
                new Lettuce("romaine"),
                new Tomato("cherry"),
                new Carrot("common"),
                new Mustard("common")
        );
        hamburger.setLettuceQuantity(2);
        hamburger.setTomatoQuantity(4);
        hamburger.setCarrotQuantity(1);
        hamburger.setMustardQuantity(1);
        Price priceBBWA = hamburger.calculatePrice();

        if (priceBBWA.getDollars() == 0 && priceBBWA.getCents() == 0) {
            System.out.println("You must add meat type and bread roll type to base burger!");
        } else {
            System.out.println(hamburger.getName() + " price: " + priceBBWA.getDollars() + " dollars, " +
                    priceBBWA.getCents() + " cents.");
        }

        hamburger.showComponentsInfo();
        System.out.println();
        System.out.println("-----------------------------------------------");

        HealthyBurger healthyBurger = new HealthyBurger(
                "Healthy burger",
                new Lettuce("romaine"),
                new Tomato("bullheart"),
                new Carrot("mini"),
                new Mustard("none"),
                new Cheese("tilsiter"),
                new Cucumber("cornishon")
        );

        healthyBurger.setCarrotQuantity(2);
        healthyBurger.setLettuceQuantity(4);
        healthyBurger.setMustardQuantity(0);
        healthyBurger.setTomatoQuantity(4);
        healthyBurger.setCheeseQuantity(2);
        healthyBurger.setCucumberQuantity(4);
        Price hbPrice = healthyBurger.calculatePrice();

        System.out.println(healthyBurger.getName() + " price: " + hbPrice.getDollars() + " dollars, " +
                hbPrice.getCents() + " cents.");

        healthyBurger.showComponentsInfo();
        System.out.println();
        System.out.println("-----------------------------------------------");

        DeluxeBurger deluxeBurger = new DeluxeBurger(
                "Deluxe burger with cola",
                new Drink("cola"),
                new Chips("pringles")
        );

        Price dbPrice = deluxeBurger.calculatePrice();

        System.out.println(deluxeBurger.getName() + " price: " + dbPrice.getDollars() + " dollars, " +
                dbPrice.getCents() + " cents.");
        deluxeBurger.showComponentsInfo();
    }
}
