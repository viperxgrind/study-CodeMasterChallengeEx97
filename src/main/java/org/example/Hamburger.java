package org.example;

public class Hamburger {
    private String name;
    private Meat meatType;
    private BreadRoll breadRoll;
    private Lettuce lettuceType;
    private Tomato tomatoType;
    private Carrot carrotType;
    private Mustard mustardType;
    private Price basePrice;

    private int lettuceQuantity;
    private int tomatoQuantity;
    private int carrotQuantity;
    private int mustardQuantity;

    public void setLettuceQuantity(int lettuceQuantity) {
        if (lettuceQuantity > -1) {
            this.lettuceQuantity = lettuceQuantity;
        } else {
            this.lettuceQuantity = 0;
        }
    }

    public void setTomatoQuantity(int tomatoQuantity) {
        if (tomatoQuantity > -1) {
            this.tomatoQuantity = tomatoQuantity;
        } else {
            this.tomatoQuantity = 0;
        }
    }

    public void setCarrotQuantity(int carrotQuantity) {
        if (carrotQuantity > -1) {
            this.carrotQuantity = carrotQuantity;
        } else {
            this.carrotQuantity = 0;
        }
    }

    public void setMustardQuantity(int mustardQuantity) {
        if (mustardQuantity > -1) {
            this.mustardQuantity = mustardQuantity;
        } else {
            this.mustardQuantity = 0;
        }
    }

    public Hamburger(String name, Meat meatType, BreadRoll breadRoll,
                     Lettuce lettuceType, Tomato tomatoType,
                     Carrot carrotType, Mustard mustardType) {
        this.name = name;
        this.meatType = meatType;
        this.breadRoll = breadRoll;
        this.lettuceType = lettuceType;
        this.tomatoType = tomatoType;
        this.carrotType = carrotType;
        this.mustardType = mustardType;
    }

    public String getName() {
        return name;
    }

    public Price calculatePrice() {
        
        lettuceQuantity = Math.max(this.lettuceQuantity, 0);
        tomatoQuantity = Math.max(this.tomatoQuantity, 0);
        carrotQuantity = Math.max(this.carrotQuantity, 0);
        mustardQuantity = Math.max(this.mustardQuantity, 0);

        if (!this.meatType.getMeatType().isEmpty() && !this.breadRoll.getBreadRollType().isEmpty()) {
            this.basePrice = new Price((
                    this.breadRoll.getBreadRollPrice().getDollars() +
                            this.meatType.getMeatTypePrice().getDollars() +
                            this.lettuceType.getLettuceTypePrice().getDollars() * lettuceQuantity +
                            this.carrotType.getCarrotTypePrice().getDollars() * carrotQuantity +
                            this.tomatoType.getTomatoTypePrice().getDollars() * tomatoQuantity +
                            this.mustardType.getMustardTypePrice().getDollars() * mustardQuantity +
                            ((this.breadRoll.getBreadRollPrice().getCents() +
                                    this.meatType.getMeatTypePrice().getCents() +
                                    this.lettuceType.getLettuceTypePrice().getCents() * lettuceQuantity +
                                    this.tomatoType.getTomatoTypePrice().getCents() * tomatoQuantity +
                                    this.carrotType.getCarrotTypePrice().getCents() * carrotQuantity +
                                    this.mustardType.getMustardTypePrice().getCents() * mustardQuantity
                            ) / 100)),
                    ((this.breadRoll.getBreadRollPrice().getCents() +
                            this.meatType.getMeatTypePrice().getCents() +
                            this.lettuceType.getLettuceTypePrice().getCents() * lettuceQuantity +
                            this.tomatoType.getTomatoTypePrice().getCents() * tomatoQuantity +
                            this.carrotType.getCarrotTypePrice().getCents() * carrotQuantity +
                            this.mustardType.getMustardTypePrice().getCents() * mustardQuantity
                    ) % 100)
            );
        } else {
            this.basePrice = new Price(0, 0);
        }
        return this.basePrice;
    }

    public void showComponentsInfo() {
        String info = "";
        if (!this.breadRoll.getBreadRollType().isEmpty()) {
            info = info.concat("Bread roll " +
                    this.breadRoll.getBreadRollType() + " price: " +
                    this.breadRoll.getBreadRollPrice().getDollars() + " dollars, " +
                    this.breadRoll.getBreadRollPrice().getCents() + " cents." + "\n");
        }
        if (!this.meatType.getMeatType().isEmpty()) {
            info = info.concat("Meat " +
                    this.meatType.getMeatType() + " price: " +
                    this.meatType.getMeatTypePrice().getDollars() + " dollars, " +
                    this.meatType.getMeatTypePrice().getCents() + " cents." + "\n");
        }
        if (!this.lettuceType.getLettuceType().isEmpty()) {
            info = info.concat("Lettuce " +
                    this.lettuceType.getLettuceType() + " price: " +
                    this.lettuceType.getLettuceTypePrice().getDollars() + " dollars, " +
                    this.lettuceType.getLettuceTypePrice().getCents() + " cents, x " +
                    this.lettuceQuantity + " pieces. " +
                    (this.lettuceType.getLettuceTypePrice().getDollars() * this.lettuceQuantity +
                            (this.lettuceType.getLettuceTypePrice().getCents() * this.lettuceQuantity / 100) + " dollars, " +
                            this.lettuceType.getLettuceTypePrice().getCents() * this.lettuceQuantity % 100) + " cents for lettuce " +
                    this.lettuceType.getLettuceType() + "." +
                    "\n");
        }
        if (!this.tomatoType.getTomatoType().isEmpty()) {
            info = info.concat("Tomato " +
                    this.tomatoType.getTomatoType() + " price: " +
                    this.tomatoType.getTomatoTypePrice().getDollars() + " dollars, " +
                    this.tomatoType.getTomatoTypePrice().getCents() + " cents, x " +
                    this.tomatoQuantity + " pieces. " +
                    (this.tomatoType.getTomatoTypePrice().getDollars() * this.tomatoQuantity +
                            (this.tomatoType.getTomatoTypePrice().getCents() * this.tomatoQuantity / 100) + " dollars, " +
                            this.tomatoType.getTomatoTypePrice().getCents() * this.tomatoQuantity % 100) + " cents for tomato " +
                    this.tomatoType.getTomatoType() + "." +
                    "\n");
        }
        if (!this.carrotType.getCarrotType().isEmpty()) {
            info = info.concat("Carrot " +
                    this.carrotType.getCarrotType() + " price: " +
                    this.carrotType.getCarrotTypePrice().getDollars() + " dollars, " +
                    this.carrotType.getCarrotTypePrice().getCents() + " cents, x " +
                    this.carrotQuantity + " pieces. " +
                    (this.carrotType.getCarrotTypePrice().getDollars() * this.carrotQuantity +
                            (this.carrotType.getCarrotTypePrice().getCents() * this.carrotQuantity / 100) + " dollars, " +
                            this.carrotType.getCarrotTypePrice().getCents() * this.carrotQuantity % 100) + " cents for carrot " +
                    this.carrotType.getCarrotType() + "." +
                    "\n");
        }
        if (!this.mustardType.getMustardType().isEmpty()) {
            info = info.concat("Mustard " +
                    this.mustardType.getMustardType() + " price: " +
                    this.mustardType.getMustardTypePrice().getDollars() + " dollars, " +
                    this.mustardType.getMustardTypePrice().getCents() + " cents, x " +
                    this.mustardQuantity + " pieces. " +
                    (this.mustardType.getMustardTypePrice().getDollars() * this.mustardQuantity +
                            (this.mustardType.getMustardTypePrice().getCents() * this.mustardQuantity / 100) + " dollars, " +
                            this.mustardType.getMustardTypePrice().getCents() * this.mustardQuantity % 100) + " cents for mustard " +
                    this.mustardType.getMustardType() + ".");
        }
        System.out.println(
                this.name + " composition: " + "\n" + info
        );
    }
}
