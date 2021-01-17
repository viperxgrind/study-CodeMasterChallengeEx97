package org.example;

public class DeluxeBurger extends Hamburger {
    private Drink drinkType;
    private Chips chipsType;

    public DeluxeBurger(String name, Drink drinkType, Chips chipsType) {
        super(name, new Meat("beef"), new BreadRoll("rye_sesame"),
                new Lettuce("romaine"), new Tomato("bullheart"),
                new Carrot("mini"), new Mustard("extrahot"));
        this.drinkType = drinkType;
        this.chipsType = chipsType;
        super.setLettuceQuantity(2);
        super.setTomatoQuantity(2);
        super.setCarrotQuantity(1);
        super.setMustardQuantity(1);
    }

    @Override
    public void setLettuceQuantity(int lettuceQuantity) {
        System.out.println("Deluxe burger is sold as-is. No modifications!");
    }

    @Override
    public void setTomatoQuantity(int tomatoQuantity) {
        System.out.println("Deluxe burger is sold as-is. No modifications!");
    }

    @Override
    public void setCarrotQuantity(int carrotQuantity) {
        System.out.println("Deluxe burger is sold as-is. No modifications!");
    }

    @Override
    public void setMustardQuantity(int mustardQuantity) {
        System.out.println("Deluxe burger is sold as-is. No modifications!");
    }

    @Override
    public Price calculatePrice() {
        Price basePrice = super.calculatePrice();
        Price addonsPrice = new Price(
                this.drinkType.getDrinkTypePrice().getDollars() +
                        this.chipsType.getChipsTypePrice().getDollars() +
                        ((this.drinkType.getDrinkTypePrice().getCents() +
                        this.chipsType.getChipsTypePrice().getCents()) / 100),
                (this.drinkType.getDrinkTypePrice().getCents() +
                        this.chipsType.getChipsTypePrice().getCents()) % 100
        );
        return new Price(
                basePrice.getDollars() +
                        addonsPrice.getDollars() +
                        ((basePrice.getCents() +
                        addonsPrice.getCents()) / 100),
                (basePrice.getCents() +
                        addonsPrice.getCents()) % 100
        );
    }

    @Override
    public void showComponentsInfo() {
        super.showComponentsInfo();
        System.out.println(
                "Drink " +
                        this.drinkType.getDrinkType() + " price: " +
                        this.drinkType.getDrinkTypePrice().getDollars() + " dollars, " +
                        this.drinkType.getDrinkTypePrice().getCents() + " cents." + "\n" +

                        "Chips " +
                        this.chipsType.getChipsType() + " price: " +
                        this.chipsType.getChipsTypePrice().getDollars() + " dollars, " +
                        this.chipsType.getChipsTypePrice().getCents() + " cents." + "\n"
        );
    }
}
