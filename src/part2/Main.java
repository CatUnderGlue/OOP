package part2;

import part2.transport.Car;

public class Main {
    public static void main(String[] args) {
        Car ladaGranta = new Car("   ", "Granta", 2015, "Russia", " ",
                1.7, "Manual", "Sedan", "т202ор", 4,
                true);
        Car audiA8 = new Car("Audi", "A8 50 L TDI quattro", 2020, "Germany", "Black",
                3.0, "Automatic", "Sedan", "р223ав", 4,
                true);
        Car bmwZ8 = new Car("BMW", "Z8", 0, "Germany", "Black", 3.0,
                "Manual", "Sedan", "т202ор", 4, true);
        Car kiaSportage = new Car("Kia", "Sportage 4th generation", 2018, "South Korea",
                "Red", 2.4, "Automatic", "Sedan", "р223ав",
                4, true);
        Car hyundaiAvante = new Car("Hyundai", null, 2016, "South Korea",
                "Orange", 1.6, null, "", "",
                120, true);
        Car.Key ladaGrantaKey = new Car.Key(false, false);
        ladaGranta.setKey(ladaGrantaKey);

        hyundaiAvante.changeTires(7);

        System.out.println(ladaGranta + "\n" + audiA8 + "\n" + bmwZ8 + "\n" + kiaSportage + "\n" + hyundaiAvante);
    }
}
