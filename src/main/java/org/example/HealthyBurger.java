package org.example;

public class HealthyBurger extends Hamburger {
    private Cheese cheeseType;
    private Cucumber cucumberType;

    private int cheeseQuantity;
    private int cucumberQuantity;

    public void setCheeseQuantity(int cheeseQuantity) {
        if (cheeseQuantity > -1) {
            this.cheeseQuantity = cheeseQuantity;
        } else {
            this.cheeseQuantity = 0;
        }
    }

    public void setCucumberQuantity(int cucumberQuantity) {
        if (cucumberQuantity > -1) {
            this.cucumberQuantity = cucumberQuantity;
        } else {
            this.cucumberQuantity = 0;
        }
    }

    public HealthyBurger(String name, Lettuce lettuceType,
                         Tomato tomatoType, Carrot carrotType, Mustard mustardType,
                         Cheese cheeseType, Cucumber cucumberType) {
        super(name, new Meat("chicken"), new BreadRoll("rye"), lettuceType,
                tomatoType, carrotType, mustardType);
        this.cheeseType = cheeseType;
        this.cucumberType = cucumberType;
    }

    @Override
    public Price calculatePrice() {
        Price tempPrice = super.calculatePrice();
        Price addPrice = new Price(
                this.cheeseType.getCheeseTypePrice().getDollars() * cheeseQuantity +
                        this.cucumberType.getCucumberTypePrice().getDollars() * cucumberQuantity +
                        ((this.cheeseType.getCheeseTypePrice().getCents() * cheeseQuantity +
                        this.cucumberType.getCucumberTypePrice().getCents() * cucumberQuantity) / 100),
                (this.cheeseType.getCheeseTypePrice().getCents() * cheeseQuantity +
                        this.cucumberType.getCucumberTypePrice().getCents() * cucumberQuantity) % 100);

        return new Price (
                tempPrice.getDollars() + addPrice.getDollars() +
                        ((tempPrice.getCents() + addPrice.getCents()) / 100),
                (tempPrice.getCents() + addPrice.getCents()) % 100);
    }

    @Override
    public void showComponentsInfo() {
        super.showComponentsInfo();
        String hbInfo = "";
        if (!this.cheeseType.getCheeseType().isEmpty()) {
            hbInfo = hbInfo.concat("Cheese " +
                    this.cheeseType.getCheeseType() + " price: " +
                    this.cheeseType.getCheeseTypePrice().getDollars() + " dollars, " +
                    this.cheeseType.getCheeseTypePrice().getCents() + " cents, x " +
                    this.cheeseQuantity + " pieces. " +
                    (this.cheeseType.getCheeseTypePrice().getDollars() * this.cheeseQuantity +
                            (this.cheeseType.getCheeseTypePrice().getCents() * this.cheeseQuantity / 100) + " dollars, " +
                            this.cheeseType.getCheeseTypePrice().getCents() * this.cheeseQuantity % 100) + " cents for cheese " +
                    this.cheeseType.getCheeseType() + "." +
                    "\n");
        }
        if (!this.cucumberType.getCucumberType().isEmpty()) {
            hbInfo = hbInfo.concat("Cucumber " +
                    this.cucumberType.getCucumberType() + " price: " +
                    this.cucumberType.getCucumberTypePrice().getDollars() + " dollars, " +
                    this.cucumberType.getCucumberTypePrice().getCents() + " cents, x " +
                    this.cucumberQuantity + " pieces. " +
                    (this.cucumberType.getCucumberTypePrice().getDollars() * this.cucumberQuantity +
                            (this.cucumberType.getCucumberTypePrice().getCents() * this.cucumberQuantity / 100) + " dollars, " +
                            this.cucumberType.getCucumberTypePrice().getCents() * this.cucumberQuantity % 100) + " cents for cucumber " +
                    this.cucumberType.getCucumberType() + ".");
        }
        System.out.println(hbInfo
//                "Cheese " +
//                        this.cheeseType.getCheeseType() + " price: " +
//                        this.cheeseType.getCheeseTypePrice().getDollars() + " dollars, " +
//                        this.cheeseType.getCheeseTypePrice().getCents() + " cents, x " +
//                        this.cheeseQuantity + " pieces. " +
//                        (this.cheeseType.getCheeseTypePrice().getDollars() * this.cheeseQuantity +
//                                (this.cheeseType.getCheeseTypePrice().getCents() * this.cheeseQuantity / 100) + " dollars, " +
//                                this.cheeseType.getCheeseTypePrice().getCents() * this.cheeseQuantity % 100) + " cents for cheese " +
//                        this.cheeseType.getCheeseType() + "." +
//                        "\n" +
//
//                        "Cucumber " +
//                        this.cucumberType.getCucumberType() + " price: " +
//                        this.cucumberType.getCucumberTypePrice().getDollars() + " dollars, " +
//                        this.cucumberType.getCucumberTypePrice().getCents() + " cents, x " +
//                        this.cucumberQuantity + " pieces. " +
//                        (this.cucumberType.getCucumberTypePrice().getDollars() * this.cucumberQuantity +
//                                (this.cucumberType.getCucumberTypePrice().getCents() * this.cucumberQuantity / 100) + " dollars, " +
//                                this.cucumberType.getCucumberTypePrice().getCents() * this.cucumberQuantity % 100) + " cents for cucumber " +
//                        this.cucumberType.getCucumberType() + "."
        );
    }
}

