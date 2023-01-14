package oop.part3;

public class Main {
    public static void main(String[] args) {
        Bus firstBus = new Bus("SomeBrand", "SomeModel", 2000, "Russia", "Yellow", 80);
        Bus secondBus = new Bus("SomeBrand2", "SomeModel2", 2001, "USA", "Black", 120);
        Bus thirdBus = new Bus("SomeBrand3", "SomeModel3", 2002, "United Kingdom", "Red", 500);
        Car ladaGranta = new Car("   ", "Granta", 2015, "Russia", " ",
                160, 1.7, "Manual", "Sedan", "т202ор", 4,
                true, null);

        System.out.println(ladaGranta);
        System.out.println(firstBus + "\n" + secondBus + "\n" + thirdBus);
    }
}
